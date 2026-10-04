package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import org.apache.commons.beanutils.PropertyUtils;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final class DefaultHttp2DataFrame extends AbstractHttp2StreamFrame implements Http2DataFrame {
    private final ByteBuf content;
    private final boolean endStream;
    private final int initialFlowControlledBytes;
    private final int padding;

    public DefaultHttp2DataFrame(ByteBuf byteBuf) {
        this(byteBuf, false);
    }

    @Override // io.netty.handler.codec.http2.Http2DataFrame, io.netty.buffer.ByteBufHolder
    public ByteBuf content() {
        return ByteBufUtil.ensureAccessible(this.content);
    }

    @Override // io.netty.handler.codec.http2.AbstractHttp2StreamFrame
    public boolean equals(Object obj) {
        if (!(obj instanceof DefaultHttp2DataFrame)) {
            return false;
        }
        DefaultHttp2DataFrame defaultHttp2DataFrame = (DefaultHttp2DataFrame) obj;
        return super.equals(defaultHttp2DataFrame) && this.content.equals(defaultHttp2DataFrame.content()) && this.endStream == defaultHttp2DataFrame.endStream && this.padding == defaultHttp2DataFrame.padding;
    }

    @Override // io.netty.handler.codec.http2.AbstractHttp2StreamFrame
    public int hashCode() {
        return ((((this.content.hashCode() + (super.hashCode() * 31)) * 31) + (!this.endStream ? 1 : 0)) * 31) + this.padding;
    }

    @Override // io.netty.handler.codec.http2.Http2DataFrame
    public int initialFlowControlledBytes() {
        return this.initialFlowControlledBytes;
    }

    @Override // io.netty.handler.codec.http2.Http2DataFrame
    public boolean isEndStream() {
        return this.endStream;
    }

    @Override // io.netty.handler.codec.http2.Http2Frame
    public String name() {
        return "DATA";
    }

    @Override // io.netty.handler.codec.http2.Http2DataFrame
    public int padding() {
        return this.padding;
    }

    @Override // io.netty.util.ReferenceCounted
    public int refCnt() {
        return this.content.refCnt();
    }

    @Override // io.netty.util.ReferenceCounted
    public boolean release() {
        return this.content.release();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(StringUtil.simpleClassName(this));
        sb.append("(stream=");
        sb.append(stream());
        sb.append(", content=");
        sb.append(this.content);
        sb.append(", endStream=");
        sb.append(this.endStream);
        sb.append(", padding=");
        return AbstractC0000a.m13j(sb, this.padding, PropertyUtils.MAPPED_DELIM2);
    }

    public DefaultHttp2DataFrame(boolean z) {
        this(Unpooled.EMPTY_BUFFER, z);
    }

    @Override // io.netty.util.ReferenceCounted
    public boolean release(int i) {
        return this.content.release(i);
    }

    public DefaultHttp2DataFrame(ByteBuf byteBuf, boolean z) {
        this(byteBuf, z, 0);
    }

    @Override // io.netty.handler.codec.http2.Http2DataFrame, io.netty.buffer.ByteBufHolder
    public DefaultHttp2DataFrame copy() {
        return replace(content().copy());
    }

    @Override // io.netty.handler.codec.http2.Http2DataFrame, io.netty.buffer.ByteBufHolder
    public DefaultHttp2DataFrame duplicate() {
        return replace(content().duplicate());
    }

    @Override // io.netty.handler.codec.http2.Http2DataFrame, io.netty.buffer.ByteBufHolder
    public DefaultHttp2DataFrame replace(ByteBuf byteBuf) {
        return new DefaultHttp2DataFrame(byteBuf, this.endStream, this.padding);
    }

    @Override // io.netty.handler.codec.http2.Http2DataFrame, io.netty.buffer.ByteBufHolder
    public DefaultHttp2DataFrame retainedDuplicate() {
        return replace(content().retainedDuplicate());
    }

    @Override // io.netty.handler.codec.http2.AbstractHttp2StreamFrame, io.netty.handler.codec.http2.Http2StreamFrame
    public DefaultHttp2DataFrame stream(Http2FrameStream http2FrameStream) {
        super.stream(http2FrameStream);
        return this;
    }

    public DefaultHttp2DataFrame(ByteBuf byteBuf, boolean z, int i) {
        this.content = (ByteBuf) ObjectUtil.checkNotNull(byteBuf, "content");
        this.endStream = z;
        Http2CodecUtil.verifyPadding(i);
        this.padding = i;
        if (((long) content().readableBytes()) + ((long) i) <= 2147483647L) {
            this.initialFlowControlledBytes = content().readableBytes() + i;
            return;
        }
        throw new IllegalArgumentException("content + padding must be <= Integer.MAX_VALUE");
    }

    @Override // io.netty.util.ReferenceCounted
    public DefaultHttp2DataFrame retain() {
        this.content.retain();
        return this;
    }

    @Override // io.netty.util.ReferenceCounted
    public DefaultHttp2DataFrame touch() {
        this.content.touch();
        return this;
    }

    @Override // io.netty.util.ReferenceCounted
    public DefaultHttp2DataFrame retain(int i) {
        this.content.retain(i);
        return this;
    }

    @Override // io.netty.util.ReferenceCounted
    public DefaultHttp2DataFrame touch(Object obj) {
        this.content.touch(obj);
        return this;
    }
}
