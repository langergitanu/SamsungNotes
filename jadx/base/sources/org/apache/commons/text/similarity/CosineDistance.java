package org.apache.commons.text.similarity;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class CosineDistance implements EditDistance<Double> {
    @Override // org.apache.commons.text.similarity.SimilarityScore, org.apache.commons.text.similarity.ObjectSimilarityScore, java.util.function.BiFunction
    public Double apply(CharSequence charSequence, CharSequence charSequence2) {
        RegexTokenizer regexTokenizer = RegexTokenizer.INSTANCE;
        CharSequence[] charSequenceArrApply = regexTokenizer.apply(charSequence);
        CharSequence[] charSequenceArrApply2 = regexTokenizer.apply(charSequence2);
        return Double.valueOf(1.0d - CosineSimilarity.INSTANCE.cosineSimilarity(Counter.m14960of(charSequenceArrApply), Counter.m14960of(charSequenceArrApply2)).doubleValue());
    }
}
