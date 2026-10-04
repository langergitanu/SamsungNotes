package com.microsoft.identity.common.java.telemetry.observers;

import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Deprecated
public interface ITelemetryAggregatedObserver extends ITelemetryObserver<Map<String, String>> {
    @Override // com.microsoft.identity.common.java.telemetry.observers.ITelemetryObserver
    void onReceived(Map<String, String> map);
}
