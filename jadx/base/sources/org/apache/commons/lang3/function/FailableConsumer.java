package org.apache.commons.lang3.function;

import java.lang.Throwable;
import java.util.Objects;
import java.util.function.Function;
import org.apache.commons.lang3.C13926u;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@FunctionalInterface
public interface FailableConsumer<T, E extends Throwable> {
    public static final FailableConsumer NOP;

    static {
        Function functionIdentity = Function.identity();
        Objects.requireNonNull(functionIdentity);
        NOP = new C13926u(functionIdentity, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* synthetic */ default void lambda$andThen$0(FailableConsumer failableConsumer, Object obj) {
        accept(obj);
        failableConsumer.accept(obj);
    }

    static <T, E extends Throwable> FailableConsumer<T, E> nop() {
        return NOP;
    }

    void accept(T t);

    default FailableConsumer<T, E> andThen(final FailableConsumer<? super T, E> failableConsumer) {
        Objects.requireNonNull(failableConsumer);
        return new FailableConsumer() { // from class: org.apache.commons.lang3.function.r
            @Override // org.apache.commons.lang3.function.FailableConsumer
            public final void accept(Object obj) {
                this.f9886a.lambda$andThen$0(failableConsumer, obj);
            }
        };
    }
}
