package io.grpc.internal;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import io.grpc.ClientStreamTracer;
import io.grpc.Metadata;
import io.grpc.Status;
import io.grpc.internal.ClientStreamListener;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final class FailingClientStream extends NoopClientStream {
    private final Status error;
    private final ClientStreamListener.RpcProgress rpcProgress;
    private boolean started;
    private final ClientStreamTracer[] tracers;

    public FailingClientStream(Status status, ClientStreamTracer[] clientStreamTracerArr) {
        this(status, ClientStreamListener.RpcProgress.PROCESSED, clientStreamTracerArr);
    }

    @Override // io.grpc.internal.NoopClientStream, io.grpc.internal.ClientStream
    public void appendTimeoutInsight(InsightBuilder insightBuilder) {
        insightBuilder.appendKeyValue("error", this.error).appendKeyValue("progress", this.rpcProgress);
    }

    @VisibleForTesting
    public Status getError() {
        return this.error;
    }

    @Override // io.grpc.internal.NoopClientStream, io.grpc.internal.ClientStream
    public void start(ClientStreamListener clientStreamListener) {
        Preconditions.checkState(!this.started, "already started");
        this.started = true;
        for (ClientStreamTracer clientStreamTracer : this.tracers) {
            clientStreamTracer.streamClosed(this.error);
        }
        clientStreamListener.closed(this.error, this.rpcProgress, new Metadata());
    }

    public FailingClientStream(Status status, ClientStreamListener.RpcProgress rpcProgress, ClientStreamTracer[] clientStreamTracerArr) {
        Preconditions.checkArgument(!status.isOk(), "error must not be OK");
        this.error = status;
        this.rpcProgress = rpcProgress;
        this.tracers = clientStreamTracerArr;
    }
}
