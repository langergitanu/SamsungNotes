package io.opentelemetry.api;

import io.opentelemetry.api.metrics.Meter;
import io.opentelemetry.api.metrics.MeterBuilder;
import io.opentelemetry.api.metrics.MeterProvider;
import io.opentelemetry.api.trace.Tracer;
import io.opentelemetry.api.trace.TracerBuilder;
import io.opentelemetry.api.trace.TracerProvider;
import io.opentelemetry.context.propagation.ContextPropagators;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public interface OpenTelemetry {
    static OpenTelemetry noop() {
        return DefaultOpenTelemetry.getNoop();
    }

    static OpenTelemetry propagating(ContextPropagators contextPropagators) {
        return DefaultOpenTelemetry.getPropagating(contextPropagators);
    }

    default Meter getMeter(String str) {
        return getMeterProvider().get(str);
    }

    default MeterProvider getMeterProvider() {
        return MeterProvider.noop();
    }

    ContextPropagators getPropagators();

    default Tracer getTracer(String str) {
        return getTracerProvider().get(str);
    }

    TracerProvider getTracerProvider();

    default MeterBuilder meterBuilder(String str) {
        return getMeterProvider().meterBuilder(str);
    }

    default TracerBuilder tracerBuilder(String str) {
        return getTracerProvider().tracerBuilder(str);
    }

    default Tracer getTracer(String str, String str2) {
        return getTracerProvider().get(str, str2);
    }
}
