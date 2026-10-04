package opennlp.tools.util.featuregen;

import java.util.Iterator;
import java.util.List;
import kotlin.collections.AbstractC12991c;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class BrownTokenFeatureGenerator implements AdaptiveFeatureGenerator {
    private final BrownCluster brownLexicon;

    public BrownTokenFeatureGenerator(BrownCluster brownCluster) {
        this.brownLexicon = brownCluster;
    }

    @Override // opennlp.tools.util.featuregen.AdaptiveFeatureGenerator
    public void createFeatures(List<String> list, String[] strArr, int i, String[] strArr2) {
        Iterator<String> it = BrownTokenClasses.getWordClasses(strArr[i], this.brownLexicon).iterator();
        while (it.hasNext()) {
            AbstractC12991c.m13977A("browncluster=", it.next(), list);
        }
    }
}
