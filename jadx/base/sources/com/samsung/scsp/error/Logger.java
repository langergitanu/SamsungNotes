package com.samsung.scsp.error;

import android.os.Build;
import android.util.Log;
import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.scsp.framework.core.identity.IdentityApiContract;
import java.util.Locale;
import java.util.function.Supplier;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class Logger {
    private final String tag;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class LazyHolder {
        private static final boolean DEBUG = !IdentityApiContract.Token.USER.equals(Build.TYPE);
        private static LoggerConfig LOGGER_CONFIG = new LoggerConfig("[SCSPSDK]");

        private LazyHolder() {
        }
    }

    private Logger(String str) {
        this.tag = AbstractC0541b.m776r(new StringBuilder(), LazyHolder.LOGGER_CONFIG.tag.get(), "[", str, "]");
    }

    public static Logger get(String str) {
        return new Logger(str);
    }

    public static void initialize(LoggerConfig loggerConfig) {
        LazyHolder.LOGGER_CONFIG = loggerConfig;
    }

    /* JADX INFO: renamed from: d */
    public void m12931d(Supplier<String> supplier) {
        if (!LazyHolder.DEBUG || supplier == null) {
            return;
        }
        Log.d(this.tag, supplier.get());
    }

    /* JADX INFO: renamed from: e */
    public void m12933e(String str, Throwable th) {
        if (str == null || th == null) {
            return;
        }
        Locale locale = Locale.US;
        Log.e(this.tag, AbstractC0541b.m774p("[E] ", str, " ", Log.getStackTraceString(th)));
    }

    /* JADX INFO: renamed from: i */
    public void m12934i(String str) {
        if (str != null) {
            Log.i(this.tag, str);
        }
    }

    /* JADX INFO: renamed from: w */
    public void m12935w(String str) {
        if (str != null) {
            Log.w(this.tag, str);
        }
    }

    /* JADX INFO: renamed from: e */
    public void m12932e(String str) {
        if (str != null) {
            Log.e(this.tag, str);
        }
    }
}
