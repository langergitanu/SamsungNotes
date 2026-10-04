package org.apache.commons.collections4.bag;

import com.adobe.internal.xmp.XMPConst;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.set.UnmodifiableSet;
import p122b2.C4191n;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public abstract class AbstractMapBag<E> implements Bag<E> {
    private transient Map<E, MutableInteger> map;
    private transient int modCount;
    private int size;
    private transient Set<E> uniqueSet;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class BagIterator<E> implements Iterator<E> {
        private final Iterator<Map.Entry<E, MutableInteger>> entryIterator;
        private int itemCount;
        private final int mods;
        private final AbstractMapBag<E> parent;
        private Map.Entry<E, MutableInteger> current = null;
        private boolean canRemove = false;

        public BagIterator(AbstractMapBag<E> abstractMapBag) {
            this.parent = abstractMapBag;
            this.entryIterator = ((AbstractMapBag) abstractMapBag).map.entrySet().iterator();
            this.mods = ((AbstractMapBag) abstractMapBag).modCount;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.itemCount > 0 || this.entryIterator.hasNext();
        }

        @Override // java.util.Iterator
        public E next() {
            if (((AbstractMapBag) this.parent).modCount != this.mods) {
                throw new ConcurrentModificationException();
            }
            if (this.itemCount == 0) {
                Map.Entry<E, MutableInteger> next = this.entryIterator.next();
                this.current = next;
                this.itemCount = next.getValue().value;
            }
            this.canRemove = true;
            this.itemCount--;
            return this.current.getKey();
        }

        @Override // java.util.Iterator
        public void remove() {
            if (((AbstractMapBag) this.parent).modCount != this.mods) {
                throw new ConcurrentModificationException();
            }
            if (!this.canRemove) {
                throw new IllegalStateException();
            }
            MutableInteger value = this.current.getValue();
            int i = value.value;
            if (i > 1) {
                value.value = i - 1;
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

    @Override // org.apache.commons.collections4.Bag, java.util.Collection
    public boolean add(E e) {
        return add(e, 1);
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends E> collection) {
        Iterator<? extends E> it = collection.iterator();
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

    public boolean containsAll(Bag<?> bag) {
        for (Object obj : bag.uniqueSet()) {
            if (getCount(obj) < bag.getCount(obj)) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void doReadObject(Map<E, MutableInteger> map, ObjectInputStream objectInputStream) {
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
        for (Map.Entry<E, MutableInteger> entry : this.map.entrySet()) {
            objectOutputStream.writeObject(entry.getKey());
            objectOutputStream.writeInt(entry.getValue().value);
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
        for (E e : this.map.keySet()) {
            if (bag.getCount(e) != getCount(e)) {
                return false;
            }
        }
        return true;
    }

    @Override // org.apache.commons.collections4.Bag
    public int getCount(Object obj) {
        MutableInteger mutableInteger = this.map.get(obj);
        if (mutableInteger != null) {
            return mutableInteger.value;
        }
        return 0;
    }

    public Map<E, MutableInteger> getMap() {
        return this.map;
    }

    @Override // java.util.Collection
    public int hashCode() {
        int iHashCode = 0;
        for (Map.Entry<E, MutableInteger> entry : this.map.entrySet()) {
            E key = entry.getKey();
            iHashCode += entry.getValue().value ^ (key == null ? 0 : key.hashCode());
        }
        return iHashCode;
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    @Override // org.apache.commons.collections4.Bag, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        return new BagIterator(this);
    }

    @Override // org.apache.commons.collections4.Bag, java.util.Collection
    public boolean remove(Object obj) {
        MutableInteger mutableInteger = this.map.get(obj);
        if (mutableInteger == null) {
            return false;
        }
        this.modCount++;
        this.map.remove(obj);
        this.size -= mutableInteger.value;
        return true;
    }

    @Override // org.apache.commons.collections4.Bag, java.util.Collection
    public boolean removeAll(Collection<?> collection) {
        if (collection == null) {
            return false;
        }
        Iterator<?> it = collection.iterator();
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

    public boolean retainAll(Bag<?> bag) {
        HashBag hashBag = new HashBag();
        for (E e : uniqueSet()) {
            int count = getCount(e);
            int count2 = bag.getCount(e);
            if (1 > count2 || count2 > count) {
                hashBag.add(e, count);
            } else {
                hashBag.add(e, count - count2);
            }
        }
        if (hashBag.isEmpty()) {
            return false;
        }
        return removeAll(hashBag);
    }

    @Override // org.apache.commons.collections4.Bag, java.util.Collection
    public int size() {
        return this.size;
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        Object[] objArr = new Object[size()];
        int i = 0;
        for (E e : this.map.keySet()) {
            int count = getCount(e);
            while (count > 0) {
                objArr[i] = e;
                count--;
                i++;
            }
        }
        return objArr;
    }

    public String toString() {
        if (isEmpty()) {
            return XMPConst.ARRAY_ITEM_NAME;
        }
        StringBuilder sb = new StringBuilder("[");
        Iterator<E> it = uniqueSet().iterator();
        while (it.hasNext()) {
            E next = it.next();
            sb.append(getCount(next));
            sb.append(":");
            sb.append(next);
            if (it.hasNext()) {
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    @Override // org.apache.commons.collections4.Bag
    public Set<E> uniqueSet() {
        if (this.uniqueSet == null) {
            this.uniqueSet = UnmodifiableSet.unmodifiableSet(this.map.keySet());
        }
        return this.uniqueSet;
    }

    public AbstractMapBag(Map<E, MutableInteger> map) {
        Objects.requireNonNull(map, "map");
        this.map = map;
    }

    @Override // org.apache.commons.collections4.Bag
    public boolean add(E e, int i) {
        this.modCount++;
        if (i <= 0) {
            return false;
        }
        MutableInteger mutableInteger = this.map.get(e);
        this.size += i;
        if (mutableInteger == null) {
            this.map.put(e, new MutableInteger(i));
            return true;
        }
        mutableInteger.value += i;
        return false;
    }

    @Override // org.apache.commons.collections4.Bag, java.util.Collection
    public boolean containsAll(Collection<?> collection) {
        if (collection instanceof Bag) {
            return containsAll((Bag<?>) collection);
        }
        return containsAll((Bag<?>) new HashBag((Collection) collection));
    }

    public AbstractMapBag(Map<E, MutableInteger> map, Iterable<? extends E> iterable) {
        this(map);
        iterable.forEach(new C4191n(this, 23));
    }

    @Override // org.apache.commons.collections4.Bag
    public boolean remove(Object obj, int i) {
        MutableInteger mutableInteger = this.map.get(obj);
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
    public <T> T[] toArray(T[] tArr) {
        int size = size();
        if (tArr.length < size) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), size));
        }
        int i = 0;
        for (E e : this.map.keySet()) {
            int count = getCount(e);
            while (count > 0) {
                tArr[i] = e;
                count--;
                i++;
            }
        }
        while (i < tArr.length) {
            tArr[i] = null;
            i++;
        }
        return tArr;
    }

    @Override // org.apache.commons.collections4.Bag, java.util.Collection
    public boolean retainAll(Collection<?> collection) {
        if (collection instanceof Bag) {
            return retainAll((Bag<?>) collection);
        }
        return retainAll((Bag<?>) new HashBag((Collection) collection));
    }
}
