package opennlp.tools.p217ml.model;

import com.opencsv.bean.C6617b;
import com.samsung.android.ocr.C7212a;
import com.samsung.android.support.senl.p148nt.stt.base.audio.C11496b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Stream;
import opennlp.tools.util.InsufficientTrainingDataException;
import opennlp.tools.util.ObjectStream;
import opennlp.tools.util.TrainingParameters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import p074R1.C0233e;
import p092W3.C0332a;
import p184g4.C12014a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public abstract class AbstractDataIndexer implements DataIndexer {
    public static final int CUTOFF_DEFAULT = 5;
    public static final String CUTOFF_PARAM = "Cutoff";
    public static final boolean SORT_DEFAULT = true;
    public static final String SORT_PARAM = "sort";
    private static final Logger logger = LoggerFactory.getLogger((Class<?>) AbstractDataIndexer.class);
    protected int[][] contexts;
    private int numEvents;
    protected int[] numTimesEventsSeen;
    protected String[] outcomeLabels;
    protected int[] outcomeList;
    protected int[] predCounts;
    protected String[] predLabels;
    protected Map<String, String> reportMap;
    protected TrainingParameters trainingParameters;

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String[] lambda$toIndexedStringArray$2(int i) {
        return new String[i];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Integer lambda$update$1(Integer num, Integer num2) {
        return Integer.valueOf(num2.intValue() + num.intValue());
    }

    public static String[] toIndexedStringArray(Map<String, Integer> map) {
        return (String[]) map.entrySet().stream().sorted(Comparator.comparingInt(new C7212a(4))).map(new C6617b(7)).toArray(new C11496b(1));
    }

    public static void update(String[] strArr, Map<String, Integer> map) {
        for (String str : strArr) {
            map.merge(str, 1, new C12014a(6));
        }
    }

    @Override // opennlp.tools.p217ml.model.DataIndexer
    public int[][] getContexts() {
        return this.contexts;
    }

    @Override // opennlp.tools.p217ml.model.DataIndexer
    public int getNumEvents() {
        return this.numEvents;
    }

    @Override // opennlp.tools.p217ml.model.DataIndexer
    public int[] getNumTimesEventsSeen() {
        return this.numTimesEventsSeen;
    }

    @Override // opennlp.tools.p217ml.model.DataIndexer
    public String[] getOutcomeLabels() {
        return this.outcomeLabels;
    }

    @Override // opennlp.tools.p217ml.model.DataIndexer
    public int[] getOutcomeList() {
        return this.outcomeList;
    }

    @Override // opennlp.tools.p217ml.model.DataIndexer
    public int[] getPredCounts() {
        return this.predCounts;
    }

    @Override // opennlp.tools.p217ml.model.DataIndexer
    public String[] getPredLabels() {
        return this.predLabels;
    }

    @Override // opennlp.tools.p217ml.model.DataIndexer
    public float[][] getValues() {
        return null;
    }

    public List<ComparableEvent> index(ObjectStream<Event> objectStream, Map<String, Integer> map) {
        HashMap map2 = new HashMap();
        ArrayList arrayList = new ArrayList();
        while (true) {
            Event event = objectStream.read();
            if (event == null) {
                this.outcomeLabels = toIndexedStringArray(map2);
                this.predLabels = toIndexedStringArray(map);
                return arrayList;
            }
            map2.putIfAbsent(event.getOutcome(), Integer.valueOf(map2.size()));
            Stream stream = Arrays.stream(event.getContext());
            Objects.requireNonNull(map);
            int[] array = stream.map(new C0332a(map, 12)).filter(new C0233e(14)).mapToInt(new C7212a(5)).toArray();
            if (array.length > 0) {
                arrayList.add(new ComparableEvent(((Integer) map2.get(event.getOutcome())).intValue(), array, event.getValues()));
            } else {
                logger.info("Dropped event {}:{}", event.getOutcome(), Arrays.asList(event.getContext()));
            }
        }
    }

    @Override // opennlp.tools.p217ml.model.DataIndexer
    public void init(TrainingParameters trainingParameters, Map<String, String> map) {
        this.reportMap = map;
        if (map == null) {
            new HashMap();
        }
        this.trainingParameters = trainingParameters;
    }

    public int sortAndMerge(List<ComparableEvent> list, boolean z) {
        int size;
        this.numEvents = list.size();
        if (!z || list.size() <= 0) {
            size = list.size();
        } else {
            Collections.sort(list);
            ComparableEvent comparableEvent = list.get(0);
            size = 1;
            for (int i = 1; i < this.numEvents; i++) {
                ComparableEvent comparableEvent2 = list.get(i);
                if (comparableEvent.compareTo(comparableEvent2) == 0) {
                    comparableEvent.seen++;
                    list.set(i, null);
                } else {
                    size++;
                    comparableEvent = comparableEvent2;
                }
            }
        }
        if (size == 0) {
            throw new InsufficientTrainingDataException("Insufficient training data to create model.");
        }
        if (z) {
            logger.info("done. Reduced {} events to {}.", Integer.valueOf(this.numEvents), Integer.valueOf(size));
        }
        this.contexts = new int[size][];
        this.outcomeList = new int[size];
        this.numTimesEventsSeen = new int[size];
        int i2 = 0;
        for (int i4 = 0; i4 < this.numEvents; i4++) {
            ComparableEvent comparableEvent3 = list.get(i4);
            if (comparableEvent3 != null) {
                this.numTimesEventsSeen[i2] = comparableEvent3.seen;
                this.outcomeList[i2] = comparableEvent3.outcome;
                this.contexts[i2] = comparableEvent3.predIndexes;
                i2++;
            }
        }
        return size;
    }
}
