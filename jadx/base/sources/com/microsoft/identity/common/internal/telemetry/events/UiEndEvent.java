package com.microsoft.identity.common.internal.telemetry.events;

import com.microsoft.identity.common.java.telemetry.TelemetryEventStrings;
import com.microsoft.identity.common.java.telemetry.events.BaseEvent;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Deprecated
public class UiEndEvent extends BaseEvent {
    public UiEndEvent() {
        names(TelemetryEventStrings.Event.UI_END_EVENT);
        types(TelemetryEventStrings.EventType.UI_EVENT);
    }

    public UiEndEvent isUiCancelled() {
        put(TelemetryEventStrings.Key.UI_CANCELLED, Boolean.TRUE.toString());
        return this;
    }

    public UiEndEvent isUiComplete() {
        put(TelemetryEventStrings.Key.UI_COMPLETE, Boolean.TRUE.toString());
        return this;
    }

    public UiEndEvent isUserCancelled() {
        put(TelemetryEventStrings.Key.USER_CANCEL, Boolean.TRUE.toString());
        return this;
    }
}
