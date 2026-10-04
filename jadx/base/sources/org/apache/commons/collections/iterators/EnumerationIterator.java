package org.apache.commons.collections.iterators;

import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class EnumerationIterator implements Iterator {
    private Collection collection;
    private Enumeration enumeration;
    private Object last;

    public EnumerationIterator() {
        this(null, null);
    }

    public Enumeration getEnumeration() {
        return this.enumeration;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.enumeration.hasMoreElements();
    }

    @Override // java.util.Iterator
    public Object next() {
        Object objNextElement = this.enumeration.nextElement();
        this.last = objNextElement;
        return objNextElement;
    }

    @Override // java.util.Iterator
    public void remove() {
        Collection collection = this.collection;
        if (collection == null) {
            throw new UnsupportedOperationException("No Collection associated with this Iterator");
        }
        Object obj = this.last;
        if (obj == null) {
            throw new IllegalStateException("next() must have been called for remove() to function");
        }
        collection.remove(obj);
    }

    public void setEnumeration(Enumeration enumeration) {
        this.enumeration = enumeration;
    }

    public EnumerationIterator(Enumeration enumeration) {
        this(enumeration, null);
    }

    public EnumerationIterator(Enumeration enumeration, Collection collection) {
        this.enumeration = enumeration;
        this.collection = collection;
        this.last = null;
    }
}
