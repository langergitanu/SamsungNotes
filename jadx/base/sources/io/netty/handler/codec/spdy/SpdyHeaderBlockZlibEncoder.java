package io.netty.handler.codec.spdy;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.Unpooled;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.SuppressJava6Requirement;
import java.util.zip.Deflater;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
class SpdyHeaderBlockZlibEncoder extends SpdyHeaderBlockRawEncoder {
    private final Deflater compressor;
    private boolean finished;

    public SpdyHeaderBlockZlibEncoder(SpdyVersion spdyVersion, int i) {
        super(spdyVersion);
        if (i < 0 || i > 9) {
            throw new IllegalArgumentException(AbstractC0541b.m767i(i, "compressionLevel: ", " (expected: 0-9)"));
        }
        Deflater deflater = new Deflater(i);
        this.compressor = deflater;
        deflater.setDictionary(SpdyCodecUtil.SPDY_DICT);
    }

    @SuppressJava6Requirement(reason = "Guarded by java version check")
    private boolean compressInto(ByteBuf byteBuf) {
        byte[] bArrArray = byteBuf.array();
        int iWriterIndex = byteBuf.writerIndex() + byteBuf.arrayOffset();
        int iWritableBytes = byteBuf.writableBytes();
        int iDeflate = PlatformDependent.javaVersion() >= 7 ? this.compressor.deflate(bArrArray, iWriterIndex, iWritableBytes, 2) : this.compressor.deflate(bArrArray, iWriterIndex, iWritableBytes);
        byteBuf.writerIndex(byteBuf.writerIndex() + iDeflate);
        return iDeflate == iWritableBytes;
    }

    private ByteBuf encode(ByteBufAllocator byteBufAllocator, int i) {
        ByteBuf byteBufHeapBuffer = byteBufAllocator.heapBuffer(i);
        while (compressInto(byteBufHeapBuffer)) {
            try {
                byteBufHeapBuffer.ensureWritable(byteBufHeapBuffer.capacity() << 1);
            } catch (Throwable th) {
                byteBufHeapBuffer.release();
                throw th;
            }
        }
        return byteBufHeapBuffer;
    }

    private int setInput(ByteBuf byteBuf) {
        int i = byteBuf.readableBytes();
        if (!byteBuf.hasArray()) {
            byte[] bArr = new byte[i];
            byteBuf.getBytes(byteBuf.readerIndex(), bArr);
            this.compressor.setInput(bArr, 0, i);
            return i;
        }
        this.compressor.setInput(byteBuf.array(), byteBuf.readerIndex() + byteBuf.arrayOffset(), i);
        return i;
    }

    @Override // io.netty.handler.codec.spdy.SpdyHeaderBlockRawEncoder, io.netty.handler.codec.spdy.SpdyHeaderBlockEncoder
    public void end() {
        if (this.finished) {
            return;
        }
        this.finished = true;
        this.compressor.end();
        super.end();
    }

    @Override // io.netty.handler.codec.spdy.SpdyHeaderBlockRawEncoder, io.netty.handler.codec.spdy.SpdyHeaderBlockEncoder
    public ByteBuf encode(ByteBufAllocator byteBufAllocator, SpdyHeadersFrame spdyHeadersFrame) {
        ObjectUtil.checkNotNullWithIAE(byteBufAllocator, "alloc");
        ObjectUtil.checkNotNullWithIAE(spdyHeadersFrame, TypedValues.Attributes.S_FRAME);
        if (this.finished) {
            return Unpooled.EMPTY_BUFFER;
        }
        ByteBuf byteBufEncode = super.encode(byteBufAllocator, spdyHeadersFrame);
        try {
            if (!byteBufEncode.isReadable()) {
                return Unpooled.EMPTY_BUFFER;
            }
            return encode(byteBufAllocator, setInput(byteBufEncode));
        } finally {
            byteBufEncode.release();
        }
    }
}
