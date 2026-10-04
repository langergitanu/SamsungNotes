package opennlp.tools.util.featuregen;

import java.util.List;
import opennlp.tools.util.StringUtil;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class WordClusterFeatureGenerator implements AdaptiveFeatureGenerator {
    private final boolean lowerCaseDictionary;
    private final String resourceName;
    private final WordClusterDictionary tokenDictionary;

    public WordClusterFeatureGenerator(WordClusterDictionary wordClusterDictionary, String str, boolean z) {
        this.tokenDictionary = wordClusterDictionary;
        this.resourceName = str;
        this.lowerCaseDictionary = z;
    }

    @Override // opennlp.tools.util.featuregen.AdaptiveFeatureGenerator
    public void createFeatures(List<String> list, String[] strArr, int i, String[] strArr2) {
        String strLookupToken = this.lowerCaseDictionary ? this.tokenDictionary.lookupToken(StringUtil.toLowerCase(strArr[i])) : this.tokenDictionary.lookupToken(strArr[i]);
        if (strLookupToken != null) {
            list.add(this.resourceName + strLookupToken);
        }
    }
}
