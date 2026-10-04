package com.samsung.android.support.senl.document.delegator;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class DocumentLogger {
    /* JADX INFO: renamed from: d */
    public static void m7178d(String str, String str2) {
        AppDelegator.getInstance().logger_d(str, str2);
    }

    /* JADX INFO: renamed from: e */
    public static void m7179e(String str, String str2) {
        AppDelegator.getInstance().logger_e(str, str2);
    }

    public static String getEncode(String str) {
        return AppDelegator.getInstance().logger_getEncode(str);
    }

    public static String getLogFilePath(Context context) {
        return AppDelegator.getInstance().logger_getLogFilePath(context);
    }

    /* JADX INFO: renamed from: i */
    public static void m7181i(String str, String str2) {
        AppDelegator.getInstance().logger_i(str, str2);
    }

    /* JADX INFO: renamed from: e */
    public static void m7180e(String str, String str2, Throwable th) {
        AppDelegator.getInstance().logger_e(str, str2, th);
    }
}
