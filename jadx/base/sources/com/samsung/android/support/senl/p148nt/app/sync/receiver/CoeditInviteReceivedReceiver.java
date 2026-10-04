package com.samsung.android.support.senl.p148nt.app.sync.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.annotation.NonNull;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.samsung.android.support.senl.p148nt.app.common.log.MainCoeditLogger;
import com.samsung.android.support.senl.p148nt.app.sync.p150ui.notification.CoeditNotificationConstants;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public abstract class CoeditInviteReceivedReceiver extends BroadcastReceiver {
    public static final String COEDIT_NOTIFICATION_GROUP_ID = "COEDIT_NOTIFICATION_GROUP_ID";
    public static final String GROUP_INVITATION_RECEIVED_INTENT_FILTER = "COEDIT_GROUP_INVITATION_RECEIVED";
    private static final String TAG = "CoeditInviteReceivedReceiver";

    public static void registerReceiver(@NonNull Context context, CoeditInviteReceivedReceiver coeditInviteReceivedReceiver) {
        MainCoeditLogger.m7250d(TAG, "registerReceiver#");
        LocalBroadcastManager.getInstance(context).registerReceiver(coeditInviteReceivedReceiver, new IntentFilter(GROUP_INVITATION_RECEIVED_INTENT_FILTER));
        LocalBroadcastManager.getInstance(context).registerReceiver(coeditInviteReceivedReceiver, new IntentFilter(CoeditNotificationConstants.COEDIT_NOTIFICATION_INTENT_FILTER));
    }

    public static void unregisterReceiver(@NonNull Context context, CoeditInviteReceivedReceiver coeditInviteReceivedReceiver) {
        MainCoeditLogger.m7250d(TAG, "unregisterReceiver#");
        LocalBroadcastManager.getInstance(context).unregisterReceiver(coeditInviteReceivedReceiver);
    }

    public abstract void onGroupInvitationReceived(Context context, Intent intent);

    public abstract void onNotificationOperated(String str);

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
        if (GROUP_INVITATION_RECEIVED_INTENT_FILTER.equals(action)) {
            onGroupInvitationReceived(context.getApplicationContext(), intent);
        } else if (CoeditNotificationConstants.COEDIT_NOTIFICATION_INTENT_FILTER.equals(action)) {
            onNotificationOperated(intent.getStringExtra(COEDIT_NOTIFICATION_GROUP_ID));
        }
    }
}
