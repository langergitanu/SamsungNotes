package io.netty.handler.codec.compression;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.util.internal.ObjectUtil;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public abstract class ZlibDecoder extends ByteToMessageDecoder {
    protected final int maxAllocation;

    public ZlibDecoder() {
        this(0);
    }

    public abstract boolean isClosed();

    public ByteBuf prepareDecompressBuffer(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, int i) {
        if (byteBuf == null) {
            return this.maxAllocation == 0 ? channelHandlerContext.alloc().heapBuffer(i) : channelHandlerContext.alloc().heapBuffer(Math.min(i, this.maxAllocation), this.maxAllocation);
        }
        if (byteBuf.ensureWritable(i, true) != 1) {
            return byteBuf;
        }
        decompressionBufferExhausted(byteBuf.duplicate());
        byteBuf.skipBytes(byteBuf.readableBytes());
        throw new DecompressionException("Decompression buffer has reached maximum size: " + byteBuf.maxCapacity());
    }

    public ZlibDecoder(int i) {
        this.maxAllocation = ObjectUtil.checkPositiveOrZero(i, "maxAllocation");
    }

    public void decompressionBufferExhausted(ByteBuf byteBuf) {
    }
}
