package opennlp.tools.p217ml.maxent;

import java.util.Objects;
import opennlp.tools.p217ml.ArrayMath;
import opennlp.tools.p217ml.model.AbstractModel;
import opennlp.tools.p217ml.model.Context;
import opennlp.tools.p217ml.model.EvalParameters;
import opennlp.tools.p217ml.model.Prior;
import opennlp.tools.p217ml.model.UniformPrior;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class GISModel extends AbstractModel {
    public GISModel(Context[] contextArr, String[] strArr, String[] strArr2) {
        this(contextArr, strArr, strArr2, new UniformPrior());
    }

    @Override // opennlp.tools.p217ml.model.AbstractModel
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof GISModel) {
            GISModel gISModel = (GISModel) obj;
            if (this.pmap.equals(gISModel.pmap) && Objects.deepEquals(this.outcomeNames, gISModel.outcomeNames) && Objects.equals(this.prior, gISModel.prior)) {
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
        return super.hashCode();
    }

    public GISModel(Context[] contextArr, String[] strArr, String[] strArr2, Prior prior) {
        super(contextArr, strArr, strArr2);
        this.prior = prior;
        prior.setLabels(strArr2, strArr);
        this.modelType = AbstractModel.ModelType.Maxent;
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
        for (int i = 0; i < strArr.length; i++) {
            contextArr[i] = this.pmap.get(strArr[i]);
        }
        this.prior.logPrior(dArr, contextArr, fArr);
        return eval(contextArr, fArr, dArr, this.evalParams);
    }

    public static double[] eval(int[] iArr, double[] dArr, EvalParameters evalParameters) {
        return eval(iArr, (float[]) null, dArr, evalParameters);
    }

    public static double[] eval(int[] iArr, float[] fArr, double[] dArr, EvalParameters evalParameters) {
        Context[] contextArr = new Context[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            contextArr[i] = evalParameters.getParams()[iArr[i]];
        }
        return eval(contextArr, fArr, dArr, evalParameters);
    }

    public static double[] eval(Context[] contextArr, float[] fArr, double[] dArr, EvalParameters evalParameters) {
        ArrayMath.sumFeatures(contextArr, fArr, dArr);
        double d = 0.0d;
        for (int i = 0; i < evalParameters.getNumOutcomes(); i++) {
            double dExp = StrictMath.exp(dArr[i]);
            dArr[i] = dExp;
            d += dExp;
        }
        for (int i2 = 0; i2 < evalParameters.getNumOutcomes(); i2++) {
            dArr[i2] = dArr[i2] / d;
        }
        return dArr;
    }
}
