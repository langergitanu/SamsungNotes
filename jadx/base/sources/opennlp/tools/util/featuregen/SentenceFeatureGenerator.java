package opennlp.tools.util.featuregen;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class SentenceFeatureGenerator implements AdaptiveFeatureGenerator {
    private final boolean isGenerateFirstWordFeature;
    private final boolean isGenerateLastWordFeature;

    public SentenceFeatureGenerator(boolean z, boolean z2) {
        this.isGenerateFirstWordFeature = z;
        this.isGenerateLastWordFeature = z2;
    }

    @Override // opennlp.tools.util.featuregen.AdaptiveFeatureGenerator
    public void createFeatures(List<String> list, String[] strArr, int i, String[] strArr2) {
        if (this.isGenerateFirstWordFeature && i == 0) {
            list.add("S=begin");
        }
        if (this.isGenerateLastWordFeature && strArr.length == i + 1) {
            list.add("S=end");
        }
    }
}
