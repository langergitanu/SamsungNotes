package com.microsoft.identity.common.java.telemetry.events;

import com.microsoft.identity.common.java.telemetry.TelemetryEventStrings;
import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Deprecated
public class BrokerEvent extends BaseEvent {
    public BrokerEvent(String str) {
        types(TelemetryEventStrings.EventType.BROKER_EVENT);
        names(str);
    }

    public BrokerEvent putIPCStrategy(@NonNull String str) {
        if (str == null) {
            throw new NullPointerException("ipcStrategy is marked non-null but is null");
        }
        put(TelemetryEventStrings.Key.IPC_STRATEGY, str);
        return this;
    }

    public BrokerEvent() {
        this(null);
    }
}
