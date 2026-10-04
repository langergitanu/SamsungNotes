package org.slf4j;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public class LoggerFactoryFriend {
    public static void reset() {
        LoggerFactory.reset();
    }

    public static void setDetectLoggerNameMismatch(boolean z) {
        LoggerFactory.DETECT_LOGGER_NAME_MISMATCH = z;
    }
}
