package org.apache.commons.text.similarity;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public interface SimilarityScore<R> extends ObjectSimilarityScore<CharSequence, R> {
    @Override // org.apache.commons.text.similarity.ObjectSimilarityScore, java.util.function.BiFunction
    R apply(CharSequence charSequence, CharSequence charSequence2);
}
