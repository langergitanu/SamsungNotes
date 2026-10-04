package opennlp.tools.util.featuregen;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class PreviousTwoMapFeatureGenerator implements AdaptiveFeatureGenerator {
    private final Map<String, String> previousMap = new HashMap();

    @Override // opennlp.tools.util.featuregen.AdaptiveFeatureGenerator
    public void clearAdaptiveData() {
        this.previousMap.clear();
    }

    @Override // opennlp.tools.util.featuregen.AdaptiveFeatureGenerator
    public void createFeatures(List<String> list, String[] strArr, int i, String[] strArr2) {
        if (i > 0) {
            list.add("ppd=" + this.previousMap.get(strArr[i]) + "," + this.previousMap.get(strArr[i - 1]));
        }
    }

    @Override // opennlp.tools.util.featuregen.AdaptiveFeatureGenerator
    public void updateAdaptiveData(String[] strArr, String[] strArr2) {
        for (int i = 0; i < strArr.length; i++) {
            this.previousMap.put(strArr[i], strArr2[i]);
        }
    }
}
