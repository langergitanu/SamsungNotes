package io.opentelemetry.api;

import io.opentelemetry.api.metrics.MeterProvider;
import io.opentelemetry.api.trace.TracerProvider;
import io.opentelemetry.context.propagation.ContextPropagators;
import javax.annotation.concurrent.ThreadSafe;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@ThreadSafe
final class DefaultOpenTelemetry implements OpenTelemetry {
    private static final OpenTelemetry NO_OP = new DefaultOpenTelemetry(ContextPropagators.noop());
    private final ContextPropagators propagators;

    public DefaultOpenTelemetry(ContextPropagators contextPropagators) {
        this.propagators = contextPropagators;
    }

    public static OpenTelemetry getNoop() {
        return NO_OP;
    }

    public static OpenTelemetry getPropagating(ContextPropagators contextPropagators) {
        return new DefaultOpenTelemetry(contextPropagators);
    }

    @Override // io.opentelemetry.api.OpenTelemetry
    public MeterProvider getMeterProvider() {
        return MeterProvider.noop();
    }

    @Override // io.opentelemetry.api.OpenTelemetry
    public ContextPropagators getPropagators() {
        return this.propagators;
    }

    @Override // io.opentelemetry.api.OpenTelemetry
    public TracerProvider getTracerProvider() {
        return TracerProvider.noop();
    }
}
