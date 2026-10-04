package opennlp.tools.formats.convert;

import opennlp.tools.cmdline.ArgumentParser;
import opennlp.tools.cmdline.StreamFactoryRegistry;
import opennlp.tools.cmdline.params.DetokenizerParameter;
import opennlp.tools.commons.Internal;
import opennlp.tools.formats.DetokenizerSampleStreamFactory;
import opennlp.tools.formats.NameSampleDataStreamFactory;
import opennlp.tools.namefind.NameSample;
import opennlp.tools.tokenize.TokenSample;
import opennlp.tools.util.ObjectStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Internal
public class NameToTokenSampleStreamFactory<P> extends DetokenizerSampleStreamFactory<TokenSample, P> {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Parameters extends NameSampleDataStreamFactory.Parameters, DetokenizerParameter {
    }

    public NameToTokenSampleStreamFactory(Class<P> cls) {
        super(cls);
    }

    public static void registerFactory() {
        StreamFactoryRegistry.registerFactory(TokenSample.class, "namefinder", new NameToTokenSampleStreamFactory(Parameters.class));
    }

    @Override // opennlp.tools.cmdline.ObjectStreamFactory
    public ObjectStream<TokenSample> create(String[] strArr) {
        Parameters parameters = (Parameters) ArgumentParser.parse(strArr, Parameters.class);
        return new NameToTokenSampleStream(createDetokenizer(parameters), StreamFactoryRegistry.getFactory(NameSample.class, "opennlp").create(ArgumentParser.filter(strArr, NameSampleDataStreamFactory.Parameters.class)));
    }
}
