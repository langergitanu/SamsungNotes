package com.samsung.scsp.framework.core.decorator;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
class PlatformConfigurationPreference {
    public static final String PREF = "scsp.platform.configuration.preferences";

    public static long getLong(Context context, String str) {
        return context.getSharedPreferences(PREF, 0).getLong(str, 0L);
    }

    public static String getString(Context context, String str) {
        return context.getSharedPreferences(PREF, 0).getString(str, "");
    }

    public static void putLong(Context context, String str, long j) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences(PREF, 0).edit();
        editorEdit.putLong(str, j);
        editorEdit.apply();
    }

    public static void putString(Context context, String str, String str2) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences(PREF, 0).edit();
        editorEdit.putString(str, str2);
        editorEdit.apply();
    }
}
