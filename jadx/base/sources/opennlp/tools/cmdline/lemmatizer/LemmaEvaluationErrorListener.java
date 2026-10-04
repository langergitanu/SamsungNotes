package opennlp.tools.cmdline.lemmatizer;

import java.io.OutputStream;
import java.io.PrintStream;
import opennlp.tools.cmdline.EvaluationErrorPrinter;
import opennlp.tools.lemmatizer.LemmaSample;
import opennlp.tools.lemmatizer.LemmatizerEvaluationMonitor;
import opennlp.tools.log.LogPrintStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class LemmaEvaluationErrorListener extends EvaluationErrorPrinter<LemmaSample> implements LemmatizerEvaluationMonitor {
    private static final Logger logger = LoggerFactory.getLogger((Class<?>) LemmaEvaluationErrorListener.class);

    public LemmaEvaluationErrorListener() {
        super((PrintStream) new LogPrintStream(logger));
    }

    public LemmaEvaluationErrorListener(OutputStream outputStream) {
        super(outputStream);
    }

    @Override // opennlp.tools.cmdline.EvaluationErrorPrinter, opennlp.tools.util.eval.EvaluationMonitor
    public void misclassified(LemmaSample lemmaSample, LemmaSample lemmaSample2) {
        printError(lemmaSample.getLemmas(), lemmaSample2.getLemmas(), lemmaSample, lemmaSample2, lemmaSample.getTokens());
    }
}
