package com.microsoft.identity.common.internal.util;

import com.microsoft.identity.common.java.cache.IMultiTypeNameValueStorage;
import com.microsoft.identity.common.java.interfaces.INameValueStorage;
import java.util.Set;
import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public abstract class AbstractSharedPrefNameValueStorage<T> implements INameValueStorage<T> {
    protected IMultiTypeNameValueStorage mManager;

    public AbstractSharedPrefNameValueStorage(IMultiTypeNameValueStorage iMultiTypeNameValueStorage) {
        this.mManager = iMultiTypeNameValueStorage;
    }

    @Override // com.microsoft.identity.common.java.interfaces.INameValueStorage
    public void clear() {
        this.mManager.clear();
    }

    @Override // com.microsoft.identity.common.java.interfaces.INameValueStorage
    @NonNull
    public Set<String> keySet() {
        return this.mManager.getAll().keySet();
    }

    @Override // com.microsoft.identity.common.java.interfaces.INameValueStorage
    public void remove(@NonNull String str) {
        if (str == null) {
            throw new NullPointerException("name is marked non-null but is null");
        }
        this.mManager.remove(str);
    }
}
