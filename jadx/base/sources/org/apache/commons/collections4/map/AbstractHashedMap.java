package org.apache.commons.collections4.map;

import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import org.apache.commons.collections4.IterableMap;
import org.apache.commons.collections4.KeyValue;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.iterators.EmptyIterator;
import org.apache.commons.collections4.iterators.EmptyMapIterator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class AbstractHashedMap<K, V> extends AbstractMap<K, V> implements IterableMap<K, V> {
    protected static final int DEFAULT_CAPACITY = 16;
    protected static final float DEFAULT_LOAD_FACTOR = 0.75f;
    protected static final int DEFAULT_THRESHOLD = 12;
    protected static final String GETKEY_INVALID = "getKey() can only be called after next() and before remove()";
    protected static final String GETVALUE_INVALID = "getValue() can only be called after next() and before remove()";
    protected static final int MAXIMUM_CAPACITY = 1073741824;
    protected static final String NO_NEXT_ENTRY = "No next() entry in the iteration";
    protected static final String NO_PREVIOUS_ENTRY = "No previous() entry in the iteration";
    protected static final Object NULL = new Object();
    protected static final String REMOVE_INVALID = "remove() can only be called once after next()";
    protected static final String SETVALUE_INVALID = "setValue() can only be called after next() and before remove()";
    transient HashEntry<K, V>[] data;
    transient EntrySet<K, V> entrySet;
    transient KeySet<K> keySet;
    transient float loadFactor;
    transient int modCount;
    transient int size;
    transient int threshold;
    transient Values<V> values;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class EntrySet<K, V> extends AbstractSet<Map.Entry<K, V>> {
        private final AbstractHashedMap<K, V> parent;

        public EntrySet(AbstractHashedMap<K, V> abstractHashedMap) {
            this.parent = abstractHashedMap;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            this.parent.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                HashEntry<K, V> entry2 = this.parent.getEntry(entry.getKey());
                if (entry2 != null && entry2.equals(entry)) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return this.parent.createEntrySetIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (!(obj instanceof Map.Entry) || !contains(obj)) {
                return false;
            }
            this.parent.remove(((Map.Entry) obj).getKey());
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.parent.size();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class EntrySetIterator<K, V> extends HashIterator<K, V> implements Iterator<Map.Entry<K, V>> {
        public EntrySetIterator(AbstractHashedMap<K, V> abstractHashedMap) {
            super(abstractHashedMap);
        }

        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            return super.nextEntry();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class HashEntry<K, V> implements Map.Entry<K, V>, KeyValue<K, V> {
        protected int hashCode;
        protected Object key;
        protected HashEntry<K, V> next;
        protected Object value;

        public HashEntry(HashEntry<K, V> hashEntry, int i, Object obj, V v) {
            this.next = hashEntry;
            this.hashCode = i;
            this.key = obj;
            this.value = v;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return Objects.equals(getKey(), entry.getKey()) && Objects.equals(getValue(), entry.getValue());
        }

        @Override // java.util.Map.Entry, org.apache.commons.collections4.KeyValue
        public K getKey() {
            K k = (K) this.key;
            if (k == AbstractHashedMap.NULL) {
                return null;
            }
            return k;
        }

        @Override // java.util.Map.Entry, org.apache.commons.collections4.KeyValue
        public V getValue() {
            return (V) this.value;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            return (getKey() == null ? 0 : getKey().hashCode()) ^ (getValue() != null ? getValue().hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            V v4 = (V) this.value;
            this.value = v;
            return v4;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(getKey());
            sb.append('=');
            sb.append(getValue());
            return sb.toString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class HashIterator<K, V> {
        private int expectedModCount;
        private int hashIndex;
        private HashEntry<K, V> last;
        private HashEntry<K, V> next;
        private final AbstractHashedMap<K, V> parent;

        public HashIterator(AbstractHashedMap<K, V> abstractHashedMap) {
            this.parent = abstractHashedMap;
            HashEntry<K, V>[] hashEntryArr = abstractHashedMap.data;
            int length = hashEntryArr.length;
            HashEntry<K, V> hashEntry = null;
            while (length > 0 && hashEntry == null) {
                length--;
                hashEntry = hashEntryArr[length];
            }
            this.next = hashEntry;
            this.hashIndex = length;
            this.expectedModCount = abstractHashedMap.modCount;
        }

        public HashEntry<K, V> currentEntry() {
            return this.last;
        }

        public boolean hasNext() {
            return this.next != null;
        }

        public HashEntry<K, V> nextEntry() {
            AbstractHashedMap<K, V> abstractHashedMap = this.parent;
            if (abstractHashedMap.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
            HashEntry<K, V> hashEntry = this.next;
            if (hashEntry == null) {
                throw new NoSuchElementException(AbstractHashedMap.NO_NEXT_ENTRY);
            }
            HashEntry<K, V>[] hashEntryArr = abstractHashedMap.data;
            int i = this.hashIndex;
            HashEntry<K, V> hashEntry2 = hashEntry.next;
            while (hashEntry2 == null && i > 0) {
                i--;
                hashEntry2 = hashEntryArr[i];
            }
            this.next = hashEntry2;
            this.hashIndex = i;
            this.last = hashEntry;
            return hashEntry;
        }

        public void remove() {
            HashEntry<K, V> hashEntry = this.last;
            if (hashEntry == null) {
                throw new IllegalStateException(AbstractHashedMap.REMOVE_INVALID);
            }
            AbstractHashedMap<K, V> abstractHashedMap = this.parent;
            if (abstractHashedMap.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
            abstractHashedMap.remove(hashEntry.getKey());
            this.last = null;
            this.expectedModCount = this.parent.modCount;
        }

        public String toString() {
            if (this.last == null) {
                return "Iterator[]";
            }
            return "Iterator[" + this.last.getKey() + MarketingConstants.REFERRER_DELIMITER_U003D + this.last.getValue() + "]";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class HashMapIterator<K, V> extends HashIterator<K, V> implements MapIterator<K, V> {
        public HashMapIterator(AbstractHashedMap<K, V> abstractHashedMap) {
            super(abstractHashedMap);
        }

        @Override // org.apache.commons.collections4.MapIterator
        public K getKey() {
            HashEntry<K, V> hashEntryCurrentEntry = currentEntry();
            if (hashEntryCurrentEntry != null) {
                return hashEntryCurrentEntry.getKey();
            }
            throw new IllegalStateException(AbstractHashedMap.GETKEY_INVALID);
        }

        @Override // org.apache.commons.collections4.MapIterator
        public V getValue() {
            HashEntry<K, V> hashEntryCurrentEntry = currentEntry();
            if (hashEntryCurrentEntry != null) {
                return hashEntryCurrentEntry.getValue();
            }
            throw new IllegalStateException(AbstractHashedMap.GETVALUE_INVALID);
        }

        @Override // org.apache.commons.collections4.MapIterator, java.util.Iterator
        public K next() {
            return super.nextEntry().getKey();
        }

        @Override // org.apache.commons.collections4.MapIterator
        public V setValue(V v) {
            HashEntry<K, V> hashEntryCurrentEntry = currentEntry();
            if (hashEntryCurrentEntry != null) {
                return hashEntryCurrentEntry.setValue(v);
            }
            throw new IllegalStateException(AbstractHashedMap.SETVALUE_INVALID);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class KeySet<K> extends AbstractSet<K> {
        private final AbstractHashedMap<K, ?> parent;

        public KeySet(AbstractHashedMap<K, ?> abstractHashedMap) {
            this.parent = abstractHashedMap;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            this.parent.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return this.parent.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return this.parent.createKeySetIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            boolean zContainsKey = this.parent.containsKey(obj);
            this.parent.remove(obj);
            return zContainsKey;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.parent.size();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class KeySetIterator<K> extends HashIterator<K, Object> implements Iterator<K> {
        public KeySetIterator(AbstractHashedMap<K, ?> abstractHashedMap) {
            super(abstractHashedMap);
        }

        @Override // java.util.Iterator
        public K next() {
            return super.nextEntry().getKey();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Values<V> extends AbstractCollection<V> {
        private final AbstractHashedMap<?, V> parent;

        public Values(AbstractHashedMap<?, V> abstractHashedMap) {
            this.parent = abstractHashedMap;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            this.parent.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return this.parent.containsValue(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return this.parent.createValuesIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return this.parent.size();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ValuesIterator<V> extends HashIterator<Object, V> implements Iterator<V> {
        public ValuesIterator(AbstractHashedMap<?, V> abstractHashedMap) {
            super(abstractHashedMap);
        }

        @Override // java.util.Iterator
        public V next() {
            return super.nextEntry().getValue();
        }
    }

    public AbstractHashedMap() {
    }

    public void addEntry(HashEntry<K, V> hashEntry, int i) {
        this.data[i] = hashEntry;
    }

    public void addMapping(int i, int i2, K k, V v) {
        this.modCount++;
        addEntry(createEntry(this.data[i], i2, k, v), i);
        this.size++;
        checkCapacity();
    }

    public int calculateNewCapacity(int i) {
        if (i > 1073741824) {
            return 1073741824;
        }
        int i2 = 1;
        while (i2 < i) {
            i2 <<= 1;
        }
        if (i2 > 1073741824) {
            return 1073741824;
        }
        return i2;
    }

    public int calculateThreshold(int i, float f) {
        return (int) (i * f);
    }

    public void checkCapacity() {
        int length;
        if (this.size < this.threshold || (length = this.data.length * 2) > 1073741824) {
            return;
        }
        ensureCapacity(length);
    }

    @Override // java.util.AbstractMap, java.util.Map, org.apache.commons.collections4.Put
    public void clear() {
        this.modCount++;
        Arrays.fill(this.data, (Object) null);
        this.size = 0;
    }

    @Override // java.util.AbstractMap, java.util.Map, org.apache.commons.collections4.Get
    public boolean containsKey(Object obj) {
        Object objConvertKey = convertKey(obj);
        int iHash = hash(objConvertKey);
        HashEntry<K, V>[] hashEntryArr = this.data;
        for (HashEntry<K, V> hashEntry = hashEntryArr[hashIndex(iHash, hashEntryArr.length)]; hashEntry != null; hashEntry = hashEntry.next) {
            if (hashEntry.hashCode == iHash && isEqualKey(objConvertKey, hashEntry.key)) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map, org.apache.commons.collections4.Get
    public boolean containsValue(Object obj) {
        if (obj == null) {
            for (HashEntry<K, V> hashEntry : this.data) {
                for (; hashEntry != null; hashEntry = hashEntry.next) {
                    if (hashEntry.getValue() == null) {
                        return true;
                    }
                }
            }
        } else {
            for (HashEntry<K, V> hashEntry2 : this.data) {
                for (; hashEntry2 != null; hashEntry2 = hashEntry2.next) {
                    if (isEqualValue(obj, hashEntry2.getValue())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public Object convertKey(Object obj) {
        return obj == null ? NULL : obj;
    }

    public HashEntry<K, V> createEntry(HashEntry<K, V> hashEntry, int i, K k, V v) {
        return new HashEntry<>(hashEntry, i, convertKey(k), v);
    }

    public Iterator<Map.Entry<K, V>> createEntrySetIterator() {
        return isEmpty() ? EmptyIterator.emptyIterator() : new EntrySetIterator(this);
    }

    public Iterator<K> createKeySetIterator() {
        return isEmpty() ? EmptyIterator.emptyIterator() : new KeySetIterator(this);
    }

    public Iterator<V> createValuesIterator() {
        return isEmpty() ? EmptyIterator.emptyIterator() : new ValuesIterator(this);
    }

    public void destroyEntry(HashEntry<K, V> hashEntry) {
        hashEntry.next = null;
        hashEntry.key = null;
        hashEntry.value = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void doReadObject(ObjectInputStream objectInputStream) throws IOException {
        this.loadFactor = objectInputStream.readFloat();
        int i = objectInputStream.readInt();
        int i2 = objectInputStream.readInt();
        init();
        this.threshold = calculateThreshold(i, this.loadFactor);
        this.data = new HashEntry[i];
        for (int i4 = 0; i4 < i2; i4++) {
            put(objectInputStream.readObject(), objectInputStream.readObject());
        }
    }

    public void doWriteObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeFloat(this.loadFactor);
        objectOutputStream.writeInt(this.data.length);
        objectOutputStream.writeInt(this.size);
        MapIterator<K, V> mapIterator = mapIterator();
        while (mapIterator.hasNext()) {
            objectOutputStream.writeObject(mapIterator.next());
            objectOutputStream.writeObject(mapIterator.getValue());
        }
    }

    public void ensureCapacity(int i) {
        HashEntry<K, V>[] hashEntryArr = this.data;
        int length = hashEntryArr.length;
        if (i <= length) {
            return;
        }
        if (this.size == 0) {
            this.threshold = calculateThreshold(i, this.loadFactor);
            this.data = new HashEntry[i];
            return;
        }
        HashEntry<K, V>[] hashEntryArr2 = new HashEntry[i];
        this.modCount++;
        for (int i2 = length - 1; i2 >= 0; i2--) {
            HashEntry<K, V> hashEntry = hashEntryArr[i2];
            if (hashEntry != null) {
                hashEntryArr[i2] = null;
                while (true) {
                    HashEntry<K, V> hashEntry2 = hashEntry.next;
                    int iHashIndex = hashIndex(hashEntry.hashCode, i);
                    hashEntry.next = hashEntryArr2[iHashIndex];
                    hashEntryArr2[iHashIndex] = hashEntry;
                    if (hashEntry2 == null) {
                        break;
                    } else {
                        hashEntry = hashEntry2;
                    }
                }
            }
        }
        this.threshold = calculateThreshold(i, this.loadFactor);
        this.data = hashEntryArr2;
    }

    public int entryHashCode(HashEntry<K, V> hashEntry) {
        return hashEntry.hashCode;
    }

    public K entryKey(HashEntry<K, V> hashEntry) {
        return hashEntry.getKey();
    }

    public HashEntry<K, V> entryNext(HashEntry<K, V> hashEntry) {
        return hashEntry.next;
    }

    @Override // java.util.AbstractMap, java.util.Map, org.apache.commons.collections4.Get
    public Set<Map.Entry<K, V>> entrySet() {
        if (this.entrySet == null) {
            this.entrySet = new EntrySet<>(this);
        }
        return this.entrySet;
    }

    public V entryValue(HashEntry<K, V> hashEntry) {
        return hashEntry.getValue();
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
        if (map.size() != size()) {
            return false;
        }
        MapIterator<K, V> mapIterator = mapIterator();
        while (mapIterator.hasNext()) {
            try {
                K next = mapIterator.next();
                V value = mapIterator.getValue();
                if (value == null) {
                    if (map.get(next) != null || !map.containsKey(next)) {
                        return false;
                    }
                } else if (!value.equals(map.get(next))) {
                    return false;
                }
            } catch (ClassCastException | NullPointerException unused) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractMap, java.util.Map, org.apache.commons.collections4.Get
    public V get(Object obj) {
        Object objConvertKey = convertKey(obj);
        int iHash = hash(objConvertKey);
        HashEntry<K, V>[] hashEntryArr = this.data;
        for (HashEntry<K, V> hashEntry = hashEntryArr[hashIndex(iHash, hashEntryArr.length)]; hashEntry != null; hashEntry = hashEntry.next) {
            if (hashEntry.hashCode == iHash && isEqualKey(objConvertKey, hashEntry.key)) {
                return hashEntry.getValue();
            }
        }
        return null;
    }

    public HashEntry<K, V> getEntry(Object obj) {
        Object objConvertKey = convertKey(obj);
        int iHash = hash(objConvertKey);
        HashEntry<K, V>[] hashEntryArr = this.data;
        for (HashEntry<K, V> hashEntry = hashEntryArr[hashIndex(iHash, hashEntryArr.length)]; hashEntry != null; hashEntry = hashEntry.next) {
            if (hashEntry.hashCode == iHash && isEqualKey(objConvertKey, hashEntry.key)) {
                return hashEntry;
            }
        }
        return null;
    }

    public int hash(Object obj) {
        int iHashCode = obj.hashCode();
        int i = iHashCode + (~(iHashCode << 9));
        int i2 = i ^ (i >>> 14);
        int i4 = i2 + (i2 << 4);
        return i4 ^ (i4 >>> 10);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int hashCode() {
        Iterator<Map.Entry<K, V>> itCreateEntrySetIterator = createEntrySetIterator();
        int iHashCode = 0;
        while (itCreateEntrySetIterator.hasNext()) {
            iHashCode += itCreateEntrySetIterator.next().hashCode();
        }
        return iHashCode;
    }

    public int hashIndex(int i, int i2) {
        return i & (i2 - 1);
    }

    @Override // java.util.AbstractMap, java.util.Map, org.apache.commons.collections4.Get
    public boolean isEmpty() {
        return this.size == 0;
    }

    public boolean isEqualKey(Object obj, Object obj2) {
        return Objects.equals(obj, obj2);
    }

    public boolean isEqualValue(Object obj, Object obj2) {
        return Objects.equals(obj, obj2);
    }

    @Override // java.util.AbstractMap, java.util.Map, org.apache.commons.collections4.Get
    public Set<K> keySet() {
        if (this.keySet == null) {
            this.keySet = new KeySet<>(this);
        }
        return this.keySet;
    }

    @Override // org.apache.commons.collections4.IterableGet
    public MapIterator<K, V> mapIterator() {
        return this.size == 0 ? EmptyMapIterator.emptyMapIterator() : new HashMapIterator(this);
    }

    @Override // java.util.AbstractMap, java.util.Map, org.apache.commons.collections4.Put
    public V put(K k, V v) {
        Object objConvertKey = convertKey(k);
        int iHash = hash(objConvertKey);
        int iHashIndex = hashIndex(iHash, this.data.length);
        for (HashEntry<K, V> hashEntry = this.data[iHashIndex]; hashEntry != null; hashEntry = hashEntry.next) {
            if (hashEntry.hashCode == iHash && isEqualKey(objConvertKey, hashEntry.key)) {
                V value = hashEntry.getValue();
                updateEntry(hashEntry, v);
                return value;
            }
        }
        addMapping(iHashIndex, iHash, k, v);
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map, org.apache.commons.collections4.Put
    public void putAll(Map<? extends K, ? extends V> map) {
        if (map.size() == 0) {
            return;
        }
        ensureCapacity(calculateNewCapacity((int) (((this.size + r0) / this.loadFactor) + 1.0f)));
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.AbstractMap, java.util.Map, org.apache.commons.collections4.Get
    public V remove(Object obj) {
        Object objConvertKey = convertKey(obj);
        int iHash = hash(objConvertKey);
        int iHashIndex = hashIndex(iHash, this.data.length);
        HashEntry<K, V> hashEntry = null;
        for (HashEntry<K, V> hashEntry2 = this.data[iHashIndex]; hashEntry2 != null; hashEntry2 = hashEntry2.next) {
            if (hashEntry2.hashCode == iHash && isEqualKey(objConvertKey, hashEntry2.key)) {
                V value = hashEntry2.getValue();
                removeMapping(hashEntry2, iHashIndex, hashEntry);
                return value;
            }
            hashEntry = hashEntry2;
        }
        return null;
    }

    public void removeEntry(HashEntry<K, V> hashEntry, int i, HashEntry<K, V> hashEntry2) {
        if (hashEntry2 == null) {
            this.data[i] = hashEntry.next;
        } else {
            hashEntry2.next = hashEntry.next;
        }
    }

    public void removeMapping(HashEntry<K, V> hashEntry, int i, HashEntry<K, V> hashEntry2) {
        this.modCount++;
        removeEntry(hashEntry, i, hashEntry2);
        this.size--;
        destroyEntry(hashEntry);
    }

    public void reuseEntry(HashEntry<K, V> hashEntry, int i, int i2, K k, V v) {
        hashEntry.next = this.data[i];
        hashEntry.hashCode = i2;
        hashEntry.key = k;
        hashEntry.value = v;
    }

    @Override // java.util.AbstractMap, java.util.Map, org.apache.commons.collections4.Get
    public int size() {
        return this.size;
    }

    @Override // java.util.AbstractMap
    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(size() * 32);
        sb.append('{');
        MapIterator<K, V> mapIterator = mapIterator();
        boolean zHasNext = mapIterator.hasNext();
        while (zHasNext) {
            Object next = mapIterator.next();
            Object value = mapIterator.getValue();
            if (next == this) {
                next = "(this Map)";
            }
            sb.append(next);
            sb.append('=');
            if (value == this) {
                value = "(this Map)";
            }
            sb.append(value);
            zHasNext = mapIterator.hasNext();
            if (zHasNext) {
                sb.append(SQLKeyword.COMMA);
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public void updateEntry(HashEntry<K, V> hashEntry, V v) {
        hashEntry.setValue(v);
    }

    @Override // java.util.AbstractMap, java.util.Map, org.apache.commons.collections4.Get
    public Collection<V> values() {
        if (this.values == null) {
            this.values = new Values<>(this);
        }
        return this.values;
    }

    public AbstractHashedMap(int i) {
        this(i, 0.75f);
    }

    @Override // java.util.AbstractMap
    public AbstractHashedMap<K, V> clone() {
        try {
            AbstractHashedMap<K, V> abstractHashedMap = (AbstractHashedMap) super.clone();
            abstractHashedMap.data = new HashEntry[this.data.length];
            abstractHashedMap.entrySet = null;
            abstractHashedMap.keySet = null;
            abstractHashedMap.values = null;
            abstractHashedMap.modCount = 0;
            abstractHashedMap.size = 0;
            abstractHashedMap.init();
            abstractHashedMap.putAll(this);
            return abstractHashedMap;
        } catch (CloneNotSupportedException e) {
            throw new UnsupportedOperationException(e);
        }
    }

    public AbstractHashedMap(int i, float f) {
        if (i >= 0) {
            if (f > 0.0f && !Float.isNaN(f)) {
                this.loadFactor = f;
                int iCalculateNewCapacity = calculateNewCapacity(i);
                this.threshold = calculateThreshold(iCalculateNewCapacity, f);
                this.data = new HashEntry[iCalculateNewCapacity];
                init();
                return;
            }
            throw new IllegalArgumentException("Load factor must be greater than 0");
        }
        throw new IllegalArgumentException("Initial capacity must be a non negative number");
    }

    public AbstractHashedMap(int i, float f, int i2) {
        this.loadFactor = f;
        this.data = new HashEntry[i];
        this.threshold = i2;
        init();
    }

    public AbstractHashedMap(Map<? extends K, ? extends V> map) {
        this(Math.max(map.size() * 2, 16), 0.75f);
        putAll(map);
    }

    public void init() {
    }
}
