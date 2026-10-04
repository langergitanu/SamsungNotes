package com.google.api.client.util.store;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public interface DataStore<V extends Serializable> {
    DataStore<V> clear();

    boolean containsKey(String str);

    boolean containsValue(V v);

    DataStore<V> delete(String str);

    V get(String str);

    DataStoreFactory getDataStoreFactory();

    String getId();

    boolean isEmpty();

    Set<String> keySet();

    DataStore<V> set(String str, V v);

    int size();

    Collection<V> values();
}
