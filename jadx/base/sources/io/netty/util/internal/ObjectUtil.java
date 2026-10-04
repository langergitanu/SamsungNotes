package io.netty.util.internal;

import androidx.appcompat.widget.AbstractC0541b;
import com.microsoft.identity.common.java.cache.CacheKeyValueDelegate;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import java.util.Collection;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final class ObjectUtil {
    private static final double DOUBLE_ZERO = 0.0d;
    private static final float FLOAT_ZERO = 0.0f;
    private static final int INT_ZERO = 0;
    private static final long LONG_ZERO = 0;

    private ObjectUtil() {
    }

    public static int checkInRange(int i, int i2, int i4, String str) {
        if (i >= i2 && i <= i4) {
            return i;
        }
        throw new IllegalArgumentException(str + ": " + i + " (expected: " + i2 + CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR + i4 + ")");
    }

    public static <T> T[] checkNonEmpty(T[] tArr, String str) {
        if (((Object[]) checkNotNull(tArr, str)).length != 0) {
            return tArr;
        }
        throw new IllegalArgumentException(AbstractC0541b.m773o("Param '", str, "' must not be empty"));
    }

    public static String checkNonEmptyAfterTrim(String str, String str2) {
        return checkNonEmpty(((String) checkNotNull(str, str2)).trim(), str2);
    }

    public static <T> T checkNotNull(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    public static <T> T checkNotNullArrayParam(T t, int i, String str) {
        if (t != null) {
            return t;
        }
        throw new IllegalArgumentException(AbstractC11014a.m12321f("Array index ", i, " of parameter '", str, "' must not be null"));
    }

    public static <T> T checkNotNullWithIAE(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new IllegalArgumentException(AbstractC0541b.m773o("Param '", str, "' must not be null"));
    }

    public static int checkPositive(int i, String str) {
        if (i > 0) {
            return i;
        }
        throw new IllegalArgumentException(str + " : " + i + " (expected: > 0)");
    }

    public static int checkPositiveOrZero(int i, String str) {
        if (i >= 0) {
            return i;
        }
        throw new IllegalArgumentException(str + " : " + i + " (expected: >= 0)");
    }

    public static <T> T[] deepCheckNotNull(String str, T... tArr) {
        if (tArr == null) {
            throw new NullPointerException(str);
        }
        for (T t : tArr) {
            if (t == null) {
                throw new NullPointerException(str);
            }
        }
        return tArr;
    }

    public static int intValue(Integer num, int i) {
        return num != null ? num.intValue() : i;
    }

    public static long longValue(Long l, long j) {
        return l != null ? l.longValue() : j;
    }

    public static long checkInRange(long j, long j2, long j3, String str) {
        if (j >= j2 && j <= j3) {
            return j;
        }
        throw new IllegalArgumentException(str + ": " + j + " (expected: " + j2 + CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR + j3 + ")");
    }

    public static long checkPositive(long j, String str) {
        if (j > 0) {
            return j;
        }
        throw new IllegalArgumentException(str + " : " + j + " (expected: > 0)");
    }

    public static long checkPositiveOrZero(long j, String str) {
        if (j >= 0) {
            return j;
        }
        throw new IllegalArgumentException(str + " : " + j + " (expected: >= 0)");
    }

    public static double checkPositive(double d, String str) {
        if (d > 0.0d) {
            return d;
        }
        throw new IllegalArgumentException(str + " : " + d + " (expected: > 0)");
    }

    public static double checkPositiveOrZero(double d, String str) {
        if (d >= 0.0d) {
            return d;
        }
        throw new IllegalArgumentException(str + " : " + d + " (expected: >= 0)");
    }

    public static float checkPositive(float f, String str) {
        if (f > 0.0f) {
            return f;
        }
        throw new IllegalArgumentException(str + " : " + f + " (expected: > 0)");
    }

    public static float checkPositiveOrZero(float f, String str) {
        if (f >= 0.0f) {
            return f;
        }
        throw new IllegalArgumentException(str + " : " + f + " (expected: >= 0)");
    }

    public static byte[] checkNonEmpty(byte[] bArr, String str) {
        if (((byte[]) checkNotNull(bArr, str)).length != 0) {
            return bArr;
        }
        throw new IllegalArgumentException(AbstractC0541b.m773o("Param '", str, "' must not be empty"));
    }

    public static char[] checkNonEmpty(char[] cArr, String str) {
        if (((char[]) checkNotNull(cArr, str)).length != 0) {
            return cArr;
        }
        throw new IllegalArgumentException(AbstractC0541b.m773o("Param '", str, "' must not be empty"));
    }

    public static <T extends Collection<?>> T checkNonEmpty(T t, String str) {
        if (((Collection) checkNotNull(t, str)).isEmpty()) {
            throw new IllegalArgumentException(AbstractC0541b.m773o("Param '", str, "' must not be empty"));
        }
        return t;
    }

    public static String checkNonEmpty(String str, String str2) {
        if (((String) checkNotNull(str, str2)).isEmpty()) {
            throw new IllegalArgumentException(AbstractC0541b.m773o("Param '", str2, "' must not be empty"));
        }
        return str;
    }

    public static <K, V, T extends Map<K, V>> T checkNonEmpty(T t, String str) {
        if (((Map) checkNotNull(t, str)).isEmpty()) {
            throw new IllegalArgumentException(AbstractC0541b.m773o("Param '", str, "' must not be empty"));
        }
        return t;
    }

    public static CharSequence checkNonEmpty(CharSequence charSequence, String str) {
        if (((CharSequence) checkNotNull(charSequence, str)).length() != 0) {
            return charSequence;
        }
        throw new IllegalArgumentException(AbstractC0541b.m773o("Param '", str, "' must not be empty"));
    }
}
