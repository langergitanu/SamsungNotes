package com.google.api.client.repackaged.org.apache.commons.codec.binary;

import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.spr.drawable.document.attribute.SprAttributeBase;
import com.yubico.yubikit.core.fido.CtapException;
import java.math.BigInteger;
import okio.Utf8;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class Base64 extends BaseNCodec {
    private static final int BITS_PER_ENCODED_BYTE = 6;
    private static final int BYTES_PER_ENCODED_BLOCK = 4;
    private static final int BYTES_PER_UNENCODED_BLOCK = 3;
    private static final int MASK_6BITS = 63;
    private int bitWorkArea;
    private final int decodeSize;
    private final byte[] decodeTable;
    private final int encodeSize;
    private final byte[] encodeTable;
    private final byte[] lineSeparator;
    static final byte[] CHUNK_SEPARATOR = {13, 10};
    private static final byte[] STANDARD_ENCODE_TABLE = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, SprAttributeBase.TYPE_ANIMATOR_SET, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, SprAttributeBase.TYPE_SHADOW, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, CtapException.ERR_PIN_BLOCKED, CtapException.ERR_PIN_AUTH_INVALID, CtapException.ERR_PIN_AUTH_BLOCKED, CtapException.ERR_PIN_NOT_SET, CtapException.ERR_PIN_REQUIRED, CtapException.ERR_PIN_POLICY_VIOLATION, CtapException.ERR_PIN_TOKEN_EXPIRED, CtapException.ERR_REQUEST_TOO_LARGE, 43, 47};
    private static final byte[] URL_SAFE_ENCODE_TABLE = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, SprAttributeBase.TYPE_ANIMATOR_SET, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, SprAttributeBase.TYPE_SHADOW, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, CtapException.ERR_PIN_BLOCKED, CtapException.ERR_PIN_AUTH_INVALID, CtapException.ERR_PIN_AUTH_BLOCKED, CtapException.ERR_PIN_NOT_SET, CtapException.ERR_PIN_REQUIRED, CtapException.ERR_PIN_POLICY_VIOLATION, CtapException.ERR_PIN_TOKEN_EXPIRED, CtapException.ERR_REQUEST_TOO_LARGE, 45, 95};
    private static final byte[] DECODE_TABLE = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, 62, -1, Utf8.REPLACEMENT_BYTE, CtapException.ERR_PIN_AUTH_BLOCKED, CtapException.ERR_PIN_NOT_SET, CtapException.ERR_PIN_REQUIRED, CtapException.ERR_PIN_POLICY_VIOLATION, CtapException.ERR_PIN_TOKEN_EXPIRED, CtapException.ERR_REQUEST_TOO_LARGE, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, Utf8.REPLACEMENT_BYTE, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, CtapException.ERR_PIN_BLOCKED, CtapException.ERR_PIN_AUTH_INVALID};

    public Base64() {
        this(0);
    }

    public static byte[] decodeBase64(String str) {
        return new Base64().decode(str);
    }

    public static BigInteger decodeInteger(byte[] bArr) {
        return new BigInteger(1, decodeBase64(bArr));
    }

    public static byte[] encodeBase64(byte[] bArr) {
        return encodeBase64(bArr, false);
    }

    public static byte[] encodeBase64Chunked(byte[] bArr) {
        return encodeBase64(bArr, true);
    }

    public static String encodeBase64String(byte[] bArr) {
        return StringUtils.newStringUtf8(encodeBase64(bArr, false));
    }

    public static byte[] encodeBase64URLSafe(byte[] bArr) {
        return encodeBase64(bArr, false, true);
    }

    public static String encodeBase64URLSafeString(byte[] bArr) {
        return StringUtils.newStringUtf8(encodeBase64(bArr, false, true));
    }

    public static byte[] encodeInteger(BigInteger bigInteger) {
        if (bigInteger != null) {
            return encodeBase64(toIntegerBytes(bigInteger), false);
        }
        throw new NullPointerException("encodeInteger called with null parameter");
    }

    public static boolean isArrayByteBase64(byte[] bArr) {
        return isBase64(bArr);
    }

    public static boolean isBase64(byte b) {
        if (b == 61) {
            return true;
        }
        if (b < 0) {
            return false;
        }
        byte[] bArr = DECODE_TABLE;
        return b < bArr.length && bArr[b] != -1;
    }

    public static byte[] toIntegerBytes(BigInteger bigInteger) {
        int iBitLength = ((bigInteger.bitLength() + 7) >> 3) << 3;
        byte[] byteArray = bigInteger.toByteArray();
        int i = 1;
        if (bigInteger.bitLength() % 8 != 0 && (bigInteger.bitLength() / 8) + 1 == iBitLength / 8) {
            return byteArray;
        }
        int length = byteArray.length;
        if (bigInteger.bitLength() % 8 == 0) {
            length--;
        } else {
            i = 0;
        }
        int i2 = iBitLength / 8;
        int i4 = i2 - length;
        byte[] bArr = new byte[i2];
        System.arraycopy(byteArray, i, bArr, i4, length);
        return bArr;
    }

    @Override // com.google.api.client.repackaged.org.apache.commons.codec.binary.BaseNCodec
    public void decode(byte[] bArr, int i, int i2) {
        byte b;
        if (this.eof) {
            return;
        }
        if (i2 < 0) {
            this.eof = true;
        }
        int i4 = 0;
        while (true) {
            if (i4 >= i2) {
                break;
            }
            ensureBufferSize(this.decodeSize);
            int i5 = i + 1;
            byte b5 = bArr[i];
            if (b5 == 61) {
                this.eof = true;
                break;
            }
            if (b5 >= 0) {
                byte[] bArr2 = DECODE_TABLE;
                if (b5 < bArr2.length && (b = bArr2[b5]) >= 0) {
                    int i6 = (this.modulus + 1) % 4;
                    this.modulus = i6;
                    int i7 = (this.bitWorkArea << 6) + b;
                    this.bitWorkArea = i7;
                    if (i6 == 0) {
                        byte[] bArr3 = this.buffer;
                        int i8 = this.pos;
                        int i9 = i8 + 1;
                        this.pos = i9;
                        bArr3[i8] = (byte) ((i7 >> 16) & 255);
                        int i10 = i8 + 2;
                        this.pos = i10;
                        bArr3[i9] = (byte) ((i7 >> 8) & 255);
                        this.pos = i8 + 3;
                        bArr3[i10] = (byte) (i7 & 255);
                    }
                }
            }
            i4++;
            i = i5;
        }
        if (!this.eof || this.modulus == 0) {
            return;
        }
        ensureBufferSize(this.decodeSize);
        int i11 = this.modulus;
        if (i11 == 2) {
            int i12 = this.bitWorkArea >> 4;
            this.bitWorkArea = i12;
            byte[] bArr4 = this.buffer;
            int i13 = this.pos;
            this.pos = i13 + 1;
            bArr4[i13] = (byte) (i12 & 255);
            return;
        }
        if (i11 != 3) {
            return;
        }
        int i14 = this.bitWorkArea;
        int i15 = i14 >> 2;
        this.bitWorkArea = i15;
        byte[] bArr5 = this.buffer;
        int i16 = this.pos;
        int i17 = i16 + 1;
        this.pos = i17;
        bArr5[i16] = (byte) ((i14 >> 10) & 255);
        this.pos = i16 + 2;
        bArr5[i17] = (byte) (i15 & 255);
    }

    @Override // com.google.api.client.repackaged.org.apache.commons.codec.binary.BaseNCodec
    public void encode(byte[] bArr, int i, int i2) {
        if (this.eof) {
            return;
        }
        if (i2 >= 0) {
            int i4 = 0;
            while (i4 < i2) {
                ensureBufferSize(this.encodeSize);
                int i5 = (this.modulus + 1) % 3;
                this.modulus = i5;
                int i6 = i + 1;
                int i7 = bArr[i];
                if (i7 < 0) {
                    i7 += 256;
                }
                int i8 = (this.bitWorkArea << 8) + i7;
                this.bitWorkArea = i8;
                if (i5 == 0) {
                    byte[] bArr2 = this.buffer;
                    int i9 = this.pos;
                    int i10 = i9 + 1;
                    this.pos = i10;
                    byte[] bArr3 = this.encodeTable;
                    bArr2[i9] = bArr3[(i8 >> 18) & 63];
                    int i11 = i9 + 2;
                    this.pos = i11;
                    bArr2[i10] = bArr3[(i8 >> 12) & 63];
                    int i12 = i9 + 3;
                    this.pos = i12;
                    bArr2[i11] = bArr3[(i8 >> 6) & 63];
                    int i13 = i9 + 4;
                    this.pos = i13;
                    bArr2[i12] = bArr3[i8 & 63];
                    int i14 = this.currentLinePos + 4;
                    this.currentLinePos = i14;
                    int i15 = this.lineLength;
                    if (i15 > 0 && i15 <= i14) {
                        byte[] bArr4 = this.lineSeparator;
                        System.arraycopy(bArr4, 0, bArr2, i13, bArr4.length);
                        this.pos += this.lineSeparator.length;
                        this.currentLinePos = 0;
                    }
                }
                i4++;
                i = i6;
            }
            return;
        }
        this.eof = true;
        if (this.modulus == 0 && this.lineLength == 0) {
            return;
        }
        ensureBufferSize(this.encodeSize);
        int i16 = this.pos;
        int i17 = this.modulus;
        if (i17 == 1) {
            byte[] bArr5 = this.buffer;
            int i18 = i16 + 1;
            this.pos = i18;
            byte[] bArr6 = this.encodeTable;
            int i19 = this.bitWorkArea;
            bArr5[i16] = bArr6[(i19 >> 2) & 63];
            int i20 = i16 + 2;
            this.pos = i20;
            bArr5[i18] = bArr6[(i19 << 4) & 63];
            if (bArr6 == STANDARD_ENCODE_TABLE) {
                int i21 = i16 + 3;
                this.pos = i21;
                bArr5[i20] = 61;
                this.pos = i16 + 4;
                bArr5[i21] = 61;
            }
        } else if (i17 == 2) {
            byte[] bArr7 = this.buffer;
            int i22 = i16 + 1;
            this.pos = i22;
            byte[] bArr8 = this.encodeTable;
            int i23 = this.bitWorkArea;
            bArr7[i16] = bArr8[(i23 >> 10) & 63];
            int i24 = i16 + 2;
            this.pos = i24;
            bArr7[i22] = bArr8[(i23 >> 4) & 63];
            int i25 = i16 + 3;
            this.pos = i25;
            bArr7[i24] = bArr8[(i23 << 2) & 63];
            if (bArr8 == STANDARD_ENCODE_TABLE) {
                this.pos = i16 + 4;
                bArr7[i25] = 61;
            }
        }
        int i26 = this.currentLinePos;
        int i27 = this.pos;
        int i28 = (i27 - i16) + i26;
        this.currentLinePos = i28;
        if (this.lineLength <= 0 || i28 <= 0) {
            return;
        }
        byte[] bArr9 = this.lineSeparator;
        System.arraycopy(bArr9, 0, this.buffer, i27, bArr9.length);
        this.pos += this.lineSeparator.length;
    }

    @Override // com.google.api.client.repackaged.org.apache.commons.codec.binary.BaseNCodec
    public boolean isInAlphabet(byte b) {
        if (b < 0) {
            return false;
        }
        byte[] bArr = this.decodeTable;
        return b < bArr.length && bArr[b] != -1;
    }

    public boolean isUrlSafe() {
        return this.encodeTable == URL_SAFE_ENCODE_TABLE;
    }

    public Base64(boolean z) {
        this(76, CHUNK_SEPARATOR, z);
    }

    public static byte[] decodeBase64(byte[] bArr) {
        return new Base64().decode(bArr);
    }

    public static byte[] encodeBase64(byte[] bArr, boolean z) {
        return encodeBase64(bArr, z, false);
    }

    public static boolean isBase64(String str) {
        return isBase64(StringUtils.getBytesUtf8(str));
    }

    public Base64(int i) {
        this(i, CHUNK_SEPARATOR);
    }

    public static byte[] encodeBase64(byte[] bArr, boolean z, boolean z2) {
        return encodeBase64(bArr, z, z2, Integer.MAX_VALUE);
    }

    public static boolean isBase64(byte[] bArr) {
        for (int i = 0; i < bArr.length; i++) {
            if (!isBase64(bArr[i]) && !BaseNCodec.isWhiteSpace(bArr[i])) {
                return false;
            }
        }
        return true;
    }

    public Base64(int i, byte[] bArr) {
        this(i, bArr, false);
    }

    public static byte[] encodeBase64(byte[] bArr, boolean z, boolean z2, int i) {
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        Base64 base64 = z ? new Base64(z2) : new Base64(0, CHUNK_SEPARATOR, z2);
        long encodedLength = base64.getEncodedLength(bArr);
        if (encodedLength <= i) {
            return base64.encode(bArr);
        }
        throw new IllegalArgumentException("Input array too big, the output array would be bigger (" + encodedLength + ") than the specified maximum size of " + i);
    }

    public Base64(int i, byte[] bArr, boolean z) {
        super(3, 4, i, bArr == null ? 0 : bArr.length);
        this.decodeTable = DECODE_TABLE;
        if (bArr != null) {
            if (containsAlphabetOrPad(bArr)) {
                throw new IllegalArgumentException(AbstractC0541b.m773o("lineSeparator must not contain base64 characters: [", StringUtils.newStringUtf8(bArr), "]"));
            }
            if (i > 0) {
                this.encodeSize = bArr.length + 4;
                byte[] bArr2 = new byte[bArr.length];
                this.lineSeparator = bArr2;
                System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            } else {
                this.encodeSize = 4;
                this.lineSeparator = null;
            }
        } else {
            this.encodeSize = 4;
            this.lineSeparator = null;
        }
        this.decodeSize = this.encodeSize - 1;
        this.encodeTable = z ? URL_SAFE_ENCODE_TABLE : STANDARD_ENCODE_TABLE;
    }
}
