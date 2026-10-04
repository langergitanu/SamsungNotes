package opennlp.tools.util.featuregen;

import java.util.ArrayList;
import java.util.Map;
import opennlp.tools.util.featuregen.GeneratorFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class AggregatedFeatureGeneratorFactory extends GeneratorFactory.AbstractXmlFeatureGeneratorFactory {
    @Override // opennlp.tools.util.featuregen.GeneratorFactory.AbstractXmlFeatureGeneratorFactory
    public AdaptiveFeatureGenerator create() {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, Object> entry : this.args.entrySet()) {
            if (entry.getKey().startsWith("generator#")) {
                arrayList.add((AdaptiveFeatureGenerator) entry.getValue());
            }
        }
        return new AggregatedFeatureGenerator((AdaptiveFeatureGenerator[]) arrayList.toArray(new AdaptiveFeatureGenerator[0]));
    }
}
