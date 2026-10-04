package io.grpc;

import io.grpc.Context;
import java.net.SocketAddress;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.ThreadSafe;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@ThreadSafe
public abstract class Server {
    static final Context.Key<Server> SERVER_CONTEXT_KEY = Context.key("io.grpc.Server");

    public abstract void awaitTermination();

    public abstract boolean awaitTermination(long j, TimeUnit timeUnit);

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/2222")
    public List<ServerServiceDefinition> getImmutableServices() {
        return Collections.EMPTY_LIST;
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/5332")
    public List<? extends SocketAddress> getListenSockets() {
        throw new UnsupportedOperationException();
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/2222")
    public List<ServerServiceDefinition> getMutableServices() {
        return Collections.EMPTY_LIST;
    }

    public int getPort() {
        return -1;
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/2222")
    public List<ServerServiceDefinition> getServices() {
        return Collections.EMPTY_LIST;
    }

    public abstract boolean isShutdown();

    public abstract boolean isTerminated();

    public abstract Server shutdown();

    public abstract Server shutdownNow();

    public abstract Server start();
}
