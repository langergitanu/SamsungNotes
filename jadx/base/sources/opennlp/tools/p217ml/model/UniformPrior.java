package opennlp.tools.p217ml.model;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class UniformPrior implements Prior {
    private int numOutcomes;

    /* JADX INFO: renamed from: r */
    private double f9678r;

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof UniformPrior) {
            UniformPrior uniformPrior = (UniformPrior) obj;
            if (this.numOutcomes == uniformPrior.numOutcomes && this.f9678r == uniformPrior.f9678r) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.numOutcomes), Double.valueOf(this.f9678r));
    }

    @Override // opennlp.tools.p217ml.model.Prior
    public void logPrior(double[] dArr, int[] iArr, float[] fArr) {
        for (int i = 0; i < this.numOutcomes; i++) {
            dArr[i] = this.f9678r;
        }
    }

    @Override // opennlp.tools.p217ml.model.Prior
    public void setLabels(String[] strArr, String[] strArr2) {
        int length = strArr.length;
        this.numOutcomes = length;
        this.f9678r = StrictMath.log(1.0d / ((double) length));
    }

    @Override // opennlp.tools.p217ml.model.Prior
    public void logPrior(double[] dArr, Context[] contextArr, float[] fArr) {
        logPrior(dArr, (int[]) null, fArr);
    }

    @Override // opennlp.tools.p217ml.model.Prior
    public void logPrior(double[] dArr, int[] iArr) {
        logPrior(dArr, iArr, (float[]) null);
    }
}
