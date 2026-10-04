package com.samsung.android.support.senl.p148nt.coedit.log;

import com.samsung.android.support.senl.p145cm.base.framework.support.LoggerBase;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class CoeditLogger {
    private static final String TAG = "NotesCoedit$";

    /* JADX INFO: renamed from: d */
    public static void m8919d(String str, String str2) {
        LoggerBase.m7125d(TAG.concat(str), str2);
    }

    /* JADX INFO: renamed from: e */
    public static void m8920e(String str, String str2) {
        LoggerBase.m7126e(TAG.concat(str), str2);
    }

    /* JADX INFO: renamed from: f */
    public static void m8922f(String str, String str2) {
        LoggerBase.m7128f(TAG.concat(str), str2);
    }

    public static String getEncode(String str) {
        return LoggerBase.getEncode(str);
    }

    /* JADX INFO: renamed from: i */
    public static void m8923i(String str, String str2) {
        LoggerBase.m7130i(TAG.concat(str), str2);
    }

    public static String pii(String str) {
        return LoggerBase.pii(str);
    }

    /* JADX INFO: renamed from: w */
    public static void m8924w(String str, String str2) {
        LoggerBase.m7131w(TAG.concat(str), str2);
    }

    /* JADX INFO: renamed from: e */
    public static void m8921e(String str, String str2, Throwable th) {
        LoggerBase.m7127e(TAG.concat(str), str2, th);
    }
}
