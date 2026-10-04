package opennlp.tools.util.featuregen;

import java.util.List;
import kotlin.collections.AbstractC12991c;
import opennlp.tools.util.StringUtil;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class TokenClassFeatureGenerator implements AdaptiveFeatureGenerator {
    private static final String TOKEN_AND_CLASS_PREFIX = "w&c=";
    private static final String TOKEN_CLASS_PREFIX = "wc=";
    private final boolean generateWordAndClassFeature;

    public TokenClassFeatureGenerator() {
        this(false);
    }

    @Override // opennlp.tools.util.featuregen.AdaptiveFeatureGenerator
    public void createFeatures(List<String> list, String[] strArr, int i, String[] strArr2) {
        String str = FeatureGeneratorUtil.tokenFeature(strArr[i]);
        AbstractC12991c.m13977A(TOKEN_CLASS_PREFIX, str, list);
        if (this.generateWordAndClassFeature) {
            list.add(TOKEN_AND_CLASS_PREFIX + StringUtil.toLowerCase(strArr[i]) + "," + str);
        }
    }

    public TokenClassFeatureGenerator(boolean z) {
        this.generateWordAndClassFeature = z;
    }
}
