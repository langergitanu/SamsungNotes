package opennlp.tools.formats.p216ad;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import opennlp.tools.cmdline.ArgumentParser;
import opennlp.tools.cmdline.CmdLineUtil;
import opennlp.tools.cmdline.StreamFactoryRegistry;
import opennlp.tools.commons.Internal;
import opennlp.tools.formats.LanguageSampleStreamFactory;
import opennlp.tools.postag.POSSample;
import opennlp.tools.util.ObjectStream;
import opennlp.tools.util.PlainTextByLineStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Internal
public class ADPOSSampleStreamFactory<P> extends LanguageSampleStreamFactory<POSSample, P> {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Parameters {
        @ArgumentParser.ParameterDescription(description = "data to be used, usually a file name.", valueName = "sampleData")
        File getData();

        @ArgumentParser.ParameterDescription(description = "encoding for reading and writing text, if absent the system default is used.", valueName = "charsetName")
        Charset getEncoding();

        @ArgumentParser.OptionalParameter(defaultValue = "false")
        @ArgumentParser.ParameterDescription(description = "expand multiword expressions.", valueName = "expandME")
        Boolean getExpandME();

        @ArgumentParser.OptionalParameter(defaultValue = "false")
        @ArgumentParser.ParameterDescription(description = "combine POS Tags with word features, like number and gender.", valueName = "includeFeatures")
        Boolean getIncludeFeatures();

        @ArgumentParser.ParameterDescription(description = "language which is being processed.", valueName = "language")
        String getLang();
    }

    public ADPOSSampleStreamFactory(Class<P> cls) {
        super(cls);
    }

    public static void registerFactory() {
        StreamFactoryRegistry.registerFactory(POSSample.class, "ad", new ADPOSSampleStreamFactory(Parameters.class));
    }

    @Override // opennlp.tools.cmdline.ObjectStreamFactory
    public ObjectStream<POSSample> create(String[] strArr) {
        PlainTextByLineStream plainTextByLineStream;
        Parameters parameters = (Parameters) ArgumentParser.parse(strArr, Parameters.class);
        this.language = parameters.getLang();
        try {
            plainTextByLineStream = new PlainTextByLineStream(CmdLineUtil.createInputStreamFactory(parameters.getData()), parameters.getEncoding());
        } catch (IOException e) {
            CmdLineUtil.handleCreateObjectStreamError(e);
            plainTextByLineStream = null;
        }
        return new ADPOSSampleStream(plainTextByLineStream, parameters.getExpandME().booleanValue(), parameters.getIncludeFeatures().booleanValue());
    }
}
