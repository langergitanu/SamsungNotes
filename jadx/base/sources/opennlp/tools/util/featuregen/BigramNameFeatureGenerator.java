package opennlp.tools.util.featuregen;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class BigramNameFeatureGenerator implements AdaptiveFeatureGenerator {
    @Override // opennlp.tools.util.featuregen.AdaptiveFeatureGenerator
    public void createFeatures(List<String> list, String[] strArr, int i, String[] strArr2) {
        String str = FeatureGeneratorUtil.tokenFeature(strArr[i]);
        if (i > 0) {
            int i2 = i - 1;
            list.add("pw,w=" + strArr[i2] + "," + strArr[i]);
            list.add("pwc,wc=" + FeatureGeneratorUtil.tokenFeature(strArr[i2]) + "," + str);
        }
        int i4 = i + 1;
        if (i4 < strArr.length) {
            list.add("w,nw=" + strArr[i] + "," + strArr[i4]);
            list.add("wc,nc=" + str + "," + FeatureGeneratorUtil.tokenFeature(strArr[i4]));
        }
    }
}
