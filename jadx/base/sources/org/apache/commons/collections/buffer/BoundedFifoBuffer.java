package org.apache.commons.collections.buffer;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.apache.commons.collections.BoundedCollection;
import org.apache.commons.collections.Buffer;
import org.apache.commons.collections.BufferOverflowException;
import org.apache.commons.collections.BufferUnderflowException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class BoundedFifoBuffer extends AbstractCollection implements Buffer, BoundedCollection, Serializable {
    private static final long serialVersionUID = 5603722811189451017L;
    private transient Object[] elements;
    private transient int end;
    private transient boolean full;
    private final int maxElements;
    private transient int start;

    public BoundedFifoBuffer() {
        this(32);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int decrement(int i) {
        int i2 = i - 1;
        return i2 < 0 ? this.maxElements - 1 : i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int increment(int i) {
        int i2 = i + 1;
        if (i2 >= this.maxElements) {
            return 0;
        }
        return i2;
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        this.elements = new Object[this.maxElements];
        int i = objectInputStream.readInt();
        for (int i2 = 0; i2 < i; i2++) {
            this.elements[i2] = objectInputStream.readObject();
        }
        this.start = 0;
        boolean z = i == this.maxElements;
        this.full = z;
        if (z) {
            this.end = 0;
        } else {
            this.end = i;
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(size());
        Iterator it = iterator();
        while (it.hasNext()) {
            objectOutputStream.writeObject(it.next());
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean add(Object obj) {
        if (obj == null) {
            throw new NullPointerException("Attempted to add null object to buffer");
        }
        if (this.full) {
            StringBuffer stringBuffer = new StringBuffer("The buffer cannot hold more than ");
            stringBuffer.append(this.maxElements);
            stringBuffer.append(" objects.");
            throw new BufferOverflowException(stringBuffer.toString());
        }
        Object[] objArr = this.elements;
        int i = this.end;
        int i2 = i + 1;
        this.end = i2;
        objArr[i] = obj;
        if (i2 >= this.maxElements) {
            this.end = 0;
        }
        if (this.end == this.start) {
            this.full = true;
        }
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public void clear() {
        this.full = false;
        this.start = 0;
        this.end = 0;
        Arrays.fill(this.elements, (Object) null);
    }

    @Override // org.apache.commons.collections.Buffer
    public Object get() {
        if (isEmpty()) {
            throw new BufferUnderflowException("The buffer is already empty");
        }
        return this.elements[this.start];
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // org.apache.commons.collections.BoundedCollection
    public boolean isFull() {
        return size() == this.maxElements;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return new Iterator() { // from class: org.apache.commons.collections.buffer.BoundedFifoBuffer.1
            private int index;
            private boolean isFirst;
            private int lastReturnedIndex = -1;

            {
                this.index = BoundedFifoBuffer.this.start;
                this.isFirst = BoundedFifoBuffer.this.full;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.isFirst || this.index != BoundedFifoBuffer.this.end;
            }

            @Override // java.util.Iterator
            public Object next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                this.isFirst = false;
                int i = this.index;
                this.lastReturnedIndex = i;
                this.index = BoundedFifoBuffer.this.increment(i);
                return BoundedFifoBuffer.this.elements[this.lastReturnedIndex];
            }

            @Override // java.util.Iterator
            public void remove() {
                int i = this.lastReturnedIndex;
                if (i == -1) {
                    throw new IllegalStateException();
                }
                if (i == BoundedFifoBuffer.this.start) {
                    BoundedFifoBuffer.this.remove();
                    this.lastReturnedIndex = -1;
                    return;
                }
                int iIncrement = this.lastReturnedIndex + 1;
                if (BoundedFifoBuffer.this.start >= this.lastReturnedIndex || iIncrement >= BoundedFifoBuffer.this.end) {
                    while (iIncrement != BoundedFifoBuffer.this.end) {
                        if (iIncrement >= BoundedFifoBuffer.this.maxElements) {
                            BoundedFifoBuffer.this.elements[iIncrement - 1] = BoundedFifoBuffer.this.elements[0];
                            iIncrement = 0;
                        } else {
                            BoundedFifoBuffer.this.elements[BoundedFifoBuffer.this.decrement(iIncrement)] = BoundedFifoBuffer.this.elements[iIncrement];
                            iIncrement = BoundedFifoBuffer.this.increment(iIncrement);
                        }
                    }
                } else {
                    System.arraycopy(BoundedFifoBuffer.this.elements, iIncrement, BoundedFifoBuffer.this.elements, this.lastReturnedIndex, BoundedFifoBuffer.this.end - iIncrement);
                }
                this.lastReturnedIndex = -1;
                BoundedFifoBuffer boundedFifoBuffer = BoundedFifoBuffer.this;
                boundedFifoBuffer.end = boundedFifoBuffer.decrement(boundedFifoBuffer.end);
                BoundedFifoBuffer.this.elements[BoundedFifoBuffer.this.end] = null;
                BoundedFifoBuffer.this.full = false;
                this.index = BoundedFifoBuffer.this.decrement(this.index);
            }
        };
    }

    @Override // org.apache.commons.collections.BoundedCollection
    public int maxSize() {
        return this.maxElements;
    }

    @Override // org.apache.commons.collections.Buffer
    public Object remove() {
        if (isEmpty()) {
            throw new BufferUnderflowException("The buffer is already empty");
        }
        Object[] objArr = this.elements;
        int i = this.start;
        Object obj = objArr[i];
        if (obj != null) {
            int i2 = i + 1;
            this.start = i2;
            objArr[i] = null;
            if (i2 >= this.maxElements) {
                this.start = 0;
            }
            this.full = false;
        }
        return obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        int i = this.end;
        int i2 = this.start;
        if (i < i2) {
            return (this.maxElements - i2) + i;
        }
        if (i != i2) {
            return i - i2;
        }
        if (this.full) {
            return this.maxElements;
        }
        return 0;
    }

    public BoundedFifoBuffer(int i) {
        this.start = 0;
        this.end = 0;
        this.full = false;
        if (i <= 0) {
            throw new IllegalArgumentException("The size must be greater than 0");
        }
        Object[] objArr = new Object[i];
        this.elements = objArr;
        this.maxElements = objArr.length;
    }

    public BoundedFifoBuffer(Collection collection) {
        this(collection.size());
        addAll(collection);
    }
}
