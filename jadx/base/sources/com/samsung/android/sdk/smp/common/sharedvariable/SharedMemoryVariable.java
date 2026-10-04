package com.samsung.android.sdk.smp.common.sharedvariable;

import android.text.TextUtils;
import com.samsung.android.sdk.smp.common.util.SmpLog;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class SharedMemoryVariable {
    private static final String TAG = "SharedMemoryVariable";
    private static SharedMemoryVariable sSharedMemoryVariable;
    private Map<String, Set<String>> mStringSetVariables = new HashMap();
    private Map<String, Boolean> mBooleanVariables = new HashMap();
    private Map<String, Integer> mIntegerVariables = new HashMap();

    private SharedMemoryVariable() {
    }

    public static synchronized SharedMemoryVariable getInstance() {
        try {
            if (sSharedMemoryVariable == null) {
                sSharedMemoryVariable = new SharedMemoryVariable();
            }
        } catch (Throwable th) {
            throw th;
        }
        return sSharedMemoryVariable;
    }

    public synchronized boolean getBoolean(String str, boolean z) {
        Boolean bool = this.mBooleanVariables.get(str);
        if (bool == null) {
            return z;
        }
        return bool.booleanValue();
    }

    public synchronized int getInteger(String str, int i) {
        Integer num = this.mIntegerVariables.get(str);
        if (num == null) {
            return i;
        }
        return num.intValue();
    }

    public synchronized Set<String> getStringSet(String str) {
        if (TextUtils.isEmpty(str)) {
            SmpLog.m6494e(TAG, "getStringSet Error. key null");
            return new HashSet();
        }
        if (this.mStringSetVariables.containsKey(str)) {
            return this.mStringSetVariables.get(str);
        }
        return new HashSet();
    }

    public synchronized void putBoolean(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            SmpLog.m6494e(TAG, "putBooleanSet Error. key null");
        } else {
            this.mBooleanVariables.put(str, Boolean.valueOf(z));
        }
    }

    public synchronized void putInteger(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            SmpLog.m6494e(TAG, "putInteger Error. key null");
        } else {
            this.mIntegerVariables.put(str, Integer.valueOf(i));
        }
    }

    public synchronized void putStringSet(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            SmpLog.m6494e(TAG, "putStringSet Error. key null");
            return;
        }
        Set<String> hashSet = this.mStringSetVariables.get(str);
        if (hashSet == null) {
            hashSet = new HashSet<>();
        }
        hashSet.add(str2);
        this.mStringSetVariables.put(str, hashSet);
    }

    public synchronized void removeStringSet(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            SmpLog.m6494e(TAG, "removeStringSet Error. key null");
            return;
        }
        Set<String> set = this.mStringSetVariables.get(str);
        if (set != null) {
            set.remove(str2);
        }
    }
}
