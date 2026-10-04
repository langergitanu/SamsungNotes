package com.microsoft.identity.common.java.telemetry.events;

import com.microsoft.identity.common.java.telemetry.TelemetryEventStrings;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Deprecated
public class UiShownEvent extends BaseEvent {
    public UiShownEvent() {
        names(TelemetryEventStrings.Event.UI_SHOWN_EVENT);
        types(TelemetryEventStrings.EventType.UI_EVENT);
    }

    public UiShownEvent putVisible(String str) {
        put(TelemetryEventStrings.Key.UI_VISIBLE, str);
        return this;
    }
}
