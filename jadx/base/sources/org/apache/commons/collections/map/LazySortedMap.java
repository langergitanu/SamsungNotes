package org.apache.commons.collections.map;

import java.util.Comparator;
import java.util.SortedMap;
import org.apache.commons.collections.Factory;
import org.apache.commons.collections.Transformer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class LazySortedMap extends LazyMap implements SortedMap {
    private static final long serialVersionUID = 2715322183617658933L;

    public LazySortedMap(SortedMap sortedMap, Factory factory) {
        super(sortedMap, factory);
    }

    public static SortedMap decorate(SortedMap sortedMap, Factory factory) {
        return new LazySortedMap(sortedMap, factory);
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

    @Override // java.util.SortedMap
    public SortedMap headMap(Object obj) {
        return new LazySortedMap(getSortedMap().headMap(obj), this.factory);
    }

    @Override // java.util.SortedMap
    public Object lastKey() {
        return getSortedMap().lastKey();
    }

    @Override // java.util.SortedMap
    public SortedMap subMap(Object obj, Object obj2) {
        return new LazySortedMap(getSortedMap().subMap(obj, obj2), this.factory);
    }

    @Override // java.util.SortedMap
    public SortedMap tailMap(Object obj) {
        return new LazySortedMap(getSortedMap().tailMap(obj), this.factory);
    }

    public LazySortedMap(SortedMap sortedMap, Transformer transformer) {
        super(sortedMap, transformer);
    }

    public static SortedMap decorate(SortedMap sortedMap, Transformer transformer) {
        return new LazySortedMap(sortedMap, transformer);
    }
}
