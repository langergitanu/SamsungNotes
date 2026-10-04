package opennlp.tools.util.model;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;
import java.util.Properties;
import org.apache.commons.text.lookup.StringLookupFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
class PropertiesSerializer implements ArtifactSerializer<Properties> {
    public static void register(Map<String, ArtifactSerializer<?>> map) {
        map.put(StringLookupFactory.KEY_PROPERTIES, new PropertiesSerializer());
    }

    @Override // opennlp.tools.util.model.ArtifactSerializer
    public Properties create(InputStream inputStream) throws IOException {
        Properties properties = new Properties();
        properties.load(inputStream);
        return properties;
    }

    @Override // opennlp.tools.util.model.ArtifactSerializer
    public void serialize(Properties properties, OutputStream outputStream) throws IOException {
        properties.store(outputStream, "");
    }
}
