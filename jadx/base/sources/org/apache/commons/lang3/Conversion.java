package org.apache.commons.lang3;

import androidx.compose.runtime.AbstractC1974b;
import com.samsung.android.sdk.smp.common.util.DeviceInfoUtil;
import java.util.UUID;
import kotlin.UShort;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class Conversion {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final boolean[] TTTT = {true, true, true, true};
    private static final boolean[] FTTT = {false, true, true, true};
    private static final boolean[] TFTT = {true, false, true, true};
    private static final boolean[] FFTT = {false, false, true, true};
    private static final boolean[] TTFT = {true, true, false, true};
    private static final boolean[] FTFT = {false, true, false, true};
    private static final boolean[] TFFT = {true, false, false, true};
    private static final boolean[] FFFT = {false, false, false, true};
    private static final boolean[] TTTF = {true, true, true, false};
    private static final boolean[] FTTF = {false, true, true, false};
    private static final boolean[] TFTF = {true, false, true, false};
    private static final boolean[] FFTF = {false, false, true, false};
    private static final boolean[] TTFF = {true, true, false, false};
    private static final boolean[] FTFF = {false, true, false, false};
    private static final boolean[] TFFF = {true, false, false, false};
    private static final boolean[] FFFF = {false, false, false, false};

    @Deprecated
    public Conversion() {
    }

    public static char binaryBeMsb0ToHexDigit(boolean[] zArr) {
        return binaryBeMsb0ToHexDigit(zArr, 0);
    }

    public static byte binaryToByte(boolean[] zArr, int i, byte b, int i2, int i4) {
        if ((zArr.length == 0 && i == 0) || i4 == 0) {
            return b;
        }
        if ((i4 - 1) + i2 >= 8) {
            throw new IllegalArgumentException("nBools-1+dstPos is greater or equal to than 8");
        }
        for (int i5 = 0; i5 < i4; i5++) {
            int i6 = i5 + i2;
            b = (byte) ((b & (~(1 << i6))) | ((zArr[i5 + i] ? 1 : 0) << i6));
        }
        return b;
    }

    public static char binaryToHexDigit(boolean[] zArr) {
        return binaryToHexDigit(zArr, 0);
    }

    public static char binaryToHexDigitMsb0_4bits(boolean[] zArr) {
        return binaryToHexDigitMsb0_4bits(zArr, 0);
    }

    public static int binaryToInt(boolean[] zArr, int i, int i2, int i4, int i5) {
        if ((zArr.length == 0 && i == 0) || i5 == 0) {
            return i2;
        }
        if ((i5 - 1) + i4 >= 32) {
            throw new IllegalArgumentException("nBools-1+dstPos is greater or equal to than 32");
        }
        for (int i6 = 0; i6 < i5; i6++) {
            int i7 = i6 + i4;
            i2 = (i2 & (~(1 << i7))) | ((zArr[i6 + i] ? 1 : 0) << i7);
        }
        return i2;
    }

    public static long binaryToLong(boolean[] zArr, int i, long j, int i2, int i4) {
        if ((zArr.length == 0 && i == 0) || i4 == 0) {
            return j;
        }
        if ((i4 - 1) + i2 >= 64) {
            throw new IllegalArgumentException("nBools-1+dstPos is greater or equal to than 64");
        }
        for (int i5 = 0; i5 < i4; i5++) {
            int i6 = i5 + i2;
            j = (j & (~(1 << i6))) | ((zArr[i5 + i] ? 1L : 0L) << i6);
        }
        return j;
    }

    public static short binaryToShort(boolean[] zArr, int i, short s, int i2, int i4) {
        if ((zArr.length == 0 && i == 0) || i4 == 0) {
            return s;
        }
        if ((i4 - 1) + i2 >= 16) {
            throw new IllegalArgumentException("nBools-1+dstPos is greater or equal to than 16");
        }
        for (int i5 = 0; i5 < i4; i5++) {
            int i6 = i5 + i2;
            s = (short) ((s & (~(1 << i6))) | ((zArr[i5 + i] ? 1 : 0) << i6));
        }
        return s;
    }

    public static int byteArrayToInt(byte[] bArr, int i, int i2, int i4, int i5) {
        if ((bArr.length == 0 && i == 0) || i5 == 0) {
            return i2;
        }
        if (AbstractC1974b.m1304A(i5, 1, 8, i4) >= 32) {
            throw new IllegalArgumentException("(nBytes-1)*8+dstPos is greater or equal to than 32");
        }
        for (int i6 = 0; i6 < i5; i6++) {
            int i7 = (i6 * 8) + i4;
            i2 = (i2 & (~(255 << i7))) | ((bArr[i6 + i] & 255) << i7);
        }
        return i2;
    }

    public static long byteArrayToLong(byte[] bArr, int i, long j, int i2, int i4) {
        if ((bArr.length == 0 && i == 0) || i4 == 0) {
            return j;
        }
        if (AbstractC1974b.m1304A(i4, 1, 8, i2) >= 64) {
            throw new IllegalArgumentException("(nBytes-1)*8+dstPos is greater or equal to than 64");
        }
        for (int i5 = 0; i5 < i4; i5++) {
            int i6 = (i5 * 8) + i2;
            j = (j & (~(255 << i6))) | ((((long) bArr[i5 + i]) & 255) << i6);
        }
        return j;
    }

    public static short byteArrayToShort(byte[] bArr, int i, short s, int i2, int i4) {
        if ((bArr.length == 0 && i == 0) || i4 == 0) {
            return s;
        }
        if (AbstractC1974b.m1304A(i4, 1, 8, i2) >= 16) {
            throw new IllegalArgumentException("(nBytes-1)*8+dstPos is greater or equal to than 16");
        }
        for (int i5 = 0; i5 < i4; i5++) {
            int i6 = (i5 * 8) + i2;
            s = (short) ((s & (~(255 << i6))) | ((bArr[i5 + i] & 255) << i6));
        }
        return s;
    }

    public static UUID byteArrayToUuid(byte[] bArr, int i) {
        if (bArr.length - i >= 16) {
            return new UUID(byteArrayToLong(bArr, i, 0L, 0, 8), byteArrayToLong(bArr, i + 8, 0L, 0, 8));
        }
        throw new IllegalArgumentException("Need at least 16 bytes for UUID");
    }

    public static boolean[] byteToBinary(byte b, int i, boolean[] zArr, int i2, int i4) {
        if (i4 != 0) {
            if ((i4 - 1) + i >= 8) {
                throw new IllegalArgumentException("nBools-1+srcPos is greater or equal to than 8");
            }
            for (int i5 = 0; i5 < i4; i5++) {
                int i6 = i2 + i5;
                boolean z = true;
                if (((b >> (i5 + i)) & 1) == 0) {
                    z = false;
                }
                zArr[i6] = z;
            }
        }
        return zArr;
    }

    public static String byteToHex(byte b, int i, String str, int i2, int i4) {
        if (i4 == 0) {
            return str;
        }
        if (AbstractC1974b.m1304A(i4, 1, 4, i) >= 8) {
            throw new IllegalArgumentException("(nHexs-1)*4+srcPos is greater or equal to than 8");
        }
        StringBuilder sb = new StringBuilder(str);
        int length = sb.length();
        for (int i5 = 0; i5 < i4; i5++) {
            int i6 = (b >> ((i5 * 4) + i)) & 15;
            int i7 = i2 + i5;
            if (i7 == length) {
                length++;
                sb.append(intToHexDigit(i6));
            } else {
                sb.setCharAt(i7, intToHexDigit(i6));
            }
        }
        return sb.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0022  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean[] hexDigitMsb0ToBinary(char c) {
        switch (c) {
            case '0':
                return (boolean[]) FFFF.clone();
            case '1':
                return (boolean[]) FFFT.clone();
            case '2':
                return (boolean[]) FFTF.clone();
            case '3':
                return (boolean[]) FFTT.clone();
            case '4':
                return (boolean[]) FTFF.clone();
            case '5':
                return (boolean[]) FTFT.clone();
            case '6':
                return (boolean[]) FTTF.clone();
            case '7':
                return (boolean[]) FTTT.clone();
            case '8':
                return (boolean[]) TFFF.clone();
            case '9':
                return (boolean[]) TFFT.clone();
            default:
                switch (c) {
                    case 'A':
                        return (boolean[]) TFTF.clone();
                    case 'B':
                        return (boolean[]) TFTT.clone();
                    case 'C':
                        return (boolean[]) TTFF.clone();
                    case 'D':
                        return (boolean[]) TTFT.clone();
                    case 'E':
                        return (boolean[]) TTTF.clone();
                    case 'F':
                        return (boolean[]) TTTT.clone();
                    default:
                        switch (c) {
                            case 'a':
                                break;
                            case 'b':
                                break;
                            case 'c':
                                break;
                            case 'd':
                                break;
                            case 'e':
                                break;
                            case 'f':
                                break;
                            default:
                                throw new IllegalArgumentException("Cannot interpret '" + c + "' as a hexadecimal digit");
                        }
                        break;
                }
                break;
        }
    }

    public static int hexDigitMsb0ToInt(char c) {
        switch (c) {
            case '0':
                return 0;
            case '1':
                return 8;
            case '2':
                return 4;
            case '3':
                return 12;
            case '4':
                return 2;
            case '5':
                return 10;
            case '6':
                return 6;
            case '7':
                return 14;
            case '8':
                return 1;
            case '9':
                return 9;
            default:
                switch (c) {
                    case 'A':
                        return 5;
                    case 'B':
                        return 13;
                    case 'C':
                        return 3;
                    case 'D':
                        return 11;
                    case 'E':
                        return 7;
                    case 'F':
                        return 15;
                    default:
                        switch (c) {
                            case 'a':
                                return 5;
                            case 'b':
                                return 13;
                            case 'c':
                                return 3;
                            case 'd':
                                return 11;
                            case 'e':
                                return 7;
                            case 'f':
                                return 15;
                            default:
                                throw new IllegalArgumentException("Cannot interpret '" + c + "' as a hexadecimal digit");
                        }
                }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0022  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean[] hexDigitToBinary(char c) {
        switch (c) {
            case '0':
                return (boolean[]) FFFF.clone();
            case '1':
                return (boolean[]) TFFF.clone();
            case '2':
                return (boolean[]) FTFF.clone();
            case '3':
                return (boolean[]) TTFF.clone();
            case '4':
                return (boolean[]) FFTF.clone();
            case '5':
                return (boolean[]) TFTF.clone();
            case '6':
                return (boolean[]) FTTF.clone();
            case '7':
                return (boolean[]) TTTF.clone();
            case '8':
                return (boolean[]) FFFT.clone();
            case '9':
                return (boolean[]) TFFT.clone();
            default:
                switch (c) {
                    case 'A':
                        return (boolean[]) FTFT.clone();
                    case 'B':
                        return (boolean[]) TTFT.clone();
                    case 'C':
                        return (boolean[]) FFTT.clone();
                    case 'D':
                        return (boolean[]) TFTT.clone();
                    case 'E':
                        return (boolean[]) FTTT.clone();
                    case 'F':
                        return (boolean[]) TTTT.clone();
                    default:
                        switch (c) {
                            case 'a':
                                break;
                            case 'b':
                                break;
                            case 'c':
                                break;
                            case 'd':
                                break;
                            case 'e':
                                break;
                            case 'f':
                                break;
                            default:
                                throw new IllegalArgumentException("Cannot interpret '" + c + "' as a hexadecimal digit");
                        }
                        break;
                }
                break;
        }
    }

    public static int hexDigitToInt(char c) {
        int iDigit = Character.digit(c, 16);
        if (iDigit >= 0) {
            return iDigit;
        }
        throw new IllegalArgumentException("Cannot interpret '" + c + "' as a hexadecimal digit");
    }

    public static byte hexToByte(String str, int i, byte b, int i2, int i4) {
        if (i4 == 0) {
            return b;
        }
        if (AbstractC1974b.m1304A(i4, 1, 4, i2) >= 8) {
            throw new IllegalArgumentException("(nHex-1)*4+dstPos is greater than or equal to 8");
        }
        for (int i5 = 0; i5 < i4; i5++) {
            int i6 = (i5 * 4) + i2;
            b = (byte) ((b & (~(15 << i6))) | ((hexDigitToInt(str.charAt(i5 + i)) & 15) << i6));
        }
        return b;
    }

    public static int hexToInt(String str, int i, int i2, int i4, int i5) {
        if (i5 == 0) {
            return i2;
        }
        if (AbstractC1974b.m1304A(i5, 1, 4, i4) >= 32) {
            throw new IllegalArgumentException("(nHexs-1)*4+dstPos is greater or equal to than 32");
        }
        for (int i6 = 0; i6 < i5; i6++) {
            int i7 = (i6 * 4) + i4;
            i2 = (i2 & (~(15 << i7))) | ((hexDigitToInt(str.charAt(i6 + i)) & 15) << i7);
        }
        return i2;
    }

    public static long hexToLong(String str, int i, long j, int i2, int i4) {
        if (i4 == 0) {
            return j;
        }
        if (AbstractC1974b.m1304A(i4, 1, 4, i2) >= 64) {
            throw new IllegalArgumentException("(nHexs-1)*4+dstPos is greater or equal to than 64");
        }
        for (int i5 = 0; i5 < i4; i5++) {
            int i6 = (i5 * 4) + i2;
            j = (j & (~(15 << i6))) | ((((long) hexDigitToInt(str.charAt(i5 + i))) & 15) << i6);
        }
        return j;
    }

    public static short hexToShort(String str, int i, short s, int i2, int i4) {
        if (i4 == 0) {
            return s;
        }
        if (AbstractC1974b.m1304A(i4, 1, 4, i2) >= 16) {
            throw new IllegalArgumentException("(nHexs-1)*4+dstPos is greater or equal to than 16");
        }
        for (int i5 = 0; i5 < i4; i5++) {
            int i6 = (i5 * 4) + i2;
            s = (short) ((s & (~(15 << i6))) | ((hexDigitToInt(str.charAt(i5 + i)) & 15) << i6));
        }
        return s;
    }

    public static long intArrayToLong(int[] iArr, int i, long j, int i2, int i4) {
        if ((iArr.length == 0 && i == 0) || i4 == 0) {
            return j;
        }
        if (AbstractC1974b.m1304A(i4, 1, 32, i2) >= 64) {
            throw new IllegalArgumentException("(nInts-1)*32+dstPos is greater or equal to than 64");
        }
        for (int i5 = 0; i5 < i4; i5++) {
            int i6 = (i5 * 32) + i2;
            j = (j & (~(4294967295 << i6))) | ((((long) iArr[i5 + i]) & 4294967295L) << i6);
        }
        return j;
    }

    public static boolean[] intToBinary(int i, int i2, boolean[] zArr, int i4, int i5) {
        if (i5 != 0) {
            if ((i5 - 1) + i2 >= 32) {
                throw new IllegalArgumentException("nBools-1+srcPos is greater or equal to than 32");
            }
            for (int i6 = 0; i6 < i5; i6++) {
                int i7 = i4 + i6;
                boolean z = true;
                if (((i >> (i6 + i2)) & 1) == 0) {
                    z = false;
                }
                zArr[i7] = z;
            }
        }
        return zArr;
    }

    public static byte[] intToByteArray(int i, int i2, byte[] bArr, int i4, int i5) {
        if (i5 != 0) {
            if (AbstractC1974b.m1304A(i5, 1, 8, i2) >= 32) {
                throw new IllegalArgumentException("(nBytes-1)*8+srcPos is greater or equal to than 32");
            }
            for (int i6 = 0; i6 < i5; i6++) {
                bArr[i4 + i6] = (byte) ((i >> ((i6 * 8) + i2)) & 255);
            }
        }
        return bArr;
    }

    public static String intToHex(int i, int i2, String str, int i4, int i5) {
        if (i5 == 0) {
            return str;
        }
        if (AbstractC1974b.m1304A(i5, 1, 4, i2) >= 32) {
            throw new IllegalArgumentException("(nHexs-1)*4+srcPos is greater or equal to than 32");
        }
        StringBuilder sb = new StringBuilder(str);
        int length = sb.length();
        for (int i6 = 0; i6 < i5; i6++) {
            int i7 = (i >> ((i6 * 4) + i2)) & 15;
            int i8 = i4 + i6;
            if (i8 == length) {
                length++;
                sb.append(intToHexDigit(i7));
            } else {
                sb.setCharAt(i8, intToHexDigit(i7));
            }
        }
        return sb.toString();
    }

    public static char intToHexDigit(int i) {
        char cForDigit = Character.forDigit(i, 16);
        if (cForDigit != 0) {
            return cForDigit;
        }
        throw new IllegalArgumentException(AbstractC0000a.m11h(i, "nibble value not between 0 and 15: "));
    }

    public static char intToHexDigitMsb0(int i) {
        switch (i) {
            case 0:
                return '0';
            case 1:
                return '8';
            case 2:
                return '4';
            case 3:
                return DeviceInfoUtil.FLAVOR_TYPE_C;
            case 4:
                return '2';
            case 5:
                return 'a';
            case 6:
                return '6';
            case 7:
                return 'e';
            case 8:
                return '1';
            case 9:
                return '9';
            case 10:
                return '5';
            case 11:
                return 'd';
            case 12:
                return '3';
            case 13:
                return 'b';
            case 14:
                return '7';
            case 15:
                return 'f';
            default:
                throw new IllegalArgumentException(AbstractC0000a.m11h(i, "nibble value not between 0 and 15: "));
        }
    }

    public static short[] intToShortArray(int i, int i2, short[] sArr, int i4, int i5) {
        if (i5 != 0) {
            if (AbstractC1974b.m1304A(i5, 1, 16, i2) >= 32) {
                throw new IllegalArgumentException("(nShorts-1)*16+srcPos is greater or equal to than 32");
            }
            for (int i6 = 0; i6 < i5; i6++) {
                sArr[i4 + i6] = (short) ((i >> ((i6 * 16) + i2)) & 65535);
            }
        }
        return sArr;
    }

    public static boolean[] longToBinary(long j, int i, boolean[] zArr, int i2, int i4) {
        if (i4 != 0) {
            if ((i4 - 1) + i >= 64) {
                throw new IllegalArgumentException("nBools-1+srcPos is greater or equal to than 64");
            }
            for (int i5 = 0; i5 < i4; i5++) {
                zArr[i2 + i5] = (1 & (j >> (i5 + i))) != 0;
            }
        }
        return zArr;
    }

    public static byte[] longToByteArray(long j, int i, byte[] bArr, int i2, int i4) {
        if (i4 != 0) {
            if (AbstractC1974b.m1304A(i4, 1, 8, i) >= 64) {
                throw new IllegalArgumentException("(nBytes-1)*8+srcPos is greater or equal to than 64");
            }
            for (int i5 = 0; i5 < i4; i5++) {
                bArr[i2 + i5] = (byte) (255 & (j >> ((i5 * 8) + i)));
            }
        }
        return bArr;
    }

    public static String longToHex(long j, int i, String str, int i2, int i4) {
        if (i4 == 0) {
            return str;
        }
        if (AbstractC1974b.m1304A(i4, 1, 4, i) >= 64) {
            throw new IllegalArgumentException("(nHexs-1)*4+srcPos is greater or equal to than 64");
        }
        StringBuilder sb = new StringBuilder(str);
        int length = sb.length();
        for (int i5 = 0; i5 < i4; i5++) {
            int i6 = (int) ((j >> ((i5 * 4) + i)) & 15);
            int i7 = i2 + i5;
            if (i7 == length) {
                length++;
                sb.append(intToHexDigit(i6));
            } else {
                sb.setCharAt(i7, intToHexDigit(i6));
            }
        }
        return sb.toString();
    }

    public static int[] longToIntArray(long j, int i, int[] iArr, int i2, int i4) {
        if (i4 != 0) {
            if (AbstractC1974b.m1304A(i4, 1, 32, i) >= 64) {
                throw new IllegalArgumentException("(nInts-1)*32+srcPos is greater or equal to than 64");
            }
            for (int i5 = 0; i5 < i4; i5++) {
                iArr[i2 + i5] = (int) (j >> ((i5 * 32) + i));
            }
        }
        return iArr;
    }

    public static short[] longToShortArray(long j, int i, short[] sArr, int i2, int i4) {
        if (i4 != 0) {
            if (AbstractC1974b.m1304A(i4, 1, 16, i) >= 64) {
                throw new IllegalArgumentException("(nShorts-1)*16+srcPos is greater or equal to than 64");
            }
            for (int i5 = 0; i5 < i4; i5++) {
                sArr[i2 + i5] = (short) (65535 & (j >> ((i5 * 16) + i)));
            }
        }
        return sArr;
    }

    public static int shortArrayToInt(short[] sArr, int i, int i2, int i4, int i5) {
        if ((sArr.length == 0 && i == 0) || i5 == 0) {
            return i2;
        }
        if (AbstractC1974b.m1304A(i5, 1, 16, i4) >= 32) {
            throw new IllegalArgumentException("(nShorts-1)*16+dstPos is greater or equal to than 32");
        }
        for (int i6 = 0; i6 < i5; i6++) {
            int i7 = (i6 * 16) + i4;
            i2 = (i2 & (~(65535 << i7))) | ((sArr[i6 + i] & UShort.MAX_VALUE) << i7);
        }
        return i2;
    }

    public static long shortArrayToLong(short[] sArr, int i, long j, int i2, int i4) {
        if ((sArr.length == 0 && i == 0) || i4 == 0) {
            return j;
        }
        if (AbstractC1974b.m1304A(i4, 1, 16, i2) >= 64) {
            throw new IllegalArgumentException("(nShorts-1)*16+dstPos is greater or equal to than 64");
        }
        for (int i5 = 0; i5 < i4; i5++) {
            int i6 = (i5 * 16) + i2;
            j = (j & (~(65535 << i6))) | ((((long) sArr[i5 + i]) & 65535) << i6);
        }
        return j;
    }

    public static boolean[] shortToBinary(short s, int i, boolean[] zArr, int i2, int i4) {
        if (i4 != 0) {
            if ((i4 - 1) + i >= 16) {
                throw new IllegalArgumentException("nBools-1+srcPos is greater or equal to than 16");
            }
            for (int i5 = 0; i5 < i4; i5++) {
                int i6 = i2 + i5;
                boolean z = true;
                if (((s >> (i5 + i)) & 1) == 0) {
                    z = false;
                }
                zArr[i6] = z;
            }
        }
        return zArr;
    }

    public static byte[] shortToByteArray(short s, int i, byte[] bArr, int i2, int i4) {
        if (i4 != 0) {
            if (AbstractC1974b.m1304A(i4, 1, 8, i) >= 16) {
                throw new IllegalArgumentException("(nBytes-1)*8+srcPos is greater or equal to than 16");
            }
            for (int i5 = 0; i5 < i4; i5++) {
                bArr[i2 + i5] = (byte) ((s >> ((i5 * 8) + i)) & 255);
            }
        }
        return bArr;
    }

    public static String shortToHex(short s, int i, String str, int i2, int i4) {
        if (i4 == 0) {
            return str;
        }
        if (AbstractC1974b.m1304A(i4, 1, 4, i) >= 16) {
            throw new IllegalArgumentException("(nHexs-1)*4+srcPos is greater or equal to than 16");
        }
        StringBuilder sb = new StringBuilder(str);
        int length = sb.length();
        for (int i5 = 0; i5 < i4; i5++) {
            int i6 = (s >> ((i5 * 4) + i)) & 15;
            int i7 = i2 + i5;
            if (i7 == length) {
                length++;
                sb.append(intToHexDigit(i6));
            } else {
                sb.setCharAt(i7, intToHexDigit(i6));
            }
        }
        return sb.toString();
    }

    public static byte[] uuidToByteArray(UUID uuid, byte[] bArr, int i, int i2) {
        if (i2 != 0) {
            if (i2 > 16) {
                throw new IllegalArgumentException("nBytes is greater than 16");
            }
            longToByteArray(uuid.getMostSignificantBits(), 0, bArr, i, Math.min(i2, 8));
            if (i2 >= 8) {
                longToByteArray(uuid.getLeastSignificantBits(), 0, bArr, i + 8, i2 - 8);
            }
        }
        return bArr;
    }

    public static char binaryBeMsb0ToHexDigit(boolean[] zArr, int i) {
        if (Integer.compareUnsigned(i, zArr.length) >= 0) {
            if (zArr.length == 0) {
                throw new IllegalArgumentException("Cannot convert an empty array.");
            }
            StringBuilder sbM1322o = AbstractC1974b.m1322o(i, " is not within array length ");
            sbM1322o.append(zArr.length);
            throw new IndexOutOfBoundsException(sbM1322o.toString());
        }
        int length = (zArr.length - 1) - i;
        if (3 > length || !zArr[length - 3]) {
            return (2 > length || !zArr[length + (-2)]) ? (1 > length || !zArr[length + (-1)]) ? zArr[length] ? '1' : '0' : zArr[length] ? '3' : '2' : zArr[length + (-1)] ? zArr[length] ? '7' : '6' : zArr[length] ? '5' : '4';
        }
        if (!zArr[length - 2]) {
            return zArr[length + (-1)] ? zArr[length] ? 'b' : 'a' : zArr[length] ? '9' : '8';
        }
        if (zArr[length - 1]) {
            return zArr[length] ? 'f' : 'e';
        }
        if (zArr[length]) {
            return 'd';
        }
        return DeviceInfoUtil.FLAVOR_TYPE_C;
    }

    public static char binaryToHexDigit(boolean[] zArr, int i) {
        if (zArr.length == 0) {
            throw new IllegalArgumentException("Cannot convert an empty array.");
        }
        int i2 = i + 3;
        if (zArr.length <= i2 || !zArr[i2]) {
            int i4 = i + 2;
            if (zArr.length > i4 && zArr[i4]) {
                return zArr[i + 1] ? zArr[i] ? '7' : '6' : zArr[i] ? '5' : '4';
            }
            int i5 = i + 1;
            return (zArr.length <= i5 || !zArr[i5]) ? zArr[i] ? '1' : '0' : zArr[i] ? '3' : '2';
        }
        if (!zArr[i + 2]) {
            return zArr[i + 1] ? zArr[i] ? 'b' : 'a' : zArr[i] ? '9' : '8';
        }
        if (zArr[i + 1]) {
            return zArr[i] ? 'f' : 'e';
        }
        if (zArr[i]) {
            return 'd';
        }
        return DeviceInfoUtil.FLAVOR_TYPE_C;
    }

    public static char binaryToHexDigitMsb0_4bits(boolean[] zArr, int i) {
        if (zArr.length > 8) {
            throw new IllegalArgumentException("src.length>8: src.length=" + zArr.length);
        }
        if (zArr.length - i < 4) {
            throw new IllegalArgumentException("src.length-srcPos<4: src.length=" + zArr.length + ", srcPos=" + i);
        }
        if (zArr[i + 3]) {
            return zArr[i + 2] ? zArr[i + 1] ? zArr[i] ? 'f' : '7' : zArr[i] ? 'b' : '3' : zArr[i + 1] ? zArr[i] ? 'd' : '5' : zArr[i] ? '9' : '1';
        }
        if (zArr[i + 2]) {
            return zArr[i + 1] ? zArr[i] ? 'e' : '6' : zArr[i] ? 'a' : '2';
        }
        if (!zArr[i + 1]) {
            return zArr[i] ? '8' : '0';
        }
        if (zArr[i]) {
            return DeviceInfoUtil.FLAVOR_TYPE_C;
        }
        return '4';
    }
}
