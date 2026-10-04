package io.netty.handler.codec.http2;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public abstract class AbstractHttp2StreamFrame implements Http2StreamFrame {
    private Http2FrameStream stream;

    public boolean equals(Object obj) {
        if (!(obj instanceof Http2StreamFrame)) {
            return false;
        }
        Http2StreamFrame http2StreamFrame = (Http2StreamFrame) obj;
        if (this.stream == http2StreamFrame.stream()) {
            return true;
        }
        Http2FrameStream http2FrameStream = this.stream;
        return http2FrameStream != null && http2FrameStream.equals(http2StreamFrame.stream());
    }

    public int hashCode() {
        Http2FrameStream http2FrameStream = this.stream;
        return http2FrameStream == null ? super.hashCode() : http2FrameStream.hashCode();
    }

    @Override // io.netty.handler.codec.http2.Http2StreamFrame
    public AbstractHttp2StreamFrame stream(Http2FrameStream http2FrameStream) {
        this.stream = http2FrameStream;
        return this;
    }

    @Override // io.netty.handler.codec.http2.Http2StreamFrame
    public Http2FrameStream stream() {
        return this.stream;
    }
}
