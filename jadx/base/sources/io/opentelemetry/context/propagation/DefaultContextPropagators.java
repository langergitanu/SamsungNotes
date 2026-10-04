package io.opentelemetry.context.propagation;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
final class DefaultContextPropagators implements ContextPropagators {
    private static final ContextPropagators NOOP = new DefaultContextPropagators(NoopTextMapPropagator.getInstance());
    private final TextMapPropagator textMapPropagator;

    public DefaultContextPropagators(TextMapPropagator textMapPropagator) {
        this.textMapPropagator = textMapPropagator;
    }

    public static ContextPropagators noop() {
        return NOOP;
    }

    @Override // io.opentelemetry.context.propagation.ContextPropagators
    public TextMapPropagator getTextMapPropagator() {
        return this.textMapPropagator;
    }
}
