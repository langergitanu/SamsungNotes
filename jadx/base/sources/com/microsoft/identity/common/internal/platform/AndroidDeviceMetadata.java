package com.microsoft.identity.common.internal.platform;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import androidx.collection.AbstractC0622a;
import com.microsoft.identity.common.java.logging.Logger;
import com.microsoft.identity.common.java.platform.AbstractDeviceMetadata;
import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class AndroidDeviceMetadata extends AbstractDeviceMetadata {
    private static final String ANDROID_DEVICE_TYPE = "Android";
    private static final String DEVICE_TYPE = "DeviceType";
    private static final String MOBILE_DEVICE = "mobileDevice";
    private static final String TAG = "AndroidDeviceMetadata";
    private static final String UNKNOWN_DEVICE = "unknown";

    public static String getAndroidDeviceTypeFromMetadata(@NonNull Context context) {
        if (context == null) {
            throw new NullPointerException("context is marked non-null but is null");
        }
        String strM1170p = AbstractC0622a.m1170p(TAG, " :getDeviceType", new StringBuilder());
        try {
            String string = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getString(DEVICE_TYPE, MOBILE_DEVICE);
            Logger.verbose(strM1170p, "Setting the deviceType as " + string);
            return string;
        } catch (PackageManager.NameNotFoundException unused) {
            Logger.warn(strM1170p, "Unable to find the app's package name from PackageManager.");
            return "unknown";
        }
    }

    @Override // com.microsoft.identity.common.java.platform.IDeviceMetadata
    @NonNull
    public String getCpu() {
        String[] strArr = Build.SUPPORTED_ABIS;
        return (strArr == null || strArr.length <= 0) ? "UNKNOWN" : strArr[0];
    }

    @Override // com.microsoft.identity.common.java.platform.IDeviceMetadata
    @NonNull
    public String getDeviceModel() {
        return Build.MODEL;
    }

    @Override // com.microsoft.identity.common.java.platform.IDeviceMetadata
    @NonNull
    public String getDeviceType() {
        return "Android";
    }

    @Override // com.microsoft.identity.common.java.platform.IDeviceMetadata
    @NonNull
    public String getManufacturer() {
        return Build.MANUFACTURER;
    }

    @Override // com.microsoft.identity.common.java.platform.IDeviceMetadata
    @NonNull
    public String getOsForDrs() {
        return Build.VERSION.RELEASE;
    }

    @Override // com.microsoft.identity.common.java.platform.IDeviceMetadata
    @NonNull
    public String getOsForEsts() {
        return String.valueOf(Build.VERSION.SDK_INT);
    }

    @Override // com.microsoft.identity.common.java.platform.IDeviceMetadata
    @NonNull
    public String getOsForMats() {
        return Build.VERSION.RELEASE;
    }
}
