package com.samsung.android.app.notes.demo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.util.DeviceUtils;
import java.io.IOException;
import java.io.InputStream;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class NotesDemoReceiver extends BroadcastReceiver {
    private static final String DEMO_RESET_COMPLETED = "com.samsung.sea.rm.DEMO_RESET_COMPLETED";
    private static final String DEMO_RESET_STARTED = "com.samsung.sea.rm.DEMO_RESET_STARTED";
    private static final String TAG = "NotesDemoReceiver";

    private void clearAppData(String str) {
        try {
            InputStream inputStream = Runtime.getRuntime().exec("pm clear " + str).getInputStream();
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    AbstractC0000a.m20q(e, new StringBuilder("onReceive() : fail to close the stream : "), TAG);
                }
            }
        } catch (Exception e2) {
            AbstractC0000a.m21r(e2, new StringBuilder("onReceive() : fail to clearAppData : "), TAG);
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Debugger.m8615i(TAG, "onReceive() : Receive noti.");
        if (Build.VERSION.SDK_INT < 29) {
            Debugger.m8615i(TAG, "onReceive() : OS < 29");
            return;
        }
        if (context == null) {
            Debugger.m8609e(TAG, "onReceive() : Invalid context");
            return;
        }
        if (!DeviceUtils.isDemoDevice(context)) {
            Debugger.m8609e(TAG, "onReceive() : Not demo device!");
            return;
        }
        if (intent == null) {
            Debugger.m8609e(TAG, "onReceive() : intent is null!");
            return;
        }
        String action = intent.getAction();
        if (action == null || action.isEmpty()) {
            Debugger.m8607d(TAG, "onReceive() : action is null or empty");
            return;
        }
        if (DEMO_RESET_STARTED.equals(action)) {
            Debugger.m8607d(TAG, "onReceive() : receive DEMO_RESET_STARTED");
            clearAppData(context.getApplicationContext().getPackageName());
        } else if (DEMO_RESET_COMPLETED.equals(action)) {
            Debugger.m8607d(TAG, "onReceive() : receive DEMO_RESET_COMPLETED");
        } else {
            Debugger.m8607d(TAG, "onReceive() : not handled action = ".concat(action));
        }
    }
}
