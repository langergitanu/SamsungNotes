package io.opentelemetry.api.metrics;

import io.opentelemetry.api.common.Attributes;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public interface ObservableLongMeasurement extends ObservableMeasurement {
    void record(long j);

    void record(long j, Attributes attributes);
}
