package io.netty.buffer;

import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import org.apache.commons.beanutils.PropertyUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class DefaultByteBufHolder implements ByteBufHolder {
    private final ByteBuf data;

    public DefaultByteBufHolder(ByteBuf byteBuf) {
        this.data = (ByteBuf) ObjectUtil.checkNotNull(byteBuf, "data");
    }

    @Override // io.netty.buffer.ByteBufHolder
    public ByteBuf content() {
        return ByteBufUtil.ensureAccessible(this.data);
    }

    public final String contentToString() {
        return this.data.toString();
    }

    @Override // io.netty.buffer.ByteBufHolder
    public ByteBufHolder copy() {
        return replace(this.data.copy());
    }

    @Override // io.netty.buffer.ByteBufHolder
    public ByteBufHolder duplicate() {
        return replace(this.data.duplicate());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.data.equals(((DefaultByteBufHolder) obj).data);
    }

    public int hashCode() {
        return this.data.hashCode();
    }

    @Override // io.netty.util.ReferenceCounted
    public int refCnt() {
        return this.data.refCnt();
    }

    @Override // io.netty.util.ReferenceCounted
    public boolean release() {
        return this.data.release();
    }

    @Override // io.netty.buffer.ByteBufHolder
    public ByteBufHolder replace(ByteBuf byteBuf) {
        return new DefaultByteBufHolder(byteBuf);
    }

    @Override // io.netty.buffer.ByteBufHolder
    public ByteBufHolder retainedDuplicate() {
        return replace(this.data.retainedDuplicate());
    }

    public String toString() {
        return StringUtil.simpleClassName(this) + PropertyUtils.MAPPED_DELIM + contentToString() + PropertyUtils.MAPPED_DELIM2;
    }

    @Override // io.netty.util.ReferenceCounted
    public boolean release(int i) {
        return this.data.release(i);
    }

    @Override // io.netty.util.ReferenceCounted
    public ByteBufHolder retain() {
        this.data.retain();
        return this;
    }

    @Override // io.netty.util.ReferenceCounted
    public ByteBufHolder touch() {
        this.data.touch();
        return this;
    }

    @Override // io.netty.util.ReferenceCounted
    public ByteBufHolder retain(int i) {
        this.data.retain(i);
        return this;
    }

    @Override // io.netty.util.ReferenceCounted
    public ByteBufHolder touch(Object obj) {
        this.data.touch(obj);
        return this;
    }
}
