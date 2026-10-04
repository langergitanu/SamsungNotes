package com.microsoft.identity.common.java.telemetry.events;

import com.microsoft.identity.common.java.telemetry.TelemetryEventStrings;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Deprecated
public class CertBasedAuthResultEvent extends BaseEvent {
    public CertBasedAuthResultEvent(String str) {
        names(str);
        types(TelemetryEventStrings.EventType.CERT_BASED_AUTH_EVENT);
    }

    public CertBasedAuthResultEvent putResponseCode(String str) {
        put(TelemetryEventStrings.Key.RESULT_CODE, str);
        return this;
    }
}
