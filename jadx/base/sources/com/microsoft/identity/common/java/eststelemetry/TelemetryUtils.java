package com.microsoft.identity.common.java.eststelemetry;

import com.microsoft.identity.common.java.util.StringUtil;
import edu.umd.cs.findbugs.annotations.Nullable;
import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class TelemetryUtils {
    public static boolean getBooleanFromString(@Nullable String str) {
        return str != null && str.equals("1");
    }

    @NonNull
    public static String getSchemaCompliantString(String str) {
        return StringUtil.isNullOrEmpty(str) ? "" : str.equals("true") ? "1" : str.equals("false") ? "0" : str;
    }

    public static String getSchemaCompliantStringFromBoolean(boolean z) {
        return z ? "1" : "0";
    }
}
