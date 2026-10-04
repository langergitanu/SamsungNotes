package opennlp.tools.tokenize;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Path;
import java.util.Map;
import java.util.Objects;
import opennlp.tools.dictionary.Dictionary;
import opennlp.tools.p217ml.model.AbstractModel;
import opennlp.tools.p217ml.model.MaxentModel;
import opennlp.tools.util.BaseToolFactory;
import opennlp.tools.util.InvalidFormatException;
import opennlp.tools.util.model.BaseModel;
import opennlp.tools.util.model.ModelUtil;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class TokenizerModel extends BaseModel {
    private static final String COMPONENT_NAME = "TokenizerME";
    private static final String TOKENIZER_MODEL_ENTRY = "token.model";
    private static final long serialVersionUID = 42334333400920419L;

    public TokenizerModel(MaxentModel maxentModel, Map<String, String> map, TokenizerFactory tokenizerFactory) {
        super(COMPONENT_NAME, tokenizerFactory.getLanguageCode(), map, tokenizerFactory);
        this.artifactMap.put(TOKENIZER_MODEL_ENTRY, maxentModel);
        checkArtifactMap();
    }

    private static boolean isModelCompatible(MaxentModel maxentModel) {
        return ModelUtil.validateOutcomes(maxentModel, "T", TokenizerME.NO_SPLIT);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof TokenizerModel) {
            Map<String, Object> map = ((TokenizerModel) obj).artifactMap;
            AbstractModel abstractModel = (AbstractModel) map.get(TOKENIZER_MODEL_ENTRY);
            if (this.artifactMap.get("manifest.properties").equals(map.get("manifest.properties")) && this.artifactMap.get(TOKENIZER_MODEL_ENTRY).equals(abstractModel)) {
                return true;
            }
        }
        return false;
    }

    public Dictionary getAbbreviations() {
        if (getFactory() != null) {
            return getFactory().getAbbreviationDictionary();
        }
        return null;
    }

    @Override // opennlp.tools.util.model.BaseModel
    public Class<? extends BaseToolFactory> getDefaultFactory() {
        return TokenizerFactory.class;
    }

    public TokenizerFactory getFactory() {
        return (TokenizerFactory) this.toolFactory;
    }

    public MaxentModel getMaxentModel() {
        return (MaxentModel) this.artifactMap.get(TOKENIZER_MODEL_ENTRY);
    }

    public int hashCode() {
        return Objects.hash(this.artifactMap.get("manifest.properties"), this.artifactMap.get(TOKENIZER_MODEL_ENTRY));
    }

    public boolean useAlphaNumericOptimization() {
        return getFactory() != null && getFactory().isUseAlphaNumericOptimization();
    }

    @Override // opennlp.tools.util.model.BaseModel
    public void validateArtifactMap() throws InvalidFormatException {
        super.validateArtifactMap();
        if (!(this.artifactMap.get(TOKENIZER_MODEL_ENTRY) instanceof AbstractModel)) {
            throw new InvalidFormatException("Token model is incomplete!");
        }
        if (!isModelCompatible(getMaxentModel())) {
            throw new InvalidFormatException("The maxent model is not compatible with the tokenizer!");
        }
    }

    public TokenizerModel(InputStream inputStream) {
        super(COMPONENT_NAME, inputStream);
    }

    public TokenizerModel(File file) {
        super(COMPONENT_NAME, file);
    }

    public TokenizerModel(Path path) {
        this(path.toFile());
    }

    public TokenizerModel(URL url) {
        super(COMPONENT_NAME, url);
    }
}
