package io.netty.handler.codec;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class DecoderException extends CodecException {
    private static final long serialVersionUID = 6926716840699621852L;

    public DecoderException() {
    }

    public DecoderException(String str, Throwable th) {
        super(str, th);
    }

    public DecoderException(String str) {
        super(str);
    }

    public DecoderException(Throwable th) {
        super(th);
    }
}
