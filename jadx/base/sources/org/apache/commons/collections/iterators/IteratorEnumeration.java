package org.apache.commons.collections.iterators;

import java.util.Enumeration;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class IteratorEnumeration implements Enumeration {
    private Iterator iterator;

    public IteratorEnumeration() {
    }

    public Iterator getIterator() {
        return this.iterator;
    }

    @Override // java.util.Enumeration
    public boolean hasMoreElements() {
        return this.iterator.hasNext();
    }

    @Override // java.util.Enumeration
    public Object nextElement() {
        return this.iterator.next();
    }

    public void setIterator(Iterator it) {
        this.iterator = it;
    }

    public IteratorEnumeration(Iterator it) {
        this.iterator = it;
    }
}
