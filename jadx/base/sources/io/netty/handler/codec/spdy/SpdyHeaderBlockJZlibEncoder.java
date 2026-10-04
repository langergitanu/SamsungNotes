package io.netty.handler.codec.spdy;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.jcraft.jzlib.Deflater;
import com.jcraft.jzlib.JZlib;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.Unpooled;
import io.netty.handler.codec.compression.CompressionException;
import io.netty.util.internal.ObjectUtil;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
class SpdyHeaderBlockJZlibEncoder extends SpdyHeaderBlockRawEncoder {
    private boolean finished;

    /* JADX INFO: renamed from: z */
    private final Deflater f8933z;

    public SpdyHeaderBlockJZlibEncoder(SpdyVersion spdyVersion, int i, int i2, int i4) {
        super(spdyVersion);
        Deflater deflater = new Deflater();
        this.f8933z = deflater;
        if (i < 0 || i > 9) {
            throw new IllegalArgumentException(AbstractC0541b.m767i(i, "compressionLevel: ", " (expected: 0-9)"));
        }
        if (i2 < 9 || i2 > 15) {
            throw new IllegalArgumentException(AbstractC0541b.m767i(i2, "windowBits: ", " (expected: 9-15)"));
        }
        if (i4 < 1 || i4 > 9) {
            throw new IllegalArgumentException(AbstractC0541b.m767i(i4, "memLevel: ", " (expected: 1-9)"));
        }
        int iDeflateInit = deflater.deflateInit(i, i2, i4, JZlib.W_ZLIB);
        if (iDeflateInit != 0) {
            throw new CompressionException(AbstractC0000a.m11h(iDeflateInit, "failed to initialize an SPDY header block deflater: "));
        }
        byte[] bArr = SpdyCodecUtil.SPDY_DICT;
        int iDeflateSetDictionary = deflater.deflateSetDictionary(bArr, bArr.length);
        if (iDeflateSetDictionary != 0) {
            throw new CompressionException(AbstractC0000a.m11h(iDeflateSetDictionary, "failed to set the SPDY dictionary: "));
        }
    }

    private ByteBuf encode(ByteBufAllocator byteBufAllocator) throws Throwable {
        ByteBuf byteBufHeapBuffer;
        int i;
        int i2;
        int iCeil;
        try {
            i = this.f8933z.next_in_index;
            i2 = this.f8933z.next_out_index;
            iCeil = ((int) Math.ceil(((double) this.f8933z.next_in.length) * 1.001d)) + 12;
            byteBufHeapBuffer = byteBufAllocator.heapBuffer(iCeil);
        } catch (Throwable th) {
            th = th;
            byteBufHeapBuffer = null;
        }
        try {
            this.f8933z.next_out = byteBufHeapBuffer.array();
            this.f8933z.next_out_index = byteBufHeapBuffer.arrayOffset() + byteBufHeapBuffer.writerIndex();
            this.f8933z.avail_out = iCeil;
            try {
                int iDeflate = this.f8933z.deflate(2);
                if (iDeflate != 0) {
                    throw new CompressionException("compression failure: " + iDeflate);
                }
                int i4 = this.f8933z.next_out_index - i2;
                if (i4 > 0) {
                    byteBufHeapBuffer.writerIndex(byteBufHeapBuffer.writerIndex() + i4);
                }
                this.f8933z.next_in = null;
                this.f8933z.next_out = null;
                return byteBufHeapBuffer;
            } finally {
                byteBufHeapBuffer.skipBytes(this.f8933z.next_in_index - i);
            }
        } catch (Throwable th2) {
            th = th2;
            this.f8933z.next_in = null;
            this.f8933z.next_out = null;
            if (byteBufHeapBuffer != null) {
                byteBufHeapBuffer.release();
            }
            throw th;
        }
    }

    private void setInput(ByteBuf byteBuf) {
        byte[] bArrArray;
        int iArrayOffset;
        int i = byteBuf.readableBytes();
        if (byteBuf.hasArray()) {
            bArrArray = byteBuf.array();
            iArrayOffset = byteBuf.readerIndex() + byteBuf.arrayOffset();
        } else {
            bArrArray = new byte[i];
            byteBuf.getBytes(byteBuf.readerIndex(), bArrArray);
            iArrayOffset = 0;
        }
        this.f8933z.next_in = bArrArray;
        this.f8933z.next_in_index = iArrayOffset;
        this.f8933z.avail_in = i;
    }

    @Override // io.netty.handler.codec.spdy.SpdyHeaderBlockRawEncoder, io.netty.handler.codec.spdy.SpdyHeaderBlockEncoder
    public void end() {
        if (this.finished) {
            return;
        }
        this.finished = true;
        this.f8933z.deflateEnd();
        this.f8933z.next_in = null;
        this.f8933z.next_out = null;
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
            setInput(byteBufEncode);
            return encode(byteBufAllocator);
        } finally {
            byteBufEncode.release();
        }
    }
}
