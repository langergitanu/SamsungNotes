package org.apache.commons.collections.iterators;

import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import org.apache.commons.collections.ResettableListIterator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class LoopingListIterator implements ResettableListIterator {
    private ListIterator iterator;
    private List list;

    public LoopingListIterator(List list) {
        if (list == null) {
            throw new NullPointerException("The list must not be null");
        }
        this.list = list;
        reset();
    }

    @Override // java.util.ListIterator
    public void add(Object obj) {
        this.iterator.add(obj);
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public boolean hasNext() {
        return !this.list.isEmpty();
    }

    @Override // java.util.ListIterator
    public boolean hasPrevious() {
        return !this.list.isEmpty();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public Object next() {
        if (this.list.isEmpty()) {
            throw new NoSuchElementException("There are no elements for this iterator to loop on");
        }
        if (!this.iterator.hasNext()) {
            reset();
        }
        return this.iterator.next();
    }

    @Override // java.util.ListIterator
    public int nextIndex() {
        if (this.list.isEmpty()) {
            throw new NoSuchElementException("There are no elements for this iterator to loop on");
        }
        if (this.iterator.hasNext()) {
            return this.iterator.nextIndex();
        }
        return 0;
    }

    @Override // java.util.ListIterator
    public Object previous() {
        if (this.list.isEmpty()) {
            throw new NoSuchElementException("There are no elements for this iterator to loop on");
        }
        if (this.iterator.hasPrevious()) {
            return this.iterator.previous();
        }
        Object next = null;
        while (this.iterator.hasNext()) {
            next = this.iterator.next();
        }
        this.iterator.previous();
        return next;
    }

    @Override // java.util.ListIterator
    public int previousIndex() {
        if (this.list.isEmpty()) {
            throw new NoSuchElementException("There are no elements for this iterator to loop on");
        }
        return !this.iterator.hasPrevious() ? this.list.size() - 1 : this.iterator.previousIndex();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public void remove() {
        this.iterator.remove();
    }

    @Override // org.apache.commons.collections.ResettableListIterator, org.apache.commons.collections.ResettableIterator
    public void reset() {
        this.iterator = this.list.listIterator();
    }

    @Override // java.util.ListIterator
    public void set(Object obj) {
        this.iterator.set(obj);
    }

    public int size() {
        return this.list.size();
    }
}
