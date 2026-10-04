package io.netty.handler.codec.compression;

import com.sun.imageio.plugins.jpeg.JPEG;
import io.netty.buffer.ByteBuf;
import org.apache.commons.beanutils.PropertyUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final class Snappy {
    private static final int COPY_1_BYTE_OFFSET = 1;
    private static final int COPY_2_BYTE_OFFSET = 2;
    private static final int COPY_4_BYTE_OFFSET = 3;
    private static final int LITERAL = 0;
    private static final int MAX_HT_SIZE = 16384;
    private static final int MIN_COMPRESSIBLE_BYTES = 15;
    private static final int NOT_ENOUGH_INPUT = -1;
    private static final int PREAMBLE_NOT_FULL = -1;
    private State state = State.READING_PREAMBLE;
    private byte tag;
    private int written;

    /* JADX INFO: renamed from: io.netty.handler.codec.compression.Snappy$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C125141 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$compression$Snappy$State;

        static {
            int[] iArr = new int[State.values().length];
            $SwitchMap$io$netty$handler$codec$compression$Snappy$State = iArr;
            try {
                iArr[State.READING_PREAMBLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$Snappy$State[State.READING_TAG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$Snappy$State[State.READING_LITERAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$Snappy$State[State.READING_COPY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum State {
        READING_PREAMBLE,
        READING_TAG,
        READING_LITERAL,
        READING_COPY
    }

    private static int bitsToEncode(int i) {
        int iHighestOneBit = Integer.highestOneBit(i);
        int i2 = 0;
        while (true) {
            iHighestOneBit >>= 1;
            if (iHighestOneBit == 0) {
                return i2;
            }
            i2++;
        }
    }

    public static int calculateChecksum(ByteBuf byteBuf) {
        return calculateChecksum(byteBuf, byteBuf.readerIndex(), byteBuf.readableBytes());
    }

    private static int decodeCopyWith1ByteOffset(byte b, ByteBuf byteBuf, ByteBuf byteBuf2, int i) {
        if (!byteBuf.isReadable()) {
            return -1;
        }
        int iWriterIndex = byteBuf2.writerIndex();
        int i2 = ((b & 28) >> 2) + 4;
        int unsignedByte = (((b & JPEG.APP0) << 8) >> 5) | byteBuf.readUnsignedByte();
        validateOffset(unsignedByte, i);
        byteBuf2.markReaderIndex();
        if (unsignedByte < i2) {
            for (int i4 = i2 / unsignedByte; i4 > 0; i4--) {
                byteBuf2.readerIndex(iWriterIndex - unsignedByte);
                byteBuf2.readBytes(byteBuf2, unsignedByte);
            }
            int i5 = i2 % unsignedByte;
            if (i5 != 0) {
                byteBuf2.readerIndex(iWriterIndex - unsignedByte);
                byteBuf2.readBytes(byteBuf2, i5);
            }
        } else {
            byteBuf2.readerIndex(iWriterIndex - unsignedByte);
            byteBuf2.readBytes(byteBuf2, i2);
        }
        byteBuf2.resetReaderIndex();
        return i2;
    }

    private static int decodeCopyWith2ByteOffset(byte b, ByteBuf byteBuf, ByteBuf byteBuf2, int i) {
        if (byteBuf.readableBytes() < 2) {
            return -1;
        }
        int iWriterIndex = byteBuf2.writerIndex();
        int i2 = ((b >> 2) & 63) + 1;
        int unsignedShortLE = byteBuf.readUnsignedShortLE();
        validateOffset(unsignedShortLE, i);
        byteBuf2.markReaderIndex();
        if (unsignedShortLE < i2) {
            for (int i4 = i2 / unsignedShortLE; i4 > 0; i4--) {
                byteBuf2.readerIndex(iWriterIndex - unsignedShortLE);
                byteBuf2.readBytes(byteBuf2, unsignedShortLE);
            }
            int i5 = i2 % unsignedShortLE;
            if (i5 != 0) {
                byteBuf2.readerIndex(iWriterIndex - unsignedShortLE);
                byteBuf2.readBytes(byteBuf2, i5);
            }
        } else {
            byteBuf2.readerIndex(iWriterIndex - unsignedShortLE);
            byteBuf2.readBytes(byteBuf2, i2);
        }
        byteBuf2.resetReaderIndex();
        return i2;
    }

    private static int decodeCopyWith4ByteOffset(byte b, ByteBuf byteBuf, ByteBuf byteBuf2, int i) {
        if (byteBuf.readableBytes() < 4) {
            return -1;
        }
        int iWriterIndex = byteBuf2.writerIndex();
        int i2 = ((b >> 2) & 63) + 1;
        int intLE = byteBuf.readIntLE();
        validateOffset(intLE, i);
        byteBuf2.markReaderIndex();
        if (intLE < i2) {
            for (int i4 = i2 / intLE; i4 > 0; i4--) {
                byteBuf2.readerIndex(iWriterIndex - intLE);
                byteBuf2.readBytes(byteBuf2, intLE);
            }
            int i5 = i2 % intLE;
            if (i5 != 0) {
                byteBuf2.readerIndex(iWriterIndex - intLE);
                byteBuf2.readBytes(byteBuf2, i5);
            }
        } else {
            byteBuf2.readerIndex(iWriterIndex - intLE);
            byteBuf2.readBytes(byteBuf2, i2);
        }
        byteBuf2.resetReaderIndex();
        return i2;
    }

    public static int decodeLiteral(byte b, ByteBuf byteBuf, ByteBuf byteBuf2) {
        byteBuf.markReaderIndex();
        int unsignedByte = (b >> 2) & 63;
        switch (unsignedByte) {
            case 60:
                if (!byteBuf.isReadable()) {
                    return -1;
                }
                unsignedByte = byteBuf.readUnsignedByte();
                break;
                break;
            case 61:
                if (byteBuf.readableBytes() < 2) {
                    return -1;
                }
                unsignedByte = byteBuf.readUnsignedShortLE();
                break;
            case 62:
                if (byteBuf.readableBytes() < 3) {
                    return -1;
                }
                unsignedByte = byteBuf.readUnsignedMediumLE();
                break;
            case 63:
                if (byteBuf.readableBytes() < 4) {
                    return -1;
                }
                unsignedByte = byteBuf.readIntLE();
                break;
        }
        int i = unsignedByte + 1;
        if (byteBuf.readableBytes() < i) {
            byteBuf.resetReaderIndex();
            return -1;
        }
        byteBuf2.writeBytes(byteBuf, i);
        return i;
    }

    private static void encodeCopy(ByteBuf byteBuf, int i, int i2) {
        while (i2 >= 68) {
            encodeCopyWithOffset(byteBuf, i, 64);
            i2 -= 64;
        }
        if (i2 > 64) {
            encodeCopyWithOffset(byteBuf, i, 60);
            i2 -= 60;
        }
        encodeCopyWithOffset(byteBuf, i, i2);
    }

    private static void encodeCopyWithOffset(ByteBuf byteBuf, int i, int i2) {
        if (i2 < 12 && i < 2048) {
            byteBuf.writeByte(((i2 - 4) << 2) | 1 | ((i >> 8) << 5));
            byteBuf.writeByte(i & 255);
        } else {
            byteBuf.writeByte(((i2 - 1) << 2) | 2);
            byteBuf.writeByte(i & 255);
            byteBuf.writeByte((i >> 8) & 255);
        }
    }

    public static void encodeLiteral(ByteBuf byteBuf, ByteBuf byteBuf2, int i) {
        if (i < 61) {
            byteBuf2.writeByte((i - 1) << 2);
        } else {
            int i2 = i - 1;
            int iBitsToEncode = bitsToEncode(i2) / 8;
            int i4 = iBitsToEncode + 1;
            byteBuf2.writeByte((iBitsToEncode + 60) << 2);
            for (int i5 = 0; i5 < i4; i5++) {
                byteBuf2.writeByte((i2 >> (i5 * 8)) & 255);
            }
        }
        byteBuf2.writeBytes(byteBuf, i);
    }

    private static int findMatchingLength(ByteBuf byteBuf, int i, int i2, int i4) {
        int i5 = 0;
        while (i2 <= i4 - 4 && byteBuf.getInt(i2) == byteBuf.getInt(i + i5)) {
            i2 += 4;
            i5 += 4;
        }
        while (i2 < i4 && byteBuf.getByte(i + i5) == byteBuf.getByte(i2)) {
            i2++;
            i5++;
        }
        return i5;
    }

    private static short[] getHashTable(int i) {
        int i2 = 256;
        while (i2 < 16384 && i2 < i) {
            i2 <<= 1;
        }
        return new short[i2];
    }

    private static int hash(ByteBuf byteBuf, int i, int i2) {
        return (byteBuf.getInt(i) * 506832829) >>> i2;
    }

    public static int maskChecksum(long j) {
        return (int) (((j << 17) | (j >> 15)) - 1568478504);
    }

    private static int readPreamble(ByteBuf byteBuf) {
        int i = 0;
        int i2 = 0;
        while (byteBuf.isReadable()) {
            short unsignedByte = byteBuf.readUnsignedByte();
            int i4 = i2 + 1;
            i |= (unsignedByte & 127) << (i2 * 7);
            if ((unsignedByte & 128) == 0) {
                return i;
            }
            if (i4 >= 4) {
                throw new DecompressionException("Preamble is greater than 4 bytes");
            }
            i2 = i4;
        }
        return 0;
    }

    public static void validateChecksum(int i, ByteBuf byteBuf) {
        validateChecksum(i, byteBuf, byteBuf.readerIndex(), byteBuf.readableBytes());
    }

    private static void validateOffset(int i, int i2) {
        if (i == 0) {
            throw new DecompressionException("Offset is less than minimum permissible value");
        }
        if (i < 0) {
            throw new DecompressionException("Offset is greater than maximum value supported by this implementation");
        }
        if (i > i2) {
            throw new DecompressionException("Offset exceeds size of chunk");
        }
    }

    public void decode(ByteBuf byteBuf, ByteBuf byteBuf2) {
        while (byteBuf.isReadable()) {
            int i = C125141.$SwitchMap$io$netty$handler$codec$compression$Snappy$State[this.state.ordinal()];
            if (i == 1) {
                int preamble = readPreamble(byteBuf);
                if (preamble == -1 || preamble == 0) {
                    return;
                }
                byteBuf2.ensureWritable(preamble);
                this.state = State.READING_TAG;
            } else if (i != 2) {
                if (i == 3) {
                    int iDecodeLiteral = decodeLiteral(this.tag, byteBuf, byteBuf2);
                    if (iDecodeLiteral == -1) {
                        return;
                    }
                    this.state = State.READING_TAG;
                    this.written += iDecodeLiteral;
                } else if (i == 4) {
                    byte b = this.tag;
                    int i2 = b & 3;
                    if (i2 == 1) {
                        int iDecodeCopyWith1ByteOffset = decodeCopyWith1ByteOffset(b, byteBuf, byteBuf2, this.written);
                        if (iDecodeCopyWith1ByteOffset == -1) {
                            return;
                        }
                        this.state = State.READING_TAG;
                        this.written += iDecodeCopyWith1ByteOffset;
                    } else if (i2 == 2) {
                        int iDecodeCopyWith2ByteOffset = decodeCopyWith2ByteOffset(b, byteBuf, byteBuf2, this.written);
                        if (iDecodeCopyWith2ByteOffset == -1) {
                            return;
                        }
                        this.state = State.READING_TAG;
                        this.written += iDecodeCopyWith2ByteOffset;
                    } else if (i2 == 3) {
                        int iDecodeCopyWith4ByteOffset = decodeCopyWith4ByteOffset(b, byteBuf, byteBuf2, this.written);
                        if (iDecodeCopyWith4ByteOffset == -1) {
                            return;
                        }
                        this.state = State.READING_TAG;
                        this.written += iDecodeCopyWith4ByteOffset;
                    } else {
                        continue;
                    }
                } else {
                    continue;
                }
            }
            if (!byteBuf.isReadable()) {
                return;
            }
            byte b5 = byteBuf.readByte();
            this.tag = b5;
            int i4 = b5 & 3;
            if (i4 == 0) {
                this.state = State.READING_LITERAL;
            } else if (i4 == 1 || i4 == 2 || i4 == 3) {
                this.state = State.READING_COPY;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0055, code lost:
    
        encodeLiteral(r13, r14, r3 - r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x005a, code lost:
    
        r4 = findMatchingLength(r13, r10 + 4, r3 + 4, r15) + 4;
        r5 = r3 + r4;
        encodeCopy(r14, r3 - r10, r4);
        r13.readerIndex(r13.readerIndex() + r4);
        r3 = r5 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0074, code lost:
    
        if (r5 < r8) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0077, code lost:
    
        r4 = r5 - r0;
        r1[hash(r13, r3, r2)] = (short) (r4 - 1);
        r3 = hash(r13, r5, r2);
        r10 = r0 + r1[r3];
        r1[r3] = (short) r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0095, code lost:
    
        if (r13.getInt(r5) == r13.getInt(r10)) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00a0, code lost:
    
        r3 = r5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void encode(ByteBuf byteBuf, ByteBuf byteBuf2, int i) {
        int i2;
        int i4 = 0;
        while (true) {
            i2 = i >>> (i4 * 7);
            if ((i2 & (-128)) == 0) {
                break;
            }
            byteBuf2.writeByte((i2 & 127) | 128);
            i4++;
        }
        byteBuf2.writeByte(i2);
        int i5 = byteBuf.readerIndex();
        short[] hashTable = getHashTable(i);
        int iNumberOfLeadingZeros = Integer.numberOfLeadingZeros(hashTable.length) + 1;
        if (i - i5 >= 15) {
            int i6 = i5 + 1;
            int iHash = hash(byteBuf, i6, iNumberOfLeadingZeros);
            int i7 = i5;
            loop1: while (true) {
                int i8 = 32;
                while (true) {
                    int i9 = i8 + 1;
                    int i10 = (i8 >> 5) + i6;
                    int i11 = i - 4;
                    if (i10 > i11) {
                        break loop1;
                    }
                    int iHash2 = hash(byteBuf, i10, iNumberOfLeadingZeros);
                    int i12 = hashTable[iHash] + i5;
                    hashTable[iHash] = (short) (i6 - i5);
                    if (byteBuf.getInt(i6) == byteBuf.getInt(i12)) {
                        break;
                    }
                    i6 = i10;
                    i8 = i9;
                    iHash = iHash2;
                }
                iHash = hash(byteBuf, i7 + 1, iNumberOfLeadingZeros);
                i6 = i7 + 1;
            }
            i5 = i7;
        }
        if (i5 < i) {
            encodeLiteral(byteBuf, byteBuf2, i - i5);
        }
    }

    public int getPreamble(ByteBuf byteBuf) {
        if (this.state != State.READING_PREAMBLE) {
            return 0;
        }
        int i = byteBuf.readerIndex();
        try {
            return readPreamble(byteBuf);
        } finally {
            byteBuf.readerIndex(i);
        }
    }

    public void reset() {
        this.state = State.READING_PREAMBLE;
        this.tag = (byte) 0;
        this.written = 0;
    }

    public static int calculateChecksum(ByteBuf byteBuf, int i, int i2) {
        Crc32c crc32c = new Crc32c();
        try {
            crc32c.update(byteBuf, i, i2);
            return maskChecksum(crc32c.getValue());
        } finally {
            crc32c.reset();
        }
    }

    public static void validateChecksum(int i, ByteBuf byteBuf, int i2, int i4) {
        int iCalculateChecksum = calculateChecksum(byteBuf, i2, i4);
        if (iCalculateChecksum == i) {
            return;
        }
        throw new DecompressionException("mismatching checksum: " + Integer.toHexString(iCalculateChecksum) + " (expected: " + Integer.toHexString(i) + PropertyUtils.MAPPED_DELIM2);
    }
}
