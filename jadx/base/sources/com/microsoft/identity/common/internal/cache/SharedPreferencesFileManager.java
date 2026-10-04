package com.microsoft.identity.common.internal.cache;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.LruCache;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import com.microsoft.identity.common.java.cache.IMultiTypeNameValueStorage;
import com.microsoft.identity.common.java.crypto.IKeyAccessor;
import com.microsoft.identity.common.java.crypto.KeyAccessorStringAdapter;
import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.java.util.StringUtil;
import com.microsoft.identity.common.java.util.ported.Predicate;
import com.microsoft.identity.common.logging.Logger;
import java.util.AbstractMap;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class SharedPreferencesFileManager implements IMultiTypeNameValueStorage {
    private static final String TAG = "SharedPreferencesFileManager";
    private static final ConcurrentMap<String, SharedPreferencesFileManager> objectCache = new ConcurrentHashMap(16, 0.75f, 1);
    private final Object cacheLock = new Object();

    @GuardedBy("cacheLock")
    private final LruCache<String, String> fileCache = new LruCache<>(256);
    private final KeyAccessorStringAdapter mEncryptionManager;

    @GuardedBy("cacheLock")
    private final SharedPreferences mSharedPreferences;

    @VisibleForTesting
    private final String mSharedPreferencesFileName;

    public SharedPreferencesFileManager(Context context, String str, IKeyAccessor iKeyAccessor) {
        if (iKeyAccessor == null) {
            Logger.verbose(TAG, "Init: ");
        } else {
            String str2 = TAG;
            Logger.verbose(str2, "Init with storage helper:  " + str2);
        }
        this.mSharedPreferences = context.getSharedPreferences(str, 0);
        this.mSharedPreferencesFileName = str;
        if (iKeyAccessor != null) {
            this.mEncryptionManager = new KeyAccessorStringAdapter(iKeyAccessor);
        } else {
            this.mEncryptionManager = null;
        }
    }

    public static void clearSingletonCache() {
        objectCache.clear();
    }

    public static SharedPreferencesFileManager getSharedPreferences(Context context, String str, IKeyAccessor iKeyAccessor) {
        StringBuilder sbM781w = AbstractC0541b.m781w(str, "/");
        sbM781w.append(context.getPackageName());
        sbM781w.append("/0/");
        sbM781w.append(iKeyAccessor == null ? "clear" : iKeyAccessor.getClass().getCanonicalName());
        String string = sbM781w.toString();
        ConcurrentMap<String, SharedPreferencesFileManager> concurrentMap = objectCache;
        SharedPreferencesFileManager sharedPreferencesFileManager = concurrentMap.get(string);
        if (sharedPreferencesFileManager != null) {
            return sharedPreferencesFileManager;
        }
        SharedPreferencesFileManager sharedPreferencesFileManagerPutIfAbsent = concurrentMap.putIfAbsent(string, new SharedPreferencesFileManager(context, str, iKeyAccessor));
        return sharedPreferencesFileManagerPutIfAbsent == null ? concurrentMap.get(string) : sharedPreferencesFileManagerPutIfAbsent;
    }

    @Override // com.microsoft.identity.common.java.cache.IMultiTypeNameValueStorage
    public final void clear() {
        synchronized (this.cacheLock) {
            SharedPreferences.Editor editorEdit = this.mSharedPreferences.edit();
            editorEdit.clear();
            this.fileCache.evictAll();
            editorEdit.apply();
        }
    }

    @Override // com.microsoft.identity.common.java.cache.IMultiTypeNameValueStorage
    public final boolean contains(String str) {
        return !StringUtil.isNullOrEmpty(getString(str));
    }

    public boolean flushSharedPreference() {
        boolean zCommit;
        synchronized (this.cacheLock) {
            zCommit = this.mSharedPreferences.edit().commit();
        }
        return zCommit;
    }

    @Override // com.microsoft.identity.common.java.cache.IMultiTypeNameValueStorage
    public final Map<String, String> getAll() {
        Map all = this.mSharedPreferences.getAll();
        if (this.mEncryptionManager != null) {
            for (Map.Entry entry : all.entrySet()) {
                String string = getString((String) entry.getKey());
                if (!StringUtil.isNullOrEmpty(string)) {
                    entry.setValue(string);
                }
            }
        }
        return all;
    }

    @Override // com.microsoft.identity.common.java.cache.IMultiTypeNameValueStorage
    public final Iterator<Map.Entry<String, String>> getAllFilteredByKey(@NonNull Predicate<String> predicate) {
        return new Iterator<Map.Entry<String, String>>(this.mSharedPreferences.getAll(), predicate) { // from class: com.microsoft.identity.common.internal.cache.SharedPreferencesFileManager.1
            final Iterator<Map.Entry<String, String>> iterator;
            Map.Entry<String, String> nextEntry = null;
            final /* synthetic */ Map val$entries;
            final /* synthetic */ Predicate val$keyFilter;

            {
                this.val$entries = map;
                this.val$keyFilter = predicate;
                this.iterator = map.entrySet().iterator();
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                if (this.nextEntry != null) {
                    return true;
                }
                if (!this.iterator.hasNext()) {
                    return false;
                }
                do {
                    Map.Entry<String, String> next = this.iterator.next();
                    if (this.val$keyFilter.test(next.getKey())) {
                        if (SharedPreferencesFileManager.this.mEncryptionManager != null) {
                            String string = SharedPreferencesFileManager.this.getString(next.getKey());
                            if (!StringUtil.isNullOrEmpty(string)) {
                                this.nextEntry = new AbstractMap.SimpleEntry(next.getKey(), string);
                            }
                        } else {
                            this.nextEntry = next;
                        }
                    }
                    if (this.nextEntry != null) {
                        break;
                    }
                } while (this.iterator.hasNext());
                return this.nextEntry != null;
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException("Removal is not supported");
            }

            @Override // java.util.Iterator
            public Map.Entry<String, String> next() {
                if (this.nextEntry == null && !hasNext()) {
                    throw new NoSuchElementException();
                }
                Map.Entry<String, String> entry = this.nextEntry;
                this.nextEntry = null;
                return entry;
            }
        };
    }

    @Override // com.microsoft.identity.common.java.cache.IMultiTypeNameValueStorage
    public long getLong(String str) {
        String string = getString(str);
        if (StringUtil.isNullOrEmpty(string)) {
            return 0L;
        }
        return Long.parseLong(string);
    }

    public final String getSharedPreferencesFileName() {
        return this.mSharedPreferencesFileName;
    }

    @Override // com.microsoft.identity.common.java.cache.IMultiTypeNameValueStorage
    @Nullable
    public final String getString(String str) {
        String strM1170p = AbstractC0622a.m1170p(TAG, ":getString", new StringBuilder());
        synchronized (this.cacheLock) {
            try {
                String str2 = this.fileCache.get(str);
                if (str2 != null) {
                    return str2;
                }
                String string = this.mSharedPreferences.getString(str, null);
                if (StringUtil.isNullOrEmpty(string)) {
                    Logger.info(strM1170p, "Data associated to the given key is null or empty", null);
                    return null;
                }
                KeyAccessorStringAdapter keyAccessorStringAdapter = this.mEncryptionManager;
                if (keyAccessorStringAdapter == null) {
                    return string;
                }
                try {
                    return keyAccessorStringAdapter.decrypt(string);
                } catch (ClientException unused) {
                    Logger.error(strM1170p, "Failed to decrypt value", null);
                    return null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.identity.common.java.cache.IMultiTypeNameValueStorage
    public void putLong(String str, long j) {
        putString(str, String.valueOf(j));
    }

    @Override // com.microsoft.identity.common.java.cache.IMultiTypeNameValueStorage
    public final void putString(String str, String str2) {
        String strEncrypt;
        String strM1170p = AbstractC0622a.m1170p(TAG, ":putString", new StringBuilder());
        synchronized (this.cacheLock) {
            try {
                if (str2 != null) {
                    this.fileCache.put(str, str2);
                } else {
                    this.fileCache.remove(str);
                }
                SharedPreferences.Editor editorEdit = this.mSharedPreferences.edit();
                if (this.mEncryptionManager == null || StringUtil.isNullOrEmpty(str2)) {
                    editorEdit.putString(str, str2).apply();
                    return;
                }
                try {
                    strEncrypt = this.mEncryptionManager.encrypt(str2);
                } catch (ClientException unused) {
                    Logger.error(strM1170p, "Failed to store encrypted value", null);
                    strEncrypt = null;
                }
                editorEdit.putString(str, strEncrypt).apply();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.identity.common.java.cache.IMultiTypeNameValueStorage
    public void remove(String str) {
        String str2 = TAG + ":remove";
        Logger.info(str2, "Removing cache key");
        synchronized (this.cacheLock) {
            this.fileCache.remove(str);
            SharedPreferences.Editor editorEdit = this.mSharedPreferences.edit();
            editorEdit.remove(str);
            editorEdit.apply();
        }
        Logger.infoPII(str2, "Removed cache key [" + str + "]");
    }
}
