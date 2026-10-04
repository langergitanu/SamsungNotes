package com.microsoft.identity.common.java.flighting;

import lombok.NonNull;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public interface IFlightsProvider {
    boolean getBooleanValue(@NonNull IFlightConfig iFlightConfig);

    double getDoubleValue(@NonNull IFlightConfig iFlightConfig);

    int getIntValue(@NonNull IFlightConfig iFlightConfig);

    JSONObject getJsonValue(@NonNull IFlightConfig iFlightConfig);

    String getStringValue(@NonNull IFlightConfig iFlightConfig);

    boolean isFlightEnabled(@NonNull IFlightConfig iFlightConfig);
}
