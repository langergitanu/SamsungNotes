package org.apache.commons.collections.buffer;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Collection;
import java.util.Iterator;
import org.apache.commons.collections.BoundedCollection;
import org.apache.commons.collections.Buffer;
import org.apache.commons.collections.BufferOverflowException;
import org.apache.commons.collections.BufferUnderflowException;
import org.apache.commons.collections.collection.SynchronizedCollection;
import org.apache.commons.collections.iterators.AbstractIteratorDecorator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class BoundedBuffer extends SynchronizedBuffer implements BoundedCollection {
    private static final long serialVersionUID = 1536432911093974264L;
    private final int maximumSize;
    private final long timeout;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class NotifyingIterator extends AbstractIteratorDecorator {
        private final /* synthetic */ BoundedBuffer this$0;

        public NotifyingIterator(BoundedBuffer boundedBuffer, Iterator it) {
            super(it);
            this.this$0 = boundedBuffer;
        }

        @Override // org.apache.commons.collections.iterators.AbstractIteratorDecorator, java.util.Iterator
        public void remove() {
            synchronized (((SynchronizedCollection) this.this$0).lock) {
                this.iterator.remove();
                ((SynchronizedCollection) this.this$0).lock.notifyAll();
            }
        }
    }

    public BoundedBuffer(Buffer buffer, int i, long j) {
        super(buffer);
        if (i < 1) {
            throw new IllegalArgumentException();
        }
        this.maximumSize = i;
        this.timeout = j;
    }

    public static BoundedBuffer decorate(Buffer buffer, int i) {
        return new BoundedBuffer(buffer, i, 0L);
    }

    private void timeoutWait(int i) {
        if (i > this.maximumSize) {
            StringBuffer stringBuffer = new StringBuffer("Buffer size cannot exceed ");
            stringBuffer.append(this.maximumSize);
            throw new BufferOverflowException(stringBuffer.toString());
        }
        if (this.timeout <= 0) {
            if (getBuffer().size() + i <= this.maximumSize) {
                return;
            }
            StringBuffer stringBuffer2 = new StringBuffer("Buffer size cannot exceed ");
            stringBuffer2.append(this.maximumSize);
            throw new BufferOverflowException(stringBuffer2.toString());
        }
        long jCurrentTimeMillis = System.currentTimeMillis() + this.timeout;
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        while (true) {
            long j = jCurrentTimeMillis - jCurrentTimeMillis2;
            if (j <= 0 || getBuffer().size() + i <= this.maximumSize) {
                break;
            }
            try {
                this.lock.wait(j);
                jCurrentTimeMillis2 = System.currentTimeMillis();
            } catch (InterruptedException e) {
                PrintWriter printWriter = new PrintWriter(new StringWriter());
                e.printStackTrace(printWriter);
                StringBuffer stringBuffer3 = new StringBuffer("Caused by InterruptedException: ");
                stringBuffer3.append(printWriter.toString());
                throw new BufferUnderflowException(stringBuffer3.toString());
            }
        }
        if (getBuffer().size() + i > this.maximumSize) {
            throw new BufferOverflowException("Timeout expired");
        }
    }

    @Override // org.apache.commons.collections.collection.SynchronizedCollection, java.util.Collection
    public boolean add(Object obj) {
        boolean zAdd;
        synchronized (this.lock) {
            timeoutWait(1);
            zAdd = getBuffer().add(obj);
        }
        return zAdd;
    }

    @Override // org.apache.commons.collections.collection.SynchronizedCollection, java.util.Collection
    public boolean addAll(Collection collection) {
        boolean zAddAll;
        synchronized (this.lock) {
            timeoutWait(collection.size());
            zAddAll = getBuffer().addAll(collection);
        }
        return zAddAll;
    }

    @Override // org.apache.commons.collections.BoundedCollection
    public boolean isFull() {
        return size() == maxSize();
    }

    @Override // org.apache.commons.collections.collection.SynchronizedCollection, java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return new NotifyingIterator(this, this.collection.iterator());
    }

    @Override // org.apache.commons.collections.BoundedCollection
    public int maxSize() {
        return this.maximumSize;
    }

    @Override // org.apache.commons.collections.buffer.SynchronizedBuffer, org.apache.commons.collections.Buffer
    public Object remove() {
        Object objRemove;
        synchronized (this.lock) {
            objRemove = getBuffer().remove();
            this.lock.notifyAll();
        }
        return objRemove;
    }

    public static BoundedBuffer decorate(Buffer buffer, int i, long j) {
        return new BoundedBuffer(buffer, i, j);
    }
}
