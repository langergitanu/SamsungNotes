package org.apache.commons.collections.iterators;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class AbstractIteratorDecorator implements Iterator {
    protected final Iterator iterator;

    public AbstractIteratorDecorator(Iterator it) {
        if (it == null) {
            throw new IllegalArgumentException("Iterator must not be null");
        }
        this.iterator = it;
    }

    public Iterator getIterator() {
        return this.iterator;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.iterator.hasNext();
    }

    @Override // java.util.Iterator
    public Object next() {
        return this.iterator.next();
    }

    @Override // java.util.Iterator
    public void remove() {
        this.iterator.remove();
    }
}
