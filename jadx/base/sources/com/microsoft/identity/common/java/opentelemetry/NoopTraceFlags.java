package com.microsoft.identity.common.java.opentelemetry;

import io.opentelemetry.api.trace.TraceFlags;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class NoopTraceFlags implements TraceFlags {
    @Override // io.opentelemetry.api.trace.TraceFlags
    public byte asByte() {
        return (byte) 0;
    }

    @Override // io.opentelemetry.api.trace.TraceFlags
    public String asHex() {
        return null;
    }

    @Override // io.opentelemetry.api.trace.TraceFlags
    public boolean isSampled() {
        return false;
    }
}
