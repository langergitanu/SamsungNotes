package opennlp.tools.cmdline.doccat;

import java.io.OutputStream;
import opennlp.tools.cmdline.FineGrainedReportListener;
import opennlp.tools.doccat.DoccatEvaluationMonitor;
import opennlp.tools.doccat.DocumentSample;
import opennlp.tools.log.LogPrintStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class DoccatFineGrainedReportListener extends FineGrainedReportListener implements DoccatEvaluationMonitor {
    private static final Logger logger = LoggerFactory.getLogger((Class<?>) DoccatFineGrainedReportListener.class);

    public DoccatFineGrainedReportListener() {
        this(new LogPrintStream(logger));
    }

    private void statsAdd(DocumentSample documentSample, DocumentSample documentSample2) {
        getStats().add(documentSample.getText(), documentSample.getCategory(), documentSample2.getCategory());
    }

    @Override // opennlp.tools.cmdline.FineGrainedReportListener
    public void writeReport() {
        printGeneralStatistics();
        printTagsErrorRank();
        printGeneralConfusionTable();
    }

    public DoccatFineGrainedReportListener(OutputStream outputStream) {
        super(outputStream);
    }

    @Override // opennlp.tools.util.eval.EvaluationMonitor
    public void correctlyClassified(DocumentSample documentSample, DocumentSample documentSample2) {
        statsAdd(documentSample, documentSample2);
    }

    @Override // opennlp.tools.util.eval.EvaluationMonitor
    public void misclassified(DocumentSample documentSample, DocumentSample documentSample2) {
        statsAdd(documentSample, documentSample2);
    }
}
