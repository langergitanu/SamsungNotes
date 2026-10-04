package com.samsung.android.sdk.smp.common.constants;

import java.util.EnumSet;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public enum MarketingState {
    INCOMP_RESOURCE,
    INCOMP_GET_STATUS_API,
    INCOMP_DISPLAY,
    DISPLAYED,
    GONE,
    FAILED,
    CANCELED;

    public static MarketingState fromString(String str) {
        for (MarketingState marketingState : EnumSet.allOf(MarketingState.class)) {
            if (marketingState.name().equals(str)) {
                return marketingState;
            }
        }
        return null;
    }
}
