package androidx.datastore.preferences.protobuf;

import androidx.compose.foundation.layout.AbstractC1038a;
import com.samsung.android.spr.drawable.document.attribute.SprAttributeBase;
import com.sun.imageio.plugins.jpeg.JPEG;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
final class Utf8 {
    private static final long ASCII_MASK_LONG = -9187201950435737472L;
    public static final int COMPLETE = 0;
    public static final int MALFORMED = -1;
    static final int MAX_BYTES_PER_CHAR = 3;
    private static final int UNSAFE_COUNT_ASCII_THRESHOLD = 16;
    private static final Processor processor;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class DecodeUtil {
        private DecodeUtil() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void handleFourBytes(byte b, byte b5, byte b6, byte b7, char[] cArr, int i) throws InvalidProtocolBufferException {
            if (!isNotTrailingByte(b5)) {
                if ((((b5 + SprAttributeBase.TYPE_SHADOW) + (b << 28)) >> 30) == 0 && !isNotTrailingByte(b6) && !isNotTrailingByte(b7)) {
                    int iTrailingByteValue = ((b & 7) << 18) | (trailingByteValue(b5) << 12) | (trailingByteValue(b6) << 6) | trailingByteValue(b7);
                    cArr[i] = highSurrogate(iTrailingByteValue);
                    cArr[i + 1] = lowSurrogate(iTrailingByteValue);
                    return;
                }
            }
            throw InvalidProtocolBufferException.invalidUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void handleOneByte(byte b, char[] cArr, int i) {
            cArr[i] = (char) b;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void handleThreeBytes(byte b, byte b5, byte b6, char[] cArr, int i) throws InvalidProtocolBufferException {
            if (isNotTrailingByte(b5) || ((b == -32 && b5 < -96) || ((b == -19 && b5 >= -96) || isNotTrailingByte(b6)))) {
                throw InvalidProtocolBufferException.invalidUtf8();
            }
            cArr[i] = (char) (((b & 15) << 12) | (trailingByteValue(b5) << 6) | trailingByteValue(b6));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void handleTwoBytes(byte b, byte b5, char[] cArr, int i) throws InvalidProtocolBufferException {
            if (b < -62 || isNotTrailingByte(b5)) {
                throw InvalidProtocolBufferException.invalidUtf8();
            }
            cArr[i] = (char) (((b & 31) << 6) | trailingByteValue(b5));
        }

        private static char highSurrogate(int i) {
            return (char) ((i >>> 10) + okio.Utf8.HIGH_SURROGATE_HEADER);
        }

        private static boolean isNotTrailingByte(byte b) {
            return b > -65;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean isOneByte(byte b) {
            return b >= 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean isThreeBytes(byte b) {
            return b < -16;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean isTwoBytes(byte b) {
            return b < -32;
        }

        private static char lowSurrogate(int i) {
            return (char) ((i & 1023) + okio.Utf8.LOG_SURROGATE_HEADER);
        }

        private static int trailingByteValue(byte b) {
            return b & okio.Utf8.REPLACEMENT_BYTE;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class Processor {
        public final String decodeUtf8(ByteBuffer byteBuffer, int i, int i2) {
            if (byteBuffer.hasArray()) {
                return decodeUtf8(byteBuffer.array(), byteBuffer.arrayOffset() + i, i2);
            }
            return byteBuffer.isDirect() ? decodeUtf8Direct(byteBuffer, i, i2) : decodeUtf8Default(byteBuffer, i, i2);
        }

        public abstract String decodeUtf8(byte[] bArr, int i, int i2);

        public final String decodeUtf8Default(ByteBuffer byteBuffer, int i, int i2) throws InvalidProtocolBufferException {
            if ((i | i2 | ((byteBuffer.limit() - i) - i2)) < 0) {
                throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", Integer.valueOf(byteBuffer.limit()), Integer.valueOf(i), Integer.valueOf(i2)));
            }
            int i4 = i + i2;
            char[] cArr = new char[i2];
            int i5 = 0;
            while (i < i4) {
                byte b = byteBuffer.get(i);
                if (!DecodeUtil.isOneByte(b)) {
                    break;
                }
                i++;
                DecodeUtil.handleOneByte(b, cArr, i5);
                i5++;
            }
            int i6 = i5;
            while (i < i4) {
                int i7 = i + 1;
                byte b5 = byteBuffer.get(i);
                if (DecodeUtil.isOneByte(b5)) {
                    int i8 = i6 + 1;
                    DecodeUtil.handleOneByte(b5, cArr, i6);
                    int i9 = i7;
                    while (i9 < i4) {
                        byte b6 = byteBuffer.get(i9);
                        if (!DecodeUtil.isOneByte(b6)) {
                            break;
                        }
                        i9++;
                        DecodeUtil.handleOneByte(b6, cArr, i8);
                        i8++;
                    }
                    i6 = i8;
                    i = i9;
                } else if (DecodeUtil.isTwoBytes(b5)) {
                    if (i7 >= i4) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    i += 2;
                    DecodeUtil.handleTwoBytes(b5, byteBuffer.get(i7), cArr, i6);
                    i6++;
                } else if (DecodeUtil.isThreeBytes(b5)) {
                    if (i7 >= i4 - 1) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    int i10 = i + 2;
                    i += 3;
                    DecodeUtil.handleThreeBytes(b5, byteBuffer.get(i7), byteBuffer.get(i10), cArr, i6);
                    i6++;
                } else {
                    if (i7 >= i4 - 2) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    byte b7 = byteBuffer.get(i7);
                    int i11 = i + 3;
                    byte b8 = byteBuffer.get(i + 2);
                    i += 4;
                    DecodeUtil.handleFourBytes(b5, b7, b8, byteBuffer.get(i11), cArr, i6);
                    i6 += 2;
                }
            }
            return new String(cArr, 0, i6);
        }

        public abstract String decodeUtf8Direct(ByteBuffer byteBuffer, int i, int i2);

        public abstract int encodeUtf8(CharSequence charSequence, byte[] bArr, int i, int i2);

        public final void encodeUtf8(CharSequence charSequence, ByteBuffer byteBuffer) {
            if (byteBuffer.hasArray()) {
                int iArrayOffset = byteBuffer.arrayOffset();
                byteBuffer.position(Utf8.encode(charSequence, byteBuffer.array(), byteBuffer.position() + iArrayOffset, byteBuffer.remaining()) - iArrayOffset);
            } else if (byteBuffer.isDirect()) {
                encodeUtf8Direct(charSequence, byteBuffer);
            } else {
                encodeUtf8Default(charSequence, byteBuffer);
            }
        }

        public final void encodeUtf8Default(CharSequence charSequence, ByteBuffer byteBuffer) {
            int i;
            int length = charSequence.length();
            int iPosition = byteBuffer.position();
            int i2 = 0;
            while (i2 < length) {
                try {
                    char cCharAt = charSequence.charAt(i2);
                    if (cCharAt >= 128) {
                        break;
                    }
                    byteBuffer.put(iPosition + i2, (byte) cCharAt);
                    i2++;
                } catch (IndexOutOfBoundsException unused) {
                    throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(i2) + " at index " + (Math.max(i2, (iPosition - byteBuffer.position()) + 1) + byteBuffer.position()));
                }
            }
            if (i2 == length) {
                byteBuffer.position(iPosition + i2);
                return;
            }
            iPosition += i2;
            while (i2 < length) {
                char cCharAt2 = charSequence.charAt(i2);
                if (cCharAt2 < 128) {
                    byteBuffer.put(iPosition, (byte) cCharAt2);
                } else if (cCharAt2 < 2048) {
                    int i4 = iPosition + 1;
                    try {
                        byteBuffer.put(iPosition, (byte) ((cCharAt2 >>> 6) | 192));
                        byteBuffer.put(i4, (byte) ((cCharAt2 & '?') | 128));
                        iPosition = i4;
                    } catch (IndexOutOfBoundsException unused2) {
                        iPosition = i4;
                        throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(i2) + " at index " + (Math.max(i2, (iPosition - byteBuffer.position()) + 1) + byteBuffer.position()));
                    }
                } else {
                    if (cCharAt2 >= 55296 && 57343 >= cCharAt2) {
                        int i5 = i2 + 1;
                        if (i5 != length) {
                            try {
                                char cCharAt3 = charSequence.charAt(i5);
                                if (Character.isSurrogatePair(cCharAt2, cCharAt3)) {
                                    int codePoint = Character.toCodePoint(cCharAt2, cCharAt3);
                                    int i6 = iPosition + 1;
                                    try {
                                        byteBuffer.put(iPosition, (byte) ((codePoint >>> 18) | 240));
                                        i = iPosition + 2;
                                    } catch (IndexOutOfBoundsException unused3) {
                                        iPosition = i6;
                                        i2 = i5;
                                        throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(i2) + " at index " + (Math.max(i2, (iPosition - byteBuffer.position()) + 1) + byteBuffer.position()));
                                    }
                                    try {
                                        byteBuffer.put(i6, (byte) (((codePoint >>> 12) & 63) | 128));
                                        iPosition += 3;
                                        byteBuffer.put(i, (byte) (((codePoint >>> 6) & 63) | 128));
                                        byteBuffer.put(iPosition, (byte) ((codePoint & 63) | 128));
                                        i2 = i5;
                                    } catch (IndexOutOfBoundsException unused4) {
                                        i2 = i5;
                                        iPosition = i;
                                        throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(i2) + " at index " + (Math.max(i2, (iPosition - byteBuffer.position()) + 1) + byteBuffer.position()));
                                    }
                                } else {
                                    i2 = i5;
                                }
                            } catch (IndexOutOfBoundsException unused5) {
                            }
                        }
                        throw new UnpairedSurrogateException(i2, length);
                    }
                    int i7 = iPosition + 1;
                    byteBuffer.put(iPosition, (byte) ((cCharAt2 >>> '\f') | JPEG.APP0));
                    iPosition += 2;
                    byteBuffer.put(i7, (byte) (((cCharAt2 >>> 6) & 63) | 128));
                    byteBuffer.put(iPosition, (byte) ((cCharAt2 & '?') | 128));
                }
                i2++;
                iPosition++;
            }
            byteBuffer.position(iPosition);
        }

        public abstract void encodeUtf8Direct(CharSequence charSequence, ByteBuffer byteBuffer);

        public final boolean isValidUtf8(byte[] bArr, int i, int i2) {
            return partialIsValidUtf8(0, bArr, i, i2) == 0;
        }

        public final int partialIsValidUtf8(int i, ByteBuffer byteBuffer, int i2, int i4) {
            if (!byteBuffer.hasArray()) {
                return byteBuffer.isDirect() ? partialIsValidUtf8Direct(i, byteBuffer, i2, i4) : partialIsValidUtf8Default(i, byteBuffer, i2, i4);
            }
            int iArrayOffset = byteBuffer.arrayOffset();
            return partialIsValidUtf8(i, byteBuffer.array(), i2 + iArrayOffset, iArrayOffset + i4);
        }

        public abstract int partialIsValidUtf8(int i, byte[] bArr, int i2, int i4);

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0017, code lost:
        
            if (r8.get(r9) > (-65)) goto L13;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x004c, code lost:
        
            if (r8.get(r9) > (-65)) goto L32;
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x008f, code lost:
        
            if (r8.get(r7) > (-65)) goto L53;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final int partialIsValidUtf8Default(int i, ByteBuffer byteBuffer, int i2, int i4) {
            byte b;
            int i5;
            int i6;
            if (i != 0) {
                if (i2 >= i4) {
                    return i;
                }
                byte b5 = (byte) i;
                if (b5 < -32) {
                    if (b5 >= -62) {
                        i6 = i2 + 1;
                    }
                    return -1;
                }
                if (b5 < -16) {
                    byte b6 = (byte) (~(i >> 8));
                    if (b6 == 0) {
                        int i7 = i2 + 1;
                        byte b7 = byteBuffer.get(i2);
                        if (i7 >= i4) {
                            return Utf8.incompleteStateFor(b5, b7);
                        }
                        i2 = i7;
                        b6 = b7;
                    }
                    if (b6 <= -65 && ((b5 != -32 || b6 >= -96) && (b5 != -19 || b6 < -96))) {
                        i6 = i2 + 1;
                    }
                    return -1;
                }
                byte b8 = (byte) (~(i >> 8));
                if (b8 == 0) {
                    i5 = i2 + 1;
                    b8 = byteBuffer.get(i2);
                    if (i5 >= i4) {
                        return Utf8.incompleteStateFor(b5, b8);
                    }
                    b = 0;
                } else {
                    b = (byte) (i >> 16);
                    i5 = i2;
                }
                if (b == 0) {
                    int i8 = i5 + 1;
                    byte b9 = byteBuffer.get(i5);
                    if (i8 >= i4) {
                        return Utf8.incompleteStateFor(b5, b8, b9);
                    }
                    b = b9;
                    i5 = i8;
                }
                if (b8 <= -65) {
                    if ((((b8 + SprAttributeBase.TYPE_SHADOW) + (b5 << 28)) >> 30) == 0 && b <= -65) {
                        i2 = i5 + 1;
                    }
                }
                return -1;
                i2 = i6;
            }
            return partialIsValidUtf8(byteBuffer, i2, i4);
        }

        public abstract int partialIsValidUtf8Direct(int i, ByteBuffer byteBuffer, int i2, int i4);

        public final boolean isValidUtf8(ByteBuffer byteBuffer, int i, int i2) {
            return partialIsValidUtf8(0, byteBuffer, i, i2) == 0;
        }

        private static int partialIsValidUtf8(ByteBuffer byteBuffer, int i, int i2) {
            int iEstimateConsecutiveAscii = i + Utf8.estimateConsecutiveAscii(byteBuffer, i, i2);
            while (iEstimateConsecutiveAscii < i2) {
                int i4 = iEstimateConsecutiveAscii + 1;
                byte b = byteBuffer.get(iEstimateConsecutiveAscii);
                if (b >= 0) {
                    iEstimateConsecutiveAscii = i4;
                } else if (b < -32) {
                    if (i4 >= i2) {
                        return b;
                    }
                    if (b < -62 || byteBuffer.get(i4) > -65) {
                        return -1;
                    }
                    iEstimateConsecutiveAscii += 2;
                } else {
                    if (b >= -16) {
                        if (i4 >= i2 - 2) {
                            return Utf8.incompleteStateFor(byteBuffer, b, i4, i2 - i4);
                        }
                        int i5 = iEstimateConsecutiveAscii + 2;
                        byte b5 = byteBuffer.get(i4);
                        if (b5 <= -65) {
                            if ((((b5 + SprAttributeBase.TYPE_SHADOW) + (b << 28)) >> 30) == 0) {
                                int i6 = iEstimateConsecutiveAscii + 3;
                                if (byteBuffer.get(i5) <= -65) {
                                    iEstimateConsecutiveAscii += 4;
                                    if (byteBuffer.get(i6) > -65) {
                                    }
                                }
                            }
                        }
                        return -1;
                    }
                    if (i4 >= i2 - 1) {
                        return Utf8.incompleteStateFor(byteBuffer, b, i4, i2 - i4);
                    }
                    int i7 = iEstimateConsecutiveAscii + 2;
                    byte b6 = byteBuffer.get(i4);
                    if (b6 > -65 || ((b == -32 && b6 < -96) || ((b == -19 && b6 >= -96) || byteBuffer.get(i7) > -65))) {
                        return -1;
                    }
                    iEstimateConsecutiveAscii += 3;
                }
            }
            return 0;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class UnpairedSurrogateException extends IllegalArgumentException {
        public UnpairedSurrogateException(int i, int i2) {
            super(AbstractC1038a.m1214o(i, i2, "Unpaired surrogate at index ", " of "));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class UnsafeProcessor extends Processor {
        public static boolean isAvailable() {
            return UnsafeUtil.hasUnsafeArrayOperations() && UnsafeUtil.hasUnsafeByteBufferOperations();
        }

        private static int unsafeEstimateConsecutiveAscii(byte[] bArr, long j, int i) {
            int i2 = 0;
            if (i < 16) {
                return 0;
            }
            while (i2 < i) {
                long j2 = 1 + j;
                if (UnsafeUtil.getByte(bArr, j) < 0) {
                    return i2;
                }
                i2++;
                j = j2;
            }
            return i;
        }

        private static int unsafeIncompleteStateFor(byte[] bArr, int i, long j, int i2) {
            if (i2 == 0) {
                return Utf8.incompleteStateFor(i);
            }
            if (i2 == 1) {
                return Utf8.incompleteStateFor(i, UnsafeUtil.getByte(bArr, j));
            }
            if (i2 == 2) {
                return Utf8.incompleteStateFor(i, UnsafeUtil.getByte(bArr, j), UnsafeUtil.getByte(bArr, j + 1));
            }
            throw new AssertionError();
        }

        @Override // androidx.datastore.preferences.protobuf.Utf8.Processor
        public String decodeUtf8(byte[] bArr, int i, int i2) throws InvalidProtocolBufferException {
            if ((i | i2 | ((bArr.length - i) - i2)) < 0) {
                throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)));
            }
            int i4 = i + i2;
            char[] cArr = new char[i2];
            int i5 = 0;
            while (i < i4) {
                byte b = UnsafeUtil.getByte(bArr, i);
                if (!DecodeUtil.isOneByte(b)) {
                    break;
                }
                i++;
                DecodeUtil.handleOneByte(b, cArr, i5);
                i5++;
            }
            int i6 = i5;
            while (i < i4) {
                int i7 = i + 1;
                byte b5 = UnsafeUtil.getByte(bArr, i);
                if (DecodeUtil.isOneByte(b5)) {
                    int i8 = i6 + 1;
                    DecodeUtil.handleOneByte(b5, cArr, i6);
                    while (i7 < i4) {
                        byte b6 = UnsafeUtil.getByte(bArr, i7);
                        if (!DecodeUtil.isOneByte(b6)) {
                            break;
                        }
                        i7++;
                        DecodeUtil.handleOneByte(b6, cArr, i8);
                        i8++;
                    }
                    i6 = i8;
                    i = i7;
                } else if (DecodeUtil.isTwoBytes(b5)) {
                    if (i7 >= i4) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    i += 2;
                    DecodeUtil.handleTwoBytes(b5, UnsafeUtil.getByte(bArr, i7), cArr, i6);
                    i6++;
                } else if (DecodeUtil.isThreeBytes(b5)) {
                    if (i7 >= i4 - 1) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    int i9 = i + 2;
                    i += 3;
                    DecodeUtil.handleThreeBytes(b5, UnsafeUtil.getByte(bArr, i7), UnsafeUtil.getByte(bArr, i9), cArr, i6);
                    i6++;
                } else {
                    if (i7 >= i4 - 2) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    byte b7 = UnsafeUtil.getByte(bArr, i7);
                    int i10 = i + 3;
                    byte b8 = UnsafeUtil.getByte(bArr, i + 2);
                    i += 4;
                    DecodeUtil.handleFourBytes(b5, b7, b8, UnsafeUtil.getByte(bArr, i10), cArr, i6);
                    i6 += 2;
                }
            }
            return new String(cArr, 0, i6);
        }

        @Override // androidx.datastore.preferences.protobuf.Utf8.Processor
        public String decodeUtf8Direct(ByteBuffer byteBuffer, int i, int i2) throws InvalidProtocolBufferException {
            if ((i | i2 | ((byteBuffer.limit() - i) - i2)) < 0) {
                throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", Integer.valueOf(byteBuffer.limit()), Integer.valueOf(i), Integer.valueOf(i2)));
            }
            long jAddressOffset = UnsafeUtil.addressOffset(byteBuffer) + ((long) i);
            long j = ((long) i2) + jAddressOffset;
            char[] cArr = new char[i2];
            int i4 = 0;
            while (jAddressOffset < j) {
                byte b = UnsafeUtil.getByte(jAddressOffset);
                if (!DecodeUtil.isOneByte(b)) {
                    break;
                }
                jAddressOffset++;
                DecodeUtil.handleOneByte(b, cArr, i4);
                i4++;
            }
            int i5 = i4;
            while (jAddressOffset < j) {
                long j2 = jAddressOffset + 1;
                byte b5 = UnsafeUtil.getByte(jAddressOffset);
                if (DecodeUtil.isOneByte(b5)) {
                    int i6 = i5 + 1;
                    DecodeUtil.handleOneByte(b5, cArr, i5);
                    long j3 = j2;
                    while (j3 < j) {
                        byte b6 = UnsafeUtil.getByte(j3);
                        if (!DecodeUtil.isOneByte(b6)) {
                            break;
                        }
                        j3++;
                        DecodeUtil.handleOneByte(b6, cArr, i6);
                        i6++;
                    }
                    i5 = i6;
                    jAddressOffset = j3;
                } else if (DecodeUtil.isTwoBytes(b5)) {
                    if (j2 >= j) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    jAddressOffset += 2;
                    DecodeUtil.handleTwoBytes(b5, UnsafeUtil.getByte(j2), cArr, i5);
                    i5++;
                } else if (DecodeUtil.isThreeBytes(b5)) {
                    if (j2 >= j - 1) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    long j5 = 2 + jAddressOffset;
                    jAddressOffset += 3;
                    DecodeUtil.handleThreeBytes(b5, UnsafeUtil.getByte(j2), UnsafeUtil.getByte(j5), cArr, i5);
                    i5++;
                } else {
                    if (j2 >= j - 2) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    byte b7 = UnsafeUtil.getByte(j2);
                    long j6 = jAddressOffset + 3;
                    byte b8 = UnsafeUtil.getByte(2 + jAddressOffset);
                    jAddressOffset += 4;
                    DecodeUtil.handleFourBytes(b5, b7, b8, UnsafeUtil.getByte(j6), cArr, i5);
                    i5 += 2;
                }
            }
            return new String(cArr, 0, i5);
        }

        @Override // androidx.datastore.preferences.protobuf.Utf8.Processor
        public int encodeUtf8(CharSequence charSequence, byte[] bArr, int i, int i2) {
            long j;
            long j2;
            long j3;
            int i4;
            char cCharAt;
            long j5 = i;
            long j6 = ((long) i2) + j5;
            int length = charSequence.length();
            if (length > i2 || bArr.length - i2 < i) {
                throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(length - 1) + " at index " + (i + i2));
            }
            int i5 = 0;
            while (true) {
                j = 1;
                if (i5 >= length || (cCharAt = charSequence.charAt(i5)) >= 128) {
                    break;
                }
                UnsafeUtil.putByte(bArr, j5, (byte) cCharAt);
                i5++;
                j5 = 1 + j5;
            }
            if (i5 == length) {
                return (int) j5;
            }
            while (i5 < length) {
                char cCharAt2 = charSequence.charAt(i5);
                if (cCharAt2 < 128 && j5 < j6) {
                    UnsafeUtil.putByte(bArr, j5, (byte) cCharAt2);
                    j3 = j6;
                    j2 = j;
                    j5 += j;
                } else if (cCharAt2 >= 2048 || j5 > j6 - 2) {
                    j2 = j;
                    if ((cCharAt2 >= 55296 && 57343 >= cCharAt2) || j5 > j6 - 3) {
                        j3 = j6;
                        if (j5 > j3 - 4) {
                            if (55296 <= cCharAt2 && cCharAt2 <= 57343 && ((i4 = i5 + 1) == length || !Character.isSurrogatePair(cCharAt2, charSequence.charAt(i4)))) {
                                throw new UnpairedSurrogateException(i5, length);
                            }
                            throw new ArrayIndexOutOfBoundsException("Failed writing " + cCharAt2 + " at index " + j5);
                        }
                        int i6 = i5 + 1;
                        if (i6 != length) {
                            char cCharAt3 = charSequence.charAt(i6);
                            if (Character.isSurrogatePair(cCharAt2, cCharAt3)) {
                                int codePoint = Character.toCodePoint(cCharAt2, cCharAt3);
                                UnsafeUtil.putByte(bArr, j5, (byte) ((codePoint >>> 18) | 240));
                                UnsafeUtil.putByte(bArr, j5 + j2, (byte) (((codePoint >>> 12) & 63) | 128));
                                long j7 = j5 + 3;
                                UnsafeUtil.putByte(bArr, j5 + 2, (byte) (((codePoint >>> 6) & 63) | 128));
                                j5 += 4;
                                UnsafeUtil.putByte(bArr, j7, (byte) ((codePoint & 63) | 128));
                                i5 = i6;
                            } else {
                                i5 = i6;
                            }
                        }
                        throw new UnpairedSurrogateException(i5 - 1, length);
                    }
                    UnsafeUtil.putByte(bArr, j5, (byte) ((cCharAt2 >>> '\f') | 480));
                    long j8 = j5 + 2;
                    j3 = j6;
                    UnsafeUtil.putByte(bArr, j5 + j2, (byte) (((cCharAt2 >>> 6) & 63) | 128));
                    j5 += 3;
                    UnsafeUtil.putByte(bArr, j8, (byte) ((cCharAt2 & '?') | 128));
                } else {
                    j2 = j;
                    long j9 = j5 + j2;
                    UnsafeUtil.putByte(bArr, j5, (byte) ((cCharAt2 >>> 6) | 960));
                    j5 += 2;
                    UnsafeUtil.putByte(bArr, j9, (byte) ((cCharAt2 & '?') | 128));
                    j3 = j6;
                }
                i5++;
                j = j2;
                j6 = j3;
            }
            return (int) j5;
        }

        @Override // androidx.datastore.preferences.protobuf.Utf8.Processor
        public void encodeUtf8Direct(CharSequence charSequence, ByteBuffer byteBuffer) {
            long j;
            char c;
            long j2;
            long j3;
            long j5;
            int i;
            char c2;
            char cCharAt;
            long jAddressOffset = UnsafeUtil.addressOffset(byteBuffer);
            long jPosition = ((long) byteBuffer.position()) + jAddressOffset;
            long jLimit = ((long) byteBuffer.limit()) + jAddressOffset;
            int length = charSequence.length();
            if (length > jLimit - jPosition) {
                throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(length - 1) + " at index " + byteBuffer.limit());
            }
            int i2 = 0;
            while (true) {
                j = 1;
                c = 128;
                if (i2 >= length || (cCharAt = charSequence.charAt(i2)) >= 128) {
                    break;
                }
                UnsafeUtil.putByte(jPosition, (byte) cCharAt);
                i2++;
                jPosition = 1 + jPosition;
            }
            if (i2 == length) {
                byteBuffer.position((int) (jPosition - jAddressOffset));
                return;
            }
            while (i2 < length) {
                char cCharAt2 = charSequence.charAt(i2);
                if (cCharAt2 >= c || jPosition >= jLimit) {
                    j2 = j;
                    if (cCharAt2 < 2048 && jPosition <= jLimit - 2) {
                        long j6 = jPosition + j2;
                        UnsafeUtil.putByte(jPosition, (byte) ((cCharAt2 >>> 6) | 960));
                        jPosition += 2;
                        UnsafeUtil.putByte(j6, (byte) ((cCharAt2 & '?') | 128));
                        j3 = jAddressOffset;
                        j5 = jLimit;
                    } else {
                        if ((cCharAt2 >= 55296 && 57343 >= cCharAt2) || jPosition > jLimit - 3) {
                            j3 = jAddressOffset;
                            j5 = jLimit;
                            if (jPosition > j5 - 4) {
                                if (55296 <= cCharAt2 && cCharAt2 <= 57343 && ((i = i2 + 1) == length || !Character.isSurrogatePair(cCharAt2, charSequence.charAt(i)))) {
                                    throw new UnpairedSurrogateException(i2, length);
                                }
                                throw new ArrayIndexOutOfBoundsException("Failed writing " + cCharAt2 + " at index " + jPosition);
                            }
                            int i4 = i2 + 1;
                            if (i4 != length) {
                                char cCharAt3 = charSequence.charAt(i4);
                                if (Character.isSurrogatePair(cCharAt2, cCharAt3)) {
                                    int codePoint = Character.toCodePoint(cCharAt2, cCharAt3);
                                    UnsafeUtil.putByte(jPosition, (byte) ((codePoint >>> 18) | 240));
                                    c2 = 128;
                                    UnsafeUtil.putByte(jPosition + j2, (byte) (((codePoint >>> 12) & 63) | 128));
                                    long j7 = jPosition + 3;
                                    UnsafeUtil.putByte(jPosition + 2, (byte) (((codePoint >>> 6) & 63) | 128));
                                    jPosition += 4;
                                    UnsafeUtil.putByte(j7, (byte) ((codePoint & 63) | 128));
                                    i2 = i4;
                                } else {
                                    i2 = i4;
                                }
                            }
                            throw new UnpairedSurrogateException(i2 - 1, length);
                        }
                        UnsafeUtil.putByte(jPosition, (byte) ((cCharAt2 >>> '\f') | 480));
                        j3 = jAddressOffset;
                        long j8 = jPosition + 2;
                        j5 = jLimit;
                        UnsafeUtil.putByte(jPosition + j2, (byte) (((cCharAt2 >>> 6) & 63) | 128));
                        jPosition += 3;
                        UnsafeUtil.putByte(j8, (byte) ((cCharAt2 & '?') | 128));
                    }
                    c2 = 128;
                } else {
                    UnsafeUtil.putByte(jPosition, (byte) cCharAt2);
                    j3 = jAddressOffset;
                    j5 = jLimit;
                    c2 = c;
                    jPosition += j;
                    j2 = j;
                }
                i2++;
                c = c2;
                j = j2;
                jAddressOffset = j3;
                jLimit = j5;
            }
            byteBuffer.position((int) (jPosition - jAddressOffset));
        }

        /* JADX WARN: Code restructure failed: missing block: B:35:0x0058, code lost:
        
            if (androidx.datastore.preferences.protobuf.UnsafeUtil.getByte(r12, r0) > (-65)) goto L38;
         */
        /* JADX WARN: Code restructure failed: missing block: B:58:0x009e, code lost:
        
            if (androidx.datastore.preferences.protobuf.UnsafeUtil.getByte(r12, r0) > (-65)) goto L59;
         */
        @Override // androidx.datastore.preferences.protobuf.Utf8.Processor
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public int partialIsValidUtf8(int i, byte[] bArr, int i2, int i4) {
            byte b;
            long j;
            if ((i2 | i4 | (bArr.length - i4)) < 0) {
                throw new ArrayIndexOutOfBoundsException(String.format("Array length=%d, index=%d, limit=%d", Integer.valueOf(bArr.length), Integer.valueOf(i2), Integer.valueOf(i4)));
            }
            long j2 = i2;
            long j3 = i4;
            if (i != 0) {
                if (j2 >= j3) {
                    return i;
                }
                byte b5 = (byte) i;
                if (b5 < -32) {
                    if (b5 >= -62) {
                        long j5 = 1 + j2;
                        if (UnsafeUtil.getByte(bArr, j2) <= -65) {
                            j2 = j5;
                        }
                    }
                    return -1;
                }
                if (b5 < -16) {
                    byte b6 = (byte) (~(i >> 8));
                    if (b6 == 0) {
                        long j6 = j2 + 1;
                        b6 = UnsafeUtil.getByte(bArr, j2);
                        if (j6 >= j3) {
                            return Utf8.incompleteStateFor(b5, b6);
                        }
                        j2 = j6;
                    }
                    if (b6 <= -65 && ((b5 != -32 || b6 >= -96) && (b5 != -19 || b6 < -96))) {
                        j = j2 + 1;
                    }
                    return -1;
                }
                byte b7 = (byte) (~(i >> 8));
                if (b7 == 0) {
                    long j7 = j2 + 1;
                    b7 = UnsafeUtil.getByte(bArr, j2);
                    if (j7 >= j3) {
                        return Utf8.incompleteStateFor(b5, b7);
                    }
                    b = 0;
                    j2 = j7;
                } else {
                    b = (byte) (i >> 16);
                }
                if (b == 0) {
                    long j8 = j2 + 1;
                    b = UnsafeUtil.getByte(bArr, j2);
                    if (j8 >= j3) {
                        return Utf8.incompleteStateFor(b5, b7, b);
                    }
                    j2 = j8;
                }
                if (b7 <= -65) {
                    if ((((b7 + SprAttributeBase.TYPE_SHADOW) + (b5 << 28)) >> 30) == 0 && b <= -65) {
                        j = j2 + 1;
                    }
                }
                return -1;
                j2 = j;
            }
            return partialIsValidUtf8(bArr, j2, (int) (j3 - j2));
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x002d, code lost:
        
            if (androidx.datastore.preferences.protobuf.UnsafeUtil.getByte(r0) > (-65)) goto L17;
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x0061, code lost:
        
            if (androidx.datastore.preferences.protobuf.UnsafeUtil.getByte(r0) > (-65)) goto L36;
         */
        /* JADX WARN: Code restructure failed: missing block: B:56:0x00a3, code lost:
        
            if (androidx.datastore.preferences.protobuf.UnsafeUtil.getByte(r0) > (-65)) goto L57;
         */
        @Override // androidx.datastore.preferences.protobuf.Utf8.Processor
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public int partialIsValidUtf8Direct(int i, ByteBuffer byteBuffer, int i2, int i4) {
            byte b;
            long j;
            if ((i2 | i4 | (byteBuffer.limit() - i4)) < 0) {
                throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", Integer.valueOf(byteBuffer.limit()), Integer.valueOf(i2), Integer.valueOf(i4)));
            }
            long jAddressOffset = UnsafeUtil.addressOffset(byteBuffer) + ((long) i2);
            long j2 = ((long) (i4 - i2)) + jAddressOffset;
            if (i != 0) {
                if (jAddressOffset >= j2) {
                    return i;
                }
                byte b5 = (byte) i;
                if (b5 < -32) {
                    if (b5 >= -62) {
                        j = 1 + jAddressOffset;
                    }
                    return -1;
                }
                if (b5 < -16) {
                    byte b6 = (byte) (~(i >> 8));
                    if (b6 == 0) {
                        long j3 = jAddressOffset + 1;
                        b6 = UnsafeUtil.getByte(jAddressOffset);
                        if (j3 >= j2) {
                            return Utf8.incompleteStateFor(b5, b6);
                        }
                        jAddressOffset = j3;
                    }
                    if (b6 <= -65 && ((b5 != -32 || b6 >= -96) && (b5 != -19 || b6 < -96))) {
                        j = 1 + jAddressOffset;
                    }
                    return -1;
                }
                byte b7 = (byte) (~(i >> 8));
                if (b7 == 0) {
                    long j5 = jAddressOffset + 1;
                    b7 = UnsafeUtil.getByte(jAddressOffset);
                    if (j5 >= j2) {
                        return Utf8.incompleteStateFor(b5, b7);
                    }
                    b = 0;
                    jAddressOffset = j5;
                } else {
                    b = (byte) (i >> 16);
                }
                if (b == 0) {
                    long j6 = jAddressOffset + 1;
                    b = UnsafeUtil.getByte(jAddressOffset);
                    if (j6 >= j2) {
                        return Utf8.incompleteStateFor(b5, b7, b);
                    }
                    jAddressOffset = j6;
                }
                if (b7 <= -65) {
                    if ((((b7 + SprAttributeBase.TYPE_SHADOW) + (b5 << 28)) >> 30) == 0 && b <= -65) {
                        j = 1 + jAddressOffset;
                    }
                }
                return -1;
                jAddressOffset = j;
            }
            return partialIsValidUtf8(jAddressOffset, (int) (j2 - jAddressOffset));
        }

        private static int unsafeEstimateConsecutiveAscii(long j, int i) {
            if (i < 16) {
                return 0;
            }
            int i2 = 8 - (((int) j) & 7);
            int i4 = i2;
            while (i4 > 0) {
                long j2 = 1 + j;
                if (UnsafeUtil.getByte(j) < 0) {
                    return i2 - i4;
                }
                i4--;
                j = j2;
            }
            int i5 = i - i2;
            while (i5 >= 8 && (UnsafeUtil.getLong(j) & (-9187201950435737472L)) == 0) {
                j += 8;
                i5 -= 8;
            }
            return i - i5;
        }

        private static int unsafeIncompleteStateFor(long j, int i, int i2) {
            if (i2 == 0) {
                return Utf8.incompleteStateFor(i);
            }
            if (i2 == 1) {
                return Utf8.incompleteStateFor(i, UnsafeUtil.getByte(j));
            }
            if (i2 == 2) {
                return Utf8.incompleteStateFor(i, UnsafeUtil.getByte(j), UnsafeUtil.getByte(j + 1));
            }
            throw new AssertionError();
        }

        /* JADX WARN: Code restructure failed: missing block: B:22:0x0039, code lost:
        
            return -1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x0064, code lost:
        
            return -1;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private static int partialIsValidUtf8(byte[] bArr, long j, int i) {
            int iUnsafeEstimateConsecutiveAscii = unsafeEstimateConsecutiveAscii(bArr, j, i);
            int i2 = i - iUnsafeEstimateConsecutiveAscii;
            long j2 = j + ((long) iUnsafeEstimateConsecutiveAscii);
            while (true) {
                byte b = 0;
                while (true) {
                    if (i2 <= 0) {
                        break;
                    }
                    long j3 = j2 + 1;
                    b = UnsafeUtil.getByte(bArr, j2);
                    if (b < 0) {
                        j2 = j3;
                        break;
                    }
                    i2--;
                    j2 = j3;
                }
                if (i2 != 0) {
                    int i4 = i2 - 1;
                    if (b >= -32) {
                        if (b >= -16) {
                            if (i4 < 3) {
                                return unsafeIncompleteStateFor(bArr, b, j2, i4);
                            }
                            i2 -= 4;
                            long j5 = 1 + j2;
                            byte b5 = UnsafeUtil.getByte(bArr, j2);
                            if (b5 > -65) {
                                break;
                            }
                            if ((((b5 + SprAttributeBase.TYPE_SHADOW) + (b << 28)) >> 30) != 0) {
                                break;
                            }
                            long j6 = 2 + j2;
                            if (UnsafeUtil.getByte(bArr, j5) > -65) {
                                break;
                            }
                            j2 += 3;
                            if (UnsafeUtil.getByte(bArr, j6) > -65) {
                                break;
                            }
                        } else {
                            if (i4 < 2) {
                                return unsafeIncompleteStateFor(bArr, b, j2, i4);
                            }
                            i2 -= 3;
                            long j7 = 1 + j2;
                            byte b6 = UnsafeUtil.getByte(bArr, j2);
                            if (b6 > -65 || ((b == -32 && b6 < -96) || (b == -19 && b6 >= -96))) {
                                break;
                            }
                            j2 += 2;
                            if (UnsafeUtil.getByte(bArr, j7) > -65) {
                                break;
                            }
                        }
                    } else if (i4 != 0) {
                        i2 -= 2;
                        if (b < -62) {
                            break;
                        }
                        long j8 = 1 + j2;
                        if (UnsafeUtil.getByte(bArr, j2) > -65) {
                            break;
                        }
                        j2 = j8;
                    } else {
                        return b;
                    }
                } else {
                    return 0;
                }
            }
            return -1;
        }

        /* JADX WARN: Code restructure failed: missing block: B:22:0x0039, code lost:
        
            return -1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x0064, code lost:
        
            return -1;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private static int partialIsValidUtf8(long j, int i) {
            int iUnsafeEstimateConsecutiveAscii = unsafeEstimateConsecutiveAscii(j, i);
            long j2 = j + ((long) iUnsafeEstimateConsecutiveAscii);
            int i2 = i - iUnsafeEstimateConsecutiveAscii;
            while (true) {
                byte b = 0;
                while (true) {
                    if (i2 <= 0) {
                        break;
                    }
                    long j3 = j2 + 1;
                    b = UnsafeUtil.getByte(j2);
                    if (b < 0) {
                        j2 = j3;
                        break;
                    }
                    i2--;
                    j2 = j3;
                }
                if (i2 != 0) {
                    int i4 = i2 - 1;
                    if (b >= -32) {
                        if (b >= -16) {
                            if (i4 < 3) {
                                return unsafeIncompleteStateFor(j2, b, i4);
                            }
                            i2 -= 4;
                            long j5 = 1 + j2;
                            byte b5 = UnsafeUtil.getByte(j2);
                            if (b5 > -65) {
                                break;
                            }
                            if ((((b5 + SprAttributeBase.TYPE_SHADOW) + (b << 28)) >> 30) != 0) {
                                break;
                            }
                            long j6 = 2 + j2;
                            if (UnsafeUtil.getByte(j5) > -65) {
                                break;
                            }
                            j2 += 3;
                            if (UnsafeUtil.getByte(j6) > -65) {
                                break;
                            }
                        } else {
                            if (i4 < 2) {
                                return unsafeIncompleteStateFor(j2, b, i4);
                            }
                            i2 -= 3;
                            long j7 = 1 + j2;
                            byte b6 = UnsafeUtil.getByte(j2);
                            if (b6 > -65 || ((b == -32 && b6 < -96) || (b == -19 && b6 >= -96))) {
                                break;
                            }
                            j2 += 2;
                            if (UnsafeUtil.getByte(j7) > -65) {
                                break;
                            }
                        }
                    } else if (i4 != 0) {
                        i2 -= 2;
                        if (b < -62) {
                            break;
                        }
                        long j8 = 1 + j2;
                        if (UnsafeUtil.getByte(j2) > -65) {
                            break;
                        }
                        j2 = j8;
                    } else {
                        return b;
                    }
                } else {
                    return 0;
                }
            }
            return -1;
        }
    }

    static {
        processor = (!UnsafeProcessor.isAvailable() || Android.isOnAndroidDevice()) ? new SafeProcessor() : new UnsafeProcessor();
    }

    private Utf8() {
    }

    public static String decodeUtf8(ByteBuffer byteBuffer, int i, int i2) {
        return processor.decodeUtf8(byteBuffer, i, i2);
    }

    public static int encode(CharSequence charSequence, byte[] bArr, int i, int i2) {
        return processor.encodeUtf8(charSequence, bArr, i, i2);
    }

    public static void encodeUtf8(CharSequence charSequence, ByteBuffer byteBuffer) {
        processor.encodeUtf8(charSequence, byteBuffer);
    }

    public static int encodedLength(CharSequence charSequence) {
        int length = charSequence.length();
        int i = 0;
        while (i < length && charSequence.charAt(i) < 128) {
            i++;
        }
        int iEncodedLengthGeneral = length;
        while (true) {
            if (i < length) {
                char cCharAt = charSequence.charAt(i);
                if (cCharAt >= 2048) {
                    iEncodedLengthGeneral += encodedLengthGeneral(charSequence, i);
                    break;
                }
                iEncodedLengthGeneral += (127 - cCharAt) >>> 31;
                i++;
            } else {
                break;
            }
        }
        if (iEncodedLengthGeneral >= length) {
            return iEncodedLengthGeneral;
        }
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (((long) iEncodedLengthGeneral) + 4294967296L));
    }

    private static int encodedLengthGeneral(CharSequence charSequence, int i) {
        int length = charSequence.length();
        int i2 = 0;
        while (i < length) {
            char cCharAt = charSequence.charAt(i);
            if (cCharAt < 2048) {
                i2 += (127 - cCharAt) >>> 31;
            } else {
                i2 += 2;
                if (55296 <= cCharAt && cCharAt <= 57343) {
                    if (Character.codePointAt(charSequence, i) < 65536) {
                        throw new UnpairedSurrogateException(i, length);
                    }
                    i++;
                }
            }
            i++;
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int estimateConsecutiveAscii(ByteBuffer byteBuffer, int i, int i2) {
        int i4 = i2 - 7;
        int i5 = i;
        while (i5 < i4 && (byteBuffer.getLong(i5) & (-9187201950435737472L)) == 0) {
            i5 += 8;
        }
        return i5 - i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int incompleteStateFor(int i) {
        if (i > -12) {
            return -1;
        }
        return i;
    }

    public static boolean isValidUtf8(byte[] bArr) {
        return processor.isValidUtf8(bArr, 0, bArr.length);
    }

    public static int partialIsValidUtf8(int i, byte[] bArr, int i2, int i4) {
        return processor.partialIsValidUtf8(i, bArr, i2, i4);
    }

    public static String decodeUtf8(byte[] bArr, int i, int i2) {
        return processor.decodeUtf8(bArr, i, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int incompleteStateFor(int i, int i2) {
        if (i > -12 || i2 > -65) {
            return -1;
        }
        return i ^ (i2 << 8);
    }

    public static boolean isValidUtf8(byte[] bArr, int i, int i2) {
        return processor.isValidUtf8(bArr, i, i2);
    }

    public static int partialIsValidUtf8(int i, ByteBuffer byteBuffer, int i2, int i4) {
        return processor.partialIsValidUtf8(i, byteBuffer, i2, i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int incompleteStateFor(int i, int i2, int i4) {
        if (i > -12 || i2 > -65 || i4 > -65) {
            return -1;
        }
        return (i ^ (i2 << 8)) ^ (i4 << 16);
    }

    public static boolean isValidUtf8(ByteBuffer byteBuffer) {
        return processor.isValidUtf8(byteBuffer, byteBuffer.position(), byteBuffer.remaining());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int incompleteStateFor(byte[] bArr, int i, int i2) {
        byte b = bArr[i - 1];
        int i4 = i2 - i;
        if (i4 == 0) {
            return incompleteStateFor(b);
        }
        if (i4 == 1) {
            return incompleteStateFor(b, bArr[i]);
        }
        if (i4 == 2) {
            return incompleteStateFor(b, bArr[i], bArr[i + 1]);
        }
        throw new AssertionError();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int incompleteStateFor(ByteBuffer byteBuffer, int i, int i2, int i4) {
        if (i4 == 0) {
            return incompleteStateFor(i);
        }
        if (i4 == 1) {
            return incompleteStateFor(i, byteBuffer.get(i2));
        }
        if (i4 == 2) {
            return incompleteStateFor(i, byteBuffer.get(i2), byteBuffer.get(i2 + 1));
        }
        throw new AssertionError();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class SafeProcessor extends Processor {
        private static int partialIsValidUtf8NonAscii(byte[] bArr, int i, int i2) {
            while (i < i2) {
                int i4 = i + 1;
                byte b = bArr[i];
                if (b < 0) {
                    if (b < -32) {
                        if (i4 >= i2) {
                            return b;
                        }
                        if (b >= -62) {
                            i += 2;
                            if (bArr[i4] > -65) {
                            }
                        }
                        return -1;
                    }
                    if (b < -16) {
                        if (i4 >= i2 - 1) {
                            return Utf8.incompleteStateFor(bArr, i4, i2);
                        }
                        int i5 = i + 2;
                        byte b5 = bArr[i4];
                        if (b5 <= -65 && ((b != -32 || b5 >= -96) && (b != -19 || b5 < -96))) {
                            i += 3;
                            if (bArr[i5] > -65) {
                            }
                        }
                        return -1;
                    }
                    if (i4 >= i2 - 2) {
                        return Utf8.incompleteStateFor(bArr, i4, i2);
                    }
                    int i6 = i + 2;
                    byte b6 = bArr[i4];
                    if (b6 <= -65) {
                        if ((((b6 + SprAttributeBase.TYPE_SHADOW) + (b << 28)) >> 30) == 0) {
                            int i7 = i + 3;
                            if (bArr[i6] <= -65) {
                                i += 4;
                                if (bArr[i7] > -65) {
                                }
                            }
                        }
                    }
                    return -1;
                }
                i = i4;
            }
            return 0;
        }

        @Override // androidx.datastore.preferences.protobuf.Utf8.Processor
        public String decodeUtf8(byte[] bArr, int i, int i2) throws InvalidProtocolBufferException {
            if ((i | i2 | ((bArr.length - i) - i2)) < 0) {
                throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)));
            }
            int i4 = i + i2;
            char[] cArr = new char[i2];
            int i5 = 0;
            while (i < i4) {
                byte b = bArr[i];
                if (!DecodeUtil.isOneByte(b)) {
                    break;
                }
                i++;
                DecodeUtil.handleOneByte(b, cArr, i5);
                i5++;
            }
            int i6 = i5;
            while (i < i4) {
                int i7 = i + 1;
                byte b5 = bArr[i];
                if (DecodeUtil.isOneByte(b5)) {
                    int i8 = i6 + 1;
                    DecodeUtil.handleOneByte(b5, cArr, i6);
                    int i9 = i7;
                    while (i9 < i4) {
                        byte b6 = bArr[i9];
                        if (!DecodeUtil.isOneByte(b6)) {
                            break;
                        }
                        i9++;
                        DecodeUtil.handleOneByte(b6, cArr, i8);
                        i8++;
                    }
                    i6 = i8;
                    i = i9;
                } else if (DecodeUtil.isTwoBytes(b5)) {
                    if (i7 >= i4) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    i += 2;
                    DecodeUtil.handleTwoBytes(b5, bArr[i7], cArr, i6);
                    i6++;
                } else if (DecodeUtil.isThreeBytes(b5)) {
                    if (i7 >= i4 - 1) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    int i10 = i + 2;
                    i += 3;
                    DecodeUtil.handleThreeBytes(b5, bArr[i7], bArr[i10], cArr, i6);
                    i6++;
                } else {
                    if (i7 >= i4 - 2) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    byte b7 = bArr[i7];
                    int i11 = i + 3;
                    byte b8 = bArr[i + 2];
                    i += 4;
                    DecodeUtil.handleFourBytes(b5, b7, b8, bArr[i11], cArr, i6);
                    i6 += 2;
                }
            }
            return new String(cArr, 0, i6);
        }

        @Override // androidx.datastore.preferences.protobuf.Utf8.Processor
        public String decodeUtf8Direct(ByteBuffer byteBuffer, int i, int i2) {
            return decodeUtf8Default(byteBuffer, i, i2);
        }

        @Override // androidx.datastore.preferences.protobuf.Utf8.Processor
        public int encodeUtf8(CharSequence charSequence, byte[] bArr, int i, int i2) {
            int i4;
            int i5;
            char cCharAt;
            int length = charSequence.length();
            int i6 = i2 + i;
            int i7 = 0;
            while (i7 < length && (i5 = i7 + i) < i6 && (cCharAt = charSequence.charAt(i7)) < 128) {
                bArr[i5] = (byte) cCharAt;
                i7++;
            }
            if (i7 == length) {
                return i + length;
            }
            int i8 = i + i7;
            while (i7 < length) {
                char cCharAt2 = charSequence.charAt(i7);
                if (cCharAt2 < 128 && i8 < i6) {
                    bArr[i8] = (byte) cCharAt2;
                    i8++;
                } else if (cCharAt2 < 2048 && i8 <= i6 - 2) {
                    int i9 = i8 + 1;
                    bArr[i8] = (byte) ((cCharAt2 >>> 6) | 960);
                    i8 += 2;
                    bArr[i9] = (byte) ((cCharAt2 & '?') | 128);
                } else {
                    if ((cCharAt2 >= 55296 && 57343 >= cCharAt2) || i8 > i6 - 3) {
                        if (i8 > i6 - 4) {
                            if (55296 <= cCharAt2 && cCharAt2 <= 57343 && ((i4 = i7 + 1) == charSequence.length() || !Character.isSurrogatePair(cCharAt2, charSequence.charAt(i4)))) {
                                throw new UnpairedSurrogateException(i7, length);
                            }
                            throw new ArrayIndexOutOfBoundsException("Failed writing " + cCharAt2 + " at index " + i8);
                        }
                        int i10 = i7 + 1;
                        if (i10 != charSequence.length()) {
                            char cCharAt3 = charSequence.charAt(i10);
                            if (Character.isSurrogatePair(cCharAt2, cCharAt3)) {
                                int codePoint = Character.toCodePoint(cCharAt2, cCharAt3);
                                bArr[i8] = (byte) ((codePoint >>> 18) | 240);
                                bArr[i8 + 1] = (byte) (((codePoint >>> 12) & 63) | 128);
                                int i11 = i8 + 3;
                                bArr[i8 + 2] = (byte) (((codePoint >>> 6) & 63) | 128);
                                i8 += 4;
                                bArr[i11] = (byte) ((codePoint & 63) | 128);
                                i7 = i10;
                            } else {
                                i7 = i10;
                            }
                        }
                        throw new UnpairedSurrogateException(i7 - 1, length);
                    }
                    bArr[i8] = (byte) ((cCharAt2 >>> '\f') | 480);
                    int i12 = i8 + 2;
                    bArr[i8 + 1] = (byte) (((cCharAt2 >>> 6) & 63) | 128);
                    i8 += 3;
                    bArr[i12] = (byte) ((cCharAt2 & '?') | 128);
                }
                i7++;
            }
            return i8;
        }

        @Override // androidx.datastore.preferences.protobuf.Utf8.Processor
        public void encodeUtf8Direct(CharSequence charSequence, ByteBuffer byteBuffer) {
            encodeUtf8Default(charSequence, byteBuffer);
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0015, code lost:
        
            if (r8[r9] > (-65)) goto L13;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x0046, code lost:
        
            if (r8[r9] > (-65)) goto L32;
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x0083, code lost:
        
            if (r8[r7] > (-65)) goto L53;
         */
        @Override // androidx.datastore.preferences.protobuf.Utf8.Processor
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public int partialIsValidUtf8(int i, byte[] bArr, int i2, int i4) {
            byte b;
            int i5;
            int i6;
            if (i != 0) {
                if (i2 >= i4) {
                    return i;
                }
                byte b5 = (byte) i;
                if (b5 < -32) {
                    if (b5 >= -62) {
                        i6 = i2 + 1;
                    }
                    return -1;
                }
                if (b5 < -16) {
                    byte b6 = (byte) (~(i >> 8));
                    if (b6 == 0) {
                        int i7 = i2 + 1;
                        byte b7 = bArr[i2];
                        if (i7 >= i4) {
                            return Utf8.incompleteStateFor(b5, b7);
                        }
                        i2 = i7;
                        b6 = b7;
                    }
                    if (b6 <= -65 && ((b5 != -32 || b6 >= -96) && (b5 != -19 || b6 < -96))) {
                        i6 = i2 + 1;
                    }
                    return -1;
                }
                byte b8 = (byte) (~(i >> 8));
                if (b8 == 0) {
                    i5 = i2 + 1;
                    b8 = bArr[i2];
                    if (i5 >= i4) {
                        return Utf8.incompleteStateFor(b5, b8);
                    }
                    b = 0;
                } else {
                    b = (byte) (i >> 16);
                    i5 = i2;
                }
                if (b == 0) {
                    int i8 = i5 + 1;
                    byte b9 = bArr[i5];
                    if (i8 >= i4) {
                        return Utf8.incompleteStateFor(b5, b8, b9);
                    }
                    b = b9;
                    i5 = i8;
                }
                if (b8 <= -65) {
                    if ((((b8 + SprAttributeBase.TYPE_SHADOW) + (b5 << 28)) >> 30) == 0 && b <= -65) {
                        i2 = i5 + 1;
                    }
                }
                return -1;
                i2 = i6;
            }
            return partialIsValidUtf8(bArr, i2, i4);
        }

        @Override // androidx.datastore.preferences.protobuf.Utf8.Processor
        public int partialIsValidUtf8Direct(int i, ByteBuffer byteBuffer, int i2, int i4) {
            return partialIsValidUtf8Default(i, byteBuffer, i2, i4);
        }

        private static int partialIsValidUtf8(byte[] bArr, int i, int i2) {
            while (i < i2 && bArr[i] >= 0) {
                i++;
            }
            if (i >= i2) {
                return 0;
            }
            return partialIsValidUtf8NonAscii(bArr, i, i2);
        }
    }
}
