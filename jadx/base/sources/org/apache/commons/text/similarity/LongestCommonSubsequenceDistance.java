package org.apache.commons.text.similarity;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class LongestCommonSubsequenceDistance implements EditDistance<Integer> {
    @Override // org.apache.commons.text.similarity.SimilarityScore, org.apache.commons.text.similarity.ObjectSimilarityScore, java.util.function.BiFunction
    public Integer apply(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence != null && charSequence2 != null) {
            return Integer.valueOf((charSequence2.length() + charSequence.length()) - (LongestCommonSubsequence.INSTANCE.apply(charSequence, charSequence2).intValue() * 2));
        }
        throw new IllegalArgumentException("Inputs must not be null");
    }
}
