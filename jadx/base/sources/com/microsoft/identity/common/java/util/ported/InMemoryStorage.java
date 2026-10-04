package com.microsoft.identity.common.java.util.ported;

import com.microsoft.identity.common.java.interfaces.INameValueStorage;
import edu.umd.cs.findbugs.annotations.Nullable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class InMemoryStorage<T> implements INameValueStorage<T> {
    private final Map<String, T> mMap = new ConcurrentHashMap();

    @Override // com.microsoft.identity.common.java.interfaces.INameValueStorage
    public void clear() {
        this.mMap.clear();
    }

    @Override // com.microsoft.identity.common.java.interfaces.INameValueStorage
    @Nullable
    public T get(@NonNull String str) {
        if (str != null) {
            return this.mMap.get(str);
        }
        throw new NullPointerException("key is marked non-null but is null");
    }

    @Override // com.microsoft.identity.common.java.interfaces.INameValueStorage
    @NonNull
    public Map<String, T> getAll() {
        return this.mMap;
    }

    @Override // com.microsoft.identity.common.java.interfaces.INameValueStorage
    public Iterator<Map.Entry<String, T>> getAllFilteredByKey(Predicate<String> predicate) {
        HashMap map = new HashMap();
        for (Map.Entry<String, T> entry : this.mMap.entrySet()) {
            if (predicate.test(entry.getKey())) {
                map.put(entry.getKey(), entry.getValue());
            }
        }
        return map.entrySet().iterator();
    }

    @Override // com.microsoft.identity.common.java.interfaces.INameValueStorage
    public Set<String> keySet() {
        return this.mMap.keySet();
    }

    @Override // com.microsoft.identity.common.java.interfaces.INameValueStorage
    public void put(@NonNull String str, @Nullable T t) {
        if (str == null) {
            throw new NullPointerException("key is marked non-null but is null");
        }
        if (t == null) {
            this.mMap.remove(str);
        } else {
            this.mMap.put(str, t);
        }
    }

    @Override // com.microsoft.identity.common.java.interfaces.INameValueStorage
    public void remove(@NonNull String str) {
        if (str == null) {
            throw new NullPointerException("name is marked non-null but is null");
        }
        this.mMap.remove(str);
    }

    public int size() {
        return this.mMap.size();
    }
}
