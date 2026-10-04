package io.opentelemetry.api.metrics;

import javax.annotation.concurrent.ThreadSafe;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@ThreadSafe
public interface MeterProvider {
    static MeterProvider noop() {
        return DefaultMeterProvider.getInstance();
    }

    default Meter get(String str) {
        return meterBuilder(str).build();
    }

    MeterBuilder meterBuilder(String str);
}
