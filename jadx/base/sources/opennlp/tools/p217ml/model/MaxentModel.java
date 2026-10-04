package opennlp.tools.p217ml.model;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public interface MaxentModel {
    double[] eval(String[] strArr);

    double[] eval(String[] strArr, double[] dArr);

    double[] eval(String[] strArr, float[] fArr);

    String getAllOutcomes(double[] dArr);

    String getBestOutcome(double[] dArr);

    int getIndex(String str);

    int getNumOutcomes();

    String getOutcome(int i);
}
