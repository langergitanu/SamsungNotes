package io.netty.handler.codec.marshalling;

import io.netty.buffer.ByteBuf;
import org.jboss.marshalling.ByteOutput;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
class ChannelBufferByteOutput implements ByteOutput {
    private final ByteBuf buffer;

    public ChannelBufferByteOutput(ByteBuf byteBuf) {
        this.buffer = byteBuf;
    }

    public ByteBuf getBuffer() {
        return this.buffer;
    }

    public void write(int i) {
        this.buffer.writeByte(i);
    }

    public void write(byte[] bArr) {
        this.buffer.writeBytes(bArr);
    }

    public void write(byte[] bArr, int i, int i2) {
        this.buffer.writeBytes(bArr, i, i2);
    }

    public void close() {
    }

    public void flush() {
    }
}
