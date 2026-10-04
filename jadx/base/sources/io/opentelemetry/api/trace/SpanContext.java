package io.opentelemetry.api.trace;

import io.opentelemetry.api.internal.ImmutableSpanContext;
import io.opentelemetry.api.internal.OtelEncodingUtils;
import javax.annotation.concurrent.Immutable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Immutable
public interface SpanContext {
    static SpanContext create(String str, String str2, TraceFlags traceFlags, TraceState traceState) {
        return ImmutableSpanContext.create(str, str2, traceFlags, traceState, false, false);
    }

    static SpanContext createFromRemoteParent(String str, String str2, TraceFlags traceFlags, TraceState traceState) {
        return ImmutableSpanContext.create(str, str2, traceFlags, traceState, true, false);
    }

    static SpanContext getInvalid() {
        return ImmutableSpanContext.INVALID;
    }

    String getSpanId();

    default byte[] getSpanIdBytes() {
        return OtelEncodingUtils.bytesFromBase16(getSpanId(), SpanId.getLength());
    }

    TraceFlags getTraceFlags();

    String getTraceId();

    default byte[] getTraceIdBytes() {
        return OtelEncodingUtils.bytesFromBase16(getTraceId(), TraceId.getLength());
    }

    TraceState getTraceState();

    boolean isRemote();

    default boolean isSampled() {
        return getTraceFlags().isSampled();
    }

    default boolean isValid() {
        return TraceId.isValid(getTraceId()) && SpanId.isValid(getSpanId());
    }
}
