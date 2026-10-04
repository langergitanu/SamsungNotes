package com.samsung.android.sdk.bixby2.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.samsung.android.sdk.bixby2.LogUtil;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class ApplicationTriggerReceiver extends BroadcastReceiver {
    private static final String TAG = "ApplicationTriggerReceiver";

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        LogUtil.m5747i(TAG, "onReceived()");
        if (context != null) {
            context.unregisterReceiver(this);
            LogUtil.m5747i(TAG, "ApplicationTriggerReceiver unRegistered");
        }
    }
}
