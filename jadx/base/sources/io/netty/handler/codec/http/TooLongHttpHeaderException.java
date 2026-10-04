package io.netty.handler.codec.http;

import io.netty.handler.codec.TooLongFrameException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final class TooLongHttpHeaderException extends TooLongFrameException {
    private static final long serialVersionUID = -8295159138628369730L;

    public TooLongHttpHeaderException() {
    }

    public TooLongHttpHeaderException(String str, Throwable th) {
        super(str, th);
    }

    public TooLongHttpHeaderException(String str) {
        super(str);
    }

    public TooLongHttpHeaderException(Throwable th) {
        super(th);
    }
}
