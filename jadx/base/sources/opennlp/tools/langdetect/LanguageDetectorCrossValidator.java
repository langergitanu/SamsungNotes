package opennlp.tools.langdetect;

import opennlp.tools.util.ObjectStream;
import opennlp.tools.util.TrainingParameters;
import opennlp.tools.util.eval.CrossValidationPartitioner;
import opennlp.tools.util.eval.Mean;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class LanguageDetectorCrossValidator {
    private final Mean documentAccuracy = new Mean();
    private final LanguageDetectorFactory factory;
    private final LanguageDetectorEvaluationMonitor[] listeners;
    private final TrainingParameters params;

    public LanguageDetectorCrossValidator(TrainingParameters trainingParameters, LanguageDetectorFactory languageDetectorFactory, LanguageDetectorEvaluationMonitor... languageDetectorEvaluationMonitorArr) {
        this.params = trainingParameters;
        this.listeners = languageDetectorEvaluationMonitorArr;
        this.factory = languageDetectorFactory;
    }

    public void evaluate(ObjectStream<LanguageSample> objectStream, int i) {
        CrossValidationPartitioner crossValidationPartitioner = new CrossValidationPartitioner(objectStream, i);
        while (crossValidationPartitioner.hasNext()) {
            CrossValidationPartitioner.TrainingSampleStream next = crossValidationPartitioner.next();
            LanguageDetectorEvaluator languageDetectorEvaluator = new LanguageDetectorEvaluator(new LanguageDetectorME(LanguageDetectorME.train(next, this.params, this.factory)), this.listeners);
            languageDetectorEvaluator.evaluate(next.getTestSampleStream());
            this.documentAccuracy.add(languageDetectorEvaluator.getAccuracy(), languageDetectorEvaluator.getDocumentCount());
        }
    }

    public double getDocumentAccuracy() {
        return this.documentAccuracy.mean();
    }

    public long getDocumentCount() {
        return this.documentAccuracy.count();
    }
}
