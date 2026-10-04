package org.apache.commons.collections4.bidimap;

import java.util.Set;
import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.map.AbstractMapDecorator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public abstract class AbstractBidiMapDecorator<K, V> extends AbstractMapDecorator<K, V> implements BidiMap<K, V> {
    public AbstractBidiMapDecorator(BidiMap<K, V> bidiMap) {
        super(bidiMap);
    }

    @Override // org.apache.commons.collections4.BidiMap
    public K getKey(Object obj) {
        return decorated().getKey(obj);
    }

    @Override // org.apache.commons.collections4.BidiMap
    public BidiMap<V, K> inverseBidiMap() {
        return decorated().inverseBidiMap();
    }

    @Override // org.apache.commons.collections4.map.AbstractIterableMap, org.apache.commons.collections4.IterableGet
    public MapIterator<K, V> mapIterator() {
        return decorated().mapIterator();
    }

    @Override // org.apache.commons.collections4.BidiMap
    public K removeValue(Object obj) {
        return decorated().removeValue(obj);
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator
    public BidiMap<K, V> decorated() {
        return (BidiMap) super.decorated();
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map, org.apache.commons.collections4.Get
    public Set<V> values() {
        return decorated().values();
    }
}
