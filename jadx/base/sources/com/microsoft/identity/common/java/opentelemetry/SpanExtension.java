package com.microsoft.identity.common.java.opentelemetry;

import androidx.collection.AbstractC0622a;
import com.microsoft.identity.common.java.logging.Logger;
import io.opentelemetry.api.internal.ImmutableSpanContext;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.SpanContext;
import io.opentelemetry.api.trace.SpanId;
import io.opentelemetry.api.trace.TraceId;
import io.opentelemetry.context.Scope;
import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class SpanExtension {
    private static final SpanContext INVALID = ImmutableSpanContext.create(TraceId.getInvalid(), SpanId.getInvalid(), new NoopTraceFlags(), new NoopTraceState(), false, false);
    private static final String TAG = "SpanExtension";

    public static Span current() {
        try {
            return Span.current();
        } catch (NoSuchMethodError e) {
            Logger.error(AbstractC0622a.m1170p(TAG, ":getCurrentSpan", new StringBuilder()), e.getMessage(), e);
            return new NoopSpan(INVALID);
        }
    }

    public static Scope makeCurrentSpan(@NonNull Span span) {
        if (span == null) {
            throw new NullPointerException("span is marked non-null but is null");
        }
        try {
            return span.makeCurrent();
        } catch (AbstractMethodError | Exception e) {
            Logger.error(AbstractC0622a.m1170p(TAG, ":makeCurrentSpan", new StringBuilder()), e.getMessage(), e);
            return NoopScope.INSTANCE;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum NoopScope implements Scope {
        INSTANCE;

        @Override // io.opentelemetry.context.Scope, java.lang.AutoCloseable
        public void close() {
        }
    }
}
