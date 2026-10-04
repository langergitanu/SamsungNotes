package opennlp.tools.p217ml.model;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class DynamicEvalParameters {
    private final int numOutcomes;
    private final List<? extends Context> params;

    public DynamicEvalParameters(List<? extends Context> list, int i) {
        this.params = list;
        this.numOutcomes = i;
    }

    public int getNumOutcomes() {
        return this.numOutcomes;
    }

    public Context[] getParams() {
        return (Context[]) this.params.toArray(new Context[0]);
    }
}
