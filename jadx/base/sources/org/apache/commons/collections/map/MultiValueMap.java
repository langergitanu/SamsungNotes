package org.apache.commons.collections.map;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.commons.collections.Factory;
import org.apache.commons.collections.FunctorException;
import org.apache.commons.collections.MultiMap;
import org.apache.commons.collections.iterators.EmptyIterator;
import org.apache.commons.collections.iterators.IteratorChain;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class MultiValueMap extends AbstractMapDecorator implements MultiMap {
    static /* synthetic */ Class class$java$util$ArrayList;
    private final Factory collectionFactory;
    private transient Collection values;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ReflectionFactory implements Factory {
        private final Class clazz;

        public ReflectionFactory(Class cls) {
            this.clazz = cls;
        }

        @Override // org.apache.commons.collections.Factory
        public Object create() {
            try {
                return this.clazz.newInstance();
            } catch (Exception e) {
                StringBuffer stringBuffer = new StringBuffer("Cannot instantiate class: ");
                stringBuffer.append(this.clazz);
                throw new FunctorException(stringBuffer.toString(), e);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class Values extends AbstractCollection {
        private Values() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            MultiValueMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            IteratorChain iteratorChain = new IteratorChain();
            Iterator it = MultiValueMap.this.keySet().iterator();
            while (it.hasNext()) {
                iteratorChain.addIterator(MultiValueMap.this.new ValuesIterator(it.next()));
            }
            return iteratorChain;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return MultiValueMap.this.totalSize();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class ValuesIterator implements Iterator {
        private final Iterator iterator;
        private final Object key;
        private final Collection values;

        public ValuesIterator(Object obj) {
            this.key = obj;
            Collection collection = MultiValueMap.this.getCollection(obj);
            this.values = collection;
            this.iterator = collection.iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.iterator.hasNext();
        }

        @Override // java.util.Iterator
        public Object next() {
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
        HashMap map = new HashMap();
        Class clsClass$ = class$java$util$ArrayList;
        if (clsClass$ == null) {
            clsClass$ = class$("java.util.ArrayList");
            class$java$util$ArrayList = clsClass$;
        }
        this(map, new ReflectionFactory(clsClass$));
    }

    public static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    public static MultiValueMap decorate(Map map) {
        Class clsClass$ = class$java$util$ArrayList;
        if (clsClass$ == null) {
            clsClass$ = class$("java.util.ArrayList");
            class$java$util$ArrayList = clsClass$;
        }
        return new MultiValueMap(map, new ReflectionFactory(clsClass$));
    }

    @Override // org.apache.commons.collections.map.AbstractMapDecorator, java.util.Map
    public void clear() {
        getMap().clear();
    }

    @Override // org.apache.commons.collections.map.AbstractMapDecorator, java.util.Map
    public boolean containsValue(Object obj) {
        Set setEntrySet = getMap().entrySet();
        if (setEntrySet == null) {
            return false;
        }
        Iterator it = setEntrySet.iterator();
        while (it.hasNext()) {
            if (((Collection) ((Map.Entry) it.next()).getValue()).contains(obj)) {
                return true;
            }
        }
        return false;
    }

    public Collection createCollection(int i) {
        return (Collection) this.collectionFactory.create();
    }

    public Collection getCollection(Object obj) {
        return (Collection) getMap().get(obj);
    }

    public Iterator iterator(Object obj) {
        return !containsKey(obj) ? EmptyIterator.INSTANCE : new ValuesIterator(obj);
    }

    @Override // org.apache.commons.collections.map.AbstractMapDecorator, java.util.Map, org.apache.commons.collections.BidiMap
    public Object put(Object obj, Object obj2) {
        boolean zAdd;
        Collection collection = getCollection(obj);
        if (collection == null) {
            zAdd = true;
            Collection collectionCreateCollection = createCollection(1);
            boolean zAdd2 = collectionCreateCollection.add(obj2);
            if (collectionCreateCollection.size() > 0) {
                getMap().put(obj, collectionCreateCollection);
            } else {
                zAdd = zAdd2;
            }
        } else {
            zAdd = collection.add(obj2);
        }
        if (zAdd) {
            return obj2;
        }
        return null;
    }

    @Override // org.apache.commons.collections.map.AbstractMapDecorator, java.util.Map
    public void putAll(Map map) {
        if (!(map instanceof MultiMap)) {
            for (Map.Entry entry : map.entrySet()) {
                put(entry.getKey(), entry.getValue());
            }
            return;
        }
        for (Map.Entry entry2 : map.entrySet()) {
            putAll(entry2.getKey(), (Collection) entry2.getValue());
        }
    }

    @Override // java.util.Map, org.apache.commons.collections.MultiMap
    public Object remove(Object obj, Object obj2) {
        Collection collection = getCollection(obj);
        if (collection == null || !collection.remove(obj2)) {
            return null;
        }
        if (collection.isEmpty()) {
            remove(obj);
        }
        return obj2;
    }

    public int size(Object obj) {
        Collection collection = getCollection(obj);
        if (collection == null) {
            return 0;
        }
        return collection.size();
    }

    public int totalSize() {
        Iterator it = getMap().values().iterator();
        int size = 0;
        while (it.hasNext()) {
            size += ((Collection) it.next()).size();
        }
        return size;
    }

    @Override // org.apache.commons.collections.map.AbstractMapDecorator, java.util.Map
    public Collection values() {
        Collection collection = this.values;
        if (collection != null) {
            return collection;
        }
        Values values = new Values();
        this.values = values;
        return values;
    }

    public MultiValueMap(Map map, Factory factory) {
        super(map);
        if (factory == null) {
            throw new IllegalArgumentException("The factory must not be null");
        }
        this.collectionFactory = factory;
    }

    public static MultiValueMap decorate(Map map, Class cls) {
        return new MultiValueMap(map, new ReflectionFactory(cls));
    }

    public static MultiValueMap decorate(Map map, Factory factory) {
        return new MultiValueMap(map, factory);
    }

    public boolean containsValue(Object obj, Object obj2) {
        Collection collection = getCollection(obj);
        if (collection == null) {
            return false;
        }
        return collection.contains(obj2);
    }

    public boolean putAll(Object obj, Collection collection) {
        if (collection == null || collection.size() == 0) {
            return false;
        }
        Collection collection2 = getCollection(obj);
        if (collection2 == null) {
            Collection collectionCreateCollection = createCollection(collection.size());
            collectionCreateCollection.addAll(collection);
            if (collectionCreateCollection.size() <= 0) {
                return false;
            }
            getMap().put(obj, collectionCreateCollection);
            return true;
        }
        return collection2.addAll(collection);
    }
}
