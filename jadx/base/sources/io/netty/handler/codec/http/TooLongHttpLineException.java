package io.netty.handler.codec.http;

import io.netty.handler.codec.TooLongFrameException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final class TooLongHttpLineException extends TooLongFrameException {
    private static final long serialVersionUID = 1614751125592211890L;

    public TooLongHttpLineException() {
    }

    public TooLongHttpLineException(String str, Throwable th) {
        super(str, th);
    }

    public TooLongHttpLineException(String str) {
        super(str);
    }

    public TooLongHttpLineException(Throwable th) {
        super(th);
    }
}
