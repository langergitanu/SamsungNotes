package org.apache.commons.collections.buffer;

import org.apache.commons.collections.Buffer;
import org.apache.commons.collections.Transformer;
import org.apache.commons.collections.collection.TransformedCollection;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class TransformedBuffer extends TransformedCollection implements Buffer {
    private static final long serialVersionUID = -7901091318986132033L;

    public TransformedBuffer(Buffer buffer, Transformer transformer) {
        super(buffer, transformer);
    }

    public static Buffer decorate(Buffer buffer, Transformer transformer) {
        return new TransformedBuffer(buffer, transformer);
    }

    @Override // org.apache.commons.collections.Buffer
    public Object get() {
        return getBuffer().get();
    }

    public Buffer getBuffer() {
        return (Buffer) this.collection;
    }

    @Override // org.apache.commons.collections.Buffer
    public Object remove() {
        return getBuffer().remove();
    }
}
