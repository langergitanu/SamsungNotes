package opennlp.tools.util.featuregen;

import androidx.appcompat.widget.AbstractC0541b;
import java.util.HashMap;
import java.util.Map;
import opennlp.tools.util.InvalidFormatException;
import opennlp.tools.util.featuregen.GeneratorFactory;
import opennlp.tools.util.featuregen.WordClusterDictionary;
import opennlp.tools.util.model.ArtifactSerializer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class WordClusterFeatureGeneratorFactory extends GeneratorFactory.AbstractXmlFeatureGeneratorFactory {
    @Override // opennlp.tools.util.featuregen.GeneratorFactory.AbstractXmlFeatureGeneratorFactory
    public AdaptiveFeatureGenerator create() throws InvalidFormatException {
        if (this.resourceManager == null) {
            return null;
        }
        String str = getStr("dict");
        boolean bool = getBool("lowerCase");
        Object resource = this.resourceManager.getResource(str);
        if (resource instanceof WordClusterDictionary) {
            return new WordClusterFeatureGenerator((WordClusterDictionary) resource, str, bool);
        }
        throw new InvalidFormatException(AbstractC0541b.m772n("Not a WordClusterDictionary resource for key: ", str));
    }

    @Override // opennlp.tools.util.featuregen.GeneratorFactory.AbstractXmlFeatureGeneratorFactory
    public Map<String, ArtifactSerializer<?>> getArtifactSerializerMapping() {
        HashMap map = new HashMap();
        map.put(getStr("dict"), new WordClusterDictionary.WordClusterDictionarySerializer());
        return map;
    }
}
