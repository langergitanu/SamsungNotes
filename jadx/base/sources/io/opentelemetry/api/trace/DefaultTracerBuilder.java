package io.opentelemetry.api.trace;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
class DefaultTracerBuilder implements TracerBuilder {
    private static final DefaultTracerBuilder INSTANCE = new DefaultTracerBuilder();

    public static TracerBuilder getInstance() {
        return INSTANCE;
    }

    @Override // io.opentelemetry.api.trace.TracerBuilder
    public Tracer build() {
        return DefaultTracer.getInstance();
    }

    @Override // io.opentelemetry.api.trace.TracerBuilder
    public TracerBuilder setInstrumentationVersion(String str) {
        return this;
    }

    @Override // io.opentelemetry.api.trace.TracerBuilder
    public TracerBuilder setSchemaUrl(String str) {
        return this;
    }
}
