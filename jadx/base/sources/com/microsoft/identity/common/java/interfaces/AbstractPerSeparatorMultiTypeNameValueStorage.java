package com.microsoft.identity.common.java.interfaces;

import com.microsoft.identity.common.java.cache.IMultiTypeNameValueStorage;
import com.microsoft.identity.common.java.util.ported.Predicate;
import edu.umd.cs.findbugs.annotations.Nullable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public abstract class AbstractPerSeparatorMultiTypeNameValueStorage<T> implements IPerSeparatorMultiTypeNameValueStorage<T> {
    @Override // com.microsoft.identity.common.java.interfaces.IPerSeparatorMultiTypeNameValueStorage
    public void clear(@NonNull T t) {
        if (t == null) {
            throw new NullPointerException("separator is marked non-null but is null");
        }
        getStoreForSeparator(t).clear();
    }

    @Override // com.microsoft.identity.common.java.interfaces.IPerSeparatorMultiTypeNameValueStorage
    @NonNull
    public Map<String, String> getAll(@NonNull T t) {
        if (t != null) {
            return getStoreForSeparator(t).getAll();
        }
        throw new NullPointerException("separator is marked non-null but is null");
    }

    @Override // com.microsoft.identity.common.java.interfaces.IPerSeparatorMultiTypeNameValueStorage
    public Iterator<Map.Entry<String, String>> getAllFilteredByKey(@NonNull T t, @NonNull Predicate<String> predicate) {
        if (t == null) {
            throw new NullPointerException("separator is marked non-null but is null");
        }
        if (predicate != null) {
            return getStoreForSeparator(t).getAllFilteredByKey(predicate);
        }
        throw new NullPointerException("keyFilter is marked non-null but is null");
    }

    @Override // com.microsoft.identity.common.java.interfaces.IPerSeparatorMultiTypeNameValueStorage
    public long getLong(@NonNull T t, @NonNull String str) {
        if (t == null) {
            throw new NullPointerException("separator is marked non-null but is null");
        }
        if (str != null) {
            return getStoreForSeparator(t).getLong(str);
        }
        throw new NullPointerException("name is marked non-null but is null");
    }

    @NonNull
    public abstract IMultiTypeNameValueStorage getStoreForSeparator(@NonNull T t);

    @Override // com.microsoft.identity.common.java.interfaces.IPerSeparatorMultiTypeNameValueStorage
    @Nullable
    public String getString(@NonNull T t, @NonNull String str) {
        if (t == null) {
            throw new NullPointerException("separator is marked non-null but is null");
        }
        if (str != null) {
            return getStoreForSeparator(t).getString(str);
        }
        throw new NullPointerException("name is marked non-null but is null");
    }

    @Override // com.microsoft.identity.common.java.interfaces.IPerSeparatorMultiTypeNameValueStorage
    @NonNull
    public Set<String> keySet(@NonNull T t) {
        if (t != null) {
            return getStoreForSeparator(t).getAll().keySet();
        }
        throw new NullPointerException("separator is marked non-null but is null");
    }

    @Override // com.microsoft.identity.common.java.interfaces.IPerSeparatorMultiTypeNameValueStorage
    public void putLong(@NonNull T t, @NonNull String str, long j) {
        if (t == null) {
            throw new NullPointerException("separator is marked non-null but is null");
        }
        if (str == null) {
            throw new NullPointerException("name is marked non-null but is null");
        }
        getStoreForSeparator(t).putLong(str, j);
    }

    @Override // com.microsoft.identity.common.java.interfaces.IPerSeparatorMultiTypeNameValueStorage
    public void putString(@NonNull T t, @NonNull String str, @Nullable String str2) {
        if (t == null) {
            throw new NullPointerException("separator is marked non-null but is null");
        }
        if (str == null) {
            throw new NullPointerException("name is marked non-null but is null");
        }
        getStoreForSeparator(t).putString(str, str2);
    }

    @Override // com.microsoft.identity.common.java.interfaces.IPerSeparatorMultiTypeNameValueStorage
    public void remove(@NonNull T t, @NonNull String str) {
        if (t == null) {
            throw new NullPointerException("separator is marked non-null but is null");
        }
        if (str == null) {
            throw new NullPointerException("name is marked non-null but is null");
        }
        getStoreForSeparator(t).remove(str);
    }
}
