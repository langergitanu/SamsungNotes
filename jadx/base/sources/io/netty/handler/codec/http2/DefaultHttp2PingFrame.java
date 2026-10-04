package io.netty.handler.codec.http2;

import androidx.collection.AbstractC0622a;
import io.netty.util.internal.StringUtil;
import org.apache.commons.beanutils.PropertyUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class DefaultHttp2PingFrame implements Http2PingFrame {
    private final boolean ack;
    private final long content;

    public DefaultHttp2PingFrame(long j) {
        this(j, false);
    }

    @Override // io.netty.handler.codec.http2.Http2PingFrame
    public boolean ack() {
        return this.ack;
    }

    @Override // io.netty.handler.codec.http2.Http2PingFrame
    public long content() {
        return this.content;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Http2PingFrame)) {
            return false;
        }
        Http2PingFrame http2PingFrame = (Http2PingFrame) obj;
        return this.ack == http2PingFrame.ack() && this.content == http2PingFrame.content();
    }

    public int hashCode() {
        return (super.hashCode() * 31) + (this.ack ? 1 : 0);
    }

    @Override // io.netty.handler.codec.http2.Http2Frame
    public String name() {
        return "PING";
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(StringUtil.simpleClassName(this));
        sb.append("(content=");
        sb.append(this.content);
        sb.append(", ack=");
        return AbstractC0622a.m1172r(sb, this.ack, PropertyUtils.MAPPED_DELIM2);
    }

    public DefaultHttp2PingFrame(long j, boolean z) {
        this.content = j;
        this.ack = z;
    }
}
