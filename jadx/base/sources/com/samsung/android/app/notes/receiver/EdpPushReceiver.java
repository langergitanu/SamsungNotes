package com.samsung.android.app.notes.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.samsung.android.support.senl.p148nt.app.common.log.MainCoeditLogger;
import com.samsung.android.support.senl.p148nt.app.sync.p150ui.notification.EdpNotificationHelper;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class EdpPushReceiver extends BroadcastReceiver {
    private static final String TAG = "EdpPushReceiver";

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (context == null) {
            MainCoeditLogger.m7251e(TAG, "[CS2-2] onReceive context is null");
            return;
        }
        if (intent == null) {
            MainCoeditLogger.m7251e(TAG, "[CS2-2] onReceive intent is null");
            return;
        }
        String action = intent.getAction();
        if (action == null || action.isEmpty()) {
            MainCoeditLogger.m7251e(TAG, "[CS2-2] onReceive action is null");
            return;
        }
        MainCoeditLogger.m7253i(TAG, "[CS2] onReceive start ( Action = " + action + " )");
        EdpNotificationHelper edpNotificationHelper = new EdpNotificationHelper();
        edpNotificationHelper.setAction(intent);
        edpNotificationHelper.cancelAllEdpNotification();
    }
}
