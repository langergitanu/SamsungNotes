package io.netty.handler.codec.http;

import io.netty.handler.codec.TooLongFrameException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final class TooLongHttpContentException extends TooLongFrameException {
    private static final long serialVersionUID = 3238341182129476117L;

    public TooLongHttpContentException() {
    }

    public TooLongHttpContentException(String str, Throwable th) {
        super(str, th);
    }

    public TooLongHttpContentException(String str) {
        super(str);
    }

    public TooLongHttpContentException(Throwable th) {
        super(th);
    }
}
