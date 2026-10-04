package io.netty.handler.codec.http2;

import io.netty.handler.codec.http2.Http2Exception;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class Http2NoMoreStreamIdsException extends Http2Exception {
    private static final String ERROR_MESSAGE = "No more streams can be created on this connection";
    private static final long serialVersionUID = -7756236161274851110L;

    public Http2NoMoreStreamIdsException() {
        super(Http2Error.PROTOCOL_ERROR, ERROR_MESSAGE, Http2Exception.ShutdownHint.GRACEFUL_SHUTDOWN);
    }

    public Http2NoMoreStreamIdsException(Throwable th) {
        super(Http2Error.PROTOCOL_ERROR, ERROR_MESSAGE, th, Http2Exception.ShutdownHint.GRACEFUL_SHUTDOWN);
    }
}
