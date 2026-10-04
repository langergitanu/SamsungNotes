package com.samsung.android.support.senl.p148nt.app.sync.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import p186h1.C12028i;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class SyncTimeReceiver extends BroadcastReceiver {
    private static final String TAG = "SyncTimeReceiver";

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Debugger.m8607d(TAG, "onReceive");
        if (context == null) {
            Debugger.m8609e(TAG, "invalid context!");
            return;
        }
        if (intent == null || intent.getAction() == null) {
            Debugger.m8609e(TAG, "invalid intent!");
            return;
        }
        if (intent.getAction().equals(BaseWidgetConstant.TIME_SET_CHANGED)) {
            Debugger.m8614f(TAG, "ACTION_TIME_CHANGED!");
        } else {
            if (!intent.getAction().equals("android.intent.action.TIMEZONE_CHANGED")) {
                Debugger.m8609e(TAG, "invalid Action : " + intent.getAction());
                return;
            }
            Debugger.m8614f(TAG, "ACTION_TIMEZONE_CHANGED!");
        }
        new C12028i().m13709d(1);
    }
}
