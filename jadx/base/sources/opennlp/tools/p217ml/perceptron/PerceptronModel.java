package opennlp.tools.p217ml.perceptron;

import java.util.Arrays;
import java.util.Objects;
import opennlp.tools.p217ml.ArrayMath;
import opennlp.tools.p217ml.model.AbstractModel;
import opennlp.tools.p217ml.model.Context;
import opennlp.tools.p217ml.model.EvalParameters;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class PerceptronModel extends AbstractModel {
    public PerceptronModel(Context[] contextArr, String[] strArr, String[] strArr2) {
        super(contextArr, strArr, strArr2);
        this.modelType = AbstractModel.ModelType.Perceptron;
    }

    @Override // opennlp.tools.p217ml.model.AbstractModel
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof PerceptronModel) {
            PerceptronModel perceptronModel = (PerceptronModel) obj;
            if (Objects.deepEquals(this.outcomeNames, perceptronModel.outcomeNames) && Objects.equals(this.prior, perceptronModel.prior)) {
                return true;
            }
        }
        return false;
    }

    @Override // opennlp.tools.p217ml.model.MaxentModel
    public double[] eval(String[] strArr) {
        return eval(strArr, new double[this.evalParams.getNumOutcomes()]);
    }

    @Override // opennlp.tools.p217ml.model.AbstractModel
    public int hashCode() {
        return Objects.hash(Integer.valueOf(Arrays.hashCode(this.outcomeNames)), this.evalParams, this.prior);
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

    public static double[] eval(int[] iArr, double[] dArr, EvalParameters evalParameters) {
        return eval(iArr, (float[]) null, dArr, evalParameters, true);
    }

    public static double[] eval(int[] iArr, float[] fArr, double[] dArr, EvalParameters evalParameters, boolean z) {
        Context[] contextArr = new Context[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            contextArr[i] = evalParameters.getParams()[iArr[i]];
        }
        return eval(contextArr, fArr, dArr, evalParameters, z);
    }

    public static double[] eval(Context[] contextArr, float[] fArr, double[] dArr, EvalParameters evalParameters, boolean z) {
        ArrayMath.sumFeatures(contextArr, fArr, dArr);
        if (z) {
            int numOutcomes = evalParameters.getNumOutcomes();
            double dAbs = 1.0d;
            for (int i = 0; i < numOutcomes; i++) {
                if (dAbs < StrictMath.abs(dArr[i])) {
                    dAbs = StrictMath.abs(dArr[i]);
                }
            }
            double d = 0.0d;
            for (int i2 = 0; i2 < numOutcomes; i2++) {
                double dExp = StrictMath.exp(dArr[i2] / dAbs);
                dArr[i2] = dExp;
                d += dExp;
            }
            for (int i4 = 0; i4 < numOutcomes; i4++) {
                dArr[i4] = dArr[i4] / d;
            }
        }
        return dArr;
    }
}
