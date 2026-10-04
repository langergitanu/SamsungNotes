package org.apache.commons.lang3.function;

import java.lang.Throwable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@FunctionalInterface
public interface FailableToDoubleFunction<T, E extends Throwable> {
    public static final FailableToDoubleFunction NOP = new C13849N(7);

    /* JADX INFO: Access modifiers changed from: private */
    static /* synthetic */ double lambda$static$0(Object obj) {
        return 0.0d;
    }

    static <T, E extends Throwable> FailableToDoubleFunction<T, E> nop() {
        return NOP;
    }

    double applyAsDouble(T t);
}
