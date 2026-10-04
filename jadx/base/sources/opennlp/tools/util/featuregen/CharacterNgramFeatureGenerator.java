package opennlp.tools.util.featuregen;

import java.util.List;
import kotlin.collections.AbstractC12991c;
import opennlp.tools.ngram.NGramModel;
import opennlp.tools.util.StringList;
import opennlp.tools.util.StringUtil;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class CharacterNgramFeatureGenerator implements AdaptiveFeatureGenerator {
    private static final String PREFIX = "ng=";
    private final int maxLength;
    private final int minLength;

    public CharacterNgramFeatureGenerator(int i, int i2) {
        this.minLength = i;
        this.maxLength = i2;
    }

    @Override // opennlp.tools.util.featuregen.AdaptiveFeatureGenerator
    public void createFeatures(List<String> list, String[] strArr, int i, String[] strArr2) {
        NGramModel nGramModel = new NGramModel();
        nGramModel.add(strArr[i], this.minLength, this.maxLength);
        for (StringList stringList : nGramModel) {
            if (stringList.size() > 0) {
                AbstractC12991c.m13977A(PREFIX, StringUtil.toLowerCase(stringList.getToken(0)), list);
            }
        }
    }

    public CharacterNgramFeatureGenerator() {
        this(2, 5);
    }
}
