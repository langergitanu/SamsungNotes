package io.grpc.netty;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import io.grpc.Status;
import io.grpc.netty.NettyServerStream;
import io.grpc.netty.WriteQueue;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
final class CancelServerStreamCommand extends WriteQueue.AbstractQueuedCommand {
    private final Status reason;
    private final NettyServerStream.TransportState stream;

    public CancelServerStreamCommand(NettyServerStream.TransportState transportState, Status status) {
        this.stream = (NettyServerStream.TransportState) Preconditions.checkNotNull(transportState, "stream");
        this.reason = (Status) Preconditions.checkNotNull(status, "reason");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && CancelServerStreamCommand.class == obj.getClass()) {
            CancelServerStreamCommand cancelServerStreamCommand = (CancelServerStreamCommand) obj;
            if (Objects.equal(this.stream, cancelServerStreamCommand.stream) && Objects.equal(this.reason, cancelServerStreamCommand.reason)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(this.stream, this.reason);
    }

    public Status reason() {
        return this.reason;
    }

    public NettyServerStream.TransportState stream() {
        return this.stream;
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).add("stream", this.stream).add("reason", this.reason).toString();
    }
}
