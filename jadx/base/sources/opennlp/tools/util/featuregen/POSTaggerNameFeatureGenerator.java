package opennlp.tools.util.featuregen;

import java.util.Arrays;
import java.util.List;
import kotlin.collections.AbstractC12991c;
import opennlp.tools.postag.POSModel;
import opennlp.tools.postag.POSTagFormatMapper;
import opennlp.tools.postag.POSTagger;
import opennlp.tools.postag.POSTaggerME;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class POSTaggerNameFeatureGenerator implements AdaptiveFeatureGenerator {
    private String[] cachedTags;
    private String[] cachedTokens;
    private final POSTagger posTagger;

    public POSTaggerNameFeatureGenerator(POSTagger pOSTagger) {
        this.posTagger = pOSTagger;
    }

    @Override // opennlp.tools.util.featuregen.AdaptiveFeatureGenerator
    public void createFeatures(List<String> list, String[] strArr, int i, String[] strArr2) {
        if (!Arrays.equals(this.cachedTokens, strArr)) {
            this.cachedTokens = strArr;
            this.cachedTags = this.posTagger.tag(strArr);
        }
        AbstractC12991c.m13977A("pos=", this.cachedTags[i], list);
    }

    public POSTaggerNameFeatureGenerator(POSModel pOSModel) {
        this.posTagger = new POSTaggerME(pOSModel, POSTagFormatMapper.guessFormat(pOSModel));
    }
}
