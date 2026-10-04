package opennlp.tools.util.featuregen;

import opennlp.tools.util.InvalidFormatException;
import opennlp.tools.util.featuregen.GeneratorFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class CachedFeatureGeneratorFactory extends GeneratorFactory.AbstractXmlFeatureGeneratorFactory {
    @Override // opennlp.tools.util.featuregen.GeneratorFactory.AbstractXmlFeatureGeneratorFactory
    public AdaptiveFeatureGenerator create() throws InvalidFormatException {
        AdaptiveFeatureGenerator adaptiveFeatureGenerator = (AdaptiveFeatureGenerator) this.args.get("generator#0");
        if (adaptiveFeatureGenerator != null) {
            return new CachedFeatureGenerator(adaptiveFeatureGenerator);
        }
        throw new InvalidFormatException("Could not find containing generator element!");
    }
}
