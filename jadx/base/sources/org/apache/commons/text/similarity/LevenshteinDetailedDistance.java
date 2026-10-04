package org.apache.commons.text.similarity;

import java.lang.reflect.Array;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class LevenshteinDetailedDistance implements EditDistance<LevenshteinResults> {
    private static final LevenshteinDetailedDistance INSTANCE = new LevenshteinDetailedDistance();
    private final Integer threshold;

    @Deprecated
    public LevenshteinDetailedDistance() {
        this(null);
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x006a A[PHI: r0 r1
      0x006a: PHI (r0v6 int) = (r0v3 int), (r0v1 int) binds: [B:42:0x007f, B:33:0x0068] A[DONT_GENERATE, DONT_INLINE]
      0x006a: PHI (r1v5 int) = (r1v1 int), (r1v6 int) binds: [B:42:0x007f, B:33:0x0068] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x006e A[PHI: r0 r1
      0x006e: PHI (r0v4 int) = (r0v3 int), (r0v1 int) binds: [B:42:0x007f, B:33:0x0068] A[DONT_GENERATE, DONT_INLINE]
      0x006e: PHI (r1v3 int) = (r1v1 int), (r1v6 int) binds: [B:42:0x007f, B:33:0x0068] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static <E> LevenshteinResults findDetailedResults(SimilarityInput<E> similarityInput, SimilarityInput<E> similarityInput2, int[][] iArr, boolean z) {
        boolean z2;
        int length = similarityInput2.length();
        int length2 = similarityInput.length();
        int i = 0;
        int i2 = 0;
        int i4 = 0;
        while (length >= 0 && length2 >= 0) {
            int i5 = length2 == 0 ? -1 : iArr[length][length2 - 1];
            int i6 = length == 0 ? -1 : iArr[length - 1][length2];
            int i7 = (length <= 0 || length2 <= 0) ? -1 : iArr[length - 1][length2 - 1];
            if (i5 == -1 && i6 == -1 && i7 == -1) {
                break;
            }
            int i8 = iArr[length][length2];
            if (length2 <= 0 || length <= 0 || !similarityInput.mo14963at(length2 - 1).equals(similarityInput2.mo14963at(length - 1))) {
                int i9 = i8 - 1;
                boolean z3 = true;
                if ((i9 == i5 && i8 <= i7 && i8 <= i6) || (i7 == -1 && i6 == -1)) {
                    length2--;
                    if (z) {
                    }
                } else if ((i9 != i6 || i8 > i7 || i8 > i5) && !(i7 == -1 && i5 == -1)) {
                    z2 = false;
                    z3 = false;
                } else {
                    length--;
                    if (z) {
                        i++;
                        z2 = true;
                        z3 = false;
                    } else {
                        i2++;
                        z2 = false;
                    }
                }
                if (!z3 && !z2) {
                    i4++;
                }
            }
            length2--;
            length--;
        }
        return new LevenshteinResults(Integer.valueOf(i2 + i + i4), Integer.valueOf(i2), Integer.valueOf(i), Integer.valueOf(i4));
    }

    public static LevenshteinDetailedDistance getDefaultInstance() {
        return INSTANCE;
    }

    private static <E> LevenshteinResults limitedCompare(SimilarityInput<E> similarityInput, SimilarityInput<E> similarityInput2, int i) {
        boolean z;
        int i2;
        int length;
        SimilarityInput<E> similarityInput3;
        SimilarityInput<E> similarityInput4;
        char c = 0;
        if (similarityInput == null || similarityInput2 == null) {
            throw new IllegalArgumentException("CharSequences must not be null");
        }
        if (i < 0) {
            throw new IllegalArgumentException("Threshold must not be negative");
        }
        int length2 = similarityInput.length();
        int length3 = similarityInput2.length();
        if (length2 == 0) {
            return length3 <= i ? new LevenshteinResults(Integer.valueOf(length3), Integer.valueOf(length3), 0, 0) : new LevenshteinResults(-1, 0, 0, 0);
        }
        if (length3 == 0) {
            return length2 <= i ? new LevenshteinResults(Integer.valueOf(length2), 0, Integer.valueOf(length2), 0) : new LevenshteinResults(-1, 0, 0, 0);
        }
        int i4 = 1;
        if (length2 > length3) {
            length = similarityInput.length();
            i2 = length3;
            z = true;
            similarityInput4 = similarityInput;
            similarityInput3 = similarityInput2;
        } else {
            z = false;
            i2 = length2;
            length = length3;
            similarityInput3 = similarityInput;
            similarityInput4 = similarityInput2;
        }
        int i5 = i2 + 1;
        int[] iArr = new int[i5];
        int[] iArr2 = new int[i5];
        int[][] iArr3 = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, length + 1, i5);
        for (int i6 = 0; i6 <= i2; i6++) {
            iArr3[0][i6] = i6;
        }
        for (int i7 = 0; i7 <= length; i7++) {
            iArr3[i7][0] = i7;
        }
        int iMin = Math.min(i2, i) + 1;
        for (int i8 = 0; i8 < iMin; i8++) {
            iArr[i8] = i8;
        }
        int i9 = Integer.MAX_VALUE;
        Arrays.fill(iArr, iMin, i5, Integer.MAX_VALUE);
        Arrays.fill(iArr2, Integer.MAX_VALUE);
        int i10 = 1;
        while (i10 <= length) {
            E eMo14963at = similarityInput4.mo14963at(i10 - 1);
            iArr2[c] = i10;
            int iMax = Math.max(i4, i10 - i);
            int i11 = i9;
            int iMin2 = i10 > i11 - i ? i2 : Math.min(i2, i10 + i);
            if (iMax > iMin2) {
                return new LevenshteinResults(-1, 0, 0, 0);
            }
            if (iMax > i4) {
                iArr2[iMax - 1] = i11;
            }
            while (iMax <= iMin2) {
                int i12 = i4;
                int i13 = iMax - 1;
                int i14 = iMax;
                if (similarityInput3.mo14963at(i13).equals(eMo14963at)) {
                    iArr2[i14] = iArr[i13];
                } else {
                    iArr2[i14] = Math.min(Math.min(iArr2[i13], iArr[i14]), iArr[i13]) + 1;
                }
                iArr3[i10][i14] = iArr2[i14];
                iMax = i14 + 1;
                i4 = i12;
            }
            i10++;
            int[] iArr4 = iArr2;
            iArr2 = iArr;
            iArr = iArr4;
            i9 = i11;
            c = 0;
        }
        return iArr[i2] <= i ? findDetailedResults(similarityInput3, similarityInput4, iArr3, z) : new LevenshteinResults(-1, 0, 0, 0);
    }

    private static <E> LevenshteinResults unlimitedCompare(SimilarityInput<E> similarityInput, SimilarityInput<E> similarityInput2) {
        boolean z;
        int i;
        int length;
        SimilarityInput<E> similarityInput3;
        SimilarityInput<E> similarityInput4;
        char c = 0;
        if (similarityInput == null || similarityInput2 == null) {
            throw new IllegalArgumentException("CharSequences must not be null");
        }
        int length2 = similarityInput.length();
        int length3 = similarityInput2.length();
        if (length2 == 0) {
            return new LevenshteinResults(Integer.valueOf(length3), Integer.valueOf(length3), 0, 0);
        }
        if (length3 == 0) {
            return new LevenshteinResults(Integer.valueOf(length2), 0, Integer.valueOf(length2), 0);
        }
        if (length2 > length3) {
            z = true;
            length = similarityInput.length();
            i = length3;
            similarityInput4 = similarityInput;
            similarityInput3 = similarityInput2;
        } else {
            z = false;
            i = length2;
            length = length3;
            similarityInput3 = similarityInput;
            similarityInput4 = similarityInput2;
        }
        int i2 = i + 1;
        int[] iArr = new int[i2];
        int[] iArr2 = new int[i2];
        int[][] iArr3 = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, length + 1, i2);
        for (int i4 = 0; i4 <= i; i4++) {
            iArr3[0][i4] = i4;
        }
        for (int i5 = 0; i5 <= length; i5++) {
            iArr3[i5][0] = i5;
        }
        for (int i6 = 0; i6 <= i; i6++) {
            iArr[i6] = i6;
        }
        int[] iArr4 = iArr;
        int[] iArr5 = iArr2;
        int i7 = 1;
        while (i7 <= length) {
            E eMo14963at = similarityInput4.mo14963at(i7 - 1);
            iArr5[c] = i7;
            for (int i8 = 1; i8 <= i; i8++) {
                int i9 = i8 - 1;
                int iMin = Math.min(Math.min(iArr5[i9] + 1, iArr4[i8] + 1), iArr4[i9] + (!similarityInput3.mo14963at(i9).equals(eMo14963at) ? 1 : 0));
                iArr5[i8] = iMin;
                iArr3[i7][i8] = iMin;
            }
            i7++;
            int[] iArr6 = iArr4;
            iArr4 = iArr5;
            iArr5 = iArr6;
            c = 0;
        }
        return findDetailedResults(similarityInput3, similarityInput4, iArr3, z);
    }

    public Integer getThreshold() {
        return this.threshold;
    }

    public LevenshteinDetailedDistance(Integer num) {
        if (num != null && num.intValue() < 0) {
            throw new IllegalArgumentException("Threshold must not be negative");
        }
        this.threshold = num;
    }

    @Override // org.apache.commons.text.similarity.SimilarityScore, org.apache.commons.text.similarity.ObjectSimilarityScore, java.util.function.BiFunction
    public LevenshteinResults apply(CharSequence charSequence, CharSequence charSequence2) {
        return apply((SimilarityInput) SimilarityInput.input(charSequence), (SimilarityInput) SimilarityInput.input(charSequence2));
    }

    public <E> LevenshteinResults apply(SimilarityInput<E> similarityInput, SimilarityInput<E> similarityInput2) {
        Integer num = this.threshold;
        if (num != null) {
            return limitedCompare(similarityInput, similarityInput2, num.intValue());
        }
        return unlimitedCompare(similarityInput, similarityInput2);
    }
}
