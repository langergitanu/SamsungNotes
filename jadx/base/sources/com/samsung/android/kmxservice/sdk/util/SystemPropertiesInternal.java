package com.samsung.android.kmxservice.sdk.util;

import android.util.Log;
import com.samsung.android.kmxservice.sdk.e2ee.data.LogTag;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class SystemPropertiesInternal {
    private static final String TAG = LogTag.getTag("SysProps");

    private SystemPropertiesInternal() {
    }

    public static String get(String str, String str2) {
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class, String.class).invoke(null, str, str2);
        } catch (Exception e) {
            Log.e(TAG, "Exception while getting system property: ", e);
            return str2;
        }
    }

    public static int getInt(String str, int i) {
        try {
            return ((Integer) Class.forName("android.os.SystemProperties").getMethod("getInt", String.class, Integer.TYPE).invoke(null, str, Integer.valueOf(i))).intValue();
        } catch (Exception e) {
            Log.e(TAG, "Exception while getting system int property: ", e);
            return i;
        }
    }
}
