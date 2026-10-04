package com.microsoft.identity.common.java.telemetry.rules;

import com.microsoft.identity.common.java.telemetry.TelemetryEventStrings;
import com.microsoft.identity.common.java.util.StringUtil;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Deprecated
public final class TelemetryPiiOiiRules {
    private static TelemetryPiiOiiRules sInstance;
    private final String[] oiiArray;
    private Set<String> oiiPropertiesSet;
    private final String[] piiArray;
    private Set<String> piiPropertiesSet;

    private TelemetryPiiOiiRules() {
        String[] strArr = {TelemetryEventStrings.Key.USER_ID, TelemetryEventStrings.Device.f3609ID, TelemetryEventStrings.Key.LOGIN_HINT, TelemetryEventStrings.Key.ERROR_DESCRIPTION, TelemetryEventStrings.Key.REQUEST_QUERY_PARAMS, TelemetryEventStrings.Key.REDIRECT_URI, TelemetryEventStrings.Key.SCOPE, TelemetryEventStrings.Key.CLAIM_REQUEST};
        this.piiArray = strArr;
        String[] strArr2 = {TelemetryEventStrings.Key.TENANT_ID, TelemetryEventStrings.Key.CLIENT_ID, TelemetryEventStrings.Key.REDIRECT_URI, TelemetryEventStrings.Key.HTTP_PATH, TelemetryEventStrings.Key.AUTHORITY, TelemetryEventStrings.Key.IDP_NAME, TelemetryEventStrings.Key.CALLER_APP_PACKAGE_NAME, TelemetryEventStrings.Key.CALLER_APP_UUID, TelemetryEventStrings.Key.CALLER_APP_VERSION};
        this.oiiArray = strArr2;
        this.piiPropertiesSet = new HashSet(Arrays.asList(strArr));
        this.oiiPropertiesSet = new HashSet(Arrays.asList(strArr2));
    }

    @NonNull
    public static synchronized TelemetryPiiOiiRules getInstance() {
        try {
            if (sInstance == null) {
                sInstance = new TelemetryPiiOiiRules();
            }
        } catch (Throwable th) {
            throw th;
        }
        return sInstance;
    }

    public boolean isOii(String str) {
        if (StringUtil.isNullOrEmpty(str)) {
            return false;
        }
        return this.oiiPropertiesSet.contains(str);
    }

    public boolean isPii(String str) {
        if (StringUtil.isNullOrEmpty(str)) {
            return false;
        }
        return this.piiPropertiesSet.contains(str);
    }

    public boolean isPiiOrOii(String str) {
        return isPii(str) || isOii(str);
    }
}
