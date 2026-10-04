package cz.msebera.android.httpclient.extras;

import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.spr.drawable.document.attribute.SprAttributeBase;
import com.yubico.yubikit.core.fido.CtapException;
import java.io.UnsupportedEncodingException;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class Base64 {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int CRLF = 4;
    public static final int DEFAULT = 0;
    public static final int NO_CLOSE = 16;
    public static final int NO_PADDING = 1;
    public static final int NO_WRAP = 2;
    public static final int URL_SAFE = 8;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class Coder {

        /* JADX INFO: renamed from: op */
        public int f8491op;
        public byte[] output;

        public abstract int maxOutputSize(int i);

        public abstract boolean process(byte[] bArr, int i, int i2, boolean z);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Decoder extends Coder {
        private static final int[] DECODE = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        private static final int[] DECODE_WEBSAFE = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        private static final int EQUALS = -2;
        private static final int SKIP = -1;
        private final int[] alphabet;
        private int state;
        private int value;

        public Decoder(int i, byte[] bArr) {
            this.output = bArr;
            this.alphabet = (i & 8) == 0 ? DECODE : DECODE_WEBSAFE;
            this.state = 0;
            this.value = 0;
        }

        @Override // cz.msebera.android.httpclient.extras.Base64.Coder
        public int maxOutputSize(int i) {
            return AbstractC2322a.m1611a(i, 3, 4, 10);
        }

        @Override // cz.msebera.android.httpclient.extras.Base64.Coder
        public boolean process(byte[] bArr, int i, int i2, boolean z) {
            int i4 = this.state;
            if (i4 == 6) {
                return false;
            }
            int i5 = i2 + i;
            int i6 = this.value;
            byte[] bArr2 = this.output;
            int[] iArr = this.alphabet;
            int i7 = 0;
            int i8 = i6;
            int i9 = i4;
            int i10 = i;
            while (i10 < i5) {
                if (i9 == 0) {
                    while (true) {
                        int i11 = i10 + 4;
                        if (i11 > i5 || (i8 = (iArr[bArr[i10] & 255] << 18) | (iArr[bArr[i10 + 1] & 255] << 12) | (iArr[bArr[i10 + 2] & 255] << 6) | iArr[bArr[i10 + 3] & 255]) < 0) {
                            break;
                        }
                        bArr2[i7 + 2] = (byte) i8;
                        bArr2[i7 + 1] = (byte) (i8 >> 8);
                        bArr2[i7] = (byte) (i8 >> 16);
                        i7 += 3;
                        i10 = i11;
                    }
                    if (i10 >= i5) {
                        break;
                    }
                }
                int i12 = i10 + 1;
                int i13 = iArr[bArr[i10] & 255];
                if (i9 != 0) {
                    if (i9 == 1) {
                        if (i13 < 0) {
                            if (i13 != -1) {
                                this.state = 6;
                                return false;
                            }
                        }
                        i13 |= i8 << 6;
                    } else if (i9 == 2) {
                        if (i13 < 0) {
                            if (i13 == -2) {
                                bArr2[i7] = (byte) (i8 >> 4);
                                i7++;
                                i9 = 4;
                            } else if (i13 != -1) {
                                this.state = 6;
                                return false;
                            }
                        }
                        i13 |= i8 << 6;
                    } else if (i9 != 3) {
                        if (i9 != 4) {
                            if (i9 == 5 && i13 != -1) {
                                this.state = 6;
                                return false;
                            }
                        } else if (i13 == -2) {
                            i9++;
                        } else if (i13 != -1) {
                            this.state = 6;
                            return false;
                        }
                    } else if (i13 >= 0) {
                        int i14 = i13 | (i8 << 6);
                        bArr2[i7 + 2] = (byte) i14;
                        bArr2[i7 + 1] = (byte) (i14 >> 8);
                        bArr2[i7] = (byte) (i14 >> 16);
                        i7 += 3;
                        i8 = i14;
                        i9 = 0;
                    } else if (i13 == -2) {
                        bArr2[i7 + 1] = (byte) (i8 >> 2);
                        bArr2[i7] = (byte) (i8 >> 10);
                        i7 += 2;
                        i9 = 5;
                    } else if (i13 != -1) {
                        this.state = 6;
                        return false;
                    }
                    i9++;
                    i8 = i13;
                } else if (i13 >= 0) {
                    i9++;
                    i8 = i13;
                } else if (i13 != -1) {
                    this.state = 6;
                    return false;
                }
                i10 = i12;
            }
            if (!z) {
                this.state = i9;
                this.value = i8;
                this.f8491op = i7;
                return true;
            }
            if (i9 == 1) {
                this.state = 6;
                return false;
            }
            if (i9 == 2) {
                bArr2[i7] = (byte) (i8 >> 4);
                i7++;
            } else if (i9 == 3) {
                int i15 = i7 + 1;
                bArr2[i7] = (byte) (i8 >> 10);
                i7 += 2;
                bArr2[i15] = (byte) (i8 >> 2);
            } else if (i9 == 4) {
                this.state = 6;
                return false;
            }
            this.state = i9;
            this.f8491op = i7;
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Encoder extends Coder {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private static final byte[] ENCODE = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, SprAttributeBase.TYPE_ANIMATOR_SET, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, SprAttributeBase.TYPE_SHADOW, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, CtapException.ERR_PIN_BLOCKED, CtapException.ERR_PIN_AUTH_INVALID, CtapException.ERR_PIN_AUTH_BLOCKED, CtapException.ERR_PIN_NOT_SET, CtapException.ERR_PIN_REQUIRED, CtapException.ERR_PIN_POLICY_VIOLATION, CtapException.ERR_PIN_TOKEN_EXPIRED, CtapException.ERR_REQUEST_TOO_LARGE, 43, 47};
        private static final byte[] ENCODE_WEBSAFE = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, SprAttributeBase.TYPE_ANIMATOR_SET, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, SprAttributeBase.TYPE_SHADOW, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, CtapException.ERR_PIN_BLOCKED, CtapException.ERR_PIN_AUTH_INVALID, CtapException.ERR_PIN_AUTH_BLOCKED, CtapException.ERR_PIN_NOT_SET, CtapException.ERR_PIN_REQUIRED, CtapException.ERR_PIN_POLICY_VIOLATION, CtapException.ERR_PIN_TOKEN_EXPIRED, CtapException.ERR_REQUEST_TOO_LARGE, 45, 95};
        public static final int LINE_GROUPS = 19;
        private final byte[] alphabet;
        private int count;
        public final boolean do_cr;
        public final boolean do_newline;
        public final boolean do_padding;
        private final byte[] tail;
        int tailLen;

        public Encoder(int i, byte[] bArr) {
            this.output = bArr;
            this.do_padding = (i & 1) == 0;
            boolean z = (i & 2) == 0;
            this.do_newline = z;
            this.do_cr = (i & 4) != 0;
            this.alphabet = (i & 8) == 0 ? ENCODE : ENCODE_WEBSAFE;
            this.tail = new byte[2];
            this.tailLen = 0;
            this.count = z ? 19 : -1;
        }

        @Override // cz.msebera.android.httpclient.extras.Base64.Coder
        public int maxOutputSize(int i) {
            return AbstractC2322a.m1611a(i, 8, 5, 10);
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x0050  */
        @Override // cz.msebera.android.httpclient.extras.Base64.Coder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean process(byte[] bArr, int i, int i2, boolean z) {
            int i4;
            int i5;
            int i6;
            int i7;
            byte b;
            byte b5;
            byte b6;
            int i8;
            int i9;
            byte[] bArr2 = this.alphabet;
            byte[] bArr3 = this.output;
            int i10 = this.count;
            int i11 = i2 + i;
            int i12 = this.tailLen;
            char c = 2;
            int i13 = 0;
            if (i12 != 1) {
                if (i12 == 2 && (i9 = i + 1) <= i11) {
                    byte[] bArr4 = this.tail;
                    i5 = ((bArr4[1] & 255) << 8) | ((bArr4[0] & 255) << 16) | (bArr[i] & 255);
                    this.tailLen = 0;
                    i4 = i9;
                } else {
                    i4 = i;
                    i5 = -1;
                }
            } else if (i + 2 <= i11) {
                i4 = i + 2;
                i5 = (bArr[i + 1] & 255) | ((this.tail[0] & 255) << 16) | ((bArr[i] & 255) << 8);
                this.tailLen = 0;
            }
            if (i5 != -1) {
                bArr3[0] = bArr2[(i5 >> 18) & 63];
                bArr3[1] = bArr2[(i5 >> 12) & 63];
                bArr3[2] = bArr2[(i5 >> 6) & 63];
                bArr3[3] = bArr2[i5 & 63];
                i10--;
                if (i10 == 0) {
                    if (this.do_cr) {
                        bArr3[4] = 13;
                        i8 = 5;
                    } else {
                        i8 = 4;
                    }
                    i6 = i8 + 1;
                    bArr3[i8] = 10;
                    i10 = 19;
                } else {
                    i6 = 4;
                }
            } else {
                i6 = 0;
            }
            while (true) {
                int i14 = i4 + 3;
                if (i14 > i11) {
                    break;
                }
                char c2 = c;
                int i15 = ((bArr[i4 + 1] & 255) << 8) | ((bArr[i4] & 255) << 16) | (bArr[i4 + 2] & 255);
                bArr3[i6] = bArr2[(i15 >> 18) & 63];
                bArr3[i6 + 1] = bArr2[(i15 >> 12) & 63];
                bArr3[i6 + 2] = bArr2[(i15 >> 6) & 63];
                bArr3[i6 + 3] = bArr2[i15 & 63];
                int i16 = i6 + 4;
                i10--;
                if (i10 == 0) {
                    if (this.do_cr) {
                        bArr3[i16] = 13;
                        i16 = i6 + 5;
                    }
                    i6 = i16 + 1;
                    bArr3[i16] = 10;
                    c = c2;
                    i10 = 19;
                    i4 = i14;
                } else {
                    i6 = i16;
                    i4 = i14;
                    c = c2;
                }
            }
            if (z) {
                int i17 = this.tailLen;
                if (i4 - i17 == i11 - 1) {
                    if (i17 > 0) {
                        b6 = this.tail[0];
                        i13 = 1;
                    } else {
                        b6 = bArr[i4];
                    }
                    int i18 = (b6 & 255) << 4;
                    this.tailLen = i17 - i13;
                    bArr3[i6] = bArr2[(i18 >> 6) & 63];
                    int i19 = i6 + 2;
                    bArr3[i6 + 1] = bArr2[i18 & 63];
                    if (this.do_padding) {
                        bArr3[i19] = 61;
                        i19 = i6 + 4;
                        bArr3[i6 + 3] = 61;
                    }
                    if (this.do_newline) {
                        if (this.do_cr) {
                            bArr3[i19] = 13;
                            i19++;
                        }
                        i7 = i19 + 1;
                        bArr3[i19] = 10;
                        i6 = i7;
                    } else {
                        i6 = i19;
                    }
                } else if (i4 - i17 == i11 - 2) {
                    if (i17 > 1) {
                        b = this.tail[0];
                        i13 = 1;
                    } else {
                        byte b7 = bArr[i4];
                        i4++;
                        b = b7;
                    }
                    int i20 = (b & 255) << 10;
                    if (i17 > 0) {
                        b5 = this.tail[i13];
                        i13++;
                    } else {
                        b5 = bArr[i4];
                    }
                    int i21 = i20 | ((b5 & 255) << 2);
                    this.tailLen = i17 - i13;
                    bArr3[i6] = bArr2[(i21 >> 12) & 63];
                    bArr3[i6 + 1] = bArr2[(i21 >> 6) & 63];
                    int i22 = i6 + 3;
                    bArr3[i6 + 2] = bArr2[i21 & 63];
                    if (this.do_padding) {
                        bArr3[i22] = 61;
                        i22 = i6 + 4;
                    }
                    if (this.do_newline) {
                        if (this.do_cr) {
                            bArr3[i22] = 13;
                            i22++;
                        }
                        i7 = i22 + 1;
                        bArr3[i22] = 10;
                        i6 = i7;
                    } else {
                        i6 = i22;
                    }
                } else if (this.do_newline && i6 > 0 && i10 != 19) {
                    if (this.do_cr) {
                        bArr3[i6] = 13;
                        i6++;
                    }
                    i7 = i6 + 1;
                    bArr3[i6] = 10;
                    i6 = i7;
                }
            } else if (i4 == i11 - 1) {
                byte[] bArr5 = this.tail;
                int i23 = this.tailLen;
                this.tailLen = i23 + 1;
                bArr5[i23] = bArr[i4];
            } else if (i4 == i11 - 2) {
                byte[] bArr6 = this.tail;
                int i24 = this.tailLen;
                int i25 = i24 + 1;
                this.tailLen = i25;
                bArr6[i24] = bArr[i4];
                this.tailLen = i24 + 2;
                bArr6[i25] = bArr[i4 + 1];
            }
            this.f8491op = i6;
            this.count = i10;
            return true;
        }
    }

    private Base64() {
    }

    public static byte[] decode(String str, int i) {
        return decode(str.getBytes(), i);
    }

    public static byte[] encode(byte[] bArr, int i) {
        return encode(bArr, 0, bArr.length, i);
    }

    public static String encodeToString(byte[] bArr, int i) {
        try {
            return new String(encode(bArr, i), "US-ASCII");
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }

    public static byte[] decode(byte[] bArr, int i) {
        return decode(bArr, 0, bArr.length, i);
    }

    public static byte[] encode(byte[] bArr, int i, int i2, int i4) {
        Encoder encoder = new Encoder(i4, null);
        int iM7d = (i2 / 3) * 4;
        if (!encoder.do_padding) {
            int i5 = i2 % 3;
            if (i5 == 1) {
                iM7d += 2;
            } else if (i5 == 2) {
                iM7d += 3;
            }
        } else if (i2 % 3 > 0) {
            iM7d += 4;
        }
        if (encoder.do_newline && i2 > 0) {
            iM7d += AbstractC0000a.m7d(i2, 1, 57, 1) * (encoder.do_cr ? 2 : 1);
        }
        encoder.output = new byte[iM7d];
        encoder.process(bArr, i, i2, true);
        return encoder.output;
    }

    public static byte[] decode(byte[] bArr, int i, int i2, int i4) {
        Decoder decoder = new Decoder(i4, new byte[(i2 * 3) / 4]);
        if (decoder.process(bArr, i, i2, true)) {
            int i5 = decoder.f8491op;
            byte[] bArr2 = decoder.output;
            if (i5 == bArr2.length) {
                return bArr2;
            }
            byte[] bArr3 = new byte[i5];
            System.arraycopy(bArr2, 0, bArr3, 0, i5);
            return bArr3;
        }
        throw new IllegalArgumentException("bad base-64");
    }

    public static String encodeToString(byte[] bArr, int i, int i2, int i4) {
        try {
            return new String(encode(bArr, i, i2, i4), "US-ASCII");
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }
}
