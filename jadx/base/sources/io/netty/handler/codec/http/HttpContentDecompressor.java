package io.netty.handler.codec.http;

import io.netty.channel.embedded.EmbeddedChannel;
import io.netty.handler.codec.compression.Brotli;
import io.netty.handler.codec.compression.BrotliDecoder;
import io.netty.handler.codec.compression.SnappyFrameDecoder;
import io.netty.handler.codec.compression.ZlibCodecFactory;
import io.netty.handler.codec.compression.ZlibWrapper;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class HttpContentDecompressor extends HttpContentDecoder {
    private final boolean strict;

    public HttpContentDecompressor() {
        this(false);
    }

    @Override // io.netty.handler.codec.http.HttpContentDecoder
    public EmbeddedChannel newContentDecoder(String str) {
        if (HttpHeaderValues.GZIP.contentEqualsIgnoreCase(str) || HttpHeaderValues.X_GZIP.contentEqualsIgnoreCase(str)) {
            return new EmbeddedChannel(this.ctx.channel().mo13765id(), this.ctx.channel().metadata().hasDisconnect(), this.ctx.channel().config(), ZlibCodecFactory.newZlibDecoder(ZlibWrapper.GZIP));
        }
        if (HttpHeaderValues.DEFLATE.contentEqualsIgnoreCase(str) || HttpHeaderValues.X_DEFLATE.contentEqualsIgnoreCase(str)) {
            return new EmbeddedChannel(this.ctx.channel().mo13765id(), this.ctx.channel().metadata().hasDisconnect(), this.ctx.channel().config(), ZlibCodecFactory.newZlibDecoder(this.strict ? ZlibWrapper.ZLIB : ZlibWrapper.ZLIB_OR_NONE));
        }
        if (Brotli.isAvailable() && HttpHeaderValues.f8893BR.contentEqualsIgnoreCase(str)) {
            return new EmbeddedChannel(this.ctx.channel().mo13765id(), this.ctx.channel().metadata().hasDisconnect(), this.ctx.channel().config(), new BrotliDecoder());
        }
        if (HttpHeaderValues.SNAPPY.contentEqualsIgnoreCase(str)) {
            return new EmbeddedChannel(this.ctx.channel().mo13765id(), this.ctx.channel().metadata().hasDisconnect(), this.ctx.channel().config(), new SnappyFrameDecoder());
        }
        return null;
    }

    public HttpContentDecompressor(boolean z) {
        this.strict = z;
    }
}
