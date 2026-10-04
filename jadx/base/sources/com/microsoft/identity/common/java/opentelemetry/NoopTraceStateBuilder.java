package com.microsoft.identity.common.java.opentelemetry;

import io.opentelemetry.api.trace.TraceState;
import io.opentelemetry.api.trace.TraceStateBuilder;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class NoopTraceStateBuilder implements TraceStateBuilder {
    @Override // io.opentelemetry.api.trace.TraceStateBuilder
    public TraceState build() {
        return new NoopTraceState();
    }

    @Override // io.opentelemetry.api.trace.TraceStateBuilder
    public TraceStateBuilder remove(String str) {
        return this;
    }

    @Override // io.opentelemetry.api.trace.TraceStateBuilder
    public TraceStateBuilder put(String str, String str2) {
        return this;
    }
}
