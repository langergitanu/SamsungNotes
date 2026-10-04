package opennlp.tools.util.featuregen;

import java.util.List;
import java.util.regex.Pattern;
import kotlin.collections.AbstractC12991c;
import opennlp.tools.tokenize.SimpleTokenizer;
import opennlp.tools.tokenize.Tokenizer;
import opennlp.tools.util.StringUtil;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class TokenPatternFeatureGenerator implements AdaptiveFeatureGenerator {
    private static final String SUB_TOKEN_PART2_PREFIX = "pt2=";
    private static final String SUB_TOKEN_PART3_PREFIX = "pt3=";
    private static final String SUB_TOKEN_PREFIX = "st=";
    private final Pattern noLetters;
    private final Tokenizer tokenizer;

    public TokenPatternFeatureGenerator() {
        this(SimpleTokenizer.INSTANCE);
    }

    @Override // opennlp.tools.util.featuregen.AdaptiveFeatureGenerator
    public void createFeatures(List<String> list, String[] strArr, int i, String[] strArr2) {
        String[] strArr3 = this.tokenizer.tokenize(strArr[i]);
        if (strArr3.length == 1) {
            AbstractC12991c.m13977A(SUB_TOKEN_PREFIX, StringUtil.toLowerCase(strArr[i]), list);
            return;
        }
        list.add("stn=" + strArr3.length);
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < strArr3.length; i2++) {
            if (i2 < strArr3.length - 1) {
                list.add(SUB_TOKEN_PART2_PREFIX + FeatureGeneratorUtil.tokenFeature(strArr3[i2]) + FeatureGeneratorUtil.tokenFeature(strArr3[i2 + 1]));
            }
            if (i2 < strArr3.length - 2) {
                list.add(SUB_TOKEN_PART3_PREFIX + FeatureGeneratorUtil.tokenFeature(strArr3[i2]) + FeatureGeneratorUtil.tokenFeature(strArr3[i2 + 1]) + FeatureGeneratorUtil.tokenFeature(strArr3[i2 + 2]));
            }
            sb.append(FeatureGeneratorUtil.tokenFeature(strArr3[i2]));
            if (!this.noLetters.matcher(strArr3[i2]).find()) {
                AbstractC12991c.m13977A(SUB_TOKEN_PREFIX, StringUtil.toLowerCase(strArr3[i2]), list);
            }
        }
        list.add("pta=" + ((Object) sb));
    }

    public TokenPatternFeatureGenerator(Tokenizer tokenizer) {
        this.noLetters = Pattern.compile("[^a-zA-Z]");
        this.tokenizer = tokenizer;
    }
}
