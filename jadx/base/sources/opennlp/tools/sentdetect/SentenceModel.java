package opennlp.tools.sentdetect;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Path;
import java.util.Map;
import opennlp.tools.dictionary.Dictionary;
import opennlp.tools.p217ml.model.MaxentModel;
import opennlp.tools.util.BaseToolFactory;
import opennlp.tools.util.InvalidFormatException;
import opennlp.tools.util.model.BaseModel;
import opennlp.tools.util.model.ModelUtil;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class SentenceModel extends BaseModel {
    private static final String COMPONENT_NAME = "SentenceDetectorME";
    private static final String MAXENT_MODEL_ENTRY_NAME = "sent.model";
    private static final long serialVersionUID = -8374532795287293730L;

    public SentenceModel(String str, MaxentModel maxentModel, Map<String, String> map, SentenceDetectorFactory sentenceDetectorFactory) {
        super(COMPONENT_NAME, str, map, sentenceDetectorFactory);
        this.artifactMap.put(MAXENT_MODEL_ENTRY_NAME, maxentModel);
        checkArtifactMap();
    }

    public Dictionary getAbbreviations() {
        if (getFactory() != null) {
            return getFactory().getAbbreviationDictionary();
        }
        return null;
    }

    @Override // opennlp.tools.util.model.BaseModel
    public Class<? extends BaseToolFactory> getDefaultFactory() {
        return SentenceDetectorFactory.class;
    }

    public char[] getEosCharacters() {
        if (getFactory() != null) {
            return getFactory().getEOSCharacters();
        }
        return null;
    }

    public SentenceDetectorFactory getFactory() {
        return (SentenceDetectorFactory) this.toolFactory;
    }

    public MaxentModel getMaxentModel() {
        return (MaxentModel) this.artifactMap.get(MAXENT_MODEL_ENTRY_NAME);
    }

    public boolean useTokenEnd() {
        return getFactory() == null || getFactory().isUseTokenEnd();
    }

    @Override // opennlp.tools.util.model.BaseModel
    public void validateArtifactMap() throws InvalidFormatException {
        super.validateArtifactMap();
        if (!(this.artifactMap.get(MAXENT_MODEL_ENTRY_NAME) instanceof MaxentModel)) {
            throw new InvalidFormatException("Unable to find sent.model maxent model!");
        }
        if (!ModelUtil.validateOutcomes(getMaxentModel(), "s", "n")) {
            throw new InvalidFormatException("The maxent model is not compatible with the sentence detector!");
        }
    }

    public SentenceModel(InputStream inputStream) {
        super(COMPONENT_NAME, inputStream);
    }

    public SentenceModel(File file) {
        super(COMPONENT_NAME, file);
    }

    public SentenceModel(Path path) {
        this(path.toFile());
    }

    public SentenceModel(URL url) {
        super(COMPONENT_NAME, url);
    }
}
