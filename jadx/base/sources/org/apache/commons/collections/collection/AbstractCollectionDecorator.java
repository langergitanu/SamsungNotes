package org.apache.commons.collections.collection;

import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public abstract class AbstractCollectionDecorator implements Collection {
    protected Collection collection;

    public AbstractCollectionDecorator() {
    }

    @Override // java.util.Collection, org.apache.commons.collections.Bag
    public boolean add(Object obj) {
        return this.collection.add(obj);
    }

    @Override // java.util.Collection
    public boolean addAll(Collection collection) {
        return this.collection.addAll(collection);
    }

    @Override // java.util.Collection
    public void clear() {
        this.collection.clear();
    }

    @Override // java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return this.collection.contains(obj);
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection collection) {
        return this.collection.containsAll(collection);
    }

    @Override // java.util.Collection
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return this.collection.equals(obj);
    }

    public Collection getCollection() {
        return this.collection;
    }

    @Override // java.util.Collection
    public int hashCode() {
        return this.collection.hashCode();
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return this.collection.isEmpty();
    }

    @Override // java.util.Collection, java.lang.Iterable, org.apache.commons.collections.Bag
    public Iterator iterator() {
        return this.collection.iterator();
    }

    @Override // java.util.Collection, org.apache.commons.collections.Bag
    public boolean remove(Object obj) {
        return this.collection.remove(obj);
    }

    @Override // java.util.Collection, org.apache.commons.collections.Bag
    public boolean removeAll(Collection collection) {
        return this.collection.removeAll(collection);
    }

    @Override // java.util.Collection, org.apache.commons.collections.Bag
    public boolean retainAll(Collection collection) {
        return this.collection.retainAll(collection);
    }

    @Override // java.util.Collection
    public int size() {
        return this.collection.size();
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        return this.collection.toArray();
    }

    public String toString() {
        return this.collection.toString();
    }

    public AbstractCollectionDecorator(Collection collection) {
        if (collection == null) {
            throw new IllegalArgumentException("Collection must not be null");
        }
        this.collection = collection;
    }

    @Override // java.util.Collection
    public Object[] toArray(Object[] objArr) {
        return this.collection.toArray(objArr);
    }
}
