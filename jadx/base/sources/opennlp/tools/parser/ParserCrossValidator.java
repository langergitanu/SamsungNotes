package opennlp.tools.parser;

import opennlp.tools.util.ObjectStream;
import opennlp.tools.util.TrainingParameters;
import opennlp.tools.util.eval.CrossValidationPartitioner;
import opennlp.tools.util.eval.FMeasure;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class ParserCrossValidator {
    private final FMeasure fmeasure = new FMeasure();
    private final String languageCode;
    private final ParserEvaluationMonitor[] monitors;
    private final TrainingParameters params;
    private final ParserType parserType;
    private final HeadRules rules;

    public ParserCrossValidator(String str, TrainingParameters trainingParameters, HeadRules headRules, ParserType parserType, ParserEvaluationMonitor... parserEvaluationMonitorArr) {
        this.languageCode = str;
        this.params = trainingParameters;
        this.rules = headRules;
        this.parserType = parserType;
        this.monitors = parserEvaluationMonitorArr;
    }

    public void evaluate(ObjectStream<Parse> objectStream, int i) {
        ParserModel parserModelTrain;
        CrossValidationPartitioner crossValidationPartitioner = new CrossValidationPartitioner(objectStream, i);
        while (crossValidationPartitioner.hasNext()) {
            CrossValidationPartitioner.TrainingSampleStream next = crossValidationPartitioner.next();
            try {
                if (ParserType.CHUNKING.equals(this.parserType)) {
                    parserModelTrain = opennlp.tools.parser.chunking.Parser.train(this.languageCode, objectStream, this.rules, this.params);
                } else {
                    if (!ParserType.TREEINSERT.equals(this.parserType)) {
                        throw new IllegalStateException("Unexpected parser type: " + this.parserType);
                    }
                    parserModelTrain = opennlp.tools.parser.treeinsert.Parser.train(this.languageCode, objectStream, this.rules, this.params);
                }
                ParserEvaluator parserEvaluator = new ParserEvaluator(ParserFactory.create(parserModelTrain), this.monitors);
                parserEvaluator.evaluate(next.getTestSampleStream());
                this.fmeasure.mergeInto(parserEvaluator.getFMeasure());
                next.close();
            } catch (Throwable th) {
                if (next != null) {
                    try {
                        next.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }
    }

    public FMeasure getFMeasure() {
        return this.fmeasure;
    }
}
