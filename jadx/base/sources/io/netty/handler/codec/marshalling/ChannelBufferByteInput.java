package io.netty.handler.codec.marshalling;

import io.netty.buffer.ByteBuf;
import org.jboss.marshalling.ByteInput;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
class ChannelBufferByteInput implements ByteInput {
    private final ByteBuf buffer;

    public ChannelBufferByteInput(ByteBuf byteBuf) {
        this.buffer = byteBuf;
    }

    public int available() {
        return this.buffer.readableBytes();
    }

    public int read() {
        if (this.buffer.isReadable()) {
            return this.buffer.readByte() & 255;
        }
        return -1;
    }

    public long skip(long j) {
        long j2 = this.buffer.readableBytes();
        if (j2 < j) {
            j = j2;
        }
        ByteBuf byteBuf = this.buffer;
        byteBuf.readerIndex((int) (((long) byteBuf.readerIndex()) + j));
        return j;
    }

    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    public int read(byte[] bArr, int i, int i2) {
        int iAvailable = available();
        if (iAvailable == 0) {
            return -1;
        }
        int iMin = Math.min(iAvailable, i2);
        this.buffer.readBytes(bArr, i, iMin);
        return iMin;
    }

    public void close() {
    }
}
