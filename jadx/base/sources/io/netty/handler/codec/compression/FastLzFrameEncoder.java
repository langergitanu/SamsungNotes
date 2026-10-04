package io.netty.handler.codec.compression;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import java.util.zip.Adler32;
import java.util.zip.Checksum;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class FastLzFrameEncoder extends MessageToByteEncoder<ByteBuf> {
    private final ByteBufChecksum checksum;
    private final int level;

    public FastLzFrameEncoder() {
        this(0, null);
    }

    public FastLzFrameEncoder(int i) {
        this(i, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x008d A[SYNTHETIC] */
    @Override // io.netty.handler.codec.MessageToByteEncoder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void encode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, ByteBuf byteBuf2) {
        ByteBuf byteBuf3;
        ByteBuf byteBuf4;
        int iCompress;
        int i;
        ByteBufChecksum byteBufChecksum = this.checksum;
        while (byteBuf.isReadable()) {
            int i2 = byteBuf.readerIndex();
            int iMin = Math.min(byteBuf.readableBytes(), 65535);
            int iWriterIndex = byteBuf2.writerIndex();
            byteBuf2.setMedium(iWriterIndex, 4607066);
            int i4 = iWriterIndex + 4;
            int i5 = 0;
            int i6 = i4 + (byteBufChecksum != null ? 4 : 0);
            if (iMin < 32) {
                int i7 = i6 + 2;
                byteBuf2.ensureWritable(i7 + iMin);
                if (byteBufChecksum != null) {
                    byteBufChecksum.reset();
                    byteBufChecksum.update(byteBuf, i2, iMin);
                    byteBuf2.setInt(i4, (int) byteBufChecksum.getValue());
                }
                byteBuf2.setBytes(i7, byteBuf, i2, iMin);
                byteBuf3 = byteBuf;
                byteBuf4 = byteBuf2;
            } else {
                if (byteBufChecksum != null) {
                    byteBufChecksum.reset();
                    byteBufChecksum.update(byteBuf, i2, iMin);
                    byteBuf2.setInt(i4, (int) byteBufChecksum.getValue());
                }
                int i8 = i6 + 4;
                byteBuf2.ensureWritable(FastLz.calculateOutputBufferLength(iMin) + i8);
                byteBuf3 = byteBuf;
                byteBuf4 = byteBuf2;
                iCompress = FastLz.compress(byteBuf3, byteBuf.readerIndex(), iMin, byteBuf4, i8, this.level);
                if (iCompress < iMin) {
                    byteBuf4.setShort(i6, iCompress);
                    i6 += 2;
                    i = 1;
                    byteBuf4.setShort(i6, iMin);
                    int i9 = iWriterIndex + 3;
                    if (byteBufChecksum == null) {
                        i5 = 16;
                    }
                    byteBuf4.setByte(i9, i | i5);
                    byteBuf4.writerIndex(i6 + 2 + iCompress);
                    byteBuf3.skipBytes(iMin);
                    byteBuf = byteBuf3;
                    byteBuf2 = byteBuf4;
                } else {
                    byteBuf4.setBytes(i6 + 2, byteBuf3, i2, iMin);
                }
            }
            iCompress = iMin;
            i = 0;
            byteBuf4.setShort(i6, iMin);
            int i92 = iWriterIndex + 3;
            if (byteBufChecksum == null) {
            }
            byteBuf4.setByte(i92, i | i5);
            byteBuf4.writerIndex(i6 + 2 + iCompress);
            byteBuf3.skipBytes(iMin);
            byteBuf = byteBuf3;
            byteBuf2 = byteBuf4;
        }
    }

    public FastLzFrameEncoder(boolean z) {
        this(0, z ? new Adler32() : null);
    }

    public FastLzFrameEncoder(int i, Checksum checksum) {
        if (i != 0 && i != 1 && i != 2) {
            throw new IllegalArgumentException(String.format("level: %d (expected: %d or %d or %d)", Integer.valueOf(i), 0, 1, 2));
        }
        this.level = i;
        this.checksum = checksum == null ? null : ByteBufChecksum.wrapChecksum(checksum);
    }
}
