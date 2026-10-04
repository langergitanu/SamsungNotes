package io.netty.handler.codec.spdy;

import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class DefaultSpdyGoAwayFrame implements SpdyGoAwayFrame {
    private int lastGoodStreamId;
    private SpdySessionStatus status;

    public DefaultSpdyGoAwayFrame(int i) {
        this(i, 0);
    }

    @Override // io.netty.handler.codec.spdy.SpdyGoAwayFrame
    public int lastGoodStreamId() {
        return this.lastGoodStreamId;
    }

    @Override // io.netty.handler.codec.spdy.SpdyGoAwayFrame
    public SpdyGoAwayFrame setLastGoodStreamId(int i) {
        ObjectUtil.checkPositiveOrZero(i, "lastGoodStreamId");
        this.lastGoodStreamId = i;
        return this;
    }

    @Override // io.netty.handler.codec.spdy.SpdyGoAwayFrame
    public SpdyGoAwayFrame setStatus(SpdySessionStatus spdySessionStatus) {
        this.status = spdySessionStatus;
        return this;
    }

    @Override // io.netty.handler.codec.spdy.SpdyGoAwayFrame
    public SpdySessionStatus status() {
        return this.status;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(StringUtil.simpleClassName(this));
        String str = StringUtil.NEWLINE;
        sb.append(str);
        sb.append("--> Last-good-stream-ID = ");
        sb.append(lastGoodStreamId());
        sb.append(str);
        sb.append("--> Status: ");
        sb.append(status());
        return sb.toString();
    }

    public DefaultSpdyGoAwayFrame(int i, int i2) {
        this(i, SpdySessionStatus.valueOf(i2));
    }

    public DefaultSpdyGoAwayFrame(int i, SpdySessionStatus spdySessionStatus) {
        setLastGoodStreamId(i);
        setStatus(spdySessionStatus);
    }
}
