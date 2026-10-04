package io.netty.util.collection;

import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public interface ByteObjectMap<V> extends Map<Byte, V> {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface PrimitiveEntry<V> {
        byte key();

        void setValue(V v);

        V value();
    }

    boolean containsKey(byte b);

    Iterable<PrimitiveEntry<V>> entries();

    V get(byte b);

    V put(byte b, V v);

    V remove(byte b);
}
