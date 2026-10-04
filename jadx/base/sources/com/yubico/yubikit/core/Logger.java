package com.yubico.yubikit.core;

import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Deprecated
public abstract class Logger {

    @Nullable
    static Logger instance;

    /* JADX INFO: renamed from: d */
    public static void m13502d(String str) {
        Logger logger = instance;
        if (logger != null) {
            logger.logDebug(str);
        }
    }

    /* JADX INFO: renamed from: e */
    public static void m13503e(String str, Throwable th) {
        Logger logger = instance;
        if (logger != null) {
            logger.logError(str, th);
        }
    }

    public static void setLogger(@Nullable Logger logger) {
        instance = logger;
        com.yubico.yubikit.core.internal.Logger.setLogger(logger);
    }

    public void logDebug(String str) {
    }

    public void logError(String str, Throwable th) {
    }
}
