package io.netty.handler.codec.http2;

import io.netty.util.internal.ObjectUtil;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final class Http2FrameStreamException extends Exception {
    private static final long serialVersionUID = -4407186173493887044L;
    private final Http2Error error;
    private final Http2FrameStream stream;

    public Http2FrameStreamException(Http2FrameStream http2FrameStream, Http2Error http2Error, Throwable th) {
        super(th.getMessage(), th);
        this.stream = (Http2FrameStream) ObjectUtil.checkNotNull(http2FrameStream, "stream");
        this.error = (Http2Error) ObjectUtil.checkNotNull(http2Error, "error");
    }

    public Http2Error error() {
        return this.error;
    }

    public Http2FrameStream stream() {
        return this.stream;
    }
}
