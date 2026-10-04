package opennlp.tools.cmdline.doccat;

import java.io.OutputStream;
import java.io.PrintStream;
import opennlp.tools.cmdline.EvaluationErrorPrinter;
import opennlp.tools.doccat.DoccatEvaluationMonitor;
import opennlp.tools.doccat.DocumentSample;
import opennlp.tools.log.LogPrintStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class DoccatEvaluationErrorListener extends EvaluationErrorPrinter<DocumentSample> implements DoccatEvaluationMonitor {
    private static final Logger logger = LoggerFactory.getLogger((Class<?>) DoccatEvaluationErrorListener.class);

    public DoccatEvaluationErrorListener() {
        super((PrintStream) new LogPrintStream(logger));
    }

    public DoccatEvaluationErrorListener(OutputStream outputStream) {
        super(outputStream);
    }

    @Override // opennlp.tools.cmdline.EvaluationErrorPrinter, opennlp.tools.util.eval.EvaluationMonitor
    public void misclassified(DocumentSample documentSample, DocumentSample documentSample2) {
        printError(documentSample, documentSample2);
    }
}
