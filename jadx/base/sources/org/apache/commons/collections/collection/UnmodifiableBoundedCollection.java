package org.apache.commons.collections.collection;

import java.util.Collection;
import java.util.Iterator;
import org.apache.commons.collections.BoundedCollection;
import org.apache.commons.collections.iterators.UnmodifiableIterator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class UnmodifiableBoundedCollection extends AbstractSerializableCollectionDecorator implements BoundedCollection {
    private static final long serialVersionUID = -7112672385450340330L;

    private UnmodifiableBoundedCollection(BoundedCollection boundedCollection) {
        super(boundedCollection);
    }

    public static BoundedCollection decorate(BoundedCollection boundedCollection) {
        return new UnmodifiableBoundedCollection(boundedCollection);
    }

    public static BoundedCollection decorateUsing(Collection collection) {
        if (collection == null) {
            throw new IllegalArgumentException("The collection must not be null");
        }
        for (int i = 0; i < 1000 && !(collection instanceof BoundedCollection); i++) {
            if (!(collection instanceof AbstractCollectionDecorator)) {
                if (!(collection instanceof SynchronizedCollection)) {
                    break;
                }
                collection = ((SynchronizedCollection) collection).collection;
            } else {
                collection = ((AbstractCollectionDecorator) collection).collection;
            }
        }
        if (collection instanceof BoundedCollection) {
            return new UnmodifiableBoundedCollection((BoundedCollection) collection);
        }
        throw new IllegalArgumentException("The collection is not a bounded collection");
    }

    @Override // org.apache.commons.collections.collection.AbstractCollectionDecorator, java.util.Collection, org.apache.commons.collections.Bag
    public boolean add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // org.apache.commons.collections.collection.AbstractCollectionDecorator, java.util.Collection
    public boolean addAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // org.apache.commons.collections.collection.AbstractCollectionDecorator, java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // org.apache.commons.collections.BoundedCollection
    public boolean isFull() {
        return ((BoundedCollection) this.collection).isFull();
    }

    @Override // org.apache.commons.collections.collection.AbstractCollectionDecorator, java.util.Collection, java.lang.Iterable, org.apache.commons.collections.Bag
    public Iterator iterator() {
        return UnmodifiableIterator.decorate(getCollection().iterator());
    }

    @Override // org.apache.commons.collections.BoundedCollection
    public int maxSize() {
        return ((BoundedCollection) this.collection).maxSize();
    }

    @Override // org.apache.commons.collections.collection.AbstractCollectionDecorator, java.util.Collection, org.apache.commons.collections.Bag
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // org.apache.commons.collections.collection.AbstractCollectionDecorator, java.util.Collection, org.apache.commons.collections.Bag
    public boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // org.apache.commons.collections.collection.AbstractCollectionDecorator, java.util.Collection, org.apache.commons.collections.Bag
    public boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException();
    }
}
