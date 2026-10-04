package org.hamcrest.internal;

import java.util.Iterator;
import org.hamcrest.SelfDescribing;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class SelfDescribingValueIterator<T> implements Iterator<SelfDescribing> {
    private Iterator<T> values;

    public SelfDescribingValueIterator(Iterator<T> it) {
        this.values = it;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.values.hasNext();
    }

    @Override // java.util.Iterator
    public void remove() {
        this.values.remove();
    }

    @Override // java.util.Iterator
    public SelfDescribing next() {
        return new SelfDescribingValue(this.values.next());
    }
}
