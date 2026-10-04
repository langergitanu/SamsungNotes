package com.samsung.android.sdk.mobileservice.common;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.samsung.android.sdk.mobileservice.SeMobileService;
import com.samsung.android.sdk.mobileservice.util.SdkLog;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class CommonUtils {
    public static final int MAX_IMAGE_SIZE = 819200;
    public static final String MOBILE_SERVICE_PACKAGE_NAME = "com.samsung.android.mobileservice";
    public static final String SAMSUNG_ACCOUNT_PACKAGE_NAME = "com.osp.app.signin";
    private static final String TAG = "CommonUtils";
    private static Boolean sIsStandAloneSamsungAccountSupported;

    public static String getMetaData(Context context, String str, String str2) {
        ApplicationInfo applicationInfo;
        try {
            applicationInfo = context.getPackageManager().getApplicationInfo(str, 128);
        } catch (PackageManager.NameNotFoundException e) {
            SdkLog.m5785s(e);
            applicationInfo = null;
        }
        Bundle bundle = applicationInfo != null ? applicationInfo.metaData : null;
        if (bundle != null) {
            return bundle.getString(str2);
        }
        return null;
    }

    private static boolean getSupportStandAloneFromMetaData(Context context) {
        ApplicationInfo applicationInfo;
        Bundle bundle;
        try {
            applicationInfo = context.getPackageManager().getApplicationInfo("com.osp.app.signin", 128);
        } catch (PackageManager.NameNotFoundException e) {
            SdkLog.m5785s(e);
            applicationInfo = null;
        }
        boolean z = false;
        if (applicationInfo != null && (bundle = applicationInfo.metaData) != null) {
            z = bundle.getBoolean("SupportStandAlone", false);
        }
        SdkLog.m5782d(TAG, "getSupportStandAloneFromMetaData : " + z);
        sIsStandAloneSamsungAccountSupported = Boolean.valueOf(z);
        return z;
    }

    public static boolean isAgentNoMoreSupportedVersion(int i, Context context) {
        return SeMobileService.getAgentVersion(context) >= i;
    }

    public static boolean isAgentSupportMinVersion(int i, Context context) {
        return SeMobileService.getAgentVersion(context) >= i;
    }

    public static boolean isAgentSupportMinVersionBetween(int i, int i2, Context context) {
        return SeMobileService.getAgentVersion(context) >= i && SeMobileService.getAgentVersion(context) < i2;
    }

    public static boolean isSaAgentSupportMinVersion(int i, Context context) {
        return isStandAloneSamsungAccountSupported(context) && SeMobileService.getSaAgentVersion(context) >= i;
    }

    public static boolean isStandAloneSamsungAccountSupported(Context context) {
        Boolean bool = sIsStandAloneSamsungAccountSupported;
        return bool != null ? bool.equals(Boolean.TRUE) : getSupportStandAloneFromMetaData(context);
    }
}
