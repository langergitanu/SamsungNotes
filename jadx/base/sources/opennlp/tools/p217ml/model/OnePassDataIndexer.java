package opennlp.tools.p217ml.model;

import com.opencsv.bean.C6617b;
import com.samsung.android.support.senl.p148nt.stt.base.audio.C11496b;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import opennlp.tools.util.ObjectStream;
import opennlp.tools.util.ObjectStreamUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import p074R1.C0231c;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class OnePassDataIndexer extends AbstractDataIndexer {
    private static final Logger logger = LoggerFactory.getLogger((Class<?>) OnePassDataIndexer.class);

    private List<Event> computeEventCounts(ObjectStream<Event> objectStream, Map<String, Integer> map, int i) {
        HashMap map2 = new HashMap();
        LinkedList linkedList = new LinkedList();
        while (true) {
            Event event = objectStream.read();
            if (event == null) {
                break;
            }
            linkedList.add(event);
            AbstractDataIndexer.update(event.getContext(), map2);
        }
        String[] strArr = (String[]) map2.entrySet().stream().filter(new C0231c(i, 7)).map(new C6617b(7)).sorted().toArray(new C11496b(2));
        this.predCounts = new int[strArr.length];
        for (int i2 = 0; i2 < strArr.length; i2++) {
            this.predCounts[i2] = ((Integer) map2.get(strArr[i2])).intValue();
            map.put(strArr[i2], Integer.valueOf(i2));
        }
        return linkedList;
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
    public void index(ObjectStream<Event> objectStream) {
        int intParameter = this.trainingParameters.getIntParameter("Cutoff", 5);
        boolean booleanParameter = this.trainingParameters.getBooleanParameter(AbstractDataIndexer.SORT_PARAM, true);
        long jCurrentTimeMillis = System.currentTimeMillis();
        Logger logger2 = logger;
        logger2.info("Indexing events with OnePass using cutoff of {}", Integer.valueOf(intParameter));
        logger2.info("Computing event counts...");
        HashMap map = new HashMap();
        List<Event> listComputeEventCounts = computeEventCounts(objectStream, map, intParameter);
        logger2.info("done. {} events", Integer.valueOf(listComputeEventCounts.size()));
        logger2.info("Indexing...  ");
        List<ComparableEvent> listIndex = index(ObjectStreamUtils.createObjectStream(listComputeEventCounts), map);
        logger2.info("done.");
        logger2.info("Sorting and merging events... ");
        sortAndMerge(listIndex, booleanParameter);
        logger2.info(String.format("Done indexing in %.2f s.", Double.valueOf((System.currentTimeMillis() - jCurrentTimeMillis) / 1000.0d)));
    }
}
