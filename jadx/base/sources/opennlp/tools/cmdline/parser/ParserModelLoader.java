package opennlp.tools.cmdline.parser;

import java.io.InputStream;
import opennlp.tools.cmdline.ModelLoader;
import opennlp.tools.commons.Internal;
import opennlp.tools.parser.ParserModel;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Internal
public final class ParserModelLoader extends ModelLoader<ParserModel> {
    public ParserModelLoader() {
        super("Parser");
    }

    @Override // opennlp.tools.cmdline.ModelLoader
    public ParserModel loadModel(InputStream inputStream) {
        return new ParserModel(inputStream);
    }
}
