package opennlp.tools.util.featuregen;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public interface AdaptiveFeatureGenerator {
    void createFeatures(List<String> list, String[] strArr, int i, String[] strArr2);

    default void clearAdaptiveData() {
    }

    default void updateAdaptiveData(String[] strArr, String[] strArr2) {
    }
}
