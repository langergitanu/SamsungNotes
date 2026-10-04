package opennlp.tools.formats.brat;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.room.FtsOptions;
import com.samsung.android.sdk.mobileservice.profile.Privacy;
import com.samsung.android.support.senl.p148nt.model.collector.common.C11419a;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import opennlp.tools.cmdline.ArgumentParser;
import opennlp.tools.cmdline.StreamFactoryRegistry;
import opennlp.tools.cmdline.TerminateToolException;
import opennlp.tools.formats.AbstractSampleStreamFactory;
import opennlp.tools.namefind.NameSample;
import opennlp.tools.sentdetect.NewlineSentenceDetector;
import opennlp.tools.sentdetect.SentenceDetector;
import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceModel;
import opennlp.tools.tokenize.SimpleTokenizer;
import opennlp.tools.tokenize.Tokenizer;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;
import opennlp.tools.tokenize.WhitespaceTokenizer;
import opennlp.tools.util.ObjectStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class BratNameSampleStreamFactory extends AbstractSampleStreamFactory<NameSample, Parameters> {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Parameters {
        @ArgumentParser.ParameterDescription(valueName = "annConfFile")
        File getAnnotationConfig();

        @ArgumentParser.ParameterDescription(description = "location of brat data dir", valueName = "bratDataDir")
        File getBratDataDir();

        @ArgumentParser.OptionalParameter
        @ArgumentParser.ParameterDescription(valueName = Privacy.KEY_NAMES)
        String getNameTypes();

        @ArgumentParser.OptionalParameter(defaultValue = "false")
        @ArgumentParser.ParameterDescription(valueName = "value")
        Boolean getRecursive();

        @ArgumentParser.OptionalParameter
        @ArgumentParser.ParameterDescription(valueName = "name")
        String getRuleBasedTokenizer();

        @ArgumentParser.OptionalParameter
        @ArgumentParser.ParameterDescription(valueName = "modelFile")
        File getSentenceDetectorModel();

        @ArgumentParser.OptionalParameter
        @ArgumentParser.ParameterDescription(valueName = "modelFile")
        File getTokenizerModel();
    }

    public BratNameSampleStreamFactory() {
        super(Parameters.class);
    }

    private boolean notNull(Object... objArr) {
        for (Object obj : objArr) {
            if (obj == null) {
                return false;
            }
        }
        return true;
    }

    public static void registerFactory() {
        StreamFactoryRegistry.registerFactory(NameSample.class, "brat", new BratNameSampleStreamFactory());
    }

    @Override // opennlp.tools.cmdline.ObjectStreamFactory
    public ObjectStream<NameSample> create(String[] strArr) {
        SentenceDetector sentenceDetectorME;
        Parameters parameters = (Parameters) ArgumentParser.parse(strArr, Parameters.class);
        if (notNull(parameters.getRuleBasedTokenizer(), parameters.getTokenizerModel())) {
            throw new TerminateToolException(-1, "Either use rule based or statistical tokenizer!");
        }
        try {
            try {
                Set set = null;
                BratDocumentStream bratDocumentStream = new BratDocumentStream(AnnotationConfiguration.parse(parameters.getAnnotationConfig()), parameters.getBratDataDir(), parameters.getRecursive().booleanValue(), null);
                if (parameters.getSentenceDetectorModel() != null) {
                    try {
                        sentenceDetectorME = new SentenceDetectorME(new SentenceModel(parameters.getSentenceDetectorModel()));
                    } catch (IOException e) {
                        throw new TerminateToolException(-1, "Failed to load sentence detector model!", e);
                    }
                } else {
                    sentenceDetectorME = new NewlineSentenceDetector();
                }
                Tokenizer tokenizerME = WhitespaceTokenizer.INSTANCE;
                if (parameters.getTokenizerModel() != null) {
                    try {
                        tokenizerME = new TokenizerME(new TokenizerModel(parameters.getTokenizerModel()));
                    } catch (IOException e2) {
                        throw new TerminateToolException(-1, "Failed to load tokenizer model!", e2);
                    }
                } else if (parameters.getRuleBasedTokenizer() != null) {
                    String ruleBasedTokenizer = parameters.getRuleBasedTokenizer();
                    if (FtsOptions.TOKENIZER_SIMPLE.equals(ruleBasedTokenizer)) {
                        tokenizerME = SimpleTokenizer.INSTANCE;
                    } else if (!"whitespace".equals(ruleBasedTokenizer)) {
                        throw new TerminateToolException(-1, AbstractC0541b.m772n("Unknown tokenizer: ", ruleBasedTokenizer));
                    }
                }
                if (parameters.getNameTypes() != null) {
                    String[] strArrSplit = parameters.getNameTypes().split(",");
                    if (strArrSplit.length > 0) {
                        set = (Set) Arrays.stream(strArrSplit).map(new C11419a(19)).collect(Collectors.toSet());
                    }
                }
                return new BratNameSampleStream(sentenceDetectorME, tokenizerME, bratDocumentStream, (Set<String>) set);
            } catch (IOException e3) {
                throw new TerminateToolException(-1, e3.getMessage());
            }
        } catch (IOException unused) {
            throw new TerminateToolException(1, "Failed to parse annotation.conf file!");
        }
    }
}
