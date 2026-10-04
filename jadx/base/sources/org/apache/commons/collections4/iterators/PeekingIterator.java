package org.apache.commons.collections4.iterators;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class PeekingIterator<E> implements Iterator<E> {
    private boolean exhausted;
    private final Iterator<? extends E> iterator;
    private E slot;
    private boolean slotFilled;

    public PeekingIterator(Iterator<? extends E> it) {
        this.iterator = it;
    }

    private void fill() {
        if (this.exhausted || this.slotFilled) {
            return;
        }
        if (this.iterator.hasNext()) {
            this.slot = this.iterator.next();
            this.slotFilled = true;
        } else {
            this.exhausted = true;
            this.slot = null;
            this.slotFilled = false;
        }
    }

    public static <E> PeekingIterator<E> peekingIterator(Iterator<? extends E> it) {
        Objects.requireNonNull(it, "iterator");
        return it instanceof PeekingIterator ? (PeekingIterator) it : new PeekingIterator<>(it);
    }

    public E element() {
        fill();
        if (this.exhausted) {
            throw new NoSuchElementException();
        }
        return this.slot;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.exhausted) {
            return false;
        }
        return this.slotFilled || this.iterator.hasNext();
    }

    @Override // java.util.Iterator
    public E next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        E next = this.slotFilled ? this.slot : this.iterator.next();
        this.slot = null;
        this.slotFilled = false;
        return next;
    }

    public E peek() {
        fill();
        if (this.exhausted) {
            return null;
        }
        return this.slot;
    }

    @Override // java.util.Iterator
    public void remove() {
        if (this.slotFilled) {
            throw new IllegalStateException("peek() or element() called before remove()");
        }
        this.iterator.remove();
    }
}
