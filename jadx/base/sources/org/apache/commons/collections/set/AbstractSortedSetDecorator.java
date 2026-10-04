package org.apache.commons.collections.set;

import java.util.Comparator;
import java.util.Set;
import java.util.SortedSet;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public abstract class AbstractSortedSetDecorator extends AbstractSetDecorator implements SortedSet {
    public AbstractSortedSetDecorator() {
    }

    @Override // java.util.SortedSet
    public Comparator comparator() {
        return getSortedSet().comparator();
    }

    @Override // java.util.SortedSet
    public Object first() {
        return getSortedSet().first();
    }

    public SortedSet getSortedSet() {
        return (SortedSet) getCollection();
    }

    @Override // java.util.SortedSet
    public SortedSet headSet(Object obj) {
        return getSortedSet().headSet(obj);
    }

    @Override // java.util.SortedSet
    public Object last() {
        return getSortedSet().last();
    }

    @Override // java.util.SortedSet
    public SortedSet subSet(Object obj, Object obj2) {
        return getSortedSet().subSet(obj, obj2);
    }

    @Override // java.util.SortedSet
    public SortedSet tailSet(Object obj) {
        return getSortedSet().tailSet(obj);
    }

    public AbstractSortedSetDecorator(Set set) {
        super(set);
    }
}
