package com.samsung.android.app.notes.sync.contentsharing.sessession;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public abstract class SesInviteReceivedReceiver extends BroadcastReceiver {
    public static final String GROUP_INVITATION_RECEIVED_INTENT_FILTER = "GROUP_INVITATION_RECEIVED";
    private static final String TAG = "SesInviteReceivedReceiver";

    public static void registerReceiver(Context context, SesInviteReceivedReceiver sesInviteReceivedReceiver) {
        Debugger.m8607d(TAG, "registerReceiver");
        LocalBroadcastManager.getInstance(context).registerReceiver(sesInviteReceivedReceiver, new IntentFilter(GROUP_INVITATION_RECEIVED_INTENT_FILTER));
    }

    public static void unregisterReceiver(Context context, SesInviteReceivedReceiver sesInviteReceivedReceiver) {
        Debugger.m8607d(TAG, "unregisterReceiver");
        LocalBroadcastManager.getInstance(context).unregisterReceiver(sesInviteReceivedReceiver);
    }

    public abstract void onGroupInvitationReceived();

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Debugger.m8607d(TAG, "onReceive");
        if (intent == null) {
            Debugger.m8607d(TAG, "onReceive intent is null");
            return;
        }
        if (context == null) {
            Debugger.m8607d(TAG, "onReceive context is null");
            return;
        }
        String action = intent.getAction();
        if (action == null || action.isEmpty()) {
            Debugger.m8607d(TAG, "onReceive action is null");
        } else if (GROUP_INVITATION_RECEIVED_INTENT_FILTER.equals(action)) {
            onGroupInvitationReceived();
        }
    }
}
