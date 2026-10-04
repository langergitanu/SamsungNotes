package org.apache.commons.collections4.map;

import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class ConcurrentReferenceHashMap<K, V> extends AbstractMap<K, V> implements ConcurrentMap<K, V> {
    static final int DEFAULT_CONCURRENCY_LEVEL = 16;
    static final int DEFAULT_INITIAL_CAPACITY = 16;
    static final float DEFAULT_LOAD_FACTOR = 0.75f;
    private static final int MAXIMUM_CAPACITY = 1073741824;
    private static final int MAX_SEGMENTS = 65536;
    private static final int RETRIES_BEFORE_LOCK = 2;
    private transient Set<Map.Entry<K, V>> entrySet;
    private final boolean identityComparisons;
    private transient Set<K> keySet;
    private final int segmentMask;
    private final int segmentShift;
    private final Segment<K, V>[] segments;
    private transient Collection<V> values;
    static final ReferenceType DEFAULT_KEY_TYPE = ReferenceType.WEAK;
    static final ReferenceType DEFAULT_VALUE_TYPE = ReferenceType.STRONG;
    static final EnumSet<Option> DEFAULT_OPTIONS = null;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Builder<K, V> implements Supplier<ConcurrentReferenceHashMap<K, V>> {
        private static final Map<?, ?> DEFAULT_SOURCE_MAP = null;
        private int initialCapacity = 16;
        private float loadFactor = 0.75f;
        private int concurrencyLevel = 16;
        private ReferenceType keyReferenceType = ConcurrentReferenceHashMap.DEFAULT_KEY_TYPE;
        private ReferenceType valueReferenceType = ConcurrentReferenceHashMap.DEFAULT_VALUE_TYPE;
        private EnumSet<Option> options = ConcurrentReferenceHashMap.DEFAULT_OPTIONS;
        private Map<? extends K, ? extends V> sourceMap = (Map<? extends K, ? extends V>) DEFAULT_SOURCE_MAP;

        public Builder<K, V> setConcurrencyLevel(int i) {
            this.concurrencyLevel = i;
            return this;
        }

        public Builder<K, V> setInitialCapacity(int i) {
            this.initialCapacity = i;
            return this;
        }

        public Builder<K, V> setKeyReferenceType(ReferenceType referenceType) {
            this.keyReferenceType = referenceType;
            return this;
        }

        public Builder<K, V> setLoadFactor(float f) {
            this.loadFactor = f;
            return this;
        }

        public Builder<K, V> setOptions(EnumSet<Option> enumSet) {
            this.options = enumSet;
            return this;
        }

        public Builder<K, V> setSourceMap(Map<? extends K, ? extends V> map) {
            this.sourceMap = map;
            return this;
        }

        public Builder<K, V> setValueReferenceType(ReferenceType referenceType) {
            this.valueReferenceType = referenceType;
            return this;
        }

        public Builder<K, V> softKeys() {
            setKeyReferenceType(ReferenceType.SOFT);
            return this;
        }

        public Builder<K, V> softValues() {
            setValueReferenceType(ReferenceType.SOFT);
            return this;
        }

        public Builder<K, V> strongKeys() {
            setKeyReferenceType(ReferenceType.STRONG);
            return this;
        }

        public Builder<K, V> strongValues() {
            setValueReferenceType(ReferenceType.STRONG);
            return this;
        }

        public Builder<K, V> weakKeys() {
            setKeyReferenceType(ReferenceType.WEAK);
            return this;
        }

        public Builder<K, V> weakValues() {
            setValueReferenceType(ReferenceType.WEAK);
            return this;
        }

        @Override // java.util.function.Supplier
        public ConcurrentReferenceHashMap<K, V> get() {
            ConcurrentReferenceHashMap<K, V> concurrentReferenceHashMap = new ConcurrentReferenceHashMap<>(this.initialCapacity, this.loadFactor, this.concurrencyLevel, this.keyReferenceType, this.valueReferenceType, this.options);
            Map<? extends K, ? extends V> map = this.sourceMap;
            if (map != null) {
                concurrentReferenceHashMap.putAll(map);
            }
            return concurrentReferenceHashMap;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public final class CachedEntryIterator extends ConcurrentReferenceHashMap<K, V>.HashIterator implements Iterator<Map.Entry<K, V>> {
        private final InitializableEntry<K, V> entry;

        /* JADX WARN: Illegal instructions before constructor call */
        private CachedEntryIterator() {
            super();
            this.entry = new InitializableEntry<>();
        }

        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            HashEntry<K, V> hashEntryNextEntry = super.nextEntry();
            return this.entry.init(hashEntryNextEntry.key(), hashEntryNextEntry.value());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public final class EntryIterator extends ConcurrentReferenceHashMap<K, V>.HashIterator implements Iterator<Map.Entry<K, V>> {
        private EntryIterator() {
            super();
        }

        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            HashEntry<K, V> hashEntryNextEntry = super.nextEntry();
            return new WriteThroughEntry(hashEntryNextEntry.key(), hashEntryNextEntry.value());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public final class EntrySet extends AbstractSet<Map.Entry<K, V>> {
        private final boolean cached;

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            ConcurrentReferenceHashMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return Objects.equals(ConcurrentReferenceHashMap.this.get(entry.getKey()), entry.getValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return ConcurrentReferenceHashMap.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return this.cached ? new CachedEntryIterator() : new EntryIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return ConcurrentReferenceHashMap.this.remove(entry.getKey(), entry.getValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return ConcurrentReferenceHashMap.this.size();
        }

        private EntrySet(boolean z) {
            this.cached = z;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class HashEntry<K, V> {
        private final int hash;
        private final Object keyRef;
        private final HashEntry<K, V> next;
        private volatile Object valueRef;

        public HashEntry(K k, int i, HashEntry<K, V> hashEntry, V v, ReferenceType referenceType, ReferenceType referenceType2, ReferenceQueue<Object> referenceQueue) {
            this.hash = i;
            this.next = hashEntry;
            this.keyRef = newKeyReference(k, referenceType, referenceQueue);
            this.valueRef = newValueReference(v, referenceType2, referenceQueue);
        }

        public static <K, V> HashEntry<K, V>[] newArray(int i) {
            return new HashEntry[i];
        }

        /* JADX WARN: Multi-variable type inference failed */
        public V dereferenceValue(Object obj) {
            return obj instanceof KeyReference ? (V) ((Reference) obj).get() : obj;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public K key() {
            K k = (K) this.keyRef;
            return k instanceof KeyReference ? (K) ((Reference) k).get() : k;
        }

        public Object newKeyReference(K k, ReferenceType referenceType, ReferenceQueue<Object> referenceQueue) {
            return referenceType == ReferenceType.WEAK ? new WeakKeyReference(k, this.hash, referenceQueue) : referenceType == ReferenceType.SOFT ? new SoftKeyReference(k, this.hash, referenceQueue) : k;
        }

        public Object newValueReference(V v, ReferenceType referenceType, ReferenceQueue<Object> referenceQueue) {
            return referenceType == ReferenceType.WEAK ? new WeakValueReference(v, this.keyRef, this.hash, referenceQueue) : referenceType == ReferenceType.SOFT ? new SoftValueReference(v, this.keyRef, this.hash, referenceQueue) : v;
        }

        public void setValue(V v, ReferenceType referenceType, ReferenceQueue<Object> referenceQueue) {
            this.valueRef = newValueReference(v, referenceType, referenceQueue);
        }

        public V value() {
            return dereferenceValue(this.valueRef);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public abstract class HashIterator {
        private K currentKey;
        private HashEntry<K, V>[] currentTable;
        private HashEntry<K, V> lastReturned;
        private HashEntry<K, V> nextEntry;
        private int nextSegmentIndex;
        private int nextTableIndex;

        public final void advance() {
            HashEntry<K, V> hashEntry;
            HashEntry<K, V> hashEntry2 = this.nextEntry;
            if (hashEntry2 != null) {
                HashEntry<K, V> hashEntry3 = ((HashEntry) hashEntry2).next;
                this.nextEntry = hashEntry3;
                if (hashEntry3 != null) {
                    return;
                }
            }
            do {
                int i = this.nextTableIndex;
                if (i < 0) {
                    while (this.nextSegmentIndex >= 0) {
                        Segment[] segmentArr = ConcurrentReferenceHashMap.this.segments;
                        int i2 = this.nextSegmentIndex;
                        this.nextSegmentIndex = i2 - 1;
                        Segment segment = segmentArr[i2];
                        if (segment.count != 0) {
                            HashEntry<K, V>[] hashEntryArr = segment.table;
                            this.currentTable = hashEntryArr;
                            for (int length = hashEntryArr.length - 1; length >= 0; length--) {
                                HashEntry<K, V> hashEntry4 = this.currentTable[length];
                                this.nextEntry = hashEntry4;
                                if (hashEntry4 != null) {
                                    this.nextTableIndex = length - 1;
                                    return;
                                }
                            }
                        }
                    }
                    return;
                }
                HashEntry<K, V>[] hashEntryArr2 = this.currentTable;
                this.nextTableIndex = i - 1;
                hashEntry = hashEntryArr2[i];
                this.nextEntry = hashEntry;
            } while (hashEntry == null);
        }

        public boolean hasMoreElements() {
            return hasNext();
        }

        public boolean hasNext() {
            while (true) {
                HashEntry<K, V> hashEntry = this.nextEntry;
                if (hashEntry == null) {
                    return false;
                }
                if (hashEntry.key() != null) {
                    return true;
                }
                advance();
            }
        }

        public HashEntry<K, V> nextEntry() {
            do {
                HashEntry<K, V> hashEntry = this.nextEntry;
                if (hashEntry == null) {
                    throw new NoSuchElementException();
                }
                this.lastReturned = hashEntry;
                this.currentKey = hashEntry.key();
                advance();
            } while (this.currentKey == null);
            return this.lastReturned;
        }

        public void remove() {
            if (this.lastReturned == null) {
                throw new IllegalStateException();
            }
            ConcurrentReferenceHashMap.this.remove(this.currentKey);
            this.lastReturned = null;
        }

        private HashIterator() {
            this.nextSegmentIndex = ConcurrentReferenceHashMap.this.segments.length - 1;
            this.nextTableIndex = -1;
            advance();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class InitializableEntry<K, V> implements Map.Entry<K, V> {
        private K key;
        private V value;

        private InitializableEntry() {
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.key;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.value;
        }

        public Map.Entry<K, V> init(K k, V v) {
            this.key = k;
            this.value = v;
            return this;
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            throw new UnsupportedOperationException();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public final class KeyIterator extends ConcurrentReferenceHashMap<K, V>.HashIterator implements Iterator<K>, Enumeration<K> {
        private KeyIterator() {
            super();
        }

        @Override // java.util.Iterator
        public K next() {
            return super.nextEntry().key();
        }

        @Override // java.util.Enumeration
        public K nextElement() {
            return super.nextEntry().key();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface KeyReference {
        int keyHash();

        Object keyRef();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public final class KeySet extends AbstractSet<K> {
        private KeySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            ConcurrentReferenceHashMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return ConcurrentReferenceHashMap.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return ConcurrentReferenceHashMap.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new KeyIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return ConcurrentReferenceHashMap.this.remove(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return ConcurrentReferenceHashMap.this.size();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum Option {
        IDENTITY_COMPARISONS
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum ReferenceType {
        STRONG,
        WEAK,
        SOFT
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class SimpleEntry<K, V> implements Map.Entry<K, V> {
        private final K key;
        private V value;

        public SimpleEntry(K k, V v) {
            this.key = k;
            this.value = v;
        }

        /* JADX INFO: renamed from: eq */
        private static boolean m14577eq(Object obj, Object obj2) {
            return Objects.equals(obj, obj2);
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return m14577eq(this.key, entry.getKey()) && m14577eq(this.value, entry.getValue());
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.key;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.value;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            K k = this.key;
            int iHashCode = k == null ? 0 : k.hashCode();
            V v = this.value;
            return iHashCode ^ (v != null ? v.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            V v4 = this.value;
            this.value = v;
            return v4;
        }

        public String toString() {
            return this.key + MarketingConstants.REFERRER_DELIMITER_U003D + this.value;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class SoftValueReference<V> extends SoftReference<V> implements KeyReference {
        private final int hash;
        private final Object keyRef;

        public SoftValueReference(V v, Object obj, int i, ReferenceQueue<Object> referenceQueue) {
            super(v, referenceQueue);
            this.keyRef = obj;
            this.hash = i;
        }

        @Override // org.apache.commons.collections4.map.ConcurrentReferenceHashMap.KeyReference
        public int keyHash() {
            return this.hash;
        }

        @Override // org.apache.commons.collections4.map.ConcurrentReferenceHashMap.KeyReference
        public Object keyRef() {
            return this.keyRef;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public final class ValueIterator extends ConcurrentReferenceHashMap<K, V>.HashIterator implements Iterator<V>, Enumeration<V> {
        private ValueIterator() {
            super();
        }

        @Override // java.util.Iterator
        public V next() {
            return super.nextEntry().value();
        }

        @Override // java.util.Enumeration
        public V nextElement() {
            return super.nextEntry().value();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public final class Values extends AbstractCollection<V> {
        private Values() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            ConcurrentReferenceHashMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return ConcurrentReferenceHashMap.this.containsValue(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return ConcurrentReferenceHashMap.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return new ValueIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return ConcurrentReferenceHashMap.this.size();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class WeakValueReference<V> extends WeakReference<V> implements KeyReference {
        private final int hash;
        private final Object keyRef;

        public WeakValueReference(V v, Object obj, int i, ReferenceQueue<Object> referenceQueue) {
            super(v, referenceQueue);
            this.keyRef = obj;
            this.hash = i;
        }

        @Override // org.apache.commons.collections4.map.ConcurrentReferenceHashMap.KeyReference
        public int keyHash() {
            return this.hash;
        }

        @Override // org.apache.commons.collections4.map.ConcurrentReferenceHashMap.KeyReference
        public Object keyRef() {
            return this.keyRef;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public final class WriteThroughEntry extends SimpleEntry<K, V> {
        @Override // org.apache.commons.collections4.map.ConcurrentReferenceHashMap.SimpleEntry, java.util.Map.Entry
        public V setValue(V v) {
            Objects.requireNonNull(v, "value");
            V v4 = (V) super.setValue(v);
            ConcurrentReferenceHashMap.this.put(getKey(), v);
            return v4;
        }

        private WriteThroughEntry(K k, V v) {
            super(k, v);
        }
    }

    public static <K, V> Builder<K, V> builder() {
        return new Builder<>();
    }

    private static int hash(int i) {
        int i2 = i + ((i << 15) ^ (-12931));
        int i4 = i2 ^ (i2 >>> 10);
        int i5 = i4 + (i4 << 3);
        int i6 = i5 ^ (i5 >>> 6);
        int i7 = (i6 << 2) + (i6 << 14) + i6;
        return (i7 >>> 16) ^ i7;
    }

    private int hashOf(Object obj) {
        return hash(this.identityComparisons ? System.identityHashCode(obj) : obj.hashCode());
    }

    private Segment<K, V> segmentFor(int i) {
        return this.segments[(i >>> this.segmentShift) & this.segmentMask];
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        for (Segment<K, V> segment : this.segments) {
            segment.clear();
        }
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public V compute(K k, BiFunction<? super K, ? super V, ? extends V> biFunction) {
        Objects.requireNonNull(k);
        Objects.requireNonNull(biFunction);
        int iHashOf = hashOf(k);
        return segmentFor(iHashOf).apply(k, iHashOf, biFunction);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public V computeIfAbsent(K k, Function<? super K, ? extends V> function) {
        Objects.requireNonNull(k);
        Objects.requireNonNull(function);
        int iHashOf = hashOf(k);
        Segment<K, V> segmentSegmentFor = segmentFor(iHashOf);
        V v = segmentSegmentFor.get(k, iHashOf);
        return v == null ? segmentSegmentFor.put(k, iHashOf, null, function, true) : v;
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public V computeIfPresent(K k, BiFunction<? super K, ? super V, ? extends V> biFunction) {
        Objects.requireNonNull(k);
        Objects.requireNonNull(biFunction);
        int iHashOf = hashOf(k);
        if (segmentFor(iHashOf).get(k, iHashOf) == null) {
            return null;
        }
        return segmentFor(iHashOf).applyIfPresent(k, iHashOf, biFunction);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        int iHashOf = hashOf(obj);
        return segmentFor(iHashOf).containsKey(obj, iHashOf);
    }

    /* JADX WARN: Finally extract failed */
    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object obj) {
        Objects.requireNonNull(obj, "value");
        Segment<K, V>[] segmentArr = this.segments;
        int[] iArr = new int[segmentArr.length];
        int i = 0;
        int i2 = 0;
        loop0: while (true) {
            boolean z = true;
            if (i2 < 2) {
                int i4 = 0;
                for (int i5 = 0; i5 < segmentArr.length; i5++) {
                    int i6 = ((Segment) segmentArr[i5]).modCount;
                    iArr[i5] = i6;
                    i4 += i6;
                    if (segmentArr[i5].containsValue(obj)) {
                        return true;
                    }
                }
                if (i4 == 0) {
                    break;
                }
                for (int i7 = 0; i7 < segmentArr.length; i7++) {
                    if (iArr[i7] != ((Segment) segmentArr[i7]).modCount) {
                        break;
                    }
                }
                break loop0;
            }
            for (Segment<K, V> segment : segmentArr) {
                segment.lock();
            }
            try {
                int length = segmentArr.length;
                int i8 = 0;
                while (true) {
                    if (i8 >= length) {
                        z = false;
                        break;
                    }
                    if (segmentArr[i8].containsValue(obj)) {
                        break;
                    }
                    i8++;
                }
                int length2 = segmentArr.length;
                while (i < length2) {
                    segmentArr[i].unlock();
                    i++;
                }
                return z;
            } catch (Throwable th) {
                int length3 = segmentArr.length;
                while (i < length3) {
                    segmentArr[i].unlock();
                    i++;
                }
                throw th;
            }
            i2++;
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.entrySet;
        if (set != null) {
            return set;
        }
        EntrySet entrySet = new EntrySet(false);
        this.entrySet = entrySet;
        return entrySet;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        int iHashOf = hashOf(obj);
        return segmentFor(iHashOf).get(obj, iHashOf);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        Segment<K, V>[] segmentArr = this.segments;
        int[] iArr = new int[segmentArr.length];
        int i = 0;
        for (int i2 = 0; i2 < segmentArr.length; i2++) {
            if (((Segment) segmentArr[i2]).count != 0) {
                return false;
            }
            int i4 = ((Segment) segmentArr[i2]).modCount;
            iArr[i2] = i4;
            i += i4;
        }
        if (i == 0) {
            return true;
        }
        for (int i5 = 0; i5 < segmentArr.length; i5++) {
            if (((Segment) segmentArr[i5]).count != 0 || iArr[i5] != ((Segment) segmentArr[i5]).modCount) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        Set<K> set = this.keySet;
        if (set != null) {
            return set;
        }
        KeySet keySet = new KeySet();
        this.keySet = keySet;
        return keySet;
    }

    public void purgeStaleEntries() {
        for (Segment<K, V> segment : this.segments) {
            segment.removeStale();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k, V v) {
        Objects.requireNonNull(k, "key");
        Objects.requireNonNull(v, "value");
        int iHashOf = hashOf(k);
        return segmentFor(iHashOf).put(k, iHashOf, v, null, false);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public V putIfAbsent(K k, V v) {
        Objects.requireNonNull(v, "value");
        int iHashOf = hashOf(k);
        return segmentFor(iHashOf).put(k, iHashOf, v, null, true);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        int iHashOf = hashOf(obj);
        return segmentFor(iHashOf).remove(obj, iHashOf, null, false);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public V replace(K k, V v) {
        Objects.requireNonNull(v, "value");
        int iHashOf = hashOf(k);
        return segmentFor(iHashOf).replace(k, iHashOf, v);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        Segment<K, V>[] segmentArr = this.segments;
        int[] iArr = new int[segmentArr.length];
        long j = 0;
        long j2 = 0;
        long j3 = 0;
        for (int i = 0; i < 2; i++) {
            j2 = 0;
            int i2 = 0;
            for (int i4 = 0; i4 < segmentArr.length; i4++) {
                j2 += (long) ((Segment) segmentArr[i4]).count;
                int i5 = ((Segment) segmentArr[i4]).modCount;
                iArr[i4] = i5;
                i2 += i5;
            }
            if (i2 != 0) {
                long j5 = 0;
                int i6 = 0;
                while (true) {
                    if (i6 >= segmentArr.length) {
                        j3 = j5;
                        break;
                    }
                    j5 += (long) ((Segment) segmentArr[i6]).count;
                    if (iArr[i6] != ((Segment) segmentArr[i6]).modCount) {
                        j3 = -1;
                        break;
                    }
                    i6++;
                }
            } else {
                j3 = 0;
            }
            if (j3 == j2) {
                break;
            }
        }
        if (j3 != j2) {
            for (Segment<K, V> segment : segmentArr) {
                segment.lock();
            }
            for (Segment<K, V> segment2 : segmentArr) {
                j += (long) ((Segment) segment2).count;
            }
            for (Segment<K, V> segment3 : segmentArr) {
                segment3.unlock();
            }
            j2 = j;
        }
        if (j2 > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) j2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection<V> values() {
        Collection<V> collection = this.values;
        if (collection != null) {
            return collection;
        }
        Values values = new Values();
        this.values = values;
        return values;
    }

    private ConcurrentReferenceHashMap(int i, float f, int i2, ReferenceType referenceType, ReferenceType referenceType2, EnumSet<Option> enumSet) {
        if (f <= 0.0f || i < 0 || i2 <= 0) {
            throw new IllegalArgumentException();
        }
        int i4 = 0;
        int i5 = 0;
        int i6 = 1;
        while (i6 < (i2 > 65536 ? 65536 : i2)) {
            i5++;
            i6 <<= 1;
        }
        this.segmentShift = 32 - i5;
        this.segmentMask = i6 - 1;
        this.segments = Segment.newArray(i6);
        i = i > 1073741824 ? 1073741824 : i;
        int i7 = i / i6;
        int i8 = 1;
        while (i8 < (i6 * i7 < i ? i7 + 1 : i7)) {
            i8 <<= 1;
        }
        this.identityComparisons = enumSet != null && enumSet.contains(Option.IDENTITY_COMPARISONS);
        while (true) {
            Segment<K, V>[] segmentArr = this.segments;
            if (i4 >= segmentArr.length) {
                return;
            }
            segmentArr[i4] = new Segment<>(i8, f, referenceType, referenceType2, this.identityComparisons);
            i4++;
        }
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public boolean remove(Object obj, Object obj2) {
        int iHashOf = hashOf(obj);
        return (obj2 == null || segmentFor(iHashOf).remove(obj, iHashOf, obj2, false) == null) ? false : true;
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Segment<K, V> extends ReentrantLock {
        private static final long serialVersionUID = 1;
        private volatile transient int count;
        private final boolean identityComparisons;
        private final ReferenceType keyType;
        private final float loadFactor;
        private transient int modCount;
        private volatile transient ReferenceQueue<Object> refQueue;
        private volatile transient HashEntry<K, V>[] table;
        private transient int threshold;
        private final ReferenceType valueType;

        public Segment(int i, float f, ReferenceType referenceType, ReferenceType referenceType2, boolean z) {
            this.loadFactor = f;
            this.keyType = referenceType;
            this.valueType = referenceType2;
            this.identityComparisons = z;
            setTable(HashEntry.newArray(i));
        }

        private boolean keyEq(Object obj, Object obj2) {
            return this.identityComparisons ? obj == obj2 : Objects.equals(obj, obj2);
        }

        public static <K, V> Segment<K, V>[] newArray(int i) {
            return new Segment[i];
        }

        private V putInternal(K k, int i, V v, Function<? super K, ? extends V> function, boolean z) {
            int iRehash;
            removeStale();
            int i2 = this.count;
            int i4 = i2 + 1;
            if (i2 > this.threshold && (iRehash = rehash()) > 0) {
                i4 -= iRehash;
                this.count = i4 - 1;
            }
            HashEntry<K, V>[] hashEntryArr = this.table;
            int length = (hashEntryArr.length - 1) & i;
            HashEntry<K, V> hashEntry = hashEntryArr[length];
            HashEntry<K, V> hashEntry2 = hashEntry;
            while (hashEntry2 != null && (((HashEntry) hashEntry2).hash != i || !keyEq(k, hashEntry2.key()))) {
                hashEntry2 = ((HashEntry) hashEntry2).next;
            }
            if (hashEntry2 != null) {
                V vValue = hashEntry2.value();
                if (!z) {
                    hashEntry2.setValue(getValue(k, v, function), this.valueType, this.refQueue);
                }
                return vValue;
            }
            V value = getValue(k, v, function);
            V v4 = function != null ? value : null;
            if (value != null) {
                this.modCount++;
                hashEntryArr[length] = newHashEntry(k, i, hashEntry, value);
                this.count = i4;
            }
            return v4;
        }

        private V removeInternal(Object obj, int i, Object obj2, boolean z) {
            if (!z) {
                removeStale();
            }
            int i2 = this.count - 1;
            HashEntry<K, V>[] hashEntryArr = this.table;
            int length = (hashEntryArr.length - 1) & i;
            HashEntry<K, V> hashEntry = hashEntryArr[length];
            HashEntry<K, V> hashEntry2 = hashEntry;
            while (hashEntry2 != null && obj != ((HashEntry) hashEntry2).keyRef && (z || i != ((HashEntry) hashEntry2).hash || !keyEq(obj, hashEntry2.key()))) {
                hashEntry2 = ((HashEntry) hashEntry2).next;
            }
            if (hashEntry2 == null) {
                return null;
            }
            V vValue = hashEntry2.value();
            if (obj2 != null && !obj2.equals(vValue)) {
                return null;
            }
            this.modCount++;
            HashEntry<K, V> hashEntryNewHashEntry = ((HashEntry) hashEntry2).next;
            while (hashEntry != hashEntry2) {
                K kKey = hashEntry.key();
                if (kKey == null) {
                    i2--;
                } else {
                    hashEntryNewHashEntry = newHashEntry(kKey, ((HashEntry) hashEntry).hash, hashEntryNewHashEntry, hashEntry.value());
                }
                hashEntry = ((HashEntry) hashEntry).next;
            }
            hashEntryArr[length] = hashEntryNewHashEntry;
            this.count = i2;
            return vValue;
        }

        private V replaceInternal(K k, int i, V v) {
            removeStale();
            HashEntry<K, V> first = getFirst(i);
            while (first != null && (((HashEntry) first).hash != i || !keyEq(k, first.key()))) {
                first = ((HashEntry) first).next;
            }
            if (first == null) {
                return null;
            }
            V vValue = first.value();
            first.setValue(v, this.valueType, this.refQueue);
            return vValue;
        }

        private boolean replaceInternal2(K k, int i, V v, V v4) {
            removeStale();
            HashEntry<K, V> first = getFirst(i);
            while (first != null && (((HashEntry) first).hash != i || !keyEq(k, first.key()))) {
                first = ((HashEntry) first).next;
            }
            if (first == null || !Objects.equals(v, first.value())) {
                return false;
            }
            first.setValue(v4, this.valueType, this.refQueue);
            return true;
        }

        public V apply(K k, int i, BiFunction<? super K, ? super V, ? extends V> biFunction) {
            lock();
            try {
                V v = get(k, i);
                V vApply = biFunction.apply(k, v);
                if (vApply != null) {
                    putInternal(k, i, vApply, null, false);
                    unlock();
                    return vApply;
                }
                if (v != null) {
                    removeInternal(k, i, v, false);
                }
                unlock();
                return null;
            } catch (Throwable th) {
                unlock();
                throw th;
            }
        }

        public V applyIfPresent(K k, int i, BiFunction<? super K, ? super V, ? extends V> biFunction) {
            lock();
            try {
                V v = get(k, i);
                if (v == null) {
                    unlock();
                    return null;
                }
                V vApply = biFunction.apply(k, v);
                if (vApply == null) {
                    removeInternal(k, i, v, false);
                    unlock();
                    return null;
                }
                putInternal(k, i, vApply, null, false);
                unlock();
                return vApply;
            } catch (Throwable th) {
                unlock();
                throw th;
            }
        }

        public void clear() {
            if (this.count != 0) {
                lock();
                try {
                    Arrays.fill(this.table, (Object) null);
                    this.modCount++;
                    this.refQueue = new ReferenceQueue<>();
                    this.count = 0;
                } finally {
                    unlock();
                }
            }
        }

        public boolean containsKey(Object obj, int i) {
            if (this.count == 0) {
                return false;
            }
            for (HashEntry<K, V> first = getFirst(i); first != null; first = ((HashEntry) first).next) {
                if (((HashEntry) first).hash == i && keyEq(obj, first.key())) {
                    return true;
                }
            }
            return false;
        }

        public boolean containsValue(Object obj) {
            if (this.count != 0) {
                for (HashEntry<K, V> hashEntry : this.table) {
                    for (; hashEntry != null; hashEntry = ((HashEntry) hashEntry).next) {
                        Object obj2 = ((HashEntry) hashEntry).valueRef;
                        if (Objects.equals(obj, obj2 == null ? readValueUnderLock(hashEntry) : hashEntry.dereferenceValue(obj2))) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }

        public V get(Object obj, int i) {
            if (this.count == 0) {
                return null;
            }
            for (HashEntry<K, V> first = getFirst(i); first != null; first = ((HashEntry) first).next) {
                if (((HashEntry) first).hash == i && keyEq(obj, first.key())) {
                    Object obj2 = ((HashEntry) first).valueRef;
                    return obj2 != null ? first.dereferenceValue(obj2) : readValueUnderLock(first);
                }
            }
            return null;
        }

        public HashEntry<K, V> getFirst(int i) {
            return this.table[i & (r0.length - 1)];
        }

        public V getValue(K k, V v, Function<? super K, ? extends V> function) {
            return v != null ? v : function.apply(k);
        }

        public HashEntry<K, V> newHashEntry(K k, int i, HashEntry<K, V> hashEntry, V v) {
            return new HashEntry<>(k, i, hashEntry, v, this.keyType, this.valueType, this.refQueue);
        }

        public V put(K k, int i, V v, Function<? super K, ? extends V> function, boolean z) {
            lock();
            try {
                return putInternal(k, i, v, function, z);
            } finally {
                unlock();
            }
        }

        public V readValueUnderLock(HashEntry<K, V> hashEntry) {
            lock();
            try {
                removeStale();
                return hashEntry.value();
            } finally {
                unlock();
            }
        }

        public int rehash() {
            HashEntry<K, V>[] hashEntryArr = this.table;
            int length = hashEntryArr.length;
            if (length >= 1073741824) {
                return 0;
            }
            HashEntry<K, V>[] hashEntryArrNewArray = HashEntry.newArray(length << 1);
            this.threshold = (int) (hashEntryArrNewArray.length * this.loadFactor);
            int length2 = hashEntryArrNewArray.length - 1;
            int i = 0;
            for (HashEntry<K, V> hashEntry : hashEntryArr) {
                if (hashEntry != null) {
                    HashEntry<K, V> hashEntry2 = ((HashEntry) hashEntry).next;
                    int i2 = ((HashEntry) hashEntry).hash & length2;
                    if (hashEntry2 == null) {
                        hashEntryArrNewArray[i2] = hashEntry;
                    } else {
                        HashEntry<K, V> hashEntry3 = hashEntry;
                        while (hashEntry2 != null) {
                            int i4 = ((HashEntry) hashEntry2).hash & length2;
                            if (i4 != i2) {
                                hashEntry3 = hashEntry2;
                                i2 = i4;
                            }
                            hashEntry2 = ((HashEntry) hashEntry2).next;
                        }
                        hashEntryArrNewArray[i2] = hashEntry3;
                        while (hashEntry != hashEntry3) {
                            K kKey = hashEntry.key();
                            if (kKey == null) {
                                i++;
                            } else {
                                int i5 = ((HashEntry) hashEntry).hash & length2;
                                hashEntryArrNewArray[i5] = newHashEntry(kKey, ((HashEntry) hashEntry).hash, hashEntryArrNewArray[i5], hashEntry.value());
                            }
                            hashEntry = ((HashEntry) hashEntry).next;
                        }
                    }
                }
            }
            this.table = hashEntryArrNewArray;
            return i;
        }

        public V remove(Object obj, int i, Object obj2, boolean z) {
            lock();
            try {
                return removeInternal(obj, i, obj2, z);
            } finally {
                unlock();
            }
        }

        public void removeStale() {
            while (true) {
                KeyReference keyReference = (KeyReference) this.refQueue.poll();
                if (keyReference == null) {
                    return;
                } else {
                    remove(keyReference.keyRef(), keyReference.keyHash(), null, true);
                }
            }
        }

        public V replace(K k, int i, V v) {
            lock();
            try {
                return replaceInternal(k, i, v);
            } finally {
                unlock();
            }
        }

        public void setTable(HashEntry<K, V>[] hashEntryArr) {
            this.threshold = (int) (hashEntryArr.length * this.loadFactor);
            this.table = hashEntryArr;
            this.refQueue = new ReferenceQueue<>();
        }

        public boolean replace(K k, int i, V v, V v4) {
            lock();
            try {
                return replaceInternal2(k, i, v, v4);
            } finally {
                unlock();
            }
        }
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public boolean replace(K k, V v, V v4) {
        Objects.requireNonNull(v, "oldValue");
        Objects.requireNonNull(v4, "newValue");
        int iHashOf = hashOf(k);
        return segmentFor(iHashOf).replace(k, iHashOf, v, v4);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class SoftKeyReference<K> extends SoftReference<K> implements KeyReference {
        private final int hash;

        public SoftKeyReference(K k, int i, ReferenceQueue<Object> referenceQueue) {
            super(k, referenceQueue);
            this.hash = i;
        }

        @Override // org.apache.commons.collections4.map.ConcurrentReferenceHashMap.KeyReference
        public int keyHash() {
            return this.hash;
        }

        @Override // org.apache.commons.collections4.map.ConcurrentReferenceHashMap.KeyReference
        public Object keyRef() {
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class WeakKeyReference<K> extends WeakReference<K> implements KeyReference {
        private final int hash;

        public WeakKeyReference(K k, int i, ReferenceQueue<Object> referenceQueue) {
            super(k, referenceQueue);
            this.hash = i;
        }

        @Override // org.apache.commons.collections4.map.ConcurrentReferenceHashMap.KeyReference
        public int keyHash() {
            return this.hash;
        }

        @Override // org.apache.commons.collections4.map.ConcurrentReferenceHashMap.KeyReference
        public Object keyRef() {
            return this;
        }
    }
}
