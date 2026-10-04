package com.samsung.context.sdk.samsunganalytics.internal.util;

import android.util.Log;
import androidx.constraintlayout.motion.widget.AbstractC2322a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class Debug {
    private static final String LOGTAG = "SamsungAnalytics605079";
    private static final String LOGWING_PREFIX = "[LOGWING]";

    public static void LogD(String str) {
        Log.d(LOGTAG, str);
    }

    public static void LogE(String str) {
        Log.e(LOGTAG, str);
    }

    public static void LogENG(String str) {
        if (Utils.isDev()) {
            AbstractC2322a.m1609C("[DEBUG ONLY] ", str, LOGTAG);
        }
    }

    public static void LogException(Class cls, Exception exc) {
        if (exc != null) {
            Log.w(LOGTAG, "[" + cls.getSimpleName() + "] " + exc.getClass().getSimpleName() + " " + exc.getMessage());
        }
    }

    public static void LogI(String str) {
        Log.i(LOGTAG, str);
    }

    public static void LogW(String str) {
        Log.w(LOGTAG, str);
    }

    public static void logwingE(String str) {
        AbstractC2322a.m1636z(LOGWING_PREFIX, str, LOGTAG);
    }

    public static void logwingW(String str) {
        Log.w(LOGTAG, LOGWING_PREFIX + str);
    }

    public static void LogD(String str, String str2) {
        LogD("[" + str + "] " + str2);
    }

    public static void LogE(String str, String str2) {
        LogE("[" + str + "] " + str2);
    }
}
