package io.netty.handler.codec.spdy;

import io.netty.util.internal.StringUtil;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class DefaultSpdyPingFrame implements SpdyPingFrame {

    /* JADX INFO: renamed from: id */
    private int f8932id;

    public DefaultSpdyPingFrame(int i) {
        setId(i);
    }

    @Override // io.netty.handler.codec.spdy.SpdyPingFrame
    /* JADX INFO: renamed from: id */
    public int mo13775id() {
        return this.f8932id;
    }

    @Override // io.netty.handler.codec.spdy.SpdyPingFrame
    public SpdyPingFrame setId(int i) {
        this.f8932id = i;
        return this;
    }

    public String toString() {
        return StringUtil.simpleClassName(this) + StringUtil.NEWLINE + "--> ID = " + mo13775id();
    }
}
