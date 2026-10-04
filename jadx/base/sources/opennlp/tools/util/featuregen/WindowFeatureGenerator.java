package opennlp.tools.util.featuregen;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class WindowFeatureGenerator implements AdaptiveFeatureGenerator {
    public static final String NEXT_PREFIX = "n";
    public static final String PREV_PREFIX = "p";
    private final AdaptiveFeatureGenerator generator;
    private final int nextWindowSize;
    private final int prevWindowSize;

    public WindowFeatureGenerator(AdaptiveFeatureGenerator adaptiveFeatureGenerator, int i, int i2) {
        this.generator = adaptiveFeatureGenerator;
        this.prevWindowSize = i;
        this.nextWindowSize = i2;
    }

    @Override // opennlp.tools.util.featuregen.AdaptiveFeatureGenerator
    public void clearAdaptiveData() {
        this.generator.clearAdaptiveData();
    }

    @Override // opennlp.tools.util.featuregen.AdaptiveFeatureGenerator
    public void createFeatures(List<String> list, String[] strArr, int i, String[] strArr2) {
        this.generator.createFeatures(list, strArr, i, strArr2);
        for (int i2 = 1; i2 < this.prevWindowSize + 1; i2++) {
            int i4 = i - i2;
            if (i4 >= 0) {
                ArrayList arrayList = new ArrayList();
                this.generator.createFeatures(arrayList, strArr, i4, strArr2);
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    list.add("p" + i2 + ((String) it.next()));
                }
            }
        }
        for (int i5 = 1; i5 < this.nextWindowSize + 1; i5++) {
            int i6 = i5 + i;
            if (i6 < strArr.length) {
                ArrayList arrayList2 = new ArrayList();
                this.generator.createFeatures(arrayList2, strArr, i6, strArr2);
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    list.add("n" + i5 + ((String) it2.next()));
                }
            }
        }
    }

    public String toString() {
        return super.toString() + ": Prev window size: " + this.prevWindowSize + ", Next window size: " + this.nextWindowSize;
    }

    @Override // opennlp.tools.util.featuregen.AdaptiveFeatureGenerator
    public void updateAdaptiveData(String[] strArr, String[] strArr2) {
        this.generator.updateAdaptiveData(strArr, strArr2);
    }

    public WindowFeatureGenerator(int i, int i2, AdaptiveFeatureGenerator... adaptiveFeatureGeneratorArr) {
        this(new AggregatedFeatureGenerator(adaptiveFeatureGeneratorArr), i, i2);
    }

    public WindowFeatureGenerator(AdaptiveFeatureGenerator adaptiveFeatureGenerator) {
        this(adaptiveFeatureGenerator, 5, 5);
    }

    public WindowFeatureGenerator(AdaptiveFeatureGenerator... adaptiveFeatureGeneratorArr) {
        this(new AggregatedFeatureGenerator(adaptiveFeatureGeneratorArr), 5, 5);
    }
}
