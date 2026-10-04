package org.hamcrest.internal;

import java.lang.reflect.Array;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class ArrayIterator implements Iterator<Object> {
    private final Object array;
    private int currentIndex = 0;

    public ArrayIterator(Object obj) {
        if (!obj.getClass().isArray()) {
            throw new IllegalArgumentException("not an array");
        }
        this.array = obj;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.currentIndex < Array.getLength(this.array);
    }

    @Override // java.util.Iterator
    public Object next() {
        Object obj = this.array;
        int i = this.currentIndex;
        this.currentIndex = i + 1;
        return Array.get(obj, i);
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("cannot remove items from an array");
    }
}
