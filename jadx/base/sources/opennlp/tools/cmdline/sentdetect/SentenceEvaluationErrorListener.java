package opennlp.tools.cmdline.sentdetect;

import java.io.OutputStream;
import java.io.PrintStream;
import opennlp.tools.cmdline.EvaluationErrorPrinter;
import opennlp.tools.log.LogPrintStream;
import opennlp.tools.sentdetect.SentenceDetectorEvaluationMonitor;
import opennlp.tools.sentdetect.SentenceSample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class SentenceEvaluationErrorListener extends EvaluationErrorPrinter<SentenceSample> implements SentenceDetectorEvaluationMonitor {
    private static final Logger logger = LoggerFactory.getLogger((Class<?>) SentenceEvaluationErrorListener.class);

    public SentenceEvaluationErrorListener() {
        super((PrintStream) new LogPrintStream(logger));
    }

    public SentenceEvaluationErrorListener(OutputStream outputStream) {
        super(outputStream);
    }

    @Override // opennlp.tools.cmdline.EvaluationErrorPrinter, opennlp.tools.util.eval.EvaluationMonitor
    public void misclassified(SentenceSample sentenceSample, SentenceSample sentenceSample2) {
        printError(sentenceSample.getSentences(), sentenceSample2.getSentences(), sentenceSample, sentenceSample2, sentenceSample.getDocument());
    }
}
