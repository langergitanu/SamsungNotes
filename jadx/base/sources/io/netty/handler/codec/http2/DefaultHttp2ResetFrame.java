package io.netty.handler.codec.http2;

import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import org.apache.commons.beanutils.PropertyUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final class DefaultHttp2ResetFrame extends AbstractHttp2StreamFrame implements Http2ResetFrame {
    private final long errorCode;

    public DefaultHttp2ResetFrame(Http2Error http2Error) {
        this.errorCode = ((Http2Error) ObjectUtil.checkNotNull(http2Error, "error")).code();
    }

    @Override // io.netty.handler.codec.http2.AbstractHttp2StreamFrame
    public boolean equals(Object obj) {
        if (obj instanceof DefaultHttp2ResetFrame) {
            return super.equals(obj) && this.errorCode == ((DefaultHttp2ResetFrame) obj).errorCode;
        }
        return false;
    }

    @Override // io.netty.handler.codec.http2.Http2ResetFrame
    public long errorCode() {
        return this.errorCode;
    }

    @Override // io.netty.handler.codec.http2.AbstractHttp2StreamFrame
    public int hashCode() {
        int iHashCode = super.hashCode() * 31;
        long j = this.errorCode;
        return iHashCode + ((int) (j ^ (j >>> 32)));
    }

    @Override // io.netty.handler.codec.http2.Http2Frame
    public String name() {
        return "RST_STREAM";
    }

    public String toString() {
        return StringUtil.simpleClassName(this) + "(stream=" + stream() + ", errorCode=" + this.errorCode + PropertyUtils.MAPPED_DELIM2;
    }

    public DefaultHttp2ResetFrame(long j) {
        this.errorCode = j;
    }

    @Override // io.netty.handler.codec.http2.AbstractHttp2StreamFrame, io.netty.handler.codec.http2.Http2StreamFrame
    public DefaultHttp2ResetFrame stream(Http2FrameStream http2FrameStream) {
        super.stream(http2FrameStream);
        return this;
    }
}
