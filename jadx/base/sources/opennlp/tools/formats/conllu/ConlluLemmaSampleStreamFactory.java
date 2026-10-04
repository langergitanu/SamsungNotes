package opennlp.tools.formats.conllu;

import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.support.senl.ntnl.coedit.constants.CoeditServiceConstants;
import java.io.IOException;
import opennlp.tools.cmdline.ArgumentParser;
import opennlp.tools.cmdline.CmdLineUtil;
import opennlp.tools.cmdline.StreamFactoryRegistry;
import opennlp.tools.cmdline.TerminateToolException;
import opennlp.tools.cmdline.params.BasicFormatParams;
import opennlp.tools.commons.Internal;
import opennlp.tools.formats.AbstractSampleStreamFactory;
import opennlp.tools.lemmatizer.LemmaSample;
import opennlp.tools.util.ObjectStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Internal
public class ConlluLemmaSampleStreamFactory<P> extends AbstractSampleStreamFactory<LemmaSample, P> {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Parameters extends BasicFormatParams {
        @ArgumentParser.OptionalParameter(defaultValue = CoeditServiceConstants.CacheFilePath.UPDATE_CACHE)
        @ArgumentParser.ParameterDescription(description = "u|x u for unified tags and x for language-specific part-of-speech tags", valueName = "tagset")
        String getTagset();
    }

    public ConlluLemmaSampleStreamFactory(Class<P> cls) {
        super(cls);
    }

    public static void registerFactory() {
        StreamFactoryRegistry.registerFactory(LemmaSample.class, ConlluPOSSampleStreamFactory.CONLLU_FORMAT, new ConlluLemmaSampleStreamFactory(Parameters.class));
    }

    @Override // opennlp.tools.cmdline.ObjectStreamFactory
    public ObjectStream<LemmaSample> create(String[] strArr) {
        ConlluTagset conlluTagset;
        Parameters parameters = (Parameters) ArgumentParser.parse(strArr, Parameters.class);
        String tagset = parameters.getTagset();
        tagset.getClass();
        if (tagset.equals(CoeditServiceConstants.CacheFilePath.UPDATE_CACHE)) {
            conlluTagset = ConlluTagset.U;
        } else {
            if (!tagset.equals("x")) {
                throw new TerminateToolException(-1, AbstractC0541b.m772n("Unknown tagset parameter: ", parameters.getTagset()));
            }
            conlluTagset = ConlluTagset.X;
        }
        try {
            return new ConlluLemmaSampleStream(new ConlluStream(CmdLineUtil.createInputStreamFactory(parameters.getData())), conlluTagset);
        } catch (IOException e) {
            CmdLineUtil.handleCreateObjectStreamError(e);
            return null;
        }
    }
}
