package io.opentelemetry.api.trace;

import java.util.Map;
import java.util.function.BiConsumer;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Immutable
public interface TraceState {
    static TraceStateBuilder builder() {
        return new ArrayBasedTraceStateBuilder();
    }

    static TraceState getDefault() {
        return ArrayBasedTraceStateBuilder.empty();
    }

    Map<String, String> asMap();

    void forEach(BiConsumer<String, String> biConsumer);

    @Nullable
    String get(String str);

    boolean isEmpty();

    int size();

    TraceStateBuilder toBuilder();
}
