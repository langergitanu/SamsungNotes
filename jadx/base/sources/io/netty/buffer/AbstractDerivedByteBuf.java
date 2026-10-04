package io.netty.buffer;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Deprecated
public abstract class AbstractDerivedByteBuf extends AbstractByteBuf {
    public AbstractDerivedByteBuf(int i) {
        super(i);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuffer internalNioBuffer(int i, int i2) {
        return nioBuffer(i, i2);
    }

    @Override // io.netty.buffer.ByteBuf
    public final boolean isAccessible() {
        return isAccessible0();
    }

    public boolean isAccessible0() {
        return unwrap().isAccessible();
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean isContiguous() {
        return unwrap().isContiguous();
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public boolean isReadOnly() {
        return unwrap().isReadOnly();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuffer nioBuffer(int i, int i2) {
        return unwrap().nioBuffer(i, i2);
    }

    @Override // io.netty.util.ReferenceCounted
    public final int refCnt() {
        return refCnt0();
    }

    public int refCnt0() {
        return unwrap().refCnt();
    }

    @Override // io.netty.util.ReferenceCounted
    public final boolean release() {
        return release0();
    }

    public boolean release0() {
        return unwrap().release();
    }

    public ByteBuf retain0() {
        unwrap().retain();
        return this;
    }

    public ByteBuf touch0() {
        unwrap().touch();
        return this;
    }

    @Override // io.netty.util.ReferenceCounted
    public final boolean release(int i) {
        return release0(i);
    }

    public boolean release0(int i) {
        return unwrap().release(i);
    }

    public ByteBuf retain0(int i) {
        unwrap().retain(i);
        return this;
    }

    public ByteBuf touch0(Object obj) {
        unwrap().touch(obj);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf, io.netty.util.ReferenceCounted
    public final ByteBuf retain() {
        return retain0();
    }

    @Override // io.netty.buffer.ByteBuf, io.netty.util.ReferenceCounted
    public final ByteBuf touch() {
        return touch0();
    }

    @Override // io.netty.buffer.ByteBuf, io.netty.util.ReferenceCounted
    public final ByteBuf retain(int i) {
        return retain0(i);
    }

    @Override // io.netty.buffer.ByteBuf, io.netty.util.ReferenceCounted
    public final ByteBuf touch(Object obj) {
        return touch0(obj);
    }
}
