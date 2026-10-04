package opennlp.tools.cmdline.tokenizer;

import java.io.OutputStream;
import java.io.PrintStream;
import opennlp.tools.cmdline.EvaluationErrorPrinter;
import opennlp.tools.log.LogPrintStream;
import opennlp.tools.tokenize.TokenSample;
import opennlp.tools.tokenize.TokenizerEvaluationMonitor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class DetokenEvaluationErrorListener extends EvaluationErrorPrinter<TokenSample> implements TokenizerEvaluationMonitor {
    private static final Logger logger = LoggerFactory.getLogger((Class<?>) DetokenEvaluationErrorListener.class);

    public DetokenEvaluationErrorListener() {
        super((PrintStream) new LogPrintStream(logger));
    }

    public DetokenEvaluationErrorListener(OutputStream outputStream) {
        super(outputStream);
    }

    @Override // opennlp.tools.cmdline.EvaluationErrorPrinter, opennlp.tools.util.eval.EvaluationMonitor
    public void misclassified(TokenSample tokenSample, TokenSample tokenSample2) {
        printError(tokenSample, tokenSample2);
    }
}
