package com.airbnb.lottie.utils;

import com.airbnb.lottie.LottieLogger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class Logger {
    private static LottieLogger INSTANCE = new LogcatLogger();

    public static void debug(String str) {
        INSTANCE.debug(str);
    }

    public static void error(String str, Throwable th) {
        INSTANCE.error(str, th);
    }

    public static void setInstance(LottieLogger lottieLogger) {
        INSTANCE = lottieLogger;
    }

    public static void warning(String str) {
        INSTANCE.warning(str);
    }

    public static void debug(String str, Throwable th) {
        INSTANCE.debug(str, th);
    }

    public static void warning(String str, Throwable th) {
        INSTANCE.warning(str, th);
    }
}
