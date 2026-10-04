package opennlp.tools.formats.letsmt;

import java.io.File;
import java.io.IOException;
import opennlp.tools.cmdline.ArgumentParser;
import opennlp.tools.cmdline.CmdLineUtil;
import opennlp.tools.cmdline.StreamFactoryRegistry;
import opennlp.tools.cmdline.TerminateToolException;
import opennlp.tools.cmdline.params.BasicFormatParams;
import opennlp.tools.formats.AbstractSampleStreamFactory;
import opennlp.tools.sentdetect.SentenceSample;
import opennlp.tools.tokenize.DetokenizationDictionary;
import opennlp.tools.tokenize.DictionaryDetokenizer;
import opennlp.tools.util.ObjectStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class LetsmtSentenceStreamFactory<P> extends AbstractSampleStreamFactory<SentenceSample, P> {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Parameters extends BasicFormatParams {
        @ArgumentParser.OptionalParameter
        @ArgumentParser.ParameterDescription(description = "specifies the file with detokenizer dictionary.", valueName = "dictionary")
        File getDetokenizer();
    }

    public LetsmtSentenceStreamFactory(Class<P> cls) {
        super(cls);
    }

    public static void registerFactory() {
        StreamFactoryRegistry.registerFactory(SentenceSample.class, "letsmt", new LetsmtSentenceStreamFactory(Parameters.class));
    }

    @Override // opennlp.tools.cmdline.ObjectStreamFactory
    public ObjectStream<SentenceSample> create(String[] strArr) {
        LetsmtDocument letsmtDocument;
        Parameters parameters = (Parameters) ArgumentParser.parse(strArr, Parameters.class);
        CmdLineUtil.checkInputFile("Data", parameters.getData());
        try {
            letsmtDocument = LetsmtDocument.parse(parameters.getData());
        } catch (IOException e) {
            CmdLineUtil.handleCreateObjectStreamError(e);
            letsmtDocument = null;
        }
        LetsmtSentenceStream letsmtSentenceStream = new LetsmtSentenceStream(letsmtDocument);
        if (parameters.getDetokenizer() == null) {
            return letsmtSentenceStream;
        }
        try {
            return new DetokenizeSentenceSampleStream(new DictionaryDetokenizer(new DetokenizationDictionary(parameters.getDetokenizer())), letsmtSentenceStream);
        } catch (IOException e2) {
            throw new TerminateToolException(-1, "Failed to load detokenizer rules!", e2);
        }
    }
}
