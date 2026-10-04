package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.http2.Http2HeadersDecoder;
import io.netty.util.internal.ObjectUtil;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class DefaultHttp2HeadersDecoder implements Http2HeadersDecoder, Http2HeadersDecoder.Configuration {
    private static final float HEADERS_COUNT_WEIGHT_HISTORICAL = 0.8f;
    private static final float HEADERS_COUNT_WEIGHT_NEW = 0.2f;
    private float headerArraySizeAccumulator;
    private final HpackDecoder hpackDecoder;
    private long maxHeaderListSizeGoAway;
    private final boolean validateHeaderValues;
    private final boolean validateHeaders;

    public DefaultHttp2HeadersDecoder() {
        this(true);
    }

    @Override // io.netty.handler.codec.http2.Http2HeadersDecoder
    public Http2Headers decodeHeaders(int i, ByteBuf byteBuf) throws Http2Exception {
        try {
            Http2Headers http2HeadersNewHeaders = newHeaders();
            this.hpackDecoder.decode(i, byteBuf, http2HeadersNewHeaders, this.validateHeaders);
            this.headerArraySizeAccumulator = (this.headerArraySizeAccumulator * 0.8f) + (http2HeadersNewHeaders.size() * 0.2f);
            return http2HeadersNewHeaders;
        } catch (Http2Exception e) {
            throw e;
        } catch (Throwable th) {
            throw Http2Exception.connectionError(Http2Error.COMPRESSION_ERROR, th, "Error decoding headers: %s", th.getMessage());
        }
    }

    @Override // io.netty.handler.codec.http2.Http2HeadersDecoder.Configuration
    public void maxHeaderListSize(long j, long j2) throws Http2Exception {
        if (j2 < j || j2 < 0) {
            throw Http2Exception.connectionError(Http2Error.INTERNAL_ERROR, "Header List Size GO_AWAY %d must be non-negative and >= %d", Long.valueOf(j2), Long.valueOf(j));
        }
        this.hpackDecoder.setMaxHeaderListSize(j);
        this.maxHeaderListSizeGoAway = j2;
    }

    @Override // io.netty.handler.codec.http2.Http2HeadersDecoder.Configuration
    public long maxHeaderListSizeGoAway() {
        return this.maxHeaderListSizeGoAway;
    }

    @Override // io.netty.handler.codec.http2.Http2HeadersDecoder.Configuration
    public void maxHeaderTableSize(long j) throws Http2Exception {
        this.hpackDecoder.setMaxHeaderTableSize(j);
    }

    public Http2Headers newHeaders() {
        return new DefaultHttp2Headers(this.validateHeaders, this.validateHeaderValues, (int) this.headerArraySizeAccumulator);
    }

    public final int numberOfHeadersGuess() {
        return (int) this.headerArraySizeAccumulator;
    }

    public boolean validateHeaderValues() {
        return this.validateHeaderValues;
    }

    public final boolean validateHeaders() {
        return this.validateHeaders;
    }

    public DefaultHttp2HeadersDecoder(boolean z) {
        this(z, 8192L);
    }

    @Override // io.netty.handler.codec.http2.Http2HeadersDecoder.Configuration
    public long maxHeaderTableSize() {
        return this.hpackDecoder.getMaxHeaderTableSize();
    }

    public DefaultHttp2HeadersDecoder(boolean z, boolean z2) {
        this(z, z2, 8192L);
    }

    public DefaultHttp2HeadersDecoder(boolean z, long j) {
        this(z, false, new HpackDecoder(j));
    }

    public DefaultHttp2HeadersDecoder(boolean z, boolean z2, long j) {
        this(z, z2, new HpackDecoder(j));
    }

    public DefaultHttp2HeadersDecoder(boolean z, long j, @Deprecated int i) {
        this(z, false, new HpackDecoder(j));
    }

    @Override // io.netty.handler.codec.http2.Http2HeadersDecoder.Configuration
    public long maxHeaderListSize() {
        return this.hpackDecoder.getMaxHeaderListSize();
    }

    public DefaultHttp2HeadersDecoder(boolean z, boolean z2, HpackDecoder hpackDecoder) {
        this.headerArraySizeAccumulator = 8.0f;
        this.hpackDecoder = (HpackDecoder) ObjectUtil.checkNotNull(hpackDecoder, "hpackDecoder");
        this.validateHeaders = z;
        this.validateHeaderValues = z2;
        this.maxHeaderListSizeGoAway = Http2CodecUtil.calculateMaxHeaderListSizeGoAway(hpackDecoder.getMaxHeaderListSize());
    }

    @Override // io.netty.handler.codec.http2.Http2HeadersDecoder
    public Http2HeadersDecoder.Configuration configuration() {
        return this;
    }
}
