package com.samsung.android.sdk.smp;

import android.content.Context;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.samsung.android.sdk.smp.common.exception.InternalException;
import com.samsung.android.sdk.smp.common.preference.PrefManager;
import com.samsung.android.sdk.smp.common.util.BroadcastUtil;
import com.samsung.android.sdk.smp.common.util.DeviceInfoUtil;
import com.samsung.android.sdk.smp.common.util.SmpLog;
import com.samsung.android.sdk.smp.data.DataManager;
import com.samsung.android.sdk.smp.push.PushMsgHandler;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public abstract class SmpFcmService extends FirebaseMessagingService {
    private static final String TAG = "SmpFcmService";

    public void marketingMessageReceived(String str, String str2) {
    }

    public abstract void messageReceived(RemoteMessage remoteMessage);

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public final void onMessageReceived(final RemoteMessage remoteMessage) {
        try {
            new PushMsgHandler().handleFcmMessage(getApplicationContext(), remoteMessage.getData(), remoteMessage.getPriority(), new PushMsgHandler.ISmpPushInterface() { // from class: com.samsung.android.sdk.smp.SmpFcmService.1
                @Override // com.samsung.android.sdk.smp.push.PushMsgHandler.ISmpPushInterface
                public void generalMessageReceivedImpl() {
                    SmpFcmService.this.messageReceived(remoteMessage);
                }

                @Override // com.samsung.android.sdk.smp.push.PushMsgHandler.ISmpPushInterface
                public void marketingMessageReceivedImpl(String str, String str2) {
                    SmpFcmService.this.marketingMessageReceived(str, str2);
                }
            });
        } catch (InternalException.ProviderErrorException e) {
            SmpLog.m6496he(TAG, "Exception onMessageReceived " + e.getErrorMessage());
        }
    }

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public final void onNewToken(String str) {
        try {
            if (!DeviceInfoUtil.isSupportCountryCode()) {
                SmpLog.m6496he(TAG, "The current country code is not supported on this sdk. should check the sdk that you are importing.");
                return;
            }
            Context applicationContext = getApplicationContext();
            PrefManager prefManager = PrefManager.getInstance(applicationContext);
            if (prefManager.isSmpDeactivated()) {
                SmpLog.m6497hi(TAG, "token refreshed. smp is deactivated. do nothing");
                return;
            }
            String pushType = prefManager.getPushType();
            if ("fcm".equals(pushType)) {
                SmpLog.m6497hi(TAG, "token refreshed");
                prefManager.setPushToken(str);
                if (DataManager.isInitialUploadDone(applicationContext)) {
                    prefManager.setUploadFailCount(0);
                    DataManager.triggerUploadClientsNow(applicationContext, false);
                }
                BroadcastUtil.broadcastTokenChanged(applicationContext, "fcm", str);
                return;
            }
            String str2 = TAG;
            SmpLog.m6497hi(str2, "token refreshed but push type is " + pushType + ". skip this");
            StringBuilder sb = new StringBuilder("new token : ");
            sb.append(str);
            SmpLog.m6498i(str2, sb.toString());
        } catch (InternalException.ProviderErrorException e) {
            SmpLog.m6496he(TAG, "Exception onNewToken " + e.getErrorMessage());
        }
    }
}
