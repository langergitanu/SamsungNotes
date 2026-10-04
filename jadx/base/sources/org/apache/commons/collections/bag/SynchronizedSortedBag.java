package org.apache.commons.collections.bag;

import java.util.Comparator;
import org.apache.commons.collections.Bag;
import org.apache.commons.collections.SortedBag;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class SynchronizedSortedBag extends SynchronizedBag implements SortedBag {
    private static final long serialVersionUID = 722374056718497858L;

    public SynchronizedSortedBag(SortedBag sortedBag) {
        super(sortedBag);
    }

    public static SortedBag decorate(SortedBag sortedBag) {
        return new SynchronizedSortedBag(sortedBag);
    }

    @Override // org.apache.commons.collections.SortedBag
    public synchronized Comparator comparator() {
        Comparator comparator;
        synchronized (this.lock) {
            comparator = getSortedBag().comparator();
        }
        return comparator;
    }

    @Override // org.apache.commons.collections.SortedBag
    public synchronized Object first() {
        Object objFirst;
        synchronized (this.lock) {
            objFirst = getSortedBag().first();
        }
        return objFirst;
    }

    public SortedBag getSortedBag() {
        return (SortedBag) this.collection;
    }

    @Override // org.apache.commons.collections.SortedBag
    public synchronized Object last() {
        Object objLast;
        synchronized (this.lock) {
            objLast = getSortedBag().last();
        }
        return objLast;
    }

    public SynchronizedSortedBag(Bag bag, Object obj) {
        super(bag, obj);
    }
}
