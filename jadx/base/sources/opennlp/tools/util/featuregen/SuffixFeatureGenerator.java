package opennlp.tools.util.featuregen;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class SuffixFeatureGenerator implements AdaptiveFeatureGenerator {
    static final int DEFAULT_MAX_LENGTH = 4;
    private static final String PREFIX = "suf=";
    private final int suffixLength;

    public SuffixFeatureGenerator() {
        this.suffixLength = 4;
    }

    private String[] getSuffixes(String str) {
        int iMin = StrictMath.min(this.suffixLength, str.length());
        String[] strArr = new String[iMin];
        for (int i = 0; i < iMin; i++) {
            strArr[i] = str.substring(StrictMath.max((str.length() - i) - 1, 0));
        }
        return strArr;
    }

    @Override // opennlp.tools.util.featuregen.AdaptiveFeatureGenerator
    public void createFeatures(List<String> list, String[] strArr, int i, String[] strArr2) {
        for (String str : getSuffixes(strArr[i])) {
            list.add(PREFIX + str);
        }
    }

    public SuffixFeatureGenerator(int i) {
        this.suffixLength = i;
    }
}
