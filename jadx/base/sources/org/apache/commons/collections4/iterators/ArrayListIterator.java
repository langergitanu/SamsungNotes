package org.apache.commons.collections4.iterators;

import java.lang.reflect.Array;
import java.util.NoSuchElementException;
import org.apache.commons.collections4.ResettableListIterator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class ArrayListIterator<E> extends ArrayIterator<E> implements ResettableListIterator<E> {
    private int lastItemIndex;

    public ArrayListIterator(Object obj) {
        super(obj);
        this.lastItemIndex = -1;
    }

    @Override // java.util.ListIterator
    public void add(Object obj) {
        throw new UnsupportedOperationException("add() method is not supported");
    }

    @Override // java.util.ListIterator, org.apache.commons.collections4.OrderedIterator
    public boolean hasPrevious() {
        return this.index > this.startIndex;
    }

    @Override // org.apache.commons.collections4.iterators.ArrayIterator, java.util.Iterator
    public E next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i = this.index;
        this.lastItemIndex = i;
        Object obj = this.array;
        this.index = i + 1;
        return (E) Array.get(obj, i);
    }

    @Override // java.util.ListIterator
    public int nextIndex() {
        return this.index - this.startIndex;
    }

    @Override // java.util.ListIterator, org.apache.commons.collections4.OrderedIterator
    public E previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        int i = this.index - 1;
        this.index = i;
        this.lastItemIndex = i;
        return (E) Array.get(this.array, i);
    }

    @Override // java.util.ListIterator
    public int previousIndex() {
        return (this.index - this.startIndex) - 1;
    }

    @Override // org.apache.commons.collections4.iterators.ArrayIterator, org.apache.commons.collections4.ResettableIterator
    public void reset() {
        super.reset();
        this.lastItemIndex = -1;
    }

    @Override // java.util.ListIterator
    public void set(Object obj) {
        int i = this.lastItemIndex;
        if (i == -1) {
            throw new IllegalStateException("must call next() or previous() before a call to set()");
        }
        Array.set(this.array, i, obj);
    }

    public ArrayListIterator(Object obj, int i) {
        super(obj, i);
        this.lastItemIndex = -1;
    }

    public ArrayListIterator(Object obj, int i, int i2) {
        super(obj, i, i2);
        this.lastItemIndex = -1;
    }
}
