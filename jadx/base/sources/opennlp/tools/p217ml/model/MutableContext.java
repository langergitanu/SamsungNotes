package opennlp.tools.p217ml.model;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class MutableContext extends Context {
    public MutableContext(int[] iArr, double[] dArr) {
        super(iArr, dArr);
    }

    public boolean contains(int i) {
        return Arrays.binarySearch(this.outcomes, i) >= 0;
    }

    public void setParameter(int i, double d) {
        this.parameters[i] = d;
    }

    public void updateParameter(int i, double d) {
        double[] dArr = this.parameters;
        dArr[i] = dArr[i] + d;
    }
}
