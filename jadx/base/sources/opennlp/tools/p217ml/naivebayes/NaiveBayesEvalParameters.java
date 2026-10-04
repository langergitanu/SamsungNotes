package opennlp.tools.p217ml.naivebayes;

import opennlp.tools.p217ml.model.Context;
import opennlp.tools.p217ml.model.EvalParameters;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class NaiveBayesEvalParameters extends EvalParameters {
    protected final double[] outcomeTotals;
    protected final long vocabulary;

    public NaiveBayesEvalParameters(Context[] contextArr, int i, double[] dArr, long j) {
        super(contextArr, i);
        this.outcomeTotals = dArr;
        this.vocabulary = j;
    }

    public double[] getOutcomeTotals() {
        return this.outcomeTotals;
    }

    public long getVocabulary() {
        return this.vocabulary;
    }
}
