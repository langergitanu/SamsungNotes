package opennlp.tools.util.featuregen;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class BrownTokenClasses {
    public static final int[] pathLengths = {4, 6, 10, 20};

    public static List<String> getWordClasses(String str, BrownCluster brownCluster) {
        if (brownCluster.lookupToken(str) == null) {
            return Collections.EMPTY_LIST;
        }
        String strLookupToken = brownCluster.lookupToken(str);
        ArrayList arrayList = new ArrayList();
        arrayList.add(strLookupToken.substring(0, StrictMath.min(strLookupToken.length(), pathLengths[0])));
        int i = 1;
        while (true) {
            int[] iArr = pathLengths;
            if (i >= iArr.length) {
                return arrayList;
            }
            if (iArr[i - 1] < strLookupToken.length()) {
                arrayList.add(strLookupToken.substring(0, StrictMath.min(strLookupToken.length(), iArr[i])));
            }
            i++;
        }
    }
}
