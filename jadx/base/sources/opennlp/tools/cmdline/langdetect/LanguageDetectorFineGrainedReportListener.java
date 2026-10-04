package opennlp.tools.cmdline.langdetect;

import java.io.OutputStream;
import opennlp.tools.cmdline.FineGrainedReportListener;
import opennlp.tools.langdetect.LanguageDetectorEvaluationMonitor;
import opennlp.tools.langdetect.LanguageSample;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class LanguageDetectorFineGrainedReportListener extends FineGrainedReportListener implements LanguageDetectorEvaluationMonitor {
    public LanguageDetectorFineGrainedReportListener() {
        this(System.err);
    }

    private void statsAdd(LanguageSample languageSample, LanguageSample languageSample2) {
        getStats().add(languageSample.context(), languageSample.language().getLang(), languageSample2.language().getLang());
    }

    @Override // opennlp.tools.cmdline.FineGrainedReportListener
    public void writeReport() {
        printGeneralStatistics();
        printTagsErrorRank();
        printGeneralConfusionTable();
    }

    public LanguageDetectorFineGrainedReportListener(OutputStream outputStream) {
        super(outputStream);
    }

    @Override // opennlp.tools.util.eval.EvaluationMonitor
    public void correctlyClassified(LanguageSample languageSample, LanguageSample languageSample2) {
        statsAdd(languageSample, languageSample2);
    }

    @Override // opennlp.tools.util.eval.EvaluationMonitor
    public void misclassified(LanguageSample languageSample, LanguageSample languageSample2) {
        statsAdd(languageSample, languageSample2);
    }
}
