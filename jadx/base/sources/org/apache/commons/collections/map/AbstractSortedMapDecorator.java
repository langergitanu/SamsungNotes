package org.apache.commons.collections.map;

import java.util.Comparator;
import java.util.SortedMap;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public abstract class AbstractSortedMapDecorator extends AbstractMapDecorator implements SortedMap {
    public AbstractSortedMapDecorator() {
    }

    @Override // java.util.SortedMap
    public Comparator comparator() {
        return getSortedMap().comparator();
    }

    @Override // java.util.SortedMap
    public Object firstKey() {
        return getSortedMap().firstKey();
    }

    public SortedMap getSortedMap() {
        return (SortedMap) this.map;
    }

    public SortedMap headMap(Object obj) {
        return getSortedMap().headMap(obj);
    }

    @Override // java.util.SortedMap
    public Object lastKey() {
        return getSortedMap().lastKey();
    }

    public SortedMap subMap(Object obj, Object obj2) {
        return getSortedMap().subMap(obj, obj2);
    }

    public SortedMap tailMap(Object obj) {
        return getSortedMap().tailMap(obj);
    }

    public AbstractSortedMapDecorator(SortedMap sortedMap) {
        super(sortedMap);
    }
}
