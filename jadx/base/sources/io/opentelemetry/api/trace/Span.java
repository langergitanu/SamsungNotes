package io.opentelemetry.api.trace;

import com.vladsch.flexmark.util.ast.C11836a;
import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.internal.ValidationUtil;
import io.opentelemetry.context.Context;
import io.opentelemetry.context.ImplicitContextKeyed;
import java.time.Instant;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@ThreadSafe
public interface Span extends ImplicitContextKeyed {
    static Span current() {
        Span span = (Span) Context.current().get(SpanContextKey.KEY);
        return span == null ? getInvalid() : span;
    }

    static Span fromContext(Context context) {
        if (context == null) {
            ValidationUtil.log("context is null");
            return getInvalid();
        }
        Span span = (Span) context.get(SpanContextKey.KEY);
        return span == null ? getInvalid() : span;
    }

    @Nullable
    static Span fromContextOrNull(Context context) {
        if (context != null) {
            return (Span) context.get(SpanContextKey.KEY);
        }
        ValidationUtil.log("context is null");
        return null;
    }

    static Span getInvalid() {
        return PropagatedSpan.INVALID;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* synthetic */ default void lambda$setAllAttributes$0(AttributeKey attributeKey, Object obj) {
        setAttribute((AttributeKey<Object>) attributeKey, obj);
    }

    static Span wrap(SpanContext spanContext) {
        if (spanContext != null) {
            return !spanContext.isValid() ? getInvalid() : PropagatedSpan.create(spanContext);
        }
        ValidationUtil.log("context is null");
        return getInvalid();
    }

    default Span addEvent(String str) {
        return addEvent(str, Attributes.empty());
    }

    Span addEvent(String str, Attributes attributes);

    Span addEvent(String str, Attributes attributes, long j, TimeUnit timeUnit);

    void end();

    void end(long j, TimeUnit timeUnit);

    default void end(Instant instant) {
        if (instant == null) {
            end();
        } else {
            end(TimeUnit.SECONDS.toNanos(instant.getEpochSecond()) + ((long) instant.getNano()), TimeUnit.NANOSECONDS);
        }
    }

    SpanContext getSpanContext();

    boolean isRecording();

    default Span recordException(Throwable th) {
        return recordException(th, Attributes.empty());
    }

    Span recordException(Throwable th, Attributes attributes);

    default Span setAllAttributes(Attributes attributes) {
        if (attributes != null && !attributes.isEmpty()) {
            attributes.forEach(new C11836a(this, 1));
        }
        return this;
    }

    <T> Span setAttribute(AttributeKey<T> attributeKey, T t);

    default Span setAttribute(String str, String str2) {
        return setAttribute(AttributeKey.stringKey(str), str2);
    }

    default Span setStatus(StatusCode statusCode) {
        return setStatus(statusCode, "");
    }

    Span setStatus(StatusCode statusCode, String str);

    @Override // io.opentelemetry.context.ImplicitContextKeyed
    default Context storeInContext(Context context) {
        return context.with(SpanContextKey.KEY, this);
    }

    Span updateName(String str);

    default Span addEvent(String str, long j, TimeUnit timeUnit) {
        return addEvent(str, Attributes.empty(), j, timeUnit);
    }

    default Span setAttribute(String str, long j) {
        return setAttribute(AttributeKey.longKey(str), Long.valueOf(j));
    }

    default Span addEvent(String str, Instant instant) {
        if (instant == null) {
            return addEvent(str);
        }
        return addEvent(str, TimeUnit.SECONDS.toNanos(instant.getEpochSecond()) + ((long) instant.getNano()), TimeUnit.NANOSECONDS);
    }

    default Span setAttribute(String str, double d) {
        return setAttribute(AttributeKey.doubleKey(str), Double.valueOf(d));
    }

    default Span setAttribute(String str, boolean z) {
        return setAttribute(AttributeKey.booleanKey(str), Boolean.valueOf(z));
    }

    default Span setAttribute(AttributeKey<Long> attributeKey, int i) {
        return setAttribute(attributeKey, Long.valueOf(i));
    }

    default Span addEvent(String str, Attributes attributes, Instant instant) {
        if (instant == null) {
            return addEvent(str, attributes);
        }
        return addEvent(str, attributes, TimeUnit.SECONDS.toNanos(instant.getEpochSecond()) + ((long) instant.getNano()), TimeUnit.NANOSECONDS);
    }
}
