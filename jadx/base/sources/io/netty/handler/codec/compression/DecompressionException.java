package io.netty.handler.codec.compression;

import io.netty.handler.codec.DecoderException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class DecompressionException extends DecoderException {
    private static final long serialVersionUID = 3546272712208105199L;

    public DecompressionException() {
    }

    public DecompressionException(String str, Throwable th) {
        super(str, th);
    }

    public DecompressionException(String str) {
        super(str);
    }

    public DecompressionException(Throwable th) {
        super(th);
    }
}
