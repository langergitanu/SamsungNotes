package org.apache.commons.text.similarity;

import java.util.function.BiFunction;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public interface ObjectSimilarityScore<T, R> extends BiFunction<T, T, R> {
    @Override // java.util.function.BiFunction
    R apply(T t, T t2);
}
