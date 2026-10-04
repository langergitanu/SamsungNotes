package io.opentelemetry.api;

import io.opentelemetry.api.trace.NoopTracerProvider;
import io.opentelemetry.api.trace.TracerProvider;
import io.opentelemetry.context.propagation.ContextPropagators;
import io.opentelemetry.context.propagation.NoopContextPropagators;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class NoopOpenTelemetry implements OpenTelemetry {
    @Override // io.opentelemetry.api.OpenTelemetry
    public ContextPropagators getPropagators() {
        return NoopContextPropagators.getInstance();
    }

    @Override // io.opentelemetry.api.OpenTelemetry
    public TracerProvider getTracerProvider() {
        return NoopTracerProvider.getInstance();
    }
}
