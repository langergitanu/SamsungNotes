package org.apache.commons.collections4.iterators;

import java.util.NoSuchElementException;
import org.apache.commons.collections4.ResettableIterator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
abstract class AbstractEmptyIterator<E> implements ResettableIterator<E> {
    @Deprecated
    public void add(E e) {
        throw new UnsupportedOperationException("add() not supported for empty Iterator");
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return false;
    }

    public boolean hasPrevious() {
        return false;
    }

    @Override // java.util.Iterator
    public E next() {
        throw new NoSuchElementException("Iterator contains no elements");
    }

    public int nextIndex() {
        return 0;
    }

    public E previous() {
        throw new NoSuchElementException("Iterator contains no elements");
    }

    public int previousIndex() {
        return -1;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new IllegalStateException("Iterator contains no elements");
    }

    public void set(E e) {
        throw new IllegalStateException("Iterator contains no elements");
    }

    @Override // org.apache.commons.collections4.ResettableIterator
    public void reset() {
    }
}
