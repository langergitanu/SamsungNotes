package org.apache.commons.collections.map;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class CaseInsensitiveMap extends AbstractHashedMap implements Serializable, Cloneable {
    private static final long serialVersionUID = -7074655917369299456L;

    public CaseInsensitiveMap() {
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
    public Object convertKey(Object obj) {
        if (obj == null) {
            return AbstractHashedMap.NULL;
        }
        char[] charArray = obj.toString().toCharArray();
        for (int length = charArray.length - 1; length >= 0; length--) {
            charArray[length] = Character.toLowerCase(Character.toUpperCase(charArray[length]));
        }
        return new String(charArray);
    }

    public CaseInsensitiveMap(int i) {
        super(i);
    }

    public CaseInsensitiveMap(int i, float f) {
        super(i, f);
    }

    public CaseInsensitiveMap(Map map) {
        super(map);
    }
}
