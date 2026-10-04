package com.google.android.datatransport.runtime.logging;

import android.util.Log;
import androidx.appcompat.widget.AbstractC0541b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class Logging {
    private static final String LOG_PREFIX = "TRuntime.";
    private static final int MAX_LOG_TAG_SIZE_IN_SDK_N = 23;

    private Logging() {
    }

    private static String concatTag(String str, String str2) {
        String strM756B = AbstractC0541b.m756B(str, str2);
        return strM756B.length() > 23 ? strM756B.substring(0, 23) : strM756B;
    }

    /* JADX INFO: renamed from: d */
    public static void m3133d(String str, String str2) {
        String tag = getTag(str);
        if (Log.isLoggable(tag, 3)) {
            Log.d(tag, str2);
        }
    }

    /* JADX INFO: renamed from: e */
    public static void m3137e(String str, String str2, Throwable th) {
        String tag = getTag(str);
        if (Log.isLoggable(tag, 6)) {
            Log.e(tag, str2, th);
        }
    }

    private static String getTag(String str) {
        return AbstractC0541b.m772n(LOG_PREFIX, str);
    }

    /* JADX INFO: renamed from: i */
    public static void m3138i(String str, String str2, Object obj) {
        String tag = getTag(str);
        if (Log.isLoggable(tag, 4)) {
            Log.i(tag, String.format(str2, obj));
        }
    }

    /* JADX INFO: renamed from: w */
    public static void m3139w(String str, String str2, Object obj) {
        String tag = getTag(str);
        if (Log.isLoggable(tag, 5)) {
            Log.w(tag, String.format(str2, obj));
        }
    }

    /* JADX INFO: renamed from: d */
    public static void m3134d(String str, String str2, Object obj) {
        String tag = getTag(str);
        if (Log.isLoggable(tag, 3)) {
            Log.d(tag, String.format(str2, obj));
        }
    }

    /* JADX INFO: renamed from: d */
    public static void m3135d(String str, String str2, Object obj, Object obj2) {
        String tag = getTag(str);
        if (Log.isLoggable(tag, 3)) {
            Log.d(tag, String.format(str2, obj, obj2));
        }
    }

    /* JADX INFO: renamed from: d */
    public static void m3136d(String str, String str2, Object... objArr) {
        String tag = getTag(str);
        if (Log.isLoggable(tag, 3)) {
            Log.d(tag, String.format(str2, objArr));
        }
    }
}
