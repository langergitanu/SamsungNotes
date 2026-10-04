package opennlp.tools.chunker;

import opennlp.tools.util.ObjectStream;
import opennlp.tools.util.TrainingParameters;
import opennlp.tools.util.eval.CrossValidationPartitioner;
import opennlp.tools.util.eval.FMeasure;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class ChunkerCrossValidator {
    private final ChunkerFactory chunkerFactory;
    private final FMeasure fmeasure = new FMeasure();
    private final String languageCode;
    private final ChunkerEvaluationMonitor[] listeners;
    private final TrainingParameters params;

    public ChunkerCrossValidator(String str, TrainingParameters trainingParameters, ChunkerFactory chunkerFactory, ChunkerEvaluationMonitor... chunkerEvaluationMonitorArr) {
        this.chunkerFactory = chunkerFactory;
        this.languageCode = str;
        this.params = trainingParameters;
        this.listeners = chunkerEvaluationMonitorArr;
    }

    public void evaluate(ObjectStream<ChunkSample> objectStream, int i) {
        CrossValidationPartitioner crossValidationPartitioner = new CrossValidationPartitioner(objectStream, i);
        while (crossValidationPartitioner.hasNext()) {
            CrossValidationPartitioner.TrainingSampleStream next = crossValidationPartitioner.next();
            ChunkerEvaluator chunkerEvaluator = new ChunkerEvaluator(new ChunkerME(ChunkerME.train(this.languageCode, next, this.params, this.chunkerFactory)), this.listeners);
            chunkerEvaluator.evaluate(next.getTestSampleStream());
            this.fmeasure.mergeInto(chunkerEvaluator.getFMeasure());
        }
    }

    public FMeasure getFMeasure() {
        return this.fmeasure;
    }
}
