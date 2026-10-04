package org.apache.commons.lang3.function;

import java.util.Objects;
import java.util.function.Function;
import org.apache.commons.lang3.C13883h;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@FunctionalInterface
public interface TriFunction<T, U, V, R> {
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* synthetic */ default Object lambda$andThen$0(Function function, Object obj, Object obj2, Object obj3) {
        return function.apply(apply(obj, obj2, obj3));
    }

    default <W> TriFunction<T, U, V, W> andThen(Function<? super R, ? extends W> function) {
        Objects.requireNonNull(function);
        return new C13883h(this, function, 6);
    }

    R apply(T t, U u, V v);
}
