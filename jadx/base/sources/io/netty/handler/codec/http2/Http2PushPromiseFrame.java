package io.netty.handler.codec.http2;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public interface Http2PushPromiseFrame extends Http2StreamFrame {
    Http2Headers http2Headers();

    int padding();

    int promisedStreamId();

    Http2FrameStream pushStream();

    Http2StreamFrame pushStream(Http2FrameStream http2FrameStream);

    @Override // io.netty.handler.codec.http2.Http2StreamFrame
    Http2PushPromiseFrame stream(Http2FrameStream http2FrameStream);
}
