package org.apache.commons.lang3.function;

import java.lang.Throwable;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@FunctionalInterface
public interface FailableIntConsumer<E extends Throwable> {
    public static final FailableIntConsumer NOP = new C13838C();

    /* JADX INFO: Access modifiers changed from: private */
    /* synthetic */ default void lambda$andThen$1(FailableIntConsumer failableIntConsumer, int i) {
        accept(i);
        failableIntConsumer.accept(i);
    }

    static <E extends Throwable> FailableIntConsumer<E> nop() {
        return NOP;
    }

    void accept(int i);

    default FailableIntConsumer<E> andThen(final FailableIntConsumer<E> failableIntConsumer) {
        Objects.requireNonNull(failableIntConsumer);
        return new FailableIntConsumer() { // from class: org.apache.commons.lang3.function.B
            @Override // org.apache.commons.lang3.function.FailableIntConsumer
            public final void accept(int i) {
                this.f9828a.lambda$andThen$1(failableIntConsumer, i);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    static /* synthetic */ void lambda$static$0(int i) {
    }
}
