package org.apache.commons.collections4;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public interface MultiValuedMap<K, V> {
    Map<K, Collection<V>> asMap();

    void clear();

    boolean containsKey(Object obj);

    boolean containsMapping(Object obj, Object obj2);

    boolean containsValue(Object obj);

    Collection<Map.Entry<K, V>> entries();

    Collection<V> get(K k);

    boolean isEmpty();

    Set<K> keySet();

    MultiSet<K> keys();

    MapIterator<K, V> mapIterator();

    boolean put(K k, V v);

    boolean putAll(K k, Iterable<? extends V> iterable);

    boolean putAll(Map<? extends K, ? extends V> map);

    boolean putAll(MultiValuedMap<? extends K, ? extends V> multiValuedMap);

    Collection<V> remove(Object obj);

    boolean removeMapping(Object obj, Object obj2);

    int size();

    Collection<V> values();
}
