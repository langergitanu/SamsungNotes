package opennlp.tools.tokenize;

import opennlp.tools.util.ObjectStream;
import opennlp.tools.util.TrainingParameters;
import opennlp.tools.util.eval.CrossValidationPartitioner;
import opennlp.tools.util.eval.FMeasure;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class TokenizerCrossValidator {
    private final TokenizerFactory factory;
    private final FMeasure fmeasure = new FMeasure();
    private final TokenizerEvaluationMonitor[] listeners;
    private final TrainingParameters params;

    public TokenizerCrossValidator(TrainingParameters trainingParameters, TokenizerFactory tokenizerFactory, TokenizerEvaluationMonitor... tokenizerEvaluationMonitorArr) {
        this.params = trainingParameters;
        this.listeners = tokenizerEvaluationMonitorArr;
        this.factory = tokenizerFactory;
    }

    public void evaluate(ObjectStream<TokenSample> objectStream, int i) {
        CrossValidationPartitioner crossValidationPartitioner = new CrossValidationPartitioner(objectStream, i);
        while (crossValidationPartitioner.hasNext()) {
            CrossValidationPartitioner.TrainingSampleStream next = crossValidationPartitioner.next();
            TokenizerEvaluator tokenizerEvaluator = new TokenizerEvaluator(new TokenizerME(TokenizerME.train(next, this.factory, this.params)), this.listeners);
            tokenizerEvaluator.evaluate(next.getTestSampleStream());
            this.fmeasure.mergeInto(tokenizerEvaluator.getFMeasure());
        }
    }

    public FMeasure getFMeasure() {
        return this.fmeasure;
    }
}
