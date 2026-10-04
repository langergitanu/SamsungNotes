package io.opentelemetry.api.metrics;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
class DefaultMeterProvider implements MeterProvider {
    private static final DefaultMeterProvider INSTANCE = new DefaultMeterProvider();
    private static final MeterBuilder BUILDER_INSTANCE = new NoopMeterBuilder();

    private DefaultMeterProvider() {
    }

    public static MeterProvider getInstance() {
        return INSTANCE;
    }

    @Override // io.opentelemetry.api.metrics.MeterProvider
    public MeterBuilder meterBuilder(String str) {
        return BUILDER_INSTANCE;
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class NoopMeterBuilder implements MeterBuilder {
        private NoopMeterBuilder() {
        }

        @Override // io.opentelemetry.api.metrics.MeterBuilder
        public Meter build() {
            return DefaultMeter.getInstance();
        }

        @Override // io.opentelemetry.api.metrics.MeterBuilder
        public MeterBuilder setInstrumentationVersion(String str) {
            return this;
        }

        @Override // io.opentelemetry.api.metrics.MeterBuilder
        public MeterBuilder setSchemaUrl(String str) {
            return this;
        }
    }
}
