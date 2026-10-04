package com.samsung.android.kmxservice.sdk.util;

import android.util.Log;
import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.kmxservice.sdk.e2ee.data.LogTag;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class SystemProperties {
    public static final int BUILD_TYPE_ENG = 2;
    public static final int BUILD_TYPE_USER = 0;
    public static final int BUILD_TYPE_USERDEBUG = 1;
    private static final String GET_PROP_EXECUTABLE_PATH = "/system/bin/getprop";
    public static final int ONE_UI_5_1_1 = 50101;
    public static final int ONE_UI_7_1 = 70100;
    private static final String PROP_BUILD_SYSTEM_NAME = "ro.product.system.name";
    private static final String PROP_BUILD_TYPE = "ro.build.type";
    private static final String PROP_FIRST_API_LEVEL = "ro.product.first_api_level";
    private static final String PROP_ONEUI_VERSION = "ro.build.version.oneui";
    private static final String TAG = LogTag.getTag("SystemProperties");

    public static String get(String str) {
        try {
            return SystemPropertiesInternal.get(str, "");
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(TAG, "SysProp e:" + e.getMessage());
            return null;
        }
    }

    public static int getBuildType() {
        String str = get(PROP_BUILD_TYPE);
        str.getClass();
        switch (str) {
            case "eng":
                return 2;
            case "user":
                return 0;
            case "userdebug":
                return 1;
            default:
                return -1;
        }
    }

    public static int getFirstApiLevel() {
        int i = getInt(PROP_FIRST_API_LEVEL);
        String str = TAG;
        AbstractC0541b.m755A(i, "firstApiLevel :", str);
        if (i == 0) {
            Log.e(str, "FirstApiLevel is empty");
        }
        return i;
    }

    public static int getInt(String str) {
        return SystemPropertiesInternal.getInt(str, 0);
    }

    public static int getOneUiVersion() {
        return getInt(PROP_ONEUI_VERSION);
    }

    public static boolean isModelVST() {
        return get(PROP_BUILD_SYSTEM_NAME).contains("xrvst");
    }

    public static boolean isMoreThanOneUI511() {
        return getOneUiVersion() >= 50101;
    }

    public static boolean isMoreThanOneUI71() {
        return getOneUiVersion() >= 70100;
    }

    public static boolean isPossibleUseFloatingFeature() {
        Class<?> cls;
        try {
            cls = Class.forName("com.samsung.android.feature.FloatingFeature");
        } catch (ClassNotFoundException e) {
            Log.i(TAG, "[isPossibleUseFloatingFeature] can not load FloatingFeature, " + e.getLocalizedMessage());
            cls = null;
        }
        if (cls == null) {
            try {
                cls = Class.forName("com.samsung.android.feature.SemFloatingFeature");
            } catch (ClassNotFoundException e2) {
                Log.i(TAG, "[isPossibleUseFloatingFeature] can not load semFloatingFeature, " + e2.getLocalizedMessage());
            }
        }
        return cls != null;
    }
}
