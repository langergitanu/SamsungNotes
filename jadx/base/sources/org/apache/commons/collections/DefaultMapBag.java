package org.apache.commons.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.commons.collections.set.UnmodifiableSet;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public abstract class DefaultMapBag implements Bag {
    private Map _map = null;
    private int _total = 0;
    private int _mods = 0;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class BagIterator implements Iterator {
        private Object _current = null;
        private int _mods;
        private DefaultMapBag _parent;
        private Iterator _support;

        public BagIterator(DefaultMapBag defaultMapBag, Iterator it) {
            this._mods = 0;
            this._parent = defaultMapBag;
            this._support = it;
            this._mods = defaultMapBag.modCount();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this._support.hasNext();
        }

        @Override // java.util.Iterator
        public Object next() {
            if (this._parent.modCount() != this._mods) {
                throw new ConcurrentModificationException();
            }
            Object next = this._support.next();
            this._current = next;
            return next;
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this._parent.modCount() != this._mods) {
                throw new ConcurrentModificationException();
            }
            this._support.remove();
            this._parent.remove(this._current, 1);
            this._mods++;
        }
    }

    public DefaultMapBag() {
    }

    private List extractList() {
        ArrayList arrayList = new ArrayList();
        for (Object obj : uniqueSet()) {
            for (int count = getCount(obj); count > 0; count--) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int modCount() {
        return this._mods;
    }

    @Override // org.apache.commons.collections.Bag, java.util.Collection
    public boolean add(Object obj) {
        return add(obj, 1);
    }

    @Override // java.util.Collection
    public boolean addAll(Collection collection) {
        Iterator it = collection.iterator();
        while (true) {
            boolean z = false;
            while (it.hasNext()) {
                boolean zAdd = add(it.next());
                if (z || zAdd) {
                    z = true;
                }
            }
            return z;
        }
    }

    public int calcTotalSize() {
        int size = extractList().size();
        this._total = size;
        return size;
    }

    @Override // java.util.Collection
    public void clear() {
        this._mods++;
        this._map.clear();
        this._total = 0;
    }

    @Override // java.util.Collection
    public boolean contains(Object obj) {
        return this._map.containsKey(obj);
    }

    @Override // org.apache.commons.collections.Bag, java.util.Collection
    public boolean containsAll(Collection collection) {
        return containsAll((Bag) new HashBag(collection));
    }

    @Override // java.util.Collection
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Bag)) {
            return false;
        }
        Bag bag = (Bag) obj;
        if (bag.size() != size()) {
            return false;
        }
        for (Object obj2 : this._map.keySet()) {
            if (bag.getCount(obj2) != getCount(obj2)) {
                return false;
            }
        }
        return true;
    }

    @Override // org.apache.commons.collections.Bag
    public int getCount(Object obj) {
        Integer integer = MapUtils.getInteger(this._map, obj);
        if (integer != null) {
            return integer.intValue();
        }
        return 0;
    }

    public Map getMap() {
        return this._map;
    }

    @Override // java.util.Collection
    public int hashCode() {
        return this._map.hashCode();
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return this._map.isEmpty();
    }

    @Override // org.apache.commons.collections.Bag, java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return new BagIterator(this, extractList().iterator());
    }

    @Override // org.apache.commons.collections.Bag, java.util.Collection
    public boolean remove(Object obj) {
        return remove(obj, getCount(obj));
    }

    @Override // org.apache.commons.collections.Bag, java.util.Collection
    public boolean removeAll(Collection collection) {
        if (collection == null) {
            return false;
        }
        Iterator it = collection.iterator();
        while (true) {
            boolean z = false;
            while (it.hasNext()) {
                boolean zRemove = remove(it.next(), 1);
                if (z || zRemove) {
                    z = true;
                }
            }
            return z;
        }
    }

    @Override // org.apache.commons.collections.Bag, java.util.Collection
    public boolean retainAll(Collection collection) {
        return retainAll((Bag) new HashBag(collection));
    }

    public void setMap(Map map) {
        if (map == null || !map.isEmpty()) {
            throw new IllegalArgumentException("The map must be non-null and empty");
        }
        this._map = map;
    }

    @Override // org.apache.commons.collections.Bag, java.util.Collection
    public int size() {
        return this._total;
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        return extractList().toArray();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("[");
        Iterator it = uniqueSet().iterator();
        while (it.hasNext()) {
            Object next = it.next();
            stringBuffer.append(getCount(next));
            stringBuffer.append(":");
            stringBuffer.append(next);
            if (it.hasNext()) {
                stringBuffer.append(",");
            }
        }
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

    @Override // org.apache.commons.collections.Bag
    public Set uniqueSet() {
        return UnmodifiableSet.decorate(this._map.keySet());
    }

    @Override // org.apache.commons.collections.Bag
    public boolean add(Object obj, int i) {
        this._mods++;
        if (i > 0) {
            int count = getCount(obj) + i;
            this._map.put(obj, new Integer(count));
            this._total += i;
            if (count == i) {
                return true;
            }
        }
        return false;
    }

    public boolean containsAll(Bag bag) {
        boolean z;
        while (true) {
            for (Object obj : bag.uniqueSet()) {
                z = z && (getCount(obj) >= bag.getCount(obj));
            }
            return z;
        }
    }

    @Override // org.apache.commons.collections.Bag
    public boolean remove(Object obj, int i) {
        this._mods++;
        int count = getCount(obj);
        if (i <= 0) {
            return false;
        }
        if (count > i) {
            this._map.put(obj, new Integer(count - i));
            this._total -= i;
            return true;
        }
        boolean z = this._map.remove(obj) != null;
        this._total -= count;
        return z;
    }

    public boolean retainAll(Bag bag) {
        HashBag hashBag = new HashBag();
        for (Object obj : uniqueSet()) {
            int count = getCount(obj);
            int count2 = bag.getCount(obj);
            if (1 > count2 || count2 > count) {
                hashBag.add(obj, count);
            } else {
                hashBag.add(obj, count - count2);
            }
        }
        if (hashBag.isEmpty()) {
            return false;
        }
        return removeAll(hashBag);
    }

    @Override // java.util.Collection
    public Object[] toArray(Object[] objArr) {
        return extractList().toArray(objArr);
    }

    public DefaultMapBag(Map map) {
        setMap(map);
    }
}
