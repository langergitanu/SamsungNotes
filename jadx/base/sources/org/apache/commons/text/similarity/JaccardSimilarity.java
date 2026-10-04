package org.apache.commons.text.similarity;

import java.util.HashSet;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class JaccardSimilarity implements SimilarityScore<Double> {
    static final JaccardSimilarity INSTANCE = new JaccardSimilarity();

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // org.apache.commons.text.similarity.SimilarityScore, org.apache.commons.text.similarity.ObjectSimilarityScore, java.util.function.BiFunction
    public Double apply(CharSequence charSequence, CharSequence charSequence2) {
        return apply((SimilarityInput) SimilarityInput.input(charSequence), (SimilarityInput) SimilarityInput.input(charSequence2));
    }

    public <E> Double apply(SimilarityInput<E> similarityInput, SimilarityInput<E> similarityInput2) {
        if (similarityInput != null && similarityInput2 != null) {
            int length = similarityInput.length();
            int length2 = similarityInput2.length();
            if (length == 0 && length2 == 0) {
                return Double.valueOf(1.0d);
            }
            if (length != 0 && length2 != 0) {
                HashSet hashSet = new HashSet();
                for (int i = 0; i < length; i++) {
                    hashSet.add(similarityInput.mo14963at(i));
                }
                HashSet hashSet2 = new HashSet();
                for (int i2 = 0; i2 < length2; i2++) {
                    hashSet2.add(similarityInput2.mo14963at(i2));
                }
                HashSet hashSet3 = new HashSet(hashSet);
                hashSet3.addAll(hashSet2);
                return Double.valueOf((((double) ((hashSet2.size() + hashSet.size()) - hashSet3.size())) * 1.0d) / ((double) hashSet3.size()));
            }
            return Double.valueOf(0.0d);
        }
        throw new IllegalArgumentException("Input cannot be null");
    }
}
