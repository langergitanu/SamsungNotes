package opennlp.tools.p217ml.maxent.quasinewton;

import java.util.Arrays;
import opennlp.tools.p217ml.ArrayMath;
import opennlp.tools.p217ml.model.DataIndexer;
import opennlp.tools.p217ml.model.OnePassRealValueDataIndexer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class NegLogLikelihood implements Function {
    protected final int[][] contexts;
    protected final int dimension;
    protected final double[] expectation;
    protected final double[] gradient;
    protected final int numContexts;
    protected final int numFeatures;
    protected final int numOutcomes;
    protected final int[] numTimesEventsSeen;
    protected final int[] outcomeList;
    protected final double[] tempSums;
    protected final float[][] values;

    public NegLogLikelihood(DataIndexer dataIndexer) {
        if (dataIndexer instanceof OnePassRealValueDataIndexer) {
            this.values = dataIndexer.getValues();
        } else {
            this.values = null;
        }
        int[][] contexts = dataIndexer.getContexts();
        this.contexts = contexts;
        this.outcomeList = dataIndexer.getOutcomeList();
        this.numTimesEventsSeen = dataIndexer.getNumTimesEventsSeen();
        int length = dataIndexer.getOutcomeLabels().length;
        this.numOutcomes = length;
        int length2 = dataIndexer.getPredLabels().length;
        this.numFeatures = length2;
        this.numContexts = contexts.length;
        int i = length2 * length;
        this.dimension = i;
        this.expectation = new double[length];
        this.tempSums = new double[length];
        this.gradient = new double[i];
    }

    @Override // opennlp.tools.p217ml.maxent.quasinewton.Function
    public int getDimension() {
        return this.dimension;
    }

    public double[] getInitialPoint() {
        return new double[this.dimension];
    }

    @Override // opennlp.tools.p217ml.maxent.quasinewton.Function
    public double[] gradientAt(double[] dArr) {
        if (dArr.length != this.dimension) {
            throw new IllegalArgumentException("x is invalid, its dimension is not equal to the function.");
        }
        double d = 0.0d;
        Arrays.fill(this.gradient, 0.0d);
        int i = 0;
        while (i < this.numContexts) {
            for (int i2 = 0; i2 < this.numOutcomes; i2++) {
                this.expectation[i2] = d;
                int i4 = 0;
                while (true) {
                    int[] iArr = this.contexts[i];
                    if (i4 < iArr.length) {
                        int iIndexOf = indexOf(i2, iArr[i4]);
                        double d2 = this.values != null ? r11[i][i4] : 1.0d;
                        double[] dArr2 = this.expectation;
                        dArr2[i2] = (d2 * dArr[iIndexOf]) + dArr2[i2];
                        i4++;
                    }
                }
            }
            double dLogSumOfExps = ArrayMath.logSumOfExps(this.expectation);
            for (int i5 = 0; i5 < this.numOutcomes; i5++) {
                double[] dArr3 = this.expectation;
                dArr3[i5] = StrictMath.exp(dArr3[i5] - dLogSumOfExps);
            }
            int i6 = 0;
            while (i6 < this.numOutcomes) {
                int i7 = this.outcomeList[i] == i6 ? 1 : 0;
                int i8 = 0;
                while (true) {
                    int[] iArr2 = this.contexts[i];
                    if (i8 < iArr2.length) {
                        int iIndexOf2 = indexOf(i6, iArr2[i8]);
                        double d3 = this.values != null ? r12[i][i8] : 1.0d;
                        double[] dArr4 = this.gradient;
                        dArr4[iIndexOf2] = ((this.expectation[i6] - ((double) i7)) * d3 * ((double) this.numTimesEventsSeen[i])) + dArr4[iIndexOf2];
                        i8++;
                    }
                }
                i6++;
            }
            i++;
            d = 0.0d;
        }
        return this.gradient;
    }

    public int indexOf(int i, int i2) {
        return (i * this.numFeatures) + i2;
    }

    @Override // opennlp.tools.p217ml.maxent.quasinewton.Function
    public double valueAt(double[] dArr) {
        if (dArr.length != this.dimension) {
            throw new IllegalArgumentException("x is invalid, its dimension is not equal to domain dimension.");
        }
        double dLogSumOfExps = 0.0d;
        for (int i = 0; i < this.numContexts; i++) {
            for (int i2 = 0; i2 < this.numOutcomes; i2++) {
                this.tempSums[i2] = 0.0d;
                int i4 = 0;
                while (true) {
                    int[] iArr = this.contexts[i];
                    if (i4 < iArr.length) {
                        int iIndexOf = indexOf(i2, iArr[i4]);
                        double d = this.values != null ? r11[i][i4] : 1.0d;
                        double[] dArr2 = this.tempSums;
                        dArr2[i2] = (d * dArr[iIndexOf]) + dArr2[i2];
                        i4++;
                    }
                }
            }
            dLogSumOfExps -= (this.tempSums[this.outcomeList[i]] - ArrayMath.logSumOfExps(this.tempSums)) * ((double) this.numTimesEventsSeen[i]);
        }
        return dLogSumOfExps;
    }
}
