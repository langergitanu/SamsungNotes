package io.opentelemetry.api.trace;

import javax.annotation.concurrent.ThreadSafe;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@ThreadSafe
public interface TracerProvider {
    static TracerProvider noop() {
        return DefaultTracerProvider.getInstance();
    }

    Tracer get(String str);

    Tracer get(String str, String str2);

    default TracerBuilder tracerBuilder(String str) {
        return DefaultTracerBuilder.getInstance();
    }
}
