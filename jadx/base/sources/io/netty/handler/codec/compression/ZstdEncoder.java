package io.netty.handler.codec.compression;

import androidx.compose.runtime.AbstractC1974b;
import androidx.glance.AbstractC2821a;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.EncoderException;
import io.netty.handler.codec.MessageToByteEncoder;
import io.netty.util.internal.ObjectUtil;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final class ZstdEncoder extends MessageToByteEncoder<ByteBuf> {
    private final int blockSize;
    private ByteBuf buffer;
    private final int compressionLevel;
    private final int maxEncodeSize;

    public ZstdEncoder() {
        this(3, 65536, 33554432);
    }

    private void flushBufferedData(ByteBuf byteBuf) {
        int i = this.buffer.readableBytes();
        if (i == 0) {
            return;
        }
        byteBuf.ensureWritable((int) com.github.luben.zstd.Zstd.compressBound(i));
        int iWriterIndex = byteBuf.writerIndex();
        try {
            ByteBuffer byteBufferInternalNioBuffer = byteBuf.internalNioBuffer(iWriterIndex, byteBuf.writableBytes());
            ByteBuf byteBuf2 = this.buffer;
            byteBuf.writerIndex(iWriterIndex + com.github.luben.zstd.Zstd.compress(byteBufferInternalNioBuffer, byteBuf2.internalNioBuffer(byteBuf2.readerIndex(), i), this.compressionLevel));
            this.buffer.clear();
        } catch (Exception e) {
            throw new CompressionException(e);
        }
    }

    @Override // io.netty.channel.ChannelOutboundHandlerAdapter, io.netty.channel.ChannelOutboundHandler
    public void flush(ChannelHandlerContext channelHandlerContext) {
        ByteBuf byteBuf = this.buffer;
        if (byteBuf != null && byteBuf.isReadable()) {
            ByteBuf byteBufAllocateBuffer = allocateBuffer(channelHandlerContext, Unpooled.EMPTY_BUFFER, isPreferDirect());
            flushBufferedData(byteBufAllocateBuffer);
            channelHandlerContext.write(byteBufAllocateBuffer);
        }
        channelHandlerContext.flush();
    }

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerAdded(ChannelHandlerContext channelHandlerContext) {
        ByteBuf byteBufDirectBuffer = channelHandlerContext.alloc().directBuffer(this.blockSize);
        this.buffer = byteBufDirectBuffer;
        byteBufDirectBuffer.clear();
    }

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerRemoved(ChannelHandlerContext channelHandlerContext) {
        super.handlerRemoved(channelHandlerContext);
        ByteBuf byteBuf = this.buffer;
        if (byteBuf != null) {
            byteBuf.release();
            this.buffer = null;
        }
    }

    public ZstdEncoder(int i) {
        this(i, 65536, 33554432);
    }

    @Override // io.netty.handler.codec.MessageToByteEncoder
    public ByteBuf allocateBuffer(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, boolean z) {
        if (this.buffer == null) {
            throw new IllegalStateException("not added to a pipeline,or has been removed,buffer is null");
        }
        int i = this.buffer.readableBytes() + byteBuf.readableBytes();
        if (i < 0) {
            throw new EncoderException("too much data to allocate a buffer for compression");
        }
        long jCompressBound = 0;
        while (i > 0) {
            int iMin = Math.min(this.blockSize, i);
            i -= iMin;
            jCompressBound += com.github.luben.zstd.Zstd.compressBound(iMin);
        }
        if (jCompressBound > this.maxEncodeSize || 0 > jCompressBound) {
            throw new EncoderException(AbstractC2821a.m2223n(AbstractC1974b.m1323p(jCompressBound, "requested encode buffer size (", " bytes) exceeds the maximum allowable size ("), " bytes)", this.maxEncodeSize));
        }
        return channelHandlerContext.alloc().directBuffer((int) jCompressBound);
    }

    @Override // io.netty.handler.codec.MessageToByteEncoder
    public void encode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, ByteBuf byteBuf2) {
        ByteBuf byteBuf3 = this.buffer;
        if (byteBuf3 == null) {
            throw new IllegalStateException("not added to a pipeline,or has been removed,buffer is null");
        }
        while (true) {
            int i = byteBuf.readableBytes();
            if (i <= 0) {
                return;
            }
            byteBuf.readBytes(byteBuf3, Math.min(i, byteBuf3.writableBytes()));
            if (!byteBuf3.isWritable()) {
                flushBufferedData(byteBuf2);
            }
        }
    }

    public ZstdEncoder(int i, int i2) {
        this(3, i, i2);
    }

    public ZstdEncoder(int i, int i2, int i4) {
        super(true);
        this.compressionLevel = ObjectUtil.checkInRange(i, 0, 22, "compressionLevel");
        this.blockSize = ObjectUtil.checkPositive(i2, "blockSize");
        this.maxEncodeSize = ObjectUtil.checkPositive(i4, "maxEncodeSize");
    }
}
