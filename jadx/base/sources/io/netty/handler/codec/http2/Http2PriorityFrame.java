package io.netty.handler.codec.http2;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public interface Http2PriorityFrame extends Http2StreamFrame {
    boolean exclusive();

    @Override // io.netty.handler.codec.http2.Http2StreamFrame
    Http2PriorityFrame stream(Http2FrameStream http2FrameStream);

    int streamDependency();

    short weight();
}
