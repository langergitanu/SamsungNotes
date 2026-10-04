package opennlp.tools.doccat;

import java.util.LinkedList;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
class DocumentCategorizerContextGenerator {
    private final FeatureGenerator[] mFeatureGenerators;

    public DocumentCategorizerContextGenerator(FeatureGenerator... featureGeneratorArr) {
        this.mFeatureGenerators = featureGeneratorArr;
    }

    public String[] getContext(String[] strArr, Map<String, Object> map) {
        LinkedList linkedList = new LinkedList();
        for (FeatureGenerator featureGenerator : this.mFeatureGenerators) {
            linkedList.addAll(featureGenerator.extractFeatures(strArr, map));
        }
        return (String[]) linkedList.toArray(new String[0]);
    }
}
