package opennlp.tools.p217ml.model;

import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class Context {
    protected final int[] outcomes;
    protected final double[] parameters;

    public Context(int[] iArr, double[] dArr) {
        this.outcomes = iArr;
        this.parameters = dArr;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Context) {
            Context context = (Context) obj;
            if (Arrays.equals(this.parameters, context.parameters) && Arrays.equals(this.outcomes, context.outcomes)) {
                return true;
            }
        }
        return false;
    }

    public int[] getOutcomes() {
        return this.outcomes;
    }

    public double[] getParameters() {
        return this.parameters;
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(Arrays.hashCode(this.parameters)), Integer.valueOf(Arrays.hashCode(this.outcomes)));
    }
}
