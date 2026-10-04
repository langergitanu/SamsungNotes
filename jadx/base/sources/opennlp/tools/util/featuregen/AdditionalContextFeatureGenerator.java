package opennlp.tools.util.featuregen;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class AdditionalContextFeatureGenerator implements AdaptiveFeatureGenerator {
    private static final String PREFIX = "ne=";
    private String[][] additionalContext;

    @Override // opennlp.tools.util.featuregen.AdaptiveFeatureGenerator
    public void createFeatures(List<String> list, String[] strArr, int i, String[] strArr2) {
        String[][] strArr3 = this.additionalContext;
        if (strArr3 == null || strArr3.length == 0) {
            return;
        }
        for (String str : strArr3[i]) {
            list.add(PREFIX + str);
        }
    }

    public void setCurrentContext(String[][] strArr) {
        this.additionalContext = strArr;
    }
}
