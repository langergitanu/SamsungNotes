package org.apache.commons.lang3.function;

import java.util.Objects;
import org.apache.commons.lang3.C13883h;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@FunctionalInterface
public interface TriConsumer<T, U, V> {
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* synthetic */ default void lambda$andThen$0(TriConsumer triConsumer, Object obj, Object obj2, Object obj3) {
        accept(obj, obj2, obj3);
        triConsumer.accept(obj, obj2, obj3);
    }

    void accept(T t, U u, V v);

    default TriConsumer<T, U, V> andThen(TriConsumer<? super T, ? super U, ? super V> triConsumer) {
        Objects.requireNonNull(triConsumer);
        return new C13883h(this, triConsumer, 5);
    }
}
