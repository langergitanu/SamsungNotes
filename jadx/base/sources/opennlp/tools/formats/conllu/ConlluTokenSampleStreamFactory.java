package opennlp.tools.formats.conllu;

import java.io.IOException;
import opennlp.tools.cmdline.ArgumentParser;
import opennlp.tools.cmdline.CmdLineUtil;
import opennlp.tools.cmdline.StreamFactoryRegistry;
import opennlp.tools.cmdline.params.BasicFormatParams;
import opennlp.tools.commons.Internal;
import opennlp.tools.formats.AbstractSampleStreamFactory;
import opennlp.tools.tokenize.TokenSample;
import opennlp.tools.util.ObjectStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Internal
public class ConlluTokenSampleStreamFactory<P> extends AbstractSampleStreamFactory<TokenSample, P> {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Parameters extends BasicFormatParams {
    }

    public ConlluTokenSampleStreamFactory(Class<P> cls) {
        super(cls);
    }

    public static void registerFactory() {
        StreamFactoryRegistry.registerFactory(TokenSample.class, ConlluPOSSampleStreamFactory.CONLLU_FORMAT, new ConlluTokenSampleStreamFactory(Parameters.class));
    }

    @Override // opennlp.tools.cmdline.ObjectStreamFactory
    public ObjectStream<TokenSample> create(String[] strArr) {
        try {
            return new ConlluTokenSampleStream(new ConlluStream(CmdLineUtil.createInputStreamFactory(((Parameters) ArgumentParser.parse(strArr, Parameters.class)).getData())));
        } catch (IOException e) {
            CmdLineUtil.handleCreateObjectStreamError(e);
            return null;
        }
    }
}
