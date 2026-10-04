package com.samsung.android.sdk.smp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.samsung.android.sdk.smp.common.constants.Constants;
import com.samsung.android.sdk.smp.common.exception.InternalException;
import com.samsung.android.sdk.smp.common.util.SmpLog;
import com.samsung.android.sdk.smp.interfaceimpl.SmpInterfaceImpl;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class SmpSAReceiver extends BroadcastReceiver {
    private static final String TAG = "SmpSAReceiver";

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        try {
            if (context == null) {
                SmpLog.m6494e(TAG, "context is null");
                return;
            }
            if (intent == null) {
                SmpLog.m6494e(TAG, "intent is null");
                return;
            }
            SmpLog.m6498i(TAG, "onReceive");
            String action = intent.getAction();
            if (!Constants.ACTION_SAMSUNGACCOUNT_SIGNIN_COMPLETED.equals(action) && !Constants.ACTION_SAMSUNGACCOUNT_SIGNOUT_COMPLETED.equals(action)) {
                return;
            }
            SmpInterfaceImpl.saSignInOrOut(context);
        } catch (InternalException.ProviderErrorException e) {
            SmpLog.m6496he(TAG, "Exception SmpSAReceiver->onReceive " + e.getErrorMessage());
        }
    }
}
