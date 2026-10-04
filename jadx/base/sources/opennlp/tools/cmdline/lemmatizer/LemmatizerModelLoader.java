package opennlp.tools.cmdline.lemmatizer;

import java.io.InputStream;
import opennlp.tools.cmdline.ModelLoader;
import opennlp.tools.commons.Internal;
import opennlp.tools.lemmatizer.LemmatizerModel;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Internal
public class LemmatizerModelLoader extends ModelLoader<LemmatizerModel> {
    public LemmatizerModelLoader() {
        super("Lemmatizer");
    }

    @Override // opennlp.tools.cmdline.ModelLoader
    public LemmatizerModel loadModel(InputStream inputStream) {
        return new LemmatizerModel(inputStream);
    }
}
