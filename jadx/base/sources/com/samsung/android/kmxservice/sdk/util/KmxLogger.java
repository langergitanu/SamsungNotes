package com.samsung.android.kmxservice.sdk.util;

import android.util.Log;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class KmxLogger {
    private static final String TAG = "KMX|";

    /* JADX INFO: renamed from: d */
    public static int m5527d(String str, String str2) {
        return Log.d(TAG + str, str2);
    }

    /* JADX INFO: renamed from: e */
    public static int m5528e(String str, String str2) {
        return Log.e(TAG + str, str2);
    }

    /* JADX INFO: renamed from: i */
    public static int m5529i(String str, String str2) {
        return Log.i(TAG + str, str2);
    }
}
