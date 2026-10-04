package com.samsung.android.support.senl.p148nt.app.sync.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.samsung.android.support.senl.p148nt.app.common.log.MainCoeditLogger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public abstract class CoeditGroupOwnerDelegationReceivedReceiver extends BroadcastReceiver {
    public static final String COEDIT_DELEGATION_GROUP_ID = "COEDIT_DELEGATION_GROUP_ID";
    public static final String GROUP_OWNER_DELEGATION_RECEIVED_INTENT_FILTER = "COEDIT_GROUP_OWNER_DELEGATION_RECEIVED_INTENT_FILTER";
    private static final String TAG = "CoeditGroupOwnerDelegationReceivedReceiver";

    public static void registerReceiver(Context context, CoeditGroupOwnerDelegationReceivedReceiver coeditGroupOwnerDelegationReceivedReceiver) {
        MainCoeditLogger.m7250d(TAG, "registerReceiver#");
        LocalBroadcastManager.getInstance(context).registerReceiver(coeditGroupOwnerDelegationReceivedReceiver, new IntentFilter(GROUP_OWNER_DELEGATION_RECEIVED_INTENT_FILTER));
    }

    public static void unregisterReceiver(Context context, CoeditGroupOwnerDelegationReceivedReceiver coeditGroupOwnerDelegationReceivedReceiver) {
        MainCoeditLogger.m7250d(TAG, "unregisterReceiver#");
        LocalBroadcastManager.getInstance(context).unregisterReceiver(coeditGroupOwnerDelegationReceivedReceiver);
    }

    public abstract void onOwnerDelegated(String str);

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
        if (GROUP_OWNER_DELEGATION_RECEIVED_INTENT_FILTER.equals(action)) {
            onOwnerDelegated(intent.getStringExtra(COEDIT_DELEGATION_GROUP_ID));
        }
    }
}
