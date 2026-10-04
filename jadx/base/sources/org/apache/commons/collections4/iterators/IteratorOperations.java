package org.apache.commons.collections4.iterators;

import androidx.emoji2.text.flatbuffer.C2747a;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.function.Supplier;
import p122b2.C4191n;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public interface IteratorOperations<E> extends Iterator<E> {
    default <C extends Collection<E>> C addTo(C c) {
        Objects.requireNonNull(c);
        forEachRemaining(new C4191n(c, 24));
        return c;
    }

    default E removeNext() {
        E next = next();
        remove();
        return next;
    }

    default <C extends Collection<E>> C toCollection(Supplier<C> supplier) {
        return (C) addTo(supplier.get());
    }

    default List<E> toList() {
        return (List) toCollection(new C2747a(26));
    }

    default Set<E> toSet() {
        return (Set) toCollection(new C2747a(11));
    }
}
