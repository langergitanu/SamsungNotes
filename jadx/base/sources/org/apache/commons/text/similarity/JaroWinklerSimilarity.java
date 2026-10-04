package org.apache.commons.text.similarity;

import androidx.compose.runtime.AbstractC1974b;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class JaroWinklerSimilarity implements SimilarityScore<Double> {
    static final JaroWinklerSimilarity INSTANCE = new JaroWinklerSimilarity();

    public static int[] matches(CharSequence charSequence, CharSequence charSequence2) {
        return matches(SimilarityInput.input(charSequence), SimilarityInput.input(charSequence2));
    }

    public static <E> int[] matches(SimilarityInput<E> similarityInput, SimilarityInput<E> similarityInput2) {
        SimilarityInput<E> similarityInput3;
        SimilarityInput<E> similarityInput4;
        if (similarityInput.length() > similarityInput2.length()) {
            similarityInput4 = similarityInput;
            similarityInput3 = similarityInput2;
        } else {
            similarityInput3 = similarityInput;
            similarityInput4 = similarityInput2;
        }
        int iMax = Math.max((similarityInput4.length() / 2) - 1, 0);
        int[] iArr = new int[similarityInput3.length()];
        Arrays.fill(iArr, -1);
        boolean[] zArr = new boolean[similarityInput4.length()];
        int i = 0;
        for (int i2 = 0; i2 < similarityInput3.length(); i2++) {
            E eMo14963at = similarityInput3.mo14963at(i2);
            int iMax2 = Math.max(i2 - iMax, 0);
            int iMin = Math.min(i2 + iMax + 1, similarityInput4.length());
            while (true) {
                if (iMax2 >= iMin) {
                    break;
                }
                if (!zArr[iMax2] && eMo14963at.equals(similarityInput4.mo14963at(iMax2))) {
                    iArr[i2] = iMax2;
                    zArr[iMax2] = true;
                    i++;
                    break;
                }
                iMax2++;
            }
        }
        Object[] objArr = new Object[i];
        Object[] objArr2 = new Object[i];
        int i4 = 0;
        for (int i5 = 0; i5 < similarityInput3.length(); i5++) {
            if (iArr[i5] != -1) {
                objArr[i4] = similarityInput3.mo14963at(i5);
                i4++;
            }
        }
        int i6 = 0;
        for (int i7 = 0; i7 < similarityInput4.length(); i7++) {
            if (zArr[i7]) {
                objArr2[i6] = similarityInput4.mo14963at(i7);
                i6++;
            }
        }
        int i8 = 0;
        for (int i9 = 0; i9 < i; i9++) {
            if (!objArr[i9].equals(objArr2[i9])) {
                i8++;
            }
        }
        int i10 = 0;
        for (int i11 = 0; i11 < Math.min(4, similarityInput3.length()) && similarityInput.mo14963at(i11).equals(similarityInput2.mo14963at(i11)); i11++) {
            i10++;
        }
        return new int[]{i, i8, i10};
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // org.apache.commons.text.similarity.SimilarityScore, org.apache.commons.text.similarity.ObjectSimilarityScore, java.util.function.BiFunction
    public Double apply(CharSequence charSequence, CharSequence charSequence2) {
        return apply((SimilarityInput) SimilarityInput.input(charSequence), (SimilarityInput) SimilarityInput.input(charSequence2));
    }

    public <E> Double apply(SimilarityInput<E> similarityInput, SimilarityInput<E> similarityInput2) {
        if (similarityInput != null && similarityInput2 != null) {
            if (similarityInput.equals(similarityInput2)) {
                return Double.valueOf(1.0d);
            }
            int[] iArrMatches = matches(similarityInput, similarityInput2);
            double d = iArrMatches[0];
            if (d == 0.0d) {
                return Double.valueOf(0.0d);
            }
            double length = (((d - (((double) iArrMatches[1]) / 2.0d)) / d) + ((d / ((double) similarityInput2.length())) + (d / ((double) similarityInput.length())))) / 3.0d;
            if (length >= 0.7d) {
                length = AbstractC1974b.m1306C(1.0d, length, 0.1d * ((double) iArrMatches[2]), length);
            }
            return Double.valueOf(length);
        }
        throw new IllegalArgumentException("CharSequences must not be null");
    }
}
