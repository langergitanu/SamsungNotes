package org.apache.commons.collections.iterators;

import java.lang.reflect.Array;
import java.util.NoSuchElementException;
import kotlin.collections.AbstractC12991c;
import org.apache.commons.collections.ResettableIterator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class ArrayIterator implements ResettableIterator {
    protected Object array;
    protected int endIndex;
    protected int index;
    protected int startIndex;

    public ArrayIterator() {
        this.startIndex = 0;
        this.endIndex = 0;
        this.index = 0;
    }

    public void checkBound(int i, String str) {
        if (i > this.endIndex) {
            throw new ArrayIndexOutOfBoundsException(AbstractC12991c.m13990k("Attempt to make an ArrayIterator that ", str, "s beyond the end of the array. "));
        }
        if (i < 0) {
            throw new ArrayIndexOutOfBoundsException(AbstractC12991c.m13990k("Attempt to make an ArrayIterator that ", str, "s before the start of the array. "));
        }
    }

    public Object getArray() {
        return this.array;
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
        Object obj = this.array;
        int i = this.index;
        this.index = i + 1;
        return Array.get(obj, i);
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("remove() method is not supported");
    }

    @Override // org.apache.commons.collections.ResettableIterator
    public void reset() {
        this.index = this.startIndex;
    }

    public void setArray(Object obj) {
        this.endIndex = Array.getLength(obj);
        this.startIndex = 0;
        this.array = obj;
        this.index = 0;
    }

    public ArrayIterator(Object obj) {
        this.startIndex = 0;
        this.endIndex = 0;
        this.index = 0;
        setArray(obj);
    }

    public ArrayIterator(Object obj, int i) {
        this.startIndex = 0;
        this.endIndex = 0;
        this.index = 0;
        setArray(obj);
        checkBound(i, "start");
        this.startIndex = i;
        this.index = i;
    }

    public ArrayIterator(Object obj, int i, int i2) {
        this.startIndex = 0;
        this.endIndex = 0;
        this.index = 0;
        setArray(obj);
        checkBound(i, "start");
        checkBound(i2, "end");
        if (i2 >= i) {
            this.startIndex = i;
            this.endIndex = i2;
            this.index = i;
            return;
        }
        throw new IllegalArgumentException("End index must not be less than start index.");
    }
}
