package org.apache.commons.collections4.map;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.apache.commons.collections4.Factory;
import org.apache.commons.collections4.Transformer;
import org.apache.commons.collections4.functors.ConstantTransformer;
import org.apache.commons.collections4.functors.FactoryTransformer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class DefaultedMap<K, V> extends AbstractMapDecorator<K, V> implements Serializable {
    private static final long serialVersionUID = 19698628745827L;
    private final Transformer<? super K, ? extends V> value;

    public DefaultedMap(Map<K, V> map, Transformer<? super K, ? extends V> transformer) {
        super(map);
        Objects.requireNonNull(transformer, "defaultValueTransformer");
        this.value = transformer;
    }

    public static <K, V> DefaultedMap<K, V> defaultedMap(Map<K, V> map, Factory<? extends V> factory) {
        Objects.requireNonNull(factory, "Factory must not be null");
        return new DefaultedMap<>(map, FactoryTransformer.factoryTransformer(factory));
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        this.map = (Map) objectInputStream.readObject();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.map);
    }

    @Override // org.apache.commons.collections4.map.AbstractMapDecorator, java.util.Map, org.apache.commons.collections4.Get
    public V get(Object obj) {
        V v = this.map.get(obj);
        return (v != null || this.map.containsKey(obj)) ? v : this.value.apply(obj);
    }

    public DefaultedMap(Transformer<? super K, ? extends V> transformer) {
        this(new HashMap(), transformer);
    }

    public DefaultedMap(V v) {
        this(ConstantTransformer.constantTransformer(v));
    }

    public static <K, V> Map<K, V> defaultedMap(Map<K, V> map, Transformer<? super K, ? extends V> transformer) {
        Objects.requireNonNull(transformer, "Transformer must not be null");
        return new DefaultedMap(map, transformer);
    }

    public static <K, V> DefaultedMap<K, V> defaultedMap(Map<K, V> map, V v) {
        return new DefaultedMap<>(map, ConstantTransformer.constantTransformer(v));
    }
}
