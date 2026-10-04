package org.apache.commons.collections.bag;

import java.util.Set;
import org.apache.commons.collections.Bag;
import org.apache.commons.collections.collection.SynchronizedCollection;
import org.apache.commons.collections.set.SynchronizedSet;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class SynchronizedBag extends SynchronizedCollection implements Bag {
    private static final long serialVersionUID = 8084674570753837109L;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class SynchronizedBagSet extends SynchronizedSet {
        private final /* synthetic */ SynchronizedBag this$0;

        public SynchronizedBagSet(SynchronizedBag synchronizedBag, Set set, Object obj) {
            super(set, obj);
            this.this$0 = synchronizedBag;
        }
    }

    public SynchronizedBag(Bag bag) {
        super(bag);
    }

    public static Bag decorate(Bag bag) {
        return new SynchronizedBag(bag);
    }

    @Override // org.apache.commons.collections.Bag
    public boolean add(Object obj, int i) {
        boolean zAdd;
        synchronized (this.lock) {
            zAdd = getBag().add(obj, i);
        }
        return zAdd;
    }

    public Bag getBag() {
        return (Bag) this.collection;
    }

    @Override // org.apache.commons.collections.Bag
    public int getCount(Object obj) {
        int count;
        synchronized (this.lock) {
            count = getBag().getCount(obj);
        }
        return count;
    }

    @Override // org.apache.commons.collections.Bag
    public boolean remove(Object obj, int i) {
        boolean zRemove;
        synchronized (this.lock) {
            zRemove = getBag().remove(obj, i);
        }
        return zRemove;
    }

    @Override // org.apache.commons.collections.Bag
    public Set uniqueSet() {
        SynchronizedBagSet synchronizedBagSet;
        synchronized (this.lock) {
            synchronizedBagSet = new SynchronizedBagSet(this, getBag().uniqueSet(), this.lock);
        }
        return synchronizedBagSet;
    }

    public SynchronizedBag(Bag bag, Object obj) {
        super(bag, obj);
    }
}
