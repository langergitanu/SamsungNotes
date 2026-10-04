package io.grpc.netty;

import com.google.common.base.Preconditions;
import com.samsung.android.app.sdk.deepsky.contract.search.Contract;
import io.grpc.netty.NettyClientStream;
import io.grpc.netty.WriteQueue;
import io.netty.handler.codec.http2.Http2Headers;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
class CreateStreamCommand extends WriteQueue.AbstractQueuedCommand {
    private final boolean get;
    private final Http2Headers headers;
    private final boolean shouldBeCountedForInUse;
    private final NettyClientStream.TransportState stream;

    public CreateStreamCommand(Http2Headers http2Headers, NettyClientStream.TransportState transportState, boolean z, boolean z2) {
        this.stream = (NettyClientStream.TransportState) Preconditions.checkNotNull(transportState, "stream");
        this.headers = (Http2Headers) Preconditions.checkNotNull(http2Headers, Contract.HEADERS);
        this.shouldBeCountedForInUse = z;
        this.get = z2;
    }

    public Http2Headers headers() {
        return this.headers;
    }

    public boolean isGet() {
        return this.get;
    }

    public boolean shouldBeCountedForInUse() {
        return this.shouldBeCountedForInUse;
    }

    public NettyClientStream.TransportState stream() {
        return this.stream;
    }
}
