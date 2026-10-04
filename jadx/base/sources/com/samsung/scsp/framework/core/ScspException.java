package com.samsung.scsp.framework.core;

import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.google.gson.annotations.SerializedName;
import com.samsung.scsp.framework.core.util.StringUtil;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class ScspException extends Exception {
    public String errorString;
    public Map<String, List<String>> headers;

    @SerializedName("rcode")
    public int rcode;

    @SerializedName("rmsg")
    public String rmsg;
    public int status;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Code {
        public static final int BAD_IMPLEMENTATION = 80000000;
        public static final int CANCELED = 70000004;
        public static final int FORBIDDEN = 80300000;
        public static final int NETWORK_USAGE_CONSENT = 80300002;
        public static final int NOT_INITIALIZED = 60000002;
        public static final int NOT_SUPPORT_OS_VERSION = 70000001;
        public static final int NO_PERMISSION = 70000002;
        public static final int REGISTRATION_REQUIRED = 40001001;
        public static final int REQUEST_TIMEOUT = 80800000;
        public static final int RUNTIME_ENVIRONMENT = 60000000;
        public static final int RUNTIME_NETWORK_ERROR = 60000004;
        public static final int RUNTIME_POLICY = 70000000;
        public static final int UNAUTHENTICATED_FOR_SA = 40100001;
        public static final int UNAUTHENTICATED_FOR_SC = 40100002;
        public static final int UNAUTHENTICATED_FOR_SC_V1 = 101000;
    }

    public ScspException(int i, String str, Throwable th) {
        super(str, th);
        this.rcode = i;
        this.rmsg = str;
    }

    public static void throwIfEmpty(String str, String str2) throws ScspException {
        if (StringUtil.isEmpty(str)) {
            throw new ScspException(Code.BAD_IMPLEMENTATION, str2);
        }
    }

    public static void throwIfNull(Object obj, String str) throws ScspException {
        if (obj == null) {
            throw new ScspException(Code.BAD_IMPLEMENTATION, str);
        }
    }

    public static void throwWhen(boolean z, String str) throws ScspException {
        if (z) {
            throw new ScspException(Code.BAD_IMPLEMENTATION, str);
        }
    }

    @Override // java.lang.Throwable
    public String toString() {
        Locale locale = Locale.US;
        return AbstractC2322a.m1616f(this.rcode, "[rcode] ", ", [rmsg]: ", this.rmsg);
    }

    public ScspException(int i, String str) {
        super(str);
        this.rcode = i;
        this.rmsg = str;
    }
}
