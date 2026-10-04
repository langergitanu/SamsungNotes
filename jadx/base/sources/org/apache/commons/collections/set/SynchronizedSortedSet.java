package org.apache.commons.collections.set;

import java.util.Comparator;
import java.util.SortedSet;
import org.apache.commons.collections.collection.SynchronizedCollection;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class SynchronizedSortedSet extends SynchronizedCollection implements SortedSet {
    private static final long serialVersionUID = 2775582861954500111L;

    public SynchronizedSortedSet(SortedSet sortedSet) {
        super(sortedSet);
    }

    public static SortedSet decorate(SortedSet sortedSet) {
        return new SynchronizedSortedSet(sortedSet);
    }

    @Override // java.util.SortedSet
    public Comparator comparator() {
        Comparator comparator;
        synchronized (this.lock) {
            comparator = getSortedSet().comparator();
        }
        return comparator;
    }

    @Override // java.util.SortedSet
    public Object first() {
        Object objFirst;
        synchronized (this.lock) {
            objFirst = getSortedSet().first();
        }
        return objFirst;
    }

    public SortedSet getSortedSet() {
        return (SortedSet) this.collection;
    }

    @Override // java.util.SortedSet
    public SortedSet headSet(Object obj) {
        SynchronizedSortedSet synchronizedSortedSet;
        synchronized (this.lock) {
            synchronizedSortedSet = new SynchronizedSortedSet(getSortedSet().headSet(obj), this.lock);
        }
        return synchronizedSortedSet;
    }

    @Override // java.util.SortedSet
    public Object last() {
        Object objLast;
        synchronized (this.lock) {
            objLast = getSortedSet().last();
        }
        return objLast;
    }

    @Override // java.util.SortedSet
    public SortedSet subSet(Object obj, Object obj2) {
        SynchronizedSortedSet synchronizedSortedSet;
        synchronized (this.lock) {
            synchronizedSortedSet = new SynchronizedSortedSet(getSortedSet().subSet(obj, obj2), this.lock);
        }
        return synchronizedSortedSet;
    }

    @Override // java.util.SortedSet
    public SortedSet tailSet(Object obj) {
        SynchronizedSortedSet synchronizedSortedSet;
        synchronized (this.lock) {
            synchronizedSortedSet = new SynchronizedSortedSet(getSortedSet().tailSet(obj), this.lock);
        }
        return synchronizedSortedSet;
    }

    public SynchronizedSortedSet(SortedSet sortedSet, Object obj) {
        super(sortedSet, obj);
    }
}
