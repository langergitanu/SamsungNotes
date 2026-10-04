package com.samsung.android.sdk.smp.common.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class PackageManagerUtil {
    public static final String FEATURE_DEVICE_CATEGORY_VST = "com.samsung.feature.device_category_vst";

    public static ApplicationInfo getApplicationInfo(Context context, String str, int i) {
        PackageManager packageManager = context.getPackageManager();
        return Build.VERSION.SDK_INT < 33 ? packageManager.getApplicationInfo(str, i) : packageManager.getApplicationInfo(str, PackageManager.ApplicationInfoFlags.of(i));
    }

    public static PackageInfo getPackageInfo(Context context, String str, int i) {
        PackageManager packageManager = context.getPackageManager();
        return Build.VERSION.SDK_INT < 33 ? packageManager.getPackageInfo(str, i) : packageManager.getPackageInfo(str, PackageManager.PackageInfoFlags.of(i));
    }

    public static boolean hasSystemFeature(Context context, String str) {
        return context.getPackageManager().hasSystemFeature(str);
    }
}
