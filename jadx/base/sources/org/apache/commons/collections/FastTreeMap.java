package org.apache.commons.collections;

import java.util.Collection;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class FastTreeMap extends TreeMap {
    protected boolean fast = false;
    protected TreeMap map;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class KeySet extends CollectionView implements Set {
        private final /* synthetic */ FastTreeMap this$0;

        private KeySet(FastTreeMap fastTreeMap) {
            super();
            this.this$0 = fastTreeMap;
        }

        @Override // org.apache.commons.collections.FastTreeMap.CollectionView
        public Collection get(Map map) {
            return map.keySet();
        }

        @Override // org.apache.commons.collections.FastTreeMap.CollectionView
        public Object iteratorNext(Map.Entry entry) {
            return entry.getKey();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class Values extends CollectionView {
        private final /* synthetic */ FastTreeMap this$0;

        private Values(FastTreeMap fastTreeMap) {
            super();
            this.this$0 = fastTreeMap;
        }

        @Override // org.apache.commons.collections.FastTreeMap.CollectionView
        public Collection get(Map map) {
            return map.values();
        }

        @Override // org.apache.commons.collections.FastTreeMap.CollectionView
        public Object iteratorNext(Map.Entry entry) {
            return entry.getValue();
        }
    }

    public FastTreeMap() {
        this.map = null;
        this.map = new TreeMap();
    }

    @Override // java.util.TreeMap, java.util.AbstractMap, java.util.Map
    public void clear() {
        if (this.fast) {
            synchronized (this) {
                this.map = new TreeMap();
            }
        } else {
            synchronized (this.map) {
                this.map.clear();
            }
        }
    }

    @Override // java.util.TreeMap, java.util.AbstractMap
    public Object clone() {
        FastTreeMap fastTreeMap;
        FastTreeMap fastTreeMap2;
        if (this.fast) {
            fastTreeMap2 = new FastTreeMap((SortedMap) this.map);
        } else {
            synchronized (this.map) {
                fastTreeMap = new FastTreeMap((SortedMap) this.map);
            }
            fastTreeMap2 = fastTreeMap;
        }
        fastTreeMap2.setFast(getFast());
        return fastTreeMap2;
    }

    @Override // java.util.TreeMap, java.util.SortedMap
    public Comparator comparator() {
        Comparator comparator;
        if (this.fast) {
            return this.map.comparator();
        }
        synchronized (this.map) {
            comparator = this.map.comparator();
        }
        return comparator;
    }

    @Override // java.util.TreeMap, java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        boolean zContainsKey;
        if (this.fast) {
            return this.map.containsKey(obj);
        }
        synchronized (this.map) {
            zContainsKey = this.map.containsKey(obj);
        }
        return zContainsKey;
    }

    @Override // java.util.TreeMap, java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object obj) {
        boolean zContainsValue;
        if (this.fast) {
            return this.map.containsValue(obj);
        }
        synchronized (this.map) {
            zContainsValue = this.map.containsValue(obj);
        }
        return zContainsValue;
    }

    @Override // java.util.TreeMap, java.util.AbstractMap, java.util.Map, java.util.SortedMap
    public Set entrySet() {
        return new EntrySet();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map)) {
            return false;
        }
        Map map = (Map) obj;
        if (this.fast) {
            if (map.size() != this.map.size()) {
                return false;
            }
            for (Map.Entry entry : this.map.entrySet()) {
                Object key = entry.getKey();
                Object value = entry.getValue();
                if (value == null) {
                    if (map.get(key) != null || !map.containsKey(key)) {
                        return false;
                    }
                } else if (!value.equals(map.get(key))) {
                    return false;
                }
            }
            return true;
        }
        synchronized (this.map) {
            try {
                if (map.size() != this.map.size()) {
                    return false;
                }
                for (Map.Entry entry2 : this.map.entrySet()) {
                    Object key2 = entry2.getKey();
                    Object value2 = entry2.getValue();
                    if (value2 == null) {
                        if (map.get(key2) != null || !map.containsKey(key2)) {
                            return false;
                        }
                    } else if (!value2.equals(map.get(key2))) {
                        return false;
                    }
                }
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.util.TreeMap, java.util.SortedMap
    public Object firstKey() {
        Object objFirstKey;
        if (this.fast) {
            return this.map.firstKey();
        }
        synchronized (this.map) {
            objFirstKey = this.map.firstKey();
        }
        return objFirstKey;
    }

    @Override // java.util.TreeMap, java.util.AbstractMap, java.util.Map
    public Object get(Object obj) {
        Object obj2;
        if (this.fast) {
            return this.map.get(obj);
        }
        synchronized (this.map) {
            obj2 = this.map.get(obj);
        }
        return obj2;
    }

    public boolean getFast() {
        return this.fast;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int hashCode() {
        int iHashCode = 0;
        if (this.fast) {
            Iterator it = this.map.entrySet().iterator();
            while (it.hasNext()) {
                iHashCode += it.next().hashCode();
            }
            return iHashCode;
        }
        synchronized (this.map) {
            try {
                Iterator it2 = this.map.entrySet().iterator();
                while (it2.hasNext()) {
                    iHashCode += it2.next().hashCode();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return iHashCode;
    }

    @Override // java.util.TreeMap, java.util.NavigableMap, java.util.SortedMap
    public SortedMap headMap(Object obj) {
        SortedMap sortedMapHeadMap;
        if (this.fast) {
            return this.map.headMap(obj);
        }
        synchronized (this.map) {
            sortedMapHeadMap = this.map.headMap(obj);
        }
        return sortedMapHeadMap;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        boolean zIsEmpty;
        if (this.fast) {
            return this.map.isEmpty();
        }
        synchronized (this.map) {
            zIsEmpty = this.map.isEmpty();
        }
        return zIsEmpty;
    }

    @Override // java.util.TreeMap, java.util.AbstractMap, java.util.Map, java.util.SortedMap
    public Set keySet() {
        return new KeySet();
    }

    @Override // java.util.TreeMap, java.util.SortedMap
    public Object lastKey() {
        Object objLastKey;
        if (this.fast) {
            return this.map.lastKey();
        }
        synchronized (this.map) {
            objLastKey = this.map.lastKey();
        }
        return objLastKey;
    }

    @Override // java.util.TreeMap, java.util.AbstractMap, java.util.Map
    public Object put(Object obj, Object obj2) {
        Object objPut;
        Object objPut2;
        if (!this.fast) {
            synchronized (this.map) {
                objPut = this.map.put(obj, obj2);
            }
            return objPut;
        }
        synchronized (this) {
            TreeMap treeMap = (TreeMap) this.map.clone();
            objPut2 = treeMap.put(obj, obj2);
            this.map = treeMap;
        }
        return objPut2;
    }

    @Override // java.util.TreeMap, java.util.AbstractMap, java.util.Map
    public void putAll(Map map) {
        if (!this.fast) {
            synchronized (this.map) {
                this.map.putAll(map);
            }
        } else {
            synchronized (this) {
                TreeMap treeMap = (TreeMap) this.map.clone();
                treeMap.putAll(map);
                this.map = treeMap;
            }
        }
    }

    @Override // java.util.TreeMap, java.util.AbstractMap, java.util.Map
    public Object remove(Object obj) {
        Object objRemove;
        Object objRemove2;
        if (!this.fast) {
            synchronized (this.map) {
                objRemove = this.map.remove(obj);
            }
            return objRemove;
        }
        synchronized (this) {
            TreeMap treeMap = (TreeMap) this.map.clone();
            objRemove2 = treeMap.remove(obj);
            this.map = treeMap;
        }
        return objRemove2;
    }

    public void setFast(boolean z) {
        this.fast = z;
    }

    @Override // java.util.TreeMap, java.util.AbstractMap, java.util.Map
    public int size() {
        int size;
        if (this.fast) {
            return this.map.size();
        }
        synchronized (this.map) {
            size = this.map.size();
        }
        return size;
    }

    @Override // java.util.TreeMap, java.util.NavigableMap, java.util.SortedMap
    public SortedMap subMap(Object obj, Object obj2) {
        SortedMap sortedMapSubMap;
        if (this.fast) {
            return this.map.subMap(obj, obj2);
        }
        synchronized (this.map) {
            sortedMapSubMap = this.map.subMap(obj, obj2);
        }
        return sortedMapSubMap;
    }

    @Override // java.util.TreeMap, java.util.NavigableMap, java.util.SortedMap
    public SortedMap tailMap(Object obj) {
        SortedMap sortedMapTailMap;
        if (this.fast) {
            return this.map.tailMap(obj);
        }
        synchronized (this.map) {
            sortedMapTailMap = this.map.tailMap(obj);
        }
        return sortedMapTailMap;
    }

    @Override // java.util.TreeMap, java.util.AbstractMap, java.util.Map, java.util.SortedMap
    public Collection values() {
        return new Values();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public abstract class CollectionView implements Collection {

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public class CollectionViewIterator implements Iterator {
            private Map expected;
            private Iterator iterator;
            private Map.Entry lastReturned = null;

            public CollectionViewIterator() {
                TreeMap treeMap = FastTreeMap.this.map;
                this.expected = treeMap;
                this.iterator = treeMap.entrySet().iterator();
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                if (this.expected == FastTreeMap.this.map) {
                    return this.iterator.hasNext();
                }
                throw new ConcurrentModificationException();
            }

            @Override // java.util.Iterator
            public Object next() {
                if (this.expected != FastTreeMap.this.map) {
                    throw new ConcurrentModificationException();
                }
                Map.Entry entry = (Map.Entry) this.iterator.next();
                this.lastReturned = entry;
                return CollectionView.this.iteratorNext(entry);
            }

            @Override // java.util.Iterator
            public void remove() {
                if (this.lastReturned == null) {
                    throw new IllegalStateException();
                }
                if (!FastTreeMap.this.fast) {
                    this.iterator.remove();
                    this.lastReturned = null;
                    return;
                }
                synchronized (FastTreeMap.this) {
                    try {
                        if (this.expected != FastTreeMap.this.map) {
                            throw new ConcurrentModificationException();
                        }
                        FastTreeMap.this.remove(this.lastReturned.getKey());
                        this.lastReturned = null;
                        this.expected = FastTreeMap.this.map;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        }

        public CollectionView() {
        }

        @Override // java.util.Collection
        public boolean add(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public boolean addAll(Collection collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public void clear() {
            FastTreeMap fastTreeMap = FastTreeMap.this;
            if (fastTreeMap.fast) {
                synchronized (fastTreeMap) {
                    FastTreeMap.this.map = new TreeMap();
                }
            } else {
                synchronized (fastTreeMap.map) {
                    get(FastTreeMap.this.map).clear();
                }
            }
        }

        @Override // java.util.Collection
        public boolean contains(Object obj) {
            boolean zContains;
            FastTreeMap fastTreeMap = FastTreeMap.this;
            if (fastTreeMap.fast) {
                return get(fastTreeMap.map).contains(obj);
            }
            synchronized (fastTreeMap.map) {
                zContains = get(FastTreeMap.this.map).contains(obj);
            }
            return zContains;
        }

        @Override // java.util.Collection
        public boolean containsAll(Collection collection) {
            boolean zContainsAll;
            FastTreeMap fastTreeMap = FastTreeMap.this;
            if (fastTreeMap.fast) {
                return get(fastTreeMap.map).containsAll(collection);
            }
            synchronized (fastTreeMap.map) {
                zContainsAll = get(FastTreeMap.this.map).containsAll(collection);
            }
            return zContainsAll;
        }

        @Override // java.util.Collection
        public boolean equals(Object obj) {
            boolean zEquals;
            if (obj == this) {
                return true;
            }
            FastTreeMap fastTreeMap = FastTreeMap.this;
            if (fastTreeMap.fast) {
                return get(fastTreeMap.map).equals(obj);
            }
            synchronized (fastTreeMap.map) {
                zEquals = get(FastTreeMap.this.map).equals(obj);
            }
            return zEquals;
        }

        public abstract Collection get(Map map);

        @Override // java.util.Collection
        public int hashCode() {
            int iHashCode;
            FastTreeMap fastTreeMap = FastTreeMap.this;
            if (fastTreeMap.fast) {
                return get(fastTreeMap.map).hashCode();
            }
            synchronized (fastTreeMap.map) {
                iHashCode = get(FastTreeMap.this.map).hashCode();
            }
            return iHashCode;
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            boolean zIsEmpty;
            FastTreeMap fastTreeMap = FastTreeMap.this;
            if (fastTreeMap.fast) {
                return get(fastTreeMap.map).isEmpty();
            }
            synchronized (fastTreeMap.map) {
                zIsEmpty = get(FastTreeMap.this.map).isEmpty();
            }
            return zIsEmpty;
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return new CollectionViewIterator();
        }

        public abstract Object iteratorNext(Map.Entry entry);

        @Override // java.util.Collection
        public boolean remove(Object obj) {
            boolean zRemove;
            boolean zRemove2;
            FastTreeMap fastTreeMap = FastTreeMap.this;
            if (!fastTreeMap.fast) {
                synchronized (fastTreeMap.map) {
                    zRemove = get(FastTreeMap.this.map).remove(obj);
                }
                return zRemove;
            }
            synchronized (fastTreeMap) {
                TreeMap treeMap = (TreeMap) FastTreeMap.this.map.clone();
                zRemove2 = get(treeMap).remove(obj);
                FastTreeMap.this.map = treeMap;
            }
            return zRemove2;
        }

        @Override // java.util.Collection
        public boolean removeAll(Collection collection) {
            boolean zRemoveAll;
            boolean zRemoveAll2;
            FastTreeMap fastTreeMap = FastTreeMap.this;
            if (!fastTreeMap.fast) {
                synchronized (fastTreeMap.map) {
                    zRemoveAll = get(FastTreeMap.this.map).removeAll(collection);
                }
                return zRemoveAll;
            }
            synchronized (fastTreeMap) {
                TreeMap treeMap = (TreeMap) FastTreeMap.this.map.clone();
                zRemoveAll2 = get(treeMap).removeAll(collection);
                FastTreeMap.this.map = treeMap;
            }
            return zRemoveAll2;
        }

        @Override // java.util.Collection
        public boolean retainAll(Collection collection) {
            boolean zRetainAll;
            boolean zRetainAll2;
            FastTreeMap fastTreeMap = FastTreeMap.this;
            if (!fastTreeMap.fast) {
                synchronized (fastTreeMap.map) {
                    zRetainAll = get(FastTreeMap.this.map).retainAll(collection);
                }
                return zRetainAll;
            }
            synchronized (fastTreeMap) {
                TreeMap treeMap = (TreeMap) FastTreeMap.this.map.clone();
                zRetainAll2 = get(treeMap).retainAll(collection);
                FastTreeMap.this.map = treeMap;
            }
            return zRetainAll2;
        }

        @Override // java.util.Collection
        public int size() {
            int size;
            FastTreeMap fastTreeMap = FastTreeMap.this;
            if (fastTreeMap.fast) {
                return get(fastTreeMap.map).size();
            }
            synchronized (fastTreeMap.map) {
                size = get(FastTreeMap.this.map).size();
            }
            return size;
        }

        @Override // java.util.Collection
        public Object[] toArray(Object[] objArr) {
            Object[] array;
            FastTreeMap fastTreeMap = FastTreeMap.this;
            if (fastTreeMap.fast) {
                return get(fastTreeMap.map).toArray(objArr);
            }
            synchronized (fastTreeMap.map) {
                array = get(FastTreeMap.this.map).toArray(objArr);
            }
            return array;
        }

        @Override // java.util.Collection
        public Object[] toArray() {
            Object[] array;
            FastTreeMap fastTreeMap = FastTreeMap.this;
            if (fastTreeMap.fast) {
                return get(fastTreeMap.map).toArray();
            }
            synchronized (fastTreeMap.map) {
                array = get(FastTreeMap.this.map).toArray();
            }
            return array;
        }
    }

    public FastTreeMap(Comparator comparator) {
        this.map = null;
        this.map = new TreeMap(comparator);
    }

    public FastTreeMap(Map map) {
        this.map = null;
        this.map = new TreeMap(map);
    }

    public FastTreeMap(SortedMap sortedMap) {
        this.map = null;
        this.map = new TreeMap(sortedMap);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class EntrySet extends CollectionView implements Set {
        private final /* synthetic */ FastTreeMap this$0;

        private EntrySet(FastTreeMap fastTreeMap) {
            super();
            this.this$0 = fastTreeMap;
        }

        @Override // org.apache.commons.collections.FastTreeMap.CollectionView
        public Collection get(Map map) {
            return map.entrySet();
        }

        @Override // org.apache.commons.collections.FastTreeMap.CollectionView
        public Object iteratorNext(Map.Entry entry) {
            return entry;
        }
    }
}
