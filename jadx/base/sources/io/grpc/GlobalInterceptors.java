package io.grpc;

import com.google.common.base.Preconditions;
import io.grpc.ServerStreamTracer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Internal
final class GlobalInterceptors {
    private static List<ClientInterceptor> clientInterceptors;
    private static boolean isGlobalInterceptorsTracersGet;
    private static boolean isGlobalInterceptorsTracersSet;
    private static List<ServerInterceptor> serverInterceptors;
    private static List<ServerStreamTracer.Factory> serverStreamTracerFactories;

    private GlobalInterceptors() {
    }

    public static synchronized List<ClientInterceptor> getClientInterceptors() {
        isGlobalInterceptorsTracersGet = true;
        return clientInterceptors;
    }

    public static synchronized List<ServerInterceptor> getServerInterceptors() {
        isGlobalInterceptorsTracersGet = true;
        return serverInterceptors;
    }

    public static synchronized List<ServerStreamTracer.Factory> getServerStreamTracerFactories() {
        isGlobalInterceptorsTracersGet = true;
        return serverStreamTracerFactories;
    }

    public static synchronized void setInterceptorsTracers(List<ClientInterceptor> list, List<ServerInterceptor> list2, List<ServerStreamTracer.Factory> list3) {
        if (isGlobalInterceptorsTracersGet) {
            throw new IllegalStateException("Set cannot be called after any get call");
        }
        if (isGlobalInterceptorsTracersSet) {
            throw new IllegalStateException("Global interceptors and tracers are already set");
        }
        Preconditions.checkNotNull(list);
        Preconditions.checkNotNull(list2);
        Preconditions.checkNotNull(list3);
        clientInterceptors = Collections.unmodifiableList(new ArrayList(list));
        serverInterceptors = Collections.unmodifiableList(new ArrayList(list2));
        serverStreamTracerFactories = Collections.unmodifiableList(new ArrayList(list3));
        isGlobalInterceptorsTracersSet = true;
    }
}
