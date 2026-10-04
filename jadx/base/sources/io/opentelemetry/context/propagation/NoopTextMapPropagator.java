package io.opentelemetry.context.propagation;

import io.opentelemetry.context.Context;
import java.util.Collection;
import java.util.Collections;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
final class NoopTextMapPropagator implements TextMapPropagator {
    private static final NoopTextMapPropagator INSTANCE = new NoopTextMapPropagator();

    public static TextMapPropagator getInstance() {
        return INSTANCE;
    }

    @Override // io.opentelemetry.context.propagation.TextMapPropagator
    public <C> Context extract(Context context, @Nullable C c, TextMapGetter<C> textMapGetter) {
        return context == null ? Context.root() : context;
    }

    @Override // io.opentelemetry.context.propagation.TextMapPropagator
    public Collection<String> fields() {
        return Collections.EMPTY_LIST;
    }

    @Override // io.opentelemetry.context.propagation.TextMapPropagator
    public <C> void inject(Context context, @Nullable C c, TextMapSetter<C> textMapSetter) {
    }
}
