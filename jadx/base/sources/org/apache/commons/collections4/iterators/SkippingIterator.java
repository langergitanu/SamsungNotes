package org.apache.commons.collections4.iterators;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class SkippingIterator<E> extends AbstractIteratorDecorator<E> {
    private final long offset;
    private long pos;

    public SkippingIterator(Iterator<E> it, long j) {
        super(it);
        if (j < 0) {
            throw new IllegalArgumentException("Offset parameter must not be negative.");
        }
        this.offset = j;
        this.pos = 0L;
        init();
    }

    private void init() {
        while (this.pos < this.offset && hasNext()) {
            next();
        }
    }

    @Override // org.apache.commons.collections4.iterators.AbstractIteratorDecorator, java.util.Iterator
    public E next() {
        E e = (E) super.next();
        this.pos++;
        return e;
    }

    @Override // org.apache.commons.collections4.iterators.AbstractUntypedIteratorDecorator, java.util.Iterator
    public void remove() {
        if (this.pos <= this.offset) {
            throw new IllegalStateException("remove() cannot be called before calling next()");
        }
        super.remove();
    }
}
