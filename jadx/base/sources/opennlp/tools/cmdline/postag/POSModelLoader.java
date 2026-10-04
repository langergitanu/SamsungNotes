package opennlp.tools.cmdline.postag;

import java.io.InputStream;
import opennlp.tools.cmdline.ModelLoader;
import opennlp.tools.commons.Internal;
import opennlp.tools.postag.POSModel;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Internal
public final class POSModelLoader extends ModelLoader<POSModel> {
    public POSModelLoader() {
        super("POS Tagger");
    }

    @Override // opennlp.tools.cmdline.ModelLoader
    public POSModel loadModel(InputStream inputStream) {
        return new POSModel(inputStream);
    }
}
