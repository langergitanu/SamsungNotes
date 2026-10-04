package opennlp.tools.lemmatizer;

import opennlp.tools.util.eval.Evaluator;
import opennlp.tools.util.eval.Mean;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class LemmatizerEvaluator extends Evaluator<LemmaSample> {
    private final Lemmatizer lemmatizer;
    private final Mean wordAccuracy;

    public LemmatizerEvaluator(Lemmatizer lemmatizer, LemmatizerEvaluationMonitor... lemmatizerEvaluationMonitorArr) {
        super(lemmatizerEvaluationMonitorArr);
        this.wordAccuracy = new Mean();
        this.lemmatizer = lemmatizer;
    }

    public double getWordAccuracy() {
        return this.wordAccuracy.mean();
    }

    public long getWordCount() {
        return this.wordAccuracy.count();
    }

    public String toString() {
        return "Accuracy:" + this.wordAccuracy.mean() + " Number of Samples: " + this.wordAccuracy.count();
    }

    @Override // opennlp.tools.util.eval.Evaluator
    public LemmaSample processSample(LemmaSample lemmaSample) {
        String[] strArrLemmatize = this.lemmatizer.lemmatize(lemmaSample.getTokens(), lemmaSample.getTags());
        String[] lemmas = lemmaSample.getLemmas();
        for (int i = 0; i < lemmas.length; i++) {
            if (lemmas[i].equals(strArrLemmatize[i])) {
                this.wordAccuracy.add(1.0d);
            } else {
                this.wordAccuracy.add(0.0d);
            }
        }
        return new LemmaSample(lemmaSample.getTokens(), lemmaSample.getTags(), strArrLemmatize);
    }
}
