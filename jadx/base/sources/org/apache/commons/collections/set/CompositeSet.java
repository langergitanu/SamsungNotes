package org.apache.commons.collections.set;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.collection.CompositeCollection;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class CompositeSet extends CompositeCollection implements Set {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface SetMutator extends CompositeCollection.CollectionMutator {
        void resolveCollision(CompositeSet compositeSet, Set set, Set set2, Collection collection);
    }

    public CompositeSet() {
    }

    @Override // org.apache.commons.collections.collection.CompositeCollection
    public synchronized void addComposited(Collection collection) {
        try {
            if (!(collection instanceof Set)) {
                throw new IllegalArgumentException("Collections added must implement java.util.Set");
            }
            for (Set set : getCollections()) {
                Collection collectionIntersection = CollectionUtils.intersection(set, collection);
                if (collectionIntersection.size() > 0) {
                    CompositeCollection.CollectionMutator collectionMutator = this.mutator;
                    if (collectionMutator == null) {
                        throw new UnsupportedOperationException("Collision adding composited collection with no SetMutator set");
                    }
                    if (!(collectionMutator instanceof SetMutator)) {
                        throw new UnsupportedOperationException("Collision adding composited collection to a CompositeSet with a CollectionMutator instead of a SetMutator");
                    }
                    ((SetMutator) collectionMutator).resolveCollision(this, set, (Set) collection, collectionIntersection);
                    if (CollectionUtils.intersection(set, collection).size() > 0) {
                        throw new IllegalArgumentException("Attempt to add illegal entry unresolved by SetMutator.resolveCollision()");
                    }
                }
            }
            super.addComposited(new Collection[]{collection});
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (!(obj instanceof Set)) {
            return false;
        }
        Set set = (Set) obj;
        return set.containsAll(this) && set.size() == size();
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        Iterator it = iterator();
        int iHashCode = 0;
        while (it.hasNext()) {
            Object next = it.next();
            iHashCode += next != null ? next.hashCode() : 0;
        }
        return iHashCode;
    }

    @Override // org.apache.commons.collections.collection.CompositeCollection, java.util.Collection
    public boolean remove(Object obj) {
        for (Set set : getCollections()) {
            if (set.contains(obj)) {
                return set.remove(obj);
            }
        }
        return false;
    }

    @Override // org.apache.commons.collections.collection.CompositeCollection
    public void setMutator(CompositeCollection.CollectionMutator collectionMutator) {
        super.setMutator(collectionMutator);
    }

    public CompositeSet(Set set) {
        super(set);
    }

    public CompositeSet(Set[] setArr) {
        super(setArr);
    }

    @Override // org.apache.commons.collections.collection.CompositeCollection
    public synchronized void addComposited(Collection collection, Collection collection2) {
        if (collection instanceof Set) {
            if (!(collection2 instanceof Set)) {
                throw new IllegalArgumentException("Argument must implement java.util.Set");
            }
            addComposited(new Set[]{(Set) collection, (Set) collection2});
        } else {
            throw new IllegalArgumentException("Argument must implement java.util.Set");
        }
    }

    @Override // org.apache.commons.collections.collection.CompositeCollection
    public synchronized void addComposited(Collection[] collectionArr) {
        for (int length = collectionArr.length - 1; length >= 0; length--) {
            addComposited(collectionArr[length]);
        }
    }
}
