package io.netty.handler.codec.http.multipart;

import io.netty.buffer.ByteBuf;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
final class HttpPostBodyUtil {
    public static final String DEFAULT_BINARY_CONTENT_TYPE = "application/octet-stream";
    public static final String DEFAULT_TEXT_CONTENT_TYPE = "text/plain";
    public static final int chunkSize = 8096;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class SeekAheadOptimize {
        ByteBuf buffer;
        byte[] bytes;
        int limit;
        int origPos;
        int pos;
        int readerIndex;

        public SeekAheadOptimize(ByteBuf byteBuf) {
            if (!byteBuf.hasArray()) {
                throw new IllegalArgumentException("buffer hasn't backing byte array");
            }
            this.buffer = byteBuf;
            this.bytes = byteBuf.array();
            this.readerIndex = byteBuf.readerIndex();
            int iArrayOffset = byteBuf.arrayOffset() + this.readerIndex;
            this.pos = iArrayOffset;
            this.origPos = iArrayOffset;
            this.limit = byteBuf.writerIndex() + byteBuf.arrayOffset();
        }

        public int getReadPosition(int i) {
            return (i - this.origPos) + this.readerIndex;
        }

        public void setReadPosition(int i) {
            int i2 = this.pos - i;
            this.pos = i2;
            int readPosition = getReadPosition(i2);
            this.readerIndex = readPosition;
            this.buffer.readerIndex(readPosition);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum TransferEncodingMechanism {
        BIT7("7bit"),
        BIT8("8bit"),
        BINARY("binary");

        private final String value;

        TransferEncodingMechanism(String str) {
            this.value = str;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.value;
        }

        public String value() {
            return this.value;
        }
    }

    private HttpPostBodyUtil() {
    }

    public static int findDelimiter(ByteBuf byteBuf, int i, byte[] bArr, boolean z) {
        int iBytesBefore;
        int length = bArr.length;
        int i2 = byteBuf.readerIndex();
        int iWriterIndex = byteBuf.writerIndex() - i;
        loop0: while (true) {
            boolean z2 = true;
            while (z2 && length <= iWriterIndex && (iBytesBefore = byteBuf.bytesBefore(i, iWriterIndex, bArr[0])) >= 0) {
                i += iBytesBefore;
                iWriterIndex -= iBytesBefore;
                if (iWriterIndex >= length) {
                    int i4 = 0;
                    while (true) {
                        if (i4 >= length) {
                            z2 = false;
                            break;
                        }
                        if (byteBuf.getByte(i + i4) != bArr[i4]) {
                            i++;
                            iWriterIndex--;
                            z2 = true;
                            break;
                        }
                        i4++;
                    }
                }
                if (!z2) {
                    if (!z || i <= i2) {
                        break;
                    }
                    if (byteBuf.getByte(i - 1) == 10) {
                        int i5 = i - 1;
                        i = (i5 <= i2 || byteBuf.getByte(i + (-2)) != 13) ? i5 : i - 2;
                    } else {
                        i++;
                        iWriterIndex--;
                    }
                }
            }
            return -1;
        }
        return i - i2;
    }

    public static int findEndOfString(String str) {
        int length = str.length();
        while (length > 0 && Character.isWhitespace(str.charAt(length - 1))) {
            length--;
        }
        return length;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0015, code lost:
    
        r4 = 1;
     */
    /* JADX WARN: Removed duplicated region for block: B:11:0x001a  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x0012 A[PHI: r0
      0x0012: PHI (r0v6 int) = (r0v3 int), (r0v0 int) binds: [B:14:0x0029, B:5:0x0010] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x0029 -> B:6:0x0012). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int findLastLineBreak(ByteBuf byteBuf, int i) {
        int i2;
        int iFindLineBreak;
        int iFindLineBreak2 = findLineBreak(byteBuf, i);
        if (iFindLineBreak2 < 0) {
            i2 = 0;
            if (iFindLineBreak2 > 0) {
            }
            return iFindLineBreak2 - i2;
        }
        i2 = byteBuf.getByte(i + iFindLineBreak2) == 13 ? 2 : 1;
        iFindLineBreak2 += i2;
        if (iFindLineBreak2 > 0 || (iFindLineBreak = findLineBreak(byteBuf, i + iFindLineBreak2)) < 0) {
            return iFindLineBreak2 - i2;
        }
        iFindLineBreak2 += iFindLineBreak;
        if (byteBuf.getByte(i + iFindLineBreak2) == 13) {
        }
        iFindLineBreak2 += i2;
        if (iFindLineBreak2 > 0) {
        }
        return iFindLineBreak2 - i2;
    }

    public static int findLineBreak(ByteBuf byteBuf, int i) {
        int iBytesBefore = byteBuf.bytesBefore(i, byteBuf.readableBytes() - (i - byteBuf.readerIndex()), (byte) 10);
        if (iBytesBefore == -1) {
            return -1;
        }
        return (iBytesBefore <= 0 || byteBuf.getByte((i + iBytesBefore) + (-1)) != 13) ? iBytesBefore : iBytesBefore - 1;
    }

    public static int findNonWhitespace(String str, int i) {
        while (i < str.length() && Character.isWhitespace(str.charAt(i))) {
            i++;
        }
        return i;
    }
}
