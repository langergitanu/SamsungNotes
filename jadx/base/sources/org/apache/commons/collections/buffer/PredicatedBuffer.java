package org.apache.commons.collections.buffer;

import org.apache.commons.collections.Buffer;
import org.apache.commons.collections.Predicate;
import org.apache.commons.collections.collection.PredicatedCollection;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class PredicatedBuffer extends PredicatedCollection implements Buffer {
    private static final long serialVersionUID = 2307609000539943581L;

    public PredicatedBuffer(Buffer buffer, Predicate predicate) {
        super(buffer, predicate);
    }

    public static Buffer decorate(Buffer buffer, Predicate predicate) {
        return new PredicatedBuffer(buffer, predicate);
    }

    @Override // org.apache.commons.collections.Buffer
    public Object get() {
        return getBuffer().get();
    }

    public Buffer getBuffer() {
        return (Buffer) getCollection();
    }

    @Override // org.apache.commons.collections.Buffer
    public Object remove() {
        return getBuffer().remove();
    }
}
