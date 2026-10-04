package io.netty.handler.codec.http2;

import io.netty.util.internal.StringUtil;
import org.apache.commons.beanutils.PropertyUtils;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class DefaultHttp2WindowUpdateFrame extends AbstractHttp2StreamFrame implements Http2WindowUpdateFrame {
    private final int windowUpdateIncrement;

    public DefaultHttp2WindowUpdateFrame(int i) {
        this.windowUpdateIncrement = i;
    }

    @Override // io.netty.handler.codec.http2.Http2Frame
    public String name() {
        return "WINDOW_UPDATE";
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(StringUtil.simpleClassName(this));
        sb.append("(stream=");
        sb.append(stream());
        sb.append(", windowUpdateIncrement=");
        return AbstractC0000a.m13j(sb, this.windowUpdateIncrement, PropertyUtils.MAPPED_DELIM2);
    }

    @Override // io.netty.handler.codec.http2.Http2WindowUpdateFrame
    public int windowSizeIncrement() {
        return this.windowUpdateIncrement;
    }

    @Override // io.netty.handler.codec.http2.AbstractHttp2StreamFrame, io.netty.handler.codec.http2.Http2StreamFrame
    public DefaultHttp2WindowUpdateFrame stream(Http2FrameStream http2FrameStream) {
        super.stream(http2FrameStream);
        return this;
    }
}
