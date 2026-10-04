package org.apache.commons.text;

import java.util.HashSet;
import java.util.Set;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class CaseUtils {
    public static String toCamelCase(String str, boolean z, char... cArr) {
        if (StringUtils.isEmpty(str)) {
            return str;
        }
        String lowerCase = str.toLowerCase();
        int length = lowerCase.length();
        int[] iArr = new int[length];
        Set<Integer> delimiterSet = toDelimiterSet(cArr);
        boolean z2 = z;
        int iCharCount = 0;
        int i = 0;
        while (iCharCount < length) {
            int iCodePointAt = lowerCase.codePointAt(iCharCount);
            if (delimiterSet.contains(Integer.valueOf(iCodePointAt))) {
                z2 = i != 0;
                iCharCount = Character.charCount(iCodePointAt) + iCharCount;
            } else if (z2 || (i == 0 && z)) {
                int titleCase = Character.toTitleCase(iCodePointAt);
                int i2 = i + 1;
                iArr[i] = titleCase;
                int iCharCount2 = Character.charCount(titleCase) + iCharCount;
                z2 = false;
                iCharCount = iCharCount2;
                i = i2;
            } else {
                iArr[i] = iCodePointAt;
                iCharCount = Character.charCount(iCodePointAt) + iCharCount;
                i++;
            }
        }
        return new String(iArr, 0, i);
    }

    private static Set<Integer> toDelimiterSet(char[] cArr) {
        HashSet hashSet = new HashSet();
        hashSet.add(Integer.valueOf(Character.codePointAt(new char[]{' '}, 0)));
        if (!ArrayUtils.isEmpty(cArr)) {
            for (int i = 0; i < cArr.length; i++) {
                hashSet.add(Integer.valueOf(Character.codePointAt(cArr, i)));
            }
        }
        return hashSet;
    }
}
