package org.apache.commons.collections4.splitmap;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;
import java.util.Objects;
import org.apache.commons.collections4.Put;
import org.apache.commons.collections4.Transformer;
import org.apache.commons.collections4.map.LinkedMap;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class TransformedSplitMap<J, K, U, V> extends AbstractIterableGetMapDecorator<K, V> implements Put<J, U>, Serializable {
    private static final long serialVersionUID = 5966875321133456994L;
    private final Transformer<? super J, ? extends K> keyTransformer;
    private final Transformer<? super U, ? extends V> valueTransformer;

    public TransformedSplitMap(Map<K, V> map, Transformer<? super J, ? extends K> transformer, Transformer<? super U, ? extends V> transformer2) {
        super(map);
        Objects.requireNonNull(transformer, "keyTransformer");
        this.keyTransformer = transformer;
        Objects.requireNonNull(transformer2, "valueTransformer");
        this.valueTransformer = transformer2;
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        this.map = (Map) objectInputStream.readObject();
    }

    public static <J, K, U, V> TransformedSplitMap<J, K, U, V> transformingMap(Map<K, V> map, Transformer<? super J, ? extends K> transformer, Transformer<? super U, ? extends V> transformer2) {
        return new TransformedSplitMap<>(map, transformer, transformer2);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(decorated());
    }

    public V checkSetValue(U u) {
        return this.valueTransformer.apply(u);
    }

    @Override // org.apache.commons.collections4.Put
    public void clear() {
        decorated().clear();
    }

    @Override // org.apache.commons.collections4.Put
    public V put(J j, U u) {
        return decorated().put(transformKey(j), transformValue(u));
    }

    @Override // org.apache.commons.collections4.Put
    public void putAll(Map<? extends J, ? extends U> map) {
        decorated().putAll(transformMap(map));
    }

    public K transformKey(J j) {
        return this.keyTransformer.apply(j);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Map<K, V> transformMap(Map<? extends J, ? extends U> map) {
        if (map.isEmpty()) {
            return map;
        }
        LinkedMap linkedMap = new LinkedMap(map.size());
        for (Map.Entry entry : map.entrySet()) {
            linkedMap.put(transformKey(entry.getKey()), transformValue(entry.getValue()));
        }
        return linkedMap;
    }

    public V transformValue(U u) {
        return this.valueTransformer.apply(u);
    }
}
