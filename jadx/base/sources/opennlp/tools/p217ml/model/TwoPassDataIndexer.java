package opennlp.tools.p217ml.model;

import com.opencsv.bean.C6617b;
import com.samsung.android.sdk.mobileservice.profile.Privacy;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.AbstractC9718n;
import com.samsung.android.support.senl.p148nt.stt.base.audio.C11496b;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.FileAttribute;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.CheckedInputStream;
import java.util.zip.CheckedOutputStream;
import opennlp.tools.util.ObjectStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import p074R1.C0231c;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class TwoPassDataIndexer extends AbstractDataIndexer {
    private static final Logger logger = LoggerFactory.getLogger((Class<?>) TwoPassDataIndexer.class);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class EventStream implements ObjectStream<Event> {
        private final DataInputStream inputStream;

        public EventStream(DataInputStream dataInputStream) {
            this.inputStream = dataInputStream;
        }

        @Override // opennlp.tools.util.ObjectStream, java.lang.AutoCloseable
        public void close() throws IOException {
            this.inputStream.close();
        }

        @Override // opennlp.tools.util.ObjectStream
        public void reset() {
            throw new UnsupportedOperationException();
        }

        @Override // opennlp.tools.util.ObjectStream
        public Event read() throws IOException {
            float[] fArr = null;
            if (this.inputStream.available() == 0) {
                return null;
            }
            String utf = this.inputStream.readUTF();
            int i = this.inputStream.readInt();
            String[] strArr = new String[i];
            for (int i2 = 0; i2 < i; i2++) {
                strArr[i2] = this.inputStream.readUTF();
            }
            int i4 = this.inputStream.readInt();
            if (i4 > 0) {
                fArr = new float[i4];
                for (int i5 = 0; i5 < i4; i5++) {
                    fArr[i5] = this.inputStream.readFloat();
                }
            }
            return new Event(utf, strArr, fArr);
        }
    }

    private int computeEventCounts(ObjectStream<Event> objectStream, DataOutputStream dataOutputStream, Map<String, Integer> map, int i) throws IOException {
        HashMap map2 = new HashMap();
        int i2 = 0;
        while (true) {
            Event event = objectStream.read();
            if (event == null) {
                break;
            }
            i2++;
            dataOutputStream.writeUTF(event.getOutcome());
            dataOutputStream.writeInt(event.getContext().length);
            String[] context = event.getContext();
            AbstractDataIndexer.update(context, map2);
            for (String str : context) {
                dataOutputStream.writeUTF(str);
            }
            if (event.getValues() == null) {
                dataOutputStream.writeInt(0);
            } else {
                dataOutputStream.writeInt(event.getValues().length);
                for (float f : event.getValues()) {
                    dataOutputStream.writeFloat(f);
                }
            }
        }
        String[] strArr = (String[]) map2.entrySet().stream().filter(new C0231c(i, 8)).map(new C6617b(7)).sorted().toArray(new C11496b(3));
        this.predCounts = new int[strArr.length];
        for (int i4 = 0; i4 < strArr.length; i4++) {
            this.predCounts[i4] = ((Integer) map2.get(strArr[i4])).intValue();
            map.put(strArr[i4], Integer.valueOf(i4));
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$computeEventCounts$0(int i, Map.Entry entry) {
        return ((Integer) entry.getValue()).intValue() >= i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String[] lambda$computeEventCounts$1(int i) {
        return new String[i];
    }

    @Override // opennlp.tools.p217ml.model.DataIndexer
    public void index(ObjectStream<Event> objectStream) throws IOException {
        int intParameter = this.trainingParameters.getIntParameter("Cutoff", 5);
        boolean booleanParameter = this.trainingParameters.getBooleanParameter(AbstractDataIndexer.SORT_PARAM, true);
        Logger logger2 = logger;
        logger2.info("Indexing events with TwoPass using cutoff of {}", Integer.valueOf(intParameter));
        logger2.info("Computing event counts...");
        long jCurrentTimeMillis = System.currentTimeMillis();
        HashMap map = new HashMap();
        File file = Files.createTempFile(Privacy.KEY_EVENTS, null, new FileAttribute[0]).toFile();
        file.deleteOnExit();
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
        try {
            AbstractC9718n.m10144l();
            CheckedOutputStream checkedOutputStream = new CheckedOutputStream(bufferedOutputStream, AbstractC9718n.m10137e());
            try {
                DataOutputStream dataOutputStream = new DataOutputStream(checkedOutputStream);
                try {
                    int iComputeEventCounts = computeEventCounts(objectStream, dataOutputStream, map, intParameter);
                    long value = checkedOutputStream.getChecksum().getValue();
                    logger2.info("done. {} events", Integer.valueOf(iComputeEventCounts));
                    dataOutputStream.close();
                    checkedOutputStream.close();
                    bufferedOutputStream.close();
                    BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                    try {
                        AbstractC9718n.m10144l();
                        CheckedInputStream checkedInputStream = new CheckedInputStream(bufferedInputStream, AbstractC9718n.m10137e());
                        try {
                            EventStream eventStream = new EventStream(new DataInputStream(checkedInputStream));
                            try {
                                logger2.info("Indexing...");
                                List<ComparableEvent> listIndex = index(eventStream, map);
                                long value2 = checkedInputStream.getChecksum().getValue();
                                eventStream.close();
                                checkedInputStream.close();
                                bufferedInputStream.close();
                                file.delete();
                                if (value2 != value) {
                                    throw new IOException("Checksum for writing and reading events did not match.");
                                }
                                logger2.info("done.");
                                if (booleanParameter) {
                                    logger2.info("Sorting and merging events... ");
                                } else {
                                    logger2.info("Collecting events... ");
                                }
                                sortAndMerge(listIndex, booleanParameter);
                                logger2.info(String.format("Done indexing in %.2f s.", Double.valueOf((System.currentTimeMillis() - jCurrentTimeMillis) / 1000.0d)));
                            } finally {
                            }
                        } finally {
                        }
                    } catch (Throwable th) {
                        try {
                            bufferedInputStream.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                    }
                } finally {
                }
            } finally {
            }
        } catch (Throwable th3) {
            try {
                bufferedOutputStream.close();
            } catch (Throwable th4) {
                th3.addSuppressed(th4);
            }
            throw th3;
        }
    }
}
