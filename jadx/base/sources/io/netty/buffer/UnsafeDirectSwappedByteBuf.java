package io.netty.buffer;

import io.netty.util.internal.PlatformDependent;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
final class UnsafeDirectSwappedByteBuf extends AbstractUnsafeSwappedByteBuf {
    public UnsafeDirectSwappedByteBuf(AbstractByteBuf abstractByteBuf) {
        super(abstractByteBuf);
    }

    private static long addr(AbstractByteBuf abstractByteBuf, int i) {
        return abstractByteBuf.memoryAddress() + ((long) i);
    }

    @Override // io.netty.buffer.AbstractUnsafeSwappedByteBuf
    public int _getInt(AbstractByteBuf abstractByteBuf, int i) {
        return PlatformDependent.getInt(addr(abstractByteBuf, i));
    }

    @Override // io.netty.buffer.AbstractUnsafeSwappedByteBuf
    public long _getLong(AbstractByteBuf abstractByteBuf, int i) {
        return PlatformDependent.getLong(addr(abstractByteBuf, i));
    }

    @Override // io.netty.buffer.AbstractUnsafeSwappedByteBuf
    public short _getShort(AbstractByteBuf abstractByteBuf, int i) {
        return PlatformDependent.getShort(addr(abstractByteBuf, i));
    }

    @Override // io.netty.buffer.AbstractUnsafeSwappedByteBuf
    public void _setInt(AbstractByteBuf abstractByteBuf, int i, int i2) {
        PlatformDependent.putInt(addr(abstractByteBuf, i), i2);
    }

    @Override // io.netty.buffer.AbstractUnsafeSwappedByteBuf
    public void _setLong(AbstractByteBuf abstractByteBuf, int i, long j) {
        PlatformDependent.putLong(addr(abstractByteBuf, i), j);
    }

    @Override // io.netty.buffer.AbstractUnsafeSwappedByteBuf
    public void _setShort(AbstractByteBuf abstractByteBuf, int i, short s) {
        PlatformDependent.putShort(addr(abstractByteBuf, i), s);
    }
}
