package org.apache.commons.collections.bidimap;

import java.util.Comparator;
import java.util.SortedMap;
import org.apache.commons.collections.SortedBidiMap;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public abstract class AbstractSortedBidiMapDecorator extends AbstractOrderedBidiMapDecorator implements SortedBidiMap {
    public AbstractSortedBidiMapDecorator(SortedBidiMap sortedBidiMap) {
        super(sortedBidiMap);
    }

    @Override // java.util.SortedMap
    public Comparator comparator() {
        return getSortedBidiMap().comparator();
    }

    public SortedBidiMap getSortedBidiMap() {
        return (SortedBidiMap) this.map;
    }

    @Override // java.util.SortedMap
    public SortedMap headMap(Object obj) {
        return getSortedBidiMap().headMap(obj);
    }

    @Override // org.apache.commons.collections.SortedBidiMap
    public SortedBidiMap inverseSortedBidiMap() {
        return getSortedBidiMap().inverseSortedBidiMap();
    }

    @Override // java.util.SortedMap
    public SortedMap subMap(Object obj, Object obj2) {
        return getSortedBidiMap().subMap(obj, obj2);
    }

    @Override // java.util.SortedMap
    public SortedMap tailMap(Object obj) {
        return getSortedBidiMap().tailMap(obj);
    }
}
