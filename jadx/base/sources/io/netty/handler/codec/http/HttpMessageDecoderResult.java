package io.netty.handler.codec.http;

import io.netty.handler.codec.DecoderResult;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final class HttpMessageDecoderResult extends DecoderResult {
    private final int headerSize;
    private final int initialLineLength;

    public HttpMessageDecoderResult(int i, int i2) {
        super(DecoderResult.SIGNAL_SUCCESS);
        this.initialLineLength = i;
        this.headerSize = i2;
    }

    public int headerSize() {
        return this.headerSize;
    }

    public int initialLineLength() {
        return this.initialLineLength;
    }

    public int totalSize() {
        return this.initialLineLength + this.headerSize;
    }
}
