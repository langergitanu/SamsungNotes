package com.samsung.android.support.senl.p148nt.model.service;

import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.model.common.log.ModelLogger;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class RestoreCacheManager {
    private static final String TAG = ModelLogger.createTag("RestoreCacheManager");
    private static final Set<String> sRestoringDocuments = new HashSet();
    private static final Map<String, Callback> sCallbacks = new HashMap();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Callback {
        void onRestored();
    }

    public static synchronized void add(@NonNull String str) {
        DataLogger.m12302d(TAG, "add, uuid: " + str);
        sRestoringDocuments.add(str);
    }

    public static synchronized boolean isRestoring(@NonNull String str) {
        return sRestoringDocuments.contains(str);
    }

    public static synchronized boolean registerCallback(@NonNull String str, @NonNull Callback callback) {
        if (!isRestoring(str)) {
            return false;
        }
        sCallbacks.put(str, callback);
        return true;
    }

    public static synchronized void remove(@NonNull String str) {
        DataLogger.m12302d(TAG, "remove, uuid: " + str);
        sRestoringDocuments.remove(str);
        Callback callbackRemove = sCallbacks.remove(str);
        if (callbackRemove != null) {
            callbackRemove.onRestored();
        }
    }
}
