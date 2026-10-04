package opennlp.tools.formats.irishsentencebank;

import java.io.IOException;
import opennlp.tools.cmdline.ArgumentParser;
import opennlp.tools.cmdline.CmdLineUtil;
import opennlp.tools.cmdline.StreamFactoryRegistry;
import opennlp.tools.cmdline.params.BasicFormatParams;
import opennlp.tools.formats.DetokenizerSampleStreamFactory;
import opennlp.tools.tokenize.TokenSample;
import opennlp.tools.util.ObjectStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class IrishSentenceBankTokenSampleStreamFactory<P> extends DetokenizerSampleStreamFactory<TokenSample, P> {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Parameters extends BasicFormatParams {
    }

    public IrishSentenceBankTokenSampleStreamFactory(Class<P> cls) {
        super(cls);
    }

    public static void registerFactory() {
        StreamFactoryRegistry.registerFactory(TokenSample.class, "irishsentencebank", new IrishSentenceBankTokenSampleStreamFactory(Parameters.class));
    }

    @Override // opennlp.tools.cmdline.ObjectStreamFactory
    public ObjectStream<TokenSample> create(String[] strArr) {
        IrishSentenceBankDocument irishSentenceBankDocument;
        Parameters parameters = (Parameters) ArgumentParser.parse(strArr, Parameters.class);
        CmdLineUtil.checkInputFile("Data", parameters.getData());
        try {
            irishSentenceBankDocument = IrishSentenceBankDocument.parse(parameters.getData());
        } catch (IOException e) {
            CmdLineUtil.handleCreateObjectStreamError(e);
            irishSentenceBankDocument = null;
        }
        return new IrishSentenceBankTokenSampleStream(irishSentenceBankDocument);
    }
}
