package opennlp.tools.postag;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;
import opennlp.tools.p217ml.BeamSearch;
import opennlp.tools.p217ml.model.AbstractModel;
import opennlp.tools.p217ml.model.MaxentModel;
import opennlp.tools.p217ml.model.SequenceClassificationModel;
import opennlp.tools.util.BaseToolFactory;
import opennlp.tools.util.InvalidFormatException;
import opennlp.tools.util.model.ArtifactSerializer;
import opennlp.tools.util.model.BaseModel;
import opennlp.tools.util.model.ByteArraySerializer;
import opennlp.tools.util.model.POSModelSerializer;
import opennlp.tools.util.model.SerializableArtifact;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class POSModel extends BaseModel implements SerializableArtifact {
    private static final String COMPONENT_NAME = "POSTaggerME";
    static final String GENERATOR_DESCRIPTOR_ENTRY_NAME = "generator.featuregen";
    static final String POS_MODEL_ENTRY_NAME = "pos.model";
    private static final long serialVersionUID = -3085487677101643697L;

    public POSModel(String str, SequenceClassificationModel sequenceClassificationModel, Map<String, String> map, POSTaggerFactory pOSTaggerFactory) {
        super(COMPONENT_NAME, str, map, pOSTaggerFactory);
        Map<String, Object> map2 = this.artifactMap;
        Objects.requireNonNull(sequenceClassificationModel, "posModel must not be null");
        map2.put(POS_MODEL_ENTRY_NAME, sequenceClassificationModel);
        this.artifactMap.put(GENERATOR_DESCRIPTOR_ENTRY_NAME, pOSTaggerFactory.getFeatureGenerator());
        this.artifactMap.putAll(pOSTaggerFactory.getResources());
    }

    @Override // opennlp.tools.util.model.BaseModel
    public void createArtifactSerializers(Map<String, ArtifactSerializer<?>> map) {
        super.createArtifactSerializers(map);
        map.put("featuregen", new ByteArraySerializer());
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof POSModel) {
            Map<String, Object> map = ((POSModel) obj).artifactMap;
            AbstractModel abstractModel = (AbstractModel) map.get(POS_MODEL_ENTRY_NAME);
            if (this.artifactMap.get("manifest.properties").equals(map.get("manifest.properties")) && this.artifactMap.get(POS_MODEL_ENTRY_NAME).equals(abstractModel) && Arrays.equals((byte[]) this.artifactMap.get(GENERATOR_DESCRIPTOR_ENTRY_NAME), (byte[]) map.get(GENERATOR_DESCRIPTOR_ENTRY_NAME))) {
                return true;
            }
        }
        return false;
    }

    @Override // opennlp.tools.util.model.SerializableArtifact
    public Class<POSModelSerializer> getArtifactSerializerClass() {
        return POSModelSerializer.class;
    }

    @Override // opennlp.tools.util.model.BaseModel
    public Class<? extends BaseToolFactory> getDefaultFactory() {
        return POSTaggerFactory.class;
    }

    public POSTaggerFactory getFactory() {
        return (POSTaggerFactory) this.toolFactory;
    }

    public SequenceClassificationModel getPosSequenceModel() {
        Properties properties = (Properties) this.artifactMap.get("manifest.properties");
        if (this.artifactMap.get(POS_MODEL_ENTRY_NAME) instanceof MaxentModel) {
            String property = properties.getProperty(BeamSearch.BEAM_SIZE_PARAMETER);
            return new BeamSearch(property != null ? Integer.parseInt(property) : 3, (MaxentModel) this.artifactMap.get(POS_MODEL_ENTRY_NAME));
        }
        if (this.artifactMap.get(POS_MODEL_ENTRY_NAME) instanceof SequenceClassificationModel) {
            return (SequenceClassificationModel) this.artifactMap.get(POS_MODEL_ENTRY_NAME);
        }
        return null;
    }

    public int hashCode() {
        return Objects.hash(this.artifactMap.get("manifest.properties"), this.artifactMap.get(POS_MODEL_ENTRY_NAME), Integer.valueOf(Arrays.hashCode((byte[]) this.artifactMap.get(GENERATOR_DESCRIPTOR_ENTRY_NAME))));
    }

    @Override // opennlp.tools.util.model.BaseModel
    public boolean skipEntryForSerialization(Map.Entry<String, Object> entry) {
        return GENERATOR_DESCRIPTOR_ENTRY_NAME.equals(entry.getKey()) && entry.getValue() == null;
    }

    @Override // opennlp.tools.util.model.BaseModel
    public void validateArtifactMap() throws InvalidFormatException {
        super.validateArtifactMap();
        if (!(this.artifactMap.get(POS_MODEL_ENTRY_NAME) instanceof MaxentModel)) {
            throw new InvalidFormatException("POS model is incomplete!");
        }
    }

    public POSModel(String str, MaxentModel maxentModel, Map<String, String> map, POSTaggerFactory pOSTaggerFactory) {
        this(str, maxentModel, 3, map, pOSTaggerFactory);
    }

    public POSModel(String str, MaxentModel maxentModel, int i, Map<String, String> map, POSTaggerFactory pOSTaggerFactory) {
        super(COMPONENT_NAME, str, map, pOSTaggerFactory);
        Objects.requireNonNull(maxentModel, "posModel must not be null");
        ((Properties) this.artifactMap.get("manifest.properties")).setProperty(BeamSearch.BEAM_SIZE_PARAMETER, Integer.toString(i));
        this.artifactMap.put(POS_MODEL_ENTRY_NAME, maxentModel);
        this.artifactMap.put(GENERATOR_DESCRIPTOR_ENTRY_NAME, pOSTaggerFactory.getFeatureGenerator());
        this.artifactMap.putAll(pOSTaggerFactory.getResources());
        checkArtifactMap();
    }

    public POSModel(InputStream inputStream) {
        super(COMPONENT_NAME, inputStream);
    }

    public POSModel(File file) {
        super(COMPONENT_NAME, file);
    }

    public POSModel(Path path) {
        this(path.toFile());
    }

    public POSModel(URL url) {
        super(COMPONENT_NAME, url);
    }
}
