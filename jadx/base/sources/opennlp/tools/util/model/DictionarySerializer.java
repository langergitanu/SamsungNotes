package opennlp.tools.util.model;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;
import opennlp.tools.dictionary.Dictionary;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class DictionarySerializer implements ArtifactSerializer<Dictionary> {
    public static void register(Map<String, ArtifactSerializer<?>> map) {
        map.put("dictionary", new DictionarySerializer());
    }

    @Override // opennlp.tools.util.model.ArtifactSerializer
    public Dictionary create(InputStream inputStream) {
        return new Dictionary(inputStream);
    }

    @Override // opennlp.tools.util.model.ArtifactSerializer
    public void serialize(Dictionary dictionary, OutputStream outputStream) {
        dictionary.serialize(outputStream);
    }
}
