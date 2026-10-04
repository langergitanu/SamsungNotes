package org.apache.commons.collections4.multimap;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.collections4.MultiValuedMap;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class ArrayListValuedLinkedHashMap<K, V> extends AbstractListValuedMap<K, V> implements Serializable {
    private static final int DEFAULT_INITIAL_LIST_CAPACITY = 3;
    private static final int DEFAULT_INITIAL_MAP_CAPACITY = 16;
    private static final long serialVersionUID = 20241014;
    private final int initialListCapacity;

    public ArrayListValuedLinkedHashMap() {
        this(16, 3);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        setMap(new LinkedHashMap());
        doReadObject(objectInputStream);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        doWriteObject(objectOutputStream);
    }

    public void trimToSize() {
        Iterator<List<V>> it = getMap().values().iterator();
        while (it.hasNext()) {
            ((ArrayList) it.next()).trimToSize();
        }
    }

    public ArrayListValuedLinkedHashMap(int i) {
        this(16, i);
    }

    public ArrayListValuedLinkedHashMap(int i, int i2) {
        super(new LinkedHashMap(i));
        this.initialListCapacity = i2;
    }

    @Override // org.apache.commons.collections4.multimap.AbstractListValuedMap, org.apache.commons.collections4.multimap.AbstractMultiValuedMap
    public ArrayList<V> createCollection() {
        return new ArrayList<>(this.initialListCapacity);
    }

    public ArrayListValuedLinkedHashMap(Map<? extends K, ? extends V> map) {
        this(map.size(), 3);
        super.putAll(map);
    }

    public ArrayListValuedLinkedHashMap(MultiValuedMap<? extends K, ? extends V> multiValuedMap) {
        this(multiValuedMap.size(), 3);
        super.putAll(multiValuedMap);
    }
}
