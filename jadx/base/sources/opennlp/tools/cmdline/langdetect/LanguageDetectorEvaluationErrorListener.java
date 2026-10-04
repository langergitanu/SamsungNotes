package opennlp.tools.cmdline.langdetect;

import java.io.OutputStream;
import java.io.PrintStream;
import opennlp.tools.cmdline.EvaluationErrorPrinter;
import opennlp.tools.langdetect.LanguageDetectorEvaluationMonitor;
import opennlp.tools.langdetect.LanguageSample;
import opennlp.tools.log.LogPrintStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class LanguageDetectorEvaluationErrorListener extends EvaluationErrorPrinter<LanguageSample> implements LanguageDetectorEvaluationMonitor {
    private static final Logger logger = LoggerFactory.getLogger((Class<?>) LanguageDetectorEvaluationErrorListener.class);

    public LanguageDetectorEvaluationErrorListener() {
        super((PrintStream) new LogPrintStream(logger));
    }

    public LanguageDetectorEvaluationErrorListener(OutputStream outputStream) {
        super(outputStream);
        this.printStream.println("Expected\tPredicted\tContext");
    }

    @Override // opennlp.tools.cmdline.EvaluationErrorPrinter, opennlp.tools.util.eval.EvaluationMonitor
    public void misclassified(LanguageSample languageSample, LanguageSample languageSample2) {
        printError(languageSample, languageSample2);
    }

    @Override // opennlp.tools.cmdline.EvaluationErrorPrinter
    public void printError(LanguageSample languageSample, LanguageSample languageSample2) {
        this.printStream.println(String.join("\t", languageSample.language().getLang(), languageSample2.language().getLang(), languageSample.context()));
    }
}
