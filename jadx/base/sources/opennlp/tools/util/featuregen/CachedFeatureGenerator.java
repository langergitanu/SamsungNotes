package opennlp.tools.util.featuregen;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import opennlp.tools.util.Cache;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class CachedFeatureGenerator implements AdaptiveFeatureGenerator {
    private final Cache<Integer, List<String>> contextsCache = new Cache<>(100);
    private final AdaptiveFeatureGenerator generator;
    private long numberOfCacheHits;
    private long numberOfCacheMisses;
    private String[] prevTokens;

    @Deprecated
    public CachedFeatureGenerator(AdaptiveFeatureGenerator... adaptiveFeatureGeneratorArr) {
        this.generator = new AggregatedFeatureGenerator(adaptiveFeatureGeneratorArr);
    }

    @Override // opennlp.tools.util.featuregen.AdaptiveFeatureGenerator
    public void clearAdaptiveData() {
        this.generator.clearAdaptiveData();
    }

    @Override // opennlp.tools.util.featuregen.AdaptiveFeatureGenerator
    public void createFeatures(List<String> list, String[] strArr, int i, String[] strArr2) {
        if (strArr == this.prevTokens) {
            Collection<? extends String> collection = (List) this.contextsCache.get(Integer.valueOf(i));
            if (collection != null) {
                this.numberOfCacheHits++;
                list.addAll(collection);
                return;
            }
        } else {
            this.contextsCache.clear();
            this.prevTokens = strArr;
        }
        ArrayList arrayList = new ArrayList();
        this.numberOfCacheMisses++;
        this.generator.createFeatures(arrayList, strArr, i, strArr2);
        this.contextsCache.put(Integer.valueOf(i), arrayList);
        list.addAll(arrayList);
    }

    public AdaptiveFeatureGenerator getCachedFeatureGenerator() {
        return this.generator;
    }

    public long getNumberOfCacheHits() {
        return this.numberOfCacheHits;
    }

    public long getNumberOfCacheMisses() {
        return this.numberOfCacheMisses;
    }

    public String toString() {
        String string = super.toString();
        long j = this.numberOfCacheHits;
        return string + ": hits=" + j + " misses=" + this.numberOfCacheMisses + " hit%" + (j > 0 ? j / (r3 + j) : 0.0d);
    }

    @Override // opennlp.tools.util.featuregen.AdaptiveFeatureGenerator
    public void updateAdaptiveData(String[] strArr, String[] strArr2) {
        this.generator.updateAdaptiveData(strArr, strArr2);
    }

    public CachedFeatureGenerator(AdaptiveFeatureGenerator adaptiveFeatureGenerator) {
        this.generator = adaptiveFeatureGenerator;
    }
}
