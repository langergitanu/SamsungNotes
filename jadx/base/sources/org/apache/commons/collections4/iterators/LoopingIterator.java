package org.apache.commons.collections4.iterators;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import org.apache.commons.collections4.ResettableIterator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class LoopingIterator<E> implements ResettableIterator<E> {
    private final Collection<? extends E> collection;
    private Iterator<? extends E> iterator;

    public LoopingIterator(Collection<? extends E> collection) {
        Objects.requireNonNull(collection, "collection");
        this.collection = collection;
        reset();
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return !this.collection.isEmpty();
    }

    @Override // java.util.Iterator
    public E next() {
        if (this.collection.isEmpty()) {
            throw new NoSuchElementException("There are no elements for this iterator to loop on");
        }
        if (!this.iterator.hasNext()) {
            reset();
        }
        return this.iterator.next();
    }

    @Override // java.util.Iterator
    public void remove() {
        this.iterator.remove();
    }

    @Override // org.apache.commons.collections4.ResettableIterator
    public void reset() {
        this.iterator = this.collection.iterator();
    }

    public int size() {
        return this.collection.size();
    }
}
