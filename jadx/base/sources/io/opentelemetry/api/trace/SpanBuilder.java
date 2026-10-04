package io.opentelemetry.api.trace;

import com.vladsch.flexmark.util.ast.C11836a;
import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.context.Context;
import java.time.Instant;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public interface SpanBuilder {
    /* JADX INFO: Access modifiers changed from: private */
    /* synthetic */ default void lambda$setAllAttributes$0(AttributeKey attributeKey, Object obj) {
        setAttribute((AttributeKey<Object>) attributeKey, obj);
    }

    SpanBuilder addLink(SpanContext spanContext);

    SpanBuilder addLink(SpanContext spanContext, Attributes attributes);

    default SpanBuilder setAllAttributes(Attributes attributes) {
        if (attributes != null && !attributes.isEmpty()) {
            attributes.forEach(new C11836a(this, 2));
        }
        return this;
    }

    <T> SpanBuilder setAttribute(AttributeKey<T> attributeKey, T t);

    SpanBuilder setAttribute(String str, double d);

    SpanBuilder setAttribute(String str, long j);

    SpanBuilder setAttribute(String str, String str2);

    SpanBuilder setAttribute(String str, boolean z);

    SpanBuilder setNoParent();

    SpanBuilder setParent(Context context);

    SpanBuilder setSpanKind(SpanKind spanKind);

    SpanBuilder setStartTimestamp(long j, TimeUnit timeUnit);

    default SpanBuilder setStartTimestamp(Instant instant) {
        return instant == null ? this : setStartTimestamp(TimeUnit.SECONDS.toNanos(instant.getEpochSecond()) + ((long) instant.getNano()), TimeUnit.NANOSECONDS);
    }

    Span startSpan();
}
