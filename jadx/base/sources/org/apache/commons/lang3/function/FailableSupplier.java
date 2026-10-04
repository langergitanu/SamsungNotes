package org.apache.commons.lang3.function;

import java.lang.Throwable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@FunctionalInterface
public interface FailableSupplier<T, E extends Throwable> {
    public static final FailableSupplier NUL = new C13855U();

    /* JADX INFO: Access modifiers changed from: private */
    static /* synthetic */ Object lambda$static$0() {
        return null;
    }

    static <T, E extends Exception> FailableSupplier<T, E> nul() {
        return NUL;
    }

    T get();
}
