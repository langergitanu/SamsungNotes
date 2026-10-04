package opennlp.tools.formats.convert;

import opennlp.tools.cmdline.ArgumentParser;
import opennlp.tools.cmdline.StreamFactoryRegistry;
import opennlp.tools.cmdline.params.DetokenizerParameter;
import opennlp.tools.commons.Internal;
import opennlp.tools.formats.DetokenizerSampleStreamFactory;
import opennlp.tools.formats.ParseSampleStreamFactory;
import opennlp.tools.parser.Parse;
import opennlp.tools.sentdetect.SentenceSample;
import opennlp.tools.util.ObjectStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Internal
public class ParseToSentenceSampleStreamFactory extends DetokenizerSampleStreamFactory<SentenceSample, Parameters> {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Parameters extends ParseSampleStreamFactory.Parameters, DetokenizerParameter {
    }

    private ParseToSentenceSampleStreamFactory() {
        super(Parameters.class);
    }

    public static void registerFactory() {
        StreamFactoryRegistry.registerFactory(SentenceSample.class, "parse", new ParseToSentenceSampleStreamFactory());
    }

    @Override // opennlp.tools.cmdline.ObjectStreamFactory
    public ObjectStream<SentenceSample> create(String[] strArr) {
        return new POSToSentenceSampleStream(createDetokenizer((Parameters) ArgumentParser.parse(strArr, Parameters.class)), new ParseToPOSSampleStream(StreamFactoryRegistry.getFactory(Parse.class, "opennlp").create(ArgumentParser.filter(strArr, ParseSampleStreamFactory.Parameters.class))), 30);
    }
}
