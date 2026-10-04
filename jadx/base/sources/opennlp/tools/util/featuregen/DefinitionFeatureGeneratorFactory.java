package opennlp.tools.util.featuregen;

import opennlp.tools.util.featuregen.GeneratorFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class DefinitionFeatureGeneratorFactory extends GeneratorFactory.AbstractXmlFeatureGeneratorFactory {
    private static final String ELEMENT_NAME = "definition";

    @Override // opennlp.tools.util.featuregen.GeneratorFactory.AbstractXmlFeatureGeneratorFactory
    public AdaptiveFeatureGenerator create() {
        return new OutcomePriorFeatureGenerator();
    }
}
