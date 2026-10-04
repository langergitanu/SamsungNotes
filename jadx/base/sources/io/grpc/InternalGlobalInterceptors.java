package io.grpc;

import io.grpc.ServerStreamTracer;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Internal
public final class InternalGlobalInterceptors {
    private InternalGlobalInterceptors() {
    }

    public static List<ClientInterceptor> getClientInterceptors() {
        return GlobalInterceptors.getClientInterceptors();
    }

    public static List<ServerInterceptor> getServerInterceptors() {
        return GlobalInterceptors.getServerInterceptors();
    }

    public static List<ServerStreamTracer.Factory> getServerStreamTracerFactories() {
        return GlobalInterceptors.getServerStreamTracerFactories();
    }

    public static void setInterceptorsTracers(List<ClientInterceptor> list, List<ServerInterceptor> list2, List<ServerStreamTracer.Factory> list3) {
        GlobalInterceptors.setInterceptorsTracers(list, list2, list3);
    }
}
