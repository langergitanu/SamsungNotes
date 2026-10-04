package io.netty.handler.codec.spdy;

import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class DefaultSpdyWindowUpdateFrame implements SpdyWindowUpdateFrame {
    private int deltaWindowSize;
    private int streamId;

    public DefaultSpdyWindowUpdateFrame(int i, int i2) {
        setStreamId(i);
        setDeltaWindowSize(i2);
    }

    @Override // io.netty.handler.codec.spdy.SpdyWindowUpdateFrame
    public int deltaWindowSize() {
        return this.deltaWindowSize;
    }

    @Override // io.netty.handler.codec.spdy.SpdyWindowUpdateFrame
    public SpdyWindowUpdateFrame setDeltaWindowSize(int i) {
        ObjectUtil.checkPositive(i, "deltaWindowSize");
        this.deltaWindowSize = i;
        return this;
    }

    @Override // io.netty.handler.codec.spdy.SpdyWindowUpdateFrame
    public SpdyWindowUpdateFrame setStreamId(int i) {
        ObjectUtil.checkPositiveOrZero(i, "streamId");
        this.streamId = i;
        return this;
    }

    @Override // io.netty.handler.codec.spdy.SpdyWindowUpdateFrame
    public int streamId() {
        return this.streamId;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(StringUtil.simpleClassName(this));
        String str = StringUtil.NEWLINE;
        sb.append(str);
        sb.append("--> Stream-ID = ");
        sb.append(streamId());
        sb.append(str);
        sb.append("--> Delta-Window-Size = ");
        sb.append(deltaWindowSize());
        return sb.toString();
    }
}
