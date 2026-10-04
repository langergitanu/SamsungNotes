package opennlp.tools.formats.leipzig;

import java.io.File;
import java.io.IOException;
import opennlp.tools.cmdline.ArgumentParser;
import opennlp.tools.cmdline.StreamFactoryRegistry;
import opennlp.tools.cmdline.TerminateToolException;
import opennlp.tools.cmdline.params.EncodingParameter;
import opennlp.tools.commons.Internal;
import opennlp.tools.formats.AbstractSampleStreamFactory;
import opennlp.tools.langdetect.LanguageSample;
import opennlp.tools.util.ObjectStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Internal
public class LeipzigLanguageSampleStreamFactory<P> extends AbstractSampleStreamFactory<LanguageSample, P> {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Parameters extends EncodingParameter {
        @ArgumentParser.ParameterDescription(description = "number of samples per language", valueName = "samplesPerLanguage")
        String getSamplesPerLanguage();

        @ArgumentParser.OptionalParameter(defaultValue = "0")
        @ArgumentParser.ParameterDescription(description = "number of samples to skip before returning", valueName = "samplesToSkip")
        String getSamplesToSkip();

        @ArgumentParser.ParameterDescription(description = "dir with Leipzig sentences to be used", valueName = "sentencesDir")
        File getSentencesDir();

        @ArgumentParser.ParameterDescription(description = "number of sentences per sample", valueName = "sentencesPerSample")
        String getSentencesPerSample();
    }

    public LeipzigLanguageSampleStreamFactory(Class<P> cls) {
        super(cls);
    }

    public static void registerFactory() {
        StreamFactoryRegistry.registerFactory(LanguageSample.class, "leipzig", new LeipzigLanguageSampleStreamFactory(Parameters.class));
    }

    @Override // opennlp.tools.cmdline.ObjectStreamFactory
    public ObjectStream<LanguageSample> create(String[] strArr) {
        Parameters parameters = (Parameters) ArgumentParser.parse(strArr, Parameters.class);
        try {
            return new SampleSkipStream(new SampleShuffleStream(new LeipzigLanguageSampleStream(parameters.getSentencesDir(), Integer.parseInt(parameters.getSentencesPerSample()), Integer.parseInt(parameters.getSamplesPerLanguage()) + Integer.parseInt(parameters.getSamplesToSkip()))), Integer.parseInt(parameters.getSamplesToSkip()));
        } catch (IOException e) {
            throw new TerminateToolException(-1, "IO error while opening sample data.", e);
        }
    }
}
