package com.microsoft.identity.common.java.opentelemetry;

import io.opentelemetry.api.trace.TraceState;
import io.opentelemetry.api.trace.TraceStateBuilder;
import java.util.Collections;
import java.util.Map;
import java.util.function.BiConsumer;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class NoopTraceState implements TraceState {
    private static final Map<String, String> EMPTY = Collections.EMPTY_MAP;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class NoopTraceStateBuilder {
        public NoopTraceState build() {
            return new NoopTraceState();
        }

        public String toString() {
            return "NoopTraceState.NoopTraceStateBuilder()";
        }
    }

    public static NoopTraceStateBuilder builder() {
        return new NoopTraceStateBuilder();
    }

    @Override // io.opentelemetry.api.trace.TraceState
    public Map<String, String> asMap() {
        return EMPTY;
    }

    @Override // io.opentelemetry.api.trace.TraceState
    @Nullable
    public String get(String str) {
        return null;
    }

    @Override // io.opentelemetry.api.trace.TraceState
    public boolean isEmpty() {
        return true;
    }

    @Override // io.opentelemetry.api.trace.TraceState
    public int size() {
        return 0;
    }

    @Override // io.opentelemetry.api.trace.TraceState
    public TraceStateBuilder toBuilder() {
        return new com.microsoft.identity.common.java.opentelemetry.NoopTraceStateBuilder();
    }

    @Override // io.opentelemetry.api.trace.TraceState
    public void forEach(BiConsumer<String, String> biConsumer) {
    }
}
