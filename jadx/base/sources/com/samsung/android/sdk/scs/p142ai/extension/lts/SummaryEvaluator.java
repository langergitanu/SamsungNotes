package com.samsung.android.sdk.scs.p142ai.extension.lts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
class SummaryEvaluator {
    public static double calculateCompression(String str, String str2) {
        String[] strArrNormalizeAndTokenize = normalizeAndTokenize(str);
        String[] strArrNormalizeAndTokenize2 = normalizeAndTokenize(str2);
        if (strArrNormalizeAndTokenize2.length == 0) {
            return 0.0d;
        }
        if (strArrNormalizeAndTokenize2.length == 1 && strArrNormalizeAndTokenize2[0].isEmpty()) {
            return 0.0d;
        }
        return ((double) strArrNormalizeAndTokenize.length) / ((double) strArrNormalizeAndTokenize2.length);
    }

    public static double calculateCoverage(String str, String str2) {
        HashSet hashSet = new HashSet(Arrays.asList(normalizeAndTokenize(str)));
        String[] strArrNormalizeAndTokenize = normalizeAndTokenize(str2);
        int i = 0;
        for (String str3 : strArrNormalizeAndTokenize) {
            if (hashSet.contains(str3)) {
                i++;
            }
        }
        if (strArrNormalizeAndTokenize.length == 0) {
            return 0.0d;
        }
        return ((double) i) / ((double) strArrNormalizeAndTokenize.length);
    }

    public static double calculateDensity(String str, String str2) {
        String[] strArrNormalizeAndTokenize = normalizeAndTokenize(str);
        String[] strArrNormalizeAndTokenize2 = normalizeAndTokenize(str2);
        ArrayList arrayList = new ArrayList();
        boolean[] zArr = new boolean[strArrNormalizeAndTokenize.length];
        int i = 0;
        for (String str3 : strArrNormalizeAndTokenize2) {
            int i2 = 0;
            while (true) {
                if (i2 >= strArrNormalizeAndTokenize.length || (str3.equals(strArrNormalizeAndTokenize[i2]) && zArr[i2])) {
                    break;
                }
                if (str3.equals(strArrNormalizeAndTokenize[i2]) && !zArr[i2]) {
                    arrayList.add(Integer.valueOf(i2));
                    zArr[i2] = true;
                    break;
                }
                i2++;
            }
        }
        if (!arrayList.isEmpty()) {
            int i4 = 1;
            for (int i5 = 1; i5 < arrayList.size(); i5++) {
                if (((Integer) arrayList.get(i5)).intValue() == ((Integer) arrayList.get(i5 - 1)).intValue() + 1) {
                    i4++;
                } else {
                    i = (i4 * i4) + i;
                    i4 = 1;
                }
            }
            i += i4 * i4;
        }
        if (strArrNormalizeAndTokenize2.length == 0) {
            return 0.0d;
        }
        return ((double) i) / ((double) strArrNormalizeAndTokenize2.length);
    }

    public static String[] normalizeAndTokenize(String str) {
        if (str == null || str.trim().isEmpty()) {
            return new String[0];
        }
        String strTrim = str.toLowerCase().replaceAll("[^\\p{L}\\p{N}\\s]", "").trim();
        return strTrim.isEmpty() ? new String[0] : strTrim.split("\\s+");
    }
}
