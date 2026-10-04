package org.apache.commons.collections4.bag;

import java.util.Comparator;
import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.SortedBag;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class SynchronizedSortedBag<E> extends SynchronizedBag<E> implements SortedBag<E> {
    private static final long serialVersionUID = 722374056718497858L;

    public SynchronizedSortedBag(Bag<E> bag, Object obj) {
        super(bag, obj);
    }

    public static <E> SynchronizedSortedBag<E> synchronizedSortedBag(SortedBag<E> sortedBag) {
        return new SynchronizedSortedBag<>(sortedBag);
    }

    @Override // org.apache.commons.collections4.SortedBag
    public synchronized Comparator<? super E> comparator() {
        Comparator<? super E> comparator;
        synchronized (this.lock) {
            comparator = getSortedBag().comparator();
        }
        return comparator;
    }

    @Override // org.apache.commons.collections4.SortedBag
    public synchronized E first() {
        E eFirst;
        synchronized (this.lock) {
            eFirst = getSortedBag().first();
        }
        return eFirst;
    }

    public SortedBag<E> getSortedBag() {
        return (SortedBag) decorated();
    }

    @Override // org.apache.commons.collections4.SortedBag
    public synchronized E last() {
        E eLast;
        synchronized (this.lock) {
            eLast = getSortedBag().last();
        }
        return eLast;
    }

    public SynchronizedSortedBag(SortedBag<E> sortedBag) {
        super(sortedBag);
    }
}
