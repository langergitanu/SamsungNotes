package org.brotli.dec;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
final class BitReader {
    private static final int BYTE_BUFFER_SIZE = 4160;
    private static final int BYTE_READ_SIZE = 4096;
    private static final int CAPACITY = 1024;
    private static final int INT_BUFFER_SIZE = 1040;
    private static final int SLACK = 16;
    long accumulator;
    int bitOffset;
    private boolean endOfStreamReached;
    private InputStream input;
    private int intOffset;
    private final byte[] byteBuffer = new byte[BYTE_BUFFER_SIZE];
    private final int[] intBuffer = new int[INT_BUFFER_SIZE];
    private final IntReader intReader = new IntReader();
    private int tailBytes = 0;

    public static void checkHealth(BitReader bitReader, boolean z) {
        if (bitReader.endOfStreamReached) {
            int i = ((bitReader.intOffset << 2) + ((bitReader.bitOffset + 7) >> 3)) - 8;
            int i2 = bitReader.tailBytes;
            if (i > i2) {
                throw new BrotliRuntimeException("Read after end");
            }
            if (z && i != i2) {
                throw new BrotliRuntimeException("Unused bytes after end");
            }
        }
    }

    public static void close(BitReader bitReader) throws IOException {
        InputStream inputStream = bitReader.input;
        bitReader.input = null;
        if (inputStream != null) {
            inputStream.close();
        }
    }

    public static void copyBytes(BitReader bitReader, byte[] bArr, int i, int i2) {
        if ((bitReader.bitOffset & 7) != 0) {
            throw new BrotliRuntimeException("Unaligned copyBytes");
        }
        while (true) {
            int i4 = bitReader.bitOffset;
            if (i4 == 64 || i2 == 0) {
                break;
            }
            bArr[i] = (byte) (bitReader.accumulator >>> i4);
            bitReader.bitOffset = i4 + 8;
            i2--;
            i++;
        }
        if (i2 == 0) {
            return;
        }
        int iMin = Math.min(intAvailable(bitReader), i2 >> 2);
        if (iMin > 0) {
            int i5 = iMin << 2;
            System.arraycopy(bitReader.byteBuffer, bitReader.intOffset << 2, bArr, i, i5);
            i += i5;
            i2 -= i5;
            bitReader.intOffset += iMin;
        }
        if (i2 == 0) {
            return;
        }
        if (intAvailable(bitReader) <= 0) {
            while (i2 > 0) {
                try {
                    int i6 = bitReader.input.read(bArr, i, i2);
                    if (i6 == -1) {
                        throw new BrotliRuntimeException("Unexpected end of input");
                    }
                    i += i6;
                    i2 -= i6;
                } catch (IOException e) {
                    throw new BrotliRuntimeException("Failed to read input", e);
                }
            }
            return;
        }
        fillBitWindow(bitReader);
        while (i2 != 0) {
            long j = bitReader.accumulator;
            int i7 = bitReader.bitOffset;
            bArr[i] = (byte) (j >>> i7);
            bitReader.bitOffset = i7 + 8;
            i2--;
            i++;
        }
        checkHealth(bitReader, false);
    }

    public static void fillBitWindow(BitReader bitReader) {
        int i = bitReader.bitOffset;
        if (i >= 32) {
            int[] iArr = bitReader.intBuffer;
            int i2 = bitReader.intOffset;
            bitReader.intOffset = i2 + 1;
            bitReader.accumulator = (((long) iArr[i2]) << 32) | (bitReader.accumulator >>> 32);
            bitReader.bitOffset = i - 32;
        }
    }

    public static void init(BitReader bitReader, InputStream inputStream) {
        if (bitReader.input != null) {
            throw new IllegalStateException("Bit reader already has associated input stream");
        }
        IntReader.init(bitReader.intReader, bitReader.byteBuffer, bitReader.intBuffer);
        bitReader.input = inputStream;
        bitReader.accumulator = 0L;
        bitReader.bitOffset = 64;
        bitReader.intOffset = 1024;
        bitReader.endOfStreamReached = false;
        prepare(bitReader);
    }

    public static int intAvailable(BitReader bitReader) {
        return (bitReader.endOfStreamReached ? (bitReader.tailBytes + 3) >> 2 : 1024) - bitReader.intOffset;
    }

    public static void jumpToByteBoundary(BitReader bitReader) {
        int i = (64 - bitReader.bitOffset) & 7;
        if (i != 0 && readBits(bitReader, i) != 0) {
            throw new BrotliRuntimeException("Corrupted padding bits");
        }
    }

    private static void prepare(BitReader bitReader) {
        readMoreInput(bitReader);
        checkHealth(bitReader, false);
        fillBitWindow(bitReader);
        fillBitWindow(bitReader);
    }

    public static int readBits(BitReader bitReader, int i) {
        fillBitWindow(bitReader);
        long j = bitReader.accumulator;
        int i2 = bitReader.bitOffset;
        int i4 = ((int) (j >>> i2)) & ((1 << i) - 1);
        bitReader.bitOffset = i2 + i;
        return i4;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0037, code lost:
    
        r4.endOfStreamReached = true;
        r4.tailBytes = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x003c, code lost:
    
        r1 = r1 + 3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void readMoreInput(BitReader bitReader) {
        int i = bitReader.intOffset;
        if (i <= 1015) {
            return;
        }
        if (bitReader.endOfStreamReached) {
            if (intAvailable(bitReader) < -2) {
                throw new BrotliRuntimeException("No more input");
            }
            return;
        }
        int i2 = i << 2;
        int i4 = 4096 - i2;
        byte[] bArr = bitReader.byteBuffer;
        System.arraycopy(bArr, i2, bArr, 0, i4);
        bitReader.intOffset = 0;
        while (true) {
            if (i4 >= 4096) {
                break;
            }
            try {
                int i5 = bitReader.input.read(bitReader.byteBuffer, i4, 4096 - i4);
                if (i5 <= 0) {
                    break;
                } else {
                    i4 += i5;
                }
            } catch (IOException e) {
                throw new BrotliRuntimeException("Failed to read input", e);
            }
        }
        IntReader.convert(bitReader.intReader, i4 >> 2);
    }

    public static void reload(BitReader bitReader) {
        if (bitReader.bitOffset == 64) {
            prepare(bitReader);
        }
    }
}
