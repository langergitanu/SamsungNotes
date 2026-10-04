package io.netty.handler.codec.protobuf;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.CorruptedFrameException;
import java.util.List;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class ProtobufVarint32FrameDecoder extends ByteToMessageDecoder {
    private static int readRawVarint32(ByteBuf byteBuf) {
        int i;
        if (!byteBuf.isReadable()) {
            return 0;
        }
        byteBuf.markReaderIndex();
        byte b = byteBuf.readByte();
        if (b >= 0) {
            return b;
        }
        int i2 = b & 127;
        if (!byteBuf.isReadable()) {
            byteBuf.resetReaderIndex();
            return 0;
        }
        byte b5 = byteBuf.readByte();
        if (b5 >= 0) {
            i = b5 << 7;
        } else {
            i2 |= (b5 & 127) << 7;
            if (!byteBuf.isReadable()) {
                byteBuf.resetReaderIndex();
                return 0;
            }
            byte b6 = byteBuf.readByte();
            if (b6 >= 0) {
                i = b6 << 14;
            } else {
                i2 |= (b6 & 127) << 14;
                if (!byteBuf.isReadable()) {
                    byteBuf.resetReaderIndex();
                    return 0;
                }
                byte b7 = byteBuf.readByte();
                if (b7 < 0) {
                    int i4 = i2 | ((b7 & 127) << 21);
                    if (!byteBuf.isReadable()) {
                        byteBuf.resetReaderIndex();
                        return 0;
                    }
                    byte b8 = byteBuf.readByte();
                    int i5 = i4 | (b8 << 28);
                    if (b8 >= 0) {
                        return i5;
                    }
                    throw new CorruptedFrameException("malformed varint.");
                }
                i = b7 << 21;
            }
        }
        return i | i2;
    }

    @Override // io.netty.handler.codec.ByteToMessageDecoder
    public void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) {
        byteBuf.markReaderIndex();
        int i = byteBuf.readerIndex();
        int rawVarint32 = readRawVarint32(byteBuf);
        if (i == byteBuf.readerIndex()) {
            return;
        }
        if (rawVarint32 < 0) {
            throw new CorruptedFrameException(AbstractC0000a.m11h(rawVarint32, "negative length: "));
        }
        if (byteBuf.readableBytes() < rawVarint32) {
            byteBuf.resetReaderIndex();
        } else {
            list.add(byteBuf.readRetainedSlice(rawVarint32));
        }
    }
}
