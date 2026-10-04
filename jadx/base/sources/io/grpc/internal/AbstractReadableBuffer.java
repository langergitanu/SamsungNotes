package io.grpc.internal;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public abstract class AbstractReadableBuffer implements ReadableBuffer {
    @Override // io.grpc.internal.ReadableBuffer
    public byte[] array() {
        throw new UnsupportedOperationException();
    }

    @Override // io.grpc.internal.ReadableBuffer
    public int arrayOffset() {
        throw new UnsupportedOperationException();
    }

    @Override // io.grpc.internal.ReadableBuffer
    public boolean byteBufferSupported() {
        return false;
    }

    public final void checkReadable(int i) {
        if (readableBytes() < i) {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override // io.grpc.internal.ReadableBuffer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // io.grpc.internal.ReadableBuffer
    public ByteBuffer getByteBuffer() {
        throw new UnsupportedOperationException();
    }

    @Override // io.grpc.internal.ReadableBuffer
    public boolean hasArray() {
        return false;
    }

    @Override // io.grpc.internal.ReadableBuffer
    public void mark() {
    }

    @Override // io.grpc.internal.ReadableBuffer
    public boolean markSupported() {
        return false;
    }

    @Override // io.grpc.internal.ReadableBuffer
    public final int readInt() {
        checkReadable(4);
        return (readUnsignedByte() << 24) | (readUnsignedByte() << 16) | (readUnsignedByte() << 8) | readUnsignedByte();
    }

    @Override // io.grpc.internal.ReadableBuffer
    public void reset() {
        throw new UnsupportedOperationException();
    }
}
