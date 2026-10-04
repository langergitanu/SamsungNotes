package org.apache.commons.collections4.iterators;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class PushbackIterator<E> implements Iterator<E> {
    private final Deque<E> items = new ArrayDeque();
    private final Iterator<? extends E> iterator;

    public PushbackIterator(Iterator<? extends E> it) {
        this.iterator = it;
    }

    public static <E> PushbackIterator<E> pushbackIterator(Iterator<? extends E> it) {
        Objects.requireNonNull(it, "iterator");
        return it instanceof PushbackIterator ? (PushbackIterator) it : new PushbackIterator<>(it);
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return !this.items.isEmpty() || this.iterator.hasNext();
    }

    @Override // java.util.Iterator
    public E next() {
        return !this.items.isEmpty() ? this.items.pop() : this.iterator.next();
    }

    public void pushback(E e) {
        this.items.push(e);
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
