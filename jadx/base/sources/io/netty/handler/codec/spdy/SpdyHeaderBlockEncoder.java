package io.netty.handler.codec.spdy;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.util.internal.PlatformDependent;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public abstract class SpdyHeaderBlockEncoder {
    public static SpdyHeaderBlockEncoder newInstance(SpdyVersion spdyVersion, int i, int i2, int i4) {
        return PlatformDependent.javaVersion() >= 7 ? new SpdyHeaderBlockZlibEncoder(spdyVersion, i) : new SpdyHeaderBlockJZlibEncoder(spdyVersion, i, i2, i4);
    }

    public abstract ByteBuf encode(ByteBufAllocator byteBufAllocator, SpdyHeadersFrame spdyHeadersFrame);

    public abstract void end();
}
