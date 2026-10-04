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
public class TelemetryAggregationRules {
    private static TelemetryAggregationRules sInstance;
    private final String[] aggregatedArray;
    private Set<String> aggregatedPropertiesSet;

    private TelemetryAggregationRules() {
        String[] strArr = {TelemetryEventStrings.Key.EVENT_NAME, TelemetryEventStrings.Key.OCCUR_TIME, TelemetryEventStrings.Key.EVENT_TYPE, TelemetryEventStrings.Key.IS_SUCCESSFUL};
        this.aggregatedArray = strArr;
        this.aggregatedPropertiesSet = new HashSet(Arrays.asList(strArr));
    }

    @NonNull
    public static synchronized TelemetryAggregationRules getInstance() {
        try {
            if (sInstance == null) {
                sInstance = new TelemetryAggregationRules();
            }
        } catch (Throwable th) {
            throw th;
        }
        return sInstance;
    }

    public boolean isRedundant(String str) {
        if (StringUtil.isNullOrEmpty(str)) {
            return false;
        }
        return this.aggregatedPropertiesSet.contains(str);
    }
}
