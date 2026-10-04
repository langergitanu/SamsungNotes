package org.apache.commons.lang3.function;

import java.lang.Throwable;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@FunctionalInterface
public interface FailableLongConsumer<E extends Throwable> {
    public static final FailableLongConsumer NOP = new C13844I();

    /* JADX INFO: Access modifiers changed from: private */
    /* synthetic */ default void lambda$andThen$1(FailableLongConsumer failableLongConsumer, long j) {
        accept(j);
        failableLongConsumer.accept(j);
    }

    static <E extends Throwable> FailableLongConsumer<E> nop() {
        return NOP;
    }

    void accept(long j);

    default FailableLongConsumer<E> andThen(final FailableLongConsumer<E> failableLongConsumer) {
        Objects.requireNonNull(failableLongConsumer);
        return new FailableLongConsumer() { // from class: org.apache.commons.lang3.function.J
            @Override // org.apache.commons.lang3.function.FailableLongConsumer
            public final void accept(long j) {
                this.f9839a.lambda$andThen$1(failableLongConsumer, j);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    static /* synthetic */ void lambda$static$0(long j) {
    }
}
