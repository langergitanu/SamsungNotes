package opennlp.tools.p217ml.naivebayes;

import java.util.Arrays;
import java.util.Map;
import opennlp.tools.p217ml.model.AbstractModel;
import opennlp.tools.p217ml.model.Context;
import opennlp.tools.p217ml.model.EvalParameters;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class NaiveBayesModel extends AbstractModel {
    protected final double[] outcomeTotals;
    protected long vocabulary;

    public NaiveBayesModel(Context[] contextArr, String[] strArr, Map<String, Context> map, String[] strArr2) {
        super(contextArr, strArr, map, strArr2);
        double[] dArrInitOutcomeTotals = initOutcomeTotals(strArr2, contextArr);
        this.outcomeTotals = dArrInitOutcomeTotals;
        this.evalParams = new NaiveBayesEvalParameters(contextArr, strArr2.length, dArrInitOutcomeTotals, strArr.length);
        this.modelType = AbstractModel.ModelType.NaiveBayes;
    }

    private static double getProbability(double d, double d2, double d3, boolean z) {
        if (z) {
            return getSmoothedProbability(d, d2, d3);
        }
        if (d2 == 0.0d || d2 <= Double.MIN_VALUE) {
            return 0.0d;
        }
        return d / d2;
    }

    private static double getSmoothedProbability(double d, double d2, double d3) {
        return (d + 0.05d) / ((d3 * 0.05d) + d2);
    }

    @Override // opennlp.tools.p217ml.model.MaxentModel
    public double[] eval(String[] strArr) {
        return eval(strArr, new double[this.evalParams.getNumOutcomes()]);
    }

    public double[] initOutcomeTotals(String[] strArr, Context[] contextArr) {
        double[] dArr = new double[strArr.length];
        for (Context context : contextArr) {
            for (int i = 0; i < context.getOutcomes().length; i++) {
                int i2 = context.getOutcomes()[i];
                dArr[i2] = dArr[i2] + context.getParameters()[i];
            }
        }
        return dArr;
    }

    @Override // opennlp.tools.p217ml.model.MaxentModel
    public double[] eval(String[] strArr, float[] fArr) {
        return eval(strArr, fArr, new double[this.evalParams.getNumOutcomes()]);
    }

    @Override // opennlp.tools.p217ml.model.MaxentModel
    public double[] eval(String[] strArr, double[] dArr) {
        return eval(strArr, (float[]) null, dArr);
    }

    public double[] eval(String[] strArr, float[] fArr, double[] dArr) {
        Context[] contextArr = new Context[strArr.length];
        Arrays.fill(dArr, 0.0d);
        for (int i = 0; i < strArr.length; i++) {
            contextArr[i] = this.pmap.get(strArr[i]);
        }
        return eval(contextArr, fArr, dArr, this.evalParams, true);
    }

    public NaiveBayesModel(Context[] contextArr, String[] strArr, String[] strArr2) {
        super(contextArr, strArr, strArr2);
        double[] dArrInitOutcomeTotals = initOutcomeTotals(strArr2, contextArr);
        this.outcomeTotals = dArrInitOutcomeTotals;
        this.evalParams = new NaiveBayesEvalParameters(contextArr, strArr2.length, dArrInitOutcomeTotals, strArr.length);
        this.modelType = AbstractModel.ModelType.NaiveBayes;
    }

    public static double[] eval(int[] iArr, double[] dArr, EvalParameters evalParameters) {
        return eval(iArr, (float[]) null, dArr, evalParameters, true);
    }

    public static double[] eval(Context[] contextArr, float[] fArr, double[] dArr, EvalParameters evalParameters, boolean z) {
        double d;
        Context[] contextArr2 = contextArr;
        LogProbabilities logProbabilities = new LogProbabilities();
        boolean z2 = evalParameters instanceof NaiveBayesEvalParameters;
        double[] outcomeTotals = z2 ? ((NaiveBayesEvalParameters) evalParameters).getOutcomeTotals() : new double[dArr.length];
        long vocabulary = z2 ? ((NaiveBayesEvalParameters) evalParameters).getVocabulary() : 0L;
        double d2 = 1.0d;
        int i = 0;
        while (i < contextArr2.length) {
            Context context = contextArr2[i];
            if (context != null) {
                double[] parameters = context.getParameters();
                if (fArr != null) {
                    d2 = fArr[i];
                }
                int i2 = 0;
                int i4 = 0;
                for (int[] outcomes = context.getOutcomes(); i4 < outcomeTotals.length && i2 < outcomes.length; outcomes = outcomes) {
                    if (outcomes[i2] == i4) {
                        d = parameters[i2] * d2;
                        i2++;
                    } else {
                        d = 0.0d;
                    }
                    logProbabilities.addIn(Integer.valueOf(i4), getProbability(d, outcomeTotals[i4], vocabulary, true), 1);
                    i4++;
                }
            }
            i++;
            contextArr2 = contextArr;
        }
        double d3 = 0.0d;
        for (double d4 : outcomeTotals) {
            d3 += d4;
        }
        for (int i5 = 0; i5 < outcomeTotals.length; i5++) {
            logProbabilities.addIn(Integer.valueOf(i5), outcomeTotals[i5] / d3, 1);
        }
        for (int i6 = 0; i6 < outcomeTotals.length; i6++) {
            dArr[i6] = logProbabilities.get(Integer.valueOf(i6)).doubleValue();
        }
        return dArr;
    }

    public static double[] eval(int[] iArr, float[] fArr, double[] dArr, EvalParameters evalParameters, boolean z) {
        Context[] contextArr = new Context[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            contextArr[i] = evalParameters.getParams()[iArr[i]];
        }
        return eval(contextArr, fArr, dArr, evalParameters, z);
    }
}
