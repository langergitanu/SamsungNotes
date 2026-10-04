package org.apache.commons.collections.bag;

import com.adobe.internal.xmp.XMPConst;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.collections.Bag;
import org.apache.commons.collections.set.UnmodifiableSet;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public abstract class AbstractMapBag implements Bag {
    private transient Map map;
    private transient int modCount;
    private int size;
    private transient Set uniqueSet;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class BagIterator implements Iterator {
        private Iterator entryIterator;
        private int itemCount;
        private final int mods;
        private AbstractMapBag parent;
        private Map.Entry current = null;
        private boolean canRemove = false;

        public BagIterator(AbstractMapBag abstractMapBag) {
            this.parent = abstractMapBag;
            this.entryIterator = abstractMapBag.map.entrySet().iterator();
            this.mods = abstractMapBag.modCount;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.itemCount > 0 || this.entryIterator.hasNext();
        }

        @Override // java.util.Iterator
        public Object next() {
            if (this.parent.modCount != this.mods) {
                throw new ConcurrentModificationException();
            }
            if (this.itemCount == 0) {
                Map.Entry entry = (Map.Entry) this.entryIterator.next();
                this.current = entry;
                this.itemCount = ((MutableInteger) entry.getValue()).value;
            }
            this.canRemove = true;
            this.itemCount--;
            return this.current.getKey();
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.parent.modCount != this.mods) {
                throw new ConcurrentModificationException();
            }
            if (!this.canRemove) {
                throw new IllegalStateException();
            }
            MutableInteger mutableInteger = (MutableInteger) this.current.getValue();
            int i = mutableInteger.value;
            if (i > 1) {
                mutableInteger.value = i - 1;
            } else {
                this.entryIterator.remove();
            }
            AbstractMapBag.access$210(this.parent);
            this.canRemove = false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class MutableInteger {
        protected int value;

        public MutableInteger(int i) {
            this.value = i;
        }

        public boolean equals(Object obj) {
            return (obj instanceof MutableInteger) && ((MutableInteger) obj).value == this.value;
        }

        public int hashCode() {
            return this.value;
        }
    }

    public AbstractMapBag() {
    }

    public static /* synthetic */ int access$210(AbstractMapBag abstractMapBag) {
        int i = abstractMapBag.size;
        abstractMapBag.size = i - 1;
        return i;
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

    @Override // java.util.Collection
    public void clear() {
        this.modCount++;
        this.map.clear();
        this.size = 0;
    }

    @Override // java.util.Collection
    public boolean contains(Object obj) {
        return this.map.containsKey(obj);
    }

    @Override // org.apache.commons.collections.Bag, java.util.Collection
    public boolean containsAll(Collection collection) {
        return collection instanceof Bag ? containsAll((Bag) collection) : containsAll((Bag) new HashBag(collection));
    }

    public void doReadObject(Map map, ObjectInputStream objectInputStream) {
        this.map = map;
        int i = objectInputStream.readInt();
        for (int i2 = 0; i2 < i; i2++) {
            Object object = objectInputStream.readObject();
            int i4 = objectInputStream.readInt();
            map.put(object, new MutableInteger(i4));
            this.size += i4;
        }
    }

    public void doWriteObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.writeInt(this.map.size());
        for (Map.Entry entry : this.map.entrySet()) {
            objectOutputStream.writeObject(entry.getKey());
            objectOutputStream.writeInt(((MutableInteger) entry.getValue()).value);
        }
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
        for (Object obj2 : this.map.keySet()) {
            if (bag.getCount(obj2) != getCount(obj2)) {
                return false;
            }
        }
        return true;
    }

    @Override // org.apache.commons.collections.Bag
    public int getCount(Object obj) {
        MutableInteger mutableInteger = (MutableInteger) this.map.get(obj);
        if (mutableInteger != null) {
            return mutableInteger.value;
        }
        return 0;
    }

    public Map getMap() {
        return this.map;
    }

    @Override // java.util.Collection
    public int hashCode() {
        int iHashCode = 0;
        for (Map.Entry entry : this.map.entrySet()) {
            Object key = entry.getKey();
            iHashCode += ((MutableInteger) entry.getValue()).value ^ (key == null ? 0 : key.hashCode());
        }
        return iHashCode;
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    @Override // org.apache.commons.collections.Bag, java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return new BagIterator(this);
    }

    @Override // org.apache.commons.collections.Bag, java.util.Collection
    public boolean remove(Object obj) {
        MutableInteger mutableInteger = (MutableInteger) this.map.get(obj);
        if (mutableInteger == null) {
            return false;
        }
        this.modCount++;
        this.map.remove(obj);
        this.size -= mutableInteger.value;
        return true;
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
        return collection instanceof Bag ? retainAll((Bag) collection) : retainAll((Bag) new HashBag(collection));
    }

    @Override // org.apache.commons.collections.Bag, java.util.Collection
    public int size() {
        return this.size;
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        Object[] objArr = new Object[size()];
        int i = 0;
        for (Object obj : this.map.keySet()) {
            int count = getCount(obj);
            while (count > 0) {
                objArr[i] = obj;
                count--;
                i++;
            }
        }
        return objArr;
    }

    public String toString() {
        if (size() == 0) {
            return XMPConst.ARRAY_ITEM_NAME;
        }
        StringBuffer stringBuffer = new StringBuffer("[");
        Iterator it = uniqueSet().iterator();
        while (it.hasNext()) {
            Object next = it.next();
            stringBuffer.append(getCount(next));
            stringBuffer.append(':');
            stringBuffer.append(next);
            if (it.hasNext()) {
                stringBuffer.append(',');
            }
        }
        stringBuffer.append(PropertyUtils.INDEXED_DELIM2);
        return stringBuffer.toString();
    }

    @Override // org.apache.commons.collections.Bag
    public Set uniqueSet() {
        if (this.uniqueSet == null) {
            this.uniqueSet = UnmodifiableSet.decorate(this.map.keySet());
        }
        return this.uniqueSet;
    }

    public AbstractMapBag(Map map) {
        this.map = map;
    }

    @Override // org.apache.commons.collections.Bag
    public boolean add(Object obj, int i) {
        this.modCount++;
        if (i > 0) {
            MutableInteger mutableInteger = (MutableInteger) this.map.get(obj);
            this.size += i;
            if (mutableInteger == null) {
                this.map.put(obj, new MutableInteger(i));
                return true;
            }
            mutableInteger.value += i;
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

    public boolean retainAll(Bag bag) {
        HashBag hashBag = new HashBag();
        for (Object obj : uniqueSet()) {
            int count = getCount(obj);
            int count2 = bag.getCount(obj);
            if (1 <= count2 && count2 <= count) {
                hashBag.add(obj, count - count2);
            } else {
                hashBag.add(obj, count);
            }
        }
        if (hashBag.isEmpty()) {
            return false;
        }
        return removeAll(hashBag);
    }

    @Override // org.apache.commons.collections.Bag
    public boolean remove(Object obj, int i) {
        MutableInteger mutableInteger = (MutableInteger) this.map.get(obj);
        if (mutableInteger == null || i <= 0) {
            return false;
        }
        this.modCount++;
        int i2 = mutableInteger.value;
        if (i < i2) {
            mutableInteger.value = i2 - i;
            this.size -= i;
        } else {
            this.map.remove(obj);
            this.size -= mutableInteger.value;
        }
        return true;
    }

    @Override // java.util.Collection
    public Object[] toArray(Object[] objArr) {
        int size = size();
        if (objArr.length < size) {
            objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), size);
        }
        int i = 0;
        for (Object obj : this.map.keySet()) {
            int count = getCount(obj);
            while (count > 0) {
                objArr[i] = obj;
                count--;
                i++;
            }
        }
        if (objArr.length > size) {
            objArr[size] = null;
        }
        return objArr;
    }
}
