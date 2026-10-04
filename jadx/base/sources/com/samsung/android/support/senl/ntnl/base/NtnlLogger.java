package com.samsung.android.support.senl.ntnl.base;

import android.util.Log;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class NtnlLogger {
    protected static final String BASE_TAG = "NTNL$";

    /* JADX INFO: renamed from: d */
    public static void m12806d(String str, String str2) {
        Log.d(BASE_TAG.concat(str), str2);
    }

    /* JADX INFO: renamed from: e */
    public static void m12807e(String str, String str2) {
        String strConcat = BASE_TAG.concat(str);
        if (str2 == null) {
            str2 = "";
        }
        Log.e(strConcat, str2);
    }

    /* JADX INFO: renamed from: i */
    public static void m12809i(String str, String str2) {
        Log.i(BASE_TAG.concat(str), str2);
    }

    /* JADX INFO: renamed from: w */
    public static void m12810w(String str, String str2) {
        Log.w(BASE_TAG.concat(str), str2);
    }

    /* JADX INFO: renamed from: e */
    public static void m12808e(String str, String str2, Throwable th) {
        Log.e(BASE_TAG.concat(str), str2, th);
    }
}
