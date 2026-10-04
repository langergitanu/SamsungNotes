package com.fasterxml.jackson.core.p128io;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class NumberInput {
    static final long L_BILLION = 1000000000;
    public static final String NASTY_SMALL_DOUBLE = "2.2250738585072012e-308";
    static final String MIN_LONG_STR_NO_SIGN = String.valueOf(Long.MIN_VALUE).substring(1);
    static final String MAX_LONG_STR = String.valueOf(Long.MAX_VALUE);

    public static boolean inLongRange(char[] cArr, int i, int i2, boolean z) {
        String str = z ? MIN_LONG_STR_NO_SIGN : MAX_LONG_STR;
        int length = str.length();
        if (i2 < length) {
            return true;
        }
        if (i2 > length) {
            return false;
        }
        for (int i4 = 0; i4 < length; i4++) {
            int iCharAt = cArr[i + i4] - str.charAt(i4);
            if (iCharAt != 0) {
                return iCharAt < 0;
            }
        }
        return true;
    }

    public static double parseAsDouble(String str, double d) {
        if (str != null) {
            String strTrim = str.trim();
            if (strTrim.length() != 0) {
                try {
                    return parseDouble(strTrim);
                } catch (NumberFormatException unused) {
                    return d;
                }
            }
        }
        return d;
    }

    public static int parseAsInt(String str, int i) {
        String strTrim;
        int length;
        if (str == null || (length = (strTrim = str.trim()).length()) == 0) {
            return i;
        }
        int i2 = 0;
        if (length > 0) {
            char cCharAt = strTrim.charAt(0);
            if (cCharAt == '+') {
                strTrim = strTrim.substring(1);
                length = strTrim.length();
            } else if (cCharAt == '-') {
                i2 = 1;
            }
        }
        while (i2 < length) {
            char cCharAt2 = strTrim.charAt(i2);
            if (cCharAt2 > '9' || cCharAt2 < '0') {
                try {
                    return (int) parseDouble(strTrim);
                } catch (NumberFormatException unused) {
                    return i;
                }
            }
            i2++;
        }
        try {
            return Integer.parseInt(strTrim);
        } catch (NumberFormatException unused2) {
            return i;
        }
    }

    public static long parseAsLong(String str, long j) {
        String strTrim;
        int length;
        if (str == null || (length = (strTrim = str.trim()).length()) == 0) {
            return j;
        }
        int i = 0;
        if (length > 0) {
            char cCharAt = strTrim.charAt(0);
            if (cCharAt == '+') {
                strTrim = strTrim.substring(1);
                length = strTrim.length();
            } else if (cCharAt == '-') {
                i = 1;
            }
        }
        while (i < length) {
            char cCharAt2 = strTrim.charAt(i);
            if (cCharAt2 > '9' || cCharAt2 < '0') {
                try {
                    return (long) parseDouble(strTrim);
                } catch (NumberFormatException unused) {
                    return j;
                }
            }
            i++;
        }
        try {
            return Long.parseLong(strTrim);
        } catch (NumberFormatException unused2) {
            return j;
        }
    }

    public static double parseDouble(String str) {
        if (NASTY_SMALL_DOUBLE.equals(str)) {
            return Double.MIN_VALUE;
        }
        return Double.parseDouble(str);
    }

    public static int parseInt(char[] cArr, int i, int i2) {
        int i4 = cArr[i] - '0';
        int i5 = i2 + i;
        if (i + 1 >= i5) {
            return i4;
        }
        int i6 = (cArr[r1] - '0') + (i4 * 10);
        if (i + 2 >= i5) {
            return i6;
        }
        int i7 = (cArr[r0] - '0') + (i6 * 10);
        if (i + 3 >= i5) {
            return i7;
        }
        int i8 = (cArr[r1] - '0') + (i7 * 10);
        if (i + 4 >= i5) {
            return i8;
        }
        int i9 = (cArr[r0] - '0') + (i8 * 10);
        if (i + 5 >= i5) {
            return i9;
        }
        int i10 = (cArr[r1] - '0') + (i9 * 10);
        if (i + 6 >= i5) {
            return i10;
        }
        int i11 = (cArr[r0] - '0') + (i10 * 10);
        if (i + 7 >= i5) {
            return i11;
        }
        int i12 = (cArr[r1] - '0') + (i11 * 10);
        if (i + 8 >= i5) {
            return i12;
        }
        return (cArr[r3] - '0') + (i12 * 10);
    }

    public static long parseLong(char[] cArr, int i, int i2) {
        int i4 = i2 - 9;
        return (((long) parseInt(cArr, i, i4)) * L_BILLION) + ((long) parseInt(cArr, i + i4, 9));
    }

    public static long parseLong(String str) {
        if (str.length() <= 9) {
            return parseInt(str);
        }
        return Long.parseLong(str);
    }

    public static boolean inLongRange(String str, boolean z) {
        String str2 = z ? MIN_LONG_STR_NO_SIGN : MAX_LONG_STR;
        int length = str2.length();
        int length2 = str.length();
        if (length2 < length) {
            return true;
        }
        if (length2 > length) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            int iCharAt = str.charAt(i) - str2.charAt(i);
            if (iCharAt != 0) {
                return iCharAt < 0;
            }
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x0072, code lost:
    
        return java.lang.Integer.parseInt(r10);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int parseInt(String str) {
        char cCharAt = str.charAt(0);
        int length = str.length();
        int i = 1;
        boolean z = cCharAt == '-';
        if (z) {
            if (length != 1 && length <= 10) {
                cCharAt = str.charAt(1);
                i = 2;
            } else {
                return Integer.parseInt(str);
            }
        } else if (length > 9) {
            return Integer.parseInt(str);
        }
        if (cCharAt > '9' || cCharAt < '0') {
            return Integer.parseInt(str);
        }
        int i2 = cCharAt - '0';
        if (i < length) {
            int i4 = i + 1;
            char cCharAt2 = str.charAt(i);
            if (cCharAt2 > '9' || cCharAt2 < '0') {
                return Integer.parseInt(str);
            }
            i2 = (i2 * 10) + (cCharAt2 - '0');
            if (i4 < length) {
                int i5 = i + 2;
                char cCharAt3 = str.charAt(i4);
                if (cCharAt3 > '9' || cCharAt3 < '0') {
                    return Integer.parseInt(str);
                }
                i2 = (i2 * 10) + (cCharAt3 - '0');
                if (i5 < length) {
                    while (true) {
                        int i6 = i5 + 1;
                        char cCharAt4 = str.charAt(i5);
                        if (cCharAt4 > '9' || cCharAt4 < '0') {
                            break;
                        }
                        i2 = (i2 * 10) + (cCharAt4 - '0');
                        if (i6 >= length) {
                            break;
                        }
                        i5 = i6;
                    }
                }
            }
        }
        return z ? -i2 : i2;
    }
}
