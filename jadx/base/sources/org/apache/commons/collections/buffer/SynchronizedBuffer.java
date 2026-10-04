package org.apache.commons.collections.buffer;

import org.apache.commons.collections.Buffer;
import org.apache.commons.collections.collection.SynchronizedCollection;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class SynchronizedBuffer extends SynchronizedCollection implements Buffer {
    private static final long serialVersionUID = -6859936183953626253L;

    public SynchronizedBuffer(Buffer buffer) {
        super(buffer);
    }

    public static Buffer decorate(Buffer buffer) {
        return new SynchronizedBuffer(buffer);
    }

    public Object get() {
        Object obj;
        synchronized (this.lock) {
            obj = getBuffer().get();
        }
        return obj;
    }

    public Buffer getBuffer() {
        return (Buffer) this.collection;
    }

    public Object remove() {
        Object objRemove;
        synchronized (this.lock) {
            objRemove = getBuffer().remove();
        }
        return objRemove;
    }

    public SynchronizedBuffer(Buffer buffer, Object obj) {
        super(buffer, obj);
    }
}
