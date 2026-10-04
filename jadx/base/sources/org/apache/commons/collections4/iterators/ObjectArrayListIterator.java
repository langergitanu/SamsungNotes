package org.apache.commons.collections4.iterators;

import java.util.NoSuchElementException;
import org.apache.commons.collections4.ResettableListIterator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class ObjectArrayListIterator<E> extends ObjectArrayIterator<E> implements ResettableListIterator<E> {
    private int lastItemIndex;

    public ObjectArrayListIterator(E... eArr) {
        super(eArr);
        this.lastItemIndex = -1;
    }

    @Override // java.util.ListIterator
    public void add(E e) {
        throw new UnsupportedOperationException("add() method is not supported");
    }

    @Override // java.util.ListIterator, org.apache.commons.collections4.OrderedIterator
    public boolean hasPrevious() {
        return this.index > getStartIndex();
    }

    @Override // org.apache.commons.collections4.iterators.ObjectArrayIterator, java.util.Iterator
    public E next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i = this.index;
        this.lastItemIndex = i;
        E[] eArr = this.array;
        this.index = i + 1;
        return eArr[i];
    }

    @Override // java.util.ListIterator
    public int nextIndex() {
        return this.index - getStartIndex();
    }

    @Override // java.util.ListIterator, org.apache.commons.collections4.OrderedIterator
    public E previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        int i = this.index - 1;
        this.index = i;
        this.lastItemIndex = i;
        return this.array[i];
    }

    @Override // java.util.ListIterator
    public int previousIndex() {
        return (this.index - getStartIndex()) - 1;
    }

    @Override // org.apache.commons.collections4.iterators.ObjectArrayIterator, org.apache.commons.collections4.ResettableIterator
    public void reset() {
        super.reset();
        this.lastItemIndex = -1;
    }

    @Override // java.util.ListIterator
    public void set(E e) {
        int i = this.lastItemIndex;
        if (i == -1) {
            throw new IllegalStateException("must call next() or previous() before a call to set()");
        }
        this.array[i] = e;
    }

    public ObjectArrayListIterator(E[] eArr, int i) {
        super(eArr, i);
        this.lastItemIndex = -1;
    }

    public ObjectArrayListIterator(E[] eArr, int i, int i2) {
        super(eArr, i, i2);
        this.lastItemIndex = -1;
    }
}
