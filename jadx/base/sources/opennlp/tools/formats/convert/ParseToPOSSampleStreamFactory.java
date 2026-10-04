package opennlp.tools.formats.convert;

import opennlp.tools.cmdline.ArgumentParser;
import opennlp.tools.cmdline.StreamFactoryRegistry;
import opennlp.tools.commons.Internal;
import opennlp.tools.formats.LanguageSampleStreamFactory;
import opennlp.tools.formats.ParseSampleStreamFactory;
import opennlp.tools.parser.Parse;
import opennlp.tools.postag.POSSample;
import opennlp.tools.util.ObjectStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Internal
public class ParseToPOSSampleStreamFactory extends LanguageSampleStreamFactory<POSSample, ParseSampleStreamFactory.Parameters> {
    private ParseToPOSSampleStreamFactory() {
        super(ParseSampleStreamFactory.Parameters.class);
    }

    public static void registerFactory() {
        StreamFactoryRegistry.registerFactory(POSSample.class, "parse", new ParseToPOSSampleStreamFactory());
    }

    @Override // opennlp.tools.cmdline.ObjectStreamFactory
    public ObjectStream<POSSample> create(String[] strArr) {
        return new ParseToPOSSampleStream(StreamFactoryRegistry.getFactory(Parse.class, "opennlp").create(ArgumentParser.filter(strArr, ParseSampleStreamFactory.Parameters.class)));
    }
}
