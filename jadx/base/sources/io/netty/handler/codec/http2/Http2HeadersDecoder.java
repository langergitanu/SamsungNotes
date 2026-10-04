package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public interface Http2HeadersDecoder {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Configuration {
        long maxHeaderListSize();

        void maxHeaderListSize(long j, long j2);

        long maxHeaderListSizeGoAway();

        long maxHeaderTableSize();

        void maxHeaderTableSize(long j);
    }

    Configuration configuration();

    Http2Headers decodeHeaders(int i, ByteBuf byteBuf);
}
