package org.apache.commons.collections.map;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import org.apache.commons.collections.MapIterator;
import org.apache.commons.collections.keyvalue.DefaultMapEntry;
import org.apache.commons.collections.map.AbstractHashedMap;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public abstract class AbstractReferenceMap extends AbstractHashedMap {
    public static final int HARD = 0;
    public static final int SOFT = 1;
    public static final int WEAK = 2;
    protected int keyType;
    protected boolean purgeValues;
    private transient ReferenceQueue queue;
    protected int valueType;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ReferenceEntry extends AbstractHashedMap.HashEntry {
        protected final AbstractReferenceMap parent;

        public ReferenceEntry(AbstractReferenceMap abstractReferenceMap, AbstractHashedMap.HashEntry hashEntry, int i, Object obj, Object obj2) {
            super(hashEntry, i, null, null);
            this.parent = abstractReferenceMap;
            this.key = toReference(abstractReferenceMap.keyType, obj, i);
            this.value = toReference(abstractReferenceMap.valueType, obj2, i);
        }

        @Override // org.apache.commons.collections.map.AbstractHashedMap.HashEntry, java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            return key != null && value != null && this.parent.isEqualKey(key, this.key) && this.parent.isEqualValue(value, getValue());
        }

        @Override // org.apache.commons.collections.map.AbstractHashedMap.HashEntry, java.util.Map.Entry, org.apache.commons.collections.KeyValue
        public Object getKey() {
            return this.parent.keyType > 0 ? ((Reference) this.key).get() : this.key;
        }

        @Override // org.apache.commons.collections.map.AbstractHashedMap.HashEntry, java.util.Map.Entry, org.apache.commons.collections.KeyValue
        public Object getValue() {
            return this.parent.valueType > 0 ? ((Reference) this.value).get() : this.value;
        }

        @Override // org.apache.commons.collections.map.AbstractHashedMap.HashEntry, java.util.Map.Entry
        public int hashCode() {
            return this.parent.hashEntry(getKey(), getValue());
        }

        public ReferenceEntry next() {
            return (ReferenceEntry) this.next;
        }

        public boolean purge(Reference reference) {
            AbstractReferenceMap abstractReferenceMap = this.parent;
            int i = abstractReferenceMap.keyType;
            boolean z = (i > 0 && this.key == reference) || (abstractReferenceMap.valueType > 0 && this.value == reference);
            if (z) {
                if (i > 0) {
                    ((Reference) this.key).clear();
                }
                AbstractReferenceMap abstractReferenceMap2 = this.parent;
                if (abstractReferenceMap2.valueType > 0) {
                    ((Reference) this.value).clear();
                    return z;
                }
                if (abstractReferenceMap2.purgeValues) {
                    this.value = null;
                }
            }
            return z;
        }

        @Override // org.apache.commons.collections.map.AbstractHashedMap.HashEntry, java.util.Map.Entry
        public Object setValue(Object obj) {
            Object value = getValue();
            if (this.parent.valueType > 0) {
                ((Reference) this.value).clear();
            }
            this.value = toReference(this.parent.valueType, obj, this.hashCode);
            return value;
        }

        public Object toReference(int i, Object obj, int i2) {
            if (i == 0) {
                return obj;
            }
            if (i == 1) {
                return new SoftRef(i2, obj, this.parent.queue);
            }
            if (i == 2) {
                return new WeakRef(i2, obj, this.parent.queue);
            }
            throw new Error();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ReferenceEntrySet extends AbstractHashedMap.EntrySet {
        public ReferenceEntrySet(AbstractHashedMap abstractHashedMap) {
            super(abstractHashedMap);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return toArray(new Object[0]);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public Object[] toArray(Object[] objArr) {
            ArrayList arrayList = new ArrayList();
            Iterator it = iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                arrayList.add(new DefaultMapEntry(entry.getKey(), entry.getValue()));
            }
            return arrayList.toArray(objArr);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ReferenceEntrySetIterator implements Iterator {
        Object currentKey;
        Object currentValue;
        ReferenceEntry entry;
        int expectedModCount;
        int index;
        Object nextKey;
        Object nextValue;
        final AbstractReferenceMap parent;
        ReferenceEntry previous;

        public ReferenceEntrySetIterator(AbstractReferenceMap abstractReferenceMap) {
            this.parent = abstractReferenceMap;
            this.index = abstractReferenceMap.size() != 0 ? abstractReferenceMap.data.length : 0;
            this.expectedModCount = abstractReferenceMap.modCount;
        }

        private void checkMod() {
            if (this.parent.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }

        private boolean nextNull() {
            return this.nextKey == null || this.nextValue == null;
        }

        public ReferenceEntry currentEntry() {
            checkMod();
            return this.previous;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            checkMod();
            while (nextNull()) {
                ReferenceEntry referenceEntry = this.entry;
                int i = this.index;
                while (referenceEntry == null && i > 0) {
                    i--;
                    referenceEntry = (ReferenceEntry) this.parent.data[i];
                }
                this.entry = referenceEntry;
                this.index = i;
                if (referenceEntry == null) {
                    this.currentKey = null;
                    this.currentValue = null;
                    return false;
                }
                this.nextKey = referenceEntry.getKey();
                this.nextValue = referenceEntry.getValue();
                if (nextNull()) {
                    this.entry = this.entry.next();
                }
            }
            return true;
        }

        @Override // java.util.Iterator
        public Object next() {
            return nextEntry();
        }

        public ReferenceEntry nextEntry() {
            checkMod();
            if (nextNull() && !hasNext()) {
                throw new NoSuchElementException();
            }
            ReferenceEntry referenceEntry = this.entry;
            this.previous = referenceEntry;
            this.entry = referenceEntry.next();
            this.currentKey = this.nextKey;
            this.currentValue = this.nextValue;
            this.nextKey = null;
            this.nextValue = null;
            return this.previous;
        }

        @Override // java.util.Iterator
        public void remove() {
            checkMod();
            if (this.previous == null) {
                throw new IllegalStateException();
            }
            this.parent.remove(this.currentKey);
            this.previous = null;
            this.currentKey = null;
            this.currentValue = null;
            this.expectedModCount = this.parent.modCount;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ReferenceKeySet extends AbstractHashedMap.KeySet {
        public ReferenceKeySet(AbstractHashedMap abstractHashedMap) {
            super(abstractHashedMap);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return toArray(new Object[0]);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public Object[] toArray(Object[] objArr) {
            ArrayList arrayList = new ArrayList(this.parent.size());
            Iterator it = iterator();
            while (it.hasNext()) {
                arrayList.add(it.next());
            }
            return arrayList.toArray(objArr);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ReferenceKeySetIterator extends ReferenceEntrySetIterator {
        public ReferenceKeySetIterator(AbstractReferenceMap abstractReferenceMap) {
            super(abstractReferenceMap);
        }

        @Override // org.apache.commons.collections.map.AbstractReferenceMap.ReferenceEntrySetIterator, java.util.Iterator
        public Object next() {
            return nextEntry().getKey();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ReferenceMapIterator extends ReferenceEntrySetIterator implements MapIterator {
        public ReferenceMapIterator(AbstractReferenceMap abstractReferenceMap) {
            super(abstractReferenceMap);
        }

        @Override // org.apache.commons.collections.MapIterator
        public Object getKey() {
            ReferenceEntry referenceEntryCurrentEntry = currentEntry();
            if (referenceEntryCurrentEntry != null) {
                return referenceEntryCurrentEntry.getKey();
            }
            throw new IllegalStateException("getKey() can only be called after next() and before remove()");
        }

        @Override // org.apache.commons.collections.MapIterator
        public Object getValue() {
            ReferenceEntry referenceEntryCurrentEntry = currentEntry();
            if (referenceEntryCurrentEntry != null) {
                return referenceEntryCurrentEntry.getValue();
            }
            throw new IllegalStateException("getValue() can only be called after next() and before remove()");
        }

        @Override // org.apache.commons.collections.map.AbstractReferenceMap.ReferenceEntrySetIterator, java.util.Iterator
        public Object next() {
            return nextEntry().getKey();
        }

        @Override // org.apache.commons.collections.MapIterator
        public Object setValue(Object obj) {
            ReferenceEntry referenceEntryCurrentEntry = currentEntry();
            if (referenceEntryCurrentEntry != null) {
                return referenceEntryCurrentEntry.setValue(obj);
            }
            throw new IllegalStateException("setValue() can only be called after next() and before remove()");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ReferenceValues extends AbstractHashedMap.Values {
        public ReferenceValues(AbstractHashedMap abstractHashedMap) {
            super(abstractHashedMap);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public Object[] toArray() {
            return toArray(new Object[0]);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public Object[] toArray(Object[] objArr) {
            ArrayList arrayList = new ArrayList(this.parent.size());
            Iterator it = iterator();
            while (it.hasNext()) {
                arrayList.add(it.next());
            }
            return arrayList.toArray(objArr);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ReferenceValuesIterator extends ReferenceEntrySetIterator {
        public ReferenceValuesIterator(AbstractReferenceMap abstractReferenceMap) {
            super(abstractReferenceMap);
        }

        @Override // org.apache.commons.collections.map.AbstractReferenceMap.ReferenceEntrySetIterator, java.util.Iterator
        public Object next() {
            return nextEntry().getValue();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class SoftRef extends SoftReference {
        private int hash;

        public SoftRef(int i, Object obj, ReferenceQueue referenceQueue) {
            super(obj, referenceQueue);
            this.hash = i;
        }

        public int hashCode() {
            return this.hash;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class WeakRef extends WeakReference {
        private int hash;

        public WeakRef(int i, Object obj, ReferenceQueue referenceQueue) {
            super(obj, referenceQueue);
            this.hash = i;
        }

        public int hashCode() {
            return this.hash;
        }
    }

    public AbstractReferenceMap() {
    }

    private static void verify(String str, int i) {
        if (i < 0 || i > 2) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(str);
            stringBuffer.append(" must be HARD, SOFT, WEAK.");
            throw new IllegalArgumentException(stringBuffer.toString());
        }
    }

    @Override // org.apache.commons.collections.map.AbstractHashedMap, java.util.AbstractMap, java.util.Map
    public void clear() {
        super.clear();
        while (this.queue.poll() != null) {
        }
    }

    @Override // org.apache.commons.collections.map.AbstractHashedMap, java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        purgeBeforeRead();
        AbstractHashedMap.HashEntry entry = getEntry(obj);
        return (entry == null || entry.getValue() == null) ? false : true;
    }

    @Override // org.apache.commons.collections.map.AbstractHashedMap, java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object obj) {
        purgeBeforeRead();
        if (obj == null) {
            return false;
        }
        return super.containsValue(obj);
    }

    @Override // org.apache.commons.collections.map.AbstractHashedMap
    public AbstractHashedMap.HashEntry createEntry(AbstractHashedMap.HashEntry hashEntry, int i, Object obj, Object obj2) {
        return new ReferenceEntry(this, hashEntry, i, obj, obj2);
    }

    @Override // org.apache.commons.collections.map.AbstractHashedMap
    public Iterator createEntrySetIterator() {
        return new ReferenceEntrySetIterator(this);
    }

    @Override // org.apache.commons.collections.map.AbstractHashedMap
    public Iterator createKeySetIterator() {
        return new ReferenceKeySetIterator(this);
    }

    @Override // org.apache.commons.collections.map.AbstractHashedMap
    public Iterator createValuesIterator() {
        return new ReferenceValuesIterator(this);
    }

    @Override // org.apache.commons.collections.map.AbstractHashedMap
    public void doReadObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        this.keyType = objectInputStream.readInt();
        this.valueType = objectInputStream.readInt();
        this.purgeValues = objectInputStream.readBoolean();
        this.loadFactor = objectInputStream.readFloat();
        int i = objectInputStream.readInt();
        init();
        this.data = new AbstractHashedMap.HashEntry[i];
        while (true) {
            Object object = objectInputStream.readObject();
            if (object == null) {
                this.threshold = calculateThreshold(this.data.length, this.loadFactor);
                return;
            }
            put(object, objectInputStream.readObject());
        }
    }

    @Override // org.apache.commons.collections.map.AbstractHashedMap
    public void doWriteObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(this.keyType);
        objectOutputStream.writeInt(this.valueType);
        objectOutputStream.writeBoolean(this.purgeValues);
        objectOutputStream.writeFloat(this.loadFactor);
        objectOutputStream.writeInt(this.data.length);
        MapIterator mapIterator = mapIterator();
        while (mapIterator.hasNext()) {
            objectOutputStream.writeObject(mapIterator.next());
            objectOutputStream.writeObject(mapIterator.getValue());
        }
        objectOutputStream.writeObject(null);
    }

    @Override // org.apache.commons.collections.map.AbstractHashedMap, java.util.AbstractMap, java.util.Map
    public Set entrySet() {
        if (this.entrySet == null) {
            this.entrySet = new ReferenceEntrySet(this);
        }
        return this.entrySet;
    }

    @Override // org.apache.commons.collections.map.AbstractHashedMap, java.util.AbstractMap, java.util.Map
    public Object get(Object obj) {
        purgeBeforeRead();
        AbstractHashedMap.HashEntry entry = getEntry(obj);
        if (entry == null) {
            return null;
        }
        return entry.getValue();
    }

    @Override // org.apache.commons.collections.map.AbstractHashedMap
    public AbstractHashedMap.HashEntry getEntry(Object obj) {
        if (obj == null) {
            return null;
        }
        return super.getEntry(obj);
    }

    public int hashEntry(Object obj, Object obj2) {
        return (obj == null ? 0 : obj.hashCode()) ^ (obj2 != null ? obj2.hashCode() : 0);
    }

    @Override // org.apache.commons.collections.map.AbstractHashedMap
    public void init() {
        this.queue = new ReferenceQueue();
    }

    @Override // org.apache.commons.collections.map.AbstractHashedMap, java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        purgeBeforeRead();
        return super.isEmpty();
    }

    @Override // org.apache.commons.collections.map.AbstractHashedMap
    public boolean isEqualKey(Object obj, Object obj2) {
        if (this.keyType > 0) {
            obj2 = ((Reference) obj2).get();
        }
        return obj == obj2 || obj.equals(obj2);
    }

    @Override // org.apache.commons.collections.map.AbstractHashedMap, java.util.AbstractMap, java.util.Map
    public Set keySet() {
        if (this.keySet == null) {
            this.keySet = new ReferenceKeySet(this);
        }
        return this.keySet;
    }

    @Override // org.apache.commons.collections.map.AbstractHashedMap, org.apache.commons.collections.IterableMap
    public MapIterator mapIterator() {
        return new ReferenceMapIterator(this);
    }

    public void purge() {
        Reference referencePoll = this.queue.poll();
        while (referencePoll != null) {
            purge(referencePoll);
            referencePoll = this.queue.poll();
        }
    }

    public void purgeBeforeRead() {
        purge();
    }

    public void purgeBeforeWrite() {
        purge();
    }

    @Override // org.apache.commons.collections.map.AbstractHashedMap, java.util.AbstractMap, java.util.Map
    public Object put(Object obj, Object obj2) {
        if (obj == null) {
            throw new NullPointerException("null keys not allowed");
        }
        if (obj2 == null) {
            throw new NullPointerException("null values not allowed");
        }
        purgeBeforeWrite();
        return super.put(obj, obj2);
    }

    @Override // org.apache.commons.collections.map.AbstractHashedMap, java.util.AbstractMap, java.util.Map
    public Object remove(Object obj) {
        if (obj == null) {
            return null;
        }
        purgeBeforeWrite();
        return super.remove(obj);
    }

    @Override // org.apache.commons.collections.map.AbstractHashedMap, java.util.AbstractMap, java.util.Map
    public int size() {
        purgeBeforeRead();
        return super.size();
    }

    @Override // org.apache.commons.collections.map.AbstractHashedMap, java.util.AbstractMap, java.util.Map
    public Collection values() {
        if (this.values == null) {
            this.values = new ReferenceValues(this);
        }
        return this.values;
    }

    public AbstractReferenceMap(int i, int i2, int i4, float f, boolean z) {
        super(i4, f);
        verify("keyType", i);
        verify("valueType", i2);
        this.keyType = i;
        this.valueType = i2;
        this.purgeValues = z;
    }

    public void purge(Reference reference) {
        int iHashIndex = hashIndex(reference.hashCode(), this.data.length);
        AbstractHashedMap.HashEntry hashEntry = null;
        for (AbstractHashedMap.HashEntry hashEntry2 = this.data[iHashIndex]; hashEntry2 != null; hashEntry2 = hashEntry2.next) {
            if (((ReferenceEntry) hashEntry2).purge(reference)) {
                if (hashEntry == null) {
                    this.data[iHashIndex] = hashEntry2.next;
                } else {
                    hashEntry.next = hashEntry2.next;
                }
                this.size--;
                return;
            }
            hashEntry = hashEntry2;
        }
    }
}
