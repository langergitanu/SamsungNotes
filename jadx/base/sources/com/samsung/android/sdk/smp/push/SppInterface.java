package com.samsung.android.sdk.smp.push;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.samsung.android.sdk.smp.common.constants.Constants;
import com.samsung.android.sdk.smp.common.exception.IErrors;
import com.samsung.android.sdk.smp.common.preference.InitOptionsHolder;
import com.samsung.android.sdk.smp.common.preference.PrefManager;
import com.samsung.android.sdk.smp.common.util.PackageManagerUtil;
import com.samsung.android.sdk.smp.common.util.SmpLog;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class SppInterface {
    public static final int SPP_DEACTIVATED_SERVICE_ERROR = 4017;
    private static final String SPP_PACKAGE = "com.sec.spp.push";
    private static final String TAG = "SppInterface";

    private static boolean isSppInstalled(Context context) {
        try {
            PackageManagerUtil.getPackageInfo(context, SPP_PACKAGE, 0);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static void register(Context context) {
        SmpLog.m6498i(TAG, "type : spp");
        if (!isSppInstalled(context)) {
            PushHelper.getInstance().handlePushRegistrationFail(context, "spp", IErrors.ERROR_CODE_SMP_5002, IErrors.ERROR_MESSAGE_SMP_5002);
            return;
        }
        String sppAppId = InitOptionsHolder.getInstance().getSppAppId(context);
        if (TextUtils.isEmpty(sppAppId)) {
            PushHelper.getInstance().handlePushRegistrationFail(context, "spp", IErrors.ERROR_CODE_SMP_5001, IErrors.ERROR_MESSAGE_SMP_5001);
            return;
        }
        Intent intent = new Intent(Constants.SPP_REGI_ACTION);
        intent.putExtra("reqType", 1);
        intent.putExtra("appId", sppAppId);
        intent.putExtra("userdata", context.getPackageName());
        intent.setPackage(SPP_PACKAGE);
        try {
            context.startService(intent);
        } catch (Exception e) {
            SmpLog.m6496he(TAG, "error while starting SPP. " + e);
            PushHelper.getInstance().handlePushRegistrationFail(context, "spp", IErrors.ERROR_CODE_SMP_5004, IErrors.ERROR_MESSAGE_SMP_5004);
        }
    }

    public static boolean switchToSPPIfNot(Context context) {
        String pushType = PrefManager.getInstance(context).getPushType();
        if ("spp".equals(pushType)) {
            return false;
        }
        SmpLog.m6497hi(TAG, "switch " + pushType + " to SPP");
        register(context);
        return true;
    }
}
