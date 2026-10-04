package opennlp.tools.cmdline.doccat;

import java.io.InputStream;
import opennlp.tools.cmdline.ModelLoader;
import opennlp.tools.commons.Internal;
import opennlp.tools.doccat.DoccatModel;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Internal
public class DoccatModelLoader extends ModelLoader<DoccatModel> {
    public DoccatModelLoader() {
        super("Document Categorizer");
    }

    @Override // opennlp.tools.cmdline.ModelLoader
    public DoccatModel loadModel(InputStream inputStream) {
        return new DoccatModel(inputStream);
    }
}
