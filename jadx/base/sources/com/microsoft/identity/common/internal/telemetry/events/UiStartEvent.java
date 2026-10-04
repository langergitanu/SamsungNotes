package com.microsoft.identity.common.internal.telemetry.events;

import com.microsoft.identity.common.java.p132ui.AuthorizationAgent;
import com.microsoft.identity.common.java.telemetry.TelemetryEventStrings;
import com.microsoft.identity.common.java.telemetry.events.BaseEvent;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Deprecated
public class UiStartEvent extends BaseEvent {
    public UiStartEvent() {
        names(TelemetryEventStrings.Event.UI_START_EVENT);
        types(TelemetryEventStrings.EventType.UI_EVENT);
    }

    public UiStartEvent isForcePrompt(boolean z) {
        put(TelemetryEventStrings.Key.IS_FORCE_PROMPT, String.valueOf(z));
        return this;
    }

    public UiStartEvent putLoginHint(String str) {
        put(TelemetryEventStrings.Key.LOGIN_HINT, str);
        return this;
    }

    public UiStartEvent putUserAgent(AuthorizationAgent authorizationAgent) {
        if (authorizationAgent == null) {
            return this;
        }
        put(TelemetryEventStrings.Key.USER_AGENT, authorizationAgent.name());
        return this;
    }
}
