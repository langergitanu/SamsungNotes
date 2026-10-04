package opennlp.tools.cmdline.lemmatizer;

import java.io.OutputStream;
import java.io.PrintStream;
import opennlp.tools.cmdline.FineGrainedReportListener;
import opennlp.tools.lemmatizer.LemmaSample;
import opennlp.tools.lemmatizer.LemmatizerEvaluationMonitor;
import opennlp.tools.log.LogPrintStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class LemmatizerFineGrainedReportListener extends FineGrainedReportListener implements LemmatizerEvaluationMonitor {
    private static final Logger logger = LoggerFactory.getLogger((Class<?>) LemmatizerFineGrainedReportListener.class);

    public LemmatizerFineGrainedReportListener() {
        super((PrintStream) new LogPrintStream(logger));
    }

    private void statsAdd(LemmaSample lemmaSample, LemmaSample lemmaSample2) {
        getStats().add(lemmaSample.getTokens(), lemmaSample.getTags(), lemmaSample2.getTags());
    }

    @Override // opennlp.tools.cmdline.FineGrainedReportListener
    public void writeReport() {
        printGeneralStatistics();
        printTokenErrorRank();
        printTokenOccurrencesRank();
        printTagsErrorRank();
        printGeneralConfusionTable();
        printDetailedConfusionMatrix();
    }

    public LemmatizerFineGrainedReportListener(OutputStream outputStream) {
        super(outputStream);
    }

    @Override // opennlp.tools.util.eval.EvaluationMonitor
    public void correctlyClassified(LemmaSample lemmaSample, LemmaSample lemmaSample2) {
        statsAdd(lemmaSample, lemmaSample2);
    }

    @Override // opennlp.tools.util.eval.EvaluationMonitor
    public void misclassified(LemmaSample lemmaSample, LemmaSample lemmaSample2) {
        statsAdd(lemmaSample, lemmaSample2);
    }
}
