package io.netty.buffer;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import io.netty.util.internal.EmptyArrays;
import io.netty.util.internal.RecyclableArrayList;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ReadOnlyBufferException;
import java.nio.channels.FileChannel;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;
import java.util.Collections;
import kotlin.UShort;
import org.apache.commons.beanutils.PropertyUtils;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
final class FixedCompositeByteBuf extends AbstractReferenceCountedByteBuf {
    private static final ByteBuf[] EMPTY = {Unpooled.EMPTY_BUFFER};
    private final ByteBufAllocator allocator;
    private final ByteBuf[] buffers;
    private final int capacity;
    private final boolean direct;
    private final int nioBufferCount;
    private final ByteOrder order;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Component extends WrappedByteBuf {
        private final int endOffset;
        private final int index;
        private final int offset;

        public Component(int i, int i2, ByteBuf byteBuf) {
            super(byteBuf);
            this.index = i;
            this.offset = i2;
            this.endOffset = byteBuf.readableBytes() + i2;
        }
    }

    public FixedCompositeByteBuf(ByteBufAllocator byteBufAllocator, ByteBuf... byteBufArr) {
        super(Integer.MAX_VALUE);
        if (byteBufArr.length == 0) {
            this.buffers = EMPTY;
            this.order = ByteOrder.BIG_ENDIAN;
            this.nioBufferCount = 1;
            this.capacity = 0;
            this.direct = Unpooled.EMPTY_BUFFER.isDirect();
        } else {
            ByteBuf byteBuf = byteBufArr[0];
            this.buffers = byteBufArr;
            int iNioBufferCount = byteBuf.nioBufferCount();
            int i = byteBuf.readableBytes();
            this.order = byteBuf.order();
            boolean z = true;
            for (int i2 = 1; i2 < byteBufArr.length; i2++) {
                ByteBuf byteBuf2 = byteBufArr[i2];
                if (byteBuf2.order() != this.order) {
                    throw new IllegalArgumentException("All ByteBufs need to have same ByteOrder");
                }
                iNioBufferCount += byteBuf2.nioBufferCount();
                i += byteBuf2.readableBytes();
                if (!byteBuf2.isDirect()) {
                    z = false;
                }
            }
            this.nioBufferCount = iNioBufferCount;
            this.capacity = i;
            this.direct = z;
        }
        setIndex(0, capacity());
        this.allocator = byteBufAllocator;
    }

    private ByteBuf buffer(int i) {
        ByteBuf byteBuf = this.buffers[i];
        return byteBuf instanceof Component ? ((Component) byteBuf).buf : byteBuf;
    }

    private Component findComponent(int i) {
        Component component;
        int i2 = 0;
        int i4 = 0;
        while (true) {
            ByteBuf[] byteBufArr = this.buffers;
            if (i2 >= byteBufArr.length) {
                throw new IllegalStateException();
            }
            ByteBuf byteBuf = byteBufArr[i2];
            if (byteBuf instanceof Component) {
                Component component2 = (Component) byteBuf;
                component = component2;
                byteBuf = component2.buf;
            } else {
                component = null;
            }
            i4 += byteBuf.readableBytes();
            if (i < i4) {
                if (component != null) {
                    return component;
                }
                Component component3 = new Component(i2, i4 - byteBuf.readableBytes(), byteBuf);
                this.buffers[i2] = component3;
                return component3;
            }
            i2++;
        }
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public byte _getByte(int i) {
        Component componentFindComponent = findComponent(i);
        return componentFindComponent.buf.getByte(i - componentFindComponent.offset);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public int _getInt(int i) {
        Component componentFindComponent = findComponent(i);
        if (i + 4 <= componentFindComponent.endOffset) {
            return componentFindComponent.buf.getInt(i - componentFindComponent.offset);
        }
        if (order() == ByteOrder.BIG_ENDIAN) {
            return (_getShort(i + 2) & UShort.MAX_VALUE) | ((_getShort(i) & UShort.MAX_VALUE) << 16);
        }
        return ((_getShort(i + 2) & UShort.MAX_VALUE) << 16) | (_getShort(i) & UShort.MAX_VALUE);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public int _getIntLE(int i) {
        Component componentFindComponent = findComponent(i);
        if (i + 4 <= componentFindComponent.endOffset) {
            return componentFindComponent.buf.getIntLE(i - componentFindComponent.offset);
        }
        if (order() == ByteOrder.BIG_ENDIAN) {
            return ((_getShortLE(i + 2) & UShort.MAX_VALUE) << 16) | (_getShortLE(i) & UShort.MAX_VALUE);
        }
        return (_getShortLE(i + 2) & UShort.MAX_VALUE) | ((_getShortLE(i) & UShort.MAX_VALUE) << 16);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public long _getLong(int i) {
        Component componentFindComponent = findComponent(i);
        return i + 8 <= componentFindComponent.endOffset ? componentFindComponent.buf.getLong(i - componentFindComponent.offset) : order() == ByteOrder.BIG_ENDIAN ? ((((long) _getInt(i)) & 4294967295L) << 32) | (((long) _getInt(i + 4)) & 4294967295L) : (((long) _getInt(i)) & 4294967295L) | ((4294967295L & ((long) _getInt(i + 4))) << 32);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public long _getLongLE(int i) {
        Component componentFindComponent = findComponent(i);
        return i + 8 <= componentFindComponent.endOffset ? componentFindComponent.buf.getLongLE(i - componentFindComponent.offset) : order() == ByteOrder.BIG_ENDIAN ? (((long) _getIntLE(i)) & 4294967295L) | ((4294967295L & ((long) _getIntLE(i + 4))) << 32) : ((((long) _getIntLE(i)) & 4294967295L) << 32) | (((long) _getIntLE(i + 4)) & 4294967295L);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public short _getShort(int i) {
        Component componentFindComponent = findComponent(i);
        if (i + 2 <= componentFindComponent.endOffset) {
            return componentFindComponent.buf.getShort(i - componentFindComponent.offset);
        }
        if (order() == ByteOrder.BIG_ENDIAN) {
            return (short) ((_getByte(i + 1) & 255) | ((_getByte(i) & 255) << 8));
        }
        return (short) (((_getByte(i + 1) & 255) << 8) | (_getByte(i) & 255));
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public short _getShortLE(int i) {
        Component componentFindComponent = findComponent(i);
        if (i + 2 <= componentFindComponent.endOffset) {
            return componentFindComponent.buf.getShortLE(i - componentFindComponent.offset);
        }
        if (order() == ByteOrder.BIG_ENDIAN) {
            return (short) (((_getByte(i + 1) & 255) << 8) | (_getByte(i) & 255));
        }
        return (short) ((_getByte(i + 1) & 255) | ((_getByte(i) & 255) << 8));
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public int _getUnsignedMedium(int i) {
        Component componentFindComponent = findComponent(i);
        if (i + 3 <= componentFindComponent.endOffset) {
            return componentFindComponent.buf.getUnsignedMedium(i - componentFindComponent.offset);
        }
        if (order() == ByteOrder.BIG_ENDIAN) {
            return (_getByte(i + 2) & 255) | ((_getShort(i) & UShort.MAX_VALUE) << 8);
        }
        return ((_getByte(i + 2) & 255) << 16) | (_getShort(i) & UShort.MAX_VALUE);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public int _getUnsignedMediumLE(int i) {
        Component componentFindComponent = findComponent(i);
        if (i + 3 <= componentFindComponent.endOffset) {
            return componentFindComponent.buf.getUnsignedMediumLE(i - componentFindComponent.offset);
        }
        if (order() == ByteOrder.BIG_ENDIAN) {
            return ((_getByte(i + 2) & 255) << 16) | (_getShortLE(i) & UShort.MAX_VALUE);
        }
        return (_getByte(i + 2) & 255) | ((_getShortLE(i) & UShort.MAX_VALUE) << 8);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public void _setByte(int i, int i2) {
        throw new ReadOnlyBufferException();
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public void _setInt(int i, int i2) {
        throw new ReadOnlyBufferException();
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public void _setIntLE(int i, int i2) {
        throw new ReadOnlyBufferException();
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public void _setLong(int i, long j) {
        throw new ReadOnlyBufferException();
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public void _setLongLE(int i, long j) {
        throw new ReadOnlyBufferException();
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public void _setMedium(int i, int i2) {
        throw new ReadOnlyBufferException();
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public void _setMediumLE(int i, int i2) {
        throw new ReadOnlyBufferException();
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public void _setShort(int i, int i2) {
        throw new ReadOnlyBufferException();
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public void _setShortLE(int i, int i2) {
        throw new ReadOnlyBufferException();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBufAllocator alloc() {
        return this.allocator;
    }

    @Override // io.netty.buffer.ByteBuf
    public byte[] array() {
        int length = this.buffers.length;
        if (length == 0) {
            return EmptyArrays.EMPTY_BYTES;
        }
        if (length == 1) {
            return buffer(0).array();
        }
        throw new UnsupportedOperationException();
    }

    @Override // io.netty.buffer.ByteBuf
    public int arrayOffset() {
        int length = this.buffers.length;
        if (length == 0) {
            return 0;
        }
        if (length == 1) {
            return buffer(0).arrayOffset();
        }
        throw new UnsupportedOperationException();
    }

    @Override // io.netty.buffer.ByteBuf
    public int capacity() {
        return this.capacity;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf copy(int i, int i2) {
        checkIndex(i, i2);
        ByteBuf byteBufBuffer = alloc().buffer(i2);
        try {
            byteBufBuffer.writeBytes(this, i, i2);
            return byteBufBuffer;
        } catch (Throwable th) {
            byteBufBuffer.release();
            throw th;
        }
    }

    @Override // io.netty.buffer.AbstractReferenceCountedByteBuf
    public void deallocate() {
        for (int i = 0; i < this.buffers.length; i++) {
            buffer(i).release();
        }
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf discardReadBytes() {
        throw new ReadOnlyBufferException();
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public byte getByte(int i) {
        return _getByte(i);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i, byte[] bArr, int i2, int i4) {
        checkDstIndex(i, i4, i2, bArr.length);
        if (i4 != 0) {
            Component componentFindComponent = findComponent(i);
            int i5 = componentFindComponent.index;
            int i6 = componentFindComponent.offset;
            ByteBuf byteBufBuffer = componentFindComponent.buf;
            while (true) {
                int i7 = i - i6;
                int iMin = Math.min(i4, byteBufBuffer.readableBytes() - i7);
                byteBufBuffer.getBytes(i7, bArr, i2, iMin);
                i += iMin;
                i2 += iMin;
                i4 -= iMin;
                i6 += byteBufBuffer.readableBytes();
                if (i4 <= 0) {
                    break;
                }
                i5++;
                byteBufBuffer = buffer(i5);
            }
        }
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean hasArray() {
        int length = this.buffers.length;
        if (length == 0) {
            return true;
        }
        if (length != 1) {
            return false;
        }
        return buffer(0).hasArray();
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean hasMemoryAddress() {
        int length = this.buffers.length;
        if (length == 0) {
            return Unpooled.EMPTY_BUFFER.hasMemoryAddress();
        }
        if (length != 1) {
            return false;
        }
        return buffer(0).hasMemoryAddress();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuffer internalNioBuffer(int i, int i2) {
        if (this.buffers.length == 1) {
            return buffer(0).internalNioBuffer(i, i2);
        }
        throw new UnsupportedOperationException();
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean isDirect() {
        return this.direct;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public boolean isWritable() {
        return false;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int maxCapacity() {
        return this.capacity;
    }

    @Override // io.netty.buffer.ByteBuf
    public long memoryAddress() {
        int length = this.buffers.length;
        if (length == 0) {
            return Unpooled.EMPTY_BUFFER.memoryAddress();
        }
        if (length == 1) {
            return buffer(0).memoryAddress();
        }
        throw new UnsupportedOperationException();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuffer nioBuffer(int i, int i2) {
        checkIndex(i, i2);
        if (this.buffers.length == 1) {
            ByteBuf byteBufBuffer = buffer(0);
            if (byteBufBuffer.nioBufferCount() == 1) {
                return byteBufBuffer.nioBuffer(i, i2);
            }
        }
        ByteBuffer byteBufferOrder = ByteBuffer.allocate(i2).order(order());
        for (ByteBuffer byteBuffer : nioBuffers(i, i2)) {
            byteBufferOrder.put(byteBuffer);
        }
        byteBufferOrder.flip();
        return byteBufferOrder;
    }

    @Override // io.netty.buffer.ByteBuf
    public int nioBufferCount() {
        return this.nioBufferCount;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuffer[] nioBuffers(int i, int i2) {
        checkIndex(i, i2);
        if (i2 == 0) {
            return EmptyArrays.EMPTY_BYTE_BUFFERS;
        }
        RecyclableArrayList recyclableArrayListNewInstance = RecyclableArrayList.newInstance(this.buffers.length);
        try {
            Component componentFindComponent = findComponent(i);
            int i4 = componentFindComponent.index;
            int i5 = componentFindComponent.offset;
            ByteBuf byteBufBuffer = componentFindComponent.buf;
            while (true) {
                int i6 = i - i5;
                int iMin = Math.min(i2, byteBufBuffer.readableBytes() - i6);
                int iNioBufferCount = byteBufBuffer.nioBufferCount();
                if (iNioBufferCount == 0) {
                    throw new UnsupportedOperationException();
                }
                if (iNioBufferCount != 1) {
                    Collections.addAll(recyclableArrayListNewInstance, byteBufBuffer.nioBuffers(i6, iMin));
                } else {
                    recyclableArrayListNewInstance.add(byteBufBuffer.nioBuffer(i6, iMin));
                }
                i += iMin;
                i2 -= iMin;
                i5 += byteBufBuffer.readableBytes();
                if (i2 <= 0) {
                    ByteBuffer[] byteBufferArr = (ByteBuffer[]) recyclableArrayListNewInstance.toArray(new ByteBuffer[0]);
                    recyclableArrayListNewInstance.recycle();
                    return byteBufferArr;
                }
                i4++;
                byteBufBuffer = buffer(i4);
            }
        } catch (Throwable th) {
            recyclableArrayListNewInstance.recycle();
            throw th;
        }
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteOrder order() {
        return this.order;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setByte(int i, int i2) {
        throw new ReadOnlyBufferException();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i, ByteBuf byteBuf, int i2, int i4) {
        throw new ReadOnlyBufferException();
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setInt(int i, int i2) {
        throw new ReadOnlyBufferException();
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setLong(int i, long j) {
        throw new ReadOnlyBufferException();
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setMedium(int i, int i2) {
        throw new ReadOnlyBufferException();
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setShort(int i, int i2) {
        throw new ReadOnlyBufferException();
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public String toString() {
        return AbstractC0000a.m13j(AbstractC0541b.m781w(AbstractC2322a.m1614d(1, 0, super.toString()), ", components="), this.buffers.length, PropertyUtils.MAPPED_DELIM2);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf unwrap() {
        return null;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf capacity(int i) {
        throw new ReadOnlyBufferException();
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public boolean isWritable(int i) {
        return false;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i, byte[] bArr, int i2, int i4) {
        throw new ReadOnlyBufferException();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i, ByteBuffer byteBuffer) {
        throw new ReadOnlyBufferException();
    }

    @Override // io.netty.buffer.ByteBuf
    public int setBytes(int i, InputStream inputStream, int i2) {
        throw new ReadOnlyBufferException();
    }

    @Override // io.netty.buffer.ByteBuf
    public int setBytes(int i, ScatteringByteChannel scatteringByteChannel, int i2) {
        throw new ReadOnlyBufferException();
    }

    @Override // io.netty.buffer.ByteBuf
    public int setBytes(int i, FileChannel fileChannel, long j, int i2) {
        throw new ReadOnlyBufferException();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i, ByteBuffer byteBuffer) {
        int iLimit = byteBuffer.limit();
        int iRemaining = byteBuffer.remaining();
        checkIndex(i, iRemaining);
        if (iRemaining == 0) {
            return this;
        }
        try {
            Component componentFindComponent = findComponent(i);
            int i2 = componentFindComponent.index;
            int i4 = componentFindComponent.offset;
            ByteBuf byteBufBuffer = componentFindComponent.buf;
            while (true) {
                int i5 = i - i4;
                int iMin = Math.min(iRemaining, byteBufBuffer.readableBytes() - i5);
                byteBuffer.limit(byteBuffer.position() + iMin);
                byteBufBuffer.getBytes(i5, byteBuffer);
                i += iMin;
                iRemaining -= iMin;
                i4 += byteBufBuffer.readableBytes();
                if (iRemaining <= 0) {
                    return this;
                }
                i2++;
                byteBufBuffer = buffer(i2);
            }
        } finally {
            byteBuffer.limit(iLimit);
        }
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i, ByteBuf byteBuf, int i2, int i4) {
        checkDstIndex(i, i4, i2, byteBuf.capacity());
        if (i4 != 0) {
            Component componentFindComponent = findComponent(i);
            int i5 = componentFindComponent.index;
            int i6 = componentFindComponent.offset;
            ByteBuf byteBufBuffer = componentFindComponent.buf;
            while (true) {
                int i7 = i - i6;
                int iMin = Math.min(i4, byteBufBuffer.readableBytes() - i7);
                byteBufBuffer.getBytes(i7, byteBuf, i2, iMin);
                i += iMin;
                i2 += iMin;
                i4 -= iMin;
                i6 += byteBufBuffer.readableBytes();
                if (i4 <= 0) {
                    break;
                }
                i5++;
                byteBufBuffer = buffer(i5);
            }
        }
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public int getBytes(int i, GatheringByteChannel gatheringByteChannel, int i2) throws IOException {
        if (nioBufferCount() == 1) {
            return gatheringByteChannel.write(internalNioBuffer(i, i2));
        }
        long jWrite = gatheringByteChannel.write(nioBuffers(i, i2));
        if (jWrite > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) jWrite;
    }

    @Override // io.netty.buffer.ByteBuf
    public int getBytes(int i, FileChannel fileChannel, long j, int i2) {
        if (nioBufferCount() == 1) {
            return fileChannel.write(internalNioBuffer(i, i2), j);
        }
        long jWrite = 0;
        for (ByteBuffer byteBuffer : nioBuffers(i, i2)) {
            jWrite += (long) fileChannel.write(byteBuffer, j + jWrite);
        }
        if (jWrite > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) jWrite;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i, OutputStream outputStream, int i2) {
        checkIndex(i, i2);
        if (i2 != 0) {
            Component componentFindComponent = findComponent(i);
            int i4 = componentFindComponent.index;
            int i5 = componentFindComponent.offset;
            ByteBuf byteBufBuffer = componentFindComponent.buf;
            while (true) {
                int i6 = i - i5;
                int iMin = Math.min(i2, byteBufBuffer.readableBytes() - i6);
                byteBufBuffer.getBytes(i6, outputStream, iMin);
                i += iMin;
                i2 -= iMin;
                i5 += byteBufBuffer.readableBytes();
                if (i2 <= 0) {
                    break;
                }
                i4++;
                byteBufBuffer = buffer(i4);
            }
        }
        return this;
    }
}
