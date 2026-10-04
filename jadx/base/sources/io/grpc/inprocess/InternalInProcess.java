package io.grpc.inprocess;

import io.grpc.Attributes;
import io.grpc.Internal;
import io.grpc.ServerStreamTracer;
import io.grpc.internal.ConnectionClientTransport;
import io.grpc.internal.ObjectPool;
import io.grpc.internal.ServerListener;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Internal
public final class InternalInProcess {
    private InternalInProcess() {
    }

    @Internal
    public static ConnectionClientTransport createInProcessTransport(String str, int i, String str2, String str3, Attributes attributes, ObjectPool<ScheduledExecutorService> objectPool, List<ServerStreamTracer.Factory> list, ServerListener serverListener, boolean z) {
        return new InProcessTransport(str, i, str2, str3, attributes, objectPool, list, serverListener, z);
    }
}
