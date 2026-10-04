package com.samsung.android.livetranslation.util;

import android.os.Build;
import android.util.Log;
import com.google.android.gms.common.data.AbstractC4539a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class LTTLogger {
    public static String LOG_TAG = null;
    public static final String TIME_TAKEN_TAG = "TIME_TAKEN ";
    private static final boolean USE_VERBOSE_LOG;

    static {
        String str = Build.TYPE;
        USE_VERBOSE_LOG = str.contentEquals("eng") || str.contentEquals("userdebug");
        LOG_TAG = "LTT_4x ";
    }

    /* JADX INFO: renamed from: d */
    public static void m5581d(String str, String str2) {
        if (USE_VERBOSE_LOG) {
            Log.d(str, LOG_TAG + str2);
        }
    }

    /* JADX INFO: renamed from: e */
    public static void m5582e(String str, String str2) {
        Log.e(str, LOG_TAG + str2);
    }

    /* JADX INFO: renamed from: i */
    public static void m5583i(String str, String str2) {
        AbstractC4539a.m3209s(new StringBuilder(), LOG_TAG, str2, str);
    }

    /* JADX INFO: renamed from: p */
    public static void m5584p(String str, String str2) {
        Log.v(str, LOG_TAG + TIME_TAKEN_TAG + str2);
    }

    /* JADX INFO: renamed from: v */
    public static void m5585v(String str, String str2) {
        if (USE_VERBOSE_LOG) {
            Log.v(str, LOG_TAG + str2);
        }
    }

    /* JADX INFO: renamed from: w */
    public static void m5586w(String str, String str2) {
        Log.w(str, LOG_TAG + str2);
    }
}
