package opennlp.tools.cmdline.postag;

import java.io.OutputStream;
import opennlp.tools.cmdline.FineGrainedReportListener;
import opennlp.tools.log.LogPrintStream;
import opennlp.tools.postag.POSSample;
import opennlp.tools.postag.POSTaggerEvaluationMonitor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class POSTaggerFineGrainedReportListener extends FineGrainedReportListener implements POSTaggerEvaluationMonitor {
    private static final Logger logger = LoggerFactory.getLogger((Class<?>) POSTaggerFineGrainedReportListener.class);

    public POSTaggerFineGrainedReportListener() {
        this(new LogPrintStream(logger));
    }

    private void statsAdd(POSSample pOSSample, POSSample pOSSample2) {
        getStats().add(pOSSample.getSentence(), pOSSample.getTags(), pOSSample2.getTags());
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

    public POSTaggerFineGrainedReportListener(OutputStream outputStream) {
        super(outputStream);
    }

    @Override // opennlp.tools.util.eval.EvaluationMonitor
    public void correctlyClassified(POSSample pOSSample, POSSample pOSSample2) {
        statsAdd(pOSSample, pOSSample2);
    }

    @Override // opennlp.tools.util.eval.EvaluationMonitor
    public void misclassified(POSSample pOSSample, POSSample pOSSample2) {
        statsAdd(pOSSample, pOSSample2);
    }
}
