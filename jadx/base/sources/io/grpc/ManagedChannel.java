package io.grpc;

import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.ThreadSafe;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@ThreadSafe
public abstract class ManagedChannel extends Channel {
    public abstract boolean awaitTermination(long j, TimeUnit timeUnit);

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/4056")
    public void enterIdle() {
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/4359")
    public ConnectivityState getState(boolean z) {
        throw new UnsupportedOperationException("Not implemented");
    }

    public abstract boolean isShutdown();

    public abstract boolean isTerminated();

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/4359")
    public void notifyWhenStateChanged(ConnectivityState connectivityState, Runnable runnable) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/4056")
    public void resetConnectBackoff() {
    }

    public abstract ManagedChannel shutdown();

    public abstract ManagedChannel shutdownNow();
}
