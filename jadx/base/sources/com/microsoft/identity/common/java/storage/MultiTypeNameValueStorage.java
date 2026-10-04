package com.microsoft.identity.common.java.storage;

import com.microsoft.identity.common.java.cache.IMultiTypeNameValueStorage;
import com.microsoft.identity.common.java.interfaces.INameValueStorage;
import com.microsoft.identity.common.java.util.StringUtil;
import com.microsoft.identity.common.java.util.ported.Predicate;
import edu.umd.cs.findbugs.annotations.Nullable;
import java.util.Iterator;
import java.util.Map;
import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class MultiTypeNameValueStorage implements IMultiTypeNameValueStorage {
    private final INameValueStorage<String> mNameValueStringStorage;

    public MultiTypeNameValueStorage(INameValueStorage<String> iNameValueStorage) {
        this.mNameValueStringStorage = iNameValueStorage;
    }

    @Override // com.microsoft.identity.common.java.cache.IMultiTypeNameValueStorage
    public void clear() {
        this.mNameValueStringStorage.clear();
    }

    @Override // com.microsoft.identity.common.java.cache.IMultiTypeNameValueStorage
    public boolean contains(@NonNull String str) {
        if (str != null) {
            return !StringUtil.isNullOrEmpty(getString(str));
        }
        throw new NullPointerException("key is marked non-null but is null");
    }

    @Override // com.microsoft.identity.common.java.cache.IMultiTypeNameValueStorage
    public Map<String, String> getAll() {
        return this.mNameValueStringStorage.getAll();
    }

    @Override // com.microsoft.identity.common.java.cache.IMultiTypeNameValueStorage
    public Iterator<Map.Entry<String, String>> getAllFilteredByKey(@NonNull Predicate<String> predicate) {
        if (predicate != null) {
            return this.mNameValueStringStorage.getAllFilteredByKey(predicate);
        }
        throw new NullPointerException("keyFilter is marked non-null but is null");
    }

    @Override // com.microsoft.identity.common.java.cache.IMultiTypeNameValueStorage
    public long getLong(@NonNull String str) {
        if (str == null) {
            throw new NullPointerException("key is marked non-null but is null");
        }
        String str2 = this.mNameValueStringStorage.get(str);
        if (StringUtil.isNullOrEmpty(str2)) {
            return 0L;
        }
        return IGenericTypeStringAdapter.LongStringAdapter.adapt(str2).longValue();
    }

    @Override // com.microsoft.identity.common.java.cache.IMultiTypeNameValueStorage
    public String getString(@NonNull String str) {
        if (str != null) {
            return this.mNameValueStringStorage.get(str);
        }
        throw new NullPointerException("key is marked non-null but is null");
    }

    @Override // com.microsoft.identity.common.java.cache.IMultiTypeNameValueStorage
    public void putLong(@NonNull String str, long j) {
        if (str == null) {
            throw new NullPointerException("key is marked non-null but is null");
        }
        this.mNameValueStringStorage.put(str, IGenericTypeStringAdapter.LongStringAdapter.adapt(Long.valueOf(j)));
    }

    @Override // com.microsoft.identity.common.java.cache.IMultiTypeNameValueStorage
    public void putString(@NonNull String str, @Nullable String str2) {
        if (str == null) {
            throw new NullPointerException("key is marked non-null but is null");
        }
        this.mNameValueStringStorage.put(str, str2);
    }

    @Override // com.microsoft.identity.common.java.cache.IMultiTypeNameValueStorage
    public void remove(@NonNull String str) {
        if (str == null) {
            throw new NullPointerException("key is marked non-null but is null");
        }
        this.mNameValueStringStorage.remove(str);
    }
}
