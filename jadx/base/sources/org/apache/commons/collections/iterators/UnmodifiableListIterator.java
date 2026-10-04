package org.apache.commons.collections.iterators;

import java.util.ListIterator;
import org.apache.commons.collections.Unmodifiable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class UnmodifiableListIterator implements ListIterator, Unmodifiable {
    private ListIterator iterator;

    private UnmodifiableListIterator(ListIterator listIterator) {
        this.iterator = listIterator;
    }

    public static ListIterator decorate(ListIterator listIterator) {
        if (listIterator != null) {
            return listIterator instanceof Unmodifiable ? listIterator : new UnmodifiableListIterator(listIterator);
        }
        throw new IllegalArgumentException("ListIterator must not be null");
    }

    @Override // java.util.ListIterator
    public void add(Object obj) {
        throw new UnsupportedOperationException("add() is not supported");
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public boolean hasNext() {
        return this.iterator.hasNext();
    }

    @Override // java.util.ListIterator
    public boolean hasPrevious() {
        return this.iterator.hasPrevious();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public Object next() {
        return this.iterator.next();
    }

    @Override // java.util.ListIterator
    public int nextIndex() {
        return this.iterator.nextIndex();
    }

    @Override // java.util.ListIterator
    public Object previous() {
        return this.iterator.previous();
    }

    @Override // java.util.ListIterator
    public int previousIndex() {
        return this.iterator.previousIndex();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("remove() is not supported");
    }

    @Override // java.util.ListIterator
    public void set(Object obj) {
        throw new UnsupportedOperationException("set() is not supported");
    }
}
