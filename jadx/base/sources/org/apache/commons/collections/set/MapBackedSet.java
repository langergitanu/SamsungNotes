package org.apache.commons.collections.set;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class MapBackedSet implements Set, Serializable {
    private static final long serialVersionUID = 6723912213766056587L;
    protected final Object dummyValue;
    protected final Map map;

    private MapBackedSet(Map map, Object obj) {
        this.map = map;
        this.dummyValue = obj;
    }

    public static Set decorate(Map map) {
        return decorate(map, null);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean add(Object obj) {
        int size = this.map.size();
        this.map.put(obj, this.dummyValue);
        return this.map.size() != size;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean addAll(Collection collection) {
        int size = this.map.size();
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            this.map.put(it.next(), this.dummyValue);
        }
        return this.map.size() != size;
    }

    @Override // java.util.Set, java.util.Collection
    public void clear() {
        this.map.clear();
    }

    @Override // java.util.Set, java.util.Collection
    public boolean contains(Object obj) {
        return this.map.containsKey(obj);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean containsAll(Collection collection) {
        return this.map.keySet().containsAll(collection);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean equals(Object obj) {
        return this.map.keySet().equals(obj);
    }

    @Override // java.util.Set, java.util.Collection
    public int hashCode() {
        return this.map.keySet().hashCode();
    }

    @Override // java.util.Set, java.util.Collection
    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return this.map.keySet().iterator();
    }

    @Override // java.util.Set, java.util.Collection
    public boolean remove(Object obj) {
        int size = this.map.size();
        this.map.remove(obj);
        return this.map.size() != size;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean removeAll(Collection collection) {
        return this.map.keySet().removeAll(collection);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean retainAll(Collection collection) {
        return this.map.keySet().retainAll(collection);
    }

    @Override // java.util.Set, java.util.Collection
    public int size() {
        return this.map.size();
    }

    @Override // java.util.Set, java.util.Collection
    public Object[] toArray() {
        return this.map.keySet().toArray();
    }

    public static Set decorate(Map map, Object obj) {
        if (map != null) {
            return new MapBackedSet(map, obj);
        }
        throw new IllegalArgumentException("The map must not be null");
    }

    @Override // java.util.Set, java.util.Collection
    public Object[] toArray(Object[] objArr) {
        return this.map.keySet().toArray(objArr);
    }
}
