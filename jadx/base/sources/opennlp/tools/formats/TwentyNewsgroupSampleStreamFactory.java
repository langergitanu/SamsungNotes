package opennlp.tools.formats;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.room.FtsOptions;
import java.io.File;
import java.io.IOException;
import opennlp.tools.cmdline.ArgumentParser;
import opennlp.tools.cmdline.StreamFactoryRegistry;
import opennlp.tools.cmdline.TerminateToolException;
import opennlp.tools.cmdline.params.EncodingParameter;
import opennlp.tools.doccat.DocumentSample;
import opennlp.tools.tokenize.SimpleTokenizer;
import opennlp.tools.tokenize.Tokenizer;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;
import opennlp.tools.tokenize.WhitespaceTokenizer;
import opennlp.tools.util.ObjectStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class TwentyNewsgroupSampleStreamFactory<P> extends AbstractSampleStreamFactory<DocumentSample, P> {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Parameters extends EncodingParameter {
        @ArgumentParser.ParameterDescription(description = "dir containing the 20newsgroup folders", valueName = "dataDir")
        File getDataDir();

        @ArgumentParser.OptionalParameter
        @ArgumentParser.ParameterDescription(valueName = "name")
        String getRuleBasedTokenizer();

        @ArgumentParser.OptionalParameter
        @ArgumentParser.ParameterDescription(valueName = "modelFile")
        File getTokenizerModel();
    }

    public TwentyNewsgroupSampleStreamFactory(Class<P> cls) {
        super(cls);
    }

    public static void registerFactory() {
        StreamFactoryRegistry.registerFactory(DocumentSample.class, "20newsgroup", new TwentyNewsgroupSampleStreamFactory(Parameters.class));
    }

    @Override // opennlp.tools.cmdline.ObjectStreamFactory
    public ObjectStream<DocumentSample> create(String[] strArr) {
        Parameters parameters = (Parameters) ArgumentParser.parse(strArr, Parameters.class);
        Tokenizer tokenizerME = WhitespaceTokenizer.INSTANCE;
        if (parameters.getTokenizerModel() != null) {
            try {
                tokenizerME = new TokenizerME(new TokenizerModel(parameters.getTokenizerModel()));
            } catch (IOException e) {
                throw new TerminateToolException(-1, "Failed to load tokenizer model!", e);
            }
        } else if (parameters.getRuleBasedTokenizer() != null) {
            String ruleBasedTokenizer = parameters.getRuleBasedTokenizer();
            if (FtsOptions.TOKENIZER_SIMPLE.equals(ruleBasedTokenizer)) {
                tokenizerME = SimpleTokenizer.INSTANCE;
            } else if (!"whitespace".equals(ruleBasedTokenizer)) {
                throw new TerminateToolException(-1, AbstractC0541b.m772n("Unknown tokenizer: ", ruleBasedTokenizer));
            }
        }
        try {
            return new TwentyNewsgroupSampleStream(tokenizerME, parameters.getDataDir().toPath());
        } catch (IOException e2) {
            throw new TerminateToolException(-1, AbstractC0541b.m772n("IO error while opening sample data: ", e2.getMessage()), e2);
        }
    }
}
