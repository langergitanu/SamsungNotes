package opennlp.tools.cmdline.tokenizer;

import java.io.InputStream;
import opennlp.tools.cmdline.ModelLoader;
import opennlp.tools.tokenize.DetokenizationDictionary;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
final class DetokenizationDictionaryLoader extends ModelLoader<DetokenizationDictionary> {
    public DetokenizationDictionaryLoader() {
        super("detokenizer dictionary");
    }

    @Override // opennlp.tools.cmdline.ModelLoader
    public DetokenizationDictionary loadModel(InputStream inputStream) {
        return new DetokenizationDictionary(inputStream);
    }
}
