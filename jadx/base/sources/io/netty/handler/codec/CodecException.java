package io.netty.handler.codec;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class CodecException extends RuntimeException {
    private static final long serialVersionUID = -1464830400709348473L;

    public CodecException() {
    }

    public CodecException(String str, Throwable th) {
        super(str, th);
    }

    public CodecException(String str) {
        super(str);
    }

    public CodecException(Throwable th) {
        super(th);
    }
}
