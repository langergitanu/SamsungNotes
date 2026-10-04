package com.samsung.android.app.notes.sync.push.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.sdk.smp.Smp;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class SmpPackageReceiver extends BroadcastReceiver {
    private static final String TAG = "SmpPackageReceiver";

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Debugger.m8615i(TAG, "[PUSH] onReceive()");
        if (context == null) {
            Debugger.m8609e(TAG, "[PUSH] onReceive() : Invalid context");
            return;
        }
        if (intent == null) {
            Debugger.m8609e(TAG, "[PUSH] onReceive() : Invalid params");
            return;
        }
        String action = intent.getAction();
        Debugger.m8607d(TAG, "[PUSH] onReceive() : action = " + action);
        if ("android.intent.action.MY_PACKAGE_REPLACED".equals(action)) {
            Debugger.m8615i(TAG, "[PUSH] onReceive() : Smp.appUpdated() start");
            try {
                Smp.appUpdated(context);
            } catch (Exception e) {
                AbstractC4539a.m3213w(e, new StringBuilder("[PUSH] onReceive() : Exception = "), TAG);
            }
            Debugger.m8615i(TAG, "[PUSH] onReceive() : Smp.appUpdated() finish");
        }
    }
}
