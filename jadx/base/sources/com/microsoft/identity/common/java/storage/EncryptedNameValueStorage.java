package com.microsoft.identity.common.java.storage;

import androidx.collection.AbstractC0622a;
import com.microsoft.identity.common.java.crypto.IKeyAccessor;
import com.microsoft.identity.common.java.crypto.KeyAccessorStringAdapter;
import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.java.interfaces.INameValueStorage;
import com.microsoft.identity.common.java.logging.Logger;
import com.microsoft.identity.common.java.util.StringUtil;
import com.microsoft.identity.common.java.util.ported.Predicate;
import edu.umd.cs.findbugs.annotations.Nullable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class EncryptedNameValueStorage<T> implements INameValueStorage<T> {
    private static final String TAG = "EncryptedNameValueStorage";

    @NonNull
    private final KeyAccessorStringAdapter mEncryptionManager;

    @NonNull
    private final INameValueStorage<String> mRawNameValueStorage;

    @NonNull
    private final IGenericTypeStringAdapter<T> mStringAdapter;

    public EncryptedNameValueStorage(@NonNull INameValueStorage<String> iNameValueStorage, @NonNull IKeyAccessor iKeyAccessor, @NonNull IGenericTypeStringAdapter<T> iGenericTypeStringAdapter) {
        if (iNameValueStorage == null) {
            throw new NullPointerException("rawNameValueStringStorage is marked non-null but is null");
        }
        if (iKeyAccessor == null) {
            throw new NullPointerException("encryptionManager is marked non-null but is null");
        }
        if (iGenericTypeStringAdapter == null) {
            throw new NullPointerException("stringAdapter is marked non-null but is null");
        }
        this.mRawNameValueStorage = iNameValueStorage;
        this.mEncryptionManager = new KeyAccessorStringAdapter(iKeyAccessor);
        this.mStringAdapter = iGenericTypeStringAdapter;
    }

    @Override // com.microsoft.identity.common.java.interfaces.INameValueStorage
    public void clear() {
        this.mRawNameValueStorage.clear();
    }

    @Override // com.microsoft.identity.common.java.interfaces.INameValueStorage
    @Nullable
    public T get(@NonNull String str) {
        if (str == null) {
            throw new NullPointerException("name is marked non-null but is null");
        }
        String strM1170p = AbstractC0622a.m1170p(TAG, ":get", new StringBuilder());
        String str2 = this.mRawNameValueStorage.get(str);
        if (StringUtil.isNullOrEmpty(str2)) {
            Logger.info(strM1170p, "Data associated to the given key is null or empty", null);
            remove(str);
            return null;
        }
        try {
            return this.mStringAdapter.adapt(this.mEncryptionManager.decrypt(str2));
        } catch (ClientException unused) {
            Logger.error(strM1170p, "Failed to read encrypted value", null);
            return null;
        }
    }

    @Override // com.microsoft.identity.common.java.interfaces.INameValueStorage
    @NonNull
    public Map<String, T> getAll() {
        Map<String, String> all = this.mRawNameValueStorage.getAll();
        HashMap map = new HashMap();
        for (Map.Entry<String, String> entry : all.entrySet()) {
            T t = get(entry.getKey());
            if (t != null) {
                map.put(entry.getKey(), t);
            }
        }
        return map;
    }

    @Override // com.microsoft.identity.common.java.interfaces.INameValueStorage
    public Iterator<Map.Entry<String, T>> getAllFilteredByKey(@NonNull Predicate<String> predicate) {
        if (predicate == null) {
            throw new NullPointerException("keyFilter is marked non-null but is null");
        }
        HashMap map = new HashMap();
        for (Map.Entry<String, T> entry : getAll().entrySet()) {
            if (predicate.test(entry.getKey())) {
                map.put(entry.getKey(), entry.getValue());
            }
        }
        return map.entrySet().iterator();
    }

    @Override // com.microsoft.identity.common.java.interfaces.INameValueStorage
    @NonNull
    public Set<String> keySet() {
        return this.mRawNameValueStorage.keySet();
    }

    @Override // com.microsoft.identity.common.java.interfaces.INameValueStorage
    public void put(@NonNull String str, @Nullable T t) {
        if (str == null) {
            throw new NullPointerException("name is marked non-null but is null");
        }
        String strM1170p = AbstractC0622a.m1170p(TAG, ":put", new StringBuilder());
        String strEncrypt = null;
        if (t == null) {
            this.mRawNameValueStorage.put(str, null);
            return;
        }
        String strAdapt = this.mStringAdapter.adapt(t);
        if (StringUtil.isNullOrEmpty(strAdapt)) {
            this.mRawNameValueStorage.put(str, strAdapt);
            return;
        }
        try {
            strEncrypt = this.mEncryptionManager.encrypt(strAdapt);
        } catch (ClientException unused) {
            Logger.error(strM1170p, "Failed to store encrypted value", null);
        }
        this.mRawNameValueStorage.put(str, strEncrypt);
    }

    @Override // com.microsoft.identity.common.java.interfaces.INameValueStorage
    public void remove(@NonNull String str) {
        if (str == null) {
            throw new NullPointerException("name is marked non-null but is null");
        }
        this.mRawNameValueStorage.remove(str);
    }
}
