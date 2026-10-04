package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.DefaultByteBufHolder;
import io.netty.buffer.Unpooled;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import org.apache.commons.beanutils.PropertyUtils;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final class DefaultHttp2GoAwayFrame extends DefaultByteBufHolder implements Http2GoAwayFrame {
    private final long errorCode;
    private int extraStreamIds;
    private final int lastStreamId;

    public DefaultHttp2GoAwayFrame(Http2Error http2Error) {
        this(http2Error.code());
    }

    @Override // io.netty.buffer.DefaultByteBufHolder
    public boolean equals(Object obj) {
        if (!(obj instanceof DefaultHttp2GoAwayFrame)) {
            return false;
        }
        DefaultHttp2GoAwayFrame defaultHttp2GoAwayFrame = (DefaultHttp2GoAwayFrame) obj;
        return this.errorCode == defaultHttp2GoAwayFrame.errorCode && this.extraStreamIds == defaultHttp2GoAwayFrame.extraStreamIds && super.equals(defaultHttp2GoAwayFrame);
    }

    @Override // io.netty.handler.codec.http2.Http2GoAwayFrame
    public long errorCode() {
        return this.errorCode;
    }

    @Override // io.netty.handler.codec.http2.Http2GoAwayFrame
    public int extraStreamIds() {
        return this.extraStreamIds;
    }

    @Override // io.netty.buffer.DefaultByteBufHolder
    public int hashCode() {
        int iHashCode = super.hashCode() * 31;
        long j = this.errorCode;
        return ((iHashCode + ((int) (j ^ (j >>> 32)))) * 31) + this.extraStreamIds;
    }

    @Override // io.netty.handler.codec.http2.Http2GoAwayFrame
    public int lastStreamId() {
        return this.lastStreamId;
    }

    @Override // io.netty.handler.codec.http2.Http2Frame
    public String name() {
        return "GOAWAY";
    }

    @Override // io.netty.handler.codec.http2.Http2GoAwayFrame
    public Http2GoAwayFrame setExtraStreamIds(int i) {
        ObjectUtil.checkPositiveOrZero(i, "extraStreamIds");
        this.extraStreamIds = i;
        return this;
    }

    @Override // io.netty.buffer.DefaultByteBufHolder
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(StringUtil.simpleClassName(this));
        sb.append("(errorCode=");
        sb.append(this.errorCode);
        sb.append(", content=");
        sb.append(content());
        sb.append(", extraStreamIds=");
        sb.append(this.extraStreamIds);
        sb.append(", lastStreamId=");
        return AbstractC0000a.m13j(sb, this.lastStreamId, PropertyUtils.MAPPED_DELIM2);
    }

    public DefaultHttp2GoAwayFrame(long j) {
        this(j, Unpooled.EMPTY_BUFFER);
    }

    @Override // io.netty.buffer.DefaultByteBufHolder, io.netty.buffer.ByteBufHolder
    public Http2GoAwayFrame copy() {
        return new DefaultHttp2GoAwayFrame(this.lastStreamId, this.errorCode, content().copy());
    }

    @Override // io.netty.buffer.DefaultByteBufHolder, io.netty.buffer.ByteBufHolder
    public Http2GoAwayFrame duplicate() {
        return (Http2GoAwayFrame) super.duplicate();
    }

    @Override // io.netty.buffer.DefaultByteBufHolder, io.netty.buffer.ByteBufHolder
    public Http2GoAwayFrame replace(ByteBuf byteBuf) {
        return new DefaultHttp2GoAwayFrame(this.errorCode, byteBuf).setExtraStreamIds(this.extraStreamIds);
    }

    @Override // io.netty.buffer.DefaultByteBufHolder, io.netty.buffer.ByteBufHolder
    public Http2GoAwayFrame retainedDuplicate() {
        return (Http2GoAwayFrame) super.retainedDuplicate();
    }

    public DefaultHttp2GoAwayFrame(Http2Error http2Error, ByteBuf byteBuf) {
        this(http2Error.code(), byteBuf);
    }

    public DefaultHttp2GoAwayFrame(long j, ByteBuf byteBuf) {
        this(-1, j, byteBuf);
    }

    public DefaultHttp2GoAwayFrame(int i, long j, ByteBuf byteBuf) {
        super(byteBuf);
        this.errorCode = j;
        this.lastStreamId = i;
    }

    @Override // io.netty.buffer.DefaultByteBufHolder, io.netty.util.ReferenceCounted
    public Http2GoAwayFrame retain() {
        super.retain();
        return this;
    }

    @Override // io.netty.buffer.DefaultByteBufHolder, io.netty.util.ReferenceCounted
    public Http2GoAwayFrame touch() {
        super.touch();
        return this;
    }

    @Override // io.netty.buffer.DefaultByteBufHolder, io.netty.util.ReferenceCounted
    public Http2GoAwayFrame retain(int i) {
        super.retain(i);
        return this;
    }

    @Override // io.netty.buffer.DefaultByteBufHolder, io.netty.util.ReferenceCounted
    public Http2GoAwayFrame touch(Object obj) {
        super.touch(obj);
        return this;
    }
}
