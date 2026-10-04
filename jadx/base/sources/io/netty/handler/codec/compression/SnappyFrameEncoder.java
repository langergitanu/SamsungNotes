package io.netty.handler.codec.compression;

import androidx.compose.p109ui.layout.LayoutKt;
import com.samsung.android.spr.drawable.document.attribute.SprAttributeBase;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class SnappyFrameEncoder extends MessageToByteEncoder<ByteBuf> {
    private static final int MIN_COMPRESSIBLE_LENGTH = 18;
    private static final byte[] STREAM_START = {-1, 6, 0, 0, 115, 78, SprAttributeBase.TYPE_ANIMATOR_SET, 80, SprAttributeBase.TYPE_SHADOW, 89};
    private final Snappy snappy = new Snappy();
    private boolean started;

    private static void calculateAndWriteChecksum(ByteBuf byteBuf, ByteBuf byteBuf2) {
        byteBuf2.writeIntLE(Snappy.calculateChecksum(byteBuf));
    }

    private static void setChunkLength(ByteBuf byteBuf, int i) {
        int iWriterIndex = (byteBuf.writerIndex() - i) - 3;
        if ((iWriterIndex >>> 24) != 0) {
            throw new CompressionException(AbstractC0000a.m11h(iWriterIndex, "compressed data too large: "));
        }
        byteBuf.setMediumLE(i, iWriterIndex);
    }

    private static void writeChunkLength(ByteBuf byteBuf, int i) {
        byteBuf.writeMediumLE(i);
    }

    private static void writeUnencodedChunk(ByteBuf byteBuf, ByteBuf byteBuf2, int i) {
        byteBuf2.writeByte(1);
        writeChunkLength(byteBuf2, i + 4);
        calculateAndWriteChecksum(byteBuf, byteBuf2);
        byteBuf2.writeBytes(byteBuf, i);
    }

    @Override // io.netty.handler.codec.MessageToByteEncoder
    public void encode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, ByteBuf byteBuf2) {
        if (!byteBuf.isReadable()) {
            return;
        }
        if (!this.started) {
            this.started = true;
            byteBuf2.writeBytes(STREAM_START);
        }
        int i = byteBuf.readableBytes();
        if (i <= 18) {
            writeUnencodedChunk(byteBuf, byteBuf2, i);
            return;
        }
        while (true) {
            int iWriterIndex = byteBuf2.writerIndex() + 1;
            if (i < 18) {
                writeUnencodedChunk(byteBuf.readSlice(i), byteBuf2, i);
                return;
            }
            byteBuf2.writeInt(0);
            if (i <= 32767) {
                ByteBuf slice = byteBuf.readSlice(i);
                calculateAndWriteChecksum(slice, byteBuf2);
                this.snappy.encode(slice, byteBuf2, i);
                setChunkLength(byteBuf2, iWriterIndex);
                return;
            }
            ByteBuf slice2 = byteBuf.readSlice(LayoutKt.LargeDimension);
            calculateAndWriteChecksum(slice2, byteBuf2);
            this.snappy.encode(slice2, byteBuf2, LayoutKt.LargeDimension);
            setChunkLength(byteBuf2, iWriterIndex);
            i -= 32767;
        }
    }
}
