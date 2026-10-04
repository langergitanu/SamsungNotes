package com.microsoft.identity.common.internal.telemetry;

import android.content.Context;
import com.microsoft.identity.common.SharedPreferenceStringStorage;
import com.microsoft.identity.common.java.constants.SpotbugsWarning;
import com.microsoft.identity.common.java.telemetry.TelemetryPropertiesCache;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Deprecated
public class AndroidTelemetryPropertiesCache extends TelemetryPropertiesCache {
    private static final String SHARED_PREFS_NAME = "com.microsoft.common.telemetry-properties";

    @SuppressFBWarnings({SpotbugsWarning.RCN_REDUNDANT_NULLCHECK_WOULD_HAVE_BEEN_A_NPE})
    public AndroidTelemetryPropertiesCache(@NonNull Context context) {
        super(new SharedPreferenceStringStorage(context, SHARED_PREFS_NAME));
        if (context == null) {
            throw new NullPointerException("context is marked non-null but is null");
        }
    }
}
