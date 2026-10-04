package org.apache.commons.collections.buffer;

import java.util.Collection;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class CircularFifoBuffer extends BoundedFifoBuffer {
    private static final long serialVersionUID = -8423413834657610406L;

    public CircularFifoBuffer() {
        super(32);
    }

    @Override // org.apache.commons.collections.buffer.BoundedFifoBuffer, java.util.AbstractCollection, java.util.Collection
    public boolean add(Object obj) {
        if (isFull()) {
            remove();
        }
        return super.add(obj);
    }

    public CircularFifoBuffer(int i) {
        super(i);
    }

    public CircularFifoBuffer(Collection collection) {
        super(collection);
    }
}
