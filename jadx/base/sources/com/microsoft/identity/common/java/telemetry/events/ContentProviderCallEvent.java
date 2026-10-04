package com.microsoft.identity.common.java.telemetry.events;

import com.microsoft.identity.common.java.telemetry.TelemetryEventStrings;
import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Deprecated
public class ContentProviderCallEvent extends BaseEvent {
    public ContentProviderCallEvent(@NonNull String str) {
        if (str == null) {
            throw new NullPointerException("contentUri is marked non-null but is null");
        }
        types(TelemetryEventStrings.EventType.CONTENT_PROVIDER_EVENT);
        names(TelemetryEventStrings.Event.CONTENT_PROVIDER_CALL_EVENT);
        put(TelemetryEventStrings.Key.CONTENT_PROVIDER_URI, str);
    }
}
