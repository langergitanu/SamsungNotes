package org.apache.commons.collections4.map;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Factory;
import org.apache.commons.collections4.FunctorException;
import org.apache.commons.collections4.MultiMap;
import org.apache.commons.collections4.Transformer;
import org.apache.commons.collections4.iterators.EmptyIterator;
import org.apache.commons.collections4.iterators.IteratorChain;
import org.apache.commons.collections4.iterators.LazyIteratorChain;
import org.apache.commons.collections4.iterators.TransformIterator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Deprecated
public class MultiValueMap<K, V> extends AbstractMapDecorator<K, Object> implements MultiMap<K, V>, Serializable {
    private static final long serialVersionUID = -2214159910087182007L;
    private final Factory<? extends Collection<V>> collectionFactory;
    private transient Collection<V> valuesView;

    /* JADX INFO: renamed from: org.apache.commons.collections4.map.MultiValueMap$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class C137691 extends LazyIteratorChain<Map.Entry<K, V>> {
        final /* synthetic */ MultiValueMap this$0;
        final /* synthetic */ Iterator val$keyIterator;

        public C137691(MultiValueMap multiValueMap, Iterator it) {
            this.val$keyIterator = it;
            this.this$0 = multiValueMap;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Map.Entry lambda$nextIterator$0(final Object obj, final Object obj2) {
            return new Map.Entry<K, V>(this) { // from class: org.apache.commons.collections4.map.MultiValueMap.1.1
                final /* synthetic */ C137691 this$1;

                {
                    this.this$1 = this;
                }

                @Override // java.util.Map.Entry
                public K getKey() {
                    return (K) obj;
                }

                @Override // java.util.Map.Entry
                public V getValue() {
                    return (V) obj2;
                }

                @Override // java.util.Map.Entry
                public V setValue(V v) {
                    throw new UnsupportedOperationException();
                }
            };
        }

        @Override // org.apache.commons.collections4.iterators.LazyIteratorChain
        public Iterator<? extends Map.Entry<K, V>> nextIterator(int i) {
            if (!this.val$keyIterator.hasNext()) {
                return null;
            }
            final Object next = this.val$keyIterator.next();
            return new TransformIterator(new ValuesIterator(next), new Transformer() { // from class: org.apache.commons.collections4.map.b
                @Override // org.apache.commons.collections4.Transformer
                public final Object transform(Object obj) {
                    return this.f9752a.lambda$nextIterator$0(next, obj);
                }
            });
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class ReflectionFactory<T extends Collection<?>> implements Factory<T>, Serializable {
        private static final long serialVersionUID = 2986114157496788874L;
        private final Class<T> clazz;

        public ReflectionFactory(Class<T> cls) {
            this.clazz = cls;
        }

        private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
            objectInputStream.defaultReadObject();
            Class<T> cls = this.clazz;
            if (cls != null && !Collection.class.isAssignableFrom(cls)) {
                throw new UnsupportedOperationException();
            }
        }

        @Override // org.apache.commons.collections4.Factory
        public T create() {
            try {
                return this.clazz.getDeclaredConstructor(null).newInstance(null);
            } catch (Exception e) {
                throw new FunctorException("Cannot instantiate class: " + this.clazz, e);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public final class Values extends AbstractCollection<V> {
        private Values() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            MultiValueMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            IteratorChain iteratorChain = new IteratorChain();
            Iterator<K> it = MultiValueMap.this.keySet().iterator();
            while (it.hasNext()) {
                iteratorChain.addIterator(new ValuesIterator(it.next()));
            }
            return iteratorChain;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return MultiValueMap.this.totalSize();
        }

        public /* synthetic */ Values(MultiValueMap multiValueMap, C137691 c137691) {
            this();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public final class ValuesIterator implements Iterator<V> {
        private final Iterator<V> iterator;
        private final Object key;
        private final Collection<V> values;

        public ValuesIterator(Object obj) {
            this.key = obj;
            Collection<V> collection = MultiValueMap.this.getCollection(obj);
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
                MultiValueMap.this.remove(this.key);
            }
        }
    }

    public MultiValueMap() {
        this(new HashMap(), new ReflectionFactory(ArrayList.class));
    }

    public static <K, V, C extends Collection<V>> MultiValueMap<K, V> multiValueMap(Map<K, ? super C> map, Class<C> cls) {
        return new MultiValueMap<>(map, new ReflectionFactory(cls));
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        this.map = (Map) objectInputStream.readObject();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.map);
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map, org.apache.commons.collections4.Put
    public void clear() {
        decorated().clear();
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map, org.apache.commons.collections4.Get
    public boolean containsValue(Object obj) {
        Set<Map.Entry<K, V>> setEntrySet = decorated().entrySet();
        if (setEntrySet == null) {
            return false;
        }
        Iterator<Map.Entry<K, V>> it = setEntrySet.iterator();
        while (it.hasNext()) {
            if (((Collection) it.next().getValue()).contains(obj)) {
                return true;
            }
        }
        return false;
    }

    public Collection<V> createCollection(int i) {
        return this.collectionFactory.get();
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map, org.apache.commons.collections4.Get
    public Set<Map.Entry<K, Object>> entrySet() {
        return super.entrySet();
    }

    public Collection<V> getCollection(Object obj) {
        return (Collection) decorated().get(obj);
    }

    public Iterator<Map.Entry<K, V>> iterator() {
        return new C137691(this, new ArrayList(keySet()).iterator());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map, org.apache.commons.collections4.Put
    public Object put(K k, Object obj) {
        boolean zAdd;
        Collection<V> collection = getCollection(k);
        if (collection == null) {
            zAdd = true;
            Collection<V> collectionCreateCollection = createCollection(1);
            collectionCreateCollection.add(obj);
            if (collectionCreateCollection.isEmpty()) {
                zAdd = false;
            } else {
                decorated().put(k, collectionCreateCollection);
            }
        } else {
            zAdd = collection.add(obj);
        }
        if (zAdd) {
            return obj;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean putAll(K k, Collection<V> collection) {
        if (collection == 0 || collection.isEmpty()) {
            return false;
        }
        Collection<V> collection2 = getCollection(k);
        if (collection2 != null) {
            return collection2.addAll(collection);
        }
        Collection<V> collectionCreateCollection = createCollection(collection.size());
        collectionCreateCollection.addAll(collection);
        if (collectionCreateCollection.isEmpty()) {
            return false;
        }
        decorated().put(k, collectionCreateCollection);
        return true;
    }

    @Override // org.apache.commons.collections4.MultiMap
    public boolean removeMapping(Object obj, Object obj2) {
        Collection<V> collection = getCollection(obj);
        if (collection == null || !collection.remove(obj2)) {
            return false;
        }
        if (!collection.isEmpty()) {
            return true;
        }
        remove(obj);
        return true;
    }

    public int size(Object obj) {
        Collection<V> collection = getCollection(obj);
        if (collection == null) {
            return 0;
        }
        return collection.size();
    }

    public int totalSize() {
        Iterator<V> it = decorated().values().iterator();
        int size = 0;
        while (it.hasNext()) {
            size += CollectionUtils.size(it.next());
        }
        return size;
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map, org.apache.commons.collections4.Get
    public Collection<Object> values() {
        Collection<V> collection = this.valuesView;
        if (collection != null) {
            return collection;
        }
        Values values = new Values(this, null);
        this.valuesView = values;
        return values;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <C extends Collection<V>> MultiValueMap(Map<K, ? super C> map, Factory<C> factory) {
        super(map);
        if (factory == 0) {
            throw new IllegalArgumentException("The factory must not be null");
        }
        this.collectionFactory = factory;
    }

    public static <K, V, C extends Collection<V>> MultiValueMap<K, V> multiValueMap(Map<K, ? super C> map, Factory<C> factory) {
        return new MultiValueMap<>(map, factory);
    }

    public static <K, V> MultiValueMap<K, V> multiValueMap(Map<K, ? super Collection<V>> map) {
        return multiValueMap(map, ArrayList.class);
    }

    public boolean containsValue(Object obj, Object obj2) {
        Collection<V> collection = getCollection(obj);
        if (collection == null) {
            return false;
        }
        return collection.contains(obj2);
    }

    public Iterator<V> iterator(Object obj) {
        if (!containsKey(obj)) {
            return EmptyIterator.emptyIterator();
        }
        return new ValuesIterator(obj);
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map, org.apache.commons.collections4.Put
    public void putAll(Map<? extends K, ?> map) {
        if (map instanceof MultiMap) {
            for (Map.Entry<K, Object> entry : ((MultiMap) map).entrySet()) {
                putAll(entry.getKey(), (Collection) entry.getValue());
            }
            return;
        }
        for (Map.Entry<? extends K, ?> entry2 : map.entrySet()) {
            put(entry2.getKey(), entry2.getValue());
        }
    }
}
