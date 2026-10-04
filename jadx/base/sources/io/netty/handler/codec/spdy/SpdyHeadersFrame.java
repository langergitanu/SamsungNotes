package io.netty.handler.codec.spdy;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public interface SpdyHeadersFrame extends SpdyStreamFrame {
    SpdyHeaders headers();

    boolean isInvalid();

    boolean isTruncated();

    SpdyHeadersFrame setInvalid();

    @Override // io.netty.handler.codec.spdy.SpdyStreamFrame, io.netty.handler.codec.spdy.SpdyDataFrame
    SpdyHeadersFrame setLast(boolean z);

    @Override // io.netty.handler.codec.spdy.SpdyStreamFrame, io.netty.handler.codec.spdy.SpdyDataFrame
    SpdyHeadersFrame setStreamId(int i);

    SpdyHeadersFrame setTruncated();
}
