package io.grpc.okhttp;

import io.grpc.internal.WritableBuffer;
import okio.Buffer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
class OkHttpWritableBuffer implements WritableBuffer {
    private final Buffer buffer;
    private int readableBytes;
    private int writableBytes;

    public OkHttpWritableBuffer(Buffer buffer, int i) {
        this.buffer = buffer;
        this.writableBytes = i;
    }

    public Buffer buffer() {
        return this.buffer;
    }

    @Override // io.grpc.internal.WritableBuffer
    public int readableBytes() {
        return this.readableBytes;
    }

    @Override // io.grpc.internal.WritableBuffer
    public int writableBytes() {
        return this.writableBytes;
    }

    @Override // io.grpc.internal.WritableBuffer
    public void write(byte[] bArr, int i, int i2) {
        this.buffer.write(bArr, i, i2);
        this.writableBytes -= i2;
        this.readableBytes += i2;
    }

    @Override // io.grpc.internal.WritableBuffer
    public void write(byte b) {
        this.buffer.writeByte((int) b);
        this.writableBytes--;
        this.readableBytes++;
    }

    @Override // io.grpc.internal.WritableBuffer
    public void release() {
    }
}
