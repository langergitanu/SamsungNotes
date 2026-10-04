package com.samsung.android.sdk.smp.push;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.messaging.FirebaseMessaging;
import com.samsung.android.sdk.smp.common.exception.IErrors;
import com.samsung.android.sdk.smp.common.exception.InternalException;
import com.samsung.android.sdk.smp.common.preference.PrefManager;
import com.samsung.android.sdk.smp.common.util.BroadcastUtil;
import com.samsung.android.sdk.smp.common.util.SmpLog;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class FcmInterface {
    private static final String TAG = "FcmInterface";

    public static void enableFcmAutoInit() {
        try {
            FirebaseMessaging.getInstance().setAutoInitEnabled(true);
        } catch (Error | Exception e) {
            SmpLog.m6494e(TAG, "Fail to enable fcm. " + e.toString());
        }
    }

    private static Task<String> getFcmToken(Context context) {
        try {
            return FirebaseMessaging.getInstance().getToken();
        } catch (Error | Exception e) {
            String str = TAG;
            SmpLog.m6501w(str, "getToken Error : " + e.toString());
            SmpLog.m6501w(str, "initialize FirebaseApp and re-try getToken");
            FirebaseApp.initializeApp(context);
            return FirebaseMessaging.getInstance().getToken();
        }
    }

    public static void register(final Context context) {
        String str = TAG;
        SmpLog.m6498i(str, "type : fcm");
        int iIsGooglePlayServicesAvailable = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(context);
        final PushHelper pushHelper = PushHelper.getInstance();
        SmpLog.m6497hi(str, "google service status : " + iIsGooglePlayServicesAvailable);
        if (1 == iIsGooglePlayServicesAvailable) {
            SmpLog.m6497hi(str, "google service is missing on this device");
            pushHelper.handlePushRegistrationFail(context, "fcm", IErrors.ERROR_CODE_SMP_0002, IErrors.ERROR_MESSAGE_SMP_0002);
            return;
        }
        try {
            Task<String> fcmToken = getFcmToken(context);
            fcmToken.addOnSuccessListener(new OnSuccessListener<String>() { // from class: com.samsung.android.sdk.smp.push.FcmInterface.1
                @Override // com.google.android.gms.tasks.OnSuccessListener
                public void onSuccess(String str2) {
                    try {
                        if (TextUtils.isEmpty(str2)) {
                            pushHelper.handlePushRegistrationFail(context, "fcm", IErrors.ERROR_CODE_SMP_0003, IErrors.ERROR_MESSAGE_SMP_0003);
                        } else {
                            pushHelper.handlePushRegistrationSuccess(context, "fcm", str2);
                        }
                    } catch (InternalException.ProviderErrorException e) {
                        SmpLog.m6496he(FcmInterface.TAG, "register getFcmToken error " + e.getErrorMessage());
                    }
                }
            });
            fcmToken.addOnFailureListener(new OnFailureListener() { // from class: com.samsung.android.sdk.smp.push.FcmInterface.2
                @Override // com.google.android.gms.tasks.OnFailureListener
                public void onFailure(Exception exc) {
                    pushHelper.handlePushRegistrationFail(context, "fcm", IErrors.ERROR_CODE_SMP_0001, exc.getClass().getSimpleName() + ":" + exc.getMessage());
                }
            });
        } catch (Error | Exception e) {
            pushHelper.handlePushRegistrationFail(context, "fcm", IErrors.ERROR_CODE_SMP_0001, e.getClass().getSimpleName() + ":" + e.getMessage());
        }
    }

    public static Task<Void> subscribeToFcmTopic(String str) {
        SmpLog.m6497hi(TAG, "subscribe topic");
        return FirebaseMessaging.getInstance().subscribeToTopic(str);
    }

    public static boolean switchToFCMIfNot(Context context) {
        String pushType = PrefManager.getInstance(context).getPushType();
        if ("fcm".equals(pushType)) {
            return false;
        }
        SmpLog.m6497hi(TAG, "switch " + pushType + " to FCM");
        enableFcmAutoInit();
        register(context);
        return true;
    }

    public static Task<Void> unsubscribeToFcmTopic(String str) {
        SmpLog.m6497hi(TAG, "unsubscribe topic");
        return FirebaseMessaging.getInstance().unsubscribeFromTopic(str);
    }

    public static void updatePushTokenIfChanged(final Context context) {
        PrefManager prefManager = PrefManager.getInstance(context);
        if ("fcm".equals(prefManager.getPushType())) {
            final String pushToken = prefManager.getPushToken();
            try {
                getFcmToken(context).addOnSuccessListener(new OnSuccessListener<String>() { // from class: com.samsung.android.sdk.smp.push.FcmInterface.3
                    @Override // com.google.android.gms.tasks.OnSuccessListener
                    public void onSuccess(String str) {
                        String str2 = pushToken;
                        if (str2 == null || str2.equals(str) || context == null) {
                            return;
                        }
                        SmpLog.m6498i(FcmInterface.TAG, "fcm token is changed");
                        try {
                            PrefManager.getInstance(context).setPushToken(str);
                            BroadcastUtil.broadcastTokenChanged(context, "fcm", str);
                        } catch (InternalException.ProviderErrorException e) {
                            SmpLog.m6496he(FcmInterface.TAG, "update token error. " + e.getErrorMessage());
                        }
                    }
                });
            } catch (Error | Exception e) {
                SmpLog.m6494e(TAG, "update token error. " + e.toString());
            }
        }
    }
}
