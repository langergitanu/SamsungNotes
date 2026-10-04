package com.fasterxml.jackson.core.util;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class BufferRecycler {
    public static final int DEFAULT_WRITE_CONCAT_BUFFER_LEN = 2000;
    protected final byte[][] _byteBuffers = new byte[ByteBufferType.values().length][];
    protected final char[][] _charBuffers = new char[CharBufferType.values().length][];

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum ByteBufferType {
        READ_IO_BUFFER(4000),
        WRITE_ENCODING_BUFFER(4000),
        WRITE_CONCAT_BUFFER(2000),
        BASE64_CODEC_BUFFER(2000);

        protected final int size;

        ByteBufferType(int i) {
            this.size = i;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum CharBufferType {
        TOKEN_BUFFER(2000),
        CONCAT_BUFFER(2000),
        TEXT_BUFFER(200),
        NAME_COPY_BUFFER(200);

        protected final int size;

        CharBufferType(int i) {
            this.size = i;
        }
    }

    private byte[] balloc(int i) {
        return new byte[i];
    }

    private char[] calloc(int i) {
        return new char[i];
    }

    public final byte[] allocByteBuffer(ByteBufferType byteBufferType) {
        int iOrdinal = byteBufferType.ordinal();
        byte[][] bArr = this._byteBuffers;
        byte[] bArr2 = bArr[iOrdinal];
        if (bArr2 == null) {
            return balloc(byteBufferType.size);
        }
        bArr[iOrdinal] = null;
        return bArr2;
    }

    public final char[] allocCharBuffer(CharBufferType charBufferType) {
        return allocCharBuffer(charBufferType, 0);
    }

    public final void releaseByteBuffer(ByteBufferType byteBufferType, byte[] bArr) {
        this._byteBuffers[byteBufferType.ordinal()] = bArr;
    }

    public final void releaseCharBuffer(CharBufferType charBufferType, char[] cArr) {
        this._charBuffers[charBufferType.ordinal()] = cArr;
    }

    public final char[] allocCharBuffer(CharBufferType charBufferType, int i) {
        int i2 = charBufferType.size;
        if (i2 > i) {
            i = i2;
        }
        int iOrdinal = charBufferType.ordinal();
        char[][] cArr = this._charBuffers;
        char[] cArr2 = cArr[iOrdinal];
        if (cArr2 == null || cArr2.length < i) {
            return calloc(i);
        }
        cArr[iOrdinal] = null;
        return cArr2;
    }
}
