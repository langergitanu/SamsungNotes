package io.netty.channel.unix;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelOutboundBuffer;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final class IovArray implements ChannelOutboundBuffer.MessageProcessor {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int ADDRESS_SIZE;
    public static final int IOV_SIZE;
    private static final int MAX_CAPACITY;
    private int count;
    private long maxBytes;
    private final ByteBuf memory;
    private final long memoryAddress;
    private long size;

    static {
        int iAddressSize = Buffer.addressSize();
        ADDRESS_SIZE = iAddressSize;
        int i = iAddressSize * 2;
        IOV_SIZE = i;
        MAX_CAPACITY = Limits.IOV_MAX * i;
    }

    public IovArray() {
        this(Unpooled.wrappedBuffer(Buffer.allocateDirectWithNativeOrder(MAX_CAPACITY)).setIndex(0, 0));
    }

    private static int idx(int i) {
        return IOV_SIZE * i;
    }

    @Deprecated
    public boolean add(ByteBuf byteBuf) {
        return add(byteBuf, byteBuf.readerIndex(), byteBuf.readableBytes());
    }

    public void clear() {
        this.count = 0;
        this.size = 0L;
    }

    public int count() {
        return this.count;
    }

    public void maxBytes(long j) {
        this.maxBytes = Math.min(Limits.SSIZE_MAX, ObjectUtil.checkPositive(j, "maxBytes"));
    }

    public long memoryAddress(int i) {
        return this.memoryAddress + ((long) idx(i));
    }

    @Override // io.netty.channel.ChannelOutboundBuffer.MessageProcessor
    public boolean processMessage(Object obj) {
        if (!(obj instanceof ByteBuf)) {
            return false;
        }
        ByteBuf byteBuf = (ByteBuf) obj;
        return add(byteBuf, byteBuf.readerIndex(), byteBuf.readableBytes());
    }

    public void release() {
        this.memory.release();
    }

    public long size() {
        return this.size;
    }

    public IovArray(ByteBuf byteBuf) {
        ByteBuf byteBufOrder;
        this.maxBytes = Limits.SSIZE_MAX;
        if (PlatformDependent.hasUnsafe()) {
            byteBufOrder = byteBuf;
        } else {
            byteBufOrder = byteBuf.order(PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        }
        this.memory = byteBufOrder;
        if (byteBuf.hasMemoryAddress()) {
            this.memoryAddress = byteBuf.memoryAddress();
        } else {
            this.memoryAddress = Buffer.memoryAddress(byteBuf.internalNioBuffer(0, byteBuf.capacity()));
        }
    }

    public boolean add(ByteBuf byteBuf, int i, int i2) {
        IovArray iovArray;
        if (this.count == Limits.IOV_MAX) {
            return false;
        }
        if (byteBuf.nioBufferCount() == 1) {
            if (i2 == 0) {
                return true;
            }
            if (byteBuf.hasMemoryAddress()) {
                return add(this.memoryAddress, byteBuf.memoryAddress() + ((long) i), i2);
            }
            ByteBuffer byteBufferInternalNioBuffer = byteBuf.internalNioBuffer(i, i2);
            return add(this.memoryAddress, ((long) byteBufferInternalNioBuffer.position()) + Buffer.memoryAddress(byteBufferInternalNioBuffer), i2);
        }
        IovArray iovArray2 = this;
        ByteBuffer[] byteBufferArrNioBuffers = byteBuf.nioBuffers(i, i2);
        int length = byteBufferArrNioBuffers.length;
        int i4 = 0;
        while (i4 < length) {
            ByteBuffer byteBuffer = byteBufferArrNioBuffers[i4];
            int iRemaining = byteBuffer.remaining();
            if (iRemaining != 0) {
                long j = iovArray2.memoryAddress;
                long jMemoryAddress = Buffer.memoryAddress(byteBuffer) + ((long) byteBuffer.position());
                iovArray = iovArray2;
                if (!iovArray.add(j, jMemoryAddress, iRemaining) || iovArray.count == Limits.IOV_MAX) {
                    return false;
                }
            } else {
                iovArray = iovArray2;
            }
            i4++;
            iovArray2 = iovArray;
        }
        return true;
    }

    public long maxBytes() {
        return this.maxBytes;
    }

    private boolean add(long j, long j2, int i) {
        long j3 = i;
        if (this.maxBytes - j3 < this.size && this.count > 0) {
            return false;
        }
        int iCapacity = this.memory.capacity();
        int i2 = this.count;
        if (iCapacity < (i2 + 1) * IOV_SIZE) {
            return false;
        }
        int iIdx = idx(i2);
        int i4 = ADDRESS_SIZE;
        int i5 = iIdx + i4;
        this.size += j3;
        this.count++;
        if (i4 == 8) {
            if (PlatformDependent.hasUnsafe()) {
                PlatformDependent.putLong(((long) iIdx) + j, j2);
                PlatformDependent.putLong(((long) i5) + j, j3);
            } else {
                this.memory.setLong(iIdx, j2);
                this.memory.setLong(i5, j3);
            }
        } else if (PlatformDependent.hasUnsafe()) {
            PlatformDependent.putInt(((long) iIdx) + j, (int) j2);
            PlatformDependent.putInt(((long) i5) + j, i);
        } else {
            this.memory.setInt(iIdx, (int) j2);
            this.memory.setInt(i5, i);
        }
        return true;
    }
}
