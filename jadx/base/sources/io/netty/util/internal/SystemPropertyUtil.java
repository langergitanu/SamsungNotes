package io.netty.util.internal;

import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.security.AccessController;
import java.security.PrivilegedAction;
import org.apache.commons.lang3.BooleanUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final class SystemPropertyUtil {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) SystemPropertyUtil.class);

    private SystemPropertyUtil() {
    }

    public static boolean contains(String str) {
        return get(str) != null;
    }

    public static String get(String str) {
        return get(str, null);
    }

    public static boolean getBoolean(String str, boolean z) {
        String str2 = get(str);
        if (str2 != null) {
            String lowerCase = str2.trim().toLowerCase();
            if (!lowerCase.isEmpty()) {
                if ("true".equals(lowerCase) || BooleanUtils.YES.equals(lowerCase) || "1".equals(lowerCase)) {
                    return true;
                }
                if ("false".equals(lowerCase) || BooleanUtils.f9757NO.equals(lowerCase) || "0".equals(lowerCase)) {
                    return false;
                }
                logger.warn("Unable to parse the boolean system property '{}':{} - using the default value: {}", str, lowerCase, Boolean.valueOf(z));
                return z;
            }
        }
        return z;
    }

    public static int getInt(String str, int i) {
        String str2 = get(str);
        if (str2 == null) {
            return i;
        }
        String strTrim = str2.trim();
        try {
            return Integer.parseInt(strTrim);
        } catch (Exception unused) {
            logger.warn("Unable to parse the integer system property '{}':{} - using the default value: {}", str, strTrim, Integer.valueOf(i));
            return i;
        }
    }

    public static long getLong(String str, long j) {
        String str2 = get(str);
        if (str2 == null) {
            return j;
        }
        String strTrim = str2.trim();
        try {
            return Long.parseLong(strTrim);
        } catch (Exception unused) {
            logger.warn("Unable to parse the long integer system property '{}':{} - using the default value: {}", str, strTrim, Long.valueOf(j));
            return j;
        }
    }

    public static String get(final String str, String str2) {
        ObjectUtil.checkNonEmpty(str, "key");
        try {
            str = System.getSecurityManager() == null ? System.getProperty(str) : (String) AccessController.doPrivileged(new PrivilegedAction<String>() { // from class: io.netty.util.internal.SystemPropertyUtil.1
                @Override // java.security.PrivilegedAction
                public String run() {
                    return System.getProperty(str);
                }
            });
        } catch (SecurityException e) {
            logger.warn("Unable to retrieve a system property '{}'; default values will be used.", str, e);
            str = null;
        }
        return str == null ? str2 : str;
    }
}
