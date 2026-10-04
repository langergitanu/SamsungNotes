package org.apache.commons.logging.impl;

import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.support.senl.p145cm.base.common.constants.Extension;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.io.StringWriter;
import java.security.AccessController;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;
import java.util.Properties;
import org.apache.commons.logging.C13939g;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogConfigurationException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class SimpleLog implements Log, Serializable {
    protected static final String DEFAULT_DATE_TIME_FORMAT = "yyyy/MM/dd HH:mm:ss:SSS zzz";
    public static final int LOG_LEVEL_ALL = 0;
    public static final int LOG_LEVEL_DEBUG = 2;
    public static final int LOG_LEVEL_ERROR = 5;
    public static final int LOG_LEVEL_FATAL = 6;
    public static final int LOG_LEVEL_INFO = 3;
    public static final int LOG_LEVEL_OFF = 7;
    public static final int LOG_LEVEL_TRACE = 1;
    public static final int LOG_LEVEL_WARN = 4;
    protected static DateFormat dateFormatter = null;
    protected static volatile String dateTimeFormat = null;
    private static final long serialVersionUID = 136942970684951178L;
    protected static volatile boolean showDateTime = false;
    protected static volatile boolean showLogName = false;
    protected static volatile boolean showShortName = false;
    protected static final Properties simpleLogProps;
    protected static final String systemPrefix = "org.apache.commons.logging.simplelog.";
    protected volatile int currentLogLevel;
    protected volatile String logName;
    private volatile String shortLogName;

    static {
        Properties properties = new Properties();
        simpleLogProps = properties;
        showShortName = true;
        dateTimeFormat = DEFAULT_DATE_TIME_FORMAT;
        try {
            InputStream resourceAsStream = getResourceAsStream("simplelog.properties");
            if (resourceAsStream != null) {
                try {
                    properties.load(resourceAsStream);
                } finally {
                }
            }
            if (resourceAsStream != null) {
                resourceAsStream.close();
            }
        } catch (IOException unused) {
        }
        showLogName = getBooleanProperty("org.apache.commons.logging.simplelog.showlogname", showLogName);
        showShortName = getBooleanProperty("org.apache.commons.logging.simplelog.showShortLogname", showShortName);
        showDateTime = getBooleanProperty("org.apache.commons.logging.simplelog.showdatetime", showDateTime);
        if (showDateTime) {
            dateTimeFormat = getStringProperty("org.apache.commons.logging.simplelog.dateTimeFormat", dateTimeFormat);
            try {
                dateFormatter = new SimpleDateFormat(dateTimeFormat);
            } catch (IllegalArgumentException unused2) {
                dateTimeFormat = DEFAULT_DATE_TIME_FORMAT;
                dateFormatter = new SimpleDateFormat(dateTimeFormat);
            }
        }
    }

    public SimpleLog(String str) {
        this.logName = str;
        setLevel(3);
        String stringProperty = getStringProperty("org.apache.commons.logging.simplelog.log." + this.logName);
        int iLastIndexOf = String.valueOf(str).lastIndexOf(Extension.DOT);
        while (true) {
            if (stringProperty != null || iLastIndexOf <= -1) {
                break;
            }
            str = str.substring(0, iLastIndexOf);
            stringProperty = getStringProperty(AbstractC0541b.m772n("org.apache.commons.logging.simplelog.log.", str));
            iLastIndexOf = String.valueOf(str).lastIndexOf(Extension.DOT);
        }
        stringProperty = stringProperty == null ? getStringProperty("org.apache.commons.logging.simplelog.defaultlog") : stringProperty;
        stringProperty = stringProperty != null ? stringProperty.toLowerCase(Locale.ROOT) : stringProperty;
        if (stringProperty != null) {
            switch (stringProperty) {
                case "all":
                    setLevel(0);
                    break;
                case "off":
                    setLevel(7);
                    break;
                case "info":
                    setLevel(3);
                    break;
                case "warn":
                    setLevel(4);
                    break;
                case "debug":
                    setLevel(2);
                    break;
                case "error":
                    setLevel(5);
                    break;
                case "fatal":
                    setLevel(6);
                    break;
                case "trace":
                    setLevel(1);
                    break;
            }
        }
    }

    private static boolean getBooleanProperty(String str, boolean z) {
        String stringProperty = getStringProperty(str);
        return stringProperty == null ? z : Boolean.parseBoolean(stringProperty);
    }

    private static ClassLoader getContextClassLoader() {
        ClassLoader contextClassLoader;
        try {
            contextClassLoader = Thread.currentThread().getContextClassLoader();
        } catch (RuntimeException e) {
            if (!(e instanceof SecurityException)) {
                throw new LogConfigurationException("Unexpected SecurityException", e);
            }
            contextClassLoader = null;
        }
        return contextClassLoader == null ? SimpleLog.class.getClassLoader() : contextClassLoader;
    }

    private static InputStream getResourceAsStream(String str) {
        return (InputStream) AccessController.doPrivileged(new C13939g(str, 1));
    }

    private static String getStringProperty(String str) {
        String property;
        try {
            property = System.getProperty(str);
        } catch (SecurityException unused) {
            property = null;
        }
        return property == null ? simpleLogProps.getProperty(str) : property;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ InputStream lambda$getResourceAsStream$0(String str) {
        ClassLoader contextClassLoader = getContextClassLoader();
        return contextClassLoader != null ? contextClassLoader.getResourceAsStream(str) : ClassLoader.getSystemResourceAsStream(str);
    }

    private void write(Object obj) {
        System.err.println(Objects.toString(obj));
    }

    @Override // org.apache.commons.logging.Log
    public final void debug(Object obj) {
        if (isLevelEnabled(2)) {
            log(2, obj, null);
        }
    }

    @Override // org.apache.commons.logging.Log
    public final void error(Object obj) {
        if (isLevelEnabled(5)) {
            log(5, obj, null);
        }
    }

    @Override // org.apache.commons.logging.Log
    public final void fatal(Object obj) {
        if (isLevelEnabled(6)) {
            log(6, obj, null);
        }
    }

    public int getLevel() {
        return this.currentLogLevel;
    }

    @Override // org.apache.commons.logging.Log
    public final void info(Object obj) {
        if (isLevelEnabled(3)) {
            log(3, obj, null);
        }
    }

    @Override // org.apache.commons.logging.Log
    public final boolean isDebugEnabled() {
        return isLevelEnabled(2);
    }

    @Override // org.apache.commons.logging.Log
    public final boolean isErrorEnabled() {
        return isLevelEnabled(5);
    }

    @Override // org.apache.commons.logging.Log
    public final boolean isFatalEnabled() {
        return isLevelEnabled(6);
    }

    @Override // org.apache.commons.logging.Log
    public final boolean isInfoEnabled() {
        return isLevelEnabled(3);
    }

    public boolean isLevelEnabled(int i) {
        return i >= this.currentLogLevel;
    }

    @Override // org.apache.commons.logging.Log
    public final boolean isTraceEnabled() {
        return isLevelEnabled(1);
    }

    @Override // org.apache.commons.logging.Log
    public final boolean isWarnEnabled() {
        return isLevelEnabled(4);
    }

    public void log(int i, Object obj, Throwable th) {
        String str;
        StringBuilder sb = new StringBuilder();
        if (showDateTime) {
            Date date = new Date();
            synchronized (dateFormatter) {
                str = dateFormatter.format(date);
            }
            sb.append(str);
            sb.append(" ");
        }
        switch (i) {
            case 1:
                sb.append("[TRACE] ");
                break;
            case 2:
                sb.append("[DEBUG] ");
                break;
            case 3:
                sb.append("[INFO] ");
                break;
            case 4:
                sb.append("[WARN] ");
                break;
            case 5:
                sb.append("[ERROR] ");
                break;
            case 6:
                sb.append("[FATAL] ");
                break;
            default:
                sb.append("[UNDEFINED] ");
                break;
        }
        if (showShortName) {
            if (this.shortLogName == null) {
                String strSubstring = this.logName.substring(this.logName.lastIndexOf(Extension.DOT) + 1);
                this.shortLogName = strSubstring.substring(strSubstring.lastIndexOf("/") + 1);
            }
            sb.append(String.valueOf(this.shortLogName));
            sb.append(" - ");
        } else if (showLogName) {
            sb.append(String.valueOf(this.logName));
            sb.append(" - ");
        }
        sb.append(String.valueOf(obj));
        if (th != null) {
            sb.append(" <");
            sb.append(th.toString());
            sb.append(">");
            StringWriter stringWriter = new StringWriter(1024);
            PrintWriter printWriter = new PrintWriter(stringWriter);
            try {
                th.printStackTrace(printWriter);
                printWriter.close();
                sb.append(stringWriter.toString());
            } catch (Throwable th2) {
                try {
                    printWriter.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
                throw th2;
            }
        }
        write(sb);
    }

    public void setLevel(int i) {
        this.currentLogLevel = i;
    }

    @Override // org.apache.commons.logging.Log
    public final void trace(Object obj) {
        if (isLevelEnabled(1)) {
            log(1, obj, null);
        }
    }

    @Override // org.apache.commons.logging.Log
    public final void warn(Object obj) {
        if (isLevelEnabled(4)) {
            log(4, obj, null);
        }
    }

    public void write(StringBuffer stringBuffer) {
        System.err.println(Objects.toString(stringBuffer));
    }

    private static String getStringProperty(String str, String str2) {
        String stringProperty = getStringProperty(str);
        return stringProperty == null ? str2 : stringProperty;
    }

    @Override // org.apache.commons.logging.Log
    public final void debug(Object obj, Throwable th) {
        if (isLevelEnabled(2)) {
            log(2, obj, th);
        }
    }

    @Override // org.apache.commons.logging.Log
    public final void error(Object obj, Throwable th) {
        if (isLevelEnabled(5)) {
            log(5, obj, th);
        }
    }

    @Override // org.apache.commons.logging.Log
    public final void fatal(Object obj, Throwable th) {
        if (isLevelEnabled(6)) {
            log(6, obj, th);
        }
    }

    @Override // org.apache.commons.logging.Log
    public final void info(Object obj, Throwable th) {
        if (isLevelEnabled(3)) {
            log(3, obj, th);
        }
    }

    @Override // org.apache.commons.logging.Log
    public final void trace(Object obj, Throwable th) {
        if (isLevelEnabled(1)) {
            log(1, obj, th);
        }
    }

    @Override // org.apache.commons.logging.Log
    public final void warn(Object obj, Throwable th) {
        if (isLevelEnabled(4)) {
            log(4, obj, th);
        }
    }
}
