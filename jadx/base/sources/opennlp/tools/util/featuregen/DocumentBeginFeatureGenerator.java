package opennlp.tools.util.featuregen;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class DocumentBeginFeatureGenerator implements AdaptiveFeatureGenerator {
    private String[] firstSentence;

    @Override // opennlp.tools.util.featuregen.AdaptiveFeatureGenerator
    public void clearAdaptiveData() {
        this.firstSentence = null;
    }

    @Override // opennlp.tools.util.featuregen.AdaptiveFeatureGenerator
    public void createFeatures(List<String> list, String[] strArr, int i, String[] strArr2) {
        if (this.firstSentence == null) {
            this.firstSentence = strArr;
        }
        if (this.firstSentence == strArr && i == 0) {
            list.add("D=begin");
        }
    }
}
