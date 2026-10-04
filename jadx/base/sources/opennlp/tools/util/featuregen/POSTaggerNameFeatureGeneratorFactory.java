package opennlp.tools.util.featuregen;

import java.util.HashMap;
import java.util.Map;
import opennlp.tools.postag.POSModel;
import opennlp.tools.util.InvalidFormatException;
import opennlp.tools.util.featuregen.GeneratorFactory;
import opennlp.tools.util.model.ArtifactSerializer;
import opennlp.tools.util.model.POSModelSerializer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class POSTaggerNameFeatureGeneratorFactory extends GeneratorFactory.AbstractXmlFeatureGeneratorFactory {
    @Override // opennlp.tools.util.featuregen.GeneratorFactory.AbstractXmlFeatureGeneratorFactory
    public AdaptiveFeatureGenerator create() throws InvalidFormatException {
        if (this.resourceManager == null) {
            return null;
        }
        return new POSTaggerNameFeatureGenerator((POSModel) this.resourceManager.getResource(getStr("model")));
    }

    @Override // opennlp.tools.util.featuregen.GeneratorFactory.AbstractXmlFeatureGeneratorFactory
    public Map<String, ArtifactSerializer<?>> getArtifactSerializerMapping() {
        HashMap map = new HashMap();
        map.put(getStr("model"), new POSModelSerializer());
        return map;
    }
}
