package org.apache.commons.collections4.map;

import org.apache.commons.collections4.OrderedMap;
import org.apache.commons.collections4.OrderedMapIterator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public abstract class AbstractOrderedMapDecorator<K, V> extends AbstractMapDecorator<K, V> implements OrderedMap<K, V> {
    public AbstractOrderedMapDecorator() {
    }

    @Override // org.apache.commons.collections4.OrderedMap
    public K firstKey() {
        return decorated().firstKey();
    }

    @Override // org.apache.commons.collections4.OrderedMap
    public K lastKey() {
        return decorated().lastKey();
    }

    @Override // org.apache.commons.collections4.OrderedMap
    public K nextKey(K k) {
        return decorated().nextKey(k);
    }

    @Override // org.apache.commons.collections4.OrderedMap
    public K previousKey(K k) {
        return decorated().previousKey(k);
    }

    public AbstractOrderedMapDecorator(OrderedMap<K, V> orderedMap) {
        super(orderedMap);
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator
    public OrderedMap<K, V> decorated() {
        return (OrderedMap) super.decorated();
    }

    @Override // org.apache.commons.collections4.map.AbstractIterableMap, org.apache.commons.collections4.IterableGet
    public OrderedMapIterator<K, V> mapIterator() {
        return decorated().mapIterator();
    }
}
