package org.apache.commons.collections;

import java.util.Collection;
import java.util.Comparator;
import java.util.SortedMap;
import java.util.TreeMap;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class TreeBag extends DefaultMapBag implements SortedBag {
    public TreeBag() {
        super(new TreeMap());
    }

    @Override // org.apache.commons.collections.SortedBag
    public Comparator comparator() {
        return ((SortedMap) getMap()).comparator();
    }

    @Override // org.apache.commons.collections.SortedBag
    public Object first() {
        return ((SortedMap) getMap()).firstKey();
    }

    @Override // org.apache.commons.collections.SortedBag
    public Object last() {
        return ((SortedMap) getMap()).lastKey();
    }

    public TreeBag(Comparator comparator) {
        super(new TreeMap(comparator));
    }

    public TreeBag(Collection collection) {
        this();
        addAll(collection);
    }
}
