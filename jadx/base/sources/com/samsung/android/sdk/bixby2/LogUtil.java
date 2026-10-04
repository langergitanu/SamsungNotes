package com.samsung.android.sdk.bixby2;

import android.util.Log;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class LogUtil {
    public static final String KEY_ENGINEERING_MODE = "engineeringMode";
    private static final String PREFIX_IUG = "IUG# ";
    private static boolean sEngineeringMode;

    /* JADX INFO: renamed from: c */
    public static void m5744c(String str, String str2) {
        if (sEngineeringMode) {
            AbstractC6670b.m4756q(PREFIX_IUG, str2, str);
        }
    }

    /* JADX INFO: renamed from: d */
    public static void m5745d(String str, String str2) {
    }

    /* JADX INFO: renamed from: e */
    public static void m5746e(String str, String str2) {
        Log.e(str, str2);
    }

    /* JADX INFO: renamed from: i */
    public static void m5747i(String str, String str2) {
        Log.i(str, str2);
    }

    public static void setEngineeringMode(boolean z) {
        sEngineeringMode = z;
    }

    /* JADX INFO: renamed from: v */
    public static void m5748v(String str, String str2) {
    }

    /* JADX INFO: renamed from: w */
    public static void m5749w(String str, String str2) {
    }
}
