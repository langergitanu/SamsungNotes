package com.samsung.android.sdk.smp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.samsung.android.sdk.smp.common.exception.IErrors;
import com.samsung.android.sdk.smp.common.exception.InternalException;
import com.samsung.android.sdk.smp.common.preference.InitOptionsHolder;
import com.samsung.android.sdk.smp.common.preference.PrefManager;
import com.samsung.android.sdk.smp.common.util.DeviceInfoUtil;
import com.samsung.android.sdk.smp.common.util.SmpLog;
import com.samsung.android.sdk.smp.push.PushHelper;
import com.samsung.android.sdk.smp.push.PushMsgHandler;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public abstract class SmpSppReceiver extends BroadcastReceiver {
    private static final String TAG = "SmpSppReceiver";

    private void onPushRegResult(Context context, Intent intent) {
        if (!DeviceInfoUtil.isSupportCountryCode()) {
            SmpLog.m6496he(TAG, "The current country code is not supported on this sdk. should check the sdk that you are importing.");
            return;
        }
        if (PrefManager.getInstance(context).isSmpDeactivated()) {
            SmpLog.m6497hi(TAG, "onPushRegResult. smp is deactivated. do nothing");
            return;
        }
        String sppAppId = InitOptionsHolder.getInstance().getSppAppId(context);
        String stringExtra = intent.getStringExtra("appId");
        if (sppAppId == null || !sppAppId.equals(stringExtra)) {
            SmpLog.m6501w(TAG, "onPushRegResult. appid not matched");
            return;
        }
        int intExtra = intent.getIntExtra("Error", 1000);
        int intExtra2 = intent.getIntExtra("com.sec.spp.Status", 1);
        PushHelper pushHelper = PushHelper.getInstance();
        if (intExtra == 4017 && (intExtra2 == 0 || intExtra2 == 2)) {
            pushHelper.handleSppDeactivateEvent(context);
            return;
        }
        if (intExtra2 == 0) {
            String stringExtra2 = intent.getStringExtra("RegistrationID");
            if (TextUtils.isEmpty(stringExtra2)) {
                pushHelper.handlePushRegistrationFail(context, "spp", IErrors.ERROR_CODE_SMP_5003, IErrors.ERROR_MESSAGE_SMP_5003);
                return;
            } else {
                pushHelper.handlePushRegistrationSuccess(context, "spp", stringExtra2);
                return;
            }
        }
        if (intExtra2 == 1) {
            pushHelper.handlePushRegistrationFail(context, "spp", AbstractC0000a.m11h(intExtra, ""), "");
        } else if (intExtra2 == 2) {
            pushHelper.handleSppDeregistrationSuccess(context);
        }
    }

    public void marketingMessageReceived(String str, String str2) {
    }

    public abstract void messageReceived(Context context, Intent intent);

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, final Intent intent) {
        try {
            if (context == null) {
                SmpLog.m6494e(TAG, "context is null");
                return;
            }
            if (intent == null) {
                SmpLog.m6494e(TAG, "intent is null");
                return;
            }
            final Context applicationContext = context.getApplicationContext();
            if ("com.sec.spp.RegistrationChangedAction".equals(intent.getAction())) {
                onPushRegResult(applicationContext, intent);
            } else {
                new PushMsgHandler().handleSPPMessage(applicationContext, intent.getExtras(), new PushMsgHandler.ISmpPushInterface() { // from class: com.samsung.android.sdk.smp.SmpSppReceiver.1
                    @Override // com.samsung.android.sdk.smp.push.PushMsgHandler.ISmpPushInterface
                    public void generalMessageReceivedImpl() {
                        SmpSppReceiver.this.messageReceived(applicationContext, intent);
                    }

                    @Override // com.samsung.android.sdk.smp.push.PushMsgHandler.ISmpPushInterface
                    public void marketingMessageReceivedImpl(String str, String str2) {
                        SmpSppReceiver.this.marketingMessageReceived(str, str2);
                    }
                });
            }
        } catch (InternalException.ProviderErrorException e) {
            SmpLog.m6496he(TAG, "Exception SmpSppReceiver->onReceive " + e.getErrorMessage());
        }
    }
}
