package opennlp.tools.formats.frenchtreebank;

import java.io.FileFilter;
import opennlp.tools.cmdline.ArgumentParser;
import opennlp.tools.cmdline.StreamFactoryRegistry;
import opennlp.tools.cmdline.params.BasicFormatParams;
import opennlp.tools.commons.Internal;
import opennlp.tools.formats.AbstractSampleStreamFactory;
import opennlp.tools.formats.DirectorySampleStream;
import opennlp.tools.formats.convert.FileToByteArraySampleStream;
import opennlp.tools.parser.Parse;
import opennlp.tools.util.ObjectStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Internal
public class ConstitParseSampleStreamFactory extends AbstractSampleStreamFactory<Parse, Parameters> {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Parameters extends BasicFormatParams {
    }

    private ConstitParseSampleStreamFactory() {
        super(Parameters.class);
    }

    public static void registerFactory() {
        StreamFactoryRegistry.registerFactory(Parse.class, "frenchtreebank", new ConstitParseSampleStreamFactory());
    }

    @Override // opennlp.tools.cmdline.ObjectStreamFactory
    public ObjectStream<Parse> create(String[] strArr) {
        return new ConstitParseSampleStream(new FileToByteArraySampleStream(new DirectorySampleStream(((Parameters) ArgumentParser.parse(strArr, Parameters.class)).getData(), (FileFilter) null, false)));
    }
}
