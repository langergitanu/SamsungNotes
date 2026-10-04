package org.apache.commons.collections.iterators;

import java.util.Iterator;
import java.util.NoSuchElementException;
import org.apache.commons.collections.ResettableIterator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class SingletonIterator implements Iterator, ResettableIterator {
    private boolean beforeFirst;
    private Object object;
    private final boolean removeAllowed;
    private boolean removed;

    public SingletonIterator(Object obj) {
        this(obj, true);
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.beforeFirst && !this.removed;
    }

    @Override // java.util.Iterator
    public Object next() {
        if (!this.beforeFirst || this.removed) {
            throw new NoSuchElementException();
        }
        this.beforeFirst = false;
        return this.object;
    }

    @Override // java.util.Iterator
    public void remove() {
        if (!this.removeAllowed) {
            throw new UnsupportedOperationException();
        }
        if (this.removed || this.beforeFirst) {
            throw new IllegalStateException();
        }
        this.object = null;
        this.removed = true;
    }

    @Override // org.apache.commons.collections.ResettableIterator
    public void reset() {
        this.beforeFirst = true;
    }

    public SingletonIterator(Object obj, boolean z) {
        this.beforeFirst = true;
        this.removed = false;
        this.object = obj;
        this.removeAllowed = z;
    }
}
