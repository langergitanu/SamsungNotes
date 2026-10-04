package org.apache.commons.lang3.function;

import java.lang.Throwable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@FunctionalInterface
public interface FailableObjDoubleConsumer<T, E extends Throwable> {
    public static final FailableObjDoubleConsumer NOP = new C13849N(2);

    static <T, E extends Throwable> FailableObjDoubleConsumer<T, E> nop() {
        return NOP;
    }

    void accept(T t, double d);

    /* JADX INFO: Access modifiers changed from: private */
    static /* synthetic */ void lambda$static$0(Object obj, double d) {
    }
}
