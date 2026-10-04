package org.apache.commons.lang3;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import com.samsung.android.sdk.smp.common.util.DeviceInfoUtil;
import java.util.Random;
import java.util.function.Supplier;
import org.apache.commons.text.RandomStringGenerator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class RandomStringUtils {
    private static final char[] ALPHANUMERICAL_CHARS;
    private static final int ASCII_0 = 48;
    private static final int ASCII_9 = 57;
    private static final int ASCII_A = 65;
    private static final int ASCII_z = 122;
    private static final int BASE_CACHE_SIZE_PADDING = 10;
    private static final int BITS_TO_BYTES_DIVISOR = 5;
    private static final int CACHE_PADDING_BITS = 3;
    private static RandomStringUtils INSECURE;
    private static RandomStringUtils SECURE;
    private static RandomStringUtils SECURE_STRONG;
    private static final Supplier<RandomUtils> SECURE_SUPPLIER;
    private final Supplier<RandomUtils> random;

    static {
        C13930x c13930x = new C13930x(0);
        SECURE_SUPPLIER = c13930x;
        INSECURE = new RandomStringUtils(new C13930x(1));
        SECURE = new RandomStringUtils(c13930x);
        SECURE_STRONG = new RandomStringUtils(new C13930x(2));
        ALPHANUMERICAL_CHARS = new char[]{'a', 'b', DeviceInfoUtil.FLAVOR_TYPE_C, 'd', 'e', 'f', DeviceInfoUtil.FLAVOR_TYPE_G, 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    }

    @Deprecated
    public RandomStringUtils() {
        this(SECURE_SUPPLIER);
    }

    public static RandomStringUtils insecure() {
        return INSECURE;
    }

    @Deprecated
    public static String random(int i) {
        return secure().next(i);
    }

    @Deprecated
    public static String randomAlphabetic(int i) {
        return secure().nextAlphabetic(i);
    }

    @Deprecated
    public static String randomAlphanumeric(int i) {
        return secure().nextAlphanumeric(i);
    }

    @Deprecated
    public static String randomAscii(int i) {
        return secure().nextAscii(i);
    }

    @Deprecated
    public static String randomGraph(int i) {
        return secure().nextGraph(i);
    }

    @Deprecated
    public static String randomNumeric(int i) {
        return secure().nextNumeric(i);
    }

    @Deprecated
    public static String randomPrint(int i) {
        return secure().nextPrint(i);
    }

    private RandomUtils randomUtils() {
        return this.random.get();
    }

    public static RandomStringUtils secure() {
        return SECURE;
    }

    public static RandomStringUtils secureStrong() {
        return SECURE_STRONG;
    }

    public String next(int i) {
        return next(i, false, false);
    }

    public String nextAlphabetic(int i) {
        return next(i, true, false);
    }

    public String nextAlphanumeric(int i) {
        return next(i, true, true);
    }

    public String nextAscii(int i) {
        return next(i, 32, 127, false, false);
    }

    public String nextGraph(int i) {
        return next(i, 33, 126, false, false);
    }

    public String nextNumeric(int i) {
        return next(i, false, true);
    }

    public String nextPrint(int i) {
        return next(i, 32, 126, false, false);
    }

    public String toString() {
        return "RandomStringUtils [random=" + random() + "]";
    }

    private RandomStringUtils(Supplier<RandomUtils> supplier) {
        this.random = supplier;
    }

    @Deprecated
    public static String random(int i, boolean z, boolean z2) {
        return secure().next(i, z, z2);
    }

    @Deprecated
    public static String randomAlphabetic(int i, int i2) {
        return secure().nextAlphabetic(i, i2);
    }

    @Deprecated
    public static String randomAlphanumeric(int i, int i2) {
        return secure().nextAlphanumeric(i, i2);
    }

    @Deprecated
    public static String randomAscii(int i, int i2) {
        return secure().nextAscii(i, i2);
    }

    @Deprecated
    public static String randomGraph(int i, int i2) {
        return secure().nextGraph(i, i2);
    }

    @Deprecated
    public static String randomNumeric(int i, int i2) {
        return secure().nextNumeric(i, i2);
    }

    @Deprecated
    public static String randomPrint(int i, int i2) {
        return secure().nextPrint(i, i2);
    }

    public String next(int i, boolean z, boolean z2) {
        return next(i, 0, 0, z, z2);
    }

    public String nextAlphabetic(int i, int i2) {
        return nextAlphabetic(randomUtils().randomInt(i, i2));
    }

    public String nextAlphanumeric(int i, int i2) {
        return nextAlphanumeric(randomUtils().randomInt(i, i2));
    }

    public String nextAscii(int i, int i2) {
        return nextAscii(randomUtils().randomInt(i, i2));
    }

    public String nextGraph(int i, int i2) {
        return nextGraph(randomUtils().randomInt(i, i2));
    }

    public String nextNumeric(int i, int i2) {
        return nextNumeric(randomUtils().randomInt(i, i2));
    }

    public String nextPrint(int i, int i2) {
        return nextPrint(randomUtils().randomInt(i, i2));
    }

    @Deprecated
    public static String random(int i, char... cArr) {
        return secure().next(i, cArr);
    }

    public String next(int i, char... cArr) {
        if (cArr == null) {
            return random(i, 0, 0, false, false, null, random());
        }
        return random(i, 0, cArr.length, false, false, cArr, random());
    }

    @Deprecated
    public static String random(int i, int i2, int i4, boolean z, boolean z2) {
        return secure().next(i, i2, i4, z, z2);
    }

    @Deprecated
    public static String random(int i, int i2, int i4, boolean z, boolean z2, char... cArr) {
        return secure().next(i, i2, i4, z, z2, cArr);
    }

    public String next(int i, int i2, int i4, boolean z, boolean z2) {
        return random(i, i2, i4, z, z2, null, random());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static String random(int i, int i2, int i4, boolean z, boolean z2, char[] cArr, Random random) {
        if (i == 0) {
            return "";
        }
        if (i >= 0) {
            if (cArr != 0 && cArr.length == 0) {
                throw new IllegalArgumentException("The chars array must not be empty");
            }
            int iMin = RandomStringGenerator.Builder.DEFAULT_MAXIMUM_CODE_POINT;
            if (i2 == 0 && i4 == 0) {
                if (cArr != 0) {
                    i4 = cArr.length;
                } else if (z || z2) {
                    i2 = 32;
                    i4 = 123;
                } else {
                    i4 = 1114111;
                }
            } else {
                if (i4 <= i2) {
                    throw new IllegalArgumentException(AbstractC0622a.m1164j(i4, i2, "Parameter end (", ") must be greater than start (", ")"));
                }
                if (i2 < 0 || i4 < 0) {
                    throw new IllegalArgumentException("Character positions MUST be >= 0");
                }
            }
            if (i4 <= 1114111) {
                iMin = i4;
            }
            if (cArr == 0 && iMin <= 127) {
                if (z && z2 && i2 <= 48 && iMin >= 123) {
                    return random(i, 0, 0, false, false, ALPHANUMERICAL_CHARS, random);
                }
                if ((z2 && iMin <= 48) || (z && iMin <= 65)) {
                    throw new IllegalArgumentException(AbstractC0541b.m767i(iMin, "Parameter end (", ") must be greater then (48) for generating digits or greater then (65) for generating letters."));
                }
                if (z && z2) {
                    i2 = Math.max(48, i2);
                    iMin = Math.min(123, iMin);
                } else if (z2) {
                    i2 = Math.max(48, i2);
                    iMin = Math.min(58, iMin);
                } else if (z) {
                    i2 = Math.max(65, i2);
                    iMin = Math.min(123, iMin);
                }
            }
            StringBuilder sb = new StringBuilder(i);
            int iNumberOfLeadingZeros = 32 - Integer.numberOfLeadingZeros(iMin - i2);
            CachedRandomBits cachedRandomBits = new CachedRandomBits((int) Math.min((((((long) i) * ((long) iNumberOfLeadingZeros)) + 3) / 5) + 10, 429496739L), random);
            while (true) {
                int i5 = i - 1;
                if (i != 0) {
                    char cNextBits = cachedRandomBits.nextBits(iNumberOfLeadingZeros) + i2;
                    if (cNextBits < iMin) {
                        if (cArr == 0) {
                            int type = Character.getType(cNextBits);
                            if (type == 0 || type == 18 || type == 19) {
                            }
                        } else {
                            cNextBits = cArr[cNextBits];
                        }
                        int iCharCount = Character.charCount(cNextBits);
                        if (i5 != 0 || iCharCount <= 1) {
                            if ((z && Character.isLetter(cNextBits)) || ((z2 && Character.isDigit(cNextBits)) || (!z && !z2))) {
                                sb.appendCodePoint(cNextBits);
                                i = iCharCount == 2 ? i - 2 : i5;
                            }
                        }
                    }
                } else {
                    return sb.toString();
                }
            }
        } else {
            throw new IllegalArgumentException(AbstractC0541b.m767i(i, "Requested random string length ", " is less than 0."));
        }
    }

    public String next(int i, int i2, int i4, boolean z, boolean z2, char... cArr) {
        return random(i, i2, i4, z, z2, cArr, random());
    }

    public String next(int i, String str) {
        if (str == null) {
            return random(i, 0, 0, false, false, null, random());
        }
        return next(i, str.toCharArray());
    }

    @Deprecated
    public static String random(int i, String str) {
        return secure().next(i, str);
    }

    private Random random() {
        return randomUtils().random();
    }
}
