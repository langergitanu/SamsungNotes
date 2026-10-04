package org.apache.commons.lang3.function;

import java.lang.Throwable;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@FunctionalInterface
public interface FailableFunction<T, R, E extends Throwable> {
    public static final FailableFunction NOP = new C13836A(0);

    static <T, E extends Throwable> FailableFunction<T, T, E> identity() {
        return new C13836A(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* synthetic */ default Object lambda$andThen$2(FailableFunction failableFunction, Object obj) {
        return failableFunction.apply(apply(obj));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* synthetic */ default Object lambda$compose$3(FailableFunction failableFunction, Object obj) {
        return apply(failableFunction.apply(obj));
    }

    /* JADX INFO: Access modifiers changed from: private */
    static /* synthetic */ Object lambda$static$0(Object obj) {
        return null;
    }

    static <T, R, E extends Throwable> FailableFunction<T, R, E> nop() {
        return NOP;
    }

    default <V> FailableFunction<T, V, E> andThen(FailableFunction<? super R, ? extends V, E> failableFunction) {
        Objects.requireNonNull(failableFunction);
        return new C13881z(this, failableFunction, 1);
    }

    R apply(T t);

    default <V> FailableFunction<V, R, E> compose(FailableFunction<? super V, ? extends T, E> failableFunction) {
        Objects.requireNonNull(failableFunction);
        return new C13881z(this, failableFunction, 0);
    }

    static <T, R, E extends Throwable> FailableFunction<T, R, E> function(FailableFunction<T, R, E> failableFunction) {
        return failableFunction;
    }

    /* JADX INFO: Access modifiers changed from: private */
    static /* synthetic */ Object lambda$identity$1(Object obj) {
        return obj;
    }
}
