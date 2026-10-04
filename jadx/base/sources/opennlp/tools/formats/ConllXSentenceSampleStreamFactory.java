package opennlp.tools.formats;

import opennlp.tools.cmdline.ArgumentParser;
import opennlp.tools.cmdline.StreamFactoryRegistry;
import opennlp.tools.cmdline.params.DetokenizerParameter;
import opennlp.tools.commons.Internal;
import opennlp.tools.formats.ConllXPOSSampleStreamFactory;
import opennlp.tools.formats.convert.POSToSentenceSampleStream;
import opennlp.tools.postag.POSSample;
import opennlp.tools.sentdetect.SentenceSample;
import opennlp.tools.util.ObjectStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Internal
public class ConllXSentenceSampleStreamFactory<P> extends DetokenizerSampleStreamFactory<SentenceSample, P> {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Parameters extends ConllXPOSSampleStreamFactory.Parameters, DetokenizerParameter {
    }

    public ConllXSentenceSampleStreamFactory(Class<P> cls) {
        super(cls);
    }

    public static void registerFactory() {
        StreamFactoryRegistry.registerFactory(SentenceSample.class, ConllXPOSSampleStreamFactory.CONLLX_FORMAT, new ConllXSentenceSampleStreamFactory(Parameters.class));
    }

    @Override // opennlp.tools.cmdline.ObjectStreamFactory
    public ObjectStream<SentenceSample> create(String[] strArr) {
        Parameters parameters = (Parameters) ArgumentParser.parse(strArr, Parameters.class);
        return new POSToSentenceSampleStream(createDetokenizer(parameters), StreamFactoryRegistry.getFactory(POSSample.class, ConllXPOSSampleStreamFactory.CONLLX_FORMAT).create(ArgumentParser.filter(strArr, ConllXPOSSampleStreamFactory.Parameters.class)), 30);
    }
}
