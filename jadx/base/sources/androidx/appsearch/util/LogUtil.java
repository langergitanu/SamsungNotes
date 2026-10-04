package androidx.appsearch.util;

import androidx.annotation.RestrictTo;
import androidx.annotation.Size;
import androidx.appsearch.app.AppSearchEnvironmentFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class LogUtil {
    public static final boolean DEBUG = false;
    public static final boolean INFO = AppSearchEnvironmentFactory.getEnvironmentInstance().isInfoLoggingEnabled();
    private static final int PII_TRACE_LEVEL = 0;

    private LogUtil() {
    }

    public static boolean isPiiTraceEnabled() {
        return false;
    }

    public static void piiTrace(@Size(max = 23, min = 0) String str, String str2, Object obj, Object obj2) {
    }

    public static void piiTrace(@Size(max = 23, min = 0) String str, String str2) {
        piiTrace(str, str2, null, null);
    }

    public static void piiTrace(@Size(max = 23, min = 0) String str, String str2, Object obj) {
        piiTrace(str, str2, obj, null);
    }
}
