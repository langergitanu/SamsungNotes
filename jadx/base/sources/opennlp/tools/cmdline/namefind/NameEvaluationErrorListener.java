package opennlp.tools.cmdline.namefind;

import java.io.OutputStream;
import java.io.PrintStream;
import opennlp.tools.cmdline.EvaluationErrorPrinter;
import opennlp.tools.log.LogPrintStream;
import opennlp.tools.namefind.NameSample;
import opennlp.tools.namefind.TokenNameFinderEvaluationMonitor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class NameEvaluationErrorListener extends EvaluationErrorPrinter<NameSample> implements TokenNameFinderEvaluationMonitor {
    private static final Logger logger = LoggerFactory.getLogger((Class<?>) NameEvaluationErrorListener.class);

    public NameEvaluationErrorListener() {
        super((PrintStream) new LogPrintStream(logger));
    }

    public NameEvaluationErrorListener(OutputStream outputStream) {
        super(outputStream);
    }

    @Override // opennlp.tools.cmdline.EvaluationErrorPrinter, opennlp.tools.util.eval.EvaluationMonitor
    public void misclassified(NameSample nameSample, NameSample nameSample2) {
        printError(nameSample.getId(), nameSample.getNames(), nameSample2.getNames(), nameSample, nameSample2, nameSample.getSentence());
    }
}
