package com.microsoft.identity.common.java.opentelemetry;

import androidx.collection.AbstractC0622a;
import com.microsoft.identity.common.java.logging.Logger;
import io.opentelemetry.api.metrics.LongCounter;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.SpanContext;
import io.opentelemetry.context.Context;
import javax.annotation.Nullable;
import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class OTelUtility {
    private static final String TAG = "OTelUtility";

    @NonNull
    public static LongCounter createLongCounter(@NonNull String str, @NonNull String str2) {
        if (str == null) {
            throw new NullPointerException("name is marked non-null but is null");
        }
        if (str2 != null) {
            return OpenTelemetryHolder.getMeter(TAG).counterBuilder(str).setDescription(str2).setUnit("count").build();
        }
        throw new NullPointerException("description is marked non-null but is null");
    }

    @NonNull
    public static Span createSpan(@NonNull String str) {
        if (str != null) {
            return OpenTelemetryHolder.getTracer(TAG).spanBuilder(str).startSpan();
        }
        throw new NullPointerException("name is marked non-null but is null");
    }

    @NonNull
    public static Span createSpanFromParent(@NonNull String str, @Nullable SpanContext spanContext) {
        if (str == null) {
            throw new NullPointerException("name is marked non-null but is null");
        }
        StringBuilder sb = new StringBuilder();
        String str2 = TAG;
        String strM1170p = AbstractC0622a.m1170p(str2, ":createSpanFromParent", sb);
        if (spanContext == null) {
            Logger.verbose(strM1170p, "parentSpanContext is NULL. Creating span without parent.");
            return createSpan(str);
        }
        if (spanContext.isValid()) {
            return OpenTelemetryHolder.getTracer(str2).spanBuilder(str).setParent(Context.current().with(Span.wrap(spanContext))).startSpan();
        }
        Logger.warn(strM1170p, "parentSpanContext is INVALID. Creating span without parent.");
        return createSpan(str);
    }

    @NonNull
    public static Span createSpan(@NonNull String str, @NonNull String str2) {
        if (str == null) {
            throw new NullPointerException("name is marked non-null but is null");
        }
        if (str2 != null) {
            return OpenTelemetryHolder.getTracer(TAG).spanBuilder(str).setAttribute(AttributeName.calling_package_name.name(), str2).startSpan();
        }
        throw new NullPointerException("callingPackageName is marked non-null but is null");
    }

    @NonNull
    public static Span createSpanFromParent(@NonNull String str, @Nullable SpanContext spanContext, @NonNull String str2) {
        if (str == null) {
            throw new NullPointerException("name is marked non-null but is null");
        }
        if (str2 != null) {
            StringBuilder sb = new StringBuilder();
            String str3 = TAG;
            String strM1170p = AbstractC0622a.m1170p(str3, ":createSpanFromParent", sb);
            if (spanContext == null) {
                Logger.verbose(strM1170p, "parentSpanContext is NULL. Creating span without parent.");
                return createSpan(str, str2);
            }
            if (!spanContext.isValid()) {
                Logger.warn(strM1170p, "parentSpanContext is INVALID. Creating span without parent.");
                return createSpan(str, str2);
            }
            return OpenTelemetryHolder.getTracer(str3).spanBuilder(str).setParent(Context.current().with(Span.wrap(spanContext))).setAttribute(AttributeName.calling_package_name.name(), str2).startSpan();
        }
        throw new NullPointerException("callingPackageName is marked non-null but is null");
    }
}
