package com.microsoft.identity.common.java.telemetry.relay;

import androidx.collection.AbstractC0622a;
import com.microsoft.identity.common.java.logging.Logger;
import com.microsoft.identity.common.java.telemetry.observers.ITelemetryObserver;
import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Deprecated
public abstract class AbstractTelemetryRelayClient<T> implements ITelemetryObserver<T> {
    private static final String TAG = "AbstractTelemetryRelayClient";
    private ITelemetryEventFilter<T> mEventFilter = null;

    public abstract void flush();

    @Override // com.microsoft.identity.common.java.telemetry.observers.ITelemetryObserver
    public void onReceived(T t) {
        String strM1170p = AbstractC0622a.m1170p(TAG, ":onReceived", new StringBuilder());
        ITelemetryEventFilter<T> iTelemetryEventFilter = this.mEventFilter;
        if (iTelemetryEventFilter != null) {
            t = iTelemetryEventFilter.apply(t);
        }
        if (t != null) {
            try {
                relayEvent(t);
            } catch (TelemetryRelayException e) {
                Logger.error(strM1170p, "Error relaying telemetry data", e);
            }
        }
    }

    public abstract void relayEvent(@NonNull T t);

    public void setFilter(ITelemetryEventFilter<T> iTelemetryEventFilter) {
        this.mEventFilter = iTelemetryEventFilter;
    }
}
