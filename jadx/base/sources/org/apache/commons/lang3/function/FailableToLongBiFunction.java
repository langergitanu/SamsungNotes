package org.apache.commons.lang3.function;

import java.lang.Throwable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@FunctionalInterface
public interface FailableToLongBiFunction<T, U, E extends Throwable> {
    public static final FailableToLongBiFunction NOP = new C13849N(10);

    /* JADX INFO: Access modifiers changed from: private */
    static /* synthetic */ long lambda$static$0(Object obj, Object obj2) {
        return 0L;
    }

    static <T, U, E extends Throwable> FailableToLongBiFunction<T, U, E> nop() {
        return NOP;
    }

    long applyAsLong(T t, U u);
}
