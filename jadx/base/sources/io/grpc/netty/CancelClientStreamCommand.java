package io.grpc.netty;

import com.google.common.base.Preconditions;
import io.grpc.Status;
import io.grpc.netty.NettyClientStream;
import io.grpc.netty.WriteQueue;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
class CancelClientStreamCommand extends WriteQueue.AbstractQueuedCommand {

    @Nullable
    private final Status reason;
    private final NettyClientStream.TransportState stream;

    public CancelClientStreamCommand(NettyClientStream.TransportState transportState, Status status) {
        this.stream = (NettyClientStream.TransportState) Preconditions.checkNotNull(transportState, "stream");
        Preconditions.checkArgument(status == null || !status.isOk(), "Should not cancel with OK status");
        this.reason = status;
    }

    @Nullable
    public Status reason() {
        return this.reason;
    }

    public NettyClientStream.TransportState stream() {
        return this.stream;
    }
}
