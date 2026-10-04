package opennlp.tools.doccat;

import opennlp.tools.util.ObjectStream;
import opennlp.tools.util.TrainingParameters;
import opennlp.tools.util.eval.CrossValidationPartitioner;
import opennlp.tools.util.eval.Mean;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class DoccatCrossValidator {
    private final Mean documentAccuracy = new Mean();
    private final DoccatFactory factory;
    private final String languageCode;
    private final DoccatEvaluationMonitor[] listeners;
    private final TrainingParameters params;

    public DoccatCrossValidator(String str, TrainingParameters trainingParameters, DoccatFactory doccatFactory, DoccatEvaluationMonitor... doccatEvaluationMonitorArr) {
        this.languageCode = str;
        this.params = trainingParameters;
        this.listeners = doccatEvaluationMonitorArr;
        this.factory = doccatFactory;
    }

    public void evaluate(ObjectStream<DocumentSample> objectStream, int i) {
        CrossValidationPartitioner crossValidationPartitioner = new CrossValidationPartitioner(objectStream, i);
        while (crossValidationPartitioner.hasNext()) {
            CrossValidationPartitioner.TrainingSampleStream next = crossValidationPartitioner.next();
            DocumentCategorizerEvaluator documentCategorizerEvaluator = new DocumentCategorizerEvaluator(new DocumentCategorizerME(DocumentCategorizerME.train(this.languageCode, next, this.params, this.factory)), this.listeners);
            documentCategorizerEvaluator.evaluate(next.getTestSampleStream());
            this.documentAccuracy.add(documentCategorizerEvaluator.getAccuracy(), documentCategorizerEvaluator.getDocumentCount());
        }
    }

    public double getDocumentAccuracy() {
        return this.documentAccuracy.mean();
    }

    public long getDocumentCount() {
        return this.documentAccuracy.count();
    }
}
