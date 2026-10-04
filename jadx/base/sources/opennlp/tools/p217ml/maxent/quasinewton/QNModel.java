package opennlp.tools.p217ml.maxent.quasinewton;

import opennlp.tools.p217ml.ArrayMath;
import opennlp.tools.p217ml.model.AbstractModel;
import opennlp.tools.p217ml.model.Context;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class QNModel extends AbstractModel {
    public QNModel(Context[] contextArr, String[] strArr, String[] strArr2) {
        super(contextArr, strArr, strArr2);
        this.modelType = AbstractModel.ModelType.MaxentQn;
    }

    private Context getPredIndex(String str) {
        return this.pmap.get(str);
    }

    @Override // opennlp.tools.p217ml.model.MaxentModel
    public double[] eval(String[] strArr) {
        return eval(strArr, new double[this.evalParams.getNumOutcomes()]);
    }

    @Override // opennlp.tools.p217ml.model.AbstractModel, opennlp.tools.p217ml.model.MaxentModel
    public int getNumOutcomes() {
        return this.outcomeNames.length;
    }

    @Override // opennlp.tools.p217ml.model.MaxentModel
    public double[] eval(String[] strArr, double[] dArr) {
        return eval(strArr, null, dArr);
    }

    @Override // opennlp.tools.p217ml.model.MaxentModel
    public double[] eval(String[] strArr, float[] fArr) {
        return eval(strArr, fArr, new double[this.evalParams.getNumOutcomes()]);
    }

    private double[] eval(String[] strArr, float[] fArr, double[] dArr) {
        for (int i = 0; i < strArr.length; i++) {
            Context predIndex = getPredIndex(strArr[i]);
            if (predIndex != null) {
                double d = fArr != null ? fArr[i] : 1.0d;
                double[] parameters = predIndex.getParameters();
                int[] outcomes = predIndex.getOutcomes();
                for (int i2 = 0; i2 < outcomes.length; i2++) {
                    int i4 = outcomes[i2];
                    dArr[i4] = (parameters[i2] * d) + dArr[i4];
                }
            }
        }
        double dLogSumOfExps = ArrayMath.logSumOfExps(dArr);
        for (int i5 = 0; i5 < this.outcomeNames.length; i5++) {
            dArr[i5] = StrictMath.exp(dArr[i5] - dLogSumOfExps);
        }
        return dArr;
    }

    public static double[] eval(int[] iArr, float[] fArr, double[] dArr, int i, int i2, double[] dArr2) {
        for (int i4 = 0; i4 < iArr.length; i4++) {
            int i5 = iArr[i4];
            double d = fArr != null ? fArr[i4] : 1.0d;
            for (int i6 = 0; i6 < i; i6++) {
                dArr[i6] = (dArr2[(i6 * i2) + i5] * d) + dArr[i6];
            }
        }
        double dLogSumOfExps = ArrayMath.logSumOfExps(dArr);
        for (int i7 = 0; i7 < i; i7++) {
            dArr[i7] = StrictMath.exp(dArr[i7] - dLogSumOfExps);
        }
        return dArr;
    }
}
