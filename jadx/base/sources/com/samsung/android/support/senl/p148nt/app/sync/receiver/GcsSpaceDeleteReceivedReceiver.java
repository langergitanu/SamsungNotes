package com.samsung.android.support.senl.p148nt.app.sync.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public abstract class GcsSpaceDeleteReceivedReceiver extends BroadcastReceiver {
    public static final String GCS_DELETED_GROUP_ID = "GCS_DELETED_GROUP_ID";
    public static final String GCS_DELETED_GROUP_NAME = "GCS_DELETED_GROUP_NAME";
    public static final String SPACE_DELTE_RECEIVED_INTENT_FILTER = "GCS_SPACE_DELTE_RECEIVED_INTENT_FILTER";
    private static final String TAG = "GcsSpaceDeleteReceivedReceiver";

    public static void registerReceiver(Context context, GcsSpaceDeleteReceivedReceiver gcsSpaceDeleteReceivedReceiver) {
        MainLogger.m7254d(TAG, "registerReceiver#");
        LocalBroadcastManager.getInstance(context).registerReceiver(gcsSpaceDeleteReceivedReceiver, new IntentFilter(SPACE_DELTE_RECEIVED_INTENT_FILTER));
    }

    public static void unregisterReceiver(Context context, GcsSpaceDeleteReceivedReceiver gcsSpaceDeleteReceivedReceiver) {
        MainLogger.m7254d(TAG, "unregisterReceiver#");
        LocalBroadcastManager.getInstance(context).unregisterReceiver(gcsSpaceDeleteReceivedReceiver);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            MainLogger.m7254d(TAG, "onReceive intent is null");
            return;
        }
        if (context == null) {
            MainLogger.m7254d(TAG, "onReceive context is null");
            return;
        }
        String action = intent.getAction();
        if (action == null || action.isEmpty()) {
            MainLogger.m7254d(TAG, "onReceive action is null");
            return;
        }
        MainLogger.m7254d(TAG, "onReceive# ".concat(action));
        if (SPACE_DELTE_RECEIVED_INTENT_FILTER.equals(action)) {
            onSpaceDeleted(intent.getStringExtra(GCS_DELETED_GROUP_ID), intent.getStringExtra(GCS_DELETED_GROUP_NAME));
        }
    }

    public abstract void onSpaceDeleted(String str, String str2);
}
