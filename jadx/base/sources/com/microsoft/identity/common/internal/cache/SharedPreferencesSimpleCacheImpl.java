package com.microsoft.identity.common.internal.cache;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import androidx.collection.AbstractC0622a;
import com.google.gson.Gson;
import com.microsoft.identity.common.java.cache.IListTypeToken;
import com.microsoft.identity.common.java.cache.ISimpleCache;
import com.microsoft.identity.common.logging.Logger;
import java.util.HashSet;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public abstract class SharedPreferencesSimpleCacheImpl<T> implements ISimpleCache<T>, IListTypeToken {
    private static final String EMPTY_ARRAY = "[]";
    private static final String TAG = "SharedPreferencesSimpleCacheImpl";
    private final Gson mGson = new Gson();
    private final String mKeySingleEntry;
    private final SharedPreferences mSharedPrefs;

    public SharedPreferencesSimpleCacheImpl(@NonNull Context context, @NonNull String str, @NonNull String str2) {
        Logger.verbose(TAG + "::constructor", "Init");
        this.mSharedPrefs = context.getSharedPreferences(str, 0);
        this.mKeySingleEntry = str2;
    }

    @Override // com.microsoft.identity.common.java.cache.ISimpleCache
    public boolean clear() {
        String strM1170p = AbstractC0622a.m1170p(TAG, ":clear", new StringBuilder());
        boolean zCommit = this.mSharedPrefs.edit().clear().commit();
        if (zCommit) {
            Logger.verbose(strM1170p, "Cache successfully cleared.");
            return zCommit;
        }
        Logger.warn(strM1170p, "Failed to clear cache.");
        return zCommit;
    }

    @Override // com.microsoft.identity.common.java.cache.ISimpleCache
    public List<T> getAll() {
        String strM1170p = AbstractC0622a.m1170p(TAG, ":getAll", new StringBuilder());
        List<T> list = (List) this.mGson.fromJson(this.mSharedPrefs.getString(this.mKeySingleEntry, "[]"), getListTypeToken());
        Logger.verbose(strM1170p, "Found [" + list.size() + "] cache entries.");
        return list;
    }

    @Override // com.microsoft.identity.common.java.cache.ISimpleCache
    public boolean insert(T t) {
        String strM1170p = AbstractC0622a.m1170p(TAG, ":insert", new StringBuilder());
        HashSet hashSet = new HashSet(getAll());
        Logger.verbose(strM1170p, "Existing metadata contained [" + hashSet.size() + "] elements.");
        hashSet.add(t);
        Logger.verbose(strM1170p, "New metadata set size: [" + hashSet.size() + "]");
        String json = this.mGson.toJson(hashSet);
        Logger.verbose(strM1170p, "Writing cache entry.");
        boolean zCommit = this.mSharedPrefs.edit().putString(this.mKeySingleEntry, json).commit();
        if (zCommit) {
            Logger.verbose(strM1170p, "Cache successfully updated.");
            return zCommit;
        }
        Logger.warn(strM1170p, "Error writing to cache.");
        return zCommit;
    }

    @Override // com.microsoft.identity.common.java.cache.ISimpleCache
    public boolean remove(T t) {
        String strM1170p = AbstractC0622a.m1170p(TAG, ":remove", new StringBuilder());
        HashSet hashSet = new HashSet(getAll());
        Logger.verbose(strM1170p, "Existing metadata contained [" + hashSet.size() + "] elements.");
        boolean zRemove = hashSet.remove(t);
        Logger.verbose(strM1170p, "New metadata set size: [" + hashSet.size() + "]");
        if (!zRemove) {
            Logger.warn(strM1170p, "Nothing to delete -- cache entry is missing!");
            return true;
        }
        String json = this.mGson.toJson(hashSet);
        Logger.verbose(strM1170p, "Writing new cache values...");
        boolean zCommit = this.mSharedPrefs.edit().putString(this.mKeySingleEntry, json).commit();
        Logger.verbose(strM1170p, "Updated cache contents written? [" + zCommit + "]");
        return zCommit;
    }
}
