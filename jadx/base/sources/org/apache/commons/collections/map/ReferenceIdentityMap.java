package org.apache.commons.collections.map;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.ref.Reference;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class ReferenceIdentityMap extends AbstractReferenceMap implements Serializable {
    private static final long serialVersionUID = -1266190134568365852L;

    public ReferenceIdentityMap() {
        super(0, 1, 16, 0.75f, false);
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
    public int hash(Object obj) {
        return System.identityHashCode(obj);
    }

    @Override // org.apache.commons.collections.map.AbstractReferenceMap
    public int hashEntry(Object obj, Object obj2) {
        return System.identityHashCode(obj) ^ System.identityHashCode(obj2);
    }

    @Override // org.apache.commons.collections.map.AbstractReferenceMap, org.apache.commons.collections.map.AbstractHashedMap
    public boolean isEqualKey(Object obj, Object obj2) {
        if (this.keyType > 0) {
            obj2 = ((Reference) obj2).get();
        }
        return obj == obj2;
    }

    @Override // org.apache.commons.collections.map.AbstractHashedMap
    public boolean isEqualValue(Object obj, Object obj2) {
        return obj == obj2;
    }

    public ReferenceIdentityMap(int i, int i2) {
        super(i, i2, 16, 0.75f, false);
    }

    public ReferenceIdentityMap(int i, int i2, boolean z) {
        super(i, i2, 16, 0.75f, z);
    }

    public ReferenceIdentityMap(int i, int i2, int i4, float f) {
        super(i, i2, i4, f, false);
    }

    public ReferenceIdentityMap(int i, int i2, int i4, float f, boolean z) {
        super(i, i2, i4, f, z);
    }
}
