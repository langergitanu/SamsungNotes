package org.apache.commons.collections.bidimap;

import org.apache.commons.collections.BidiMap;
import org.apache.commons.collections.MapIterator;
import org.apache.commons.collections.map.AbstractMapDecorator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public abstract class AbstractBidiMapDecorator extends AbstractMapDecorator implements BidiMap {
    public AbstractBidiMapDecorator(BidiMap bidiMap) {
        super(bidiMap);
    }

    public BidiMap getBidiMap() {
        return (BidiMap) this.map;
    }

    @Override // org.apache.commons.collections.BidiMap
    public Object getKey(Object obj) {
        return getBidiMap().getKey(obj);
    }

    @Override // org.apache.commons.collections.BidiMap
    public BidiMap inverseBidiMap() {
        return getBidiMap().inverseBidiMap();
    }

    @Override // org.apache.commons.collections.BidiMap, org.apache.commons.collections.IterableMap
    public MapIterator mapIterator() {
        return getBidiMap().mapIterator();
    }

    @Override // org.apache.commons.collections.BidiMap
    public Object removeValue(Object obj) {
        return getBidiMap().removeValue(obj);
    }
}
