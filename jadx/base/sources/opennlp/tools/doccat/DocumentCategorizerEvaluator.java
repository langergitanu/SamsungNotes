package opennlp.tools.doccat;

import opennlp.tools.util.eval.Evaluator;
import opennlp.tools.util.eval.Mean;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class DocumentCategorizerEvaluator extends Evaluator<DocumentSample> {
    private final Mean accuracy;
    private final DocumentCategorizer categorizer;

    public DocumentCategorizerEvaluator(DocumentCategorizer documentCategorizer, DoccatEvaluationMonitor... doccatEvaluationMonitorArr) {
        super(doccatEvaluationMonitorArr);
        this.accuracy = new Mean();
        this.categorizer = documentCategorizer;
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
    public DocumentSample processSample(DocumentSample documentSample) {
        String bestCategory = this.categorizer.getBestCategory(this.categorizer.categorize(documentSample.getText()));
        if (documentSample.getCategory().equals(bestCategory)) {
            this.accuracy.add(1.0d);
        } else {
            this.accuracy.add(0.0d);
        }
        return new DocumentSample(bestCategory, documentSample.getText());
    }
}
