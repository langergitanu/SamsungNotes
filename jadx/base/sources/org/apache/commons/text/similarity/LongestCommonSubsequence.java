package org.apache.commons.text.similarity;

import java.lang.reflect.Array;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class LongestCommonSubsequence implements SimilarityScore<Integer> {
    static final LongestCommonSubsequence INSTANCE = new LongestCommonSubsequence();

    private static int[] algorithmB(CharSequence charSequence, CharSequence charSequence2) {
        int length = charSequence.length();
        int length2 = charSequence2.length();
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, 2, length2 + 1);
        for (int i = 1; i <= length; i++) {
            int[] iArr2 = iArr[0];
            iArr[0] = iArr[1];
            iArr[1] = iArr2;
            for (int i2 = 1; i2 <= length2; i2++) {
                int i4 = i2 - 1;
                if (charSequence.charAt(i - 1) == charSequence2.charAt(i4)) {
                    iArr[1][i2] = iArr[0][i4] + 1;
                } else {
                    int[] iArr3 = iArr[1];
                    iArr3[i2] = Math.max(iArr3[i4], iArr[0][i2]);
                }
            }
        }
        return iArr[1];
    }

    private static String algorithmC(CharSequence charSequence, CharSequence charSequence2) {
        int length = charSequence.length();
        int length2 = charSequence2.length();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        if (length == 1) {
            char cCharAt = charSequence.charAt(0);
            while (true) {
                if (i >= length2) {
                    break;
                }
                if (cCharAt == charSequence2.charAt(i)) {
                    sb.append(cCharAt);
                    break;
                }
                i++;
            }
        } else if (length2 > 0 && length > 1) {
            int i2 = length / 2;
            CharSequence charSequenceSubSequence = charSequence.subSequence(0, i2);
            CharSequence charSequenceSubSequence2 = charSequence.subSequence(i2, length);
            int[] iArrAlgorithmB = algorithmB(charSequenceSubSequence, charSequence2);
            int[] iArrAlgorithmB2 = algorithmB(reverse(charSequenceSubSequence2), reverse(charSequence2));
            int i4 = 0;
            int i5 = 0;
            for (int i6 = 0; i6 <= length2; i6++) {
                int i7 = iArrAlgorithmB[i6] + iArrAlgorithmB2[length2 - i6];
                if (i5 < i7) {
                    i4 = i6;
                    i5 = i7;
                }
            }
            sb.append(algorithmC(charSequenceSubSequence, charSequence2.subSequence(0, i4)));
            sb.append(algorithmC(charSequenceSubSequence2, charSequence2.subSequence(i4, length2)));
        }
        return sb.toString();
    }

    private static String reverse(CharSequence charSequence) {
        return new StringBuilder(charSequence).reverse().toString();
    }

    @Deprecated
    public CharSequence logestCommonSubsequence(CharSequence charSequence, CharSequence charSequence2) {
        return longestCommonSubsequence(charSequence, charSequence2);
    }

    public CharSequence longestCommonSubsequence(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence == null || charSequence2 == null) {
            throw new IllegalArgumentException("Inputs must not be null");
        }
        int length = charSequence.length();
        int length2 = charSequence2.length();
        return (length == 0 || length2 == 0) ? "" : length < length2 ? algorithmC(charSequence2, charSequence) : algorithmC(charSequence, charSequence2);
    }

    @Deprecated
    public int[][] longestCommonSubstringLengthArray(CharSequence charSequence, CharSequence charSequence2) {
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, charSequence.length() + 1, charSequence2.length() + 1);
        for (int i = 0; i < charSequence.length(); i++) {
            for (int i2 = 0; i2 < charSequence2.length(); i2++) {
                if (i == 0) {
                    iArr[i][i2] = 0;
                }
                if (i2 == 0) {
                    iArr[i][i2] = 0;
                }
                if (charSequence.charAt(i) == charSequence2.charAt(i2)) {
                    iArr[i + 1][i2 + 1] = iArr[i][i2] + 1;
                } else {
                    int[] iArr2 = iArr[i + 1];
                    int i4 = i2 + 1;
                    iArr2[i4] = Math.max(iArr2[i2], iArr[i][i4]);
                }
            }
        }
        return iArr;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // org.apache.commons.text.similarity.SimilarityScore, org.apache.commons.text.similarity.ObjectSimilarityScore, java.util.function.BiFunction
    public Integer apply(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence != null && charSequence2 != null) {
            int length = charSequence.length();
            int length2 = charSequence2.length();
            if (length == 0 || length2 == 0) {
                return 0;
            }
            if (length < length2) {
                return Integer.valueOf(algorithmB(charSequence2, charSequence)[length]);
            }
            return Integer.valueOf(algorithmB(charSequence, charSequence2)[length2]);
        }
        throw new IllegalArgumentException("Inputs must not be null");
    }
}
