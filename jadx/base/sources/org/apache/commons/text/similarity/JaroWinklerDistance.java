package org.apache.commons.text.similarity;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class JaroWinklerDistance implements EditDistance<Double> {

    @Deprecated
    public static final int INDEX_NOT_FOUND = -1;

    @Deprecated
    public static int[] matches(CharSequence charSequence, CharSequence charSequence2) {
        return JaroWinklerSimilarity.matches(charSequence, charSequence2);
    }

    @Override // org.apache.commons.text.similarity.SimilarityScore, org.apache.commons.text.similarity.ObjectSimilarityScore, java.util.function.BiFunction
    public Double apply(CharSequence charSequence, CharSequence charSequence2) {
        return apply((SimilarityInput) SimilarityInput.input(charSequence), (SimilarityInput) SimilarityInput.input(charSequence2));
    }

    public <E> Double apply(SimilarityInput<E> similarityInput, SimilarityInput<E> similarityInput2) {
        if (similarityInput != null && similarityInput2 != null) {
            return Double.valueOf(1.0d - JaroWinklerSimilarity.INSTANCE.apply((SimilarityInput) similarityInput, (SimilarityInput) similarityInput2).doubleValue());
        }
        throw new IllegalArgumentException("CharSequences must not be null");
    }
}
