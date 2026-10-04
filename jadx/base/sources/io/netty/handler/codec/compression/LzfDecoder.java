package io.netty.handler.codec.compression;

import com.ning.compress.BufferRecycler;
import com.ning.compress.lzf.ChunkDecoder;
import com.ning.compress.lzf.util.ChunkDecoderFactory;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class LzfDecoder extends ByteToMessageDecoder {
    private static final short MAGIC_NUMBER = 23126;
    private int chunkLength;
    private State currentState;
    private ChunkDecoder decoder;
    private boolean isCompressed;
    private int originalLength;
    private BufferRecycler recycler;

    /* JADX INFO: renamed from: io.netty.handler.codec.compression.LzfDecoder$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C125131 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$compression$LzfDecoder$State;

        static {
            int[] iArr = new int[State.values().length];
            $SwitchMap$io$netty$handler$codec$compression$LzfDecoder$State = iArr;
            try {
                iArr[State.INIT_BLOCK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$LzfDecoder$State[State.INIT_ORIGINAL_LENGTH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$LzfDecoder$State[State.DECOMPRESS_DATA.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$LzfDecoder$State[State.CORRUPTED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum State {
        INIT_BLOCK,
        INIT_ORIGINAL_LENGTH,
        DECOMPRESS_DATA,
        CORRUPTED
    }

    public LzfDecoder() {
        this(false);
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x0099 A[Catch: Exception -> 0x0026, TryCatch #1 {Exception -> 0x0026, blocks: (B:3:0x0007, B:10:0x001e, B:14:0x002a, B:15:0x002f, B:38:0x0090, B:41:0x0099, B:43:0x009f, B:45:0x00a9, B:48:0x00c0, B:50:0x00ce, B:61:0x0103, B:63:0x0109, B:68:0x011c, B:64:0x010f, B:65:0x0112, B:52:0x00de, B:47:0x00b5, B:67:0x0115, B:32:0x007d, B:35:0x0084, B:37:0x008c, B:70:0x0121, B:71:0x0136, B:16:0x0030, B:19:0x0038, B:21:0x0040, B:24:0x0048, B:28:0x0072, B:72:0x0137, B:73:0x014c, B:25:0x004f, B:26:0x006b, B:27:0x006c, B:74:0x014d, B:75:0x0155, B:54:0x00e1, B:56:0x00ee, B:60:0x00fd, B:59:0x00fa), top: B:80:0x0007, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:83:? A[RETURN, SYNTHETIC] */
    @Override // io.netty.handler.codec.ByteToMessageDecoder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        int i;
        byte[] bArrAllocInputBuffer;
        int iArrayOffset;
        byte[] bArrArray;
        try {
            int i2 = C125131.$SwitchMap$io$netty$handler$codec$compression$LzfDecoder$State[this.currentState.ordinal()];
            int iWriterIndex = 0;
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
                int i4 = this.originalLength;
                if (this.isCompressed) {
                    int i5 = byteBuf.readerIndex();
                    if (byteBuf.hasArray()) {
                        bArrAllocInputBuffer = byteBuf.array();
                        iArrayOffset = byteBuf.arrayOffset() + i5;
                    } else {
                        bArrAllocInputBuffer = this.recycler.allocInputBuffer(i);
                        byteBuf.getBytes(i5, bArrAllocInputBuffer, 0, i);
                        iArrayOffset = 0;
                    }
                    byte[] bArr = bArrAllocInputBuffer;
                    ByteBuf byteBufHeapBuffer = channelHandlerContext.alloc().heapBuffer(i4, i4);
                    if (byteBufHeapBuffer.hasArray()) {
                        bArrArray = byteBufHeapBuffer.array();
                        iWriterIndex = byteBufHeapBuffer.writerIndex() + byteBufHeapBuffer.arrayOffset();
                    } else {
                        bArrArray = new byte[i4];
                    }
                    byte[] bArr2 = bArrArray;
                    int i6 = iWriterIndex;
                    try {
                        this.decoder.decodeChunk(bArr, iArrayOffset, bArr2, i6, i6 + i4);
                        if (byteBufHeapBuffer.hasArray()) {
                            byteBufHeapBuffer.writerIndex(byteBufHeapBuffer.writerIndex() + i4);
                        } else {
                            byteBufHeapBuffer.writeBytes(bArr2);
                        }
                        list.add(byteBufHeapBuffer);
                        byteBuf.skipBytes(i);
                        if (!byteBuf.hasArray()) {
                            this.recycler.releaseInputBuffer(bArr);
                        }
                    } catch (Throwable th) {
                        byteBufHeapBuffer.release();
                        throw th;
                    }
                } else if (i > 0) {
                    list.add(byteBuf.readRetainedSlice(i));
                }
                this.currentState = State.INIT_BLOCK;
                return;
            }
            if (byteBuf.readableBytes() < 5) {
                return;
            }
            if (byteBuf.readUnsignedShort() != 23126) {
                throw new DecompressionException("unexpected block identifier");
            }
            byte b = byteBuf.readByte();
            if (b == 0) {
                this.isCompressed = false;
                this.currentState = State.DECOMPRESS_DATA;
            } else {
                if (b != 1) {
                    throw new DecompressionException(String.format("unknown type of chunk: %d (expected: %d or %d)", Integer.valueOf(b), 0, 1));
                }
                this.isCompressed = true;
                this.currentState = State.INIT_ORIGINAL_LENGTH;
            }
            int unsignedShort = byteBuf.readUnsignedShort();
            this.chunkLength = unsignedShort;
            if (unsignedShort > 65535) {
                throw new DecompressionException(String.format("chunk length exceeds maximum: %d (expected: =< %d)", Integer.valueOf(this.chunkLength), 65535));
            }
            if (b != 1) {
                return;
            }
            if (byteBuf.readableBytes() < 2) {
                return;
            }
            int unsignedShort2 = byteBuf.readUnsignedShort();
            this.originalLength = unsignedShort2;
            if (unsignedShort2 > 65535) {
                throw new DecompressionException(String.format("original length exceeds maximum: %d (expected: =< %d)", Integer.valueOf(this.chunkLength), 65535));
            }
            this.currentState = State.DECOMPRESS_DATA;
            i = this.chunkLength;
            if (byteBuf.readableBytes() >= i) {
            }
        } catch (Exception e) {
            this.currentState = State.CORRUPTED;
            this.decoder = null;
            this.recycler = null;
            throw e;
        }
    }

    public LzfDecoder(boolean z) {
        this.currentState = State.INIT_BLOCK;
        this.decoder = z ? ChunkDecoderFactory.safeInstance() : ChunkDecoderFactory.optimalInstance();
        this.recycler = BufferRecycler.instance();
    }
}
