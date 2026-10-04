package opennlp.tools.util;

import androidx.appcompat.widget.AbstractC0541b;
import java.util.HashMap;
import java.util.Map;
import opennlp.tools.util.ext.ExtensionLoader;
import opennlp.tools.util.model.ArtifactProvider;
import opennlp.tools.util.model.ArtifactSerializer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public abstract class BaseToolFactory {
    protected ArtifactProvider artifactProvider;

    public static BaseToolFactory create(String str, ArtifactProvider artifactProvider) throws InvalidFormatException {
        try {
            BaseToolFactory baseToolFactory = (BaseToolFactory) ExtensionLoader.instantiateExtension(BaseToolFactory.class, str);
            if (baseToolFactory == null) {
                return baseToolFactory;
            }
            baseToolFactory.init(artifactProvider);
            return baseToolFactory;
        } catch (Exception e) {
            throw new InvalidFormatException(AbstractC0541b.m773o("Could not instantiate the ", str, ". The initialization threw an exception."), e);
        }
    }

    public Map<String, Object> createArtifactMap() {
        return new HashMap();
    }

    public Map<String, ArtifactSerializer<?>> createArtifactSerializersMap() {
        return new HashMap();
    }

    public Map<String, String> createManifestEntries() {
        return new HashMap();
    }

    public void init(ArtifactProvider artifactProvider) {
        this.artifactProvider = artifactProvider;
    }

    public abstract void validateArtifactMap();

    public static BaseToolFactory create(Class<? extends BaseToolFactory> cls, ArtifactProvider artifactProvider) throws InvalidFormatException {
        if (cls == null) {
            return null;
        }
        try {
            BaseToolFactory baseToolFactoryNewInstance = cls.getDeclaredConstructor(null).newInstance(null);
            baseToolFactoryNewInstance.init(artifactProvider);
            return baseToolFactoryNewInstance;
        } catch (Exception e) {
            throw new InvalidFormatException(AbstractC0541b.m773o("Could not instantiate the ", cls.getCanonicalName(), ". The initialization threw an exception."), e);
        }
    }
}
