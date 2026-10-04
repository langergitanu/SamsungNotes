package opennlp.tools.util.featuregen;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class BrownBigramFeatureGenerator implements AdaptiveFeatureGenerator {
    private final BrownCluster brownCluster;

    public BrownBigramFeatureGenerator(BrownCluster brownCluster) {
        this.brownCluster = brownCluster;
    }

    @Override // opennlp.tools.util.featuregen.AdaptiveFeatureGenerator
    public void createFeatures(List<String> list, String[] strArr, int i, String[] strArr2) {
        List<String> wordClasses = BrownTokenClasses.getWordClasses(strArr[i], this.brownCluster);
        if (i > 0) {
            List<String> wordClasses2 = BrownTokenClasses.getWordClasses(strArr[i - 1], this.brownCluster);
            for (int i2 = 0; i2 < wordClasses.size() && i2 < wordClasses2.size(); i2++) {
                list.add("pbrowncluster,browncluster=" + wordClasses2.get(i2) + "," + wordClasses.get(i2));
            }
        }
        int i4 = i + 1;
        if (i4 < strArr.length) {
            List<String> wordClasses3 = BrownTokenClasses.getWordClasses(strArr[i4], this.brownCluster);
            for (int i5 = 0; i5 < wordClasses.size() && i5 < wordClasses3.size(); i5++) {
                list.add("browncluster,nbrowncluster=" + wordClasses.get(i5) + "," + wordClasses3.get(i5));
            }
        }
    }
}
