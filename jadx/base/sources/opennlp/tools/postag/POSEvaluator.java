package opennlp.tools.postag;

import opennlp.tools.util.eval.Evaluator;
import opennlp.tools.util.eval.Mean;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class POSEvaluator extends Evaluator<POSSample> {
    private final POSTagger tagger;
    private final Mean wordAccuracy;

    public POSEvaluator(POSTagger pOSTagger, POSTaggerEvaluationMonitor... pOSTaggerEvaluationMonitorArr) {
        super(pOSTaggerEvaluationMonitorArr);
        this.wordAccuracy = new Mean();
        this.tagger = pOSTagger;
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
    public POSSample processSample(POSSample pOSSample) {
        String[] strArrTag = this.tagger.tag(pOSSample.getSentence(), pOSSample.getAdditionalContext());
        String[] tags = pOSSample.getTags();
        for (int i = 0; i < tags.length; i++) {
            if (tags[i].equals(strArrTag[i])) {
                this.wordAccuracy.add(1.0d);
            } else {
                this.wordAccuracy.add(0.0d);
            }
        }
        return new POSSample(pOSSample.getSentence(), strArrTag);
    }
}
