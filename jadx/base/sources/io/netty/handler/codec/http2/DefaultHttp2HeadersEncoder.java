package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.handler.codec.http2.Http2HeadersEncoder;
import io.netty.util.internal.ObjectUtil;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class DefaultHttp2HeadersEncoder implements Http2HeadersEncoder, Http2HeadersEncoder.Configuration {
    private final HpackEncoder hpackEncoder;
    private final Http2HeadersEncoder.SensitivityDetector sensitivityDetector;
    private final ByteBuf tableSizeChangeOutput;

    public DefaultHttp2HeadersEncoder() {
        this(Http2HeadersEncoder.NEVER_SENSITIVE);
    }

    @Override // io.netty.handler.codec.http2.Http2HeadersEncoder
    public void encodeHeaders(int i, Http2Headers http2Headers, ByteBuf byteBuf) throws Http2Exception {
        try {
            if (this.tableSizeChangeOutput.isReadable()) {
                byteBuf.writeBytes(this.tableSizeChangeOutput);
                this.tableSizeChangeOutput.clear();
            }
            this.hpackEncoder.encodeHeaders(i, byteBuf, http2Headers, this.sensitivityDetector);
        } catch (Http2Exception e) {
            throw e;
        } catch (Throwable th) {
            throw Http2Exception.connectionError(Http2Error.COMPRESSION_ERROR, th, "Failed encoding headers block: %s", th.getMessage());
        }
    }

    @Override // io.netty.handler.codec.http2.Http2HeadersEncoder.Configuration
    public void maxHeaderListSize(long j) throws Http2Exception {
        this.hpackEncoder.setMaxHeaderListSize(j);
    }

    @Override // io.netty.handler.codec.http2.Http2HeadersEncoder.Configuration
    public void maxHeaderTableSize(long j) throws Http2Exception {
        this.hpackEncoder.setMaxHeaderTableSize(this.tableSizeChangeOutput, j);
    }

    public DefaultHttp2HeadersEncoder(Http2HeadersEncoder.SensitivityDetector sensitivityDetector) {
        this(sensitivityDetector, new HpackEncoder());
    }

    @Override // io.netty.handler.codec.http2.Http2HeadersEncoder.Configuration
    public long maxHeaderListSize() {
        return this.hpackEncoder.getMaxHeaderListSize();
    }

    @Override // io.netty.handler.codec.http2.Http2HeadersEncoder.Configuration
    public long maxHeaderTableSize() {
        return this.hpackEncoder.getMaxHeaderTableSize();
    }

    public DefaultHttp2HeadersEncoder(Http2HeadersEncoder.SensitivityDetector sensitivityDetector, boolean z) {
        this(sensitivityDetector, new HpackEncoder(z));
    }

    public DefaultHttp2HeadersEncoder(Http2HeadersEncoder.SensitivityDetector sensitivityDetector, boolean z, int i) {
        this(sensitivityDetector, z, i, 512);
    }

    public DefaultHttp2HeadersEncoder(Http2HeadersEncoder.SensitivityDetector sensitivityDetector, boolean z, int i, int i2) {
        this(sensitivityDetector, new HpackEncoder(z, i, i2));
    }

    public DefaultHttp2HeadersEncoder(Http2HeadersEncoder.SensitivityDetector sensitivityDetector, HpackEncoder hpackEncoder) {
        this.tableSizeChangeOutput = Unpooled.buffer();
        this.sensitivityDetector = (Http2HeadersEncoder.SensitivityDetector) ObjectUtil.checkNotNull(sensitivityDetector, "sensitiveDetector");
        this.hpackEncoder = (HpackEncoder) ObjectUtil.checkNotNull(hpackEncoder, "hpackEncoder");
    }

    @Override // io.netty.handler.codec.http2.Http2HeadersEncoder
    public Http2HeadersEncoder.Configuration configuration() {
        return this;
    }
}
