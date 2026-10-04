package org.apache.commons.collections4.multimap;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.IteratorUtils;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.MultiSet;
import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.Transformer;
import org.apache.commons.collections4.iterators.AbstractIteratorDecorator;
import org.apache.commons.collections4.iterators.EmptyMapIterator;
import org.apache.commons.collections4.iterators.IteratorChain;
import org.apache.commons.collections4.iterators.LazyIteratorChain;
import org.apache.commons.collections4.iterators.TransformIterator;
import org.apache.commons.collections4.keyvalue.AbstractMapEntry;
import org.apache.commons.collections4.keyvalue.UnmodifiableMapEntry;
import org.apache.commons.collections4.multiset.AbstractMultiSet;
import org.apache.commons.collections4.multiset.UnmodifiableMultiSet;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public abstract class AbstractMultiValuedMap<K, V> implements MultiValuedMap<K, V> {
    private transient AbstractMultiValuedMap<K, V>.AsMap asMapView;
    private transient AbstractMultiValuedMap<K, V>.EntryValues entryValuesView;
    private transient MultiSet<K> keysMultiSetView;
    private transient Map<K, Collection<V>> map;
    private transient Collection<V> valuesView;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public final class AsMap extends AbstractMap<K, Collection<V>> {
        final transient Map<K, Collection<V>> map;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public final class AsMapEntrySet extends AbstractSet<Map.Entry<K, Collection<V>>> {
            public AsMapEntrySet() {
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public void clear() {
                AsMap.this.clear();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object obj) {
                return AsMap.this.map.entrySet().contains(obj);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<K, Collection<V>>> iterator() {
                AsMap asMap = AsMap.this;
                return asMap.new AsMapEntrySetIterator(asMap.map.entrySet().iterator());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object obj) {
                if (!contains(obj)) {
                    return false;
                }
                AbstractMultiValuedMap.this.remove(((Map.Entry) obj).getKey());
                return true;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return AsMap.this.size();
            }
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public final class AsMapEntrySetIterator extends AbstractIteratorDecorator<Map.Entry<K, Collection<V>>> {
            public AsMapEntrySetIterator(Iterator<Map.Entry<K, Collection<V>>> it) {
                super(it);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // org.apache.commons.collections4.iterators.AbstractIteratorDecorator, java.util.Iterator
            public Map.Entry<K, Collection<V>> next() {
                Object key = ((Map.Entry) super.next()).getKey();
                return new UnmodifiableMapEntry(key, AbstractMultiValuedMap.this.wrappedCollection(key));
            }
        }

        public AsMap(Map<K, Collection<V>> map) {
            this.map = map;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            AbstractMultiValuedMap.this.clear();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return this.map.containsKey(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<Map.Entry<K, Collection<V>>> entrySet() {
            return new AsMapEntrySet();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean equals(Object obj) {
            return this == obj || this.map.equals(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int hashCode() {
            return this.map.hashCode();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<K> keySet() {
            return AbstractMultiValuedMap.this.keySet();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return this.map.size();
        }

        @Override // java.util.AbstractMap
        public String toString() {
            return this.map.toString();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Collection<V> get(Object obj) {
            if (this.map.get(obj) == null) {
                return null;
            }
            return AbstractMultiValuedMap.this.wrappedCollection(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Collection<V> remove(Object obj) {
            Collection<V> collectionRemove = this.map.remove(obj);
            if (collectionRemove == null) {
                return null;
            }
            Collection<V> collectionCreateCollection = AbstractMultiValuedMap.this.createCollection();
            collectionCreateCollection.addAll(collectionRemove);
            collectionRemove.clear();
            return collectionCreateCollection;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public final class EntryValues extends AbstractCollection<Map.Entry<K, V>> {

        /* JADX INFO: renamed from: org.apache.commons.collections4.multimap.AbstractMultiValuedMap$EntryValues$1 */
        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public class C137741 extends LazyIteratorChain<Map.Entry<K, V>> {
            final Iterator<K> keyIterator;
            final Collection<K> keysCol;

            public C137741() {
                ArrayList arrayList = new ArrayList(AbstractMultiValuedMap.this.getMap().keySet());
                this.keysCol = arrayList;
                this.keyIterator = arrayList.iterator();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ Map.Entry lambda$nextIterator$0(Object obj, Object obj2) {
                return new MultiValuedMapEntry(obj, obj2);
            }

            @Override // org.apache.commons.collections4.iterators.LazyIteratorChain
            public Iterator<? extends Map.Entry<K, V>> nextIterator(int i) {
                if (!this.keyIterator.hasNext()) {
                    return null;
                }
                final K next = this.keyIterator.next();
                return new TransformIterator(new ValuesIterator(next), new Transformer() { // from class: org.apache.commons.collections4.multimap.a
                    @Override // org.apache.commons.collections4.Transformer
                    public final Object transform(Object obj) {
                        return this.f9755a.lambda$nextIterator$0(next, obj);
                    }
                });
            }
        }

        private EntryValues() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<Map.Entry<K, V>> iterator() {
            return new C137741();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return AbstractMultiValuedMap.this.size();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public final class KeysMultiSet extends AbstractMultiSet<K> {

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public final class MapEntryTransformer implements Transformer<Map.Entry<K, Collection<V>>, MultiSet.Entry<K>> {
            private MapEntryTransformer() {
            }

            @Override // org.apache.commons.collections4.Transformer
            public MultiSet.Entry<K> transform(final Map.Entry<K, Collection<V>> entry) {
                return new AbstractMultiSet.AbstractEntry<K>(this) { // from class: org.apache.commons.collections4.multimap.AbstractMultiValuedMap.KeysMultiSet.MapEntryTransformer.1
                    final /* synthetic */ MapEntryTransformer this$2;

                    {
                        this.this$2 = this;
                    }

                    @Override // org.apache.commons.collections4.MultiSet.Entry
                    public int getCount() {
                        return ((Collection) entry.getValue()).size();
                    }

                    @Override // org.apache.commons.collections4.MultiSet.Entry
                    public K getElement() {
                        return (K) entry.getKey();
                    }
                };
            }
        }

        private KeysMultiSet() {
        }

        @Override // org.apache.commons.collections4.multiset.AbstractMultiSet, java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return AbstractMultiValuedMap.this.getMap().containsKey(obj);
        }

        @Override // org.apache.commons.collections4.multiset.AbstractMultiSet
        public Iterator<MultiSet.Entry<K>> createEntrySetIterator() {
            return IteratorUtils.transformedIterator(AbstractMultiValuedMap.this.map.entrySet().iterator(), new MapEntryTransformer());
        }

        @Override // org.apache.commons.collections4.multiset.AbstractMultiSet, org.apache.commons.collections4.MultiSet
        public int getCount(Object obj) {
            Collection<V> collection = AbstractMultiValuedMap.this.getMap().get(obj);
            if (collection != null) {
                return collection.size();
            }
            return 0;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return AbstractMultiValuedMap.this.getMap().isEmpty();
        }

        @Override // org.apache.commons.collections4.multiset.AbstractMultiSet, java.util.AbstractCollection, java.util.Collection, org.apache.commons.collections4.MultiSet
        public int size() {
            return AbstractMultiValuedMap.this.size();
        }

        @Override // org.apache.commons.collections4.multiset.AbstractMultiSet
        public int uniqueElements() {
            return AbstractMultiValuedMap.this.getMap().size();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public final class MultiValuedMapEntry extends AbstractMapEntry<K, V> {
        public MultiValuedMapEntry(K k, V v) {
            super(k, v);
        }

        @Override // org.apache.commons.collections4.keyvalue.AbstractMapEntry, org.apache.commons.collections4.keyvalue.AbstractKeyValue, java.util.Map.Entry
        public V setValue(V v) {
            throw new UnsupportedOperationException();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public final class MultiValuedMapIterator implements MapIterator<K, V> {
        private Map.Entry<K, V> current;

        /* JADX INFO: renamed from: it */
        private final Iterator<Map.Entry<K, V>> f9754it;

        public MultiValuedMapIterator() {
            this.f9754it = AbstractMultiValuedMap.this.entries().iterator();
        }

        @Override // org.apache.commons.collections4.MapIterator
        public K getKey() {
            Map.Entry<K, V> entry = this.current;
            if (entry != null) {
                return entry.getKey();
            }
            throw new IllegalStateException();
        }

        @Override // org.apache.commons.collections4.MapIterator
        public V getValue() {
            Map.Entry<K, V> entry = this.current;
            if (entry != null) {
                return entry.getValue();
            }
            throw new IllegalStateException();
        }

        @Override // org.apache.commons.collections4.MapIterator, java.util.Iterator
        public boolean hasNext() {
            return this.f9754it.hasNext();
        }

        @Override // org.apache.commons.collections4.MapIterator, java.util.Iterator
        public K next() {
            Map.Entry<K, V> next = this.f9754it.next();
            this.current = next;
            return next.getKey();
        }

        @Override // org.apache.commons.collections4.MapIterator, java.util.Iterator
        public void remove() {
            this.f9754it.remove();
        }

        @Override // org.apache.commons.collections4.MapIterator
        public V setValue(V v) {
            Map.Entry<K, V> entry = this.current;
            if (entry != null) {
                return entry.setValue(v);
            }
            throw new IllegalStateException();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public final class Values extends AbstractCollection<V> {
        private Values() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            AbstractMultiValuedMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            IteratorChain iteratorChain = new IteratorChain();
            Iterator<K> it = AbstractMultiValuedMap.this.keySet().iterator();
            while (it.hasNext()) {
                iteratorChain.addIterator(new ValuesIterator(it.next()));
            }
            return iteratorChain;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return AbstractMultiValuedMap.this.size();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public final class ValuesIterator implements Iterator<V> {
        private final Iterator<V> iterator;
        private final Object key;
        private final Collection<V> values;

        public ValuesIterator(Object obj) {
            this.key = obj;
            Collection<V> collection = AbstractMultiValuedMap.this.getMap().get(obj);
            this.values = collection;
            this.iterator = collection.iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.iterator.hasNext();
        }

        @Override // java.util.Iterator
        public V next() {
            return this.iterator.next();
        }

        @Override // java.util.Iterator
        public void remove() {
            this.iterator.remove();
            if (this.values.isEmpty()) {
                AbstractMultiValuedMap.this.remove(this.key);
            }
        }
    }

    public AbstractMultiValuedMap() {
    }

    @Override // org.apache.commons.collections4.MultiValuedMap
    public Map<K, Collection<V>> asMap() {
        AbstractMultiValuedMap<K, V>.AsMap asMap = this.asMapView;
        if (asMap != null) {
            return asMap;
        }
        AbstractMultiValuedMap<K, V>.AsMap asMap2 = new AsMap(this.map);
        this.asMapView = asMap2;
        return asMap2;
    }

    @Override // org.apache.commons.collections4.MultiValuedMap
    public void clear() {
        getMap().clear();
    }

    @Override // org.apache.commons.collections4.MultiValuedMap
    public boolean containsKey(Object obj) {
        return getMap().containsKey(obj);
    }

    @Override // org.apache.commons.collections4.MultiValuedMap
    public boolean containsMapping(Object obj, Object obj2) {
        Collection<V> collection = getMap().get(obj);
        return collection != null && collection.contains(obj2);
    }

    @Override // org.apache.commons.collections4.MultiValuedMap
    public boolean containsValue(Object obj) {
        return values().contains(obj);
    }

    public abstract Collection<V> createCollection();

    /* JADX WARN: Multi-variable type inference failed */
    public void doReadObject(ObjectInputStream objectInputStream) {
        int i = objectInputStream.readInt();
        for (int i2 = 0; i2 < i; i2++) {
            Collection collection = get(objectInputStream.readObject());
            int i4 = objectInputStream.readInt();
            for (int i5 = 0; i5 < i4; i5++) {
                collection.add(objectInputStream.readObject());
            }
        }
    }

    public void doWriteObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.writeInt(this.map.size());
        for (Map.Entry<K, Collection<V>> entry : this.map.entrySet()) {
            objectOutputStream.writeObject(entry.getKey());
            objectOutputStream.writeInt(entry.getValue().size());
            Iterator<V> it = entry.getValue().iterator();
            while (it.hasNext()) {
                objectOutputStream.writeObject(it.next());
            }
        }
    }

    @Override // org.apache.commons.collections4.MultiValuedMap
    public Collection<Map.Entry<K, V>> entries() {
        AbstractMultiValuedMap<K, V>.EntryValues entryValues = this.entryValuesView;
        if (entryValues != null) {
            return entryValues;
        }
        AbstractMultiValuedMap<K, V>.EntryValues entryValues2 = new EntryValues();
        this.entryValuesView = entryValues2;
        return entryValues2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MultiValuedMap) {
            return asMap().equals(((MultiValuedMap) obj).asMap());
        }
        return false;
    }

    @Override // org.apache.commons.collections4.MultiValuedMap
    public Collection<V> get(K k) {
        return wrappedCollection(k);
    }

    public Map<K, ? extends Collection<V>> getMap() {
        return this.map;
    }

    public int hashCode() {
        return getMap().hashCode();
    }

    @Override // org.apache.commons.collections4.MultiValuedMap
    public boolean isEmpty() {
        return getMap().isEmpty();
    }

    @Override // org.apache.commons.collections4.MultiValuedMap
    public Set<K> keySet() {
        return getMap().keySet();
    }

    @Override // org.apache.commons.collections4.MultiValuedMap
    public MultiSet<K> keys() {
        if (this.keysMultiSetView == null) {
            this.keysMultiSetView = UnmodifiableMultiSet.unmodifiableMultiSet(new KeysMultiSet());
        }
        return this.keysMultiSetView;
    }

    @Override // org.apache.commons.collections4.MultiValuedMap
    public MapIterator<K, V> mapIterator() {
        return isEmpty() ? EmptyMapIterator.emptyMapIterator() : new MultiValuedMapIterator();
    }

    @Override // org.apache.commons.collections4.MultiValuedMap
    public boolean put(K k, V v) {
        Collection<V> collection = getMap().get(k);
        if (collection != null) {
            return collection.add(v);
        }
        Collection<V> collectionCreateCollection = createCollection();
        if (!collectionCreateCollection.add(v)) {
            return false;
        }
        this.map.put(k, collectionCreateCollection);
        return true;
    }

    @Override // org.apache.commons.collections4.MultiValuedMap
    public boolean putAll(K k, Iterable<? extends V> iterable) {
        Objects.requireNonNull(iterable, "values");
        if (iterable instanceof Collection) {
            Collection<? extends V> collection = (Collection) iterable;
            return !collection.isEmpty() && get(k).addAll(collection);
        }
        Iterator<? extends V> it = iterable.iterator();
        return it.hasNext() && CollectionUtils.addAll(get(k), it);
    }

    @Override // org.apache.commons.collections4.MultiValuedMap
    public Collection<V> remove(Object obj) {
        return CollectionUtils.emptyIfNull(getMap().remove(obj));
    }

    @Override // org.apache.commons.collections4.MultiValuedMap
    public boolean removeMapping(Object obj, Object obj2) {
        Collection<V> collection = getMap().get(obj);
        if (collection == null) {
            return false;
        }
        boolean zRemove = collection.remove(obj2);
        if (collection.isEmpty()) {
            getMap().remove(obj);
        }
        return zRemove;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setMap(Map<K, ? extends Collection<V>> map) {
        this.map = map;
    }

    @Override // org.apache.commons.collections4.MultiValuedMap
    public int size() {
        Iterator<? extends Collection<V>> it = getMap().values().iterator();
        int size = 0;
        while (it.hasNext()) {
            size += it.next().size();
        }
        return size;
    }

    public String toString() {
        return getMap().toString();
    }

    @Override // org.apache.commons.collections4.MultiValuedMap
    public Collection<V> values() {
        Collection<V> collection = this.valuesView;
        if (collection != null) {
            return collection;
        }
        Values values = new Values();
        this.valuesView = values;
        return values;
    }

    public Collection<V> wrappedCollection(K k) {
        return new WrappedCollection(k);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AbstractMultiValuedMap(Map<K, ? extends Collection<V>> map) {
        Objects.requireNonNull(map, "map");
        this.map = map;
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class WrappedCollection implements Collection<V> {
        protected final K key;

        public WrappedCollection(K k) {
            this.key = k;
        }

        @Override // java.util.Collection
        public boolean add(V v) {
            Collection<V> mapping = getMapping();
            if (mapping == null) {
                mapping = AbstractMultiValuedMap.this.createCollection();
                AbstractMultiValuedMap.this.map.put(this.key, mapping);
            }
            return mapping.add(v);
        }

        @Override // java.util.Collection
        public boolean addAll(Collection<? extends V> collection) {
            Collection<V> mapping = getMapping();
            if (mapping == null) {
                mapping = AbstractMultiValuedMap.this.createCollection();
                AbstractMultiValuedMap.this.map.put(this.key, mapping);
            }
            return mapping.addAll(collection);
        }

        @Override // java.util.Collection
        public void clear() {
            Collection<V> mapping = getMapping();
            if (mapping != null) {
                mapping.clear();
                AbstractMultiValuedMap.this.remove(this.key);
            }
        }

        @Override // java.util.Collection
        public boolean contains(Object obj) {
            Collection<V> mapping = getMapping();
            return mapping != null && mapping.contains(obj);
        }

        @Override // java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            Collection<V> mapping = getMapping();
            return mapping != null && mapping.containsAll(collection);
        }

        public Collection<V> getMapping() {
            return AbstractMultiValuedMap.this.getMap().get(this.key);
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            Collection<V> mapping = getMapping();
            return mapping == null || mapping.isEmpty();
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return getMapping() == null ? IteratorUtils.EMPTY_ITERATOR : new ValuesIterator(this.key);
        }

        @Override // java.util.Collection
        public boolean remove(Object obj) {
            Collection<V> mapping = getMapping();
            if (mapping == null) {
                return false;
            }
            boolean zRemove = mapping.remove(obj);
            if (mapping.isEmpty()) {
                AbstractMultiValuedMap.this.remove(this.key);
            }
            return zRemove;
        }

        @Override // java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            Collection<V> mapping = getMapping();
            if (mapping == null) {
                return false;
            }
            boolean zRemoveAll = mapping.removeAll(collection);
            if (mapping.isEmpty()) {
                AbstractMultiValuedMap.this.remove(this.key);
            }
            return zRemoveAll;
        }

        @Override // java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            Collection<V> mapping = getMapping();
            if (mapping == null) {
                return false;
            }
            boolean zRetainAll = mapping.retainAll(collection);
            if (mapping.isEmpty()) {
                AbstractMultiValuedMap.this.remove(this.key);
            }
            return zRetainAll;
        }

        @Override // java.util.Collection
        public int size() {
            Collection<V> mapping = getMapping();
            if (mapping == null) {
                return 0;
            }
            return mapping.size();
        }

        @Override // java.util.Collection
        public Object[] toArray() {
            Collection<V> mapping = getMapping();
            return mapping == null ? CollectionUtils.EMPTY_COLLECTION.toArray() : mapping.toArray();
        }

        public String toString() {
            Collection<V> mapping = getMapping();
            return mapping == null ? CollectionUtils.EMPTY_COLLECTION.toString() : mapping.toString();
        }

        @Override // java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            Collection<V> mapping = getMapping();
            if (mapping == null) {
                return (T[]) CollectionUtils.EMPTY_COLLECTION.toArray(tArr);
            }
            return (T[]) mapping.toArray(tArr);
        }
    }

    @Override // org.apache.commons.collections4.MultiValuedMap
    public boolean putAll(Map<? extends K, ? extends V> map) {
        Objects.requireNonNull(map, "map");
        boolean zPut = false;
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            zPut |= put(entry.getKey(), entry.getValue());
        }
        return zPut;
    }

    @Override // org.apache.commons.collections4.MultiValuedMap
    public boolean putAll(MultiValuedMap<? extends K, ? extends V> multiValuedMap) {
        Objects.requireNonNull(multiValuedMap, "map");
        boolean zPut = false;
        for (Map.Entry<? extends K, ? extends V> entry : multiValuedMap.entries()) {
            zPut |= put(entry.getKey(), entry.getValue());
        }
        return zPut;
    }
}
