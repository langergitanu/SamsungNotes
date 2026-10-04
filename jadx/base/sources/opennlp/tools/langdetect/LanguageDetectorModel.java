package opennlp.tools.langdetect;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.Map;
import opennlp.tools.p217ml.model.AbstractModel;
import opennlp.tools.p217ml.model.MaxentModel;
import opennlp.tools.util.BaseToolFactory;
import opennlp.tools.util.InvalidFormatException;
import opennlp.tools.util.model.BaseModel;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class LanguageDetectorModel extends BaseModel {
    private static final String COMPONENT_NAME = "LanguageDetectorME";
    private static final String LANGDETECT_MODEL_ENTRY_NAME = "langdetect.model";
    private static final long serialVersionUID = -8894047401677394181L;

    public LanguageDetectorModel(MaxentModel maxentModel, Map<String, String> map, LanguageDetectorFactory languageDetectorFactory) {
        super(COMPONENT_NAME, "und", map, languageDetectorFactory);
        this.artifactMap.put(LANGDETECT_MODEL_ENTRY_NAME, maxentModel);
        checkArtifactMap();
    }

    @Override // opennlp.tools.util.model.BaseModel
    public Class<? extends BaseToolFactory> getDefaultFactory() {
        return LanguageDetectorFactory.class;
    }

    public LanguageDetectorFactory getFactory() {
        return (LanguageDetectorFactory) this.toolFactory;
    }

    public MaxentModel getMaxentModel() {
        return (MaxentModel) this.artifactMap.get(LANGDETECT_MODEL_ENTRY_NAME);
    }

    @Override // opennlp.tools.util.model.BaseModel
    public void validateArtifactMap() throws InvalidFormatException {
        super.validateArtifactMap();
        if (!(this.artifactMap.get(LANGDETECT_MODEL_ENTRY_NAME) instanceof AbstractModel)) {
            throw new InvalidFormatException("Language detector model is incomplete!");
        }
    }

    public LanguageDetectorModel(InputStream inputStream) {
        super(COMPONENT_NAME, inputStream);
    }

    public LanguageDetectorModel(File file) {
        super(COMPONENT_NAME, file);
    }

    public LanguageDetectorModel(URL url) {
        super(COMPONENT_NAME, url);
    }
}
