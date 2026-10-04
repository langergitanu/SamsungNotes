package com.fasterxml.jackson.core.p128io;

import com.fasterxml.jackson.core.util.BufferRecycler;
import com.fasterxml.jackson.core.util.ByteArrayBuilder;
import com.fasterxml.jackson.core.util.TextBuffer;
import com.sun.imageio.plugins.jpeg.JPEG;
import java.lang.ref.SoftReference;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class JsonStringEncoder {
    private static final int INT_0 = 48;
    private static final int INT_BACKSLASH = 92;
    private static final int INT_U = 117;
    private static final int SURR1_FIRST = 55296;
    private static final int SURR1_LAST = 56319;
    private static final int SURR2_FIRST = 56320;
    private static final int SURR2_LAST = 57343;
    protected ByteArrayBuilder _byteBuilder;
    protected final char[] _quoteBuffer = {'\\', 0, '0', '0', 0, 0};
    protected TextBuffer _textBuffer;
    private static final char[] HEX_CHARS = CharTypes.copyHexChars();
    private static final byte[] HEX_BYTES = CharTypes.copyHexBytes();
    protected static final ThreadLocal<SoftReference<JsonStringEncoder>> _threadEncoder = new ThreadLocal<>();

    private int _appendByteEscape(int i, int i2, ByteArrayBuilder byteArrayBuilder, int i4) {
        byteArrayBuilder.setCurrentSegmentLength(i4);
        byteArrayBuilder.append(92);
        if (i2 < 0) {
            byteArrayBuilder.append(117);
            if (i > 255) {
                byte[] bArr = HEX_BYTES;
                byteArrayBuilder.append(bArr[i >> 12]);
                byteArrayBuilder.append(bArr[(i >> 8) & 15]);
                i &= 255;
            } else {
                byteArrayBuilder.append(48);
                byteArrayBuilder.append(48);
            }
            byte[] bArr2 = HEX_BYTES;
            byteArrayBuilder.append(bArr2[i >> 4]);
            byteArrayBuilder.append(bArr2[i & 15]);
        } else {
            byteArrayBuilder.append((byte) i2);
        }
        return byteArrayBuilder.getCurrentSegmentLength();
    }

    private int _appendNamedEscape(int i, char[] cArr) {
        cArr[1] = (char) i;
        return 2;
    }

    private int _appendNumericEscape(int i, char[] cArr) {
        cArr[1] = 'u';
        char[] cArr2 = HEX_CHARS;
        cArr[4] = cArr2[i >> 4];
        cArr[5] = cArr2[i & 15];
        return 6;
    }

    private int _convertSurrogate(int i, int i2) {
        if (i2 >= 56320 && i2 <= SURR2_LAST) {
            return (i2 - 56320) + ((i - SURR1_FIRST) << 10) + 65536;
        }
        throw new IllegalArgumentException("Broken surrogate pair: first char 0x" + Integer.toHexString(i) + ", second 0x" + Integer.toHexString(i2) + "; illegal combination");
    }

    private void _throwIllegalSurrogate(int i) {
        if (i > 1114111) {
            throw new IllegalArgumentException("Illegal character point (0x" + Integer.toHexString(i) + ") to output; max is 0x10FFFF as per RFC 4627");
        }
        if (i < SURR1_FIRST) {
            throw new IllegalArgumentException("Illegal character point (0x" + Integer.toHexString(i) + ") to output");
        }
        if (i <= SURR1_LAST) {
            throw new IllegalArgumentException("Unmatched first part of surrogate pair (0x" + Integer.toHexString(i) + ")");
        }
        throw new IllegalArgumentException("Unmatched second part of surrogate pair (0x" + Integer.toHexString(i) + ")");
    }

    public static JsonStringEncoder getInstance() {
        ThreadLocal<SoftReference<JsonStringEncoder>> threadLocal = _threadEncoder;
        SoftReference<JsonStringEncoder> softReference = threadLocal.get();
        JsonStringEncoder jsonStringEncoder = softReference == null ? null : softReference.get();
        if (jsonStringEncoder != null) {
            return jsonStringEncoder;
        }
        JsonStringEncoder jsonStringEncoder2 = new JsonStringEncoder();
        threadLocal.set(new SoftReference<>(jsonStringEncoder2));
        return jsonStringEncoder2;
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00dc A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public byte[] encodeAsUTF8(String str) {
        int i;
        int i2;
        ByteArrayBuilder byteArrayBuilder = this._byteBuilder;
        if (byteArrayBuilder == null) {
            byteArrayBuilder = new ByteArrayBuilder((BufferRecycler) null);
            this._byteBuilder = byteArrayBuilder;
        }
        int length = str.length();
        byte[] bArrResetAndGetFirstSegment = byteArrayBuilder.resetAndGetFirstSegment();
        int length2 = bArrResetAndGetFirstSegment.length;
        int i4 = 0;
        int i5 = 0;
        loop0: while (true) {
            if (i4 >= length) {
                break;
            }
            int i6 = i4 + 1;
            char cCharAt = str.charAt(i4);
            while (cCharAt <= 127) {
                if (i5 >= length2) {
                    bArrResetAndGetFirstSegment = byteArrayBuilder.finishCurrentSegment();
                    length2 = bArrResetAndGetFirstSegment.length;
                    i5 = 0;
                }
                int i7 = i5 + 1;
                bArrResetAndGetFirstSegment[i5] = (byte) cCharAt;
                if (i6 >= length) {
                    i5 = i7;
                    break loop0;
                }
                char cCharAt2 = str.charAt(i6);
                i6++;
                cCharAt = cCharAt2;
                i5 = i7;
            }
            if (i5 >= length2) {
                bArrResetAndGetFirstSegment = byteArrayBuilder.finishCurrentSegment();
                length2 = bArrResetAndGetFirstSegment.length;
                i5 = 0;
            }
            if (cCharAt < 2048) {
                i = i5 + 1;
                bArrResetAndGetFirstSegment[i5] = (byte) ((cCharAt >> 6) | 192);
            } else if (cCharAt < SURR1_FIRST || cCharAt > SURR2_LAST) {
                int i8 = i5 + 1;
                bArrResetAndGetFirstSegment[i5] = (byte) ((cCharAt >> '\f') | JPEG.APP0);
                if (i8 >= length2) {
                    bArrResetAndGetFirstSegment = byteArrayBuilder.finishCurrentSegment();
                    length2 = bArrResetAndGetFirstSegment.length;
                    i8 = 0;
                }
                bArrResetAndGetFirstSegment[i8] = (byte) (((cCharAt >> 6) & 63) | 128);
                i = i8 + 1;
            } else {
                if (cCharAt > SURR1_LAST) {
                    _throwIllegalSurrogate(cCharAt);
                }
                if (i6 >= length) {
                    _throwIllegalSurrogate(cCharAt);
                }
                int i9 = i6 + 1;
                int i_convertSurrogate = _convertSurrogate(cCharAt, str.charAt(i6));
                if (i_convertSurrogate > 1114111) {
                    _throwIllegalSurrogate(i_convertSurrogate);
                }
                int i10 = i5 + 1;
                bArrResetAndGetFirstSegment[i5] = (byte) ((i_convertSurrogate >> 18) | 240);
                if (i10 >= length2) {
                    bArrResetAndGetFirstSegment = byteArrayBuilder.finishCurrentSegment();
                    length2 = bArrResetAndGetFirstSegment.length;
                    i10 = 0;
                }
                int i11 = i10 + 1;
                bArrResetAndGetFirstSegment[i10] = (byte) (((i_convertSurrogate >> 12) & 63) | 128);
                if (i11 >= length2) {
                    bArrResetAndGetFirstSegment = byteArrayBuilder.finishCurrentSegment();
                    length2 = bArrResetAndGetFirstSegment.length;
                    i11 = 0;
                }
                int i12 = i11 + 1;
                bArrResetAndGetFirstSegment[i11] = (byte) (((i_convertSurrogate >> 6) & 63) | 128);
                i2 = i_convertSurrogate;
                i4 = i9;
                i = i12;
                if (i < length2) {
                    bArrResetAndGetFirstSegment = byteArrayBuilder.finishCurrentSegment();
                    length2 = bArrResetAndGetFirstSegment.length;
                    i = 0;
                }
                bArrResetAndGetFirstSegment[i] = (byte) ((i2 & 63) | 128);
                i5 = i + 1;
            }
            i2 = cCharAt;
            i4 = i6;
            if (i < length2) {
            }
            bArrResetAndGetFirstSegment[i] = (byte) ((i2 & 63) | 128);
            i5 = i + 1;
        }
        return this._byteBuilder.completeAndCoalesce(i5);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0028, code lost:
    
        r8 = r6 + 1;
        r6 = r12.charAt(r6);
        r9 = r2[r6];
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0030, code lost:
    
        if (r9 >= 0) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0032, code lost:
    
        r6 = _appendNumericEscape(r6, r11._quoteBuffer);
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0039, code lost:
    
        r6 = _appendNamedEscape(r9, r11._quoteBuffer);
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x003f, code lost:
    
        r9 = r7 + r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0042, code lost:
    
        if (r9 <= r1.length) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0044, code lost:
    
        r9 = r1.length - r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0046, code lost:
    
        if (r9 <= 0) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0048, code lost:
    
        java.lang.System.arraycopy(r11._quoteBuffer, 0, r1, r7, r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x004d, code lost:
    
        r1 = r0.finishCurrentSegment();
        r6 = r6 - r9;
        java.lang.System.arraycopy(r11._quoteBuffer, r9, r1, 0, r6);
        r7 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0059, code lost:
    
        java.lang.System.arraycopy(r11._quoteBuffer, 0, r1, r7, r6);
        r7 = r9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public char[] quoteAsString(String str) {
        int i;
        TextBuffer textBuffer = this._textBuffer;
        if (textBuffer == null) {
            textBuffer = new TextBuffer(null);
            this._textBuffer = textBuffer;
        }
        char[] cArrEmptyAndGetCurrentSegment = textBuffer.emptyAndGetCurrentSegment();
        int[] iArr = CharTypes.get7BitOutputEscapes();
        int length = iArr.length;
        int length2 = str.length();
        int i2 = 0;
        int i4 = 0;
        loop0: while (true) {
            if (i2 >= length2) {
                break;
            }
            while (true) {
                char cCharAt = str.charAt(i2);
                if (cCharAt < length && iArr[cCharAt] != 0) {
                    break;
                }
                if (i4 >= cArrEmptyAndGetCurrentSegment.length) {
                    cArrEmptyAndGetCurrentSegment = textBuffer.finishCurrentSegment();
                    i4 = 0;
                }
                int i5 = i4 + 1;
                cArrEmptyAndGetCurrentSegment[i4] = cCharAt;
                i2++;
                if (i2 >= length2) {
                    i4 = i5;
                    break loop0;
                }
                i4 = i5;
            }
            i2 = i;
        }
        textBuffer.setCurrentLength(i4);
        return textBuffer.contentsAsArray();
    }

    public byte[] quoteAsUTF8(String str) {
        int i;
        int i2;
        int i4;
        ByteArrayBuilder byteArrayBuilder = this._byteBuilder;
        if (byteArrayBuilder == null) {
            byteArrayBuilder = new ByteArrayBuilder((BufferRecycler) null);
            this._byteBuilder = byteArrayBuilder;
        }
        int length = str.length();
        byte[] bArrResetAndGetFirstSegment = byteArrayBuilder.resetAndGetFirstSegment();
        int i5 = 0;
        int i_appendByteEscape = 0;
        loop0: while (true) {
            if (i5 >= length) {
                break;
            }
            int[] iArr = CharTypes.get7BitOutputEscapes();
            while (true) {
                char cCharAt = str.charAt(i5);
                if (cCharAt > 127 || iArr[cCharAt] != 0) {
                    break;
                }
                if (i_appendByteEscape >= bArrResetAndGetFirstSegment.length) {
                    bArrResetAndGetFirstSegment = byteArrayBuilder.finishCurrentSegment();
                    i_appendByteEscape = 0;
                }
                int i6 = i_appendByteEscape + 1;
                bArrResetAndGetFirstSegment[i_appendByteEscape] = (byte) cCharAt;
                i5++;
                if (i5 >= length) {
                    i_appendByteEscape = i6;
                    break loop0;
                }
                i_appendByteEscape = i6;
            }
            if (i_appendByteEscape >= bArrResetAndGetFirstSegment.length) {
                bArrResetAndGetFirstSegment = byteArrayBuilder.finishCurrentSegment();
                i_appendByteEscape = 0;
            }
            int i7 = i5 + 1;
            char cCharAt2 = str.charAt(i5);
            if (cCharAt2 <= 127) {
                i_appendByteEscape = _appendByteEscape(cCharAt2, iArr[cCharAt2], byteArrayBuilder, i_appendByteEscape);
                bArrResetAndGetFirstSegment = byteArrayBuilder.getCurrentSegment();
            } else {
                if (cCharAt2 <= 2047) {
                    i4 = i_appendByteEscape + 1;
                    bArrResetAndGetFirstSegment[i_appendByteEscape] = (byte) ((cCharAt2 >> 6) | 192);
                    i2 = (cCharAt2 & '?') | 128;
                } else {
                    if (cCharAt2 < SURR1_FIRST || cCharAt2 > SURR2_LAST) {
                        int i8 = i_appendByteEscape + 1;
                        bArrResetAndGetFirstSegment[i_appendByteEscape] = (byte) ((cCharAt2 >> '\f') | JPEG.APP0);
                        if (i8 >= bArrResetAndGetFirstSegment.length) {
                            bArrResetAndGetFirstSegment = byteArrayBuilder.finishCurrentSegment();
                            i8 = 0;
                        }
                        bArrResetAndGetFirstSegment[i8] = (byte) (((cCharAt2 >> 6) & 63) | 128);
                        i = i8 + 1;
                        i2 = (cCharAt2 & '?') | 128;
                    } else {
                        if (cCharAt2 > SURR1_LAST) {
                            _throwIllegalSurrogate(cCharAt2);
                        }
                        if (i7 >= length) {
                            _throwIllegalSurrogate(cCharAt2);
                        }
                        int i9 = i5 + 2;
                        int i_convertSurrogate = _convertSurrogate(cCharAt2, str.charAt(i7));
                        if (i_convertSurrogate > 1114111) {
                            _throwIllegalSurrogate(i_convertSurrogate);
                        }
                        int i10 = i_appendByteEscape + 1;
                        bArrResetAndGetFirstSegment[i_appendByteEscape] = (byte) ((i_convertSurrogate >> 18) | 240);
                        if (i10 >= bArrResetAndGetFirstSegment.length) {
                            bArrResetAndGetFirstSegment = byteArrayBuilder.finishCurrentSegment();
                            i10 = 0;
                        }
                        int i11 = i10 + 1;
                        bArrResetAndGetFirstSegment[i10] = (byte) (((i_convertSurrogate >> 12) & 63) | 128);
                        if (i11 >= bArrResetAndGetFirstSegment.length) {
                            bArrResetAndGetFirstSegment = byteArrayBuilder.finishCurrentSegment();
                            i11 = 0;
                        }
                        int i12 = i11 + 1;
                        bArrResetAndGetFirstSegment[i11] = (byte) (((i_convertSurrogate >> 6) & 63) | 128);
                        i2 = (i_convertSurrogate & 63) | 128;
                        i = i12;
                        i7 = i9;
                    }
                    i4 = i;
                }
                if (i4 >= bArrResetAndGetFirstSegment.length) {
                    bArrResetAndGetFirstSegment = byteArrayBuilder.finishCurrentSegment();
                    i4 = 0;
                }
                bArrResetAndGetFirstSegment[i4] = (byte) i2;
                i_appendByteEscape = i4 + 1;
            }
            i5 = i7;
        }
        return this._byteBuilder.completeAndCoalesce(i_appendByteEscape);
    }
}
