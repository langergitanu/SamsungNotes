package com.microsoft.identity.common.java.flighting;

import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class CommonFlightManager {
    private static IFlightsProvider mFlightProvider;

    public static int getIntValue(@NonNull IFlightConfig iFlightConfig) {
        if (iFlightConfig == null) {
            throw new NullPointerException("flightConfig is marked non-null but is null");
        }
        IFlightsProvider iFlightsProvider = mFlightProvider;
        return iFlightsProvider == null ? ((Integer) iFlightConfig.getDefaultValue()).intValue() : iFlightsProvider.getIntValue(iFlightConfig);
    }

    public static boolean isFlightEnabled(@NonNull IFlightConfig iFlightConfig) {
        if (iFlightConfig == null) {
            throw new NullPointerException("flightConfig is marked non-null but is null");
        }
        IFlightsProvider iFlightsProvider = mFlightProvider;
        return iFlightsProvider == null ? ((Boolean) iFlightConfig.getDefaultValue()).booleanValue() : iFlightsProvider.isFlightEnabled(iFlightConfig);
    }

    public static void setFlightProvider(@NonNull IFlightsProvider iFlightsProvider) {
        if (iFlightsProvider == null) {
            throw new NullPointerException("flightProvider is marked non-null but is null");
        }
        mFlightProvider = iFlightsProvider;
    }
}
