package org.apache.commons.collections4.iterators;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public abstract class LazyIteratorChain<E> implements Iterator<E> {
    private int callCounter;
    private boolean chainExhausted;
    private Iterator<? extends E> currentIterator;
    private Iterator<? extends E> lastUsedIterator;

    private void updateCurrentIterator() {
        int i = this.callCounter;
        if (i == 0) {
            int i2 = i + 1;
            this.callCounter = i2;
            Iterator<? extends E> itNextIterator = nextIterator(i2);
            this.currentIterator = itNextIterator;
            if (itNextIterator == null) {
                this.currentIterator = EmptyIterator.emptyIterator();
                this.chainExhausted = true;
            }
            this.lastUsedIterator = this.currentIterator;
        }
        while (!this.currentIterator.hasNext() && !this.chainExhausted) {
            int i4 = this.callCounter + 1;
            this.callCounter = i4;
            Iterator<? extends E> itNextIterator2 = nextIterator(i4);
            if (itNextIterator2 != null) {
                this.currentIterator = itNextIterator2;
            } else {
                this.chainExhausted = true;
            }
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        updateCurrentIterator();
        Iterator<? extends E> it = this.currentIterator;
        this.lastUsedIterator = it;
        return it.hasNext();
    }

    @Override // java.util.Iterator
    public E next() {
        updateCurrentIterator();
        Iterator<? extends E> it = this.currentIterator;
        this.lastUsedIterator = it;
        return it.next();
    }

    public abstract Iterator<? extends E> nextIterator(int i);

    @Override // java.util.Iterator
    public void remove() {
        if (this.currentIterator == null) {
            updateCurrentIterator();
        }
        this.lastUsedIterator.remove();
    }
}
