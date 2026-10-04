package io.netty.handler.codec.http2;

import com.samsung.android.app.sdk.deepsky.contract.search.Contract;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import org.apache.commons.beanutils.PropertyUtils;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final class DefaultHttp2HeadersFrame extends AbstractHttp2StreamFrame implements Http2HeadersFrame {
    private final boolean endStream;
    private final Http2Headers headers;
    private final int padding;

    public DefaultHttp2HeadersFrame(Http2Headers http2Headers) {
        this(http2Headers, false);
    }

    @Override // io.netty.handler.codec.http2.AbstractHttp2StreamFrame
    public boolean equals(Object obj) {
        if (!(obj instanceof DefaultHttp2HeadersFrame)) {
            return false;
        }
        DefaultHttp2HeadersFrame defaultHttp2HeadersFrame = (DefaultHttp2HeadersFrame) obj;
        return super.equals(defaultHttp2HeadersFrame) && this.headers.equals(defaultHttp2HeadersFrame.headers) && this.endStream == defaultHttp2HeadersFrame.endStream && this.padding == defaultHttp2HeadersFrame.padding;
    }

    @Override // io.netty.handler.codec.http2.AbstractHttp2StreamFrame
    public int hashCode() {
        return ((((this.headers.hashCode() + (super.hashCode() * 31)) * 31) + (!this.endStream ? 1 : 0)) * 31) + this.padding;
    }

    @Override // io.netty.handler.codec.http2.Http2HeadersFrame
    public Http2Headers headers() {
        return this.headers;
    }

    @Override // io.netty.handler.codec.http2.Http2HeadersFrame
    public boolean isEndStream() {
        return this.endStream;
    }

    @Override // io.netty.handler.codec.http2.Http2Frame
    public String name() {
        return "HEADERS";
    }

    @Override // io.netty.handler.codec.http2.Http2HeadersFrame
    public int padding() {
        return this.padding;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(StringUtil.simpleClassName(this));
        sb.append("(stream=");
        sb.append(stream());
        sb.append(", headers=");
        sb.append(this.headers);
        sb.append(", endStream=");
        sb.append(this.endStream);
        sb.append(", padding=");
        return AbstractC0000a.m13j(sb, this.padding, PropertyUtils.MAPPED_DELIM2);
    }

    public DefaultHttp2HeadersFrame(Http2Headers http2Headers, boolean z) {
        this(http2Headers, z, 0);
    }

    public DefaultHttp2HeadersFrame(Http2Headers http2Headers, boolean z, int i) {
        this.headers = (Http2Headers) ObjectUtil.checkNotNull(http2Headers, Contract.HEADERS);
        this.endStream = z;
        Http2CodecUtil.verifyPadding(i);
        this.padding = i;
    }

    @Override // io.netty.handler.codec.http2.AbstractHttp2StreamFrame, io.netty.handler.codec.http2.Http2StreamFrame
    public DefaultHttp2HeadersFrame stream(Http2FrameStream http2FrameStream) {
        super.stream(http2FrameStream);
        return this;
    }
}
