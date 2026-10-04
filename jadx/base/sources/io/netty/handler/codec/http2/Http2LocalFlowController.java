package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public interface Http2LocalFlowController extends Http2FlowController {
    boolean consumeBytes(Http2Stream http2Stream, int i);

    Http2LocalFlowController frameWriter(Http2FrameWriter http2FrameWriter);

    int initialWindowSize(Http2Stream http2Stream);

    void receiveFlowControlledFrame(Http2Stream http2Stream, ByteBuf byteBuf, int i, boolean z);

    int unconsumedBytes(Http2Stream http2Stream);
}
