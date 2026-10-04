package opennlp.tools.util.featuregen;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.AbstractC12991c;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class PreviousMapFeatureGenerator implements AdaptiveFeatureGenerator {
    private final Map<String, String> previousMap = new HashMap();

    @Override // opennlp.tools.util.featuregen.AdaptiveFeatureGenerator
    public void clearAdaptiveData() {
        this.previousMap.clear();
    }

    @Override // opennlp.tools.util.featuregen.AdaptiveFeatureGenerator
    public void createFeatures(List<String> list, String[] strArr, int i, String[] strArr2) {
        AbstractC12991c.m13977A("pd=", this.previousMap.get(strArr[i]), list);
    }

    @Override // opennlp.tools.util.featuregen.AdaptiveFeatureGenerator
    public void updateAdaptiveData(String[] strArr, String[] strArr2) {
        for (int i = 0; i < strArr.length; i++) {
            this.previousMap.put(strArr[i], strArr2[i]);
        }
    }
}
