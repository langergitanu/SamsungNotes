package com.microsoft.identity.common.java.logging;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.glance.AbstractC2821a;
import com.microsoft.identity.common.java.nativeauth.util.ILoggable;
import com.microsoft.identity.common.java.util.StringUtil;
import com.microsoft.identity.common.java.util.ThrowableUtil;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import edu.umd.cs.findbugs.annotations.Nullable;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class Logger {
    private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    private static final String UNSET = "UNSET";
    private static final SimpleDateFormat sDateTimeFormatter;
    private static final Object $LOCK = new Object[0];
    private static final ExecutorService sLogExecutor = Executors.newSingleThreadExecutor();
    private static LogLevel sLogLevel = LogLevel.VERBOSE;
    private static boolean sAllowPii = false;
    private static String sPlatformString = "";
    private static final ReentrantReadWriteLock sLoggersLock = new ReentrantReadWriteLock();
    private static final Map<String, ILoggerCallback> sLoggers = new HashMap();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum LogLevel {
        NO_LOG,
        ERROR,
        WARN,
        INFO,
        VERBOSE,
        UNDEFINED
    }

    static {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_FORMAT, Locale.getDefault());
        sDateTimeFormatter = simpleDateFormat;
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
    }

    public static void error(String str, String str2, Throwable th) {
        log(str, LogLevel.ERROR, null, str2, null, th, false);
    }

    public static void errorPII(String str, String str2, Throwable th) {
        log(str, LogLevel.ERROR, null, str2, null, th, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String formatMessage(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @NonNull String str5, @Nullable Throwable th) {
        if (str5 == null) {
            throw new NullPointerException("dateTimeStamp is marked non-null but is null");
        }
        String str6 = "";
        if (StringUtil.isNullOrEmpty(str3)) {
            str3 = "";
        }
        if (StringUtil.isNullOrEmpty(str4)) {
            str4 = "";
        }
        StringBuilder sbM12325j = AbstractC11014a.m12325j("[", str5);
        AbstractC2821a.m2207B(sbM12325j, StringUtil.isNullOrEmpty(str) ? " " : AbstractC0541b.m773o(" - ", str, " "), "- ", str2, "] ");
        AbstractC2821a.m2207B(sbM12325j, str3, " ", str4, " ");
        if (th != null) {
            str6 = "\n" + ThrowableUtil.getStackTraceAsString(th);
        }
        sbM12325j.append(str6);
        return sbM12325j.toString();
    }

    public static synchronized String getDiagnosticContextMetadata() {
        return getDiagnosticContextMetadata(null);
    }

    public static LogLevel getLogLevel() {
        return sLogLevel;
    }

    public static void info(String str, String str2) {
        log(str, LogLevel.INFO, null, str2, null, null, false);
    }

    public static void infoPII(String str, String str2) {
        log(str, LogLevel.INFO, null, str2, null, null, true);
    }

    public static void infoWithObject(String str, String str2, ILoggable iLoggable) {
        if (isAllowPii()) {
            log(str, LogLevel.INFO, null, str2, iLoggable.toUnsanitizedString(), null, iLoggable.containsPii());
        } else {
            log(str, LogLevel.INFO, null, str2, iLoggable.toString(), null, false);
        }
    }

    public static boolean isAllowPii() {
        return sAllowPii;
    }

    private static void log(final String str, @NonNull final LogLevel logLevel, String str2, final String str3, @Nullable final String str4, final Throwable th, final boolean z) {
        if (logLevel == null) {
            throw new NullPointerException("logLevel is marked non-null but is null");
        }
        if (sLogLevel == LogLevel.NO_LOG || logLevel.compareTo(sLogLevel) > 0) {
            return;
        }
        if (sAllowPii || !z) {
            final Date date = new Date();
            final String diagnosticContextMetadata = getDiagnosticContextMetadata(str2);
            sLogExecutor.execute(new Runnable() { // from class: com.microsoft.identity.common.java.logging.Logger.1
                @Override // java.lang.Runnable
                @SuppressFBWarnings(justification = "If logging throws, there is nothing left to do but swallow the exception and move on.", value = {"DE_MIGHT_IGNORE"})
                public void run() {
                    String message = Logger.formatMessage(diagnosticContextMetadata, Logger.sPlatformString, str3, str4, Logger.sDateTimeFormatter.format(date), th);
                    Logger.sLoggersLock.readLock().lock();
                    try {
                        Iterator it = Logger.sLoggers.keySet().iterator();
                        while (it.hasNext()) {
                            try {
                                ILoggerCallback iLoggerCallback = (ILoggerCallback) Logger.sLoggers.get((String) it.next());
                                if (iLoggerCallback != null) {
                                    iLoggerCallback.log(str, logLevel, message, z);
                                }
                            } catch (Exception unused) {
                            }
                        }
                    } finally {
                        Logger.sLoggersLock.readLock().unlock();
                    }
                }
            });
        }
    }

    public static synchronized void resetLogger() {
        ReentrantReadWriteLock reentrantReadWriteLock = sLoggersLock;
        reentrantReadWriteLock.writeLock().lock();
        try {
            sLoggers.clear();
            sAllowPii = false;
            sPlatformString = "";
            sLogLevel = LogLevel.VERBOSE;
            reentrantReadWriteLock.writeLock().unlock();
        } catch (Throwable th) {
            sLoggersLock.writeLock().unlock();
            throw th;
        }
    }

    public static void setAllowPii(boolean z) {
        sAllowPii = z;
    }

    public static void setLogLevel(LogLevel logLevel) {
        sLogLevel = logLevel;
    }

    public static boolean setLogger(@NonNull String str, ILoggerCallback iLoggerCallback) {
        if (str == null) {
            throw new NullPointerException("identifier is marked non-null but is null");
        }
        ReentrantReadWriteLock reentrantReadWriteLock = sLoggersLock;
        reentrantReadWriteLock.writeLock().lock();
        try {
            if (iLoggerCallback == null) {
                sLoggers.remove(str);
            } else {
                Map<String, ILoggerCallback> map = sLoggers;
                if (map.containsValue(iLoggerCallback)) {
                    reentrantReadWriteLock.writeLock().unlock();
                    return false;
                }
                map.put(str, iLoggerCallback);
            }
            reentrantReadWriteLock.writeLock().unlock();
            return true;
        } catch (Throwable th) {
            sLoggersLock.writeLock().unlock();
            throw th;
        }
    }

    public static void setPlatformString(String str) {
        synchronized ($LOCK) {
            sPlatformString = str;
        }
    }

    public static void verbose(String str, String str2) {
        log(str, LogLevel.VERBOSE, null, str2, null, null, false);
    }

    public static void verbosePII(String str, String str2) {
        log(str, LogLevel.VERBOSE, null, str2, null, null, true);
    }

    public static void warn(String str, String str2) {
        log(str, LogLevel.WARN, null, str2, null, null, false);
    }

    public static void warnPII(String str, String str2) {
        log(str, LogLevel.WARN, null, str2, null, null, true);
    }

    public static void warnWithObject(String str, String str2, String str3, ILoggable iLoggable) {
        if (isAllowPii()) {
            log(str, LogLevel.WARN, str2, str3, iLoggable.toUnsanitizedString(), null, iLoggable.containsPii());
        } else {
            log(str, LogLevel.WARN, str2, str3, iLoggable.toString(), null, false);
        }
    }

    public static void error(String str, String str2, String str3, Throwable th) {
        log(str, LogLevel.ERROR, str2, str3, null, th, false);
    }

    public static void errorPII(String str, String str2, String str3, Throwable th) {
        log(str, LogLevel.ERROR, str2, str3, null, th, true);
    }

    private static String getDiagnosticContextMetadata(@Nullable String str) {
        IRequestContext requestContext = DiagnosticContext.INSTANCE.getRequestContext();
        String str2 = requestContext.get(DiagnosticContext.THREAD_ID);
        if (StringUtil.isNullOrEmpty(str2)) {
            str2 = "UNSET";
        }
        if (StringUtil.isNullOrEmpty(str)) {
            str = requestContext.get("correlation_id");
            if (StringUtil.isNullOrEmpty(str)) {
                str = "UNSET";
            }
        }
        return AbstractC0541b.m774p("thread_id: ", str2, ", correlation_id: ", str);
    }

    public static void info(String str, String str2, String str3) {
        log(str, LogLevel.INFO, str2, str3, null, null, false);
    }

    public static void infoPII(String str, String str2, String str3) {
        log(str, LogLevel.INFO, str2, str3, null, null, true);
    }

    public static void verbose(String str, String str2, String str3) {
        log(str, LogLevel.VERBOSE, str2, str3, null, null, false);
    }

    public static void verbosePII(String str, String str2, String str3) {
        log(str, LogLevel.VERBOSE, str2, str3, null, null, true);
    }

    public static void warn(String str, String str2, String str3) {
        log(str, LogLevel.WARN, str2, str3, null, null, false);
    }

    public static void warnPII(String str, String str2, String str3) {
        log(str, LogLevel.WARN, str2, str3, null, null, true);
    }

    public static void infoWithObject(String str, String str2, String str3, ILoggable iLoggable) {
        if (isAllowPii()) {
            log(str, LogLevel.INFO, str3, str2, iLoggable.toUnsanitizedString(), null, iLoggable.containsPii());
        } else {
            log(str, LogLevel.INFO, str3, str2, iLoggable.toString(), null, false);
        }
    }

    public static void warnWithObject(String str, String str2, ILoggable iLoggable) {
        if (isAllowPii()) {
            log(str, LogLevel.WARN, null, str2, iLoggable.toUnsanitizedString(), null, iLoggable.containsPii());
        } else {
            log(str, LogLevel.WARN, null, str2, iLoggable.toString(), null, false);
        }
    }
}
