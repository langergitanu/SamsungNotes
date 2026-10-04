package com.vladsch.flexmark.util.collection;

import androidx.collection.AbstractC0622a;
import androidx.compose.runtime.AbstractC1974b;
import com.vladsch.flexmark.util.collection.iteration.BitSetIterable;
import com.vladsch.flexmark.util.collection.iteration.BitSetIterator;
import com.vladsch.flexmark.util.collection.iteration.Indexed;
import com.vladsch.flexmark.util.collection.iteration.IndexedIterable;
import com.vladsch.flexmark.util.collection.iteration.IndexedIterator;
import com.vladsch.flexmark.util.collection.iteration.ReversibleIndexedIterator;
import com.vladsch.flexmark.util.collection.iteration.ReversibleIterable;
import com.vladsch.flexmark.util.misc.Pair;
import com.vladsch.flexmark.util.misc.Paired;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.function.Consumer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class OrderedMultiMap<K, V> implements Map<K, V>, Iterable<Map.Entry<K, V>> {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    @Nullable
    private final CollectionHost<Paired<K, V>> host;

    @Nullable
    private Indexed<Map.Entry<K, V>> indexedProxy;
    boolean isInKeyUpdate;
    boolean isInValueUpdate;

    @NotNull
    private final OrderedSet<K> keySet;

    @NotNull
    private final OrderedSet<V> valueSet;

    public OrderedMultiMap() {
        this(0, null);
    }

    private boolean addKeyValue(@Nullable K k, @Nullable V v) {
        int iIndexOf = this.keySet.indexOf(k);
        int iIndexOf2 = this.valueSet.indexOf(v);
        if (iIndexOf == -1 && iIndexOf2 == -1) {
            this.isInKeyUpdate = true;
            this.isInValueUpdate = true;
            CollectionHost<Paired<K, V>> collectionHost = this.host;
            if (collectionHost != null && !collectionHost.skipHostUpdate()) {
                this.host.adding(this.keySet.getValueList().size(), new Pair(k, v), null);
            }
            if (k == null) {
                this.keySet.addNull();
            } else {
                this.keySet.add(k, v);
            }
            if (k == null) {
                this.valueSet.addNull();
            } else {
                this.valueSet.add(v, k);
            }
            this.isInValueUpdate = false;
            this.isInKeyUpdate = false;
            return true;
        }
        if (iIndexOf == -1) {
            this.isInKeyUpdate = true;
            this.isInValueUpdate = true;
            CollectionHost<Paired<K, V>> collectionHost2 = this.host;
            if (collectionHost2 != null && !collectionHost2.skipHostUpdate()) {
                this.host.adding(iIndexOf2, new Pair(k, v), null);
            }
            if (k == null) {
                this.keySet.removeIndex(iIndexOf2);
            } else {
                this.keySet.setValueAt(iIndexOf2, k, v);
            }
            this.isInValueUpdate = false;
            this.isInKeyUpdate = false;
            return true;
        }
        if (iIndexOf2 == -1) {
            this.isInKeyUpdate = true;
            this.isInValueUpdate = true;
            CollectionHost<Paired<K, V>> collectionHost3 = this.host;
            if (collectionHost3 != null && !collectionHost3.skipHostUpdate()) {
                this.host.adding(iIndexOf, new Pair(k, v), null);
            }
            if (k == null) {
                this.valueSet.removeIndex(iIndexOf2);
            } else {
                this.valueSet.setValueAt(iIndexOf, v, k);
            }
            this.isInValueUpdate = false;
            return true;
        }
        if (iIndexOf2 == iIndexOf) {
            return false;
        }
        throw new IllegalStateException("keySet[" + iIndexOf + "]=" + k + " and valueSet[" + iIndexOf2 + "]=" + v + " are out of sync");
    }

    private BitSet getKeyValueIntersectionSet() {
        BitSet bitSet = new BitSet(this.keySet.size());
        bitSet.or(this.keySet.getValidIndices());
        bitSet.and(this.valueSet.getValidIndices());
        return bitSet;
    }

    private BitSet getKeyValueUnionSet() {
        BitSet bitSet = new BitSet(this.keySet.size());
        bitSet.or(this.keySet.getValidIndices());
        bitSet.or(this.valueSet.getValidIndices());
        return bitSet;
    }

    public void addNullEntry(int i) {
        this.isInKeyUpdate = true;
        this.isInValueUpdate = true;
        CollectionHost<Paired<K, V>> collectionHost = this.host;
        if (collectionHost != null && !collectionHost.skipHostUpdate()) {
            this.host.addingNulls(i);
        }
        this.keySet.addNulls(i);
        this.valueSet.addNulls(i);
        this.isInValueUpdate = false;
        this.isInKeyUpdate = false;
    }

    public void addingKey(int i, @Nullable K k, @Nullable Object obj) {
        this.isInValueUpdate = true;
        CollectionHost<Paired<K, V>> collectionHost = this.host;
        if (collectionHost != null && !collectionHost.skipHostUpdate()) {
            this.host.adding(i, new Pair(k, obj), null);
        }
        if (obj == null) {
            this.valueSet.addNulls(i);
        } else {
            this.valueSet.add(obj);
        }
        this.isInValueUpdate = false;
    }

    public void addingNullKey(int i) {
        this.isInValueUpdate = true;
        CollectionHost<Paired<K, V>> collectionHost = this.host;
        if (collectionHost != null && !collectionHost.skipHostUpdate()) {
            this.host.addingNulls(i);
        }
        while (valueSet().size() <= i) {
            this.valueSet.add(null);
        }
        this.isInValueUpdate = false;
    }

    public void addingNullValue(int i) {
        this.isInKeyUpdate = true;
        CollectionHost<Paired<K, V>> collectionHost = this.host;
        if (collectionHost != null && !collectionHost.skipHostUpdate()) {
            this.host.addingNulls(i);
        }
        while (this.keySet.size() <= i) {
            this.keySet.add(null);
        }
        this.isInKeyUpdate = false;
    }

    public void addingValue(int i, @Nullable V v, @Nullable Object obj) {
        this.isInKeyUpdate = true;
        CollectionHost<Paired<K, V>> collectionHost = this.host;
        if (collectionHost != null && !collectionHost.skipHostUpdate()) {
            this.host.adding(i, new Pair(obj, v), null);
        }
        if (obj == null) {
            this.keySet.addNulls(i);
        } else {
            this.keySet.add(obj);
        }
        this.isInKeyUpdate = false;
    }

    @Override // java.util.Map
    public void clear() {
        this.isInValueUpdate = true;
        this.isInKeyUpdate = true;
        CollectionHost<Paired<K, V>> collectionHost = this.host;
        if (collectionHost != null && !collectionHost.skipHostUpdate()) {
            this.host.clearing();
        }
        this.keySet.clear();
        this.valueSet.clear();
        this.isInKeyUpdate = false;
        this.isInValueUpdate = false;
    }

    @Override // java.util.Map
    public boolean containsKey(@Nullable Object obj) {
        return this.keySet.contains(obj);
    }

    @Override // java.util.Map
    public boolean containsValue(@Nullable Object obj) {
        return this.keySet.isValidIndex(this.valueSet.indexOf(obj));
    }

    public ReversibleIterable<Map.Entry<K, V>> entrySetIterable() {
        return new IndexedIterable(getIndexedProxy(), new BitSetIterable(getKeyValueUnionSet()));
    }

    public ReversibleIndexedIterator<Map.Entry<K, V>> entrySetIterator() {
        return new IndexedIterator(getIndexedProxy(), new BitSetIterator(getKeyValueUnionSet()));
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        OrderedMultiMap orderedMultiMap = (OrderedMultiMap) obj;
        if (size() != orderedMultiMap.size()) {
            return false;
        }
        return entrySet().equals(orderedMultiMap.entrySet());
    }

    @Override // java.lang.Iterable
    public void forEach(Consumer<? super Map.Entry<K, V>> consumer) {
        ReversibleIndexedIterator<Map.Entry<K, V>> reversibleIndexedIteratorEntrySetIterator = entrySetIterator();
        while (reversibleIndexedIteratorEntrySetIterator.hasNext()) {
            consumer.accept(reversibleIndexedIteratorEntrySetIterator.next());
        }
    }

    @Override // java.util.Map
    @Nullable
    public V get(@Nullable Object obj) {
        return getKeyValue(obj);
    }

    public Map.Entry<K, V> getEntry(int i) {
        return new MapEntry(this.keySet.getValueOrNull(i), this.valueSet.getValueOrNull(i));
    }

    public Indexed<Map.Entry<K, V>> getIndexedProxy() {
        Indexed<Map.Entry<K, V>> indexed = this.indexedProxy;
        if (indexed != null) {
            return indexed;
        }
        Indexed<Map.Entry<K, V>> indexed2 = new Indexed<Map.Entry<K, V>>() { // from class: com.vladsch.flexmark.util.collection.OrderedMultiMap.3
            @Override // com.vladsch.flexmark.util.collection.iteration.Indexed
            public int modificationCount() {
                return OrderedMultiMap.this.getModificationCount();
            }

            @Override // com.vladsch.flexmark.util.collection.iteration.Indexed
            public void removeAt(int i) {
                OrderedMultiMap.this.removeEntryIndex(i);
            }

            @Override // com.vladsch.flexmark.util.collection.iteration.Indexed
            public int size() {
                return OrderedMultiMap.this.size();
            }

            @Override // com.vladsch.flexmark.util.collection.iteration.Indexed
            public Map.Entry<K, V> get(int i) {
                return OrderedMultiMap.this.getEntry(i);
            }

            @Override // com.vladsch.flexmark.util.collection.iteration.Indexed
            public void set(int i, Map.Entry<K, V> entry) {
                throw new UnsupportedOperationException();
            }
        };
        this.indexedProxy = indexed2;
        return indexed2;
    }

    public K getKey(int i) {
        if (this.keySet.isValidIndex(i)) {
            return this.keySet.getValueList().get(i);
        }
        return null;
    }

    @Nullable
    public V getKeyValue(@Nullable Object obj) {
        int iIndexOf = this.keySet.indexOf(obj);
        if (iIndexOf == -1) {
            return null;
        }
        return this.valueSet.getValue(iIndexOf);
    }

    public int getModificationCount() {
        return (int) (((long) this.keySet.getModificationCount()) + ((long) this.valueSet.getModificationCount()));
    }

    public V getValue(int i) {
        if (this.valueSet.isValidIndex(i)) {
            return this.valueSet.getValue(i);
        }
        return null;
    }

    @Nullable
    public K getValueKey(@Nullable Object obj) {
        int iIndexOf = this.valueSet.indexOf(obj);
        if (iIndexOf == -1) {
            return null;
        }
        return this.keySet.getValue(iIndexOf);
    }

    @Override // java.util.Map
    public int hashCode() {
        return this.valueSet.hashCode() + (this.keySet.hashCode() * 31);
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this.keySet.isEmpty();
    }

    @Override // java.lang.Iterable
    @NotNull
    public Iterator<Map.Entry<K, V>> iterator() {
        return entrySetIterator();
    }

    public ReversibleIterable<K> keyIterable() {
        return new IndexedIterable(this.keySet.getIndexedProxy(), this.keySet.indexIterable());
    }

    public ReversibleIndexedIterator<K> keyIterator() {
        return keySet().iterator();
    }

    public OrderedSet<Map.Entry<K, V>> keyValueEntrySet() {
        this.isInValueUpdate = true;
        this.isInKeyUpdate = true;
        OrderedSet<Map.Entry<K, V>> orderedSet = new OrderedSet<>(this.keySet.size(), new CollectionHost<Map.Entry<K, V>>() { // from class: com.vladsch.flexmark.util.collection.OrderedMultiMap.4
            static final /* synthetic */ boolean $assertionsDisabled = false;

            @Override // com.vladsch.flexmark.util.collection.CollectionHost
            public void addingNulls(int i) {
                OrderedMultiMap.this.addNullEntry(i);
            }

            @Override // com.vladsch.flexmark.util.collection.CollectionHost
            public void clearing() {
                OrderedMultiMap.this.clear();
            }

            @Override // com.vladsch.flexmark.util.collection.CollectionHost
            public int getIteratorModificationCount() {
                return OrderedMultiMap.this.getModificationCount();
            }

            @Override // com.vladsch.flexmark.util.collection.CollectionHost
            public boolean skipHostUpdate() {
                OrderedMultiMap orderedMultiMap = OrderedMultiMap.this;
                return orderedMultiMap.isInKeyUpdate || orderedMultiMap.isInValueUpdate;
            }

            @Override // com.vladsch.flexmark.util.collection.CollectionHost
            public void adding(int i, @Nullable Map.Entry<K, V> entry, @Nullable Object obj) {
                OrderedMultiMap.this.putKeyValue(entry.getKey(), entry.getValue());
            }

            @Override // com.vladsch.flexmark.util.collection.CollectionHost
            public Object removing(int i, @Nullable Map.Entry<K, V> entry) {
                if (OrderedMultiMap.this.removeEntryIndex(i, entry.getKey(), entry.getValue())) {
                    return entry;
                }
                return null;
            }
        });
        ReversibleIndexedIterator<Map.Entry<K, V>> reversibleIndexedIteratorEntrySetIterator = entrySetIterator();
        while (reversibleIndexedIteratorEntrySetIterator.hasNext()) {
            orderedSet.add(reversibleIndexedIteratorEntrySetIterator.next());
        }
        this.isInValueUpdate = false;
        this.isInKeyUpdate = false;
        return orderedSet;
    }

    public Collection<K> keys() {
        if (!this.keySet.isSparse()) {
            return this.keySet;
        }
        ArrayList arrayList = new ArrayList(this.valueSet.size());
        arrayList.addAll(this.keySet);
        return arrayList;
    }

    @Override // java.util.Map
    @Nullable
    public V put(@Nullable K k, @Nullable V v) {
        return putKeyValue(k, v);
    }

    @Override // java.util.Map
    public void putAll(@NotNull Map<? extends K, ? extends V> map) {
        putAllKeyValues(map);
    }

    public void putAllKeyValues(Map<? extends K, ? extends V> map) {
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    public void putAllValueKeys(Map<? extends V, ? extends K> map) {
        for (Map.Entry<? extends V, ? extends K> entry : map.entrySet()) {
            putValueKey(entry.getKey(), entry.getValue());
        }
    }

    public boolean putEntry(@NotNull Map.Entry<K, V> entry) {
        return addKeyValue(entry.getKey(), entry.getValue());
    }

    public V putKeyValue(@Nullable K k, @Nullable V v) {
        if (addKeyValue(k, v)) {
            return null;
        }
        return v;
    }

    public boolean putKeyValueEntry(@NotNull Map.Entry<K, V> entry) {
        return addKeyValue(entry.getKey(), entry.getValue());
    }

    public boolean putKeyValuePair(@NotNull Paired<K, V> paired) {
        return addKeyValue(paired.getFirst(), paired.getSecond());
    }

    public K putValueKey(@Nullable V v, @Nullable K k) {
        if (addKeyValue(k, v)) {
            return null;
        }
        return k;
    }

    public boolean putValueKeyEntry(@NotNull Map.Entry<V, K> entry) {
        return addKeyValue(entry.getValue(), entry.getKey());
    }

    public boolean putValueKeyPair(@NotNull Paired<V, K> paired) {
        return addKeyValue(paired.getSecond(), paired.getFirst());
    }

    @Override // java.util.Map
    @Nullable
    public V remove(@Nullable Object obj) {
        return removeKey(obj);
    }

    @Nullable
    public Map.Entry<K, V> removeEntry(@NotNull Map.Entry<K, V> entry) {
        if (removeEntryIndex(-1, entry.getKey(), entry.getValue())) {
            return entry;
        }
        return null;
    }

    public boolean removeEntryIndex(int i) {
        return removeEntryIndex(i, this.keySet.getValueOrNull(i), this.valueSet.getValueOrNull(i));
    }

    public V removeKey(Object obj) {
        int iIndexOf;
        this.isInKeyUpdate = true;
        CollectionHost<Paired<K, V>> collectionHost = this.host;
        if (collectionHost != null && !collectionHost.skipHostUpdate() && (iIndexOf = this.keySet.indexOf(obj)) != -1) {
            this.host.removing(iIndexOf, new Pair(obj, this.valueSet.isValidIndex(iIndexOf) ? this.valueSet.getValue(iIndexOf) : null));
        }
        V v = (V) this.keySet.removeHosted(obj);
        this.isInKeyUpdate = false;
        return v;
    }

    public K removeValue(Object obj) {
        this.isInValueUpdate = true;
        int iIndexOf = this.valueSet.indexOf(obj);
        CollectionHost<Paired<K, V>> collectionHost = this.host;
        if (collectionHost != null && !collectionHost.skipHostUpdate() && iIndexOf != -1) {
            this.host.removing(iIndexOf, new Pair(this.keySet.isValidIndex(iIndexOf) ? this.keySet.getValue(iIndexOf) : null, obj));
        }
        K k = (K) this.valueSet.removeHosted(obj);
        this.isInValueUpdate = false;
        return k;
    }

    public Object removingKey(int i, @Nullable K k) {
        this.isInValueUpdate = true;
        CollectionHost<Paired<K, V>> collectionHost = this.host;
        if (collectionHost != null && !collectionHost.skipHostUpdate()) {
            this.host.removing(i, new Pair(k, null));
        }
        Object objRemoveIndexHosted = this.valueSet.removeIndexHosted(i);
        this.isInValueUpdate = false;
        return objRemoveIndexHosted;
    }

    public Object removingValue(int i, @Nullable V v) {
        this.isInKeyUpdate = true;
        CollectionHost<Paired<K, V>> collectionHost = this.host;
        if (collectionHost != null && !collectionHost.skipHostUpdate()) {
            this.host.removing(i, new Pair(null, v));
        }
        Object objRemoveIndexHosted = this.keySet.removeIndexHosted(i);
        this.isInKeyUpdate = false;
        return objRemoveIndexHosted;
    }

    public ReversibleIterable<Map.Entry<K, V>> reversedEntrySetIterable() {
        return new IndexedIterable(getIndexedProxy(), new BitSetIterable(getKeyValueUnionSet()));
    }

    public ReversibleIndexedIterator<Map.Entry<K, V>> reversedEntrySetIterator() {
        return new IndexedIterator(getIndexedProxy(), new BitSetIterator(getKeyValueUnionSet(), true));
    }

    public ReversibleIterable<K> reversedKeyIterable() {
        return new IndexedIterable(this.keySet.getIndexedProxy(), this.keySet.reversedIndexIterable());
    }

    public ReversibleIndexedIterator<K> reversedKeyIterator() {
        return keySet().reversedIterator();
    }

    public ReversibleIterable<V> reversedValueIterable() {
        return new IndexedIterable(this.valueSet.getIndexedProxy(), this.valueSet.reversedIndexIterable());
    }

    public ReversibleIndexedIterator<V> reversedValueIterator() {
        return this.valueSet.reversedIterator();
    }

    @Override // java.util.Map
    public int size() {
        return this.keySet.size();
    }

    public ReversibleIterable<V> valueIterable() {
        return new IndexedIterable(this.valueSet.getIndexedProxy(), this.valueSet.indexIterable());
    }

    public ReversibleIndexedIterator<V> valueIterator() {
        return this.valueSet.iterator();
    }

    public OrderedSet<V> valueSet() {
        return this.valueSet;
    }

    @Override // java.util.Map
    @NotNull
    public Collection<V> values() {
        if (!this.keySet.isSparse()) {
            return this.valueSet;
        }
        ArrayList arrayList = new ArrayList(this.keySet.size());
        arrayList.addAll(this.valueSet);
        return arrayList;
    }

    public OrderedMultiMap(int i) {
        this(i, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean removeEntryIndex(int i, @Nullable K k, @Nullable V v) {
        int iIndexOf = this.keySet.indexOf(k);
        int iIndexOf2 = this.valueSet.indexOf(v);
        if (iIndexOf != iIndexOf2) {
            throw new IllegalStateException("keySet[" + iIndexOf + "]=" + k + " and valueSet[" + iIndexOf2 + "]=" + v + " are out of sync");
        }
        if (i != -1 && iIndexOf != i) {
            StringBuilder sbM1173s = AbstractC0622a.m1173s(i, iIndexOf, "removeEntryIndex ", " does not match keySet[", "]=");
            sbM1173s.append(k);
            sbM1173s.append(" and valueSet[");
            sbM1173s.append(iIndexOf2);
            sbM1173s.append("]=");
            throw new IllegalStateException(AbstractC1974b.m1320m(sbM1173s, v, " are out of sync"));
        }
        if (iIndexOf == -1) {
            return false;
        }
        this.isInKeyUpdate = true;
        this.isInValueUpdate = true;
        CollectionHost<Paired<K, V>> collectionHost = this.host;
        if (collectionHost != null && !collectionHost.skipHostUpdate()) {
            this.host.removing(iIndexOf, new Pair(k, v));
        }
        this.keySet.removeHosted(k);
        this.valueSet.removeHosted(v);
        this.isInValueUpdate = false;
        this.isInKeyUpdate = false;
        return true;
    }

    @Override // java.util.Map
    @NotNull
    public OrderedSet<Map.Entry<K, V>> entrySet() {
        return keyValueEntrySet();
    }

    @Override // java.util.Map
    @NotNull
    public OrderedSet<K> keySet() {
        return this.keySet;
    }

    public OrderedMultiMap(@NotNull CollectionHost<Paired<K, V>> collectionHost) {
        this(0, collectionHost);
    }

    public OrderedMultiMap(int i, @Nullable CollectionHost<Paired<K, V>> collectionHost) {
        this.host = collectionHost;
        this.indexedProxy = null;
        this.valueSet = new OrderedSet<>(i, new CollectionHost<V>() { // from class: com.vladsch.flexmark.util.collection.OrderedMultiMap.1
            @Override // com.vladsch.flexmark.util.collection.CollectionHost
            public void adding(int i2, @Nullable V v, @Nullable Object obj) {
                OrderedMultiMap.this.addingValue(i2, v, obj);
            }

            @Override // com.vladsch.flexmark.util.collection.CollectionHost
            public void addingNulls(int i2) {
                OrderedMultiMap.this.addingNullValue(i2);
            }

            @Override // com.vladsch.flexmark.util.collection.CollectionHost
            public void clearing() {
                OrderedMultiMap.this.clear();
            }

            @Override // com.vladsch.flexmark.util.collection.CollectionHost
            public int getIteratorModificationCount() {
                return OrderedMultiMap.this.getModificationCount();
            }

            @Override // com.vladsch.flexmark.util.collection.CollectionHost
            public Object removing(int i2, @Nullable V v) {
                return OrderedMultiMap.this.removingValue(i2, v);
            }

            @Override // com.vladsch.flexmark.util.collection.CollectionHost
            public boolean skipHostUpdate() {
                return OrderedMultiMap.this.isInKeyUpdate;
            }
        });
        this.keySet = new OrderedSet<>(i, new CollectionHost<K>() { // from class: com.vladsch.flexmark.util.collection.OrderedMultiMap.2
            @Override // com.vladsch.flexmark.util.collection.CollectionHost
            public void adding(int i2, @Nullable K k, @Nullable Object obj) {
                OrderedMultiMap.this.addingKey(i2, k, obj);
            }

            @Override // com.vladsch.flexmark.util.collection.CollectionHost
            public void addingNulls(int i2) {
                OrderedMultiMap.this.addingNullKey(i2);
            }

            @Override // com.vladsch.flexmark.util.collection.CollectionHost
            public void clearing() {
                OrderedMultiMap.this.clear();
            }

            @Override // com.vladsch.flexmark.util.collection.CollectionHost
            public int getIteratorModificationCount() {
                return OrderedMultiMap.this.getModificationCount();
            }

            @Override // com.vladsch.flexmark.util.collection.CollectionHost
            public Object removing(int i2, @Nullable K k) {
                return OrderedMultiMap.this.removingKey(i2, k);
            }

            @Override // com.vladsch.flexmark.util.collection.CollectionHost
            public boolean skipHostUpdate() {
                return OrderedMultiMap.this.isInValueUpdate;
            }
        });
    }
}
