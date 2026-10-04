package org.apache.commons.collections.iterators;

import java.util.Iterator;
import java.util.NoSuchElementException;
import org.apache.commons.collections.ResettableIterator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class ObjectArrayIterator implements Iterator, ResettableIterator {
    protected Object[] array;
    protected int endIndex;
    protected int index;
    protected int startIndex;

    public ObjectArrayIterator() {
        this.array = null;
        this.startIndex = 0;
        this.endIndex = 0;
        this.index = 0;
    }

    public Object[] getArray() {
        return this.array;
    }

    public int getEndIndex() {
        return this.endIndex;
    }

    public int getStartIndex() {
        return this.startIndex;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.endIndex;
    }

    @Override // java.util.Iterator
    public Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        Object[] objArr = this.array;
        int i = this.index;
        this.index = i + 1;
        return objArr[i];
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("remove() method is not supported for an ObjectArrayIterator");
    }

    @Override // org.apache.commons.collections.ResettableIterator
    public void reset() {
        this.index = this.startIndex;
    }

    public void setArray(Object[] objArr) {
        if (this.array != null) {
            throw new IllegalStateException("The array to iterate over has already been set");
        }
        this.array = objArr;
        this.startIndex = 0;
        this.endIndex = objArr.length;
        this.index = 0;
    }

    public ObjectArrayIterator(Object[] objArr) {
        this(objArr, 0, objArr.length);
    }

    public ObjectArrayIterator(Object[] objArr, int i) {
        this(objArr, i, objArr.length);
    }

    public ObjectArrayIterator(Object[] objArr, int i, int i2) {
        this.array = null;
        this.startIndex = 0;
        this.endIndex = 0;
        this.index = 0;
        if (i >= 0) {
            if (i2 <= objArr.length) {
                if (i > objArr.length) {
                    throw new ArrayIndexOutOfBoundsException("Start index must not be greater than the array length");
                }
                if (i2 >= i) {
                    this.array = objArr;
                    this.startIndex = i;
                    this.endIndex = i2;
                    this.index = i;
                    return;
                }
                throw new IllegalArgumentException("End index must not be less than start index");
            }
            throw new ArrayIndexOutOfBoundsException("End index must not be greater than the array length");
        }
        throw new ArrayIndexOutOfBoundsException("Start index must not be less than zero");
    }
}
