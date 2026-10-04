package io.opentelemetry.api.internal;

import com.google.auto.value.AutoValue;
import io.opentelemetry.api.trace.SpanContext;
import io.opentelemetry.api.trace.SpanId;
import io.opentelemetry.api.trace.TraceFlags;
import io.opentelemetry.api.trace.TraceId;
import io.opentelemetry.api.trace.TraceState;
import javax.annotation.concurrent.Immutable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@AutoValue
@Immutable
public abstract class ImmutableSpanContext implements SpanContext {
    public static final SpanContext INVALID = createInternal(TraceId.getInvalid(), SpanId.getInvalid(), TraceFlags.getDefault(), TraceState.getDefault(), false, false);

    public static SpanContext create(String str, String str2, TraceFlags traceFlags, TraceState traceState, boolean z, boolean z2) {
        return (z2 || (SpanId.isValid(str2) && TraceId.isValid(str))) ? createInternal(str, str2, traceFlags, traceState, z, true) : createInternal(TraceId.getInvalid(), SpanId.getInvalid(), traceFlags, traceState, z, false);
    }

    private static AutoValue_ImmutableSpanContext createInternal(String str, String str2, TraceFlags traceFlags, TraceState traceState, boolean z, boolean z2) {
        return new AutoValue_ImmutableSpanContext(str, str2, traceFlags, traceState, z, z2);
    }

    @Override // io.opentelemetry.api.trace.SpanContext
    public abstract boolean isValid();
}
