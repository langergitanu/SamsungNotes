package org.apache.commons.collections4.bag;

import java.util.Set;
import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.collection.SynchronizedCollection;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class SynchronizedBag<E> extends SynchronizedCollection<E> implements Bag<E> {
    private static final long serialVersionUID = 8084674570753837109L;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public final class SynchronizedBagSet extends SynchronizedCollection<E> implements Set<E> {
        private static final long serialVersionUID = 2990565892366827855L;

        public SynchronizedBagSet(Set<E> set, Object obj) {
            super(set, obj);
        }
    }

    public SynchronizedBag(Bag<E> bag) {
        super(bag);
    }

    public static <E> SynchronizedBag<E> synchronizedBag(Bag<E> bag) {
        return new SynchronizedBag<>(bag);
    }

    @Override // org.apache.commons.collections4.Bag
    public boolean add(E e, int i) {
        boolean zAdd;
        synchronized (this.lock) {
            zAdd = getBag().add(e, i);
        }
        return zAdd;
    }

    @Override // org.apache.commons.collections4.collection.SynchronizedCollection, java.util.Collection
    public boolean equals(Object obj) {
        boolean zEquals;
        if (obj == this) {
            return true;
        }
        synchronized (this.lock) {
            zEquals = getBag().equals(obj);
        }
        return zEquals;
    }

    public Bag<E> getBag() {
        return (Bag) decorated();
    }

    @Override // org.apache.commons.collections4.Bag
    public int getCount(Object obj) {
        int count;
        synchronized (this.lock) {
            count = getBag().getCount(obj);
        }
        return count;
    }

    @Override // org.apache.commons.collections4.collection.SynchronizedCollection, java.util.Collection
    public int hashCode() {
        int iHashCode;
        synchronized (this.lock) {
            iHashCode = getBag().hashCode();
        }
        return iHashCode;
    }

    @Override // org.apache.commons.collections4.Bag
    public boolean remove(Object obj, int i) {
        boolean zRemove;
        synchronized (this.lock) {
            zRemove = getBag().remove(obj, i);
        }
        return zRemove;
    }

    @Override // org.apache.commons.collections4.Bag
    public Set<E> uniqueSet() {
        SynchronizedBagSet synchronizedBagSet;
        synchronized (this.lock) {
            synchronizedBagSet = new SynchronizedBagSet(getBag().uniqueSet(), this.lock);
        }
        return synchronizedBagSet;
    }

    public SynchronizedBag(Bag<E> bag, Object obj) {
        super(bag, obj);
    }
}
