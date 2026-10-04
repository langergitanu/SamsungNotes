package org.apache.commons.collections.iterators;

import org.apache.commons.collections.MapIterator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class AbstractMapIteratorDecorator implements MapIterator {
    protected final MapIterator iterator;

    public AbstractMapIteratorDecorator(MapIterator mapIterator) {
        if (mapIterator == null) {
            throw new IllegalArgumentException("MapIterator must not be null");
        }
        this.iterator = mapIterator;
    }

    @Override // org.apache.commons.collections.MapIterator
    public Object getKey() {
        return this.iterator.getKey();
    }

    public MapIterator getMapIterator() {
        return this.iterator;
    }

    @Override // org.apache.commons.collections.MapIterator
    public Object getValue() {
        return this.iterator.getValue();
    }

    @Override // org.apache.commons.collections.MapIterator, java.util.Iterator
    public boolean hasNext() {
        return this.iterator.hasNext();
    }

    @Override // org.apache.commons.collections.MapIterator, java.util.Iterator
    public Object next() {
        return this.iterator.next();
    }

    @Override // org.apache.commons.collections.MapIterator, java.util.Iterator
    public void remove() {
        this.iterator.remove();
    }

    @Override // org.apache.commons.collections.MapIterator
    public Object setValue(Object obj) {
        return this.iterator.setValue(obj);
    }
}
