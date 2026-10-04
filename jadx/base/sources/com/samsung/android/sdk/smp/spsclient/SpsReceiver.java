package com.samsung.android.sdk.smp.spsclient;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.samsung.android.sdk.smp.common.exception.InternalException;
import com.samsung.android.sdk.smp.common.preference.PrefManager;
import com.samsung.android.sdk.smp.common.util.DeviceInfoUtil;
import com.samsung.android.sdk.smp.common.util.SmpLog;
import com.samsung.android.sdk.smp.task.STask;
import com.samsung.android.sdk.smp.task.STaskDispatcher;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class SpsReceiver extends BroadcastReceiver {
    private static final String ACTION_DEACTIVATE = "com.samsung.android.sdk.smp.DEACTIVATE";
    private static final String TAG = "SpsReceiver";

    private void deactivateSmp(Context context) {
        String str = TAG;
        SmpLog.m6497hi(str, "deactivate smp");
        PrefManager prefManager = PrefManager.getInstance(context);
        if (!TextUtils.isEmpty(prefManager.getSmpID())) {
            prefManager.deactivateSmp(true);
            STaskDispatcher.dispatchOnService(context, new STask(STask.CommonAction.DEACTIVATE, null));
        } else if (prefManager.isSmpDeactivated()) {
            SmpLog.m6497hi(str, "smp is already deactivated. finish deactivation");
        } else {
            SmpLog.m6497hi(str, "smp has never been initialized. finish deactivation");
            prefManager.deactivateSmp(true);
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        try {
            if (context == null) {
                SmpLog.m6494e(TAG, "onReceive. context is null");
                return;
            }
            if (intent == null) {
                SmpLog.m6494e(TAG, "onReceive. intent is null");
                return;
            }
            if (DeviceInfoUtil.isSamsungPushService(context)) {
                if (ACTION_DEACTIVATE.equals(intent.getAction())) {
                    deactivateSmp(context);
                }
            } else {
                SmpLog.m6494e(TAG, "onReceive. This receiver is only for spp. pkg : " + context.getPackageName());
            }
        } catch (InternalException.ProviderErrorException e) {
            SmpLog.m6496he(TAG, "onReceive error: " + e.getErrorMessage());
        }
    }
}
