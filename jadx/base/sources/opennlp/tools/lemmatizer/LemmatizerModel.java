package opennlp.tools.lemmatizer;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.OpenOption;
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
public class LemmatizerModel extends BaseModel {
    private static final String COMPONENT_NAME = "StatisticalLemmatizer";
    private static final String LEMMATIZER_MODEL_ENTRY_NAME = "lemmatizer.model";
    private static final long serialVersionUID = -3362902631186156673L;

    public LemmatizerModel(String str, SequenceClassificationModel sequenceClassificationModel, Map<String, String> map, LemmatizerFactory lemmatizerFactory) {
        super(COMPONENT_NAME, str, map, lemmatizerFactory);
        this.artifactMap.put(LEMMATIZER_MODEL_ENTRY_NAME, sequenceClassificationModel);
        checkArtifactMap();
    }

    @Override // opennlp.tools.util.model.BaseModel
    public Class<? extends BaseToolFactory> getDefaultFactory() {
        return LemmatizerFactory.class;
    }

    public LemmatizerFactory getFactory() {
        return (LemmatizerFactory) this.toolFactory;
    }

    public SequenceClassificationModel getLemmatizerSequenceModel() {
        Properties properties = (Properties) this.artifactMap.get("manifest.properties");
        if (this.artifactMap.get(LEMMATIZER_MODEL_ENTRY_NAME) instanceof MaxentModel) {
            String property = properties.getProperty(BeamSearch.BEAM_SIZE_PARAMETER);
            return new BeamSearch(property != null ? Integer.parseInt(property) : 3, (MaxentModel) this.artifactMap.get(LEMMATIZER_MODEL_ENTRY_NAME));
        }
        if (this.artifactMap.get(LEMMATIZER_MODEL_ENTRY_NAME) instanceof SequenceClassificationModel) {
            return (SequenceClassificationModel) this.artifactMap.get(LEMMATIZER_MODEL_ENTRY_NAME);
        }
        return null;
    }

    @Override // opennlp.tools.util.model.BaseModel
    public void validateArtifactMap() throws InvalidFormatException {
        super.validateArtifactMap();
        if (!(this.artifactMap.get(LEMMATIZER_MODEL_ENTRY_NAME) instanceof AbstractModel)) {
            throw new InvalidFormatException("Lemmatizer model is incomplete!");
        }
    }

    public LemmatizerModel(String str, MaxentModel maxentModel, Map<String, String> map, LemmatizerFactory lemmatizerFactory) {
        this(str, maxentModel, 3, map, lemmatizerFactory);
    }

    public LemmatizerModel(String str, MaxentModel maxentModel, int i, Map<String, String> map, LemmatizerFactory lemmatizerFactory) {
        super(COMPONENT_NAME, str, map, lemmatizerFactory);
        this.artifactMap.put(LEMMATIZER_MODEL_ENTRY_NAME, maxentModel);
        ((Properties) this.artifactMap.get("manifest.properties")).put(BeamSearch.BEAM_SIZE_PARAMETER, Integer.toString(i));
        checkArtifactMap();
    }

    public LemmatizerModel(String str, MaxentModel maxentModel, LemmatizerFactory lemmatizerFactory) {
        this(str, maxentModel, (Map<String, String>) null, lemmatizerFactory);
    }

    public LemmatizerModel(InputStream inputStream) {
        super(COMPONENT_NAME, inputStream);
    }

    public LemmatizerModel(File file) {
        super(COMPONENT_NAME, file);
    }

    public LemmatizerModel(Path path) {
        super(COMPONENT_NAME, Files.newInputStream(path, new OpenOption[0]));
    }

    public LemmatizerModel(URL url) {
        super(COMPONENT_NAME, url);
    }
}
