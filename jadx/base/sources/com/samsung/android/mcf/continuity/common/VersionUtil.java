package com.samsung.android.mcf.continuity.common;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.compose.runtime.AbstractC1974b;
import com.samsung.android.mcf.continuity.BuildConfig;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class VersionUtil {
    private static final int MASK_SDK_REVISION = 1000;
    private static final int MASK_SERVICE_BRANCH_AND_FLAVOR = 100000;

    @VisibleForTesting
    public static final String PACKAGE_NAME_MCF_CONTINUITY = "com.samsung.android.mcfds";

    @VisibleForTesting
    public static final int SUPPORT_BT_SESSION = 1;

    @VisibleForTesting
    public static final int SUPPORT_WIFI_P2P_SESSION = 4;

    @VisibleForTesting
    public static final int SUPPORT_WIFI_SESSION = 2;
    private static final String TAG = "VersionUtil";
    private static final int VERSION_CODE_SUPPORT_BT_SESSION = 1100;
    private static final int VERSION_CODE_SUPPORT_WIFI_SESSION = 1200;
    private static int mServiceSupportFeatures = -1;

    @VisibleForTesting
    public static int getFeatureFlag(int i) {
        switch (i) {
            case 11:
                return 1;
            case 12:
                return 2;
            case 13:
                return 4;
            default:
                return 0;
        }
    }

    public static int getSDKVersionCode() {
        return BuildConfig.VERSION_CODE;
    }

    public static long getServiceVersionCode(@NonNull Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(PACKAGE_NAME_MCF_CONTINUITY, 128);
            if (packageInfo != null) {
                return packageInfo.getLongVersionCode();
            }
            return -1L;
        } catch (PackageManager.NameNotFoundException e) {
            DLog.m5611w(TAG, "getServiceVersionCode", "NameNotFoundException " + e.getMessage());
            return -1L;
        }
    }

    private static boolean hasFeature(int i, int i2) {
        return i2 <= i;
    }

    public static void initServiceSupportFeatures(@NonNull Context context) {
        long serviceVersionCode = getServiceVersionCode(context);
        mServiceSupportFeatures = 0;
        if (serviceVersionCode == -1) {
            return;
        }
        int i = (int) (serviceVersionCode / 100000);
        DLog.m5607d(TAG, "initSupportFeatures", "abovePatchVersionCode - " + i);
        if (hasFeature(i, 1100)) {
            mServiceSupportFeatures |= 1;
        }
        if (hasFeature(i, 1200)) {
            mServiceSupportFeatures |= 2;
        }
        StringBuilder sbM1323p = AbstractC1974b.m1323p(serviceVersionCode, "serviceVersionCode - ", ", mSupportFeatures - ");
        sbM1323p.append(mServiceSupportFeatures);
        DLog.m5610i(TAG, "initSupportFeatures", sbM1323p.toString());
    }

    public static boolean isNetworkTypeSupported(int i) {
        return isSDKSupportNetworkType(i) && isServiceSupportNetworkType(i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    @VisibleForTesting
    public static boolean isSDKSupportFeatureFlag(int i, int i2) {
        boolean zHasFeature = hasFeature(i, 1100);
        ?? r02 = zHasFeature;
        if (hasFeature(i, 1200)) {
            r02 = (zHasFeature ? 1 : 0) | 2;
        }
        return (r02 & i2) != 0;
    }

    private static boolean isSDKSupportNetworkType(int i) {
        int sDKVersionCode = getSDKVersionCode() / 1000;
        DLog.m5607d(TAG, "isSDKSupportFeature", "abovePatchVersionCode - " + sDKVersionCode);
        return isSDKSupportFeatureFlag(sDKVersionCode, getFeatureFlag(i));
    }

    public static boolean isServiceSupportAppId(int i) {
        return isServiceSupportFeature(i != 1 ? i != 2 ? 0 : 1 : 2);
    }

    private static boolean isServiceSupportFeature(int i) {
        int i2 = mServiceSupportFeatures;
        return (i2 == -1 || (i & i2) == 0) ? false : true;
    }

    private static boolean isServiceSupportNetworkType(int i) {
        return isServiceSupportFeature(getFeatureFlag(i));
    }
}
