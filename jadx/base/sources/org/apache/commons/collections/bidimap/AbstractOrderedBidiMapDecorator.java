package org.apache.commons.collections.bidimap;

import org.apache.commons.collections.OrderedBidiMap;
import org.apache.commons.collections.OrderedMapIterator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public abstract class AbstractOrderedBidiMapDecorator extends AbstractBidiMapDecorator implements OrderedBidiMap {
    public AbstractOrderedBidiMapDecorator(OrderedBidiMap orderedBidiMap) {
        super(orderedBidiMap);
    }

    @Override // org.apache.commons.collections.OrderedMap
    public Object firstKey() {
        return getOrderedBidiMap().firstKey();
    }

    public OrderedBidiMap getOrderedBidiMap() {
        return (OrderedBidiMap) this.map;
    }

    @Override // org.apache.commons.collections.OrderedBidiMap
    public OrderedBidiMap inverseOrderedBidiMap() {
        return getOrderedBidiMap().inverseOrderedBidiMap();
    }

    @Override // org.apache.commons.collections.OrderedMap
    public Object lastKey() {
        return getOrderedBidiMap().lastKey();
    }

    @Override // org.apache.commons.collections.OrderedMap
    public Object nextKey(Object obj) {
        return getOrderedBidiMap().nextKey(obj);
    }

    @Override // org.apache.commons.collections.OrderedMap
    public OrderedMapIterator orderedMapIterator() {
        return getOrderedBidiMap().orderedMapIterator();
    }

    @Override // org.apache.commons.collections.OrderedMap
    public Object previousKey(Object obj) {
        return getOrderedBidiMap().previousKey(obj);
    }
}
