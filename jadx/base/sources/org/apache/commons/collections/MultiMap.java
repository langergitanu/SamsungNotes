package org.apache.commons.collections;

import java.util.Collection;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public interface MultiMap extends Map {
    @Override // java.util.AbstractMap, java.util.Map, org.apache.commons.collections.MultiMap
    boolean containsValue(Object obj);

    @Override // java.util.Map
    Object get(Object obj);

    @Override // java.util.AbstractMap, java.util.Map, org.apache.commons.collections.MultiMap
    Object put(Object obj, Object obj2);

    @Override // java.util.Map
    Object remove(Object obj);

    @Override // java.util.Map, org.apache.commons.collections.MultiMap
    Object remove(Object obj, Object obj2);

    @Override // java.util.Map
    int size();

    @Override // java.util.AbstractMap, java.util.Map, org.apache.commons.collections.MultiMap
    Collection values();
}
