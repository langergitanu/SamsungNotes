package org.apache.commons.collections.map;

import java.util.AbstractCollection;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import org.apache.commons.collections.KeyValue;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class StaticBucketMap implements Map {
    private static final int DEFAULT_BUCKETS = 255;
    private Node[] buckets;
    private Lock[] locks;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class EntryIterator implements Iterator {
        private int bucket;
        private ArrayList current;
        private Map.Entry last;

        private EntryIterator() {
            this.current = new ArrayList();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.current.size() > 0) {
                return true;
            }
            while (this.bucket < StaticBucketMap.this.buckets.length) {
                synchronized (StaticBucketMap.this.locks[this.bucket]) {
                    try {
                        for (Node node = StaticBucketMap.this.buckets[this.bucket]; node != null; node = node.next) {
                            this.current.add(node);
                        }
                        this.bucket++;
                        if (this.current.size() > 0) {
                            return true;
                        }
                    } finally {
                    }
                }
            }
            return false;
        }

        @Override // java.util.Iterator
        public Object next() {
            return nextEntry();
        }

        public Map.Entry nextEntry() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Map.Entry entry = (Map.Entry) this.current.remove(r0.size() - 1);
            this.last = entry;
            return entry;
        }

        @Override // java.util.Iterator
        public void remove() {
            Map.Entry entry = this.last;
            if (entry == null) {
                throw new IllegalStateException();
            }
            StaticBucketMap.this.remove(entry.getKey());
            this.last = null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class EntrySet extends AbstractSet {
        private EntrySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            StaticBucketMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            int hash = StaticBucketMap.this.getHash(entry.getKey());
            synchronized (StaticBucketMap.this.locks[hash]) {
                try {
                    for (Node node = StaticBucketMap.this.buckets[hash]; node != null; node = node.next) {
                        if (node.equals(entry)) {
                            return true;
                        }
                    }
                    return false;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return new EntryIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            int hash = StaticBucketMap.this.getHash(entry.getKey());
            synchronized (StaticBucketMap.this.locks[hash]) {
                try {
                    for (Node node = StaticBucketMap.this.buckets[hash]; node != null; node = node.next) {
                        if (node.equals(entry)) {
                            StaticBucketMap.this.remove(node.getKey());
                            return true;
                        }
                    }
                    return false;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return StaticBucketMap.this.size();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class KeyIterator extends EntryIterator {
        private final /* synthetic */ StaticBucketMap this$0;

        private KeyIterator(StaticBucketMap staticBucketMap) {
            super();
            this.this$0 = staticBucketMap;
        }

        @Override // org.apache.commons.collections.map.StaticBucketMap.EntryIterator, java.util.Iterator
        public Object next() {
            return nextEntry().getKey();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class KeySet extends AbstractSet {
        private KeySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            StaticBucketMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return StaticBucketMap.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return new KeyIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            int hash = StaticBucketMap.this.getHash(obj);
            synchronized (StaticBucketMap.this.locks[hash]) {
                try {
                    for (Node node = StaticBucketMap.this.buckets[hash]; node != null; node = node.next) {
                        Object key = node.getKey();
                        if (key != obj && (key == null || !key.equals(obj))) {
                        }
                        StaticBucketMap.this.remove(key);
                        return true;
                    }
                    return false;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return StaticBucketMap.this.size();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Lock {
        public int size;

        private Lock() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Node implements Map.Entry, KeyValue {
        protected Object key;
        protected Node next;
        protected Object value;

        private Node() {
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
            Object obj2 = this.key;
            if (obj2 != null ? obj2.equals(entry.getKey()) : entry.getKey() == null) {
                Object obj3 = this.value;
                Object value = entry.getValue();
                if (obj3 != null ? obj3.equals(value) : value == null) {
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
            Object obj = this.key;
            int iHashCode = obj == null ? 0 : obj.hashCode();
            Object obj2 = this.value;
            return iHashCode ^ (obj2 != null ? obj2.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            Object obj2 = this.value;
            this.value = obj;
            return obj2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class ValueIterator extends EntryIterator {
        private final /* synthetic */ StaticBucketMap this$0;

        private ValueIterator(StaticBucketMap staticBucketMap) {
            super();
            this.this$0 = staticBucketMap;
        }

        @Override // org.apache.commons.collections.map.StaticBucketMap.EntryIterator, java.util.Iterator
        public Object next() {
            return nextEntry().getValue();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class Values extends AbstractCollection {
        private Values() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            StaticBucketMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return new ValueIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return StaticBucketMap.this.size();
        }
    }

    public StaticBucketMap() {
        this(255);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getHash(Object obj) {
        if (obj == null) {
            return 0;
        }
        int iHashCode = obj.hashCode();
        int i = iHashCode + (~(iHashCode << 15));
        int i2 = i ^ (i >>> 10);
        int i4 = i2 + (i2 << 3);
        int i5 = i4 ^ (i4 >>> 6);
        int i6 = i5 + (~(i5 << 11));
        int length = (i6 ^ (i6 >>> 16)) % this.buckets.length;
        return length < 0 ? length * (-1) : length;
    }

    public void atomic(Runnable runnable) {
        runnable.getClass();
        atomic(runnable, 0);
    }

    @Override // java.util.Map
    public void clear() {
        for (int i = 0; i < this.buckets.length; i++) {
            Lock lock = this.locks[i];
            synchronized (lock) {
                this.buckets[i] = null;
                lock.size = 0;
            }
        }
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        int hash = getHash(obj);
        synchronized (this.locks[hash]) {
            try {
                for (Node node = this.buckets[hash]; node != null; node = node.next) {
                    Object obj2 = node.key;
                    if (obj2 != obj && (obj2 == null || !obj2.equals(obj))) {
                    }
                    return true;
                }
                return false;
            } finally {
            }
        }
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        for (int i = 0; i < this.buckets.length; i++) {
            synchronized (this.locks[i]) {
                try {
                    for (Node node = this.buckets[i]; node != null; node = node.next) {
                        Object obj2 = node.value;
                        if (obj2 != obj && (obj2 == null || !obj2.equals(obj))) {
                        }
                        return true;
                    }
                } finally {
                }
            }
        }
        return false;
    }

    @Override // java.util.Map
    public Set entrySet() {
        return new EntrySet();
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
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
        int hash = getHash(obj);
        synchronized (this.locks[hash]) {
            try {
                for (Node node = this.buckets[hash]; node != null; node = node.next) {
                    Object obj2 = node.key;
                    if (obj2 != obj && (obj2 == null || !obj2.equals(obj))) {
                    }
                    return node.value;
                }
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.util.Map
    public int hashCode() {
        int iHashCode = 0;
        for (int i = 0; i < this.buckets.length; i++) {
            synchronized (this.locks[i]) {
                try {
                    for (Node node = this.buckets[i]; node != null; node = node.next) {
                        iHashCode += node.hashCode();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return iHashCode;
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.Map
    public Set keySet() {
        return new KeySet();
    }

    @Override // java.util.Map
    public Object put(Object obj, Object obj2) {
        int hash = getHash(obj);
        synchronized (this.locks[hash]) {
            try {
                Node node = this.buckets[hash];
                if (node == null) {
                    Node node2 = new Node();
                    node2.key = obj;
                    node2.value = obj2;
                    this.buckets[hash] = node2;
                    this.locks[hash].size++;
                    return null;
                }
                Node node3 = node;
                while (node != null) {
                    Object obj3 = node.key;
                    if (obj3 != obj && (obj3 == null || !obj3.equals(obj))) {
                        node3 = node;
                        node = node.next;
                    }
                    Object obj4 = node.value;
                    node.value = obj2;
                    return obj4;
                }
                Node node4 = new Node();
                node4.key = obj;
                node4.value = obj2;
                node3.next = node4;
                this.locks[hash].size++;
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.util.Map
    public void putAll(Map map) {
        for (Object obj : map.keySet()) {
            put(obj, map.get(obj));
        }
    }

    @Override // java.util.Map
    public Object remove(Object obj) {
        int hash = getHash(obj);
        synchronized (this.locks[hash]) {
            try {
                Node node = null;
                for (Node node2 = this.buckets[hash]; node2 != null; node2 = node2.next) {
                    Object obj2 = node2.key;
                    if (obj2 != obj && (obj2 == null || !obj2.equals(obj))) {
                        node = node2;
                    }
                    if (node == null) {
                        this.buckets[hash] = node2.next;
                    } else {
                        node.next = node2.next;
                    }
                    Lock lock = this.locks[hash];
                    lock.size--;
                    return node2.value;
                }
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.util.Map
    public int size() {
        int i = 0;
        for (int i2 = 0; i2 < this.buckets.length; i2++) {
            synchronized (this.locks[i2]) {
                i += this.locks[i2].size;
            }
        }
        return i;
    }

    @Override // java.util.Map
    public Collection values() {
        return new Values();
    }

    public StaticBucketMap(int i) {
        int iMax = Math.max(17, i);
        iMax = iMax % 2 == 0 ? iMax - 1 : iMax;
        this.buckets = new Node[iMax];
        this.locks = new Lock[iMax];
        for (int i2 = 0; i2 < iMax; i2++) {
            this.locks[i2] = new Lock();
        }
    }

    private void atomic(Runnable runnable, int i) {
        if (i >= this.buckets.length) {
            runnable.run();
            return;
        }
        synchronized (this.locks[i]) {
            atomic(runnable, i + 1);
        }
    }
}
