package opennlp.tools.p217ml.model;

import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class EvalParameters {
    private double correctionConstant;
    private final int numOutcomes;
    private final Context[] params;

    public EvalParameters(Context[] contextArr, int i) {
        this.params = contextArr;
        this.numOutcomes = i;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof EvalParameters) {
            EvalParameters evalParameters = (EvalParameters) obj;
            if (Arrays.equals(this.params, evalParameters.params) && this.numOutcomes == evalParameters.numOutcomes && this.correctionConstant == evalParameters.correctionConstant) {
                return true;
            }
        }
        return false;
    }

    public int getNumOutcomes() {
        return this.numOutcomes;
    }

    public Context[] getParams() {
        return this.params;
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(Arrays.hashCode(this.params)), Integer.valueOf(this.numOutcomes), Double.valueOf(this.correctionConstant));
    }
}
