package opennlp.tools.util.featuregen;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class PosTaggerFeatureGenerator implements AdaptiveFeatureGenerator {

    /* JADX INFO: renamed from: SB */
    private static final String f9701SB = "S=begin";

    @Override // opennlp.tools.util.featuregen.AdaptiveFeatureGenerator
    public void createFeatures(List<String> list, String[] strArr, int i, String[] strArr2) {
        String str;
        String str2;
        int i2 = i - 1;
        String str3 = f9701SB;
        String str4 = null;
        if (i2 >= 0) {
            String str5 = strArr[i2];
            str2 = strArr2[i2];
            int i4 = i - 2;
            if (i4 >= 0) {
                str3 = strArr[i4];
                str4 = strArr2[i4];
            }
            str = str4;
            str4 = str3;
            str3 = str5;
        } else {
            str = null;
            str2 = null;
        }
        if (str3 != null) {
            if (str2 != null) {
                list.add("t=".concat(str2));
            }
            if (str4 == null || str == null) {
                return;
            }
            list.add("t2=" + str + "," + str2);
        }
    }
}
