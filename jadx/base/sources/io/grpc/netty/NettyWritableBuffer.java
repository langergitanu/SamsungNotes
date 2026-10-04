package io.grpc.netty;

import io.grpc.internal.WritableBuffer;
import io.netty.buffer.ByteBuf;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
class NettyWritableBuffer implements WritableBuffer {
    private final ByteBuf bytebuf;

    public NettyWritableBuffer(ByteBuf byteBuf) {
        this.bytebuf = byteBuf;
    }

    public ByteBuf bytebuf() {
        return this.bytebuf;
    }

    @Override // io.grpc.internal.WritableBuffer
    public int readableBytes() {
        return this.bytebuf.readableBytes();
    }

    @Override // io.grpc.internal.WritableBuffer
    public void release() {
        this.bytebuf.release();
    }

    @Override // io.grpc.internal.WritableBuffer
    public int writableBytes() {
        return this.bytebuf.writableBytes();
    }

    @Override // io.grpc.internal.WritableBuffer
    public void write(byte[] bArr, int i, int i2) {
        this.bytebuf.writeBytes(bArr, i, i2);
    }

    @Override // io.grpc.internal.WritableBuffer
    public void write(byte b) {
        this.bytebuf.writeByte(b);
    }
}
