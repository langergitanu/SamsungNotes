package io.netty.handler.codec.compression;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class Bzip2Decoder extends ByteToMessageDecoder {
    private int blockCRC;
    private Bzip2BlockDecompressor blockDecompressor;
    private int blockSize;
    private Bzip2HuffmanStageDecoder huffmanStageDecoder;
    private int streamCRC;
    private State currentState = State.INIT;
    private final Bzip2BitReader reader = new Bzip2BitReader();

    /* JADX INFO: renamed from: io.netty.handler.codec.compression.Bzip2Decoder$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C124991 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$compression$Bzip2Decoder$State;

        static {
            int[] iArr = new int[State.values().length];
            $SwitchMap$io$netty$handler$codec$compression$Bzip2Decoder$State = iArr;
            try {
                iArr[State.INIT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$Bzip2Decoder$State[State.INIT_BLOCK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$Bzip2Decoder$State[State.INIT_BLOCK_PARAMS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$Bzip2Decoder$State[State.RECEIVE_HUFFMAN_USED_MAP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$Bzip2Decoder$State[State.RECEIVE_HUFFMAN_USED_BITMAPS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$Bzip2Decoder$State[State.RECEIVE_SELECTORS_NUMBER.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$Bzip2Decoder$State[State.RECEIVE_SELECTORS.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$Bzip2Decoder$State[State.RECEIVE_HUFFMAN_LENGTH.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$Bzip2Decoder$State[State.DECODE_HUFFMAN_DATA.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$Bzip2Decoder$State[State.EOF.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum State {
        INIT,
        INIT_BLOCK,
        INIT_BLOCK_PARAMS,
        RECEIVE_HUFFMAN_USED_MAP,
        RECEIVE_HUFFMAN_USED_BITMAPS,
        RECEIVE_SELECTORS_NUMBER,
        RECEIVE_SELECTORS,
        RECEIVE_HUFFMAN_LENGTH,
        DECODE_HUFFMAN_DATA,
        EOF
    }

    /* JADX WARN: Code restructure failed: missing block: B:101:0x01a8, code lost:
    
        if (r8.isReadable() != false) goto L103;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x01ab, code lost:
    
        if (r7 != false) goto L108;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x01b1, code lost:
    
        if (r8.readBoolean() == false) goto L189;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x01b4, code lost:
    
        r4[r9][r10] = (byte) r6;
        r10 = r10 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x01c0, code lost:
    
        if (r8.isReadable() != false) goto L111;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x01c2, code lost:
    
        r7 = true;
        r11 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x01c9, code lost:
    
        if (r8.readBoolean() == false) goto L114;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x01cb, code lost:
    
        r7 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x01cd, code lost:
    
        r7 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x01ce, code lost:
    
        r6 = r6 + r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x01d3, code lost:
    
        if (r8.isReadable() != false) goto L118;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x01d5, code lost:
    
        r7 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x01d7, code lost:
    
        r7 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x01d9, code lost:
    
        r2.currentAlpha = 0;
        r9 = r9 + 1;
        r7 = false;
        r6 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x01e0, code lost:
    
        r10 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x01e1, code lost:
    
        if (r11 == false) goto L124;
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x01e3, code lost:
    
        r2.currentGroup = r9;
        r2.currentLength = r6;
        r2.currentAlpha = r10;
        r2.modifyLength = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x01eb, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x01ec, code lost:
    
        r2.createHuffmanDecodingTables();
        r16.currentState = io.netty.handler.codec.compression.Bzip2Decoder.State.DECODE_HUFFMAN_DATA;
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x01f3, code lost:
    
        r2 = r16.blockDecompressor;
        r3 = r18.readerIndex();
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x01ff, code lost:
    
        if (r2.decodeHuffmanData(r16.huffmanStageDecoder) != false) goto L128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x0201, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x0206, code lost:
    
        if (r18.readerIndex() != r3) goto L133;
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x020c, code lost:
    
        if (r18.isReadable() == false) goto L133;
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x020e, code lost:
    
        r8.refill();
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x0211, code lost:
    
        r3 = r17.alloc().buffer(r2.blockLength());
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x021d, code lost:
    
        r0 = r2.read();
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x0221, code lost:
    
        if (r0 < 0) goto L190;
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x0223, code lost:
    
        r3.writeByte(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x0227, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x0229, code lost:
    
        r16.currentState = io.netty.handler.codec.compression.Bzip2Decoder.State.INIT_BLOCK;
        r0 = r2.checkCRC();
        r2 = r16.streamCRC;
        r16.streamCRC = r0 ^ ((r2 >>> 31) | (r2 << 1));
        r19.add(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x0240, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:141:0x0241, code lost:
    
        if (r3 != null) goto L142;
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x0243, code lost:
    
        r3.release();
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x0246, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x024e, code lost:
    
        throw new io.netty.handler.codec.compression.DecompressionException("incorrect selectors number");
     */
    /* JADX WARN: Code restructure failed: missing block: B:147:0x0256, code lost:
    
        throw new io.netty.handler.codec.compression.DecompressionException("incorrect alphabet size");
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x025e, code lost:
    
        throw new io.netty.handler.codec.compression.DecompressionException("incorrect huffman groups number");
     */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x0266, code lost:
    
        throw new io.netty.handler.codec.compression.DecompressionException("bad block header");
     */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x026e, code lost:
    
        throw new io.netty.handler.codec.compression.DecompressionException("block size is invalid");
     */
    /* JADX WARN: Code restructure failed: missing block: B:192:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:193:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:194:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:195:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0092, code lost:
    
        if (r2 != 3227993) goto L150;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0097, code lost:
    
        if (r4 != 2511705) goto L150;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0099, code lost:
    
        r16.blockCRC = r8.readInt();
        r16.currentState = io.netty.handler.codec.compression.Bzip2Decoder.State.INIT_BLOCK_PARAMS;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00a9, code lost:
    
        if (r8.hasReadableBits(25) != false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00ad, code lost:
    
        r16.blockDecompressor = new io.netty.handler.codec.compression.Bzip2BlockDecompressor(r16.blockSize, r16.blockCRC, r8.readBoolean(), r8.readBits(24), r8);
        r16.currentState = io.netty.handler.codec.compression.Bzip2Decoder.State.RECEIVE_HUFFMAN_USED_MAP;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00c8, code lost:
    
        if (r8.hasReadableBits(16) != false) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00cc, code lost:
    
        r16.blockDecompressor.huffmanInUse16 = r8.readBits(16);
        r16.currentState = io.netty.handler.codec.compression.Bzip2Decoder.State.RECEIVE_HUFFMAN_USED_BITMAPS;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00d8, code lost:
    
        r2 = r16.blockDecompressor;
        r3 = r2.huffmanInUse16;
        r4 = java.lang.Integer.bitCount(r3);
        r5 = r2.huffmanSymbolMap;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00ea, code lost:
    
        if (r8.hasReadableBits((r4 * 16) + 3) != false) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00ee, code lost:
    
        if (r4 <= 0) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00f0, code lost:
    
        r4 = 0;
        r6 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00f2, code lost:
    
        if (r4 >= r10) goto L175;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00f9, code lost:
    
        if (((32768 >>> r4) & r3) == 0) goto L176;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00fb, code lost:
    
        r13 = r4 << 4;
        r14 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00fe, code lost:
    
        if (r14 >= r10) goto L177;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0104, code lost:
    
        if (r8.readBoolean() == false) goto L179;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0106, code lost:
    
        r5[r6] = (byte) r13;
        r6 = r6 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x010c, code lost:
    
        r14 = r14 + 1;
        r13 = r13 + 1;
        r10 = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0113, code lost:
    
        r4 = r4 + 1;
        r10 = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0118, code lost:
    
        r6 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0119, code lost:
    
        r2.huffmanEndOfBlockSymbol = r6 + 1;
        r2 = r8.readBits(3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0122, code lost:
    
        if (r2 < 2) goto L148;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0124, code lost:
    
        if (r2 > 6) goto L148;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0126, code lost:
    
        r6 = r6 + 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0129, code lost:
    
        if (r6 > 258) goto L146;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x012b, code lost:
    
        r16.huffmanStageDecoder = new io.netty.handler.codec.compression.Bzip2HuffmanStageDecoder(r8, r2, r6);
        r16.currentState = io.netty.handler.codec.compression.Bzip2Decoder.State.RECEIVE_SELECTORS_NUMBER;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x013c, code lost:
    
        if (r8.hasReadableBits(15) != false) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0140, code lost:
    
        r2 = r8.readBits(15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0144, code lost:
    
        if (r2 < 1) goto L144;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0148, code lost:
    
        if (r2 > 18002) goto L144;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x014a, code lost:
    
        r16.huffmanStageDecoder.selectors = new byte[r2];
        r16.currentState = io.netty.handler.codec.compression.Bzip2Decoder.State.RECEIVE_SELECTORS;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0154, code lost:
    
        r2 = r16.huffmanStageDecoder;
        r3 = r2.selectors;
        r4 = r3.length;
        r5 = r2.tableMTF;
        r6 = r2.currentSelector;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x015d, code lost:
    
        if (r6 >= r4) goto L181;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0163, code lost:
    
        if (r8.hasReadableBits(6) != false) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0165, code lost:
    
        r2.currentSelector = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0167, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0168, code lost:
    
        r7 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x016d, code lost:
    
        if (r8.readBoolean() == false) goto L182;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x016f, code lost:
    
        r7 = r7 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0172, code lost:
    
        r3[r6] = r5.indexToFront(r7);
        r6 = r6 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x017b, code lost:
    
        r16.currentState = io.netty.handler.codec.compression.Bzip2Decoder.State.RECEIVE_HUFFMAN_LENGTH;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x017f, code lost:
    
        r2 = r16.huffmanStageDecoder;
        r3 = r2.totalTables;
        r4 = r2.tableCodeLengths;
        r5 = r2.alphabetSize;
        r6 = r2.currentLength;
        r7 = r2.modifyLength;
        r9 = r2.currentGroup;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x018d, code lost:
    
        if (r9 >= r3) goto L186;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x0194, code lost:
    
        if (r8.hasReadableBits(5) != false) goto L95;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x0196, code lost:
    
        r10 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x0197, code lost:
    
        r11 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0199, code lost:
    
        if (r6 >= 0) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x019b, code lost:
    
        r6 = r8.readBits(5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x019f, code lost:
    
        r10 = r2.currentAlpha;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x01a2, code lost:
    
        if (r10 >= r5) goto L188;
     */
    @Override // io.netty.handler.codec.ByteToMessageDecoder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) {
        if (byteBuf.isReadable()) {
            Bzip2BitReader bzip2BitReader = this.reader;
            bzip2BitReader.setByteBuf(byteBuf);
            while (true) {
                int i = 16;
                boolean z = false;
                switch (C124991.$SwitchMap$io$netty$handler$codec$compression$Bzip2Decoder$State[this.currentState.ordinal()]) {
                    case 1:
                        if (byteBuf.readableBytes() < 4) {
                            return;
                        }
                        if (byteBuf.readUnsignedMedium() != 4348520) {
                            throw new DecompressionException("Unexpected stream identifier contents. Mismatched bzip2 protocol version?");
                        }
                        int i2 = byteBuf.readByte() - 48;
                        if (i2 >= 1 && i2 <= 9) {
                            this.blockSize = i2 * 100000;
                            this.streamCRC = 0;
                            this.currentState = State.INIT_BLOCK;
                        }
                        break;
                    case 2:
                        if (!bzip2BitReader.hasReadableBytes(10)) {
                            return;
                        }
                        int bits = bzip2BitReader.readBits(24);
                        int bits2 = bzip2BitReader.readBits(24);
                        if (bits == 1536581 && bits2 == 3690640) {
                            if (bzip2BitReader.readInt() != this.streamCRC) {
                                throw new DecompressionException("stream CRC error");
                            }
                            this.currentState = State.EOF;
                        }
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    case 6:
                        break;
                    case 7:
                        break;
                    case 8:
                        break;
                    case 9:
                        break;
                    case 10:
                        byteBuf.skipBytes(byteBuf.readableBytes());
                        return;
                    default:
                        throw new IllegalStateException();
                }
            }
        }
    }

    public boolean isClosed() {
        return this.currentState == State.EOF;
    }
}
