package opennlp.tools.util.featuregen;

import androidx.appcompat.widget.AbstractC0541b;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import opennlp.tools.dictionary.Dictionary;
import opennlp.tools.util.InvalidFormatException;
import opennlp.tools.util.featuregen.GeneratorFactory;
import opennlp.tools.util.model.ArtifactSerializer;
import opennlp.tools.util.model.DictionarySerializer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class DictionaryFeatureGeneratorFactory extends GeneratorFactory.AbstractXmlFeatureGeneratorFactory {
    private static final String DICT = "dict";

    @Override // opennlp.tools.util.featuregen.GeneratorFactory.AbstractXmlFeatureGeneratorFactory
    public AdaptiveFeatureGenerator create() throws InvalidFormatException {
        Dictionary dictionaryCreate;
        if (this.resourceManager == null) {
            String str = getStr(DICT);
            try {
                InputStream resourceAsStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(str);
                try {
                    if (resourceAsStream == null) {
                        throw new InvalidFormatException("No dictionary resource at: '" + str);
                    }
                    dictionaryCreate = ((DictionarySerializer) getArtifactSerializerMapping().get(str)).create(resourceAsStream);
                    resourceAsStream.close();
                } finally {
                }
            } catch (IOException e) {
                throw new InvalidFormatException(AbstractC0541b.m772n("Error processing resource at: ", str), e);
            }
        } else {
            String str2 = getStr(DICT);
            Object resource = this.resourceManager.getResource(str2);
            if (!(resource instanceof Dictionary)) {
                throw new InvalidFormatException(AbstractC0541b.m772n("No dictionary resource for key: ", str2));
            }
            dictionaryCreate = (Dictionary) resource;
        }
        return new DictionaryFeatureGenerator(dictionaryCreate);
    }

    @Override // opennlp.tools.util.featuregen.GeneratorFactory.AbstractXmlFeatureGeneratorFactory
    public Map<String, ArtifactSerializer<?>> getArtifactSerializerMapping() {
        HashMap map = new HashMap();
        map.put(getStr(DICT), new DictionarySerializer());
        return map;
    }
}
