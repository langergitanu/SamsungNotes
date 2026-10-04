package com.samsung.android.sdk.smp.push;

import android.content.Context;
import android.text.TextUtils;
import com.samsung.android.sdk.smp.common.preference.PrefManager;
import com.samsung.android.sdk.smp.common.util.BroadcastUtil;
import com.samsung.android.sdk.smp.common.util.DeviceInfoUtil;
import com.samsung.android.sdk.smp.common.util.SmpLog;
import com.samsung.android.sdk.smp.data.DataManager;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class PushHelper extends PushHelperFeature {
    private static final String TAG = "PushHelper";
    private static PushHelper mPushHelper;

    private PushHelper() {
    }

    public static synchronized PushHelper getInstance() {
        try {
            if (mPushHelper == null) {
                mPushHelper = new PushHelper();
            }
        } catch (Throwable th) {
            throw th;
        }
        return mPushHelper;
    }

    private static boolean hasPushTypeCache(Context context) {
        return !TextUtils.isEmpty(PrefManager.getInstance(context).getPushTypeCache());
    }

    public static synchronized boolean isPushRegComplete(Context context) {
        return !TextUtils.isEmpty(PrefManager.getInstance(context).getPushType());
    }

    private boolean needTokenChangedBroadcast(Context context) {
        return isPushRegComplete(context) || hasPushTypeCache(context);
    }

    private void saveToken(Context context, String str, String str2) {
        PrefManager prefManager = PrefManager.getInstance(context);
        prefManager.setPushToken(str2);
        prefManager.setPushType(str);
    }

    @Override // com.samsung.android.sdk.smp.push.PushHelperFeature, com.samsung.android.sdk.smp.push.PushHelperFeatureInterface
    public synchronized void handlePushRegistrationFail(Context context, String str, String str2, String str3) {
        String str4;
        try {
            String str5 = TAG;
            StringBuilder sb = new StringBuilder("push registration fail - ");
            sb.append(str2);
            if (TextUtils.isEmpty(str3)) {
                str4 = "";
            } else {
                str4 = SQLKeyword.COMMA + str3;
            }
            sb.append(str4);
            SmpLog.m6496he(str5, sb.toString());
            if (context == null) {
                SmpLog.m6494e(str5, "handlePushRegistrationFail. context is null");
            } else {
                if (isPushRegComplete(context)) {
                    return;
                }
                super.handlePushRegistrationFail(context, str, str2, str3);
                BroadcastUtil.broadcastPushRegFail(context, str, str2, str3);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void handlePushRegistrationSuccess(Context context, String str, String str2) {
        String str3 = TAG;
        SmpLog.m6497hi(str3, "push registration success");
        if (context == null) {
            SmpLog.m6494e(str3, "handlePushRegistrationSuccess. context is null");
            return;
        }
        if (isValidPushRegistration(context, str, str2)) {
            boolean zNeedTokenChangedBroadcast = needTokenChangedBroadcast(context);
            saveToken(context, str, str2);
            if (zNeedTokenChangedBroadcast) {
                BroadcastUtil.broadcastTokenChanged(context, str, str2);
            } else {
                BroadcastUtil.broadcastPushRegSuccess(context, str, str2);
            }
            if (DeviceInfoUtil.hasSppForceActivationFeature()) {
                BroadcastUtil.broadcastSmpInitSuccessForSppForceActivationFeature(context);
            } else if (DeviceInfoUtil.isOnlySupportGeneralPush(context)) {
                BroadcastUtil.broadcastSmpInitSuccess(context, false);
            } else {
                DataManager.triggerUploadClientsNow(context, true);
            }
        }
    }

    public synchronized void handleSppDeactivateEvent(Context context) {
        SmpLog.m6497hi(TAG, "SPP is deactivated");
        if ("spp".equals(PrefManager.getInstance(context).getPushType())) {
            PrefManager.getInstance(context).removePushInfoAndSaveToCache();
            switchPushWhenSppDeactivated(context);
        }
    }

    public synchronized void handleSppDeregistrationSuccess(Context context) {
        SmpLog.m6497hi(TAG, "push deregistration");
        if ("spp".equals(PrefManager.getInstance(context).getPushType())) {
            PrefManager.getInstance(context).removePushInfoAndSaveToCache();
        }
    }

    @Override // com.samsung.android.sdk.smp.push.PushHelperFeature, com.samsung.android.sdk.smp.push.PushHelperFeatureInterface
    public synchronized boolean isValidPushRegistration(Context context, String str, String str2) {
        if (str2.equals(PrefManager.getInstance(context).getPushToken())) {
            SmpLog.m6497hi(TAG, "push registration success but not valid request : already registered with the same token. ignore it");
            return false;
        }
        return super.isValidPushRegistration(context, str, str2);
    }
}
