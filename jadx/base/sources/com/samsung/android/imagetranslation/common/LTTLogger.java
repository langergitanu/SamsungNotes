package com.samsung.android.imagetranslation.common;

import android.os.Build;
import android.util.Log;
import com.google.android.gms.common.data.AbstractC4539a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class LTTLogger {
    public static String LOG_TAG = null;
    public static final String TIME_TAKEN_TAG = "PROFILING ";
    private static final boolean USE_VERBOSE_LOG;

    static {
        String str = Build.TYPE;
        USE_VERBOSE_LOG = str.contentEquals("eng") || str.contentEquals("userdebug");
        LOG_TAG = "LTT_J ";
    }

    /* JADX INFO: renamed from: d */
    public static void m5458d(String str, String str2) {
        if (USE_VERBOSE_LOG) {
            Log.d(str, LOG_TAG + str2);
        }
    }

    /* JADX INFO: renamed from: e */
    public static void m5459e(String str, String str2) {
        Log.e(str, LOG_TAG + str2);
    }

    /* JADX INFO: renamed from: h */
    public static void m5460h(String str, String str2) {
        if (Dump.isDumpEnabled()) {
            Log.d(str, LOG_TAG + str2);
        }
    }

    /* JADX INFO: renamed from: i */
    public static void m5461i(String str, String str2) {
        AbstractC4539a.m3209s(new StringBuilder(), LOG_TAG, str2, str);
    }

    /* JADX INFO: renamed from: p */
    public static void m5462p(String str, String str2) {
        if (Dump.isDumpEnabled()) {
            Log.v(str, LOG_TAG + TIME_TAKEN_TAG + str2);
        }
    }

    /* JADX INFO: renamed from: v */
    public static void m5463v(String str, String str2) {
        if (USE_VERBOSE_LOG) {
            Log.v(str, LOG_TAG + str2);
        }
    }

    /* JADX INFO: renamed from: w */
    public static void m5464w(String str, String str2) {
        Log.w(str, LOG_TAG + str2);
    }
}
