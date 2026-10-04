package opennlp.tools.langdetect;

import opennlp.tools.util.eval.Evaluator;
import opennlp.tools.util.eval.Mean;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class LanguageDetectorEvaluator extends Evaluator<LanguageSample> {
    private final Mean accuracy;
    private final LanguageDetector languageDetector;

    public LanguageDetectorEvaluator(LanguageDetector languageDetector, LanguageDetectorEvaluationMonitor... languageDetectorEvaluationMonitorArr) {
        super(languageDetectorEvaluationMonitorArr);
        this.accuracy = new Mean();
        this.languageDetector = languageDetector;
    }

    public double getAccuracy() {
        return this.accuracy.mean();
    }

    public long getDocumentCount() {
        return this.accuracy.count();
    }

    public String toString() {
        return "Accuracy: " + this.accuracy.mean() + "\nNumber of documents: " + this.accuracy.count();
    }

    @Override // opennlp.tools.util.eval.Evaluator
    public LanguageSample processSample(LanguageSample languageSample) {
        Language languagePredictLanguage = this.languageDetector.predictLanguage(languageSample.context());
        if (languageSample.language().getLang().equals(languagePredictLanguage.getLang())) {
            this.accuracy.add(1.0d);
        } else {
            this.accuracy.add(0.0d);
        }
        return new LanguageSample(languagePredictLanguage, languageSample.context());
    }
}
