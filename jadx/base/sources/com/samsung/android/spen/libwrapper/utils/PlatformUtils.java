package com.samsung.android.spen.libwrapper.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class PlatformUtils {
    public static final String DEVICE_BUILD_MANUFACTURER = "DEVICE_BUILD_MANUFACTURER";
    private static final String SAMSUNG_DEVICE_NAME = "Samsung";

    public static final boolean isPlatformSupportHoverUI(Context context) {
        return context.getPackageManager().hasSystemFeature("com.sec.feature.hovering_ui");
    }

    public static final boolean isSamsungDevice(Context context) {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        String string = defaultSharedPreferences.getString(DEVICE_BUILD_MANUFACTURER, null);
        boolean zIsEmpty = TextUtils.isEmpty(string);
        boolean z = true;
        String str = SAMSUNG_DEVICE_NAME;
        if (!zIsEmpty) {
            return SAMSUNG_DEVICE_NAME.equalsIgnoreCase(string);
        }
        String str2 = Build.MANUFACTURER;
        if (str2 == null || !Pattern.compile(Pattern.quote(SAMSUNG_DEVICE_NAME), 2).matcher(str2).find()) {
            str = str2;
            z = false;
        }
        SharedPreferences.Editor editorEdit = defaultSharedPreferences.edit();
        editorEdit.putString(DEVICE_BUILD_MANUFACTURER, str);
        editorEdit.apply();
        return z;
    }

    public static final boolean isSemDevice(Context context) {
        PackageManager packageManager = context.getPackageManager();
        return packageManager.hasSystemFeature("com.samsung.feature.samsung_experience_mobile") || packageManager.hasSystemFeature("com.samsung.feature.samsung_experience_mobile_lite");
    }

    public static final boolean isSemDevice() {
        return ReflectUtils.getField(Build.VERSION.class, "SEM_INT") != null;
    }
}
