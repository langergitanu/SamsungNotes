package io.grpc.inprocess;

import com.google.common.base.Preconditions;
import io.grpc.ExperimentalApi;
import java.io.IOException;
import java.net.SocketAddress;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@ExperimentalApi("https://github.com/grpc/grpc-java/issues/8626")
public final class AnonymousInProcessSocketAddress extends SocketAddress {
    private static final long serialVersionUID = -8567592561863414695L;

    @GuardedBy("this")
    @Nullable
    private InProcessServer server;

    public synchronized void clearServer(InProcessServer inProcessServer) {
        Preconditions.checkState(this.server == inProcessServer);
        this.server = null;
    }

    @Nullable
    public synchronized InProcessServer getServer() {
        return this.server;
    }

    public synchronized void setServer(InProcessServer inProcessServer) {
        if (this.server != null) {
            throw new IOException("Server instance already registered");
        }
        this.server = inProcessServer;
    }
}
