package org.apache.commons.collections.iterators;

import java.util.Iterator;
import org.apache.commons.collections.Transformer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class TransformIterator implements Iterator {
    private Iterator iterator;
    private Transformer transformer;

    public TransformIterator() {
    }

    public Iterator getIterator() {
        return this.iterator;
    }

    public Transformer getTransformer() {
        return this.transformer;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.iterator.hasNext();
    }

    @Override // java.util.Iterator
    public Object next() {
        return transform(this.iterator.next());
    }

    @Override // java.util.Iterator
    public void remove() {
        this.iterator.remove();
    }

    public void setIterator(Iterator it) {
        this.iterator = it;
    }

    public void setTransformer(Transformer transformer) {
        this.transformer = transformer;
    }

    public Object transform(Object obj) {
        Transformer transformer = this.transformer;
        return transformer != null ? transformer.transform(obj) : obj;
    }

    public TransformIterator(Iterator it) {
        this.iterator = it;
    }

    public TransformIterator(Iterator it, Transformer transformer) {
        this.iterator = it;
        this.transformer = transformer;
    }
}
