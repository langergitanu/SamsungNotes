package org.apache.commons.lang3.function;

import java.util.function.Function;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class Functions {
    private Functions() {
    }

    public static <T, R> R apply(Function<T, R> function, T t) {
        if (function != null) {
            return function.apply(t);
        }
        return null;
    }

    public static <T, R> Function<T, R> function(Function<T, R> function) {
        return function;
    }
}
