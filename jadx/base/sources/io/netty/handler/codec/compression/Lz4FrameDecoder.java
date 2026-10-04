package io.netty.handler.codec.compression;

import com.yubico.yubikit.core.fido.CtapException;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.util.internal.ObjectUtil;
import java.util.List;
import java.util.zip.Checksum;
import net.jpountz.lz4.LZ4Exception;
import net.jpountz.lz4.LZ4Factory;
import net.jpountz.lz4.LZ4FastDecompressor;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class Lz4FrameDecoder extends ByteToMessageDecoder {
    private int blockType;
    private ByteBufChecksum checksum;
    private int compressedLength;
    private int currentChecksum;
    private State currentState;
    private int decompressedLength;
    private LZ4FastDecompressor decompressor;

    /* JADX INFO: renamed from: io.netty.handler.codec.compression.Lz4FrameDecoder$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C125111 {

        /* JADX INFO: renamed from: $SwitchMap$io$netty$handler$codec$compression$Lz4FrameDecoder$State */
        static final /* synthetic */ int[] f8886xd73b9784;

        static {
            int[] iArr = new int[State.values().length];
            f8886xd73b9784 = iArr;
            try {
                iArr[State.INIT_BLOCK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f8886xd73b9784[State.DECOMPRESS_DATA.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f8886xd73b9784[State.FINISHED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f8886xd73b9784[State.CORRUPTED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum State {
        INIT_BLOCK,
        DECOMPRESS_DATA,
        FINISHED,
        CORRUPTED
    }

    public Lz4FrameDecoder() {
        this(false);
    }

    @Override // io.netty.handler.codec.ByteToMessageDecoder
    public void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        ByteBuf byteBufRetainedSlice;
        try {
            int i = C125111.f8886xd73b9784[this.currentState.ordinal()];
            ByteBuf byteBuf2 = null;
            if (i != 1) {
                if (i != 2) {
                    if (i != 3 && i != 4) {
                        throw new IllegalStateException();
                    }
                    byteBuf.skipBytes(byteBuf.readableBytes());
                    return;
                }
            } else {
                if (byteBuf.readableBytes() < 21) {
                    return;
                }
                if (byteBuf.readLong() != 5501767354678207339L) {
                    throw new DecompressionException("unexpected block identifier");
                }
                byte b = byteBuf.readByte();
                int i2 = (b & 15) + 10;
                int i4 = b & CtapException.ERR_VENDOR_FIRST;
                int iReverseBytes = Integer.reverseBytes(byteBuf.readInt());
                if (iReverseBytes < 0 || iReverseBytes > 33554432) {
                    throw new DecompressionException(String.format("invalid compressedLength: %d (expected: 0-%d)", Integer.valueOf(iReverseBytes), 33554432));
                }
                int iReverseBytes2 = Integer.reverseBytes(byteBuf.readInt());
                int i5 = 1 << i2;
                if (iReverseBytes2 < 0 || iReverseBytes2 > i5) {
                    throw new DecompressionException(String.format("invalid decompressedLength: %d (expected: 0-%d)", Integer.valueOf(iReverseBytes2), Integer.valueOf(i5)));
                }
                if ((iReverseBytes2 == 0 && iReverseBytes != 0) || ((iReverseBytes2 != 0 && iReverseBytes == 0) || (i4 == 16 && iReverseBytes2 != iReverseBytes))) {
                    throw new DecompressionException(String.format("stream corrupted: compressedLength(%d) and decompressedLength(%d) mismatch", Integer.valueOf(iReverseBytes), Integer.valueOf(iReverseBytes2)));
                }
                int iReverseBytes3 = Integer.reverseBytes(byteBuf.readInt());
                if (iReverseBytes2 == 0 && iReverseBytes == 0) {
                    if (iReverseBytes3 != 0) {
                        throw new DecompressionException("stream corrupted: checksum error");
                    }
                    this.currentState = State.FINISHED;
                    this.decompressor = null;
                    this.checksum = null;
                    return;
                }
                this.blockType = i4;
                this.compressedLength = iReverseBytes;
                this.decompressedLength = iReverseBytes2;
                this.currentChecksum = iReverseBytes3;
                this.currentState = State.DECOMPRESS_DATA;
            }
            int i6 = this.blockType;
            int i7 = this.compressedLength;
            int i8 = this.decompressedLength;
            int i9 = this.currentChecksum;
            if (byteBuf.readableBytes() < i7) {
                return;
            }
            ByteBufChecksum byteBufChecksum = this.checksum;
            try {
                try {
                    if (i6 == 16) {
                        byteBufRetainedSlice = byteBuf.retainedSlice(byteBuf.readerIndex(), i8);
                    } else {
                        if (i6 != 32) {
                            throw new DecompressionException(String.format("unexpected blockType: %d (expected: %d or %d)", Integer.valueOf(i6), 16, 32));
                        }
                        byteBufRetainedSlice = channelHandlerContext.alloc().buffer(i8, i8);
                        try {
                            this.decompressor.decompress(CompressionUtil.safeNioBuffer(byteBuf), byteBufRetainedSlice.internalNioBuffer(byteBufRetainedSlice.writerIndex(), i8));
                            byteBufRetainedSlice.writerIndex(byteBufRetainedSlice.writerIndex() + i8);
                        } catch (LZ4Exception e) {
                            e = e;
                            throw new DecompressionException((Throwable) e);
                        } catch (Throwable th) {
                            th = th;
                            byteBuf2 = byteBufRetainedSlice;
                            if (byteBuf2 != null) {
                                byteBuf2.release();
                            }
                            throw th;
                        }
                    }
                    byteBuf.skipBytes(i7);
                    if (byteBufChecksum != null) {
                        CompressionUtil.checkChecksum(byteBufChecksum, byteBufRetainedSlice, i9);
                    }
                    list.add(byteBufRetainedSlice);
                    this.currentState = State.INIT_BLOCK;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (LZ4Exception e2) {
                e = e2;
            }
        } catch (Exception e3) {
            this.currentState = State.CORRUPTED;
            throw e3;
        }
    }

    public boolean isClosed() {
        return this.currentState == State.FINISHED;
    }

    public Lz4FrameDecoder(boolean z) {
        this(LZ4Factory.fastestInstance(), z);
    }

    public Lz4FrameDecoder(LZ4Factory lZ4Factory, boolean z) {
        this(lZ4Factory, z ? new Lz4XXHash32(-1756908916) : null);
    }

    public Lz4FrameDecoder(LZ4Factory lZ4Factory, Checksum checksum) {
        this.currentState = State.INIT_BLOCK;
        this.decompressor = ((LZ4Factory) ObjectUtil.checkNotNull(lZ4Factory, "factory")).fastDecompressor();
        this.checksum = checksum == null ? null : ByteBufChecksum.wrapChecksum(checksum);
    }
}
