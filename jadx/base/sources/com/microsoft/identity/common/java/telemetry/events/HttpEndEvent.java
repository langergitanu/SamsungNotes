package com.microsoft.identity.common.java.telemetry.events;

import com.microsoft.identity.common.java.telemetry.TelemetryEventStrings;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Deprecated
public class HttpEndEvent extends BaseEvent {
    public HttpEndEvent() {
        names(TelemetryEventStrings.Event.HTTP_END_EVENT);
        types(TelemetryEventStrings.EventType.HTTP_EVENT);
    }

    public HttpEndEvent putStatusCode(int i) {
        put(TelemetryEventStrings.Key.HTTP_RESPONSE_CODE, String.valueOf(i));
        return this;
    }
}
