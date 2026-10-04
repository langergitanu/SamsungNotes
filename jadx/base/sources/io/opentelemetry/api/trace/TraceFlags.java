package io.opentelemetry.api.trace;

import javax.annotation.concurrent.Immutable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Immutable
public interface TraceFlags {
    static TraceFlags fromByte(byte b) {
        return ImmutableTraceFlags.fromByte(b);
    }

    static TraceFlags fromHex(CharSequence charSequence, int i) {
        return ImmutableTraceFlags.fromHex(charSequence, i);
    }

    static TraceFlags getDefault() {
        return ImmutableTraceFlags.DEFAULT;
    }

    static int getLength() {
        return 2;
    }

    static TraceFlags getSampled() {
        return ImmutableTraceFlags.SAMPLED;
    }

    byte asByte();

    String asHex();

    boolean isSampled();
}
