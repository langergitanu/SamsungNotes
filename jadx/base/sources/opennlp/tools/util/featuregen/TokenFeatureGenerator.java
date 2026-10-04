package opennlp.tools.util.featuregen;

import java.util.List;
import kotlin.collections.AbstractC12991c;
import opennlp.tools.util.StringUtil;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class TokenFeatureGenerator implements AdaptiveFeatureGenerator {
    private static final String WORD_PREFIX = "w=";
    private final boolean lowercase;

    public TokenFeatureGenerator(boolean z) {
        this.lowercase = z;
    }

    @Override // opennlp.tools.util.featuregen.AdaptiveFeatureGenerator
    public void createFeatures(List<String> list, String[] strArr, int i, String[] strArr2) {
        if (this.lowercase) {
            AbstractC12991c.m13977A(WORD_PREFIX, StringUtil.toLowerCase(strArr[i]), list);
        } else {
            AbstractC12991c.m13977A(WORD_PREFIX, strArr[i], list);
        }
    }

    public TokenFeatureGenerator() {
        this(true);
    }
}
