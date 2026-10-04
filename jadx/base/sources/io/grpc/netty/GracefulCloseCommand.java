package io.grpc.netty;

import io.grpc.Status;
import io.grpc.netty.WriteQueue;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
class GracefulCloseCommand extends WriteQueue.AbstractQueuedCommand {
    private final Status status;

    public GracefulCloseCommand(Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return this.status;
    }
}
