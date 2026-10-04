package io.netty.handler.codec.http2;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final class Http2MultiplexActiveStreamsException extends Exception {
    public Http2MultiplexActiveStreamsException(Throwable th) {
        super(th);
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        return this;
    }
}
