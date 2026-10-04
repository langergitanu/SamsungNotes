package org.apache.commons.collections4.multimap;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import org.apache.commons.collections4.MultiValuedMap;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class HashSetValuedHashMap<K, V> extends AbstractSetValuedMap<K, V> implements Serializable {
    private static final int DEFAULT_INITIAL_MAP_CAPACITY = 16;
    private static final int DEFAULT_INITIAL_SET_CAPACITY = 3;
    private static final long serialVersionUID = 20151118;
    private final int initialSetCapacity;

    public HashSetValuedHashMap() {
        this(16, 3);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        setMap(new HashMap());
        doReadObject(objectInputStream);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        doWriteObject(objectOutputStream);
    }

    public HashSetValuedHashMap(int i) {
        this(16, i);
    }

    public HashSetValuedHashMap(int i, int i2) {
        super(new HashMap(i));
        this.initialSetCapacity = i2;
    }

    @Override // org.apache.commons.collections4.multimap.AbstractSetValuedMap, org.apache.commons.collections4.multimap.AbstractMultiValuedMap
    public HashSet<V> createCollection() {
        return new HashSet<>(this.initialSetCapacity);
    }

    public HashSetValuedHashMap(Map<? extends K, ? extends V> map) {
        this(map.size(), 3);
        super.putAll(map);
    }

    public HashSetValuedHashMap(MultiValuedMap<? extends K, ? extends V> multiValuedMap) {
        this(multiValuedMap.size(), 3);
        super.putAll(multiValuedMap);
    }
}
