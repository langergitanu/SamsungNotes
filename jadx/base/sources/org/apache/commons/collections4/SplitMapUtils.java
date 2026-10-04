package org.apache.commons.collections4;

import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import org.apache.commons.collections4.collection.UnmodifiableCollection;
import org.apache.commons.collections4.iterators.UnmodifiableMapIterator;
import org.apache.commons.collections4.map.EntrySetToMapIteratorAdapter;
import org.apache.commons.collections4.map.UnmodifiableEntrySet;
import org.apache.commons.collections4.set.UnmodifiableSet;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class SplitMapUtils {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class WrappedGet<K, V> implements IterableMap<K, V>, Unmodifiable {
        private final Get<K, V> get;

        @Override // java.util.Map, org.apache.commons.collections4.Put
        public void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map, org.apache.commons.collections4.Get
        public boolean containsKey(Object obj) {
            return this.get.containsKey(obj);
        }

        @Override // java.util.Map, org.apache.commons.collections4.Get
        public boolean containsValue(Object obj) {
            return this.get.containsValue(obj);
        }

        @Override // java.util.Map, org.apache.commons.collections4.Get
        public Set<Map.Entry<K, V>> entrySet() {
            return UnmodifiableEntrySet.unmodifiableEntrySet(this.get.entrySet());
        }

        @Override // java.util.Map
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            return (obj instanceof WrappedGet) && ((WrappedGet) obj).get.equals(this.get);
        }

        @Override // java.util.Map, org.apache.commons.collections4.Get
        public V get(Object obj) {
            return this.get.get(obj);
        }

        @Override // java.util.Map
        public int hashCode() {
            return this.get.hashCode() | 360074000;
        }

        @Override // java.util.Map, org.apache.commons.collections4.Get
        public boolean isEmpty() {
            return this.get.isEmpty();
        }

        @Override // java.util.Map, org.apache.commons.collections4.Get
        public Set<K> keySet() {
            return UnmodifiableSet.unmodifiableSet(this.get.keySet());
        }

        @Override // org.apache.commons.collections4.IterableGet
        public MapIterator<K, V> mapIterator() {
            Get<K, V> get = this.get;
            return UnmodifiableMapIterator.unmodifiableMapIterator(get instanceof IterableGet ? ((IterableGet) get).mapIterator() : new EntrySetToMapIteratorAdapter(get.entrySet()));
        }

        @Override // java.util.Map, org.apache.commons.collections4.Put
        public V put(K k, V v) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map, org.apache.commons.collections4.Put
        public void putAll(Map<? extends K, ? extends V> map) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map, org.apache.commons.collections4.Get
        public V remove(Object obj) {
            return this.get.remove(obj);
        }

        @Override // java.util.Map, org.apache.commons.collections4.Get
        public int size() {
            return this.get.size();
        }

        @Override // java.util.Map, org.apache.commons.collections4.Get
        public Collection<V> values() {
            return UnmodifiableCollection.unmodifiableCollection(this.get.values());
        }

        private WrappedGet(Get<K, V> get) {
            this.get = get;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class WrappedPut<K, V> implements Map<K, V>, Put<K, V> {
        private final Put<K, V> put;

        @Override // java.util.Map, org.apache.commons.collections4.Put
        public void clear() {
            this.put.clear();
        }

        @Override // java.util.Map
        public boolean containsKey(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map
        public boolean containsValue(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map
        public Set<Map.Entry<K, V>> entrySet() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            return (obj instanceof WrappedPut) && ((WrappedPut) obj).put.equals(this.put);
        }

        @Override // java.util.Map
        public V get(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map
        public int hashCode() {
            return this.put.hashCode() | 360220320;
        }

        @Override // java.util.Map
        public boolean isEmpty() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map
        public Set<K> keySet() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map, org.apache.commons.collections4.Put
        public V put(K k, V v) {
            return (V) this.put.put(k, v);
        }

        @Override // java.util.Map, org.apache.commons.collections4.Put
        public void putAll(Map<? extends K, ? extends V> map) {
            this.put.putAll(map);
        }

        @Override // java.util.Map
        public V remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map
        public int size() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Map
        public Collection<V> values() {
            throw new UnsupportedOperationException();
        }

        private WrappedPut(Put<K, V> put) {
            this.put = put;
        }
    }

    private SplitMapUtils() {
    }

    public static <K, V> IterableMap<K, V> readableMap(Get<K, V> get) {
        Objects.requireNonNull(get, "get");
        return get instanceof Map ? get instanceof IterableMap ? (IterableMap) get : MapUtils.iterableMap((Map) get) : new WrappedGet(get);
    }

    public static <K, V> Map<K, V> writableMap(Put<K, V> put) {
        Objects.requireNonNull(put, "put");
        return put instanceof Map ? (Map) put : new WrappedPut(put);
    }
}
