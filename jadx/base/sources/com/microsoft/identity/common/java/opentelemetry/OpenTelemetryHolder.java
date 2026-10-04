package com.microsoft.identity.common.java.opentelemetry;

import io.opentelemetry.api.NoopOpenTelemetry;
import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.api.metrics.Meter;
import io.opentelemetry.api.metrics.MeterProvider;
import io.opentelemetry.api.metrics.NoopMeterProvider;
import io.opentelemetry.api.trace.Tracer;
import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class OpenTelemetryHolder {
    private static final OpenTelemetry NOOP;
    private static final MeterProvider NOOP_METER_PROVIDER;

    @NonNull
    private static OpenTelemetry sOpenTelemetry;

    static {
        NoopOpenTelemetry noopOpenTelemetry = new NoopOpenTelemetry();
        NOOP = noopOpenTelemetry;
        sOpenTelemetry = noopOpenTelemetry;
        NOOP_METER_PROVIDER = NoopMeterProvider.getInstance();
    }

    public static Meter getMeter(String str) {
        try {
            return sOpenTelemetry.getMeterProvider().get(str);
        } catch (AbstractMethodError unused) {
            return NOOP_METER_PROVIDER.get(str);
        }
    }

    @NonNull
    public static OpenTelemetry getOpenTelemetry() {
        return sOpenTelemetry;
    }

    public static Tracer getTracer(String str) {
        return sOpenTelemetry.getTracerProvider().get(str);
    }

    public static void setOpenTelemetry(@NonNull OpenTelemetry openTelemetry) {
        if (openTelemetry == null) {
            throw new NullPointerException("sOpenTelemetry is marked non-null but is null");
        }
        sOpenTelemetry = openTelemetry;
    }
}
