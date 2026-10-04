package org.apache.commons.text.similarity;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class LevenshteinDistance implements EditDistance<Integer> {
    private static final LevenshteinDistance INSTANCE = new LevenshteinDistance();
    private final Integer threshold;

    @Deprecated
    public LevenshteinDistance() {
        this(null);
    }

    public static LevenshteinDistance getDefaultInstance() {
        return INSTANCE;
    }

    private static <E> int limitedCompare(SimilarityInput<E> similarityInput, SimilarityInput<E> similarityInput2, int i) {
        int i2;
        int length;
        SimilarityInput<E> similarityInput3;
        SimilarityInput<E> similarityInput4;
        if (similarityInput == null || similarityInput2 == null) {
            throw new IllegalArgumentException("CharSequences must not be null");
        }
        if (i < 0) {
            throw new IllegalArgumentException("Threshold must not be negative");
        }
        int length2 = similarityInput.length();
        int length3 = similarityInput2.length();
        int i4 = -1;
        if (length2 == 0) {
            if (length3 <= i) {
                return length3;
            }
            return -1;
        }
        if (length3 == 0) {
            if (length2 <= i) {
                return length2;
            }
            return -1;
        }
        if (length2 > length3) {
            length = similarityInput.length();
            i2 = length3;
            similarityInput4 = similarityInput;
            similarityInput3 = similarityInput2;
        } else {
            i2 = length2;
            length = length3;
            similarityInput3 = similarityInput;
            similarityInput4 = similarityInput2;
        }
        if (length - i2 > i) {
            return -1;
        }
        int i5 = i2 + 1;
        int[] iArr = new int[i5];
        int[] iArr2 = new int[i5];
        int i6 = 1;
        int iMin = Math.min(i2, i) + 1;
        char c = 0;
        for (int i7 = 0; i7 < iMin; i7++) {
            iArr[i7] = i7;
        }
        Arrays.fill(iArr, iMin, i5, Integer.MAX_VALUE);
        Arrays.fill(iArr2, Integer.MAX_VALUE);
        int i8 = 1;
        while (i8 <= length) {
            E eMo14963at = similarityInput4.mo14963at(i8 - 1);
            iArr2[c] = i8;
            int iMax = Math.max(i6, i8 - i);
            int iMin2 = i8 > Integer.MAX_VALUE - i ? i2 : Math.min(i2, i8 + i);
            if (iMax > i6) {
                iArr2[iMax - 1] = Integer.MAX_VALUE;
            }
            int iMin3 = Integer.MAX_VALUE;
            while (iMax <= iMin2) {
                int i9 = i4;
                int i10 = iMax - 1;
                int i11 = i6;
                if (similarityInput3.mo14963at(i10).equals(eMo14963at)) {
                    iArr2[iMax] = iArr[i10];
                } else {
                    iArr2[iMax] = Math.min(Math.min(iArr2[i10], iArr[iMax]), iArr[i10]) + 1;
                }
                iMin3 = Math.min(iMin3, iArr2[iMax]);
                iMax++;
                i6 = i11;
                i4 = i9;
            }
            int i12 = i4;
            int i13 = i6;
            if (iMin3 > i) {
                return i12;
            }
            i8++;
            int[] iArr3 = iArr2;
            iArr2 = iArr;
            iArr = iArr3;
            i6 = i13;
            i4 = i12;
            c = 0;
        }
        int i14 = i4;
        int i15 = iArr[i2];
        return i15 <= i ? i15 : i14;
    }

    private static <E> int unlimitedCompare(SimilarityInput<E> similarityInput, SimilarityInput<E> similarityInput2) {
        if (similarityInput == null || similarityInput2 == null) {
            throw new IllegalArgumentException("CharSequences must not be null");
        }
        int length = similarityInput.length();
        int length2 = similarityInput2.length();
        if (length == 0) {
            return length2;
        }
        if (length2 == 0) {
            return length;
        }
        if (length > length2) {
            length2 = similarityInput.length();
            length = length2;
        } else {
            similarityInput2 = similarityInput;
            similarityInput = similarityInput2;
        }
        int[] iArr = new int[length + 1];
        for (int i = 0; i <= length; i++) {
            iArr[i] = i;
        }
        for (int i2 = 1; i2 <= length2; i2++) {
            int i4 = iArr[0];
            E eMo14963at = similarityInput.mo14963at(i2 - 1);
            iArr[0] = i2;
            int i5 = 1;
            while (i5 <= length) {
                int i6 = iArr[i5];
                int i7 = i5 - 1;
                iArr[i5] = Math.min(Math.min(iArr[i7] + 1, iArr[i5] + 1), i4 + (!similarityInput2.mo14963at(i7).equals(eMo14963at) ? 1 : 0));
                i5++;
                i4 = i6;
            }
        }
        return iArr[length];
    }

    public Integer getThreshold() {
        return this.threshold;
    }

    public LevenshteinDistance(Integer num) {
        if (num != null && num.intValue() < 0) {
            throw new IllegalArgumentException("Threshold must not be negative");
        }
        this.threshold = num;
    }

    @Override // org.apache.commons.text.similarity.SimilarityScore, org.apache.commons.text.similarity.ObjectSimilarityScore, java.util.function.BiFunction
    public Integer apply(CharSequence charSequence, CharSequence charSequence2) {
        return apply((SimilarityInput) SimilarityInput.input(charSequence), (SimilarityInput) SimilarityInput.input(charSequence2));
    }

    public <E> Integer apply(SimilarityInput<E> similarityInput, SimilarityInput<E> similarityInput2) {
        Integer num = this.threshold;
        if (num != null) {
            return Integer.valueOf(limitedCompare(similarityInput, similarityInput2, num.intValue()));
        }
        return Integer.valueOf(unlimitedCompare(similarityInput, similarityInput2));
    }
}
