package com.samsung.android.support.senl.p148nt.app.labs.collect;

import android.content.Context;
import android.content.SharedPreferences;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabaseManager;
import com.samsung.android.support.senl.p148nt.model.collector.manager.CollectTaskManager;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class CollectStatus {
    private static final String COLLECT_LOGGING_ENABLED = "CollectLoggingEnabled";
    private static final String PREF_NAME = "CollectLogging";

    public static void checkCollectStatus(Context context) {
        ToastHandler.show(context, "Is Running: " + CollectTaskManager.getInstance().isRunning() + "\nAll searchable notes : " + NotesDatabaseManager.getInstance().getMainListDocumentDataDao().getAllNoteCount(0, false) + "\nRemaining recognition notes : " + NotesDatabaseManager.getInstance().getRetryDao().getCountInState(1), 1);
    }

    private static SharedPreferences getSharedPreference(Context context) {
        return context.getSharedPreferences(PREF_NAME, 0);
    }

    public static void setCollectLogging(Context context, boolean z) {
        getSharedPreference(context).edit().putBoolean(COLLECT_LOGGING_ENABLED, z).apply();
    }
}
