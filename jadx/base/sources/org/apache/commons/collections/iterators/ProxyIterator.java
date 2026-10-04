package org.apache.commons.collections.iterators;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class ProxyIterator implements Iterator {
    private Iterator iterator;

    public ProxyIterator() {
    }

    public Iterator getIterator() {
        return this.iterator;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return getIterator().hasNext();
    }

    @Override // java.util.Iterator
    public Object next() {
        return getIterator().next();
    }

    @Override // java.util.Iterator
    public void remove() {
        getIterator().remove();
    }

    public void setIterator(Iterator it) {
        this.iterator = it;
    }

    public ProxyIterator(Iterator it) {
        this.iterator = it;
    }
}
