package io.netty.handler.codec.compression;

import androidx.appcompat.widget.AbstractC0541b;
import com.ning.compress.BufferRecycler;
import com.ning.compress.lzf.ChunkEncoder;
import com.ning.compress.lzf.LZFChunk;
import com.ning.compress.lzf.LZFEncoder;
import com.ning.compress.lzf.util.ChunkEncoderFactory;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class LzfEncoder extends MessageToByteEncoder<ByteBuf> {
    private static final int MIN_BLOCK_TO_COMPRESS = 16;
    private final int compressThreshold;
    private final ChunkEncoder encoder;
    private final BufferRecycler recycler;

    public LzfEncoder() {
        this(false);
    }

    private int encodeCompress(byte[] bArr, int i, int i2, byte[] bArr2, int i4) {
        return LZFEncoder.appendEncoded(this.encoder, bArr, i, i2, bArr2, i4) - i4;
    }

    private static int encodeNonCompress(byte[] bArr, int i, int i2, byte[] bArr2, int i4) {
        return lzfEncodeNonCompress(bArr, i, i2, bArr2, i4) - i4;
    }

    private static int lzfEncodeNonCompress(byte[] bArr, int i, int i2, byte[] bArr2, int i4) {
        int iMin = Math.min(65535, i2);
        int iAppendNonCompressed = LZFChunk.appendNonCompressed(bArr, i, iMin, bArr2, i4);
        int i5 = i2 - iMin;
        if (i5 < 1) {
            return iAppendNonCompressed;
        }
        int i6 = i + iMin;
        do {
            int iMin2 = Math.min(i5, 65535);
            iAppendNonCompressed = LZFChunk.appendNonCompressed(bArr, i6, iMin2, bArr2, iAppendNonCompressed);
            i6 += iMin2;
            i5 -= iMin2;
        } while (i5 > 0);
        return iAppendNonCompressed;
    }

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerRemoved(ChannelHandlerContext channelHandlerContext) {
        this.encoder.close();
        super.handlerRemoved(channelHandlerContext);
    }

    public LzfEncoder(boolean z) {
        this(z, 65535);
    }

    @Override // io.netty.handler.codec.MessageToByteEncoder
    public void encode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, ByteBuf byteBuf2) {
        byte[] bArrAllocInputBuffer;
        int iArrayOffset;
        byte[] bArrArray;
        int iWriterIndex;
        LzfEncoder lzfEncoder;
        int iEncodeNonCompress;
        int i = byteBuf.readableBytes();
        int i2 = byteBuf.readerIndex();
        if (byteBuf.hasArray()) {
            bArrAllocInputBuffer = byteBuf.array();
            iArrayOffset = byteBuf.arrayOffset() + i2;
        } else {
            bArrAllocInputBuffer = this.recycler.allocInputBuffer(i);
            byteBuf.getBytes(i2, bArrAllocInputBuffer, 0, i);
            iArrayOffset = 0;
        }
        byte[] bArr = bArrAllocInputBuffer;
        int iEstimateMaxWorkspaceSize = LZFEncoder.estimateMaxWorkspaceSize(i) + 1;
        byteBuf2.ensureWritable(iEstimateMaxWorkspaceSize);
        if (byteBuf2.hasArray()) {
            bArrArray = byteBuf2.array();
            iWriterIndex = byteBuf2.writerIndex() + byteBuf2.arrayOffset();
        } else {
            bArrArray = new byte[iEstimateMaxWorkspaceSize];
            iWriterIndex = 0;
        }
        byte[] bArr2 = bArrArray;
        if (i >= this.compressThreshold) {
            lzfEncoder = this;
            iEncodeNonCompress = lzfEncoder.encodeCompress(bArr, iArrayOffset, i, bArr2, iWriterIndex);
        } else {
            lzfEncoder = this;
            iEncodeNonCompress = encodeNonCompress(bArr, iArrayOffset, i, bArr2, iWriterIndex);
        }
        if (byteBuf2.hasArray()) {
            byteBuf2.writerIndex(byteBuf2.writerIndex() + iEncodeNonCompress);
        } else {
            byteBuf2.writeBytes(bArr2, 0, iEncodeNonCompress);
        }
        byteBuf.skipBytes(i);
        if (byteBuf.hasArray()) {
            return;
        }
        lzfEncoder.recycler.releaseInputBuffer(bArr);
    }

    public LzfEncoder(boolean z, int i) {
        this(z, i, 16);
    }

    public LzfEncoder(int i) {
        this(false, i);
    }

    public LzfEncoder(boolean z, int i, int i2) {
        ChunkEncoder chunkEncoderOptimalNonAllocatingInstance;
        super(false);
        if (i < 16 || i > 65535) {
            throw new IllegalArgumentException(AbstractC0541b.m767i(i, "totalLength: ", " (expected: 16-65535)"));
        }
        if (i2 >= 16) {
            this.compressThreshold = i2;
            if (z) {
                chunkEncoderOptimalNonAllocatingInstance = ChunkEncoderFactory.safeNonAllocatingInstance(i);
            } else {
                chunkEncoderOptimalNonAllocatingInstance = ChunkEncoderFactory.optimalNonAllocatingInstance(i);
            }
            this.encoder = chunkEncoderOptimalNonAllocatingInstance;
            this.recycler = BufferRecycler.instance();
            return;
        }
        throw new IllegalArgumentException(AbstractC0541b.m767i(i2, "compressThreshold:", " expected >=16"));
    }
}
