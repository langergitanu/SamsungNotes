package org.apache.commons.lang3.function;

import java.lang.Throwable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@FunctionalInterface
public interface FailableLongToIntFunction<E extends Throwable> {
    public static final FailableLongToIntFunction NOP = new C13849N(1);

    /* JADX INFO: Access modifiers changed from: private */
    static /* synthetic */ int lambda$static$0(long j) {
        return 0;
    }

    static <E extends Throwable> FailableLongToIntFunction<E> nop() {
        return NOP;
    }

    int applyAsInt(long j);
}
