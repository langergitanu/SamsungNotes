package opennlp.tools.util.featuregen;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class PrefixFeatureGenerator implements AdaptiveFeatureGenerator {
    static final int DEFAULT_MAX_LENGTH = 4;
    private static final String PREFIX = "pre=";
    private final int prefixLength;

    public PrefixFeatureGenerator() {
        this.prefixLength = 4;
    }

    private String[] getPrefixes(String str) {
        int iMin = StrictMath.min(this.prefixLength, str.length());
        String[] strArr = new String[iMin];
        int i = 0;
        while (i < iMin) {
            int i2 = i + 1;
            strArr[i] = str.substring(0, StrictMath.min(i2, str.length()));
            i = i2;
        }
        return strArr;
    }

    @Override // opennlp.tools.util.featuregen.AdaptiveFeatureGenerator
    public void createFeatures(List<String> list, String[] strArr, int i, String[] strArr2) {
        for (String str : getPrefixes(strArr[i])) {
            list.add(PREFIX + str);
        }
    }

    public PrefixFeatureGenerator(int i) {
        this.prefixLength = i;
    }
}
