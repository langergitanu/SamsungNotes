package com.samsung.context.sdk.samsunganalytics.internal.util;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class DeleteApiCallChecker {
    private static final int MAX_DELETE_CALL_COUNT = 5;
    private int apiCallCount;
    private final Context context;
    private long lastResetTimeMs;

    public DeleteApiCallChecker(Context context) {
        this.context = context;
    }

    public void increaseCount() {
        SharedPreferences.Editor editorEdit = Preferences.getPreferences(this.context).edit();
        int i = this.apiCallCount + 1;
        this.apiCallCount = i;
        editorEdit.putInt(Preferences.PREFS_KEY_DELETE_COUNT, i).apply();
    }

    public boolean isNotOverLimit() {
        SharedPreferences preferences = Preferences.getPreferences(this.context);
        if (this.lastResetTimeMs == 0) {
            this.lastResetTimeMs = preferences.getLong(Preferences.PREFS_KEY_DELETE_COUNT_RESET_TIME, 0L);
            this.apiCallCount = preferences.getInt(Preferences.PREFS_KEY_DELETE_COUNT, 0);
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (TimeUnit.DAYS.toMillis(1L) + this.lastResetTimeMs >= jCurrentTimeMillis) {
            boolean z = this.apiCallCount < 5;
            if (!z) {
                Debug.LogI("SDK operation was stopped for 24 hours due to excessive delete API calls");
            }
            return z;
        }
        Debug.LogI("Initialize delete api call counting");
        this.lastResetTimeMs = jCurrentTimeMillis;
        this.apiCallCount = 0;
        SharedPreferences.Editor editorEdit = preferences.edit();
        editorEdit.putInt(Preferences.PREFS_KEY_DELETE_COUNT, this.apiCallCount);
        editorEdit.putLong(Preferences.PREFS_KEY_DELETE_COUNT_RESET_TIME, this.lastResetTimeMs).apply();
        return true;
    }
}
