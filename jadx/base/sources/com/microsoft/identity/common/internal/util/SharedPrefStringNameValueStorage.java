package com.microsoft.identity.common.internal.util;

import com.microsoft.identity.common.java.cache.IMultiTypeNameValueStorage;
import com.microsoft.identity.common.java.util.ported.Predicate;
import java.util.Iterator;
import java.util.Map;
import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class SharedPrefStringNameValueStorage extends AbstractSharedPrefNameValueStorage<String> {
    public SharedPrefStringNameValueStorage(IMultiTypeNameValueStorage iMultiTypeNameValueStorage) {
        super(iMultiTypeNameValueStorage);
    }

    @Override // com.microsoft.identity.common.java.interfaces.INameValueStorage
    @NonNull
    public Map<String, String> getAll() {
        return this.mManager.getAll();
    }

    @Override // com.microsoft.identity.common.java.interfaces.INameValueStorage
    public Iterator<Map.Entry<String, String>> getAllFilteredByKey(Predicate<String> predicate) {
        return this.mManager.getAllFilteredByKey(predicate);
    }

    @Override // com.microsoft.identity.common.java.interfaces.INameValueStorage
    public String get(@NonNull String str) {
        if (str != null) {
            return this.mManager.getString(str);
        }
        throw new NullPointerException("name is marked non-null but is null");
    }

    @Override // com.microsoft.identity.common.java.interfaces.INameValueStorage
    public void put(@NonNull String str, String str2) {
        if (str == null) {
            throw new NullPointerException("name is marked non-null but is null");
        }
        this.mManager.putString(str, str2);
    }
}
