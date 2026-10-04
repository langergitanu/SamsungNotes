package opennlp.tools.formats;

import java.io.IOException;
import opennlp.tools.cmdline.ArgumentParser;
import opennlp.tools.cmdline.CmdLineUtil;
import opennlp.tools.cmdline.StreamFactoryRegistry;
import opennlp.tools.cmdline.params.BasicFormatParams;
import opennlp.tools.commons.Internal;
import opennlp.tools.postag.POSSample;
import opennlp.tools.postag.WordTagSampleStream;
import opennlp.tools.util.ObjectStream;
import opennlp.tools.util.PlainTextByLineStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Internal
public class WordTagSampleStreamFactory<P> extends AbstractSampleStreamFactory<POSSample, P> {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Parameters extends BasicFormatParams {
    }

    public WordTagSampleStreamFactory(Class<P> cls) {
        super(cls);
    }

    public static void registerFactory() {
        StreamFactoryRegistry.registerFactory(POSSample.class, "opennlp", new WordTagSampleStreamFactory(Parameters.class));
    }

    @Override // opennlp.tools.cmdline.ObjectStreamFactory
    public ObjectStream<POSSample> create(String[] strArr) {
        PlainTextByLineStream plainTextByLineStream;
        Parameters parameters = (Parameters) ArgumentParser.parse(strArr, Parameters.class);
        CmdLineUtil.checkInputFile("Data", parameters.getData());
        try {
            plainTextByLineStream = new PlainTextByLineStream(CmdLineUtil.createInputStreamFactory(parameters.getData()), parameters.getEncoding());
        } catch (IOException e) {
            CmdLineUtil.handleCreateObjectStreamError(e);
            plainTextByLineStream = null;
        }
        return new WordTagSampleStream(plainTextByLineStream);
    }
}
