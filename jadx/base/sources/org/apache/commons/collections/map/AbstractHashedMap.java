package org.apache.commons.collections.map;

import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import org.apache.commons.collections.IterableMap;
import org.apache.commons.collections.KeyValue;
import org.apache.commons.collections.MapIterator;
import org.apache.commons.collections.iterators.EmptyIterator;
import org.apache.commons.collections.iterators.EmptyMapIterator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class AbstractHashedMap extends AbstractMap implements IterableMap {
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
    protected transient HashEntry[] data;
    protected transient EntrySet entrySet;
    protected transient KeySet keySet;
    protected transient float loadFactor;
    protected transient int modCount;
    protected transient int size;
    protected transient int threshold;
    protected transient Values values;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class EntrySet extends AbstractSet {
        protected final AbstractHashedMap parent;

        public EntrySet(AbstractHashedMap abstractHashedMap) {
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
                HashEntry entry2 = this.parent.getEntry(entry.getKey());
                if (entry2 != null && entry2.equals(entry)) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
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
    public static class EntrySetIterator extends HashIterator {
        public EntrySetIterator(AbstractHashedMap abstractHashedMap) {
            super(abstractHashedMap);
        }

        @Override // java.util.Iterator
        public Object next() {
            return super.nextEntry();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class HashEntry implements Map.Entry, KeyValue {
        protected int hashCode;
        protected Object key;
        protected HashEntry next;
        protected Object value;

        public HashEntry(HashEntry hashEntry, int i, Object obj, Object obj2) {
            this.next = hashEntry;
            this.hashCode = i;
            this.key = obj;
            this.value = obj2;
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
            if (getKey() != null ? getKey().equals(entry.getKey()) : entry.getKey() == null) {
                if (getValue() != null ? getValue().equals(entry.getValue()) : entry.getValue() == null) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.Map.Entry, org.apache.commons.collections.KeyValue
        public Object getKey() {
            Object obj = this.key;
            if (obj == AbstractHashedMap.NULL) {
                return null;
            }
            return obj;
        }

        @Override // java.util.Map.Entry, org.apache.commons.collections.KeyValue
        public Object getValue() {
            return this.value;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            return (getKey() == null ? 0 : getKey().hashCode()) ^ (getValue() != null ? getValue().hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            Object obj2 = this.value;
            this.value = obj;
            return obj2;
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(getKey());
            stringBuffer.append('=');
            stringBuffer.append(getValue());
            return stringBuffer.toString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class HashIterator implements Iterator {
        protected int expectedModCount;
        protected int hashIndex;
        protected HashEntry last;
        protected HashEntry next;
        protected final AbstractHashedMap parent;

        public HashIterator(AbstractHashedMap abstractHashedMap) {
            this.parent = abstractHashedMap;
            HashEntry[] hashEntryArr = abstractHashedMap.data;
            int length = hashEntryArr.length;
            HashEntry hashEntry = null;
            while (length > 0 && hashEntry == null) {
                length--;
                hashEntry = hashEntryArr[length];
            }
            this.next = hashEntry;
            this.hashIndex = length;
            this.expectedModCount = abstractHashedMap.modCount;
        }

        public HashEntry currentEntry() {
            return this.last;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.next != null;
        }

        public HashEntry nextEntry() {
            AbstractHashedMap abstractHashedMap = this.parent;
            if (abstractHashedMap.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
            HashEntry hashEntry = this.next;
            if (hashEntry == null) {
                throw new NoSuchElementException(AbstractHashedMap.NO_NEXT_ENTRY);
            }
            HashEntry[] hashEntryArr = abstractHashedMap.data;
            int i = this.hashIndex;
            HashEntry hashEntry2 = hashEntry.next;
            while (hashEntry2 == null && i > 0) {
                i--;
                hashEntry2 = hashEntryArr[i];
            }
            this.next = hashEntry2;
            this.hashIndex = i;
            this.last = hashEntry;
            return hashEntry;
        }

        @Override // java.util.Iterator
        public void remove() {
            HashEntry hashEntry = this.last;
            if (hashEntry == null) {
                throw new IllegalStateException(AbstractHashedMap.REMOVE_INVALID);
            }
            AbstractHashedMap abstractHashedMap = this.parent;
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
            StringBuffer stringBuffer = new StringBuffer("Iterator[");
            stringBuffer.append(this.last.getKey());
            stringBuffer.append(MarketingConstants.REFERRER_DELIMITER_U003D);
            stringBuffer.append(this.last.getValue());
            stringBuffer.append("]");
            return stringBuffer.toString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class HashMapIterator extends HashIterator implements MapIterator {
        public HashMapIterator(AbstractHashedMap abstractHashedMap) {
            super(abstractHashedMap);
        }

        @Override // org.apache.commons.collections.MapIterator
        public Object getKey() {
            HashEntry hashEntryCurrentEntry = currentEntry();
            if (hashEntryCurrentEntry != null) {
                return hashEntryCurrentEntry.getKey();
            }
            throw new IllegalStateException(AbstractHashedMap.GETKEY_INVALID);
        }

        @Override // org.apache.commons.collections.MapIterator
        public Object getValue() {
            HashEntry hashEntryCurrentEntry = currentEntry();
            if (hashEntryCurrentEntry != null) {
                return hashEntryCurrentEntry.getValue();
            }
            throw new IllegalStateException(AbstractHashedMap.GETVALUE_INVALID);
        }

        @Override // java.util.Iterator, org.apache.commons.collections.MapIterator
        public Object next() {
            return super.nextEntry().getKey();
        }

        @Override // org.apache.commons.collections.MapIterator
        public Object setValue(Object obj) {
            HashEntry hashEntryCurrentEntry = currentEntry();
            if (hashEntryCurrentEntry != null) {
                return hashEntryCurrentEntry.setValue(obj);
            }
            throw new IllegalStateException(AbstractHashedMap.SETVALUE_INVALID);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class KeySet extends AbstractSet {
        protected final AbstractHashedMap parent;

        public KeySet(AbstractHashedMap abstractHashedMap) {
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
        public Iterator iterator() {
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
    public static class KeySetIterator extends EntrySetIterator {
        public KeySetIterator(AbstractHashedMap abstractHashedMap) {
            super(abstractHashedMap);
        }

        @Override // org.apache.commons.collections.map.AbstractHashedMap.EntrySetIterator, java.util.Iterator
        public Object next() {
            return super.nextEntry().getKey();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Values extends AbstractCollection {
        protected final AbstractHashedMap parent;

        public Values(AbstractHashedMap abstractHashedMap) {
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
        public Iterator iterator() {
            return this.parent.createValuesIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return this.parent.size();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ValuesIterator extends HashIterator {
        public ValuesIterator(AbstractHashedMap abstractHashedMap) {
            super(abstractHashedMap);
        }

        @Override // java.util.Iterator
        public Object next() {
            return super.nextEntry().getValue();
        }
    }

    public AbstractHashedMap() {
    }

    public void addEntry(HashEntry hashEntry, int i) {
        this.data[i] = hashEntry;
    }

    public void addMapping(int i, int i2, Object obj, Object obj2) {
        this.modCount++;
        addEntry(createEntry(this.data[i], i2, obj, obj2), i);
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

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        this.modCount++;
        HashEntry[] hashEntryArr = this.data;
        for (int length = hashEntryArr.length - 1; length >= 0; length--) {
            hashEntryArr[length] = null;
        }
        this.size = 0;
    }

    @Override // java.util.AbstractMap
    public Object clone() {
        try {
            AbstractHashedMap abstractHashedMap = (AbstractHashedMap) super.clone();
            abstractHashedMap.data = new HashEntry[this.data.length];
            abstractHashedMap.entrySet = null;
            abstractHashedMap.keySet = null;
            abstractHashedMap.values = null;
            abstractHashedMap.modCount = 0;
            abstractHashedMap.size = 0;
            abstractHashedMap.init();
            abstractHashedMap.putAll(this);
            return abstractHashedMap;
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        Object objConvertKey = convertKey(obj);
        int iHash = hash(objConvertKey);
        HashEntry[] hashEntryArr = this.data;
        for (HashEntry hashEntry = hashEntryArr[hashIndex(iHash, hashEntryArr.length)]; hashEntry != null; hashEntry = hashEntry.next) {
            if (hashEntry.hashCode == iHash && isEqualKey(objConvertKey, hashEntry.key)) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object obj) {
        if (obj == null) {
            int length = this.data.length;
            for (int i = 0; i < length; i++) {
                for (HashEntry hashEntry = this.data[i]; hashEntry != null; hashEntry = hashEntry.next) {
                    if (hashEntry.getValue() == null) {
                        return true;
                    }
                }
            }
        } else {
            int length2 = this.data.length;
            for (int i2 = 0; i2 < length2; i2++) {
                for (HashEntry hashEntry2 = this.data[i2]; hashEntry2 != null; hashEntry2 = hashEntry2.next) {
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

    public HashEntry createEntry(HashEntry hashEntry, int i, Object obj, Object obj2) {
        return new HashEntry(hashEntry, i, obj, obj2);
    }

    public Iterator createEntrySetIterator() {
        return size() == 0 ? EmptyIterator.INSTANCE : new EntrySetIterator(this);
    }

    public Iterator createKeySetIterator() {
        return size() == 0 ? EmptyIterator.INSTANCE : new KeySetIterator(this);
    }

    public Iterator createValuesIterator() {
        return size() == 0 ? EmptyIterator.INSTANCE : new ValuesIterator(this);
    }

    public void destroyEntry(HashEntry hashEntry) {
        hashEntry.next = null;
        hashEntry.key = null;
        hashEntry.value = null;
    }

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
        MapIterator mapIterator = mapIterator();
        while (mapIterator.hasNext()) {
            objectOutputStream.writeObject(mapIterator.next());
            objectOutputStream.writeObject(mapIterator.getValue());
        }
    }

    public void ensureCapacity(int i) {
        HashEntry[] hashEntryArr = this.data;
        int length = hashEntryArr.length;
        if (i <= length) {
            return;
        }
        if (this.size == 0) {
            this.threshold = calculateThreshold(i, this.loadFactor);
            this.data = new HashEntry[i];
            return;
        }
        HashEntry[] hashEntryArr2 = new HashEntry[i];
        this.modCount++;
        for (int i2 = length - 1; i2 >= 0; i2--) {
            HashEntry hashEntry = hashEntryArr[i2];
            if (hashEntry != null) {
                hashEntryArr[i2] = null;
                while (true) {
                    HashEntry hashEntry2 = hashEntry.next;
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

    public int entryHashCode(HashEntry hashEntry) {
        return hashEntry.hashCode;
    }

    public Object entryKey(HashEntry hashEntry) {
        return hashEntry.key;
    }

    public HashEntry entryNext(HashEntry hashEntry) {
        return hashEntry.next;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set entrySet() {
        if (this.entrySet == null) {
            this.entrySet = new EntrySet(this);
        }
        return this.entrySet;
    }

    public Object entryValue(HashEntry hashEntry) {
        return hashEntry.value;
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
        MapIterator mapIterator = mapIterator();
        while (mapIterator.hasNext()) {
            try {
                Object next = mapIterator.next();
                Object value = mapIterator.getValue();
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

    @Override // java.util.AbstractMap, java.util.Map
    public Object get(Object obj) {
        Object objConvertKey = convertKey(obj);
        int iHash = hash(objConvertKey);
        HashEntry[] hashEntryArr = this.data;
        for (HashEntry hashEntry = hashEntryArr[hashIndex(iHash, hashEntryArr.length)]; hashEntry != null; hashEntry = hashEntry.next) {
            if (hashEntry.hashCode == iHash && isEqualKey(objConvertKey, hashEntry.key)) {
                return hashEntry.getValue();
            }
        }
        return null;
    }

    public HashEntry getEntry(Object obj) {
        Object objConvertKey = convertKey(obj);
        int iHash = hash(objConvertKey);
        HashEntry[] hashEntryArr = this.data;
        for (HashEntry hashEntry = hashEntryArr[hashIndex(iHash, hashEntryArr.length)]; hashEntry != null; hashEntry = hashEntry.next) {
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
        Iterator itCreateEntrySetIterator = createEntrySetIterator();
        int iHashCode = 0;
        while (itCreateEntrySetIterator.hasNext()) {
            iHashCode += itCreateEntrySetIterator.next().hashCode();
        }
        return iHashCode;
    }

    public int hashIndex(int i, int i2) {
        return i & (i2 - 1);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        return this.size == 0;
    }

    public boolean isEqualKey(Object obj, Object obj2) {
        return obj == obj2 || obj.equals(obj2);
    }

    public boolean isEqualValue(Object obj, Object obj2) {
        return obj == obj2 || obj.equals(obj2);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set keySet() {
        if (this.keySet == null) {
            this.keySet = new KeySet(this);
        }
        return this.keySet;
    }

    @Override // org.apache.commons.collections.IterableMap
    public MapIterator mapIterator() {
        return this.size == 0 ? EmptyMapIterator.INSTANCE : new HashMapIterator(this);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object put(Object obj, Object obj2) {
        Object objConvertKey = convertKey(obj);
        int iHash = hash(objConvertKey);
        int iHashIndex = hashIndex(iHash, this.data.length);
        for (HashEntry hashEntry = this.data[iHashIndex]; hashEntry != null; hashEntry = hashEntry.next) {
            if (hashEntry.hashCode == iHash && isEqualKey(objConvertKey, hashEntry.key)) {
                Object value = hashEntry.getValue();
                updateEntry(hashEntry, obj2);
                return value;
            }
        }
        addMapping(iHashIndex, iHash, objConvertKey, obj2);
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void putAll(Map map) {
        if (map.size() == 0) {
            return;
        }
        ensureCapacity(calculateNewCapacity((int) (((this.size + r0) / this.loadFactor) + 1.0f)));
        for (Map.Entry entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object remove(Object obj) {
        Object objConvertKey = convertKey(obj);
        int iHash = hash(objConvertKey);
        int iHashIndex = hashIndex(iHash, this.data.length);
        HashEntry hashEntry = null;
        for (HashEntry hashEntry2 = this.data[iHashIndex]; hashEntry2 != null; hashEntry2 = hashEntry2.next) {
            if (hashEntry2.hashCode == iHash && isEqualKey(objConvertKey, hashEntry2.key)) {
                Object value = hashEntry2.getValue();
                removeMapping(hashEntry2, iHashIndex, hashEntry);
                return value;
            }
            hashEntry = hashEntry2;
        }
        return null;
    }

    public void removeEntry(HashEntry hashEntry, int i, HashEntry hashEntry2) {
        if (hashEntry2 == null) {
            this.data[i] = hashEntry.next;
        } else {
            hashEntry2.next = hashEntry.next;
        }
    }

    public void removeMapping(HashEntry hashEntry, int i, HashEntry hashEntry2) {
        this.modCount++;
        removeEntry(hashEntry, i, hashEntry2);
        this.size--;
        destroyEntry(hashEntry);
    }

    public void reuseEntry(HashEntry hashEntry, int i, int i2, Object obj, Object obj2) {
        hashEntry.next = this.data[i];
        hashEntry.hashCode = i2;
        hashEntry.key = obj;
        hashEntry.value = obj2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.size;
    }

    @Override // java.util.AbstractMap
    public String toString() {
        if (size() == 0) {
            return "{}";
        }
        StringBuffer stringBuffer = new StringBuffer(size() * 32);
        stringBuffer.append('{');
        MapIterator mapIterator = mapIterator();
        boolean zHasNext = mapIterator.hasNext();
        while (zHasNext) {
            Object next = mapIterator.next();
            Object value = mapIterator.getValue();
            if (next == this) {
                next = "(this Map)";
            }
            stringBuffer.append(next);
            stringBuffer.append('=');
            if (value == this) {
                value = "(this Map)";
            }
            stringBuffer.append(value);
            zHasNext = mapIterator.hasNext();
            if (zHasNext) {
                stringBuffer.append(SQLKeyword.COMMA);
            }
        }
        stringBuffer.append('}');
        return stringBuffer.toString();
    }

    public void updateEntry(HashEntry hashEntry, Object obj) {
        hashEntry.setValue(obj);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection values() {
        if (this.values == null) {
            this.values = new Values(this);
        }
        return this.values;
    }

    public AbstractHashedMap(int i, float f, int i2) {
        this.loadFactor = f;
        this.data = new HashEntry[i];
        this.threshold = i2;
        init();
    }

    public AbstractHashedMap(int i) {
        this(i, 0.75f);
    }

    public AbstractHashedMap(int i, float f) {
        if (i >= 1) {
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
        throw new IllegalArgumentException("Initial capacity must be greater than 0");
    }

    public AbstractHashedMap(Map map) {
        this(Math.max(map.size() * 2, 16), 0.75f);
        putAll(map);
    }

    public void init() {
    }
}
