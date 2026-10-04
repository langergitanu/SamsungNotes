package opennlp.tools.doccat;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import opennlp.tools.util.featuregen.StringPattern;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class BagOfWordsFeatureGenerator implements FeatureGenerator {
    private final boolean useOnlyAllLetterTokens;

    public BagOfWordsFeatureGenerator() {
        this(false);
    }

    @Override // opennlp.tools.doccat.FeatureGenerator
    public Collection<String> extractFeatures(String[] strArr, Map<String, Object> map) {
        Objects.requireNonNull(strArr, "text must not be null");
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            if (!this.useOnlyAllLetterTokens) {
                arrayList.add("bow=" + str);
            } else if (StringPattern.recognize(str).isAllLetter()) {
                arrayList.add("bow=" + str);
            }
        }
        return arrayList;
    }

    public BagOfWordsFeatureGenerator(boolean z) {
        this.useOnlyAllLetterTokens = z;
    }
}
