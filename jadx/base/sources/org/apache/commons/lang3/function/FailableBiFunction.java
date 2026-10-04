package org.apache.commons.lang3.function;

import java.lang.Throwable;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@FunctionalInterface
public interface FailableBiFunction<T, U, R, E extends Throwable> {
    public static final FailableBiFunction NOP = new C13868m();

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* synthetic */ default Object lambda$andThen$1(FailableFunction failableFunction, Object obj, Object obj2) {
        return failableFunction.apply(apply(obj, obj2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    static /* synthetic */ Object lambda$static$0(Object obj, Object obj2) {
        return null;
    }

    static <T, U, R, E extends Throwable> FailableBiFunction<T, U, R, E> nop() {
        return NOP;
    }

    default <V> FailableBiFunction<T, U, V, E> andThen(final FailableFunction<? super R, ? extends V, E> failableFunction) {
        Objects.requireNonNull(failableFunction);
        return new FailableBiFunction() { // from class: org.apache.commons.lang3.function.n
            @Override // org.apache.commons.lang3.function.FailableBiFunction
            public final Object apply(Object obj, Object obj2) {
                return this.f9879a.lambda$andThen$1(failableFunction, obj, obj2);
            }
        };
    }

    R apply(T t, U u);
}
