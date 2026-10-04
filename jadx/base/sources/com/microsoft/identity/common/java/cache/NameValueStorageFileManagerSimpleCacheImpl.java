package com.microsoft.identity.common.java.cache;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import com.google.android.gms.common.data.AbstractC4539a;
import com.google.gson.Gson;
import com.microsoft.identity.common.java.interfaces.INameValueStorage;
import com.microsoft.identity.common.java.interfaces.IPlatformComponents;
import com.microsoft.identity.common.java.logging.Logger;
import com.microsoft.identity.common.java.util.StringUtil;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public abstract class NameValueStorageFileManagerSimpleCacheImpl<T> implements ISimpleCache<T>, IListTypeToken {
    private static final String EMTPY_ARRAY = "[]";
    private static final String TAG = "NameValueStorageFileManagerSimpleCacheImpl";
    private static final String TIMING_TAG = "execWithTiming";
    private final IPlatformComponents mComponents;
    private final boolean mForceReinsertionOfDuplicates;
    private final Gson mGson;
    private final String mKeySingleEntry;
    private final INameValueStorage<String> mStorage;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface NamedRunnable<V> extends Callable<V> {
        String getName();
    }

    public NameValueStorageFileManagerSimpleCacheImpl(@NonNull IPlatformComponents iPlatformComponents, @NonNull String str, @NonNull String str2) {
        this(iPlatformComponents, str, str2, false);
        if (iPlatformComponents == null) {
            throw new NullPointerException("components is marked non-null but is null");
        }
        if (str == null) {
            throw new NullPointerException("name is marked non-null but is null");
        }
        if (str2 == null) {
            throw new NullPointerException("singleKey is marked non-null but is null");
        }
    }

    private <V> V execWithTiming(@NonNull NamedRunnable<V> namedRunnable) {
        if (namedRunnable == null) {
            throw new NullPointerException("runnable is marked non-null but is null");
        }
        long nanosecondTime = this.mComponents.getPlatformUtil().getNanosecondTime();
        try {
            try {
                return namedRunnable.call();
            } catch (Exception e) {
                if (e instanceof InterruptedException) {
                    Thread.currentThread().interrupt();
                }
                StringBuilder sb = new StringBuilder();
                String str = TAG;
                sb.append(str);
                sb.append(TIMING_TAG);
                Logger.error(sb.toString(), "Error during operation", e);
                long nanosecondTime2 = this.mComponents.getPlatformUtil().getNanosecondTime() - nanosecondTime;
                Logger.verbose(AbstractC0541b.m756B(str, TIMING_TAG), namedRunnable.getName() + " finished in: " + nanosecondTime2 + " " + TimeUnit.NANOSECONDS.name());
                return null;
            }
        } finally {
            long nanosecondTime3 = this.mComponents.getPlatformUtil().getNanosecondTime() - nanosecondTime;
            Logger.verbose(AbstractC0622a.m1170p(TAG, TIMING_TAG, new StringBuilder()), namedRunnable.getName() + " finished in: " + nanosecondTime3 + " " + TimeUnit.NANOSECONDS.name());
        }
    }

    @Override // com.microsoft.identity.common.java.cache.ISimpleCache
    public boolean clear() {
        return ((Boolean) execWithTiming(new NamedRunnable<Boolean>() { // from class: com.microsoft.identity.common.java.cache.NameValueStorageFileManagerSimpleCacheImpl.4
            @Override // com.microsoft.identity.common.java.cache.NameValueStorageFileManagerSimpleCacheImpl.NamedRunnable
            public String getName() {
                return "clear";
            }

            @Override // java.util.concurrent.Callable
            public Boolean call() {
                NameValueStorageFileManagerSimpleCacheImpl.this.mStorage.clear();
                return Boolean.TRUE;
            }
        })).booleanValue();
    }

    @Override // com.microsoft.identity.common.java.cache.ISimpleCache
    public List<T> getAll() {
        return (List) execWithTiming(new NamedRunnable<List<T>>() { // from class: com.microsoft.identity.common.java.cache.NameValueStorageFileManagerSimpleCacheImpl.3
            @Override // com.microsoft.identity.common.java.cache.NameValueStorageFileManagerSimpleCacheImpl.NamedRunnable
            public String getName() {
                return "getAll";
            }

            @Override // java.util.concurrent.Callable
            public List<T> call() {
                String str = (String) NameValueStorageFileManagerSimpleCacheImpl.this.mStorage.get(NameValueStorageFileManagerSimpleCacheImpl.this.mKeySingleEntry);
                if (StringUtil.isNullOrEmpty(str)) {
                    str = "[]";
                }
                return (List) NameValueStorageFileManagerSimpleCacheImpl.this.mGson.fromJson(str, NameValueStorageFileManagerSimpleCacheImpl.this.getListTypeToken());
            }
        });
    }

    @Override // com.microsoft.identity.common.java.cache.ISimpleCache
    public boolean insert(final T t) {
        return ((Boolean) execWithTiming(new NamedRunnable<Boolean>() { // from class: com.microsoft.identity.common.java.cache.NameValueStorageFileManagerSimpleCacheImpl.1
            @Override // com.microsoft.identity.common.java.cache.NameValueStorageFileManagerSimpleCacheImpl.NamedRunnable
            public String getName() {
                return "insert";
            }

            @Override // java.util.concurrent.Callable
            public Boolean call() {
                HashSet hashSet = new HashSet(NameValueStorageFileManagerSimpleCacheImpl.this.getAll());
                if (NameValueStorageFileManagerSimpleCacheImpl.this.mForceReinsertionOfDuplicates) {
                    hashSet.remove(t);
                }
                hashSet.add(t);
                NameValueStorageFileManagerSimpleCacheImpl.this.mStorage.put(NameValueStorageFileManagerSimpleCacheImpl.this.mKeySingleEntry, NameValueStorageFileManagerSimpleCacheImpl.this.mGson.toJson(hashSet));
                return Boolean.TRUE;
            }
        })).booleanValue();
    }

    @Override // com.microsoft.identity.common.java.cache.ISimpleCache
    public boolean remove(final T t) {
        return ((Boolean) execWithTiming(new NamedRunnable<Boolean>() { // from class: com.microsoft.identity.common.java.cache.NameValueStorageFileManagerSimpleCacheImpl.2
            @Override // com.microsoft.identity.common.java.cache.NameValueStorageFileManagerSimpleCacheImpl.NamedRunnable
            public String getName() {
                return "remove";
            }

            @Override // java.util.concurrent.Callable
            public Boolean call() {
                HashSet hashSet = new HashSet(NameValueStorageFileManagerSimpleCacheImpl.this.getAll());
                hashSet.remove(t);
                NameValueStorageFileManagerSimpleCacheImpl.this.mStorage.put(NameValueStorageFileManagerSimpleCacheImpl.this.mKeySingleEntry, NameValueStorageFileManagerSimpleCacheImpl.this.mGson.toJson(hashSet));
                return Boolean.TRUE;
            }
        })).booleanValue();
    }

    public NameValueStorageFileManagerSimpleCacheImpl(@NonNull IPlatformComponents iPlatformComponents, @NonNull String str, @NonNull String str2, boolean z) {
        this.mGson = new Gson();
        if (iPlatformComponents == null) {
            throw new NullPointerException("components is marked non-null but is null");
        }
        if (str == null) {
            throw new NullPointerException("name is marked non-null but is null");
        }
        if (str2 != null) {
            AbstractC4539a.m3216z(new StringBuilder(), TAG, "::ctor", "Init");
            this.mComponents = iPlatformComponents;
            this.mStorage = iPlatformComponents.getStorageSupplier().getUnencryptedNameValueStore(str, String.class);
            this.mKeySingleEntry = str2;
            this.mForceReinsertionOfDuplicates = z;
            return;
        }
        throw new NullPointerException("singleKey is marked non-null but is null");
    }
}
