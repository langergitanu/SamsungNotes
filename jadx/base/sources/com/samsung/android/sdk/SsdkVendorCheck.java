package com.samsung.android.sdk;

import android.os.Build;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class SsdkVendorCheck {
    private static String strBrand = Build.BRAND;
    private static String strManufacturer = Build.MANUFACTURER;

    private SsdkVendorCheck() {
    }

    public static boolean isSamsungDevice() {
        String str = strBrand;
        if (str == null || strManufacturer == null) {
            return false;
        }
        return str.compareToIgnoreCase("Samsung") == 0 || strManufacturer.compareToIgnoreCase("Samsung") == 0;
    }
}
