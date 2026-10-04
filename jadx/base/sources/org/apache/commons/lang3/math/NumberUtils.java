package org.apache.commons.lang3.math;

import com.samsung.android.support.senl.p148nt.base.common.displaydata.ContentUtils;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Objects;
import org.apache.commons.lang3.CharUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class NumberUtils {
    public static final Long LONG_ZERO = 0L;
    public static final Long LONG_ONE = 1L;
    public static final Long LONG_MINUS_ONE = -1L;
    public static final Integer INTEGER_ZERO = 0;
    public static final Integer INTEGER_ONE = 1;
    public static final Integer INTEGER_TWO = 2;
    public static final Integer INTEGER_MINUS_ONE = -1;
    public static final Short SHORT_ZERO = 0;
    public static final Short SHORT_ONE = 1;
    public static final Short SHORT_MINUS_ONE = -1;
    public static final Byte BYTE_ZERO = (byte) 0;
    public static final Byte BYTE_ONE = (byte) 1;
    public static final Byte BYTE_MINUS_ONE = (byte) -1;
    public static final Double DOUBLE_ZERO = Double.valueOf(0.0d);
    public static final Double DOUBLE_ONE = Double.valueOf(1.0d);
    public static final Double DOUBLE_MINUS_ONE = Double.valueOf(-1.0d);
    public static final Float FLOAT_ZERO = Float.valueOf(0.0f);
    public static final Float FLOAT_ONE = Float.valueOf(1.0f);
    public static final Float FLOAT_MINUS_ONE = Float.valueOf(-1.0f);
    public static final Long LONG_INT_MAX_VALUE = 2147483647L;
    public static final Long LONG_INT_MIN_VALUE = -2147483648L;

    @Deprecated
    public NumberUtils() {
    }

    public static int compare(byte b, byte b5) {
        return b - b5;
    }

    public static BigDecimal createBigDecimal(String str) {
        if (str == null) {
            return null;
        }
        if (StringUtils.isBlank(str)) {
            throw new NumberFormatException("A blank string is not a valid number");
        }
        return new BigDecimal(str);
    }

    public static BigInteger createBigInteger(String str) {
        int i;
        if (str == null) {
            return null;
        }
        if (str.isEmpty()) {
            throw new NumberFormatException("An empty string is not a valid number");
        }
        int i2 = 0;
        char cCharAt = str.charAt(0);
        boolean z = true;
        if (cCharAt == '-') {
            i2 = 1;
        } else if (cCharAt == '+') {
            z = false;
            i2 = 1;
        } else {
            z = false;
        }
        int i4 = 16;
        if (str.startsWith("0x", i2) || str.startsWith("0X", i2)) {
            i2 += 2;
        } else if (str.startsWith(ContentUtils.HASH_SYMBOL, i2)) {
            i2++;
        } else if (!str.startsWith("0", i2) || str.length() <= (i = i2 + 1)) {
            i4 = 10;
        } else {
            i4 = 8;
            i2 = i;
        }
        BigInteger bigInteger = new BigInteger(str.substring(i2), i4);
        return z ? bigInteger.negate() : bigInteger;
    }

    public static Double createDouble(String str) {
        if (str == null) {
            return null;
        }
        return Double.valueOf(str);
    }

    public static Float createFloat(String str) {
        if (str == null) {
            return null;
        }
        return Float.valueOf(str);
    }

    public static Integer createInteger(String str) {
        if (str == null) {
            return null;
        }
        return Integer.decode(str);
    }

    public static Long createLong(String str) {
        if (str == null) {
            return null;
        }
        return Long.decode(str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:105:0x0153, code lost:
    
        if (isZero(r6, r2) != false) goto L106;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x016c, code lost:
    
        if (isZero(r6, r2) != false) goto L113;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0105, code lost:
    
        if (r4 == 'l') goto L84;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0147 A[Catch: NumberFormatException -> 0x0156, TryCatch #1 {NumberFormatException -> 0x0156, blocks: (B:100:0x013d, B:102:0x0147, B:104:0x014f), top: B:156:0x013d }] */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0160 A[Catch: NumberFormatException -> 0x016f, TryCatch #6 {NumberFormatException -> 0x016f, blocks: (B:107:0x0156, B:109:0x0160, B:111:0x0168), top: B:166:0x0156 }] */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0156 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Number createNumber(String str) {
        int length;
        String mantissa;
        String mantissa2;
        String strSubstring;
        Double dCreateDouble;
        Float fCreateFloat;
        String strSubstring2 = null;
        if (str == null) {
            return null;
        }
        if (StringUtils.isBlank(str)) {
            throw new NumberFormatException("A blank string is not a valid number");
        }
        String[] strArr = {"0x", "0X", ContentUtils.HASH_SYMBOL};
        int length2 = str.length();
        char cCharAt = 0;
        boolean zIsSign = isSign(str.charAt(0));
        int i = 0;
        while (true) {
            if (i >= 3) {
                length = 0;
                break;
            }
            String str2 = strArr[i];
            if (str.startsWith(str2, zIsSign ? 1 : 0)) {
                length = str2.length() + (zIsSign ? 1 : 0);
                break;
            }
            i++;
        }
        if (length > 0) {
            int i2 = length;
            while (length < length2) {
                cCharAt = str.charAt(length);
                if (cCharAt != '0') {
                    break;
                }
                i2++;
                length++;
            }
            int i4 = length2 - i2;
            return (i4 > 16 || (i4 == 16 && cCharAt > '7')) ? createBigInteger(str) : (i4 > 8 || (i4 == 8 && cCharAt > '7')) ? createLong(str) : createInteger(str);
        }
        int i5 = length2 - 1;
        char cCharAt2 = str.charAt(i5);
        int iIndexOf = str.indexOf(46);
        int iIndexOf2 = str.indexOf(69) + str.indexOf(101);
        int i6 = iIndexOf2 + 1;
        Object[] objArr = (Character.isDigit(cCharAt2) || cCharAt2 == '.') ? false : true;
        if (iIndexOf > -1) {
            if (i6 <= -1) {
                int i7 = iIndexOf + 1;
                if (objArr != false) {
                    length2 = i5;
                }
                strSubstring = str.substring(i7, length2);
            } else {
                if (i6 <= iIndexOf || i6 > length2) {
                    throw new NumberFormatException(str.concat(" is not a valid number."));
                }
                strSubstring = str.substring(iIndexOf + 1, i6);
            }
            mantissa2 = getMantissa(str, iIndexOf);
        } else {
            if (i6 <= -1) {
                if (objArr != false) {
                    length2 = i5;
                }
                mantissa = getMantissa(str, length2);
            } else {
                if (i6 > length2) {
                    throw new NumberFormatException(str.concat(" is not a valid number."));
                }
                mantissa = getMantissa(str, i6);
            }
            mantissa2 = mantissa;
            strSubstring = null;
        }
        if (objArr != true) {
            if (i6 > -1 && i6 < i5) {
                strSubstring2 = str.substring(iIndexOf2 + 2);
            }
            if (strSubstring == null && strSubstring2 == null) {
                try {
                    try {
                        return createInteger(str);
                    } catch (NumberFormatException unused) {
                        return createBigInteger(str);
                    }
                } catch (NumberFormatException unused2) {
                    return createLong(str);
                }
            }
            try {
                Float fCreateFloat2 = createFloat(str);
                Double dCreateDouble2 = createDouble(str);
                if (!fCreateFloat2.isInfinite() && ((fCreateFloat2.floatValue() != 0.0f || isZero(mantissa2, strSubstring)) && fCreateFloat2.toString().equals(dCreateDouble2.toString()))) {
                    return fCreateFloat2;
                }
                if (!dCreateDouble2.isInfinite() && (dCreateDouble2.doubleValue() != 0.0d || isZero(mantissa2, strSubstring))) {
                    BigDecimal bigDecimalCreateBigDecimal = createBigDecimal(str);
                    return bigDecimalCreateBigDecimal.compareTo(BigDecimal.valueOf(dCreateDouble2.doubleValue())) == 0 ? dCreateDouble2 : bigDecimalCreateBigDecimal;
                }
            } catch (NumberFormatException unused3) {
            }
            return createBigDecimal(str);
        }
        if (i6 > -1 && i6 < i5) {
            strSubstring2 = str.substring(iIndexOf2 + 2, i5);
        }
        String strSubstring3 = str.substring(0, i5);
        if (cCharAt2 != 'D') {
            if (cCharAt2 == 'F') {
                try {
                    fCreateFloat = createFloat(str);
                    if (!fCreateFloat.isInfinite()) {
                        if (fCreateFloat.floatValue() == 0.0f) {
                        }
                        return fCreateFloat;
                    }
                } catch (NumberFormatException unused4) {
                }
                dCreateDouble = createDouble(str);
                if (!dCreateDouble.isInfinite()) {
                }
                return createBigDecimal(strSubstring3);
            }
            if (cCharAt2 != 'L') {
                if (cCharAt2 != 'd') {
                    if (cCharAt2 != 'f') {
                    }
                    fCreateFloat = createFloat(str);
                    if (!fCreateFloat.isInfinite()) {
                    }
                    dCreateDouble = createDouble(str);
                    if (!dCreateDouble.isInfinite()) {
                    }
                    return createBigDecimal(strSubstring3);
                }
            }
            if (strSubstring != null || strSubstring2 != null || ((strSubstring3.isEmpty() || strSubstring3.charAt(0) != '-' || !isDigits(strSubstring3.substring(1))) && !isDigits(strSubstring3))) {
                throw new NumberFormatException(str.concat(" is not a valid number."));
            }
            try {
                return createLong(strSubstring3);
            } catch (NumberFormatException unused5) {
                return createBigInteger(strSubstring3);
            }
        }
        try {
            dCreateDouble = createDouble(str);
            if (!dCreateDouble.isInfinite()) {
                if (dCreateDouble.doubleValue() == 0.0d) {
                }
                return dCreateDouble;
            }
        } catch (NumberFormatException unused6) {
        }
        try {
            return createBigDecimal(strSubstring3);
        } catch (NumberFormatException unused7) {
        }
        throw new NumberFormatException(str.concat(" is not a valid number."));
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [boolean] */
    private static String getMantissa(String str, int i) {
        ?? IsSign = isSign(str.charAt(0));
        int length = str.length();
        if (length <= IsSign || length < i) {
            throw new NumberFormatException(str.concat(" is not a valid number."));
        }
        return IsSign != 0 ? str.substring(1, i) : str.substring(0, i);
    }

    private static boolean isAllZeros(String str) {
        if (str == null) {
            return true;
        }
        for (int length = str.length() - 1; length >= 0; length--) {
            if (str.charAt(length) != '0') {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:89:0x00ca, code lost:
    
        return false;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r3v2, types: [int] */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean isCreatable(String str) {
        if (StringUtils.isEmpty(str)) {
            return false;
        }
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        ?? IsSign = isSign(charArray[0]);
        int i = IsSign + 1;
        if (length > i && charArray[IsSign] == '0' && !StringUtils.contains(str, 46)) {
            char c = charArray[i];
            if (c == 'x' || c == 'X') {
                int i2 = IsSign + 2;
                if (i2 == length) {
                    return false;
                }
                while (i2 < charArray.length) {
                    if (!CharUtils.isHex(charArray[i2])) {
                        return false;
                    }
                    i2++;
                }
                return true;
            }
            if (Character.isDigit(c)) {
                while (i < charArray.length) {
                    if (!CharUtils.isOctal(charArray[i])) {
                        return false;
                    }
                    i++;
                }
                return true;
            }
        }
        int i4 = length - 1;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        ?? r32 = IsSign;
        while (true) {
            if (r32 >= i4 && (r32 >= length || !z || z2)) {
                break;
            }
            if (CharUtils.isAsciiNumeric(charArray[r32])) {
                z = false;
                z2 = true;
            } else {
                char c2 = charArray[r32];
                if (c2 == '.') {
                    if (z4 || z3) {
                        break;
                    }
                    z4 = true;
                } else if (c2 == 'e' || c2 == 'E') {
                    if (z3 || !z2) {
                        return false;
                    }
                    z = true;
                    z3 = true;
                } else {
                    if (!isSign(c2) || !z) {
                        return false;
                    }
                    z = false;
                    z2 = false;
                }
            }
            r32++;
        }
        if (r32 >= charArray.length) {
            return !z && z2;
        }
        if (CharUtils.isAsciiNumeric(charArray[r32])) {
            return true;
        }
        char c4 = charArray[r32];
        if (c4 != 'e' && c4 != 'E') {
            if (c4 == '.') {
                if (z4 || z3) {
                    return false;
                }
            } else if (z || (c4 != 'd' && c4 != 'D' && c4 != 'f' && c4 != 'F')) {
                if ((c4 == 'l' || c4 == 'L') && z2 && !z3 && !z4) {
                    return true;
                }
            }
            return z2;
        }
        return false;
    }

    public static boolean isDigits(String str) {
        return StringUtils.isNumeric(str);
    }

    @Deprecated
    public static boolean isNumber(String str) {
        return isCreatable(str);
    }

    public static boolean isParsable(String str) {
        if (StringUtils.isEmpty(str) || AbstractC0000a.m4a(1, str) == '.') {
            return false;
        }
        if (str.charAt(0) != '-') {
            return withDecimalsParsing(str, 0);
        }
        if (str.length() == 1) {
            return false;
        }
        return withDecimalsParsing(str, 1);
    }

    private static boolean isSign(char c) {
        return c == '-' || c == '+';
    }

    private static boolean isZero(String str, String str2) {
        return isAllZeros(str) && isAllZeros(str2);
    }

    public static byte max(byte b, byte b5, byte b6) {
        if (b5 > b) {
            b = b5;
        }
        return b6 > b ? b6 : b;
    }

    public static byte min(byte b, byte b5, byte b6) {
        if (b5 < b) {
            b = b5;
        }
        return b6 < b ? b6 : b;
    }

    public static byte toByte(String str) {
        return toByte(str, (byte) 0);
    }

    public static double toDouble(BigDecimal bigDecimal) {
        return toDouble(bigDecimal, 0.0d);
    }

    public static float toFloat(String str) {
        return toFloat(str, 0.0f);
    }

    public static int toInt(String str) {
        return toInt(str, 0);
    }

    public static long toLong(String str) {
        return toLong(str, 0L);
    }

    public static BigDecimal toScaledBigDecimal(BigDecimal bigDecimal) {
        return toScaledBigDecimal(bigDecimal, INTEGER_TWO.intValue(), RoundingMode.HALF_EVEN);
    }

    public static short toShort(String str) {
        return toShort(str, (short) 0);
    }

    private static void validateArray(Object obj) {
        Objects.requireNonNull(obj, "array");
        Validate.isTrue(Array.getLength(obj) != 0, "Array cannot be empty.", new Object[0]);
    }

    private static boolean withDecimalsParsing(String str, int i) {
        int i2 = 0;
        while (i < str.length()) {
            char cCharAt = str.charAt(i);
            boolean z = cCharAt == '.';
            if (z) {
                i2++;
            }
            if (i2 > 1) {
                return false;
            }
            if (!z && !Character.isDigit(cCharAt)) {
                return false;
            }
            i++;
        }
        return true;
    }

    public static int compare(int i, int i2) {
        if (i == i2) {
            return 0;
        }
        return i < i2 ? -1 : 1;
    }

    public static int max(int i, int i2, int i4) {
        if (i2 > i) {
            i = i2;
        }
        return i4 > i ? i4 : i;
    }

    public static int min(int i, int i2, int i4) {
        if (i2 < i) {
            i = i2;
        }
        return i4 < i ? i4 : i;
    }

    public static byte toByte(String str, byte b) {
        try {
            return Byte.parseByte(str);
        } catch (RuntimeException unused) {
            return b;
        }
    }

    public static double toDouble(BigDecimal bigDecimal, double d) {
        return bigDecimal == null ? d : bigDecimal.doubleValue();
    }

    public static float toFloat(String str, float f) {
        try {
            return Float.parseFloat(str);
        } catch (RuntimeException unused) {
            return f;
        }
    }

    public static int toInt(String str, int i) {
        try {
            return Integer.parseInt(str);
        } catch (RuntimeException unused) {
            return i;
        }
    }

    public static long toLong(String str, long j) {
        try {
            return Long.parseLong(str);
        } catch (RuntimeException unused) {
            return j;
        }
    }

    public static BigDecimal toScaledBigDecimal(BigDecimal bigDecimal, int i, RoundingMode roundingMode) {
        if (bigDecimal == null) {
            return BigDecimal.ZERO;
        }
        if (roundingMode == null) {
            roundingMode = RoundingMode.HALF_EVEN;
        }
        return bigDecimal.setScale(i, roundingMode);
    }

    public static short toShort(String str, short s) {
        try {
            return Short.parseShort(str);
        } catch (RuntimeException unused) {
            return s;
        }
    }

    public static int compare(long j, long j2) {
        if (j == j2) {
            return 0;
        }
        return j < j2 ? -1 : 1;
    }

    public static long max(long j, long j2, long j3) {
        if (j2 > j) {
            j = j2;
        }
        return j3 > j ? j3 : j;
    }

    public static long min(long j, long j2, long j3) {
        if (j2 < j) {
            j = j2;
        }
        return j3 < j ? j3 : j;
    }

    public static double toDouble(String str) {
        return toDouble(str, 0.0d);
    }

    public static int compare(short s, short s2) {
        if (s == s2) {
            return 0;
        }
        return s < s2 ? -1 : 1;
    }

    public static short max(short s, short s2, short s3) {
        if (s2 > s) {
            s = s2;
        }
        return s3 > s ? s3 : s;
    }

    public static short min(short s, short s2, short s3) {
        if (s2 < s) {
            s = s2;
        }
        return s3 < s ? s3 : s;
    }

    public static double toDouble(String str, double d) {
        try {
            return Double.parseDouble(str);
        } catch (RuntimeException unused) {
            return d;
        }
    }

    public static byte max(byte... bArr) {
        validateArray(bArr);
        byte b = bArr[0];
        for (int i = 1; i < bArr.length; i++) {
            byte b5 = bArr[i];
            if (b5 > b) {
                b = b5;
            }
        }
        return b;
    }

    public static byte min(byte... bArr) {
        validateArray(bArr);
        byte b = bArr[0];
        for (int i = 1; i < bArr.length; i++) {
            byte b5 = bArr[i];
            if (b5 < b) {
                b = b5;
            }
        }
        return b;
    }

    public static BigDecimal toScaledBigDecimal(Double d) {
        return toScaledBigDecimal(d, INTEGER_TWO.intValue(), RoundingMode.HALF_EVEN);
    }

    public static BigDecimal toScaledBigDecimal(Double d, int i, RoundingMode roundingMode) {
        if (d == null) {
            return BigDecimal.ZERO;
        }
        return toScaledBigDecimal(BigDecimal.valueOf(d.doubleValue()), i, roundingMode);
    }

    public static double max(double... dArr) {
        validateArray(dArr);
        double d = dArr[0];
        for (int i = 1; i < dArr.length; i++) {
            if (Double.isNaN(dArr[i])) {
                return Double.NaN;
            }
            double d2 = dArr[i];
            if (d2 > d) {
                d = d2;
            }
        }
        return d;
    }

    public static double min(double... dArr) {
        validateArray(dArr);
        double d = dArr[0];
        for (int i = 1; i < dArr.length; i++) {
            if (Double.isNaN(dArr[i])) {
                return Double.NaN;
            }
            double d2 = dArr[i];
            if (d2 < d) {
                d = d2;
            }
        }
        return d;
    }

    public static BigDecimal toScaledBigDecimal(Float f) {
        return toScaledBigDecimal(f, INTEGER_TWO.intValue(), RoundingMode.HALF_EVEN);
    }

    public static BigDecimal toScaledBigDecimal(Float f, int i, RoundingMode roundingMode) {
        if (f == null) {
            return BigDecimal.ZERO;
        }
        return toScaledBigDecimal(BigDecimal.valueOf(f.floatValue()), i, roundingMode);
    }

    public static BigDecimal toScaledBigDecimal(String str) {
        return toScaledBigDecimal(str, INTEGER_TWO.intValue(), RoundingMode.HALF_EVEN);
    }

    public static double max(double d, double d2, double d3) {
        return Math.max(Math.max(d, d2), d3);
    }

    public static double min(double d, double d2, double d3) {
        return Math.min(Math.min(d, d2), d3);
    }

    public static BigDecimal toScaledBigDecimal(String str, int i, RoundingMode roundingMode) {
        if (str == null) {
            return BigDecimal.ZERO;
        }
        return toScaledBigDecimal(createBigDecimal(str), i, roundingMode);
    }

    public static float max(float... fArr) {
        validateArray(fArr);
        float f = fArr[0];
        for (int i = 1; i < fArr.length; i++) {
            if (Float.isNaN(fArr[i])) {
                return Float.NaN;
            }
            float f4 = fArr[i];
            if (f4 > f) {
                f = f4;
            }
        }
        return f;
    }

    public static float min(float... fArr) {
        validateArray(fArr);
        float f = fArr[0];
        for (int i = 1; i < fArr.length; i++) {
            if (Float.isNaN(fArr[i])) {
                return Float.NaN;
            }
            float f4 = fArr[i];
            if (f4 < f) {
                f = f4;
            }
        }
        return f;
    }

    public static float max(float f, float f4, float f5) {
        return Math.max(Math.max(f, f4), f5);
    }

    public static float min(float f, float f4, float f5) {
        return Math.min(Math.min(f, f4), f5);
    }

    public static int max(int... iArr) {
        validateArray(iArr);
        int i = iArr[0];
        for (int i2 = 1; i2 < iArr.length; i2++) {
            int i4 = iArr[i2];
            if (i4 > i) {
                i = i4;
            }
        }
        return i;
    }

    public static int min(int... iArr) {
        validateArray(iArr);
        int i = iArr[0];
        for (int i2 = 1; i2 < iArr.length; i2++) {
            int i4 = iArr[i2];
            if (i4 < i) {
                i = i4;
            }
        }
        return i;
    }

    public static long max(long... jArr) {
        validateArray(jArr);
        long j = jArr[0];
        for (int i = 1; i < jArr.length; i++) {
            long j2 = jArr[i];
            if (j2 > j) {
                j = j2;
            }
        }
        return j;
    }

    public static long min(long... jArr) {
        validateArray(jArr);
        long j = jArr[0];
        for (int i = 1; i < jArr.length; i++) {
            long j2 = jArr[i];
            if (j2 < j) {
                j = j2;
            }
        }
        return j;
    }

    public static short max(short... sArr) {
        validateArray(sArr);
        short s = sArr[0];
        for (int i = 1; i < sArr.length; i++) {
            short s2 = sArr[i];
            if (s2 > s) {
                s = s2;
            }
        }
        return s;
    }

    public static short min(short... sArr) {
        validateArray(sArr);
        short s = sArr[0];
        for (int i = 1; i < sArr.length; i++) {
            short s2 = sArr[i];
            if (s2 < s) {
                s = s2;
            }
        }
        return s;
    }
}
