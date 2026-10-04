package org.apache.poi.sun.misc;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class SoftCache extends AbstractMap implements Map {
    private Set entrySet;
    private Map hash;
    private ReferenceQueue queue;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class Entry implements Map.Entry {
        private Map.Entry ent;
        private Object value;

        public Entry(Map.Entry entry, Object obj) {
            this.ent = entry;
            this.value = obj;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return SoftCache.valEquals(this.ent.getKey(), entry.getKey()) && SoftCache.valEquals(this.value, entry.getValue());
        }

        @Override // java.util.Map.Entry
        public Object getKey() {
            return this.ent.getKey();
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            return this.value;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            Object key = getKey();
            int iHashCode = key == null ? 0 : key.hashCode();
            Object obj = this.value;
            return iHashCode ^ (obj != null ? obj.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            Map.Entry entry = this.ent;
            return entry.setValue(ValueCell.create(entry.getKey(), obj, SoftCache.this.queue));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class EntrySet extends AbstractSet {
        Set hashEntries;

        private EntrySet() {
            this.hashEntries = SoftCache.this.hash.entrySet();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return !iterator().hasNext();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return new Iterator() { // from class: org.apache.poi.sun.misc.SoftCache.EntrySet.1
                Iterator hashIterator;
                Entry next = null;

                {
                    this.hashIterator = EntrySet.this.hashEntries.iterator();
                }

                @Override // java.util.Iterator
                public boolean hasNext() {
                    Object obj;
                    while (this.hashIterator.hasNext()) {
                        Map.Entry entry = (Map.Entry) this.hashIterator.next();
                        ValueCell valueCell = (ValueCell) entry.getValue();
                        if (valueCell != null) {
                            obj = valueCell.get();
                            if (obj == null) {
                            }
                        } else {
                            obj = null;
                        }
                        this.next = SoftCache.this.new Entry(entry, obj);
                        return true;
                    }
                    return false;
                }

                @Override // java.util.Iterator
                public Object next() {
                    if (this.next == null && !hasNext()) {
                        throw new NoSuchElementException();
                    }
                    Entry entry = this.next;
                    this.next = null;
                    return entry;
                }

                @Override // java.util.Iterator
                public void remove() {
                    this.hashIterator.remove();
                }
            };
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            SoftCache.this.processQueue();
            if (obj instanceof Entry) {
                return this.hashEntries.remove(((Entry) obj).ent);
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            Iterator it = iterator();
            int i = 0;
            while (it.hasNext()) {
                i++;
                it.next();
            }
            return i;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ValueCell extends SoftReference {
        private static Object INVALID_KEY = new Object();
        private static int dropped;
        private Object key;

        private ValueCell(Object obj, Object obj2, ReferenceQueue referenceQueue) {
            super(obj2, referenceQueue);
            this.key = obj;
        }

        public static /* synthetic */ int access$210() {
            int i = dropped;
            dropped = i - 1;
            return i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static ValueCell create(Object obj, Object obj2, ReferenceQueue referenceQueue) {
            if (obj2 == null) {
                return null;
            }
            return new ValueCell(obj, obj2, referenceQueue);
        }

        private void drop() {
            super.clear();
            this.key = INVALID_KEY;
            dropped++;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean isValid() {
            return this.key != INVALID_KEY;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static Object strip(Object obj, boolean z) {
            if (obj == null) {
                return null;
            }
            ValueCell valueCell = (ValueCell) obj;
            T t = valueCell.get();
            if (z) {
                valueCell.drop();
            }
            return t;
        }
    }

    public SoftCache(int i, float f) {
        this.queue = new ReferenceQueue();
        this.entrySet = null;
        this.hash = new HashMap(i, f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processQueue() {
        while (true) {
            ValueCell valueCell = (ValueCell) this.queue.poll();
            if (valueCell == null) {
                return;
            }
            if (valueCell.isValid()) {
                this.hash.remove(valueCell.key);
            } else {
                ValueCell.access$210();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean valEquals(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        processQueue();
        this.hash.clear();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return ValueCell.strip(this.hash.get(obj), false) != null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set entrySet() {
        if (this.entrySet == null) {
            this.entrySet = new EntrySet();
        }
        return this.entrySet;
    }

    public Object fill(Object obj) {
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object get(Object obj) {
        processQueue();
        Object objFill = this.hash.get(obj);
        if (objFill != null || (objFill = fill(obj)) == null) {
            return ValueCell.strip(objFill, false);
        }
        this.hash.put(obj, ValueCell.create(obj, objFill, this.queue));
        return objFill;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        return entrySet().isEmpty();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object put(Object obj, Object obj2) {
        processQueue();
        return ValueCell.strip(this.hash.put(obj, ValueCell.create(obj, obj2, this.queue)), true);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object remove(Object obj) {
        processQueue();
        return ValueCell.strip(this.hash.remove(obj), true);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return entrySet().size();
    }

    public SoftCache(int i) {
        this.queue = new ReferenceQueue();
        this.entrySet = null;
        this.hash = new HashMap(i);
    }

    public SoftCache() {
        this.queue = new ReferenceQueue();
        this.entrySet = null;
        this.hash = new HashMap();
    }
}
