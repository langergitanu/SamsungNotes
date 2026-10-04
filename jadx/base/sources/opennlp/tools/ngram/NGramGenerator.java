package opennlp.tools.ngram;

import androidx.glance.AbstractC2821a;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class NGramGenerator {
    public static List<String> generate(List<String> list, int i, String str) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < list.size() - (i - 1); i2++) {
            StringBuilder sb = new StringBuilder();
            int iM2213d = i2;
            while (iM2213d < i + i2) {
                iM2213d = AbstractC2821a.m2213d(sb, iM2213d, 1, list.get(iM2213d), str);
            }
            String string = sb.toString();
            arrayList.add(string.substring(0, string.lastIndexOf(str)));
        }
        return arrayList;
    }

    public static List<String> generate(char[] cArr, int i, String str) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < cArr.length - (i - 1); i2++) {
            StringBuilder sb = new StringBuilder();
            for (int i4 = i2; i4 < i + i2; i4++) {
                sb.append(cArr[i4]);
                sb.append(str);
            }
            String string = sb.toString();
            arrayList.add(string.substring(0, string.lastIndexOf(str)));
        }
        return arrayList;
    }
}
