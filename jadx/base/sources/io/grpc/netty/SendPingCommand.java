package io.grpc.netty;

import io.grpc.internal.ClientTransport;
import io.grpc.netty.WriteQueue;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
class SendPingCommand extends WriteQueue.AbstractQueuedCommand {
    private final ClientTransport.PingCallback callback;
    private final Executor executor;

    public SendPingCommand(ClientTransport.PingCallback pingCallback, Executor executor) {
        this.callback = pingCallback;
        this.executor = executor;
    }

    public ClientTransport.PingCallback callback() {
        return this.callback;
    }

    public Executor executor() {
        return this.executor;
    }
}
