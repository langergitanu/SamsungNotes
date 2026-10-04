package io.netty.buffer;

import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import java.nio.ByteBuffer;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
final class ReadOnlyUnsafeDirectByteBuf extends ReadOnlyByteBufferBuf {
    private final long memoryAddress;

    public ReadOnlyUnsafeDirectByteBuf(ByteBufAllocator byteBufAllocator, ByteBuffer byteBuffer) {
        super(byteBufAllocator, byteBuffer);
        this.memoryAddress = PlatformDependent.directBufferAddress(this.buffer);
    }

    private long addr(int i) {
        return this.memoryAddress + ((long) i);
    }

    @Override // io.netty.buffer.ReadOnlyByteBufferBuf, io.netty.buffer.AbstractByteBuf
    public byte _getByte(int i) {
        return UnsafeByteBufUtil.getByte(addr(i));
    }

    @Override // io.netty.buffer.ReadOnlyByteBufferBuf, io.netty.buffer.AbstractByteBuf
    public int _getInt(int i) {
        return UnsafeByteBufUtil.getInt(addr(i));
    }

    @Override // io.netty.buffer.ReadOnlyByteBufferBuf, io.netty.buffer.AbstractByteBuf
    public long _getLong(int i) {
        return UnsafeByteBufUtil.getLong(addr(i));
    }

    @Override // io.netty.buffer.ReadOnlyByteBufferBuf, io.netty.buffer.AbstractByteBuf
    public short _getShort(int i) {
        return UnsafeByteBufUtil.getShort(addr(i));
    }

    @Override // io.netty.buffer.ReadOnlyByteBufferBuf, io.netty.buffer.AbstractByteBuf
    public int _getUnsignedMedium(int i) {
        return UnsafeByteBufUtil.getUnsignedMedium(addr(i));
    }

    @Override // io.netty.buffer.ReadOnlyByteBufferBuf, io.netty.buffer.ByteBuf
    public ByteBuf copy(int i, int i2) {
        checkIndex(i, i2);
        ByteBuf byteBufDirectBuffer = alloc().directBuffer(i2, maxCapacity());
        if (i2 != 0) {
            if (byteBufDirectBuffer.hasMemoryAddress()) {
                PlatformDependent.copyMemory(addr(i), byteBufDirectBuffer.memoryAddress(), i2);
                byteBufDirectBuffer.setIndex(0, i2);
                return byteBufDirectBuffer;
            }
            byteBufDirectBuffer.writeBytes(this, i, i2);
        }
        return byteBufDirectBuffer;
    }

    @Override // io.netty.buffer.ReadOnlyByteBufferBuf, io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i, ByteBuf byteBuf, int i2, int i4) {
        checkIndex(i, i4);
        ObjectUtil.checkNotNull(byteBuf, "dst");
        if (i2 < 0 || i2 > byteBuf.capacity() - i4) {
            throw new IndexOutOfBoundsException(AbstractC0000a.m11h(i2, "dstIndex: "));
        }
        if (byteBuf.hasMemoryAddress()) {
            PlatformDependent.copyMemory(addr(i), ((long) i2) + byteBuf.memoryAddress(), i4);
            return this;
        }
        if (byteBuf.hasArray()) {
            PlatformDependent.copyMemory(addr(i), byteBuf.array(), byteBuf.arrayOffset() + i2, i4);
            return this;
        }
        byteBuf.setBytes(i2, this, i, i4);
        return this;
    }

    @Override // io.netty.buffer.ReadOnlyByteBufferBuf, io.netty.buffer.ByteBuf
    public boolean hasMemoryAddress() {
        return true;
    }

    @Override // io.netty.buffer.ReadOnlyByteBufferBuf, io.netty.buffer.ByteBuf
    public long memoryAddress() {
        return this.memoryAddress;
    }

    @Override // io.netty.buffer.ReadOnlyByteBufferBuf, io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i, byte[] bArr, int i2, int i4) {
        checkIndex(i, i4);
        ObjectUtil.checkNotNull(bArr, "dst");
        if (i2 < 0 || i2 > bArr.length - i4) {
            throw new IndexOutOfBoundsException(String.format("dstIndex: %d, length: %d (expected: range(0, %d))", Integer.valueOf(i2), Integer.valueOf(i4), Integer.valueOf(bArr.length)));
        }
        if (i4 != 0) {
            PlatformDependent.copyMemory(addr(i), bArr, i2, i4);
        }
        return this;
    }
}
