package io.netty.handler.codec.http;

import io.netty.buffer.ByteBuf;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import org.apache.commons.beanutils.PropertyUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class DefaultHttpContent extends DefaultHttpObject implements HttpContent {
    private final ByteBuf content;

    public DefaultHttpContent(ByteBuf byteBuf) {
        this.content = (ByteBuf) ObjectUtil.checkNotNull(byteBuf, "content");
    }

    @Override // io.netty.buffer.ByteBufHolder
    public ByteBuf content() {
        return this.content;
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
        return StringUtil.simpleClassName(this) + "(data: " + content() + ", decoderResult: " + decoderResult() + PropertyUtils.MAPPED_DELIM2;
    }

    @Override // io.netty.buffer.ByteBufHolder
    public HttpContent copy() {
        return replace(this.content.copy());
    }

    @Override // io.netty.buffer.ByteBufHolder
    public HttpContent duplicate() {
        return replace(this.content.duplicate());
    }

    @Override // io.netty.util.ReferenceCounted
    public boolean release(int i) {
        return this.content.release(i);
    }

    @Override // io.netty.buffer.ByteBufHolder
    public HttpContent replace(ByteBuf byteBuf) {
        return new DefaultHttpContent(byteBuf);
    }

    @Override // io.netty.buffer.ByteBufHolder
    public HttpContent retainedDuplicate() {
        return replace(this.content.retainedDuplicate());
    }

    @Override // io.netty.util.ReferenceCounted
    public HttpContent retain() {
        this.content.retain();
        return this;
    }

    @Override // io.netty.util.ReferenceCounted
    public HttpContent touch() {
        this.content.touch();
        return this;
    }

    @Override // io.netty.util.ReferenceCounted
    public HttpContent retain(int i) {
        this.content.retain(i);
        return this;
    }

    @Override // io.netty.util.ReferenceCounted
    public HttpContent touch(Object obj) {
        this.content.touch(obj);
        return this;
    }
}
