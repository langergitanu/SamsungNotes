package com.microsoft.identity.common.internal.telemetry.events;

import androidx.annotation.NonNull;
import com.microsoft.identity.common.java.exception.BaseException;
import com.microsoft.identity.common.java.exception.UserCancelException;
import com.microsoft.identity.common.java.telemetry.TelemetryEventStrings;
import com.microsoft.identity.common.java.telemetry.events.BaseEvent;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Deprecated
public class BrokerEndEvent extends BaseEvent {
    public BrokerEndEvent() {
        names(TelemetryEventStrings.Event.BROKER_END_EVENT);
        types(TelemetryEventStrings.EventType.BROKER_EVENT);
    }

    public BrokerEndEvent isSuccessful(boolean z) {
        put(TelemetryEventStrings.Key.IS_SUCCESSFUL, String.valueOf(z));
        return this;
    }

    public BrokerEndEvent putAction(String str) {
        put(TelemetryEventStrings.Key.BROKER_ACTION, str);
        return this;
    }

    public BrokerEndEvent putErrorCode(@NonNull String str) {
        put("Microsoft.MSAL.error_code", str);
        return this;
    }

    public BrokerEndEvent putErrorDescription(@NonNull String str) {
        put(TelemetryEventStrings.Key.ERROR_DESCRIPTION, str);
        return this;
    }

    public BrokerEndEvent putException(@NonNull BaseException baseException) {
        if (baseException == null) {
            return this;
        }
        if (baseException instanceof UserCancelException) {
            put(TelemetryEventStrings.Key.USER_CANCEL, "true");
        }
        put(TelemetryEventStrings.Key.SERVER_ERROR_CODE, baseException.getCliTelemErrorCode());
        put(TelemetryEventStrings.Key.SERVER_SUBERROR_CODE, baseException.getCliTelemSubErrorCode());
        put("Microsoft.MSAL.error_code", baseException.getErrorCode());
        put(TelemetryEventStrings.Key.SPE_RING, baseException.getSpeRing());
        put(TelemetryEventStrings.Key.ERROR_DESCRIPTION, baseException.getMessage());
        put(TelemetryEventStrings.Key.RT_AGE, baseException.getRefreshTokenAge());
        put(TelemetryEventStrings.Key.IS_SUCCESSFUL, "false");
        return this;
    }
}
