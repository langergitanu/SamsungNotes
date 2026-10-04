package org.apache.commons.collections4.iterators;

import java.util.Iterator;
import java.util.Objects;
import org.apache.commons.collections4.Unmodifiable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class UnmodifiableIterator<E> implements Iterator<E>, Unmodifiable {
    private final Iterator<? extends E> iterator;

    private UnmodifiableIterator(Iterator<? extends E> it) {
        this.iterator = it;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <E> Iterator<E> unmodifiableIterator(Iterator<? extends E> it) {
        Objects.requireNonNull(it, "iterator");
        return it instanceof Unmodifiable ? it : new UnmodifiableIterator(it);
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.iterator.hasNext();
    }

    @Override // java.util.Iterator
    public E next() {
        return this.iterator.next();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("remove() is not supported");
    }
}
