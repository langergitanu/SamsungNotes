package org.apache.commons.collections4.map;

import androidx.glance.AbstractC2821a;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;
import org.apache.commons.collections4.BoundedMap;
import org.apache.commons.collections4.map.AbstractHashedMap;
import org.apache.commons.collections4.map.AbstractLinkedMap;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class LRUMap<K, V> extends AbstractLinkedMap<K, V> implements BoundedMap<K, V>, Serializable, Cloneable {
    protected static final int DEFAULT_MAX_SIZE = 100;
    private static final long serialVersionUID = -612114643488955218L;
    private transient int maxSize;
    private final boolean scanUntilRemovable;

    public LRUMap() {
        this(100, 0.75f, false);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        doReadObject(objectInputStream);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        doWriteObject(objectOutputStream);
    }

    @Override // org.apache.commons.collections4.map.AbstractHashedMap
    public void addMapping(int i, int i2, K k, V v) {
        boolean zRemoveLRU;
        if (!isFull()) {
            super.addMapping(i, i2, k, v);
            return;
        }
        AbstractLinkedMap.LinkEntry<K, V> linkEntry = this.header.after;
        if (this.scanUntilRemovable) {
            while (linkEntry != this.header && linkEntry != null) {
                if (removeLRU(linkEntry)) {
                    zRemoveLRU = true;
                    break;
                }
                linkEntry = linkEntry.after;
            }
            zRemoveLRU = false;
            if (linkEntry == null) {
                StringBuilder sb = new StringBuilder("Entry.after=null, header.after=");
                sb.append(this.header.after);
                sb.append(" header.before=");
                sb.append(this.header.before);
                sb.append(" key=");
                sb.append(k);
                sb.append(" value=");
                sb.append(v);
                sb.append(" size=");
                sb.append(this.size);
                sb.append(" maxSize=");
                throw new IllegalStateException(AbstractC2821a.m2223n(sb, " This should not occur if your keys are immutable and you used synchronization properly.", this.maxSize));
            }
        } else {
            zRemoveLRU = removeLRU(linkEntry);
        }
        if (!zRemoveLRU) {
            super.addMapping(i, i2, k, v);
            return;
        }
        if (linkEntry != null) {
            reuseMapping(linkEntry, i, i2, k, v);
            return;
        }
        StringBuilder sb2 = new StringBuilder("reuse=null, header.after=");
        sb2.append(this.header.after);
        sb2.append(" header.before=");
        sb2.append(this.header.before);
        sb2.append(" key=");
        sb2.append(k);
        sb2.append(" value=");
        sb2.append(v);
        sb2.append(" size=");
        sb2.append(this.size);
        sb2.append(" maxSize=");
        throw new IllegalStateException(AbstractC2821a.m2223n(sb2, " This should not occur if your keys are immutable and you used synchronization properly.", this.maxSize));
    }

    @Override // org.apache.commons.collections4.map.AbstractHashedMap
    public void doReadObject(ObjectInputStream objectInputStream) throws IOException {
        this.maxSize = objectInputStream.readInt();
        super.doReadObject(objectInputStream);
    }

    @Override // org.apache.commons.collections4.map.AbstractHashedMap
    public void doWriteObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(this.maxSize);
        super.doWriteObject(objectOutputStream);
    }

    @Override // org.apache.commons.collections4.map.AbstractHashedMap, java.util.AbstractMap, java.util.Map, org.apache.commons.collections4.Get
    public V get(Object obj) {
        return get(obj, true);
    }

    @Override // org.apache.commons.collections4.BoundedMap
    public boolean isFull() {
        return this.size >= this.maxSize;
    }

    public boolean isScanUntilRemovable() {
        return this.scanUntilRemovable;
    }

    @Override // org.apache.commons.collections4.BoundedMap
    public int maxSize() {
        return this.maxSize;
    }

    public void moveToMRU(AbstractLinkedMap.LinkEntry<K, V> linkEntry) {
        AbstractLinkedMap.LinkEntry<K, V> linkEntry2 = linkEntry.after;
        AbstractLinkedMap.LinkEntry<K, V> linkEntry3 = this.header;
        if (linkEntry2 == linkEntry3) {
            if (linkEntry == linkEntry3) {
                throw new IllegalStateException("Can't move header to MRU This should not occur if your keys are immutable, and you have used synchronization properly.");
            }
            return;
        }
        this.modCount++;
        AbstractLinkedMap.LinkEntry<K, V> linkEntry4 = linkEntry.before;
        if (linkEntry4 == null) {
            throw new IllegalStateException("Entry.before is null. This should not occur if your keys are immutable, and you have used synchronization properly.");
        }
        linkEntry4.after = linkEntry2;
        linkEntry.after.before = linkEntry4;
        linkEntry.after = linkEntry3;
        linkEntry.before = linkEntry3.before;
        linkEntry3.before.after = linkEntry;
        linkEntry3.before = linkEntry;
    }

    public boolean removeLRU(AbstractLinkedMap.LinkEntry<K, V> linkEntry) {
        return true;
    }

    public void reuseMapping(AbstractLinkedMap.LinkEntry<K, V> linkEntry, int i, int i2, K k, V v) {
        try {
            int iHashIndex = hashIndex(linkEntry.hashCode, this.data.length);
            AbstractHashedMap.HashEntry<K, V> hashEntry = this.data[iHashIndex];
            AbstractHashedMap.HashEntry<K, V> hashEntry2 = null;
            while (hashEntry != linkEntry && hashEntry != null) {
                hashEntry2 = hashEntry;
                hashEntry = hashEntry.next;
            }
            if (hashEntry != null) {
                this.modCount++;
                removeEntry(linkEntry, iHashIndex, hashEntry2);
                reuseEntry(linkEntry, i, i2, k, v);
                addEntry(linkEntry, i);
                return;
            }
            throw new IllegalStateException("Entry.next=null, data[removeIndex]=" + this.data[iHashIndex] + " previous=" + hashEntry2 + " key=" + k + " value=" + v + " size=" + this.size + " maxSize=" + this.maxSize + " This should not occur if your keys are immutable, and you have used synchronization properly.");
        } catch (NullPointerException unused) {
            StringBuilder sb = new StringBuilder("NPE, entry=");
            sb.append(linkEntry);
            sb.append(" entryIsHeader=");
            sb.append(linkEntry == this.header);
            sb.append(" key=");
            sb.append(k);
            sb.append(" value=");
            sb.append(v);
            sb.append(" size=");
            sb.append(this.size);
            sb.append(" maxSize=");
            throw new IllegalStateException(AbstractC2821a.m2223n(sb, " This should not occur if your keys are immutable, and you have used synchronization properly.", this.maxSize));
        }
    }

    @Override // org.apache.commons.collections4.map.AbstractHashedMap
    public void updateEntry(AbstractHashedMap.HashEntry<K, V> hashEntry, V v) {
        moveToMRU((AbstractLinkedMap.LinkEntry) hashEntry);
        hashEntry.setValue(v);
    }

    public LRUMap(int i) {
        this(i, 0.75f);
    }

    public V get(Object obj, boolean z) {
        AbstractLinkedMap.LinkEntry<K, V> entry = getEntry(obj);
        if (entry == null) {
            return null;
        }
        if (z) {
            moveToMRU(entry);
        }
        return entry.getValue();
    }

    public LRUMap(int i, boolean z) {
        this(i, 0.75f, z);
    }

    @Override // org.apache.commons.collections4.map.AbstractHashedMap, java.util.AbstractMap
    public LRUMap<K, V> clone() {
        return (LRUMap) super.clone();
    }

    public LRUMap(int i, float f) {
        this(i, f, false);
    }

    public LRUMap(int i, float f, boolean z) {
        this(i, i, f, z);
    }

    public LRUMap(int i, int i2) {
        this(i, i2, 0.75f);
    }

    public LRUMap(int i, int i2, float f) {
        this(i, i2, f, false);
    }

    public LRUMap(int i, int i2, float f, boolean z) {
        super(i2, f);
        if (i < 1) {
            throw new IllegalArgumentException("LRUMap max size must be greater than 0");
        }
        if (i2 <= i) {
            this.maxSize = i;
            this.scanUntilRemovable = z;
            return;
        }
        throw new IllegalArgumentException("LRUMap initial size must not be greater than max size");
    }

    public LRUMap(Map<? extends K, ? extends V> map) {
        this((Map) map, false);
    }

    public LRUMap(Map<? extends K, ? extends V> map, boolean z) {
        this(map.size(), 0.75f, z);
        putAll(map);
    }
}
