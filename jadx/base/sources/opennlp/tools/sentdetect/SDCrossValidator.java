package opennlp.tools.sentdetect;

import opennlp.tools.util.ObjectStream;
import opennlp.tools.util.TrainingParameters;
import opennlp.tools.util.eval.CrossValidationPartitioner;
import opennlp.tools.util.eval.FMeasure;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class SDCrossValidator {
    private final FMeasure fmeasure = new FMeasure();
    private final String languageCode;
    private final SentenceDetectorEvaluationMonitor[] listeners;
    private final TrainingParameters params;
    private final SentenceDetectorFactory sdFactory;

    public SDCrossValidator(String str, TrainingParameters trainingParameters, SentenceDetectorFactory sentenceDetectorFactory, SentenceDetectorEvaluationMonitor... sentenceDetectorEvaluationMonitorArr) {
        this.languageCode = str;
        this.params = trainingParameters;
        this.listeners = sentenceDetectorEvaluationMonitorArr;
        this.sdFactory = sentenceDetectorFactory;
    }

    public void evaluate(ObjectStream<SentenceSample> objectStream, int i) {
        CrossValidationPartitioner crossValidationPartitioner = new CrossValidationPartitioner(objectStream, i);
        while (crossValidationPartitioner.hasNext()) {
            CrossValidationPartitioner.TrainingSampleStream next = crossValidationPartitioner.next();
            SentenceDetectorEvaluator sentenceDetectorEvaluator = new SentenceDetectorEvaluator(new SentenceDetectorME(SentenceDetectorME.train(this.languageCode, next, this.sdFactory, this.params)), this.listeners);
            sentenceDetectorEvaluator.evaluate(next.getTestSampleStream());
            this.fmeasure.mergeInto(sentenceDetectorEvaluator.getFMeasure());
        }
    }

    public FMeasure getFMeasure() {
        return this.fmeasure;
    }
}
