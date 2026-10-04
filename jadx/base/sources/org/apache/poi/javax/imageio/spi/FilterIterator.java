package org.apache.poi.javax.imageio.spi;

import java.util.Iterator;
import java.util.NoSuchElementException;
import org.apache.poi.javax.imageio.spi.ServiceRegistry;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
class FilterIterator<T> implements Iterator<T> {
    private ServiceRegistry.Filter filter;
    private Iterator<T> iter;
    private T next = null;

    public FilterIterator(Iterator<T> it, ServiceRegistry.Filter filter) {
        this.iter = it;
        this.filter = filter;
        advance();
    }

    private void advance() {
        while (this.iter.hasNext()) {
            T next = this.iter.next();
            if (this.filter.filter(next)) {
                this.next = next;
                return;
            }
        }
        this.next = null;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.next != null;
    }

    @Override // java.util.Iterator
    public T next() {
        T t = this.next;
        if (t == null) {
            throw new NoSuchElementException();
        }
        advance();
        return t;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
