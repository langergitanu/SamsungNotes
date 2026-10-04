package io.grpc.netty;

import com.google.common.base.Preconditions;
import io.grpc.internal.AbstractReadableBuffer;
import io.netty.buffer.ByteBuf;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
class NettyReadableBuffer extends AbstractReadableBuffer {
    private final ByteBuf buffer;
    private boolean closed;

    public NettyReadableBuffer(ByteBuf byteBuf) {
        this.buffer = (ByteBuf) Preconditions.checkNotNull(byteBuf, "buffer");
    }

    @Override // io.grpc.internal.AbstractReadableBuffer, io.grpc.internal.ReadableBuffer
    public byte[] array() {
        return this.buffer.array();
    }

    @Override // io.grpc.internal.AbstractReadableBuffer, io.grpc.internal.ReadableBuffer
    public int arrayOffset() {
        return this.buffer.readerIndex() + this.buffer.arrayOffset();
    }

    public ByteBuf buffer() {
        return this.buffer;
    }

    @Override // io.grpc.internal.AbstractReadableBuffer, io.grpc.internal.ReadableBuffer
    public boolean byteBufferSupported() {
        return this.buffer.nioBufferCount() > 0;
    }

    @Override // io.grpc.internal.AbstractReadableBuffer, io.grpc.internal.ReadableBuffer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.closed) {
            return;
        }
        this.closed = true;
        this.buffer.release();
    }

    @Override // io.grpc.internal.AbstractReadableBuffer, io.grpc.internal.ReadableBuffer
    public ByteBuffer getByteBuffer() {
        return this.buffer.nioBufferCount() == 1 ? this.buffer.nioBuffer() : this.buffer.nioBuffers()[0];
    }

    @Override // io.grpc.internal.AbstractReadableBuffer, io.grpc.internal.ReadableBuffer
    public boolean hasArray() {
        return this.buffer.hasArray();
    }

    @Override // io.grpc.internal.AbstractReadableBuffer, io.grpc.internal.ReadableBuffer
    public void mark() {
        this.buffer.markReaderIndex();
    }

    @Override // io.grpc.internal.AbstractReadableBuffer, io.grpc.internal.ReadableBuffer
    public boolean markSupported() {
        return true;
    }

    @Override // io.grpc.internal.ReadableBuffer
    public int readUnsignedByte() {
        return this.buffer.readUnsignedByte();
    }

    @Override // io.grpc.internal.ReadableBuffer
    public int readableBytes() {
        return this.buffer.readableBytes();
    }

    @Override // io.grpc.internal.AbstractReadableBuffer, io.grpc.internal.ReadableBuffer
    public void reset() {
        this.buffer.resetReaderIndex();
    }

    @Override // io.grpc.internal.ReadableBuffer
    public void skipBytes(int i) {
        this.buffer.skipBytes(i);
    }

    @Override // io.grpc.internal.ReadableBuffer
    public void readBytes(byte[] bArr, int i, int i2) {
        this.buffer.readBytes(bArr, i, i2);
    }

    @Override // io.grpc.internal.ReadableBuffer
    public void readBytes(ByteBuffer byteBuffer) {
        this.buffer.readBytes(byteBuffer);
    }

    @Override // io.grpc.internal.ReadableBuffer
    public void readBytes(OutputStream outputStream, int i) {
        try {
            this.buffer.readBytes(outputStream, i);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // io.grpc.internal.ReadableBuffer
    public NettyReadableBuffer readBytes(int i) {
        return new NettyReadableBuffer(this.buffer.readRetainedSlice(i));
    }
}
