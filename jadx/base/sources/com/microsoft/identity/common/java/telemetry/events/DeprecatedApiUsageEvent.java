package com.microsoft.identity.common.java.telemetry.events;

import com.microsoft.identity.common.java.telemetry.TelemetryEventStrings;
import javax.annotation.Nonnull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Deprecated
public class DeprecatedApiUsageEvent extends BaseEvent {
    public DeprecatedApiUsageEvent() {
        names(TelemetryEventStrings.Event.DEPRECATED_API_USAGE_EVENT).types(TelemetryEventStrings.EventType.LIBRARY_CONSUMER_EVENT);
    }

    public DeprecatedApiUsageEvent putDeprecatedClassUsage(@Nonnull Class<?> cls) {
        put(TelemetryEventStrings.Key.PACKAGE_NAME, cls.getPackage().toString());
        put(TelemetryEventStrings.Key.CLASS_NAME, cls.getSimpleName());
        return this;
    }

    public DeprecatedApiUsageEvent putDeprecatedMethodUsage(@Nonnull Class<?> cls, @Nonnull String str) {
        put(TelemetryEventStrings.Key.CLASS_METHOD, str);
        return putDeprecatedClassUsage(cls);
    }
}
