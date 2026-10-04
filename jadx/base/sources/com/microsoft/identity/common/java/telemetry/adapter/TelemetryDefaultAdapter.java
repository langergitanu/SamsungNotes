package com.microsoft.identity.common.java.telemetry.adapter;

import com.microsoft.identity.common.java.telemetry.observers.ITelemetryDefaultObserver;
import java.util.List;
import java.util.Map;
import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Deprecated
public final class TelemetryDefaultAdapter implements ITelemetryAdapter<List<Map<String, String>>> {
    private ITelemetryDefaultObserver mObserver;

    public TelemetryDefaultAdapter(@NonNull ITelemetryDefaultObserver iTelemetryDefaultObserver) {
        if (iTelemetryDefaultObserver == null) {
            throw new NullPointerException("observer is marked non-null but is null");
        }
        this.mObserver = iTelemetryDefaultObserver;
    }

    public ITelemetryDefaultObserver getObserver() {
        return this.mObserver;
    }

    @Override // com.microsoft.identity.common.java.telemetry.adapter.ITelemetryAdapter
    public void process(@NonNull List<Map<String, String>> list) {
        if (list == null) {
            throw new NullPointerException("rawData is marked non-null but is null");
        }
        ITelemetryDefaultObserver iTelemetryDefaultObserver = this.mObserver;
        if (iTelemetryDefaultObserver == null) {
            return;
        }
        iTelemetryDefaultObserver.onReceived(list);
    }
}
