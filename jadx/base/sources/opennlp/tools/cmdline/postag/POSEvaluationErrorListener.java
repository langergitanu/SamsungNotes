package opennlp.tools.cmdline.postag;

import java.io.OutputStream;
import java.io.PrintStream;
import opennlp.tools.cmdline.EvaluationErrorPrinter;
import opennlp.tools.log.LogPrintStream;
import opennlp.tools.postag.POSSample;
import opennlp.tools.postag.POSTaggerEvaluationMonitor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class POSEvaluationErrorListener extends EvaluationErrorPrinter<POSSample> implements POSTaggerEvaluationMonitor {
    private static final Logger logger = LoggerFactory.getLogger((Class<?>) POSEvaluationErrorListener.class);

    public POSEvaluationErrorListener() {
        super((PrintStream) new LogPrintStream(logger));
    }

    public POSEvaluationErrorListener(OutputStream outputStream) {
        super(outputStream);
    }

    @Override // opennlp.tools.cmdline.EvaluationErrorPrinter, opennlp.tools.util.eval.EvaluationMonitor
    public void misclassified(POSSample pOSSample, POSSample pOSSample2) {
        printError(pOSSample.getTags(), pOSSample2.getTags(), pOSSample, pOSSample2, pOSSample.getSentence());
    }
}
