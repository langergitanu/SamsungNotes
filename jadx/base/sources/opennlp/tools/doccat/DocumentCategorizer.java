package opennlp.tools.doccat;

import java.util.Map;
import java.util.Set;
import java.util.SortedMap;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public interface DocumentCategorizer {
    double[] categorize(String[] strArr);

    double[] categorize(String[] strArr, Map<String, Object> map);

    String getAllResults(double[] dArr);

    String getBestCategory(double[] dArr);

    String getCategory(int i);

    int getIndex(String str);

    int getNumberOfCategories();

    Map<String, Double> scoreMap(String[] strArr);

    SortedMap<Double, Set<String>> sortedScoreMap(String[] strArr);
}
