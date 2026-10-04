package org.apache.commons.collections.map;

import org.apache.commons.collections.MapIterator;
import org.apache.commons.collections.OrderedMap;
import org.apache.commons.collections.OrderedMapIterator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public abstract class AbstractOrderedMapDecorator extends AbstractMapDecorator implements OrderedMap {
    public AbstractOrderedMapDecorator() {
    }

    @Override // org.apache.commons.collections.OrderedMap
    public Object firstKey() {
        return getOrderedMap().firstKey();
    }

    public OrderedMap getOrderedMap() {
        return (OrderedMap) this.map;
    }

    @Override // org.apache.commons.collections.OrderedMap
    public Object lastKey() {
        return getOrderedMap().lastKey();
    }

    @Override // org.apache.commons.collections.IterableMap
    public MapIterator mapIterator() {
        return getOrderedMap().mapIterator();
    }

    @Override // org.apache.commons.collections.OrderedMap
    public Object nextKey(Object obj) {
        return getOrderedMap().nextKey(obj);
    }

    @Override // org.apache.commons.collections.OrderedMap
    public OrderedMapIterator orderedMapIterator() {
        return getOrderedMap().orderedMapIterator();
    }

    @Override // org.apache.commons.collections.OrderedMap
    public Object previousKey(Object obj) {
        return getOrderedMap().previousKey(obj);
    }

    public AbstractOrderedMapDecorator(OrderedMap orderedMap) {
        super(orderedMap);
    }
}
