package org.apache.commons.collections.map;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;
import org.apache.commons.collections.map.AbstractHashedMap;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class IdentityMap extends AbstractHashedMap implements Serializable, Cloneable {
    private static final long serialVersionUID = 2028493495224302329L;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class IdentityEntry extends AbstractHashedMap.HashEntry {
        public IdentityEntry(AbstractHashedMap.HashEntry hashEntry, int i, Object obj, Object obj2) {
            super(hashEntry, i, obj, obj2);
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
            return getKey() == entry.getKey() && getValue() == entry.getValue();
        }

        @Override // org.apache.commons.collections.map.AbstractHashedMap.HashEntry, java.util.Map.Entry
        public int hashCode() {
            return System.identityHashCode(getKey()) ^ System.identityHashCode(getValue());
        }
    }

    public IdentityMap() {
        super(16, 0.75f, 12);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        doReadObject(objectInputStream);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        doWriteObject(objectOutputStream);
    }

    @Override // org.apache.commons.collections.map.AbstractHashedMap, java.util.AbstractMap
    public Object clone() {
        return super.clone();
    }

    @Override // org.apache.commons.collections.map.AbstractHashedMap
    public AbstractHashedMap.HashEntry createEntry(AbstractHashedMap.HashEntry hashEntry, int i, Object obj, Object obj2) {
        return new IdentityEntry(hashEntry, i, obj, obj2);
    }

    @Override // org.apache.commons.collections.map.AbstractHashedMap
    public int hash(Object obj) {
        return System.identityHashCode(obj);
    }

    @Override // org.apache.commons.collections.map.AbstractHashedMap
    public boolean isEqualKey(Object obj, Object obj2) {
        return obj == obj2;
    }

    @Override // org.apache.commons.collections.map.AbstractHashedMap
    public boolean isEqualValue(Object obj, Object obj2) {
        return obj == obj2;
    }

    public IdentityMap(int i) {
        super(i);
    }

    public IdentityMap(int i, float f) {
        super(i, f);
    }

    public IdentityMap(Map map) {
        super(map);
    }
}
