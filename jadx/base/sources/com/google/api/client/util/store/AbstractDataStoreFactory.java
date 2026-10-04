package com.google.api.client.util.store;

import com.google.api.client.util.Maps;
import com.google.api.client.util.Preconditions;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public abstract class AbstractDataStoreFactory implements DataStoreFactory {
    private static final Pattern ID_PATTERN = Pattern.compile("\\w{1,30}");
    private final Lock lock = new ReentrantLock();
    private final Map<String, DataStore<? extends Serializable>> dataStoreMap = Maps.newHashMap();

    public abstract <V extends Serializable> DataStore<V> createDataStore(String str);

    @Override // com.google.api.client.util.store.DataStoreFactory
    public final <V extends Serializable> DataStore<V> getDataStore(String str) {
        Pattern pattern = ID_PATTERN;
        Preconditions.checkArgument(pattern.matcher(str).matches(), "%s does not match pattern %s", str, pattern);
        this.lock.lock();
        try {
            DataStore<V> dataStoreCreateDataStore = (DataStore) this.dataStoreMap.get(str);
            if (dataStoreCreateDataStore == null) {
                dataStoreCreateDataStore = createDataStore(str);
                this.dataStoreMap.put(str, dataStoreCreateDataStore);
            }
            return dataStoreCreateDataStore;
        } finally {
            this.lock.unlock();
        }
    }
}
