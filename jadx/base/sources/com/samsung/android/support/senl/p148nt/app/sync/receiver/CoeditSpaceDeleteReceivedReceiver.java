package com.samsung.android.support.senl.p148nt.app.sync.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.samsung.android.support.senl.p148nt.app.common.log.MainCoeditLogger;
import com.samsung.android.support.senl.p148nt.base.common.constants.CoeditBaseConstants;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public abstract class CoeditSpaceDeleteReceivedReceiver extends BroadcastReceiver {
    private static final String TAG = "CoeditSpaceDeleteReceivedReceiver";

    public static void registerReceiver(Context context, CoeditSpaceDeleteReceivedReceiver coeditSpaceDeleteReceivedReceiver) {
        MainCoeditLogger.m7250d(TAG, "registerReceiver#");
        LocalBroadcastManager.getInstance(context).registerReceiver(coeditSpaceDeleteReceivedReceiver, new IntentFilter(CoeditBaseConstants.SPACE_DELTE_RECEIVED_INTENT_FILTER));
    }

    public static void unregisterReceiver(Context context, CoeditSpaceDeleteReceivedReceiver coeditSpaceDeleteReceivedReceiver) {
        MainCoeditLogger.m7250d(TAG, "unregisterReceiver#");
        LocalBroadcastManager.getInstance(context).unregisterReceiver(coeditSpaceDeleteReceivedReceiver);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            MainCoeditLogger.m7250d(TAG, "onReceive intent is null");
            return;
        }
        if (context == null) {
            MainCoeditLogger.m7250d(TAG, "onReceive context is null");
            return;
        }
        String action = intent.getAction();
        if (action == null || action.isEmpty()) {
            MainCoeditLogger.m7250d(TAG, "onReceive action is null");
            return;
        }
        MainCoeditLogger.m7250d(TAG, "onReceive# ".concat(action));
        if (CoeditBaseConstants.SPACE_DELTE_RECEIVED_INTENT_FILTER.equals(action)) {
            onSpaceDeleted(intent.getStringExtra(CoeditBaseConstants.COEDIT_DELETED_GROUP_ID), intent.getStringExtra(CoeditBaseConstants.COEDIT_DELETED_GROUP_NAME), intent.getStringExtra(CoeditBaseConstants.COEDIT_DELETED_SPACE_ID));
        }
    }

    public abstract void onSpaceDeleted(String str, String str2, String str3);
}
