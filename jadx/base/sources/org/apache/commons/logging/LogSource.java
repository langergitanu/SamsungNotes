package org.apache.commons.logging;

import java.lang.reflect.Constructor;
import java.util.Hashtable;
import org.apache.commons.lang3.C13928v;
import org.apache.commons.logging.impl.LogFactoryImpl;
import org.apache.commons.logging.impl.NoOpLog;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Deprecated
public class LogSource {
    protected static Constructor<?> logImplctor;
    protected static Hashtable<String, Log> logs = new Hashtable<>();

    @Deprecated
    protected static boolean jdk14IsAvailable = true;
    private static final String[] EMPTY_STRING_ARRAY = new String[0];
    protected static boolean log4jIsAvailable = isClassForName("org.apache.log4j.Logger");

    static {
        String property = null;
        try {
            property = System.getProperty("org.apache.commons.logging.log");
            if (property == null) {
                property = System.getProperty(LogFactoryImpl.LOG_PROPERTY);
            }
        } catch (Throwable unused) {
        }
        try {
            if (property != null) {
                try {
                    setLogImplementation(property);
                } catch (Throwable unused2) {
                    setLogImplementation("org.apache.commons.logging.impl.NoOpLog");
                }
            } else {
                try {
                    if (log4jIsAvailable) {
                        setLogImplementation("org.apache.commons.logging.impl.Log4JLogger");
                    } else {
                        setLogImplementation("org.apache.commons.logging.impl.Jdk14Logger");
                    }
                } catch (Throwable unused3) {
                    setLogImplementation("org.apache.commons.logging.impl.NoOpLog");
                }
            }
        } catch (Throwable unused4) {
        }
    }

    private LogSource() {
    }

    public static Log getInstance(Class<?> cls) {
        return getInstance(cls.getName());
    }

    public static String[] getLogNames() {
        return (String[]) logs.keySet().toArray(EMPTY_STRING_ARRAY);
    }

    private static boolean isClassForName(String str) {
        try {
            Class.forName(str);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Log lambda$getInstance$0(String str, String str2) {
        return makeNewLogInstance(str);
    }

    public static Log makeNewLogInstance(String str) {
        Log log;
        try {
            log = (Log) logImplctor.newInstance(str);
        } catch (Throwable unused) {
            log = null;
        }
        return log == null ? new NoOpLog(str) : log;
    }

    public static void setLogImplementation(Class<?> cls) {
        logImplctor = cls.getConstructor(String.class);
    }

    public static Log getInstance(String str) {
        return logs.computeIfAbsent(str, new C13928v(str, 3));
    }

    public static void setLogImplementation(String str) {
        try {
            logImplctor = Class.forName(str).getConstructor(String.class);
        } catch (Throwable unused) {
            logImplctor = null;
        }
    }
}
