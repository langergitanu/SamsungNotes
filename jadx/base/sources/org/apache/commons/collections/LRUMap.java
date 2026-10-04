package org.apache.commons.collections;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class LRUMap extends SequencedHashMap implements Externalizable {
    private static final long serialVersionUID = 2197433140769957051L;
    private int maximumSize;

    public LRUMap() {
        this(100);
    }

    @Override // org.apache.commons.collections.SequencedHashMap, java.util.Map
    public Object get(Object obj) {
        if (!containsKey(obj)) {
            return null;
        }
        Object objRemove = remove(obj);
        super.put(obj, objRemove);
        return objRemove;
    }

    public int getMaximumSize() {
        return this.maximumSize;
    }

    @Override // org.apache.commons.collections.SequencedHashMap, java.util.Map
    public Object put(Object obj, Object obj2) {
        if (size() >= this.maximumSize && !containsKey(obj)) {
            removeLRU();
        }
        return super.put(obj, obj2);
    }

    @Override // org.apache.commons.collections.SequencedHashMap, java.io.Externalizable
    public void readExternal(ObjectInput objectInput) throws IOException {
        this.maximumSize = objectInput.readInt();
        int i = objectInput.readInt();
        for (int i2 = 0; i2 < i; i2++) {
            put(objectInput.readObject(), objectInput.readObject());
        }
    }

    public void removeLRU() {
        Object firstKey = getFirstKey();
        Object obj = super.get(firstKey);
        remove(firstKey);
        processRemovedLRU(firstKey, obj);
    }

    public void setMaximumSize(int i) {
        this.maximumSize = i;
        while (size() > i) {
            removeLRU();
        }
    }

    @Override // org.apache.commons.collections.SequencedHashMap, java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeInt(this.maximumSize);
        objectOutput.writeInt(size());
        for (Object obj : keySet()) {
            objectOutput.writeObject(obj);
            objectOutput.writeObject(super.get(obj));
        }
    }

    public LRUMap(int i) {
        super(i);
        this.maximumSize = i;
    }

    public void processRemovedLRU(Object obj, Object obj2) {
    }
}
