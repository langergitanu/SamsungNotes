package io.netty.handler.codec.spdy;

import io.netty.channel.CombinedChannelDuplexHandler;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final class SpdyHttpCodec extends CombinedChannelDuplexHandler<SpdyHttpDecoder, SpdyHttpEncoder> {
    public SpdyHttpCodec(SpdyVersion spdyVersion, int i) {
        super(new SpdyHttpDecoder(spdyVersion, i), new SpdyHttpEncoder(spdyVersion));
    }

    public SpdyHttpCodec(SpdyVersion spdyVersion, int i, boolean z) {
        super(new SpdyHttpDecoder(spdyVersion, i, z), new SpdyHttpEncoder(spdyVersion));
    }
}
