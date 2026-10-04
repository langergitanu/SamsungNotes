package opennlp.tools.chunker;

import java.util.ArrayList;
import opennlp.tools.util.FilterObjectStream;
import opennlp.tools.util.ObjectStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class ChunkSampleStream extends FilterObjectStream<String, ChunkSample> {
    private static final Logger logger = LoggerFactory.getLogger((Class<?>) ChunkSampleStream.class);

    public ChunkSampleStream(ObjectStream<String> objectStream) {
        super(objectStream);
    }

    @Override // opennlp.tools.util.ObjectStream
    public ChunkSample read() {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        while (true) {
            String str = (String) this.samples.read();
            if (str == null || str.isEmpty()) {
                break;
            }
            String[] strArrSplit = str.split(" ");
            if (strArrSplit.length != 3) {
                logger.error("Skipping corrupt line: {}", str);
            } else {
                arrayList.add(strArrSplit[0]);
                arrayList2.add(strArrSplit[1]);
                arrayList3.add(strArrSplit[2]);
            }
        }
        if (arrayList.size() > 0) {
            return new ChunkSample((String[]) arrayList.toArray(new String[0]), (String[]) arrayList2.toArray(new String[0]), (String[]) arrayList3.toArray(new String[0]));
        }
        return null;
    }
}
