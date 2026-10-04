package io.netty.handler.codec.spdy;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public interface SpdySynReplyFrame extends SpdyHeadersFrame {
    @Override // io.netty.handler.codec.spdy.SpdyHeadersFrame
    SpdySynReplyFrame setInvalid();

    @Override // io.netty.handler.codec.spdy.SpdyHeadersFrame, io.netty.handler.codec.spdy.SpdyStreamFrame, io.netty.handler.codec.spdy.SpdyDataFrame
    SpdySynReplyFrame setLast(boolean z);

    @Override // io.netty.handler.codec.spdy.SpdyHeadersFrame, io.netty.handler.codec.spdy.SpdyStreamFrame, io.netty.handler.codec.spdy.SpdyDataFrame
    SpdySynReplyFrame setStreamId(int i);
}
