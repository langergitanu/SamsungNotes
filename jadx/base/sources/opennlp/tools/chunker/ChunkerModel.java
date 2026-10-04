package opennlp.tools.chunker;

import androidx.appcompat.widget.AbstractC0541b;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Path;
import java.util.Map;
import java.util.Properties;
import opennlp.tools.p217ml.BeamSearch;
import opennlp.tools.p217ml.model.AbstractModel;
import opennlp.tools.p217ml.model.MaxentModel;
import opennlp.tools.p217ml.model.SequenceClassificationModel;
import opennlp.tools.util.BaseToolFactory;
import opennlp.tools.util.InvalidFormatException;
import opennlp.tools.util.model.BaseModel;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class ChunkerModel extends BaseModel {
    static final String CHUNKER_MODEL_ENTRY_NAME = "chunker.model";
    private static final String COMPONENT_NAME = "ChunkerME";
    private static final long serialVersionUID = -5450757164882452147L;

    public ChunkerModel(String str, SequenceClassificationModel sequenceClassificationModel, Map<String, String> map, ChunkerFactory chunkerFactory) {
        super(COMPONENT_NAME, str, map, chunkerFactory);
        this.artifactMap.put(CHUNKER_MODEL_ENTRY_NAME, sequenceClassificationModel);
        checkArtifactMap();
    }

    public SequenceClassificationModel getChunkerSequenceModel() {
        Properties properties = (Properties) this.artifactMap.get("manifest.properties");
        if (this.artifactMap.get(CHUNKER_MODEL_ENTRY_NAME) instanceof MaxentModel) {
            String property = properties.getProperty(BeamSearch.BEAM_SIZE_PARAMETER);
            return new BeamSearch(property != null ? Integer.parseInt(property) : 10, (MaxentModel) this.artifactMap.get(CHUNKER_MODEL_ENTRY_NAME));
        }
        if (this.artifactMap.get(CHUNKER_MODEL_ENTRY_NAME) instanceof SequenceClassificationModel) {
            return (SequenceClassificationModel) this.artifactMap.get(CHUNKER_MODEL_ENTRY_NAME);
        }
        return null;
    }

    @Override // opennlp.tools.util.model.BaseModel
    public Class<? extends BaseToolFactory> getDefaultFactory() {
        return ChunkerFactory.class;
    }

    public ChunkerFactory getFactory() {
        return (ChunkerFactory) this.toolFactory;
    }

    @Override // opennlp.tools.util.model.BaseModel
    public void validateArtifactMap() throws InvalidFormatException {
        super.validateArtifactMap();
        if (!(this.artifactMap.get(CHUNKER_MODEL_ENTRY_NAME) instanceof AbstractModel)) {
            throw new InvalidFormatException("Chunker model is incomplete!");
        }
        String manifestProperty = getManifestProperty("factory");
        if (manifestProperty != null && !manifestProperty.equals("opennlp.tools.chunker.ChunkerFactory") && getVersion().getMajor() <= 1 && getVersion().getMinor() < 8) {
            throw new InvalidFormatException(AbstractC0541b.m773o("The Chunker factory '", manifestProperty, "' is no longer compatible. Please update it to match the latest ChunkerFactory."));
        }
    }

    public ChunkerModel(String str, MaxentModel maxentModel, Map<String, String> map, ChunkerFactory chunkerFactory) {
        this(str, maxentModel, 10, map, chunkerFactory);
    }

    public ChunkerModel(String str, MaxentModel maxentModel, int i, Map<String, String> map, ChunkerFactory chunkerFactory) {
        super(COMPONENT_NAME, str, map, chunkerFactory);
        this.artifactMap.put(CHUNKER_MODEL_ENTRY_NAME, maxentModel);
        ((Properties) this.artifactMap.get("manifest.properties")).put(BeamSearch.BEAM_SIZE_PARAMETER, Integer.toString(i));
        checkArtifactMap();
    }

    public ChunkerModel(String str, MaxentModel maxentModel, ChunkerFactory chunkerFactory) {
        this(str, maxentModel, (Map<String, String>) null, chunkerFactory);
    }

    public ChunkerModel(InputStream inputStream) {
        super(COMPONENT_NAME, inputStream);
    }

    public ChunkerModel(File file) {
        super(COMPONENT_NAME, file);
    }

    public ChunkerModel(Path path) {
        this(path.toFile());
    }

    public ChunkerModel(URL url) {
        super(COMPONENT_NAME, url);
    }
}
