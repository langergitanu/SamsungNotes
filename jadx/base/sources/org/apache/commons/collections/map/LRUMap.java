package org.apache.commons.collections.map;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;
import org.apache.commons.collections.BoundedMap;
import org.apache.commons.collections.map.AbstractHashedMap;
import org.apache.commons.collections.map.AbstractLinkedMap;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class LRUMap extends AbstractLinkedMap implements BoundedMap, Serializable, Cloneable {
    protected static final int DEFAULT_MAX_SIZE = 100;
    private static final long serialVersionUID = -612114643488955218L;
    private transient int maxSize;
    private boolean scanUntilRemovable;

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

    @Override // org.apache.commons.collections.map.AbstractHashedMap
    public void addMapping(int i, int i2, Object obj, Object obj2) {
        boolean zRemoveLRU;
        if (!isFull()) {
            super.addMapping(i, i2, obj, obj2);
            return;
        }
        AbstractLinkedMap.LinkEntry linkEntry = this.header.after;
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
                StringBuffer stringBuffer = new StringBuffer("Entry.after=null, header.after");
                stringBuffer.append(this.header.after);
                stringBuffer.append(" header.before");
                stringBuffer.append(this.header.before);
                stringBuffer.append(" key=");
                stringBuffer.append(obj);
                stringBuffer.append(" value=");
                stringBuffer.append(obj2);
                stringBuffer.append(" size=");
                stringBuffer.append(this.size);
                stringBuffer.append(" maxSize=");
                stringBuffer.append(this.maxSize);
                stringBuffer.append(" Please check that your keys are immutable, and that you have used synchronization properly. If so, then please report this to commons-dev@jakarta.apache.org as a bug.");
                throw new IllegalStateException(stringBuffer.toString());
            }
        } else {
            zRemoveLRU = removeLRU(linkEntry);
        }
        if (!zRemoveLRU) {
            super.addMapping(i, i2, obj, obj2);
            return;
        }
        if (linkEntry != null) {
            reuseMapping(linkEntry, i, i2, obj, obj2);
            return;
        }
        StringBuffer stringBuffer2 = new StringBuffer("reuse=null, header.after=");
        stringBuffer2.append(this.header.after);
        stringBuffer2.append(" header.before");
        stringBuffer2.append(this.header.before);
        stringBuffer2.append(" key=");
        stringBuffer2.append(obj);
        stringBuffer2.append(" value=");
        stringBuffer2.append(obj2);
        stringBuffer2.append(" size=");
        stringBuffer2.append(this.size);
        stringBuffer2.append(" maxSize=");
        stringBuffer2.append(this.maxSize);
        stringBuffer2.append(" Please check that your keys are immutable, and that you have used synchronization properly. If so, then please report this to commons-dev@jakarta.apache.org as a bug.");
        throw new IllegalStateException(stringBuffer2.toString());
    }

    @Override // org.apache.commons.collections.map.AbstractHashedMap, java.util.AbstractMap
    public Object clone() {
        return super.clone();
    }

    @Override // org.apache.commons.collections.map.AbstractHashedMap
    public void doReadObject(ObjectInputStream objectInputStream) throws IOException {
        this.maxSize = objectInputStream.readInt();
        super.doReadObject(objectInputStream);
    }

    @Override // org.apache.commons.collections.map.AbstractHashedMap
    public void doWriteObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(this.maxSize);
        super.doWriteObject(objectOutputStream);
    }

    @Override // org.apache.commons.collections.map.AbstractHashedMap, java.util.AbstractMap, java.util.Map
    public Object get(Object obj) {
        AbstractLinkedMap.LinkEntry linkEntry = (AbstractLinkedMap.LinkEntry) getEntry(obj);
        if (linkEntry == null) {
            return null;
        }
        moveToMRU(linkEntry);
        return linkEntry.getValue();
    }

    @Override // org.apache.commons.collections.BoundedMap
    public boolean isFull() {
        return this.size >= this.maxSize;
    }

    public boolean isScanUntilRemovable() {
        return this.scanUntilRemovable;
    }

    @Override // org.apache.commons.collections.BoundedMap
    public int maxSize() {
        return this.maxSize;
    }

    public void moveToMRU(AbstractLinkedMap.LinkEntry linkEntry) {
        AbstractLinkedMap.LinkEntry linkEntry2 = linkEntry.after;
        AbstractLinkedMap.LinkEntry linkEntry3 = this.header;
        if (linkEntry2 == linkEntry3) {
            if (linkEntry == linkEntry3) {
                throw new IllegalStateException("Can't move header to MRU (please report this to commons-dev@jakarta.apache.org)");
            }
            return;
        }
        this.modCount++;
        AbstractLinkedMap.LinkEntry linkEntry4 = linkEntry.before;
        linkEntry4.after = linkEntry2;
        linkEntry.after.before = linkEntry4;
        linkEntry.after = linkEntry3;
        linkEntry.before = linkEntry3.before;
        linkEntry3.before.after = linkEntry;
        linkEntry3.before = linkEntry;
    }

    public boolean removeLRU(AbstractLinkedMap.LinkEntry linkEntry) {
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0, types: [org.apache.commons.collections.map.AbstractHashedMap$HashEntry, org.apache.commons.collections.map.AbstractLinkedMap$LinkEntry] */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v2, types: [org.apache.commons.collections.map.AbstractHashedMap, org.apache.commons.collections.map.AbstractLinkedMap, org.apache.commons.collections.map.LRUMap] */
    /* JADX WARN: Type inference failed for: r12v0, types: [int] */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.StringBuffer] */
    public void reuseMapping(AbstractLinkedMap.LinkEntry linkEntry, int i, int i2, Object obj, Object obj2) {
        try {
            int iHashIndex = hashIndex(linkEntry.hashCode, this.data.length);
            AbstractHashedMap.HashEntry hashEntry = this.data[iHashIndex];
            AbstractHashedMap.HashEntry hashEntry2 = null;
            while (hashEntry != linkEntry && hashEntry != null) {
                hashEntry2 = hashEntry;
                hashEntry = hashEntry.next;
            }
            try {
                if (hashEntry != null) {
                    this.modCount++;
                    removeEntry(linkEntry, iHashIndex, hashEntry2);
                    reuseEntry(linkEntry, i, i2, obj, obj2);
                    addEntry(linkEntry, i);
                    return;
                }
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("Entry.next=null, data[removeIndex]=");
                stringBuffer.append(this.data[iHashIndex]);
                stringBuffer.append(" previous=");
                stringBuffer.append(hashEntry2);
                stringBuffer.append(" key=");
                stringBuffer.append(obj);
                stringBuffer.append(" value=");
                stringBuffer.append(obj2);
                stringBuffer.append(" size=");
                stringBuffer.append(this.size);
                stringBuffer.append(" maxSize=");
                stringBuffer.append(this.maxSize);
                stringBuffer.append(" Please check that your keys are immutable, and that you have used synchronization properly.");
                stringBuffer.append(" If so, then please report this to commons-dev@jakarta.apache.org as a bug.");
                throw new IllegalStateException(stringBuffer.toString());
            } catch (NullPointerException unused) {
            }
        } catch (NullPointerException unused2) {
            i = linkEntry;
            linkEntry = this;
        }
        ?? stringBuffer2 = new StringBuffer("NPE, entry=");
        stringBuffer2.append(i);
        stringBuffer2.append(" entryIsHeader=");
        stringBuffer2.append(i == linkEntry.header);
        stringBuffer2.append(" key=");
        stringBuffer2.append(obj);
        stringBuffer2.append(" value=");
        stringBuffer2.append(obj2);
        stringBuffer2.append(" size=");
        stringBuffer2.append(linkEntry.size);
        stringBuffer2.append(" maxSize=");
        stringBuffer2.append(linkEntry.maxSize);
        stringBuffer2.append(" Please check that your keys are immutable, and that you have used synchronization properly. If so, then please report this to commons-dev@jakarta.apache.org as a bug.");
        throw new IllegalStateException(stringBuffer2.toString());
    }

    @Override // org.apache.commons.collections.map.AbstractHashedMap
    public void updateEntry(AbstractHashedMap.HashEntry hashEntry, Object obj) {
        moveToMRU((AbstractLinkedMap.LinkEntry) hashEntry);
        hashEntry.setValue(obj);
    }

    public LRUMap(int i) {
        this(i, 0.75f);
    }

    public LRUMap(int i, boolean z) {
        this(i, 0.75f, z);
    }

    public LRUMap(int i, float f) {
        this(i, f, false);
    }

    public LRUMap(int i, float f, boolean z) {
        super(i < 1 ? 16 : i, f);
        if (i >= 1) {
            this.maxSize = i;
            this.scanUntilRemovable = z;
            return;
        }
        throw new IllegalArgumentException("LRUMap max size must be greater than 0");
    }

    public LRUMap(Map map) {
        this(map, false);
    }

    public LRUMap(Map map, boolean z) {
        this(map.size(), 0.75f, z);
        putAll(map);
    }
}
