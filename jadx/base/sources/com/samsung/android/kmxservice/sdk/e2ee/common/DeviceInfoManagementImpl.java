package com.samsung.android.kmxservice.sdk.e2ee.common;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import com.samsung.android.feature.SemFloatingFeature;
import com.samsung.android.kmxservice.sdk.e2ee.KmxException;
import com.samsung.android.kmxservice.sdk.e2ee.data.KMX_CMD;
import com.samsung.android.kmxservice.sdk.e2ee.data.KMX_CONSTANT;
import com.samsung.android.kmxservice.sdk.e2ee.data.SharedPreferenceHelper;
import com.samsung.android.kmxservice.sdk.e2ee.manager.DeviceInfoManagement;
import com.samsung.android.kmxservice.sdk.util.KmxLogger;
import com.samsung.android.kmxservice.sdk.util.SksAttestation;
import com.samsung.android.kmxservice.sdk.util.SystemProperties;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class DeviceInfoManagementImpl implements DeviceInfoManagement {
    private static final String SUPPORTED_ATTESTATION_KEY_PROP = "ro.security.keystore.keytype";
    private static final String TAG = "DeviceInfoManagementImpl";
    private final int deviceType;
    private final SksAttestation sksAttestation;

    public DeviceInfoManagementImpl(SksAttestation sksAttestation) {
        this.sksAttestation = sksAttestation;
        int deviceType = getDeviceType();
        this.deviceType = deviceType;
        KmxLogger.m5529i(TAG, "[DeviceInfoManagementImpl] : " + deviceType);
    }

    private int getDeviceType() {
        if (this.sksAttestation == null) {
            return 0;
        }
        if (SystemProperties.isModelVST()) {
            return 2;
        }
        if (SystemProperties.isMoreThanOneUI511()) {
            PackageManager packageManager = KmxSdk.getContext().getPackageManager();
            try {
                ApplicationInfo applicationInfo = packageManager.getPackageInfo("com.samsung.android.kmxservice", 128).applicationInfo;
                if (applicationInfo != null && applicationInfo.enabled) {
                    KmxLogger.m5527d(TAG, "appInfo was found");
                    return 1;
                }
                int i = 0;
                for (PackageInfo packageInfo : packageManager.getInstalledPackages(0)) {
                    i++;
                    if (packageInfo.packageName.equals("com.samsung.android.kmxservice")) {
                        KmxLogger.m5529i(TAG, "PKG [" + i + "] :" + packageInfo.packageName);
                        return 1;
                    }
                }
            } catch (Exception e) {
                KmxLogger.m5528e(TAG, "[E] E2EEDeviceType |" + e.getMessage());
                e.printStackTrace();
            }
        } else {
            KmxLogger.m5529i(TAG, "[getE2EEDeviceType] OneUI version is lower than 5.1.1");
        }
        try {
            if ("jdm".equals(SystemProperties.isPossibleUseFloatingFeature() ? SemFloatingFeature.getInstance().getString("SEC_FLOATING_FEATURE_COMMON_CONFIG_DEVICE_MANUFACTURING_TYPE") : "")) {
                KmxLogger.m5529i(TAG, "[getE2EEDeviceType] : JDM model");
                return 0;
            }
            if (!SystemProperties.get(SUPPORTED_ATTESTATION_KEY_PROP).contains("sak") || SystemProperties.getFirstApiLevel() < 28) {
                return 0;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("[E2EE] SDK LEVEL:");
            int i2 = Build.VERSION.SDK_INT;
            sb.append(i2);
            KmxLogger.m5529i(TAG, sb.toString());
            if (i2 != 28) {
                return 2;
            }
            KmxLogger.m5529i(TAG, "[E2EE | OS] : P");
            return 0;
        } catch (Exception e2) {
            KmxLogger.m5528e(TAG, "[E] E2EEDeviceType No FloatingFeature |" + e2.getMessage());
            e2.printStackTrace();
            return 0;
        }
    }

    @Override // com.samsung.android.kmxservice.sdk.e2ee.manager.DeviceInfoManagement
    public int getDeviceIntegrity(boolean z) throws KmxException {
        int buildType;
        if (this.sksAttestation == null || this.deviceType == 0) {
            return -1;
        }
        if (!z && ((buildType = SystemProperties.getBuildType()) == 1 || buildType == 2)) {
            KmxLogger.m5529i(TAG, "This is not USER binary. Skip check integrity");
            return 0;
        }
        int deviceIntegrity = this.sksAttestation.getDeviceIntegrity();
        if (deviceIntegrity == -1) {
            KmxErrorHandler.throwIfNotSuccess("2| FAIL to check device integrity :" + deviceIntegrity, 5);
        }
        KmxLogger.m5529i(TAG, "[getDeviceIntegrity] : " + deviceIntegrity);
        return deviceIntegrity;
    }

    @Override // com.samsung.android.kmxservice.sdk.e2ee.manager.DeviceInfoManagement
    public int getE2EEDeviceType() {
        KmxLogger.m5529i(TAG, "KmxSdk v2.0.9-release");
        KmxLogger.m5529i(TAG, "[getE2EEDeviceType] : " + this.deviceType);
        return this.deviceType;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0076  */
    @Override // com.samsung.android.kmxservice.sdk.e2ee.manager.DeviceInfoManagement
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String getSakUid() throws KmxException {
        if (this.sksAttestation == null || this.deviceType == 0) {
            KmxLogger.m5529i(TAG, "[DeviceInfo] : " + this.deviceType);
            return null;
        }
        Context context = KmxSdk.getContext();
        int firstApiLevel = SystemProperties.getFirstApiLevel();
        String sakUid = SharedPreferenceHelper.getSakUid(context);
        if (firstApiLevel >= 28) {
            int iCharCount = 0;
            if (sakUid == null || sakUid.isEmpty()) {
                sakUid = this.sksAttestation.getSakUid();
                SharedPreferenceHelper.setSakUid(context, sakUid);
                if (sakUid != null || sakUid.isEmpty()) {
                    KmxLogger.m5528e(TAG, "1-1| FAIL to Get SAK UID.");
                    KmxErrorHandler.throwIfNotSuccess("1-1| FAIL to Get SAK UID.", 3);
                    if (getE2EEDeviceType() == 1) {
                        try {
                            int i = context.getPackageManager().getPackageInfo("com.samsung.android.kmxservice", 128).versionCode;
                            Log.i(TAG, "VC :" + i);
                            if (i < 110138000) {
                                Bundle bundle = new Bundle();
                                bundle.putString(KMX_CONSTANT.KMX_SAK_UID, sakUid);
                                context.getContentResolver().call(Uri.parse(KMX_CONSTANT.KMX_E2EE_URI), KMX_CMD.KMX_SET_SAK_UID, (String) null, bundle);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                } else {
                    int length = sakUid.length();
                    while (iCharCount < length) {
                        int iCodePointAt = sakUid.codePointAt(iCharCount);
                        if (!Character.isWhitespace(iCodePointAt)) {
                            break;
                        }
                        iCharCount += Character.charCount(iCodePointAt);
                    }
                    KmxLogger.m5528e(TAG, "1-1| FAIL to Get SAK UID.");
                    KmxErrorHandler.throwIfNotSuccess("1-1| FAIL to Get SAK UID.", 3);
                    if (getE2EEDeviceType() == 1) {
                    }
                }
            } else {
                int length2 = sakUid.length();
                int iCharCount2 = 0;
                while (iCharCount2 < length2) {
                    int iCodePointAt2 = sakUid.codePointAt(iCharCount2);
                    if (!Character.isWhitespace(iCodePointAt2)) {
                        break;
                    }
                    iCharCount2 += Character.charCount(iCodePointAt2);
                }
                sakUid = this.sksAttestation.getSakUid();
                SharedPreferenceHelper.setSakUid(context, sakUid);
                if (sakUid != null) {
                    KmxLogger.m5528e(TAG, "1-1| FAIL to Get SAK UID.");
                    KmxErrorHandler.throwIfNotSuccess("1-1| FAIL to Get SAK UID.", 3);
                    if (getE2EEDeviceType() == 1) {
                    }
                }
            }
        } else {
            KmxLogger.m5528e(TAG, "This model doesn't support SAK. FirstApiLevel : " + firstApiLevel);
            KmxErrorHandler.throwIfNotSuccess("1-3| FAIL to Get SAK UID", 3);
        }
        KmxLogger.m5529i(TAG, "[getSAKUid] : " + sakUid);
        return sakUid;
    }
}
