package org.apache.commons.collections;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import org.apache.commons.collections.iterators.EmptyIterator;
import org.apache.commons.lang3.SystemProperties;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class MultiHashMap extends HashMap implements MultiMap {
    private static final long serialVersionUID = 1943563828307035349L;
    private transient Collection values;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class ValueIterator implements Iterator {
        private Iterator backedIterator;
        private Iterator tempIterator;

        private boolean searchNextIterator() {
            while (true) {
                Iterator it = this.tempIterator;
                if (it != null && it.hasNext()) {
                    return true;
                }
                if (!this.backedIterator.hasNext()) {
                    return false;
                }
                this.tempIterator = ((Collection) this.backedIterator.next()).iterator();
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return searchNextIterator();
        }

        @Override // java.util.Iterator
        public Object next() {
            if (searchNextIterator()) {
                return this.tempIterator.next();
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            Iterator it = this.tempIterator;
            if (it == null) {
                throw new IllegalStateException();
            }
            it.remove();
        }

        private ValueIterator() {
            this.backedIterator = MultiHashMap.this.superValuesIterator();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class Values extends AbstractCollection {
        private Values() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            MultiHashMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return new ValueIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            Iterator it = iterator();
            int i = 0;
            while (it.hasNext()) {
                it.next();
                i++;
            }
            return i;
        }
    }

    public MultiHashMap() {
        this.values = null;
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        String property;
        objectInputStream.defaultReadObject();
        try {
            property = System.getProperty(SystemProperties.JAVA_VERSION);
        } catch (SecurityException unused) {
            property = "1.2";
        }
        if (property.startsWith("1.2") || property.startsWith("1.3")) {
            Iterator it = entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                super.put(entry.getKey(), ((Collection) entry.getValue()).iterator().next());
            }
        }
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public void clear() {
        Iterator it = super.entrySet().iterator();
        while (it.hasNext()) {
            ((Collection) ((Map.Entry) it.next()).getValue()).clear();
        }
        super.clear();
    }

    @Override // java.util.HashMap, java.util.AbstractMap
    public Object clone() {
        MultiHashMap multiHashMap = (MultiHashMap) super.clone();
        Iterator it = multiHashMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            entry.setValue(createCollection((Collection) entry.getValue()));
        }
        return multiHashMap;
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map, org.apache.commons.collections.MultiMap
    public boolean containsValue(Object obj) {
        Set setEntrySet = super.entrySet();
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

    public Collection createCollection(Collection collection) {
        return collection == null ? new ArrayList() : new ArrayList(collection);
    }

    public Collection getCollection(Object obj) {
        return (Collection) get(obj);
    }

    public Iterator iterator(Object obj) {
        Collection collection = getCollection(obj);
        return collection == null ? EmptyIterator.INSTANCE : collection.iterator();
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map, org.apache.commons.collections.MultiMap
    public Object put(Object obj, Object obj2) {
        Collection collection = getCollection(obj);
        if (collection == null) {
            collection = createCollection(null);
            super.put(obj, collection);
        }
        if (collection.add(obj2)) {
            return obj2;
        }
        return null;
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
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

    @Override // java.util.HashMap, java.util.Map, org.apache.commons.collections.MultiMap
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

    public Iterator superValuesIterator() {
        return super.values().iterator();
    }

    public int totalSize() {
        Iterator it = super.values().iterator();
        int size = 0;
        while (it.hasNext()) {
            size += ((Collection) it.next()).size();
        }
        return size;
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map, org.apache.commons.collections.MultiMap
    public Collection values() {
        Collection collection = this.values;
        if (collection != null) {
            return collection;
        }
        Values values = new Values();
        this.values = values;
        return values;
    }

    public MultiHashMap(int i) {
        super(i);
        this.values = null;
    }

    public MultiHashMap(int i, float f) {
        super(i, f);
        this.values = null;
    }

    public MultiHashMap(Map map) {
        super((int) (map.size() * 1.4f));
        this.values = null;
        putAll(map);
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
            Collection collectionCreateCollection = createCollection(collection);
            if (collectionCreateCollection.size() == 0) {
                return false;
            }
            super.put(obj, collectionCreateCollection);
            return true;
        }
        return collection2.addAll(collection);
    }
}
