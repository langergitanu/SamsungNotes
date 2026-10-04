package com.samsung.android.support.senl.p148nt.data.common.log;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.support.senl.p145cm.base.framework.support.LoggerBase;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class DataLogger {
    private static final String PERFORMANCE = "ntData$#Perf#";
    private static final int PRINT_STACK_TRACE_LINE_MAX = 10;
    private static final String TAG = "ntData$";

    public static String createTag(@NonNull String str) {
        return AbstractC0541b.m772n(TAG, str);
    }

    /* JADX INFO: renamed from: d */
    public static void m12302d(String str, String str2) {
        LoggerBase.m7125d(str, str2);
    }

    /* JADX INFO: renamed from: e */
    public static void m12303e(String str, String str2) {
        LoggerBase.m7126e(str, str2);
    }

    /* JADX INFO: renamed from: f */
    public static void m12305f(String str, String str2) {
        LoggerBase.m7128f(str, str2);
    }

    public static String getEncode(String str) {
        return LoggerBase.getEncode(str);
    }

    /* JADX INFO: renamed from: i */
    public static void m12307i(String str, String str2) {
        LoggerBase.m7130i(str, str2);
    }

    /* JADX INFO: renamed from: p */
    public static void m12308p(String str, String str2) {
        LoggerBase.m7130i(PERFORMANCE.concat(str), str2);
    }

    public static String pii(String str) {
        return LoggerBase.pii(str);
    }

    public static void printMemory(@NonNull String str, @NonNull String str2) {
        LoggerBase.printMemory(str, str2);
    }

    public static void printStackTrace(String str, Throwable th) {
        StringBuilder sb = new StringBuilder();
        if (th != null) {
            StackTraceElement[] stackTrace = th.getStackTrace();
            int iMin = Math.min(stackTrace.length, 10);
            for (int i = 0; i < iMin; i++) {
                sb.append(stackTrace[i].toString());
                sb.append('\n');
            }
        }
        m12305f(str, sb.toString());
    }

    /* JADX INFO: renamed from: w */
    public static void m12309w(String str, String str2) {
        LoggerBase.m7131w(str, str2);
    }

    /* JADX INFO: renamed from: e */
    public static void m12304e(String str, String str2, Throwable th) {
        LoggerBase.m7127e(str, str2, th);
    }

    /* JADX INFO: renamed from: f */
    public static void m12306f(String str, String str2, Throwable th) {
        LoggerBase.m7129f(str, str2, th);
    }
}
