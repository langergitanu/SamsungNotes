package org.apache.commons.collections;

import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.AbstractCollection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class BinaryHeap extends AbstractCollection implements PriorityQueue, Buffer {
    private static final int DEFAULT_CAPACITY = 13;
    Comparator m_comparator;
    Object[] m_elements;
    boolean m_isMinHeap;
    int m_size;

    public BinaryHeap() {
        this(13, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int compare(Object obj, Object obj2) {
        Comparator comparator = this.m_comparator;
        return comparator != null ? comparator.compare(obj, obj2) : ((Comparable) obj).compareTo(obj2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean add(Object obj) {
        insert(obj);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, org.apache.commons.collections.PriorityQueue
    public void clear() {
        this.m_elements = new Object[this.m_elements.length];
        this.m_size = 0;
    }

    @Override // org.apache.commons.collections.Buffer
    public Object get() {
        try {
            return peek();
        } catch (NoSuchElementException unused) {
            throw new BufferUnderflowException();
        }
    }

    public void grow() {
        Object[] objArr = this.m_elements;
        Object[] objArr2 = new Object[objArr.length * 2];
        System.arraycopy(objArr, 0, objArr2, 0, objArr.length);
        this.m_elements = objArr2;
    }

    @Override // org.apache.commons.collections.PriorityQueue
    public void insert(Object obj) {
        if (isFull()) {
            grow();
        }
        if (this.m_isMinHeap) {
            percolateUpMinHeap(obj);
        } else {
            percolateUpMaxHeap(obj);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, org.apache.commons.collections.PriorityQueue
    public boolean isEmpty() {
        return this.m_size == 0;
    }

    public boolean isFull() {
        return this.m_elements.length == this.m_size + 1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return new Iterator() { // from class: org.apache.commons.collections.BinaryHeap.1
            private int index = 1;
            private int lastReturnedIndex = -1;

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index <= BinaryHeap.this.m_size;
            }

            @Override // java.util.Iterator
            public Object next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                int i = this.index;
                this.lastReturnedIndex = i;
                this.index = i + 1;
                return BinaryHeap.this.m_elements[i];
            }

            @Override // java.util.Iterator
            public void remove() {
                int i = this.lastReturnedIndex;
                if (i == -1) {
                    throw new IllegalStateException();
                }
                BinaryHeap binaryHeap = BinaryHeap.this;
                Object[] objArr = binaryHeap.m_elements;
                int i2 = binaryHeap.m_size;
                objArr[i] = objArr[i2];
                objArr[i2] = null;
                int i4 = i2 - 1;
                binaryHeap.m_size = i4;
                if (i4 != 0 && i <= i4) {
                    int iCompare = i > 1 ? binaryHeap.compare(objArr[i], objArr[i / 2]) : 0;
                    BinaryHeap binaryHeap2 = BinaryHeap.this;
                    if (binaryHeap2.m_isMinHeap) {
                        int i5 = this.lastReturnedIndex;
                        if (i5 <= 1 || iCompare >= 0) {
                            binaryHeap2.percolateDownMinHeap(i5);
                        } else {
                            binaryHeap2.percolateUpMinHeap(i5);
                        }
                    } else {
                        int i6 = this.lastReturnedIndex;
                        if (i6 <= 1 || iCompare <= 0) {
                            binaryHeap2.percolateDownMaxHeap(i6);
                        } else {
                            binaryHeap2.percolateUpMaxHeap(i6);
                        }
                    }
                }
                this.index--;
                this.lastReturnedIndex = -1;
            }
        };
    }

    @Override // org.apache.commons.collections.PriorityQueue
    public Object peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return this.m_elements[1];
    }

    public void percolateDownMaxHeap(int i) {
        Object obj = this.m_elements[i];
        while (true) {
            int i2 = i * 2;
            int i4 = this.m_size;
            if (i2 > i4) {
                break;
            }
            if (i2 != i4) {
                Object[] objArr = this.m_elements;
                int i5 = i2 + 1;
                if (compare(objArr[i5], objArr[i2]) > 0) {
                    i2 = i5;
                }
            }
            if (compare(this.m_elements[i2], obj) <= 0) {
                break;
            }
            Object[] objArr2 = this.m_elements;
            objArr2[i] = objArr2[i2];
            i = i2;
        }
        this.m_elements[i] = obj;
    }

    public void percolateDownMinHeap(int i) {
        Object obj = this.m_elements[i];
        while (true) {
            int i2 = i * 2;
            int i4 = this.m_size;
            if (i2 > i4) {
                break;
            }
            if (i2 != i4) {
                Object[] objArr = this.m_elements;
                int i5 = i2 + 1;
                if (compare(objArr[i5], objArr[i2]) < 0) {
                    i2 = i5;
                }
            }
            if (compare(this.m_elements[i2], obj) >= 0) {
                break;
            }
            Object[] objArr2 = this.m_elements;
            objArr2[i] = objArr2[i2];
            i = i2;
        }
        this.m_elements[i] = obj;
    }

    public void percolateUpMaxHeap(int i) {
        Object obj = this.m_elements[i];
        while (i > 1) {
            int i2 = i / 2;
            if (compare(obj, this.m_elements[i2]) <= 0) {
                break;
            }
            Object[] objArr = this.m_elements;
            objArr[i] = objArr[i2];
            i = i2;
        }
        this.m_elements[i] = obj;
    }

    public void percolateUpMinHeap(int i) {
        Object obj = this.m_elements[i];
        while (i > 1) {
            int i2 = i / 2;
            if (compare(obj, this.m_elements[i2]) >= 0) {
                break;
            }
            Object[] objArr = this.m_elements;
            objArr[i] = objArr[i2];
            i = i2;
        }
        this.m_elements[i] = obj;
    }

    @Override // org.apache.commons.collections.PriorityQueue
    public Object pop() {
        Object objPeek = peek();
        Object[] objArr = this.m_elements;
        int i = this.m_size;
        int i2 = i - 1;
        this.m_size = i2;
        objArr[1] = objArr[i];
        objArr[i] = null;
        if (i2 != 0) {
            if (this.m_isMinHeap) {
                percolateDownMinHeap(1);
                return objPeek;
            }
            percolateDownMaxHeap(1);
        }
        return objPeek;
    }

    @Override // org.apache.commons.collections.Buffer
    public Object remove() {
        try {
            return pop();
        } catch (NoSuchElementException unused) {
            throw new BufferUnderflowException();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        return this.m_size;
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("[ ");
        for (int i = 1; i < this.m_size + 1; i++) {
            if (i != 1) {
                stringBuffer.append(SQLKeyword.COMMA);
            }
            stringBuffer.append(this.m_elements[i]);
        }
        stringBuffer.append(" ]");
        return stringBuffer.toString();
    }

    public BinaryHeap(Comparator comparator) {
        this();
        this.m_comparator = comparator;
    }

    public BinaryHeap(int i) {
        this(i, true);
    }

    public BinaryHeap(int i, Comparator comparator) {
        this(i);
        this.m_comparator = comparator;
    }

    public void percolateUpMaxHeap(Object obj) {
        Object[] objArr = this.m_elements;
        int i = this.m_size + 1;
        this.m_size = i;
        objArr[i] = obj;
        percolateUpMaxHeap(i);
    }

    public void percolateUpMinHeap(Object obj) {
        Object[] objArr = this.m_elements;
        int i = this.m_size + 1;
        this.m_size = i;
        objArr[i] = obj;
        percolateUpMinHeap(i);
    }

    public BinaryHeap(boolean z) {
        this(13, z);
    }

    public BinaryHeap(boolean z, Comparator comparator) {
        this(z);
        this.m_comparator = comparator;
    }

    public BinaryHeap(int i, boolean z) {
        if (i > 0) {
            this.m_isMinHeap = z;
            this.m_elements = new Object[i + 1];
            return;
        }
        throw new IllegalArgumentException("invalid capacity");
    }

    public BinaryHeap(int i, boolean z, Comparator comparator) {
        this(i, z);
        this.m_comparator = comparator;
    }
}
