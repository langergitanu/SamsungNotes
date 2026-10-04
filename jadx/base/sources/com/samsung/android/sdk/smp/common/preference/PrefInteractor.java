package com.samsung.android.sdk.smp.common.preference;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class PrefInteractor {
    private static PrefInteractor mPrefInteractor;
    private final SharedPreferences mPref;

    private PrefInteractor(Context context) {
        this.mPref = context.getSharedPreferences("SmpPref", 0);
    }

    public static synchronized PrefInteractor getInstance(Context context) {
        try {
            if (mPrefInteractor == null) {
                mPrefInteractor = new PrefInteractor(context.getApplicationContext());
            }
        } catch (Throwable th) {
            throw th;
        }
        return mPrefInteractor;
    }

    public synchronized Boolean getBoolean(String str, boolean z) {
        if (str == null) {
            return Boolean.valueOf(z);
        }
        return Boolean.valueOf(this.mPref.getBoolean(str, z));
    }

    public synchronized Integer getInteger(String str, int i) {
        if (str == null) {
            return Integer.valueOf(i);
        }
        return Integer.valueOf(this.mPref.getInt(str, i));
    }

    public synchronized Long getLong(String str, long j) {
        if (str == null) {
            return Long.valueOf(j);
        }
        return Long.valueOf(this.mPref.getLong(str, j));
    }

    public synchronized String getString(String str, String str2) {
        if (str == null) {
            return str2;
        }
        return this.mPref.getString(str, str2);
    }

    public synchronized void putBoolean(String str, boolean z) {
        if (str == null) {
            return;
        }
        this.mPref.edit().putBoolean(str, z).apply();
    }

    public synchronized void putInteger(String str, int i) {
        if (str == null) {
            return;
        }
        this.mPref.edit().putInt(str, i).apply();
    }

    public synchronized void putLong(String str, long j) {
        if (str == null) {
            return;
        }
        this.mPref.edit().putLong(str, j).apply();
    }

    public synchronized void putString(String str, String str2) {
        if (str == null) {
            return;
        }
        this.mPref.edit().putString(str, str2).apply();
    }

    public synchronized void remove(String str) {
        this.mPref.edit().remove(str).apply();
    }
}
