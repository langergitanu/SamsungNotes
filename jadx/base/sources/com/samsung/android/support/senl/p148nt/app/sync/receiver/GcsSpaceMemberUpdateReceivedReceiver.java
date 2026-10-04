package com.samsung.android.support.senl.p148nt.app.sync.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public abstract class GcsSpaceMemberUpdateReceivedReceiver extends BroadcastReceiver {
    public static final String GCS_MEMBER_UPDATED_GROUP_ID = "GCS_MEMBER_UPDATED_GROUP_ID";
    public static final String SPACE_MEMBER_UPDATED_RECEIVED_INTENT_FILTER = "GCS_SPACE_MEMBER_UPDATED_RECEIVED_INTENT_FILTER";
    private static final String TAG = "GcsSpaceMemberUpdateRecivedReceiver";

    public static void registerReceiver(Context context, GcsSpaceMemberUpdateReceivedReceiver gcsSpaceMemberUpdateReceivedReceiver) {
        MainLogger.m7254d(TAG, "registerReceiver#");
        LocalBroadcastManager.getInstance(context).registerReceiver(gcsSpaceMemberUpdateReceivedReceiver, new IntentFilter(SPACE_MEMBER_UPDATED_RECEIVED_INTENT_FILTER));
    }

    public static void unregisterReceiver(Context context, GcsSpaceMemberUpdateReceivedReceiver gcsSpaceMemberUpdateReceivedReceiver) {
        MainLogger.m7254d(TAG, "unregisterReceiver#");
        LocalBroadcastManager.getInstance(context).unregisterReceiver(gcsSpaceMemberUpdateReceivedReceiver);
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
        if (SPACE_MEMBER_UPDATED_RECEIVED_INTENT_FILTER.equals(action)) {
            onSpaceMemberUpdated(intent.getStringExtra(GCS_MEMBER_UPDATED_GROUP_ID));
        }
    }

    public abstract void onSpaceMemberUpdated(String str);
}
