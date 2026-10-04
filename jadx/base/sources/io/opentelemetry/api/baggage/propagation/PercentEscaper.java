package io.opentelemetry.api.baggage.propagation;

import io.opentelemetry.api.internal.TemporaryBuffers;
import javax.annotation.CheckForNull;
import net.lingala.zip4j.crypto.PBKDF2.BinTools;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
final class PercentEscaper {
    private static final int DEST_PAD = 32;
    private static final char[] UPPER_HEX_DIGITS = BinTools.hex.toCharArray();
    private static final String SAFE_CHARS = "-._~!$'()*&@:abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final boolean[] safeOctets = createSafeOctets(SAFE_CHARS);

    private static int codePointAt(CharSequence charSequence, int i, int i2) {
        if (i >= i2) {
            throw new IndexOutOfBoundsException("Index exceeds specified range");
        }
        int i4 = i + 1;
        char cCharAt = charSequence.charAt(i);
        if (cCharAt < 55296 || cCharAt > 57343) {
            return cCharAt;
        }
        if (cCharAt > 56319) {
            throw new IllegalArgumentException("Unexpected low surrogate character '" + cCharAt + "' with value " + ((int) cCharAt) + " at index " + i + " in '" + ((Object) charSequence) + "'");
        }
        if (i4 == i2) {
            return -cCharAt;
        }
        char cCharAt2 = charSequence.charAt(i4);
        if (Character.isLowSurrogate(cCharAt2)) {
            return Character.toCodePoint(cCharAt, cCharAt2);
        }
        throw new IllegalArgumentException("Expected low surrogate but got char '" + cCharAt2 + "' with value " + ((int) cCharAt2) + " at index " + i4 + " in '" + ((Object) charSequence) + "'");
    }

    public static PercentEscaper create() {
        return new PercentEscaper();
    }

    private static boolean[] createSafeOctets(String str) {
        char[] charArray = str.toCharArray();
        int iMax = -1;
        for (char c : charArray) {
            iMax = Math.max((int) c, iMax);
        }
        boolean[] zArr = new boolean[iMax + 1];
        for (char c2 : charArray) {
            zArr[c2] = true;
        }
        return zArr;
    }

    private static String escapeSlow(String str, int i) {
        int length = str.length();
        char[] cArrChars = TemporaryBuffers.chars(1024);
        int i2 = 0;
        int length2 = 0;
        while (i < length) {
            int iCodePointAt = codePointAt(str, i, length);
            if (iCodePointAt < 0) {
                throw new IllegalArgumentException("Trailing high surrogate at end of input");
            }
            char[] cArrEscape = escape(iCodePointAt);
            int i4 = (Character.isSupplementaryCodePoint(iCodePointAt) ? 2 : 1) + i;
            if (cArrEscape != null) {
                int i5 = i - i2;
                int i6 = length2 + i5;
                int length3 = cArrEscape.length + i6;
                if (cArrChars.length < length3) {
                    cArrChars = growBuffer(cArrChars, length2, (length - i) + length3 + 32);
                }
                if (i5 > 0) {
                    str.getChars(i2, i, cArrChars, length2);
                    length2 = i6;
                }
                if (cArrEscape.length > 0) {
                    System.arraycopy(cArrEscape, 0, cArrChars, length2, cArrEscape.length);
                    length2 += cArrEscape.length;
                }
                i2 = i4;
            }
            i = nextEscapeIndex(str, i4, length);
        }
        int i7 = length - i2;
        if (i7 > 0) {
            int i8 = i7 + length2;
            if (cArrChars.length < i8) {
                cArrChars = growBuffer(cArrChars, length2, i8);
            }
            str.getChars(i2, length, cArrChars, length2);
            length2 = i8;
        }
        return new String(cArrChars, 0, length2);
    }

    private static char[] growBuffer(char[] cArr, int i, int i2) {
        if (i2 < 0) {
            throw new AssertionError("Cannot increase internal buffer any further");
        }
        char[] cArr2 = new char[i2];
        if (i > 0) {
            System.arraycopy(cArr, 0, cArr2, 0, i);
        }
        return cArr2;
    }

    private static int nextEscapeIndex(CharSequence charSequence, int i, int i2) {
        while (i < i2) {
            char cCharAt = charSequence.charAt(i);
            boolean[] zArr = safeOctets;
            if (cCharAt >= zArr.length || !zArr[cCharAt]) {
                break;
            }
            i++;
        }
        return i;
    }

    public String escape(String str) {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            boolean[] zArr = safeOctets;
            if (cCharAt >= zArr.length || !zArr[cCharAt]) {
                return escapeSlow(str, i);
            }
        }
        return str;
    }

    @CheckForNull
    private static char[] escape(int i) {
        boolean[] zArr = safeOctets;
        if (i < zArr.length && zArr[i]) {
            return null;
        }
        if (i <= 127) {
            char[] cArr = UPPER_HEX_DIGITS;
            return new char[]{'%', cArr[i >>> 4], cArr[i & 15]};
        }
        if (i <= 2047) {
            char[] cArr2 = UPPER_HEX_DIGITS;
            return new char[]{'%', cArr2[(i >>> 10) | 12], cArr2[(i >>> 6) & 15], '%', cArr2[((i >>> 4) & 3) | 8], cArr2[i & 15]};
        }
        if (i <= 65535) {
            char[] cArr3 = UPPER_HEX_DIGITS;
            return new char[]{'%', 'E', cArr3[i >>> 12], '%', cArr3[((i >>> 10) & 3) | 8], cArr3[(i >>> 6) & 15], '%', cArr3[((i >>> 4) & 3) | 8], cArr3[i & 15]};
        }
        if (i <= 1114111) {
            char[] cArr4 = UPPER_HEX_DIGITS;
            return new char[]{'%', 'F', cArr4[(i >>> 18) & 7], '%', cArr4[((i >>> 16) & 3) | 8], cArr4[(i >>> 12) & 15], '%', cArr4[((i >>> 10) & 3) | 8], cArr4[(i >>> 6) & 15], '%', cArr4[((i >>> 4) & 3) | 8], cArr4[i & 15]};
        }
        throw new IllegalArgumentException(AbstractC0000a.m11h(i, "Invalid unicode character value "));
    }
}
