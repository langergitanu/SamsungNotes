package org.apache.commons.lang3.function;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import org.apache.commons.lang3.exception.C13834b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class Consumers {
    private static final Consumer NOP;

    static {
        Function functionIdentity = Function.identity();
        Objects.requireNonNull(functionIdentity);
        NOP = new C13834b(functionIdentity, 2);
    }

    private Consumers() {
    }

    public static <T> void accept(Consumer<T> consumer, T t) {
        if (consumer != null) {
            consumer.accept(t);
        }
    }

    public static <T> Consumer<T> nop() {
        return NOP;
    }
}
