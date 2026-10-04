package opennlp.tools.postag;

import java.util.ArrayList;
import java.util.Objects;
import opennlp.tools.util.Cache;
import opennlp.tools.util.featuregen.AdaptiveFeatureGenerator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class ConfigurablePOSContextGenerator implements POSContextGenerator {
    private Cache<String, String[]> contextsCache;
    private final AdaptiveFeatureGenerator featureGenerator;
    private Object wordsKey;

    public ConfigurablePOSContextGenerator(AdaptiveFeatureGenerator adaptiveFeatureGenerator) {
        this(0, adaptiveFeatureGenerator);
    }

    public ConfigurablePOSContextGenerator(int i, AdaptiveFeatureGenerator adaptiveFeatureGenerator) {
        Objects.requireNonNull(adaptiveFeatureGenerator, "featureGenerator must not be null");
        this.featureGenerator = adaptiveFeatureGenerator;
        if (i > 0) {
            this.contextsCache = new Cache<>(i);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // opennlp.tools.postag.POSContextGenerator, opennlp.tools.util.BeamSearchContextGenerator
    public String[] getContext(int i, String[] strArr, String[] strArr2, Object[] objArr) {
        String str;
        int i2 = i - 1;
        if (i2 >= 0) {
            int i4 = i - 2;
            str = strArr2[i2];
            str = i4 >= 0 ? strArr2[i4] : null;
        } else {
            str = null;
        }
        String str2 = i + str + str;
        Cache<String, String[]> cache = this.contextsCache;
        if (cache != null) {
            if (this.wordsKey == strArr) {
                String[] strArr3 = cache.get(str2);
                if (strArr3 != null) {
                    return strArr3;
                }
            } else {
                cache.clear();
                this.wordsKey = strArr;
            }
        }
        ArrayList arrayList = new ArrayList();
        this.featureGenerator.createFeatures(arrayList, strArr, i, strArr2);
        String[] strArr4 = (String[]) arrayList.toArray(new String[0]);
        Cache<String, String[]> cache2 = this.contextsCache;
        if (cache2 != null) {
            cache2.put(str2, strArr4);
        }
        return strArr4;
    }
}
