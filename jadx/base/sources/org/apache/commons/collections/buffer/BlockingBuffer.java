package org.apache.commons.collections.buffer;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Collection;
import org.apache.commons.collections.Buffer;
import org.apache.commons.collections.BufferUnderflowException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class BlockingBuffer extends SynchronizedBuffer {
    private static final long serialVersionUID = 1719328905017860541L;
    private final long timeout;

    public BlockingBuffer(Buffer buffer) {
        super(buffer);
        this.timeout = 0L;
    }

    public static Buffer decorate(Buffer buffer) {
        return new BlockingBuffer(buffer);
    }

    @Override // org.apache.commons.collections.collection.SynchronizedCollection, java.util.Collection
    public boolean add(Object obj) {
        boolean zAdd;
        synchronized (this.lock) {
            zAdd = this.collection.add(obj);
            this.lock.notifyAll();
        }
        return zAdd;
    }

    @Override // org.apache.commons.collections.collection.SynchronizedCollection, java.util.Collection
    public boolean addAll(Collection collection) {
        boolean zAddAll;
        synchronized (this.lock) {
            zAddAll = this.collection.addAll(collection);
            this.lock.notifyAll();
        }
        return zAddAll;
    }

    @Override // org.apache.commons.collections.buffer.SynchronizedBuffer, org.apache.commons.collections.Buffer
    public Object get() {
        synchronized (this.lock) {
            while (this.collection.isEmpty()) {
                try {
                    try {
                        long j = this.timeout;
                        if (j > 0) {
                            return get(j);
                        }
                        this.lock.wait();
                    } catch (InterruptedException e) {
                        PrintWriter printWriter = new PrintWriter(new StringWriter());
                        e.printStackTrace(printWriter);
                        StringBuffer stringBuffer = new StringBuffer();
                        stringBuffer.append("Caused by InterruptedException: ");
                        stringBuffer.append(printWriter.toString());
                        throw new BufferUnderflowException(stringBuffer.toString());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return getBuffer().get();
        }
    }

    @Override // org.apache.commons.collections.buffer.SynchronizedBuffer, org.apache.commons.collections.Buffer
    public Object remove() {
        synchronized (this.lock) {
            while (this.collection.isEmpty()) {
                try {
                    try {
                        long j = this.timeout;
                        if (j > 0) {
                            return remove(j);
                        }
                        this.lock.wait();
                    } catch (InterruptedException e) {
                        PrintWriter printWriter = new PrintWriter(new StringWriter());
                        e.printStackTrace(printWriter);
                        StringBuffer stringBuffer = new StringBuffer();
                        stringBuffer.append("Caused by InterruptedException: ");
                        stringBuffer.append(printWriter.toString());
                        throw new BufferUnderflowException(stringBuffer.toString());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return getBuffer().remove();
        }
    }

    public static Buffer decorate(Buffer buffer, long j) {
        return new BlockingBuffer(buffer, j);
    }

    public BlockingBuffer(Buffer buffer, long j) {
        super(buffer);
        this.timeout = j < 0 ? 0L : j;
    }

    public Object get(long j) {
        Object obj;
        synchronized (this.lock) {
            long jCurrentTimeMillis = System.currentTimeMillis() + j;
            long jCurrentTimeMillis2 = System.currentTimeMillis();
            while (true) {
                long j2 = jCurrentTimeMillis - jCurrentTimeMillis2;
                if (j2 <= 0 || !this.collection.isEmpty()) {
                    break;
                }
                try {
                    this.lock.wait(j2);
                    jCurrentTimeMillis2 = System.currentTimeMillis();
                } catch (InterruptedException e) {
                    PrintWriter printWriter = new PrintWriter(new StringWriter());
                    e.printStackTrace(printWriter);
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("Caused by InterruptedException: ");
                    stringBuffer.append(printWriter.toString());
                    throw new BufferUnderflowException(stringBuffer.toString());
                }
            }
            if (!this.collection.isEmpty()) {
                obj = getBuffer().get();
            } else {
                throw new BufferUnderflowException("Timeout expired");
            }
        }
        return obj;
    }

    public Object remove(long j) {
        Object objRemove;
        synchronized (this.lock) {
            long jCurrentTimeMillis = System.currentTimeMillis() + j;
            long jCurrentTimeMillis2 = System.currentTimeMillis();
            while (true) {
                long j2 = jCurrentTimeMillis - jCurrentTimeMillis2;
                if (j2 <= 0 || !this.collection.isEmpty()) {
                    break;
                }
                try {
                    this.lock.wait(j2);
                    jCurrentTimeMillis2 = System.currentTimeMillis();
                } catch (InterruptedException e) {
                    PrintWriter printWriter = new PrintWriter(new StringWriter());
                    e.printStackTrace(printWriter);
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("Caused by InterruptedException: ");
                    stringBuffer.append(printWriter.toString());
                    throw new BufferUnderflowException(stringBuffer.toString());
                }
            }
            if (!this.collection.isEmpty()) {
                objRemove = getBuffer().remove();
            } else {
                throw new BufferUnderflowException("Timeout expired");
            }
        }
        return objRemove;
    }
}
