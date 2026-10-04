package opennlp.tools.util.featuregen;

import java.util.List;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class TrigramNameFeatureGenerator implements AdaptiveFeatureGenerator {
    @Override // opennlp.tools.util.featuregen.AdaptiveFeatureGenerator
    public void createFeatures(List<String> list, String[] strArr, int i, String[] strArr2) {
        String str = FeatureGeneratorUtil.tokenFeature(strArr[i]);
        if (i > 1) {
            int i2 = i - 2;
            String str2 = strArr[i2];
            int i4 = i - 1;
            String str3 = strArr[i4];
            String str4 = strArr[i];
            StringBuilder sbM16m = AbstractC0000a.m16m("ppw,pw,w=", str2, ",", str3, ",");
            sbM16m.append(str4);
            list.add(sbM16m.toString());
            StringBuilder sbM16m2 = AbstractC0000a.m16m("ppwc,pwc,wc=", FeatureGeneratorUtil.tokenFeature(strArr[i2]), ",", FeatureGeneratorUtil.tokenFeature(strArr[i4]), ",");
            sbM16m2.append(str);
            list.add(sbM16m2.toString());
        }
        int i5 = i + 2;
        if (i5 < strArr.length) {
            String str5 = strArr[i];
            int i6 = i + 1;
            String str6 = strArr[i6];
            String str7 = strArr[i5];
            StringBuilder sbM16m3 = AbstractC0000a.m16m("w,nw,nnw=", str5, ",", str6, ",");
            sbM16m3.append(str7);
            list.add(sbM16m3.toString());
            String str8 = FeatureGeneratorUtil.tokenFeature(strArr[i6]);
            String str9 = FeatureGeneratorUtil.tokenFeature(strArr[i5]);
            StringBuilder sbM16m4 = AbstractC0000a.m16m("wc,nwc,nnwc=", str, ",", str8, ",");
            sbM16m4.append(str9);
            list.add(sbM16m4.toString());
        }
    }
}
