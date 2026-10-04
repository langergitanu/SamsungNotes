package opennlp.tools.formats;

import androidx.appcompat.widget.AbstractC0541b;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import opennlp.tools.cmdline.ArgumentParser;
import opennlp.tools.cmdline.CmdLineUtil;
import opennlp.tools.cmdline.StreamFactoryRegistry;
import opennlp.tools.cmdline.TerminateToolException;
import opennlp.tools.cmdline.params.BasicFormatParams;
import opennlp.tools.commons.Internal;
import opennlp.tools.postag.POSSample;
import opennlp.tools.util.ObjectStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Internal
public class ConllXPOSSampleStreamFactory<P> extends AbstractSampleStreamFactory<POSSample, P> {
    public static final String CONLLX_FORMAT = "conllx";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Parameters extends BasicFormatParams {
    }

    public ConllXPOSSampleStreamFactory(Class<P> cls) {
        super(cls);
    }

    public static void registerFactory() {
        StreamFactoryRegistry.registerFactory(POSSample.class, CONLLX_FORMAT, new ConllXPOSSampleStreamFactory(Parameters.class));
    }

    @Override // opennlp.tools.cmdline.ObjectStreamFactory
    public ObjectStream<POSSample> create(String[] strArr) {
        try {
            return new ConllXPOSSampleStream(CmdLineUtil.createInputStreamFactory(((Parameters) ArgumentParser.parse(strArr, Parameters.class)).getData()), StandardCharsets.UTF_8);
        } catch (UnsupportedEncodingException e) {
            throw new TerminateToolException(-1, AbstractC0541b.m772n("UTF-8 encoding is not supported: ", e.getMessage()), e);
        } catch (IOException e2) {
            CmdLineUtil.handleCreateObjectStreamError(e2);
            return null;
        }
    }
}
