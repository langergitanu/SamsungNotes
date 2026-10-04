package org.apache.commons.collections.iterators;

import java.util.Iterator;
import org.apache.commons.collections.Unmodifiable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class UnmodifiableIterator implements Iterator, Unmodifiable {
    private Iterator iterator;

    private UnmodifiableIterator(Iterator it) {
        this.iterator = it;
    }

    public static Iterator decorate(Iterator it) {
        if (it != null) {
            return it instanceof Unmodifiable ? it : new UnmodifiableIterator(it);
        }
        throw new IllegalArgumentException("Iterator must not be null");
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
        throw new UnsupportedOperationException("remove() is not supported");
    }
}
