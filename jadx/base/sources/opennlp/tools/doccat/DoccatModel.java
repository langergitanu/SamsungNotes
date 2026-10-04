package opennlp.tools.doccat;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Path;
import java.util.Map;
import opennlp.tools.p217ml.model.AbstractModel;
import opennlp.tools.p217ml.model.MaxentModel;
import opennlp.tools.util.BaseToolFactory;
import opennlp.tools.util.InvalidFormatException;
import opennlp.tools.util.model.BaseModel;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class DoccatModel extends BaseModel {
    private static final String COMPONENT_NAME = "DocumentCategorizerME";
    private static final String DOCCAT_MODEL_ENTRY_NAME = "doccat.model";
    private static final long serialVersionUID = -1348944493118276133L;

    public DoccatModel(String str, MaxentModel maxentModel, Map<String, String> map, DoccatFactory doccatFactory) {
        super(COMPONENT_NAME, str, map, doccatFactory);
        this.artifactMap.put(DOCCAT_MODEL_ENTRY_NAME, maxentModel);
        checkArtifactMap();
    }

    @Override // opennlp.tools.util.model.BaseModel
    public Class<? extends BaseToolFactory> getDefaultFactory() {
        return DoccatFactory.class;
    }

    public DoccatFactory getFactory() {
        return (DoccatFactory) this.toolFactory;
    }

    public MaxentModel getMaxentModel() {
        return (MaxentModel) this.artifactMap.get(DOCCAT_MODEL_ENTRY_NAME);
    }

    @Override // opennlp.tools.util.model.BaseModel
    public void validateArtifactMap() throws InvalidFormatException {
        super.validateArtifactMap();
        if (!(this.artifactMap.get(DOCCAT_MODEL_ENTRY_NAME) instanceof AbstractModel)) {
            throw new InvalidFormatException("Doccat model is incomplete!");
        }
    }

    public DoccatModel(InputStream inputStream) {
        super(COMPONENT_NAME, inputStream);
    }

    public DoccatModel(File file) {
        super(COMPONENT_NAME, file);
    }

    public DoccatModel(Path path) {
        this(path.toFile());
    }

    public DoccatModel(URL url) {
        super(COMPONENT_NAME, url);
    }
}
