package com.microsoft.identity.common.logging;

import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.microsoft.identity.common.java.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class Logger {
    private static final String ANDROID_EXTERNAL_LOGGER_IDENTIFIER = "ANDROID_EXTERNAL_LOGGER";
    private static final String ANDROID_LOGCAT_LOGGER_IDENTIFIER = "ANDROID_LOGCAT_LOGGER";
    private static final Logger INSTANCE = new Logger();
    private static boolean sAllowLogcat = false;

    /* JADX INFO: renamed from: com.microsoft.identity.common.logging.Logger$3 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C64473 {

        /* JADX INFO: renamed from: $SwitchMap$com$microsoft$identity$common$java$logging$Logger$LogLevel */
        static final /* synthetic */ int[] f3612x8dd05ff9;
        static final /* synthetic */ int[] $SwitchMap$com$microsoft$identity$common$logging$Logger$LogLevel;

        static {
            int[] iArr = new int[Logger.LogLevel.values().length];
            f3612x8dd05ff9 = iArr;
            try {
                iArr[Logger.LogLevel.INFO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3612x8dd05ff9[Logger.LogLevel.WARN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3612x8dd05ff9[Logger.LogLevel.ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3612x8dd05ff9[Logger.LogLevel.NO_LOG.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3612x8dd05ff9[Logger.LogLevel.VERBOSE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            int[] iArr2 = new int[LogLevel.values().length];
            $SwitchMap$com$microsoft$identity$common$logging$Logger$LogLevel = iArr2;
            try {
                iArr2[LogLevel.INFO.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$microsoft$identity$common$logging$Logger$LogLevel[LogLevel.WARN.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$microsoft$identity$common$logging$Logger$LogLevel[LogLevel.ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$microsoft$identity$common$logging$Logger$LogLevel[LogLevel.NO_LOG.ordinal()] = 4;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum LogLevel {
        NO_LOG,
        ERROR,
        WARN,
        INFO,
        VERBOSE;

        /* JADX INFO: Access modifiers changed from: private */
        public static LogLevel convertFromJavaLogLevel(@NonNull Logger.LogLevel logLevel) {
            int i = C64473.f3612x8dd05ff9[logLevel.ordinal()];
            return i != 1 ? i != 2 ? i != 3 ? i != 4 ? VERBOSE : NO_LOG : ERROR : WARN : INFO;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Logger.LogLevel convertToJavaLogLevel() {
            int i = C64473.$SwitchMap$com$microsoft$identity$common$logging$Logger$LogLevel[ordinal()];
            return i != 1 ? i != 2 ? i != 3 ? i != 4 ? Logger.LogLevel.VERBOSE : Logger.LogLevel.NO_LOG : Logger.LogLevel.ERROR : Logger.LogLevel.WARN : Logger.LogLevel.INFO;
        }
    }

    static {
        setAndroidLogger();
    }

    public static void error(String str, @Nullable String str2, @Nullable Throwable th) {
        com.microsoft.identity.common.java.logging.Logger.error(str, str2, th);
    }

    public static void errorPII(String str, @Nullable String str2, @Nullable Throwable th) {
        com.microsoft.identity.common.java.logging.Logger.errorPII(str, str2, th);
    }

    public static boolean getAllowLogcat() {
        return sAllowLogcat;
    }

    public static boolean getAllowPii() {
        return com.microsoft.identity.common.java.logging.Logger.isAllowPii();
    }

    public static String getDiagnosticContextMetadata() {
        return com.microsoft.identity.common.java.logging.Logger.getDiagnosticContextMetadata();
    }

    public static Logger getInstance() {
        return INSTANCE;
    }

    public static void info(String str, @Nullable String str2) {
        com.microsoft.identity.common.java.logging.Logger.info(str, str2);
    }

    public static void infoPII(String str, @Nullable String str2) {
        com.microsoft.identity.common.java.logging.Logger.infoPII(str, str2);
    }

    public static void setAllowLogcat(boolean z) {
        sAllowLogcat = z;
    }

    public static void setAllowPii(boolean z) {
        com.microsoft.identity.common.java.logging.Logger.setAllowPii(z);
    }

    public static void setAndroidLogger() {
        com.microsoft.identity.common.java.logging.Logger.setLogger(ANDROID_LOGCAT_LOGGER_IDENTIFIER, new com.microsoft.identity.common.java.logging.ILoggerCallback() { // from class: com.microsoft.identity.common.logging.Logger.1
            @Override // com.microsoft.identity.common.java.logging.ILoggerCallback
            public void log(String str, Logger.LogLevel logLevel, String str2, boolean z) {
                if (Logger.sAllowLogcat) {
                    int i = C64473.f3612x8dd05ff9[logLevel.ordinal()];
                    if (i == 1) {
                        Log.i(str, str2);
                        return;
                    }
                    if (i == 2) {
                        Log.w(str, str2);
                    } else if (i == 3) {
                        Log.e(str, str2);
                    } else {
                        if (i != 5) {
                            return;
                        }
                        Log.v(str, str2);
                    }
                }
            }
        });
        com.microsoft.identity.common.java.logging.Logger.setPlatformString("Android " + Build.VERSION.SDK_INT);
    }

    public static void verbose(String str, @Nullable String str2) {
        com.microsoft.identity.common.java.logging.Logger.verbose(str, str2);
    }

    public static void verbosePII(String str, @Nullable String str2) {
        com.microsoft.identity.common.java.logging.Logger.verbosePII(str, str2);
    }

    public static void warn(String str, @Nullable String str2) {
        com.microsoft.identity.common.java.logging.Logger.warn(str, str2);
    }

    public static void warnPII(String str, @Nullable String str2) {
        com.microsoft.identity.common.java.logging.Logger.warnPII(str, str2);
    }

    public void setExternalLogger(final ILoggerCallback iLoggerCallback) {
        com.microsoft.identity.common.java.logging.Logger.setLogger(ANDROID_EXTERNAL_LOGGER_IDENTIFIER, new com.microsoft.identity.common.java.logging.ILoggerCallback() { // from class: com.microsoft.identity.common.logging.Logger.2
            @Override // com.microsoft.identity.common.java.logging.ILoggerCallback
            public void log(String str, Logger.LogLevel logLevel, String str2, boolean z) {
                iLoggerCallback.log(str, LogLevel.convertFromJavaLogLevel(logLevel), str2, z);
            }
        });
    }

    public void setLogLevel(LogLevel logLevel) {
        com.microsoft.identity.common.java.logging.Logger.setLogLevel(logLevel.convertToJavaLogLevel());
    }

    public static void error(String str, @Nullable String str2, @Nullable String str3, @Nullable Throwable th) {
        com.microsoft.identity.common.java.logging.Logger.error(str, str2, str3, th);
    }

    public static void errorPII(String str, @Nullable String str2, @Nullable String str3, @Nullable Throwable th) {
        com.microsoft.identity.common.java.logging.Logger.errorPII(str, str2, str3, th);
    }

    public static void info(String str, @Nullable String str2, @Nullable String str3) {
        com.microsoft.identity.common.java.logging.Logger.info(str, str2, str3);
    }

    public static void infoPII(String str, @Nullable String str2, @Nullable String str3) {
        com.microsoft.identity.common.java.logging.Logger.infoPII(str, str2, str3);
    }

    public static void verbose(String str, @Nullable String str2, @Nullable String str3) {
        com.microsoft.identity.common.java.logging.Logger.verbose(str, str2, str3);
    }

    public static void verbosePII(String str, String str2, @Nullable String str3) {
        com.microsoft.identity.common.java.logging.Logger.verbosePII(str, str2, str3);
    }

    public static void warn(String str, @Nullable String str2, @Nullable String str3) {
        com.microsoft.identity.common.java.logging.Logger.warn(str, str2, str3);
    }

    public static void warnPII(String str, @Nullable String str2, @Nullable String str3) {
        com.microsoft.identity.common.java.logging.Logger.warnPII(str, str2, str3);
    }
}
