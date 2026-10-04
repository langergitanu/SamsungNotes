package org.apache.commons.lang3.function;

import java.lang.Throwable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@FunctionalInterface
public interface FailableObjLongConsumer<T, E extends Throwable> {
    public static final FailableObjLongConsumer NOP = new C13849N(4);

    static <T, E extends Throwable> FailableObjLongConsumer<T, E> nop() {
        return NOP;
    }

    void accept(T t, long j);

    /* JADX INFO: Access modifiers changed from: private */
    static /* synthetic */ void lambda$static$0(Object obj, long j) {
    }
}
