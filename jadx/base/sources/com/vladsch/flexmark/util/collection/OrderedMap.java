package com.vladsch.flexmark.util.collection;

import androidx.compose.foundation.layout.AbstractC1038a;
import com.vladsch.flexmark.util.collection.iteration.Indexed;
import com.vladsch.flexmark.util.collection.iteration.IndexedIterable;
import com.vladsch.flexmark.util.collection.iteration.IndexedIterator;
import com.vladsch.flexmark.util.collection.iteration.ReversibleIndexedIterator;
import com.vladsch.flexmark.util.collection.iteration.ReversibleIterable;
import com.vladsch.flexmark.util.collection.iteration.ReversibleIterator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class OrderedMap<K, V> implements Map<K, V>, Iterable<Map.Entry<K, V>> {

    @Nullable
    private final CollectionHost<K> host;
    boolean inUpdate;

    @Nullable
    private Indexed<Map.Entry<K, V>> indexedEntryProxy;

    @Nullable
    private Indexed<V> indexedValueProxy;

    @NotNull
    final OrderedSet<K> keySet;

    @NotNull
    private final ArrayList<V> valueList;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class EntryCollectionHost<KK extends K, VV extends V> implements CollectionHost<Map.Entry<KK, VV>> {
        static final /* synthetic */ boolean $assertionsDisabled = false;

        public /* synthetic */ EntryCollectionHost(OrderedMap orderedMap, int i) {
            this();
        }

        @Override // com.vladsch.flexmark.util.collection.CollectionHost
        public void addingNulls(int i) {
            OrderedMap.this.keySet.addNulls(i);
        }

        @Override // com.vladsch.flexmark.util.collection.CollectionHost
        public void clearing() {
            OrderedMap.this.keySet.clear();
        }

        @Override // com.vladsch.flexmark.util.collection.CollectionHost
        public int getIteratorModificationCount() {
            return OrderedMap.this.getModificationCount();
        }

        @Override // com.vladsch.flexmark.util.collection.CollectionHost
        public boolean skipHostUpdate() {
            return OrderedMap.this.inUpdate;
        }

        private EntryCollectionHost() {
        }

        @Override // com.vladsch.flexmark.util.collection.CollectionHost
        public void adding(int i, @Nullable Map.Entry<KK, VV> entry, @Nullable Object obj) {
            OrderedMap.this.keySet.add(entry.getKey(), entry.getValue());
        }

        @Override // com.vladsch.flexmark.util.collection.CollectionHost
        public Object removing(int i, @Nullable Map.Entry<KK, VV> entry) {
            OrderedMap.this.keySet.removeIndex(i);
            return entry;
        }
    }

    public OrderedMap() {
        this(0, null);
    }

    public void addAll(@NotNull Collection<? extends Map.Entry<? extends K, ? extends V>> collection) {
        for (Map.Entry<? extends K, ? extends V> entry : collection) {
            put(entry.getKey(), entry.getValue());
        }
    }

    public void addNull() {
        addNulls(this.valueList.size());
    }

    public void addNulls(int i) {
        if (i < this.valueList.size()) {
            throw new IllegalArgumentException(AbstractC1038a.m1214o(i, this.valueList.size(), "addNulls(", ") called when valueList size is "));
        }
        while (this.valueList.size() <= i) {
            this.valueList.add(null);
        }
    }

    public void adding(int i, @NotNull K k, @NotNull Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException();
        }
        CollectionHost<K> collectionHost = this.host;
        if (collectionHost != null && !collectionHost.skipHostUpdate()) {
            this.host.adding(i, k, obj);
        }
        this.valueList.add(obj);
    }

    public void addingNull(int i) {
        CollectionHost<K> collectionHost = this.host;
        if (collectionHost != null && !collectionHost.skipHostUpdate()) {
            this.host.addingNulls(i);
        }
        addNulls(i);
    }

    @Override // java.util.Map
    public void clear() {
        this.keySet.clear();
    }

    public void clearing() {
        CollectionHost<K> collectionHost = this.host;
        if (collectionHost != null && !collectionHost.skipHostUpdate()) {
            this.host.clearing();
        }
        this.valueList.clear();
    }

    @NotNull
    public V computeIfMissing(@NotNull K k, @NotNull Function<? super K, ? extends V> function) {
        int iIndexOf = this.keySet.indexOf(k);
        if (iIndexOf != -1) {
            return this.valueList.get(iIndexOf);
        }
        V vApply = function.apply(k);
        this.keySet.add(k, vApply);
        return vApply;
    }

    @Override // java.util.Map
    public boolean containsKey(@Nullable Object obj) {
        return this.keySet.contains(obj);
    }

    @Override // java.util.Map
    public boolean containsValue(@Nullable Object obj) {
        return this.keySet.isValidIndex(this.valueList.indexOf(obj));
    }

    @NotNull
    public List<Map.Entry<K, V>> entries() {
        ArrayList arrayList = new ArrayList();
        ReversibleIndexedIterator<Map.Entry<K, V>> reversibleIndexedIteratorEntryIterator = entryIterator();
        while (reversibleIndexedIteratorEntryIterator.hasNext()) {
            arrayList.add(reversibleIndexedIteratorEntryIterator.next());
        }
        return arrayList;
    }

    @NotNull
    public ReversibleIterable<Map.Entry<K, V>> entryIterable() {
        return new IndexedIterable(getIndexedEntryProxy(), this.keySet.indexIterable());
    }

    @NotNull
    public ReversibleIndexedIterator<Map.Entry<K, V>> entryIterator() {
        return new IndexedIterator(getIndexedEntryProxy(), this.keySet.indexIterator());
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        OrderedMap orderedMap = (OrderedMap) obj;
        if (size() != orderedMap.size()) {
            return false;
        }
        return entrySet().equals(orderedMap.entrySet());
    }

    @Override // java.lang.Iterable
    public void forEach(Consumer<? super Map.Entry<K, V>> consumer) {
        ReversibleIndexedIterator<Map.Entry<K, V>> it = iterator();
        while (it.hasNext()) {
            consumer.accept(it.next());
        }
    }

    @Override // java.util.Map
    @Nullable
    public V get(@Nullable Object obj) {
        int iIndexOf = this.keySet.indexOf(obj);
        if (iIndexOf == -1) {
            return null;
        }
        return this.valueList.get(iIndexOf);
    }

    @NotNull
    public Map.Entry<K, V> getEntry(int i) {
        return new MapEntry(this.keySet.getValue(i), this.valueList.get(i));
    }

    @NotNull
    public Indexed<Map.Entry<K, V>> getIndexedEntryProxy() {
        Indexed<Map.Entry<K, V>> indexed = this.indexedEntryProxy;
        if (indexed != null) {
            return indexed;
        }
        Indexed<Map.Entry<K, V>> indexed2 = new Indexed<Map.Entry<K, V>>() { // from class: com.vladsch.flexmark.util.collection.OrderedMap.2
            @Override // com.vladsch.flexmark.util.collection.iteration.Indexed
            public int modificationCount() {
                return OrderedMap.this.getModificationCount();
            }

            @Override // com.vladsch.flexmark.util.collection.iteration.Indexed
            public void removeAt(int i) {
                OrderedMap.this.keySet.removeIndexHosted(i);
            }

            @Override // com.vladsch.flexmark.util.collection.iteration.Indexed
            public int size() {
                return OrderedMap.this.size();
            }

            @Override // com.vladsch.flexmark.util.collection.iteration.Indexed
            public Map.Entry<K, V> get(int i) {
                return OrderedMap.this.getEntry(i);
            }

            @Override // com.vladsch.flexmark.util.collection.iteration.Indexed
            public void set(int i, Map.Entry<K, V> entry) {
                throw new UnsupportedOperationException();
            }
        };
        this.indexedEntryProxy = indexed2;
        return indexed2;
    }

    @NotNull
    public Indexed<V> getIndexedValueProxy() {
        Indexed<V> indexed = this.indexedValueProxy;
        if (indexed != null) {
            return indexed;
        }
        Indexed<V> indexed2 = new Indexed<V>() { // from class: com.vladsch.flexmark.util.collection.OrderedMap.3
            @Override // com.vladsch.flexmark.util.collection.iteration.Indexed
            public V get(int i) {
                return (V) OrderedMap.this.getValue(i);
            }

            @Override // com.vladsch.flexmark.util.collection.iteration.Indexed
            public int modificationCount() {
                return OrderedMap.this.getModificationCount();
            }

            @Override // com.vladsch.flexmark.util.collection.iteration.Indexed
            public void removeAt(int i) {
                OrderedMap.this.keySet.removeIndexHosted(i);
            }

            @Override // com.vladsch.flexmark.util.collection.iteration.Indexed
            public void set(int i, V v) {
                throw new UnsupportedOperationException();
            }

            @Override // com.vladsch.flexmark.util.collection.iteration.Indexed
            public int size() {
                return OrderedMap.this.size();
            }
        };
        this.indexedValueProxy = indexed2;
        return indexed2;
    }

    @Nullable
    public K getKey(int i) {
        if (this.keySet.isValidIndex(i)) {
            return this.keySet.getValueList().get(i);
        }
        return null;
    }

    public int getModificationCount() {
        return this.keySet.getModificationCount();
    }

    @Nullable
    public V getValue(int i) {
        if (this.keySet.isValidIndex(i)) {
            return this.valueList.get(i);
        }
        return null;
    }

    @Override // java.util.Map
    public int hashCode() {
        return this.valueList.hashCode() + (this.keySet.hashCode() * 31);
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this.keySet.isEmpty();
    }

    @NotNull
    public ReversibleIterable<K> keyIterable() {
        return this.keySet.iterable();
    }

    @NotNull
    public ReversibleIndexedIterator<K> keyIterator() {
        return this.keySet.iterator();
    }

    @NotNull
    public List<K> keys() {
        return this.keySet.values();
    }

    @Override // java.util.Map
    @Nullable
    public V put(@NotNull K k, @NotNull V v) {
        int iIndexOf = this.keySet.indexOf(k);
        if (iIndexOf == -1) {
            this.keySet.add(k, v);
            return null;
        }
        V v4 = this.valueList.get(iIndexOf);
        this.valueList.set(iIndexOf, v);
        return v4;
    }

    @Override // java.util.Map
    public void putAll(@NotNull Map<? extends K, ? extends V> map) {
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map
    @NotNull
    public V remove(@Nullable Object obj) {
        return (V) this.keySet.removeHosted(obj);
    }

    public Object removing(int i, @NotNull K k) {
        CollectionHost<K> collectionHost = this.host;
        if (collectionHost != null && !collectionHost.skipHostUpdate()) {
            this.host.removing(i, k);
        }
        return this.valueList.get(i);
    }

    @NotNull
    public ReversibleIterable<Map.Entry<K, V>> reversedEntryIterable() {
        return new IndexedIterable(getIndexedEntryProxy(), this.keySet.reversedIndexIterable());
    }

    @NotNull
    public ReversibleIndexedIterator<Map.Entry<K, V>> reversedEntryIterator() {
        return new IndexedIterator(getIndexedEntryProxy(), this.keySet.reversedIndexIterator());
    }

    @NotNull
    public ReversibleIterable<Map.Entry<K, V>> reversedIterable() {
        return reversedEntryIterable();
    }

    @NotNull
    public ReversibleIndexedIterator<Map.Entry<K, V>> reversedIterator() {
        return reversedEntryIterator();
    }

    @NotNull
    public ReversibleIterable<K> reversedKeyIterable() {
        return this.keySet.reversedIterable();
    }

    @NotNull
    public ReversibleIndexedIterator<K> reversedKeyIterator() {
        return this.keySet.reversedIterator();
    }

    @NotNull
    public ReversibleIterable<V> reversedValueIterable() {
        return new IndexedIterable(getIndexedValueProxy(), this.keySet.reversedIndexIterable());
    }

    @NotNull
    public ReversibleIndexedIterator<V> reversedValueIterator() {
        return new IndexedIterator(getIndexedValueProxy(), this.keySet.reversedIndexIterator());
    }

    @Override // java.util.Map
    public int size() {
        return this.keySet.size();
    }

    @NotNull
    public ReversibleIterable<V> valueIterable() {
        return new IndexedIterable(getIndexedValueProxy(), this.keySet.indexIterable());
    }

    @NotNull
    public ReversibleIndexedIterator<V> valueIterator() {
        return new IndexedIterator(getIndexedValueProxy(), this.keySet.indexIterator());
    }

    @Override // java.util.Map
    @NotNull
    public Collection<V> values() {
        if (!this.keySet.isSparse()) {
            return this.valueList;
        }
        ArrayList arrayList = new ArrayList(this.keySet.size());
        ReversibleIterator<Integer> reversibleIteratorIndexIterator = this.keySet.indexIterator();
        while (reversibleIteratorIndexIterator.hasNext()) {
            arrayList.add(this.valueList.get(reversibleIteratorIndexIterator.next().intValue()));
        }
        return arrayList;
    }

    public OrderedMap(int i) {
        this(i, null);
    }

    @Override // java.util.Map
    @NotNull
    public OrderedSet<Map.Entry<K, V>> entrySet() {
        this.inUpdate = true;
        OrderedSet<Map.Entry<K, V>> orderedSet = new OrderedSet<>(this.keySet.size(), new EntryCollectionHost(this, 0));
        ReversibleIndexedIterator<Map.Entry<K, V>> reversibleIndexedIteratorEntryIterator = entryIterator();
        while (reversibleIndexedIteratorEntryIterator.hasNext()) {
            orderedSet.add(reversibleIndexedIteratorEntryIterator.next());
        }
        this.inUpdate = false;
        return orderedSet;
    }

    @Override // java.lang.Iterable
    @NotNull
    public ReversibleIndexedIterator<Map.Entry<K, V>> iterator() {
        return entryIterator();
    }

    @Override // java.util.Map
    @NotNull
    public OrderedSet<K> keySet() {
        return this.keySet;
    }

    public OrderedMap(@NotNull CollectionHost<K> collectionHost) {
        this(0, collectionHost);
    }

    public OrderedMap(int i, @Nullable CollectionHost<K> collectionHost) {
        this.valueList = new ArrayList<>(i);
        this.host = collectionHost;
        this.indexedEntryProxy = null;
        this.indexedValueProxy = null;
        this.keySet = new OrderedSet<>(i, new CollectionHost<K>() { // from class: com.vladsch.flexmark.util.collection.OrderedMap.1
            @Override // com.vladsch.flexmark.util.collection.CollectionHost
            public void adding(int i2, @Nullable K k, @Nullable Object obj) {
                OrderedMap.this.adding(i2, k, obj);
            }

            @Override // com.vladsch.flexmark.util.collection.CollectionHost
            public void addingNulls(int i2) {
                OrderedMap.this.addingNull(i2);
            }

            @Override // com.vladsch.flexmark.util.collection.CollectionHost
            public void clearing() {
                OrderedMap.this.clearing();
            }

            @Override // com.vladsch.flexmark.util.collection.CollectionHost
            public int getIteratorModificationCount() {
                return OrderedMap.this.getModificationCount();
            }

            @Override // com.vladsch.flexmark.util.collection.CollectionHost
            public Object removing(int i2, @Nullable K k) {
                return OrderedMap.this.removing(i2, k);
            }

            @Override // com.vladsch.flexmark.util.collection.CollectionHost
            public boolean skipHostUpdate() {
                return OrderedMap.this.inUpdate;
            }
        });
    }
}
