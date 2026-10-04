package org.apache.commons.collections.iterators;

import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
abstract class AbstractEmptyIterator {
    public void add(Object obj) {
        throw new UnsupportedOperationException("add() not supported for empty Iterator");
    }

    public Object getKey() {
        throw new IllegalStateException("Iterator contains no elements");
    }

    public Object getValue() {
        throw new IllegalStateException("Iterator contains no elements");
    }

    public boolean hasNext() {
        return false;
    }

    public boolean hasPrevious() {
        return false;
    }

    public Object next() {
        throw new NoSuchElementException("Iterator contains no elements");
    }

    public int nextIndex() {
        return 0;
    }

    public Object previous() {
        throw new NoSuchElementException("Iterator contains no elements");
    }

    public int previousIndex() {
        return -1;
    }

    public void remove() {
        throw new IllegalStateException("Iterator contains no elements");
    }

    public void set(Object obj) {
        throw new IllegalStateException("Iterator contains no elements");
    }

    public Object setValue(Object obj) {
        throw new IllegalStateException("Iterator contains no elements");
    }

    public void reset() {
    }
}
