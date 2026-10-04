package io.netty.handler.codec.compression;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import java.util.List;
import java.util.zip.Adler32;
import java.util.zip.Checksum;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class FastLzFrameDecoder extends ByteToMessageDecoder {
    private final ByteBufChecksum checksum;
    private int chunkLength;
    private int currentChecksum;
    private State currentState;
    private boolean hasChecksum;
    private boolean isCompressed;
    private int originalLength;

    /* JADX INFO: renamed from: io.netty.handler.codec.compression.FastLzFrameDecoder$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C125041 {

        /* JADX INFO: renamed from: $SwitchMap$io$netty$handler$codec$compression$FastLzFrameDecoder$State */
        static final /* synthetic */ int[] f8882x8db84534;

        static {
            int[] iArr = new int[State.values().length];
            f8882x8db84534 = iArr;
            try {
                iArr[State.INIT_BLOCK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f8882x8db84534[State.INIT_BLOCK_PARAMS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f8882x8db84534[State.DECOMPRESS_DATA.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f8882x8db84534[State.CORRUPTED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum State {
        INIT_BLOCK,
        INIT_BLOCK_PARAMS,
        DECOMPRESS_DATA,
        CORRUPTED
    }

    public FastLzFrameDecoder() {
        this(false);
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x008e A[Catch: Exception -> 0x001f, TRY_LEAVE, TryCatch #0 {Exception -> 0x001f, blocks: (B:2:0x0000, B:8:0x0017, B:12:0x0023, B:13:0x0028, B:45:0x0085, B:48:0x008e, B:79:0x012d, B:80:0x0130, B:28:0x0053, B:32:0x005e, B:36:0x0065, B:40:0x006b, B:41:0x006f, B:43:0x007b, B:44:0x007f, B:14:0x0029, B:17:0x0030, B:19:0x0039, B:23:0x0044, B:27:0x004d, B:81:0x0131, B:82:0x0139), top: B:85:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:90:? A[RETURN, SYNTHETIC] */
    @Override // io.netty.handler.codec.ByteToMessageDecoder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        int i;
        Throwable th;
        ByteBuf byteBuf2;
        ByteBuf byteBufRetainedSlice;
        try {
            int i2 = C125041.f8882x8db84534[this.currentState.ordinal()];
            int i4 = 4;
            boolean z = true;
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        if (i2 != 4) {
                            throw new IllegalStateException();
                        }
                        byteBuf.skipBytes(byteBuf.readableBytes());
                        return;
                    }
                }
                i = this.chunkLength;
                if (byteBuf.readableBytes() >= i) {
                    return;
                }
                int i5 = byteBuf.readerIndex();
                int i6 = this.originalLength;
                ByteBuf byteBuf3 = null;
                try {
                    if (this.isCompressed) {
                        byteBufRetainedSlice = channelHandlerContext.alloc().buffer(i6);
                        try {
                            byteBuf2 = byteBuf;
                            int iDecompress = FastLz.decompress(byteBuf2, i5, i, byteBufRetainedSlice, byteBufRetainedSlice.writerIndex(), i6);
                            if (i6 != iDecompress) {
                                throw new DecompressionException(String.format("stream corrupted: originalLength(%d) and actual length(%d) mismatch", Integer.valueOf(i6), Integer.valueOf(iDecompress)));
                            }
                            byteBufRetainedSlice.writerIndex(byteBufRetainedSlice.writerIndex() + iDecompress);
                        } catch (Throwable th2) {
                            th = th2;
                            byteBuf3 = byteBufRetainedSlice;
                            if (byteBuf3 == null) {
                                throw th;
                            }
                            byteBuf3.release();
                            throw th;
                        }
                    } else {
                        byteBuf2 = byteBuf;
                        byteBufRetainedSlice = byteBuf2.retainedSlice(i5, i);
                    }
                    ByteBufChecksum byteBufChecksum = this.checksum;
                    if (this.hasChecksum && byteBufChecksum != null) {
                        byteBufChecksum.reset();
                        byteBufChecksum.update(byteBufRetainedSlice, byteBufRetainedSlice.readerIndex(), byteBufRetainedSlice.readableBytes());
                        int value = (int) byteBufChecksum.getValue();
                        if (value != this.currentChecksum) {
                            throw new DecompressionException(String.format("stream corrupted: mismatching checksum: %d (expected: %d)", Integer.valueOf(value), Integer.valueOf(this.currentChecksum)));
                        }
                    }
                    if (byteBufRetainedSlice.readableBytes() > 0) {
                        list.add(byteBufRetainedSlice);
                    } else {
                        byteBufRetainedSlice.release();
                    }
                    byteBuf2.skipBytes(i);
                    this.currentState = State.INIT_BLOCK;
                    return;
                } catch (Throwable th3) {
                    th = th3;
                }
            } else {
                if (byteBuf.readableBytes() < 4) {
                    return;
                }
                if (byteBuf.readUnsignedMedium() != 4607066) {
                    throw new DecompressionException("unexpected block identifier");
                }
                byte b = byteBuf.readByte();
                this.isCompressed = (b & 1) == 1;
                if ((b & 16) != 16) {
                    z = false;
                }
                this.hasChecksum = z;
                this.currentState = State.INIT_BLOCK_PARAMS;
            }
            int i7 = byteBuf.readableBytes();
            int i8 = 2 + (this.isCompressed ? 2 : 0);
            boolean z2 = this.hasChecksum;
            if (!z2) {
                i4 = 0;
            }
            if (i7 < i8 + i4) {
                return;
            }
            this.currentChecksum = z2 ? byteBuf.readInt() : 0;
            int unsignedShort = byteBuf.readUnsignedShort();
            this.chunkLength = unsignedShort;
            if (this.isCompressed) {
                unsignedShort = byteBuf.readUnsignedShort();
            }
            this.originalLength = unsignedShort;
            this.currentState = State.DECOMPRESS_DATA;
            i = this.chunkLength;
            if (byteBuf.readableBytes() >= i) {
            }
        } catch (Exception e) {
            this.currentState = State.CORRUPTED;
            throw e;
        }
    }

    public FastLzFrameDecoder(boolean z) {
        this(z ? new Adler32() : null);
    }

    public FastLzFrameDecoder(Checksum checksum) {
        this.currentState = State.INIT_BLOCK;
        this.checksum = checksum == null ? null : ByteBufChecksum.wrapChecksum(checksum);
    }
}
