package opennlp.tools.util.featuregen;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class AggregatedFeatureGenerator implements AdaptiveFeatureGenerator {
    private Collection<AdaptiveFeatureGenerator> generators;

    public AggregatedFeatureGenerator(AdaptiveFeatureGenerator... adaptiveFeatureGeneratorArr) {
        for (AdaptiveFeatureGenerator adaptiveFeatureGenerator : adaptiveFeatureGeneratorArr) {
            Objects.requireNonNull(adaptiveFeatureGenerator, "null values in generators are not permitted");
        }
        ArrayList arrayList = new ArrayList(adaptiveFeatureGeneratorArr.length);
        this.generators = arrayList;
        Collections.addAll(arrayList, adaptiveFeatureGeneratorArr);
        this.generators = Collections.unmodifiableCollection(this.generators);
    }

    @Override // opennlp.tools.util.featuregen.AdaptiveFeatureGenerator
    public void clearAdaptiveData() {
        Iterator<AdaptiveFeatureGenerator> it = this.generators.iterator();
        while (it.hasNext()) {
            it.next().clearAdaptiveData();
        }
    }

    @Override // opennlp.tools.util.featuregen.AdaptiveFeatureGenerator
    public void createFeatures(List<String> list, String[] strArr, int i, String[] strArr2) {
        Iterator<AdaptiveFeatureGenerator> it = this.generators.iterator();
        while (it.hasNext()) {
            it.next().createFeatures(list, strArr, i, strArr2);
        }
    }

    public Collection<AdaptiveFeatureGenerator> getGenerators() {
        return this.generators;
    }

    @Override // opennlp.tools.util.featuregen.AdaptiveFeatureGenerator
    public void updateAdaptiveData(String[] strArr, String[] strArr2) {
        Iterator<AdaptiveFeatureGenerator> it = this.generators.iterator();
        while (it.hasNext()) {
            it.next().updateAdaptiveData(strArr, strArr2);
        }
    }

    public AggregatedFeatureGenerator(Collection<AdaptiveFeatureGenerator> collection) {
        this((AdaptiveFeatureGenerator[]) collection.toArray(new AdaptiveFeatureGenerator[0]));
    }
}
