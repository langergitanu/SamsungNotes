package org.apache.commons.collections;

import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.AbstractCollection;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.collections.list.UnmodifiableList;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class SequencedHashMap implements Map, Cloneable, Externalizable {
    private static final int ENTRY = 2;
    private static final int KEY = 0;
    private static final int REMOVED_MASK = Integer.MIN_VALUE;
    private static final int VALUE = 1;
    private static final long serialVersionUID = 3380552487888102930L;
    private HashMap entries;
    private transient long modCount;
    private Entry sentinel;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Entry implements Map.Entry, KeyValue {
        private final Object key;
        Entry next = null;
        Entry prev = null;
        private Object value;

        public Entry(Object obj, Object obj2) {
            this.key = obj;
            this.value = obj2;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
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
            return this.key;
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
            StringBuffer stringBuffer = new StringBuffer("[");
            stringBuffer.append(getKey());
            stringBuffer.append(MarketingConstants.REFERRER_DELIMITER_U003D);
            stringBuffer.append(getValue());
            stringBuffer.append("]");
            return stringBuffer.toString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class OrderedIterator implements Iterator {
        private transient long expectedModCount;
        private Entry pos;
        private int returnType;

        public OrderedIterator(int i) {
            this.pos = SequencedHashMap.this.sentinel;
            this.expectedModCount = SequencedHashMap.this.modCount;
            this.returnType = Integer.MIN_VALUE | i;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.pos.next != SequencedHashMap.this.sentinel;
        }

        @Override // java.util.Iterator
        public Object next() {
            if (SequencedHashMap.this.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
            if (this.pos.next == SequencedHashMap.this.sentinel) {
                throw new NoSuchElementException();
            }
            int i = this.returnType & Integer.MAX_VALUE;
            this.returnType = i;
            Entry entry = this.pos.next;
            this.pos = entry;
            if (i == 0) {
                return entry.getKey();
            }
            if (i == 1) {
                return entry.getValue();
            }
            if (i == 2) {
                return entry;
            }
            StringBuffer stringBuffer = new StringBuffer("bad iterator type: ");
            stringBuffer.append(this.returnType);
            throw new Error(stringBuffer.toString());
        }

        @Override // java.util.Iterator
        public void remove() {
            if ((this.returnType & Integer.MIN_VALUE) != 0) {
                throw new IllegalStateException("remove() must follow next()");
            }
            if (SequencedHashMap.this.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
            SequencedHashMap.this.removeImpl(this.pos.getKey());
            this.expectedModCount++;
            this.returnType |= Integer.MIN_VALUE;
        }
    }

    public SequencedHashMap() {
        this.modCount = 0L;
        this.sentinel = createSentinel();
        this.entries = new HashMap();
    }

    private static final Entry createSentinel() {
        Entry entry = new Entry(null, null);
        entry.prev = entry;
        entry.next = entry;
        return entry;
    }

    private Map.Entry getEntry(int i) {
        Entry entry;
        Entry entry2 = this.sentinel;
        if (i < 0) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(i);
            stringBuffer.append(" < 0");
            throw new ArrayIndexOutOfBoundsException(stringBuffer.toString());
        }
        int i2 = -1;
        while (i2 < i - 1 && (entry = entry2.next) != this.sentinel) {
            i2++;
            entry2 = entry;
        }
        Entry entry3 = entry2.next;
        if (entry3 != this.sentinel) {
            return entry3;
        }
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append(i);
        stringBuffer2.append(" >= ");
        stringBuffer2.append(i2 + 1);
        throw new ArrayIndexOutOfBoundsException(stringBuffer2.toString());
    }

    private void insertEntry(Entry entry) {
        Entry entry2 = this.sentinel;
        entry.next = entry2;
        entry.prev = entry2.prev;
        entry2.prev.next = entry;
        entry2.prev = entry;
    }

    private void removeEntry(Entry entry) {
        Entry entry2 = entry.next;
        entry2.prev = entry.prev;
        entry.prev.next = entry2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Entry removeImpl(Object obj) {
        Entry entry = (Entry) this.entries.remove(obj);
        if (entry == null) {
            return null;
        }
        this.modCount++;
        removeEntry(entry);
        return entry;
    }

    @Override // java.util.Map
    public void clear() {
        this.modCount++;
        this.entries.clear();
        Entry entry = this.sentinel;
        entry.next = entry;
        entry.prev = entry;
    }

    public Object clone() {
        SequencedHashMap sequencedHashMap = (SequencedHashMap) super.clone();
        sequencedHashMap.sentinel = createSentinel();
        sequencedHashMap.entries = new HashMap();
        sequencedHashMap.putAll(this);
        return sequencedHashMap;
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return this.entries.containsKey(obj);
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        if (obj == null) {
            Entry entry = this.sentinel;
            do {
                entry = entry.next;
                if (entry == this.sentinel) {
                    return false;
                }
            } while (entry.getValue() != null);
            return true;
        }
        Entry entry2 = this.sentinel;
        do {
            entry2 = entry2.next;
            if (entry2 == this.sentinel) {
                return false;
            }
        } while (!obj.equals(entry2.getValue()));
        return true;
    }

    @Override // java.util.Map
    public Set entrySet() {
        return new AbstractSet() { // from class: org.apache.commons.collections.SequencedHashMap.3
            private Entry findEntry(Object obj) {
                if (obj == null || !(obj instanceof Map.Entry)) {
                    return null;
                }
                Map.Entry entry = (Map.Entry) obj;
                Entry entry2 = (Entry) SequencedHashMap.this.entries.get(entry.getKey());
                if (entry2 == null || !entry2.equals(entry)) {
                    return null;
                }
                return entry2;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public void clear() {
                SequencedHashMap.this.clear();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object obj) {
                return findEntry(obj) != null;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean isEmpty() {
                return SequencedHashMap.this.isEmpty();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator iterator() {
                return SequencedHashMap.this.new OrderedIterator(2);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object obj) {
                Entry entryFindEntry = findEntry(obj);
                return (entryFindEntry == null || SequencedHashMap.this.removeImpl(entryFindEntry.getKey()) == null) ? false : true;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return SequencedHashMap.this.size();
            }
        };
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj instanceof Map) {
            return entrySet().equals(((Map) obj).entrySet());
        }
        return false;
    }

    @Override // java.util.Map
    public Object get(Object obj) {
        Entry entry = (Entry) this.entries.get(obj);
        if (entry == null) {
            return null;
        }
        return entry.getValue();
    }

    public Map.Entry getFirst() {
        if (isEmpty()) {
            return null;
        }
        return this.sentinel.next;
    }

    public Object getFirstKey() {
        return this.sentinel.next.getKey();
    }

    public Object getFirstValue() {
        return this.sentinel.next.getValue();
    }

    public Map.Entry getLast() {
        if (isEmpty()) {
            return null;
        }
        return this.sentinel.prev;
    }

    public Object getLastKey() {
        return this.sentinel.prev.getKey();
    }

    public Object getLastValue() {
        return this.sentinel.prev.getValue();
    }

    public Object getValue(int i) {
        return getEntry(i).getValue();
    }

    @Override // java.util.Map
    public int hashCode() {
        return entrySet().hashCode();
    }

    public int indexOf(Object obj) {
        Entry entry = (Entry) this.entries.get(obj);
        if (entry == null) {
            return -1;
        }
        int i = 0;
        while (true) {
            entry = entry.prev;
            if (entry == this.sentinel) {
                return i;
            }
            i++;
        }
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        Entry entry = this.sentinel;
        return entry.next == entry;
    }

    public Iterator iterator() {
        return keySet().iterator();
    }

    @Override // java.util.Map
    public Set keySet() {
        return new AbstractSet() { // from class: org.apache.commons.collections.SequencedHashMap.1
            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public void clear() {
                SequencedHashMap.this.clear();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object obj) {
                return SequencedHashMap.this.containsKey(obj);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean isEmpty() {
                return SequencedHashMap.this.isEmpty();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator iterator() {
                return SequencedHashMap.this.new OrderedIterator(0);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object obj) {
                return SequencedHashMap.this.removeImpl(obj) != null;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return SequencedHashMap.this.size();
            }
        };
    }

    public int lastIndexOf(Object obj) {
        return indexOf(obj);
    }

    @Override // java.util.Map
    public Object put(Object obj, Object obj2) {
        Object value;
        this.modCount++;
        Entry entry = (Entry) this.entries.get(obj);
        if (entry != null) {
            removeEntry(entry);
            value = entry.setValue(obj2);
        } else {
            entry = new Entry(obj, obj2);
            this.entries.put(obj, entry);
            value = null;
        }
        insertEntry(entry);
        return value;
    }

    @Override // java.util.Map
    public void putAll(Map map) {
        for (Map.Entry entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    public void readExternal(ObjectInput objectInput) throws IOException {
        int i = objectInput.readInt();
        for (int i2 = 0; i2 < i; i2++) {
            put(objectInput.readObject(), objectInput.readObject());
        }
    }

    @Override // java.util.Map
    public Object remove(Object obj) {
        Entry entryRemoveImpl = removeImpl(obj);
        if (entryRemoveImpl == null) {
            return null;
        }
        return entryRemoveImpl.getValue();
    }

    public List sequence() {
        ArrayList arrayList = new ArrayList(size());
        Iterator it = keySet().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return UnmodifiableList.decorate(arrayList);
    }

    @Override // java.util.Map
    public int size() {
        return this.entries.size();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("[");
        Entry entry = this.sentinel;
        while (true) {
            entry = entry.next;
            if (entry == this.sentinel) {
                stringBuffer.append(PropertyUtils.INDEXED_DELIM2);
                return stringBuffer.toString();
            }
            stringBuffer.append(entry.getKey());
            stringBuffer.append('=');
            stringBuffer.append(entry.getValue());
            if (entry.next != this.sentinel) {
                stringBuffer.append(',');
            }
        }
    }

    @Override // java.util.Map
    public Collection values() {
        return new AbstractCollection() { // from class: org.apache.commons.collections.SequencedHashMap.2
            @Override // java.util.AbstractCollection, java.util.Collection
            public void clear() {
                SequencedHashMap.this.clear();
            }

            @Override // java.util.AbstractCollection, java.util.Collection
            public boolean contains(Object obj) {
                return SequencedHashMap.this.containsValue(obj);
            }

            @Override // java.util.AbstractCollection, java.util.Collection
            public boolean isEmpty() {
                return SequencedHashMap.this.isEmpty();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
            public Iterator iterator() {
                return SequencedHashMap.this.new OrderedIterator(1);
            }

            @Override // java.util.AbstractCollection, java.util.Collection
            public boolean remove(Object obj) {
                if (obj == null) {
                    Entry entry = SequencedHashMap.this.sentinel;
                    do {
                        entry = entry.next;
                        if (entry == SequencedHashMap.this.sentinel) {
                            return false;
                        }
                    } while (entry.getValue() != null);
                    SequencedHashMap.this.removeImpl(entry.getKey());
                    return true;
                }
                Entry entry2 = SequencedHashMap.this.sentinel;
                do {
                    entry2 = entry2.next;
                    if (entry2 == SequencedHashMap.this.sentinel) {
                        return false;
                    }
                } while (!obj.equals(entry2.getValue()));
                SequencedHashMap.this.removeImpl(entry2.getKey());
                return true;
            }

            @Override // java.util.AbstractCollection, java.util.Collection
            public int size() {
                return SequencedHashMap.this.size();
            }
        };
    }

    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeInt(size());
        Entry entry = this.sentinel;
        while (true) {
            entry = entry.next;
            if (entry == this.sentinel) {
                return;
            }
            objectOutput.writeObject(entry.getKey());
            objectOutput.writeObject(entry.getValue());
        }
    }

    public Object get(int i) {
        return getEntry(i).getKey();
    }

    public Object remove(int i) {
        return remove(get(i));
    }

    public SequencedHashMap(int i) {
        this.modCount = 0L;
        this.sentinel = createSentinel();
        this.entries = new HashMap(i);
    }

    public SequencedHashMap(int i, float f) {
        this.modCount = 0L;
        this.sentinel = createSentinel();
        this.entries = new HashMap(i, f);
    }

    public SequencedHashMap(Map map) {
        this();
        putAll(map);
    }
}
