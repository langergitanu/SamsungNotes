package com.fasterxml.jackson.core.p128io;

import com.sun.imageio.plugins.jpeg.JPEG;
import java.util.Arrays;
import net.lingala.zip4j.crypto.PBKDF2.BinTools;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class CharTypes {
    private static final byte[] HEX_BYTES;
    private static final char[] HEX_CHARS;
    static final int[] sHexValues;
    static final int[] sInputCodes;
    static final int[] sInputCodesComment;
    static final int[] sInputCodesJsNames;
    static final int[] sInputCodesUtf8;
    static final int[] sInputCodesUtf8JsNames;
    static final int[] sOutputEscapes128;

    static {
        char[] charArray = BinTools.hex.toCharArray();
        HEX_CHARS = charArray;
        int length = charArray.length;
        HEX_BYTES = new byte[length];
        for (int i = 0; i < length; i++) {
            HEX_BYTES[i] = (byte) HEX_CHARS[i];
        }
        int[] iArr = new int[256];
        for (int i2 = 0; i2 < 32; i2++) {
            iArr[i2] = -1;
        }
        iArr[34] = 1;
        iArr[92] = 1;
        sInputCodes = iArr;
        int[] iArr2 = new int[iArr.length];
        System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
        for (int i4 = 128; i4 < 256; i4++) {
            iArr2[i4] = (i4 & JPEG.APP0) == 192 ? 2 : (i4 & 240) == 224 ? 3 : (i4 & 248) == 240 ? 4 : -1;
        }
        sInputCodesUtf8 = iArr2;
        int[] iArr3 = new int[256];
        Arrays.fill(iArr3, -1);
        for (int i5 = 33; i5 < 256; i5++) {
            if (Character.isJavaIdentifierPart((char) i5)) {
                iArr3[i5] = 0;
            }
        }
        iArr3[64] = 0;
        iArr3[35] = 0;
        iArr3[42] = 0;
        iArr3[45] = 0;
        iArr3[43] = 0;
        sInputCodesJsNames = iArr3;
        int[] iArr4 = new int[256];
        System.arraycopy(iArr3, 0, iArr4, 0, iArr3.length);
        Arrays.fill(iArr4, 128, 128, 0);
        sInputCodesUtf8JsNames = iArr4;
        int[] iArr5 = new int[256];
        sInputCodesComment = iArr5;
        System.arraycopy(sInputCodesUtf8, 128, iArr5, 128, 128);
        Arrays.fill(iArr5, 0, 32, -1);
        iArr5[9] = 0;
        iArr5[10] = 10;
        iArr5[13] = 13;
        iArr5[42] = 42;
        int[] iArr6 = new int[128];
        for (int i6 = 0; i6 < 32; i6++) {
            iArr6[i6] = -1;
        }
        iArr6[34] = 34;
        iArr6[92] = 92;
        iArr6[8] = 98;
        iArr6[9] = 116;
        iArr6[12] = 102;
        iArr6[10] = 110;
        iArr6[13] = 114;
        sOutputEscapes128 = iArr6;
        int[] iArr7 = new int[128];
        sHexValues = iArr7;
        Arrays.fill(iArr7, -1);
        for (int i7 = 0; i7 < 10; i7++) {
            sHexValues[i7 + 48] = i7;
        }
        for (int i8 = 0; i8 < 6; i8++) {
            int[] iArr8 = sHexValues;
            int i9 = i8 + 10;
            iArr8[i8 + 97] = i9;
            iArr8[i8 + 65] = i9;
        }
    }

    public static void appendQuoted(StringBuilder sb, String str) {
        int[] iArr = sOutputEscapes128;
        int length = iArr.length;
        int length2 = str.length();
        for (int i = 0; i < length2; i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt >= length || iArr[cCharAt] == 0) {
                sb.append(cCharAt);
            } else {
                sb.append('\\');
                int i2 = iArr[cCharAt];
                if (i2 < 0) {
                    sb.append('u');
                    sb.append('0');
                    sb.append('0');
                    int i4 = -(i2 + 1);
                    char[] cArr = HEX_CHARS;
                    sb.append(cArr[i4 >> 4]);
                    sb.append(cArr[i4 & 15]);
                } else {
                    sb.append((char) i2);
                }
            }
        }
    }

    public static int charToHex(int i) {
        if (i > 127) {
            return -1;
        }
        return sHexValues[i];
    }

    public static byte[] copyHexBytes() {
        return (byte[]) HEX_BYTES.clone();
    }

    public static char[] copyHexChars() {
        return (char[]) HEX_CHARS.clone();
    }

    public static int[] get7BitOutputEscapes() {
        return sOutputEscapes128;
    }

    public static int[] getInputCodeComment() {
        return sInputCodesComment;
    }

    public static int[] getInputCodeLatin1() {
        return sInputCodes;
    }

    public static int[] getInputCodeLatin1JsNames() {
        return sInputCodesJsNames;
    }

    public static int[] getInputCodeUtf8() {
        return sInputCodesUtf8;
    }

    public static int[] getInputCodeUtf8JsNames() {
        return sInputCodesUtf8JsNames;
    }
}
