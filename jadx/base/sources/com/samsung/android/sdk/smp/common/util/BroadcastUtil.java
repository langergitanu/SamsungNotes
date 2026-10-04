package com.samsung.android.sdk.smp.common.util;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.samsung.android.sdk.smp.SmpConstants;
import com.samsung.android.sdk.smp.common.interfaces.ListenerManager;
import com.samsung.android.sdk.smp.common.preference.PrefManager;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class BroadcastUtil {
    private static final String SPS_POLICY = "sps_policy";
    private static final String SPS_POLICY_ACTION = "com.samsung.android.sdk.smp.SPS_POLICY_ACTION";
    private static final String TAG = "BroadcastUtil";

    public static void broadcastMarketingDisplay(Context context, String str, String str2, String str3, boolean z, String str4, CharSequence charSequence, String[] strArr) {
        String str5 = TAG;
        SmpLog.m6493d(str5, str3, "SEND BR : DISPLAY");
        if (context == null) {
            SmpLog.m6494e(str5, "broadcastMarketingDisplay. context is null");
            return;
        }
        Intent intent = new Intent();
        intent.setPackage(context.getPackageName());
        intent.setAction(SmpConstants.SMP_MARKETING_EVENT_ACTION);
        intent.putExtra("event", str);
        intent.putExtra("type", str2);
        intent.putExtra("mid", str3);
        intent.putExtra(SmpConstants.INITIAL_DISPLAY, z);
        if (str4 != null) {
            intent.putExtra(SmpConstants.NOTIFICATION_TITLE, str4.replace("\u200e", ""));
        }
        if (charSequence != null) {
            intent.putExtra("contents", (CharSequence) charSequence.toString().replace("\u200e", ""));
        }
        if (strArr != null) {
            intent.putExtra("link", strArr);
        }
        context.sendBroadcast(intent);
    }

    private static void broadcastNewSmpInitFail(Context context, String str, String str2) {
        context.sendBroadcast(getInitResultIntent(context, SmpConstants.SMP_INIT_RESULT_ACTION, false, str, str2));
    }

    private static void broadcastNewSmpInitSuccess(Context context) {
        context.sendBroadcast(getInitResultIntent(context, SmpConstants.SMP_INIT_RESULT_ACTION, true, null, null));
    }

    private static void broadcastOldSmpInitFail(Context context, String str, String str2) {
        context.sendBroadcast(getInitResultIntent(context, SmpConstants.SMP_INITIALIZE_RESULT_ACTION, false, str, str2));
    }

    private static void broadcastOldSmpInitSuccess(Context context) {
        context.sendBroadcast(getInitResultIntent(context, SmpConstants.SMP_INITIALIZE_RESULT_ACTION, true, null, null));
    }

    public static void broadcastPushRegFail(Context context, String str, String str2, String str3) {
        if (context == null) {
            SmpLog.m6494e(TAG, "broadcastPushRegFail. context is null");
            return;
        }
        ListenerManager.getInstance().sendPushResultFail(str, str2, str3);
        SmpLog.m6497hi(TAG, "SEND BR : PUSH_REGISTRATION_RESULT_FAIL");
        Intent intent = new Intent(SmpConstants.PUSH_REGISTRATION_RESULT_ACTION);
        intent.setPackage(context.getPackageName());
        intent.putExtra(SmpConstants.IS_SUCCESS, false);
        intent.putExtra(SmpConstants.PUSH_TYPE, str);
        intent.putExtra("error_code", str2);
        intent.putExtra("error_message", str3);
        context.sendBroadcast(intent);
    }

    public static void broadcastPushRegSuccess(Context context, String str, String str2) {
        if (context == null) {
            SmpLog.m6494e(TAG, "broadcastPushRegSuccess. context is null");
            return;
        }
        ListenerManager.getInstance().sendPushResultSuccess(str, str2);
        SmpLog.m6497hi(TAG, "SEND BR : PUSH_REGISTRATION_RESULT_SUCCESS");
        Intent intent = new Intent(SmpConstants.PUSH_REGISTRATION_RESULT_ACTION);
        intent.setPackage(context.getPackageName());
        intent.putExtra(SmpConstants.IS_SUCCESS, true);
        intent.putExtra(SmpConstants.PUSH_TYPE, str);
        intent.putExtra(SmpConstants.PUSH_TOKEN, str2);
        context.sendBroadcast(intent);
    }

    public static void broadcastSPSPolicy(Context context, String str) {
        if (context != null) {
            SmpLog.m6492d(TAG, "send intent : sps policy");
            Intent intent = new Intent();
            intent.setPackage(context.getPackageName());
            intent.setAction(SPS_POLICY_ACTION);
            intent.putExtra(SPS_POLICY, str);
            context.sendBroadcast(intent);
        }
    }

    public static void broadcastSmpInitFail(Context context, String str, String str2) {
        if (context == null) {
            SmpLog.m6494e(TAG, "broadcastSmpInitFail. context is null");
            return;
        }
        ListenerManager.getInstance().sendInitResultFail(str, str2);
        String str3 = TAG;
        SmpLog.m6497hi(str3, "SEND BR : smp init fail - " + str);
        SmpLog.m6498i(str3, str2);
        broadcastOldSmpInitFail(context, str, str2);
        broadcastNewSmpInitFail(context, str, str2);
    }

    public static void broadcastSmpInitSuccess(Context context, boolean z) {
        if (context == null) {
            SmpLog.m6494e(TAG, "broadcastSmpInitSuccess. context is null");
            return;
        }
        ListenerManager.getInstance().sendInitResultSuccess();
        SmpLog.m6497hi(TAG, "SEND BR : smp init success");
        if (z) {
            broadcastOldSmpInitSuccess(context);
        }
        broadcastNewSmpInitSuccess(context);
    }

    public static void broadcastSmpInitSuccessForSppForceActivationFeature(Context context) {
        PrefManager prefManager = PrefManager.getInstance(context);
        if (prefManager.getInitCompleteTimeForSppForceActivationFeature() > 0) {
            return;
        }
        broadcastSmpInitSuccess(context, true);
        prefManager.setInitCompleteTimeForSppForceActivationFeature(System.currentTimeMillis());
    }

    public static void broadcastTokenChanged(Context context, String str, String str2) {
        String str3 = TAG;
        SmpLog.m6497hi(str3, "SEND BR : PUSH_TOKEN_CHANGED. type : " + str);
        SmpLog.m6498i(str3, "new token : " + str2);
        if (context == null) {
            SmpLog.m6494e(str3, "broadcastTokenChanged. context is null");
            return;
        }
        Intent intent = new Intent(SmpConstants.PUSH_TOKEN_CHANGED_ACTION);
        intent.setPackage(context.getPackageName());
        intent.putExtra(SmpConstants.PUSH_TYPE, str);
        intent.putExtra(SmpConstants.PUSH_TOKEN, str2);
        context.sendBroadcast(intent);
    }

    private static Intent getInitResultIntent(Context context, String str, boolean z, String str2, String str3) {
        Intent intent = new Intent(str);
        intent.setPackage(context.getPackageName());
        intent.putExtra(SmpConstants.IS_SUCCESS, z);
        if (!TextUtils.isEmpty(str2)) {
            intent.putExtra("error_code", str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            intent.putExtra("error_message", str3);
        }
        return intent;
    }
}
