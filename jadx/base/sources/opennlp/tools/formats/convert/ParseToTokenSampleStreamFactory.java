package opennlp.tools.formats.convert;

import opennlp.tools.cmdline.ArgumentParser;
import opennlp.tools.cmdline.StreamFactoryRegistry;
import opennlp.tools.cmdline.params.DetokenizerParameter;
import opennlp.tools.commons.Internal;
import opennlp.tools.formats.DetokenizerSampleStreamFactory;
import opennlp.tools.formats.ParseSampleStreamFactory;
import opennlp.tools.formats.WordTagSampleStreamFactory;
import opennlp.tools.parser.Parse;
import opennlp.tools.tokenize.TokenSample;
import opennlp.tools.util.ObjectStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Internal
public class ParseToTokenSampleStreamFactory extends DetokenizerSampleStreamFactory<TokenSample, Parameters> {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Parameters extends ParseSampleStreamFactory.Parameters, DetokenizerParameter {
    }

    private ParseToTokenSampleStreamFactory() {
        super(Parameters.class);
    }

    public static void registerFactory() {
        StreamFactoryRegistry.registerFactory(TokenSample.class, "parse", new ParseToTokenSampleStreamFactory());
    }

    @Override // opennlp.tools.cmdline.ObjectStreamFactory
    public ObjectStream<TokenSample> create(String[] strArr) {
        return new POSToTokenSampleStream(createDetokenizer((Parameters) ArgumentParser.parse(strArr, Parameters.class)), new ParseToPOSSampleStream(StreamFactoryRegistry.getFactory(Parse.class, "opennlp").create(ArgumentParser.filter(strArr, WordTagSampleStreamFactory.Parameters.class))));
    }
}
