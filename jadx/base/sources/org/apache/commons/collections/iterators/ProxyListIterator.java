package org.apache.commons.collections.iterators;

import java.util.ListIterator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class ProxyListIterator implements ListIterator {
    private ListIterator iterator;

    public ProxyListIterator() {
    }

    @Override // java.util.ListIterator
    public void add(Object obj) {
        getListIterator().add(obj);
    }

    public ListIterator getListIterator() {
        return this.iterator;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public boolean hasNext() {
        return getListIterator().hasNext();
    }

    @Override // java.util.ListIterator
    public boolean hasPrevious() {
        return getListIterator().hasPrevious();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public Object next() {
        return getListIterator().next();
    }

    @Override // java.util.ListIterator
    public int nextIndex() {
        return getListIterator().nextIndex();
    }

    @Override // java.util.ListIterator
    public Object previous() {
        return getListIterator().previous();
    }

    @Override // java.util.ListIterator
    public int previousIndex() {
        return getListIterator().previousIndex();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public void remove() {
        getListIterator().remove();
    }

    @Override // java.util.ListIterator
    public void set(Object obj) {
        getListIterator().set(obj);
    }

    public void setListIterator(ListIterator listIterator) {
        this.iterator = listIterator;
    }

    public ProxyListIterator(ListIterator listIterator) {
        this.iterator = listIterator;
    }
}
