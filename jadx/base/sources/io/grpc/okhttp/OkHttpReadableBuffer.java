package io.grpc.okhttp;

import androidx.appcompat.widget.AbstractC0541b;
import io.grpc.internal.AbstractReadableBuffer;
import io.grpc.internal.ReadableBuffer;
import java.io.EOFException;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import okio.Buffer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
class OkHttpReadableBuffer extends AbstractReadableBuffer {
    private final Buffer buffer;

    public OkHttpReadableBuffer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override // io.grpc.internal.AbstractReadableBuffer, io.grpc.internal.ReadableBuffer, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws EOFException {
        this.buffer.clear();
    }

    @Override // io.grpc.internal.ReadableBuffer
    public void readBytes(byte[] bArr, int i, int i2) {
        while (i2 > 0) {
            int i4 = this.buffer.read(bArr, i, i2);
            if (i4 == -1) {
                throw new IndexOutOfBoundsException(AbstractC0541b.m767i(i2, "EOF trying to read ", " bytes"));
            }
            i2 -= i4;
            i += i4;
        }
    }

    @Override // io.grpc.internal.ReadableBuffer
    public int readUnsignedByte() {
        try {
            fakeEofExceptionMethod();
            return this.buffer.readByte() & 255;
        } catch (EOFException e) {
            throw new IndexOutOfBoundsException(e.getMessage());
        }
    }

    @Override // io.grpc.internal.ReadableBuffer
    public int readableBytes() {
        return (int) this.buffer.size();
    }

    @Override // io.grpc.internal.ReadableBuffer
    public void skipBytes(int i) {
        try {
            this.buffer.skip(i);
        } catch (EOFException e) {
            throw new IndexOutOfBoundsException(e.getMessage());
        }
    }

    @Override // io.grpc.internal.ReadableBuffer
    public void readBytes(ByteBuffer byteBuffer) {
        throw new UnsupportedOperationException();
    }

    @Override // io.grpc.internal.ReadableBuffer
    public void readBytes(OutputStream outputStream, int i) throws IOException {
        this.buffer.writeTo(outputStream, i);
    }

    @Override // io.grpc.internal.ReadableBuffer
    public ReadableBuffer readBytes(int i) {
        Buffer buffer = new Buffer();
        buffer.write(this.buffer, i);
        return new OkHttpReadableBuffer(buffer);
    }

    private void fakeEofExceptionMethod() {
    }
}
