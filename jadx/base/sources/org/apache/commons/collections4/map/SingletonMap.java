package org.apache.commons.collections4.map;

import androidx.compose.runtime.AbstractC1974b;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import org.apache.commons.collections4.BoundedMap;
import org.apache.commons.collections4.KeyValue;
import org.apache.commons.collections4.OrderedMap;
import org.apache.commons.collections4.OrderedMapIterator;
import org.apache.commons.collections4.ResettableIterator;
import org.apache.commons.collections4.iterators.SingletonIterator;
import org.apache.commons.collections4.keyvalue.TiedMapEntry;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class SingletonMap<K, V> implements OrderedMap<K, V>, BoundedMap<K, V>, KeyValue<K, V>, Serializable, Cloneable {
    private static final long serialVersionUID = -8931271118676803261L;
    private final K key;
    private V value;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class SingletonMapIterator<K, V> implements OrderedMapIterator<K, V>, ResettableIterator<K> {
        private boolean canGetSet;
        private boolean hasNext = true;
        private final SingletonMap<K, V> parent;

        public SingletonMapIterator(SingletonMap<K, V> singletonMap) {
            this.parent = singletonMap;
        }

        @Override // org.apache.commons.collections4.MapIterator
        public K getKey() {
            if (this.canGetSet) {
                return this.parent.getKey();
            }
            throw new IllegalStateException("getKey() can only be called after next() and before remove()");
        }

        @Override // org.apache.commons.collections4.MapIterator
        public V getValue() {
            if (this.canGetSet) {
                return this.parent.getValue();
            }
            throw new IllegalStateException("getValue() can only be called after next() and before remove()");
        }

        @Override // org.apache.commons.collections4.MapIterator, java.util.Iterator
        public boolean hasNext() {
            return this.hasNext;
        }

        @Override // org.apache.commons.collections4.OrderedMapIterator, org.apache.commons.collections4.OrderedIterator
        public boolean hasPrevious() {
            return !this.hasNext;
        }

        @Override // org.apache.commons.collections4.MapIterator, java.util.Iterator
        public K next() {
            if (!this.hasNext) {
                throw new NoSuchElementException("No next() entry in the iteration");
            }
            this.hasNext = false;
            this.canGetSet = true;
            return this.parent.getKey();
        }

        @Override // org.apache.commons.collections4.OrderedMapIterator, org.apache.commons.collections4.OrderedIterator
        public K previous() {
            if (this.hasNext) {
                throw new NoSuchElementException("No previous() entry in the iteration");
            }
            this.hasNext = true;
            return this.parent.getKey();
        }

        @Override // org.apache.commons.collections4.MapIterator, java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override // org.apache.commons.collections4.ResettableIterator
        public void reset() {
            this.hasNext = true;
        }

        @Override // org.apache.commons.collections4.MapIterator
        public V setValue(V v) {
            if (this.canGetSet) {
                return this.parent.setValue(v);
            }
            throw new IllegalStateException("setValue() can only be called after next() and before remove()");
        }

        public String toString() {
            if (this.hasNext) {
                return "Iterator[]";
            }
            StringBuilder sb = new StringBuilder("Iterator[");
            sb.append(getKey());
            sb.append(MarketingConstants.REFERRER_DELIMITER_U003D);
            return AbstractC1974b.m1320m(sb, getValue(), "]");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class SingletonValues<V> extends AbstractSet<V> implements Serializable {
        private static final long serialVersionUID = -3689524741863047872L;
        private final SingletonMap<?, V> parent;

        public SingletonValues(SingletonMap<?, V> singletonMap) {
            this.parent = singletonMap;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return this.parent.containsValue(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<V> iterator() {
            return new SingletonIterator(this.parent.getValue(), false);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return 1;
        }
    }

    public SingletonMap() {
        this.key = null;
    }

    @Override // java.util.Map, org.apache.commons.collections4.Put
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map, org.apache.commons.collections4.Get
    public boolean containsKey(Object obj) {
        return isEqualKey(obj);
    }

    @Override // java.util.Map, org.apache.commons.collections4.Get
    public boolean containsValue(Object obj) {
        return isEqualValue(obj);
    }

    @Override // java.util.Map, org.apache.commons.collections4.Get
    public Set<Map.Entry<K, V>> entrySet() {
        return Collections.singleton(new TiedMapEntry(this, getKey()));
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map)) {
            return false;
        }
        Map map = (Map) obj;
        if (map.size() != 1) {
            return false;
        }
        Map.Entry<K, V> next = map.entrySet().iterator().next();
        return isEqualKey(next.getKey()) && isEqualValue(next.getValue());
    }

    @Override // org.apache.commons.collections4.OrderedMap
    public K firstKey() {
        return getKey();
    }

    @Override // java.util.Map, org.apache.commons.collections4.Get
    public V get(Object obj) {
        if (isEqualKey(obj)) {
            return this.value;
        }
        return null;
    }

    @Override // org.apache.commons.collections4.KeyValue
    public K getKey() {
        return this.key;
    }

    @Override // org.apache.commons.collections4.KeyValue
    public V getValue() {
        return this.value;
    }

    @Override // java.util.Map
    public int hashCode() {
        return (getKey() == null ? 0 : getKey().hashCode()) ^ (getValue() != null ? getValue().hashCode() : 0);
    }

    @Override // java.util.Map, org.apache.commons.collections4.Get
    public boolean isEmpty() {
        return false;
    }

    public boolean isEqualKey(Object obj) {
        return Objects.equals(obj, getKey());
    }

    public boolean isEqualValue(Object obj) {
        return Objects.equals(obj, getValue());
    }

    @Override // org.apache.commons.collections4.BoundedMap
    public boolean isFull() {
        return true;
    }

    @Override // java.util.Map, org.apache.commons.collections4.Get
    public Set<K> keySet() {
        return Collections.singleton(this.key);
    }

    @Override // org.apache.commons.collections4.OrderedMap
    public K lastKey() {
        return getKey();
    }

    @Override // org.apache.commons.collections4.BoundedMap
    public int maxSize() {
        return 1;
    }

    @Override // org.apache.commons.collections4.OrderedMap
    public K nextKey(K k) {
        return null;
    }

    @Override // org.apache.commons.collections4.OrderedMap
    public K previousKey(K k) {
        return null;
    }

    @Override // java.util.Map, org.apache.commons.collections4.Put
    public V put(K k, V v) {
        if (isEqualKey(k)) {
            return setValue(v);
        }
        throw new IllegalArgumentException("Cannot put new key/value pair - Map is fixed size singleton");
    }

    @Override // java.util.Map, org.apache.commons.collections4.Put
    public void putAll(Map<? extends K, ? extends V> map) {
        int size = map.size();
        if (size != 0) {
            if (size != 1) {
                throw new IllegalArgumentException("The map size must be 0 or 1");
            }
            Map.Entry<? extends K, ? extends V> next = map.entrySet().iterator().next();
            put(next.getKey(), next.getValue());
        }
    }

    @Override // java.util.Map, org.apache.commons.collections4.Get
    public V remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    public V setValue(V v) {
        V v4 = this.value;
        this.value = v;
        return v4;
    }

    @Override // java.util.Map, org.apache.commons.collections4.Get
    public int size() {
        return 1;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append('{');
        sb.append(getKey() == this ? "(this Map)" : getKey());
        sb.append('=');
        sb.append(getValue() != this ? getValue() : "(this Map)");
        sb.append('}');
        return sb.toString();
    }

    @Override // java.util.Map, org.apache.commons.collections4.Get
    public Collection<V> values() {
        return new SingletonValues(this);
    }

    public SingletonMap<K, V> clone() {
        try {
            return (SingletonMap) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new UnsupportedOperationException(e);
        }
    }

    @Override // org.apache.commons.collections4.OrderedMap, org.apache.commons.collections4.IterableGet
    public OrderedMapIterator<K, V> mapIterator() {
        return new SingletonMapIterator(this);
    }

    public SingletonMap(K k, V v) {
        this.key = k;
        this.value = v;
    }

    public SingletonMap(KeyValue<K, V> keyValue) {
        this.key = keyValue.getKey();
        this.value = keyValue.getValue();
    }

    public SingletonMap(Map.Entry<? extends K, ? extends V> entry) {
        this.key = entry.getKey();
        this.value = entry.getValue();
    }

    public SingletonMap(Map<? extends K, ? extends V> map) {
        if (map.size() == 1) {
            Map.Entry<? extends K, ? extends V> next = map.entrySet().iterator().next();
            this.key = next.getKey();
            this.value = next.getValue();
            return;
        }
        throw new IllegalArgumentException("The map size must be 1");
    }
}
