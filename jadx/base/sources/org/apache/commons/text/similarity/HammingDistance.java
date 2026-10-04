package org.apache.commons.text.similarity;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class HammingDistance implements EditDistance<Integer> {
    @Override // org.apache.commons.text.similarity.SimilarityScore, org.apache.commons.text.similarity.ObjectSimilarityScore, java.util.function.BiFunction
    public Integer apply(CharSequence charSequence, CharSequence charSequence2) {
        return apply((SimilarityInput) SimilarityInput.input(charSequence), (SimilarityInput) SimilarityInput.input(charSequence2));
    }

    public <E> Integer apply(SimilarityInput<E> similarityInput, SimilarityInput<E> similarityInput2) {
        if (similarityInput != null && similarityInput2 != null) {
            if (similarityInput.length() == similarityInput2.length()) {
                int i = 0;
                for (int i2 = 0; i2 < similarityInput.length(); i2++) {
                    if (!similarityInput.mo14963at(i2).equals(similarityInput2.mo14963at(i2))) {
                        i++;
                    }
                }
                return Integer.valueOf(i);
            }
            throw new IllegalArgumentException("SimilarityInput must have the same length");
        }
        throw new IllegalArgumentException("SimilarityInput must not be null");
    }
}
