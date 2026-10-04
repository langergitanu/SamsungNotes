package org.apache.commons.lang3.function;

import java.lang.Throwable;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@FunctionalInterface
public interface FailableBiConsumer<T, U, E extends Throwable> {
    public static final FailableBiConsumer NOP = new C13866k(0);

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* synthetic */ default void lambda$andThen$1(FailableBiConsumer failableBiConsumer, Object obj, Object obj2) {
        accept(obj, obj2);
        failableBiConsumer.accept(obj, obj2);
    }

    static <T, U, E extends Throwable> FailableBiConsumer<T, U, E> nop() {
        return NOP;
    }

    void accept(T t, U u);

    default FailableBiConsumer<T, U, E> andThen(final FailableBiConsumer<? super T, ? super U, E> failableBiConsumer) {
        Objects.requireNonNull(failableBiConsumer);
        return new FailableBiConsumer() { // from class: org.apache.commons.lang3.function.l
            @Override // org.apache.commons.lang3.function.FailableBiConsumer
            public final void accept(Object obj, Object obj2) {
                this.f9877a.lambda$andThen$1(failableBiConsumer, obj, obj2);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    static /* synthetic */ void lambda$static$0(Object obj, Object obj2) {
    }
}
