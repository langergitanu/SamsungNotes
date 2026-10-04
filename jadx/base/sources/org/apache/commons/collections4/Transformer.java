package org.apache.commons.collections4;

import java.util.function.Function;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@FunctionalInterface
@Deprecated
public interface Transformer<T, R> extends Function<T, R> {
    @Override // java.util.function.Function
    default R apply(T t) {
        return transform(t);
    }

    R transform(T t);
}
