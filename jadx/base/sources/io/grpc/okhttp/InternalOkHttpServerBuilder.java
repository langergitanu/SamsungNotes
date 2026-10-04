package io.grpc.okhttp;

import io.grpc.Internal;
import io.grpc.ServerStreamTracer;
import io.grpc.internal.InternalServer;
import io.grpc.internal.TransportTracer;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Internal
public final class InternalOkHttpServerBuilder {
    private InternalOkHttpServerBuilder() {
    }

    public static InternalServer buildTransportServers(OkHttpServerBuilder okHttpServerBuilder, List<? extends ServerStreamTracer.Factory> list) {
        return okHttpServerBuilder.buildTransportServers(list);
    }

    public static void setStatsEnabled(OkHttpServerBuilder okHttpServerBuilder, boolean z) {
        okHttpServerBuilder.setStatsEnabled(z);
    }

    public static void setTransportTracerFactory(OkHttpServerBuilder okHttpServerBuilder, TransportTracer.Factory factory) {
        okHttpServerBuilder.setTransportTracerFactory(factory);
    }
}
