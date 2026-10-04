package io.netty.handler.codec.compression;

import androidx.appcompat.widget.AbstractC0541b;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufInputStream;
import io.netty.buffer.ByteBufOutputStream;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import lzma.sdk.ICodeProgress;
import lzma.sdk.lzma.Encoder;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class LzmaFrameEncoder extends MessageToByteEncoder<ByteBuf> {
    private static final int DEFAULT_LC = 3;
    private static final int DEFAULT_LP = 0;
    private static final int DEFAULT_MATCH_FINDER = 1;
    private static final int DEFAULT_PB = 2;
    private static final int MAX_FAST_BYTES = 273;
    private static final int MEDIUM_DICTIONARY_SIZE = 65536;
    private static final int MEDIUM_FAST_BYTES = 32;
    private static final int MIN_FAST_BYTES = 5;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) LzmaFrameEncoder.class);
    private static boolean warningLogged;
    private final Encoder encoder;
    private final int littleEndianDictionarySize;
    private final byte properties;

    public LzmaFrameEncoder() {
        this(65536);
    }

    private static int maxOutputBufferLength(int i) {
        return ((int) (((double) i) * (i < 200 ? 1.5d : i < 500 ? 1.2d : i < 1000 ? 1.1d : i < 10000 ? 1.05d : 1.02d))) + 13;
    }

    public LzmaFrameEncoder(int i, int i2, int i4) {
        this(i, i2, i4, 65536);
    }

    @Override // io.netty.handler.codec.MessageToByteEncoder
    public ByteBuf allocateBuffer(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, boolean z) {
        return channelHandlerContext.alloc().ioBuffer(maxOutputBufferLength(byteBuf.readableBytes()));
    }

    @Override // io.netty.handler.codec.MessageToByteEncoder
    public void encode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, ByteBuf byteBuf2) throws Throwable {
        Throwable th;
        ByteBufOutputStream byteBufOutputStream;
        int i = byteBuf.readableBytes();
        ByteBufInputStream byteBufInputStream = null;
        try {
            ByteBufInputStream byteBufInputStream2 = new ByteBufInputStream(byteBuf);
            try {
                byteBufOutputStream = new ByteBufOutputStream(byteBuf2);
                try {
                    byteBufOutputStream.writeByte(this.properties);
                    byteBufOutputStream.writeInt(this.littleEndianDictionarySize);
                    byteBufOutputStream.writeLong(Long.reverseBytes(i));
                    this.encoder.code(byteBufInputStream2, byteBufOutputStream, -1L, -1L, (ICodeProgress) null);
                    byteBufInputStream2.close();
                    byteBufOutputStream.close();
                } catch (Throwable th2) {
                    th = th2;
                    byteBufInputStream = byteBufInputStream2;
                    if (byteBufInputStream != null) {
                        byteBufInputStream.close();
                    }
                    if (byteBufOutputStream == null) {
                        throw th;
                    }
                    byteBufOutputStream.close();
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                byteBufOutputStream = null;
            }
        } catch (Throwable th4) {
            th = th4;
            byteBufOutputStream = null;
        }
    }

    public LzmaFrameEncoder(int i) {
        this(3, 0, 2, i);
    }

    public LzmaFrameEncoder(int i, int i2, int i4, int i5) {
        this(i, i2, i4, i5, false, 32);
    }

    public LzmaFrameEncoder(int i, int i2, int i4, int i5, boolean z, int i6) {
        if (i < 0 || i > 8) {
            throw new IllegalArgumentException(AbstractC0541b.m767i(i, "lc: ", " (expected: 0-8)"));
        }
        if (i2 < 0 || i2 > 4) {
            throw new IllegalArgumentException(AbstractC0541b.m767i(i2, "lp: ", " (expected: 0-4)"));
        }
        if (i4 >= 0 && i4 <= 4) {
            if (i + i2 > 4 && !warningLogged) {
                logger.warn("The latest versions of LZMA libraries (for example, XZ Utils) has an additional requirement: lc + lp <= 4. Data which don't follow this requirement cannot be decompressed with this libraries.");
                warningLogged = true;
            }
            if (i5 < 0) {
                throw new IllegalArgumentException(AbstractC0541b.m767i(i5, "dictionarySize: ", " (expected: 0+)"));
            }
            if (i6 >= 5 && i6 <= 273) {
                Encoder encoder = new Encoder();
                this.encoder = encoder;
                encoder.setDictionarySize(i5);
                encoder.setEndMarkerMode(z);
                encoder.setMatchFinder(1);
                encoder.setNumFastBytes(i6);
                encoder.setLcLpPb(i, i2, i4);
                this.properties = (byte) ((((i4 * 5) + i2) * 9) + i);
                this.littleEndianDictionarySize = Integer.reverseBytes(i5);
                return;
            }
            throw new IllegalArgumentException(String.format("numFastBytes: %d (expected: %d-%d)", Integer.valueOf(i6), 5, 273));
        }
        throw new IllegalArgumentException(AbstractC0541b.m767i(i4, "pb: ", " (expected: 0-4)"));
    }
}
