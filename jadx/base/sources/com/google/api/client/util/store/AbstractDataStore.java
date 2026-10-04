package com.google.api.client.util.store;

import com.google.api.client.util.Preconditions;
import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public abstract class AbstractDataStore<V extends Serializable> implements DataStore<V> {
    private final DataStoreFactory dataStoreFactory;

    /* JADX INFO: renamed from: id */
    private final String f3253id;

    public AbstractDataStore(DataStoreFactory dataStoreFactory, String str) {
        this.dataStoreFactory = (DataStoreFactory) Preconditions.checkNotNull(dataStoreFactory);
        this.f3253id = (String) Preconditions.checkNotNull(str);
    }

    @Override // com.google.api.client.util.store.DataStore
    public boolean containsKey(String str) {
        return get(str) != null;
    }

    @Override // com.google.api.client.util.store.DataStore
    public boolean containsValue(V v) {
        return values().contains(v);
    }

    @Override // com.google.api.client.util.store.DataStore
    public DataStoreFactory getDataStoreFactory() {
        return this.dataStoreFactory;
    }

    @Override // com.google.api.client.util.store.DataStore
    public final String getId() {
        return this.f3253id;
    }

    @Override // com.google.api.client.util.store.DataStore
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // com.google.api.client.util.store.DataStore
    public int size() {
        return keySet().size();
    }
}
