package org.junit;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.glance.AbstractC2821a;
import com.samsung.android.sdk.scs.base.utils.Log;
import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;
import org.junit.function.ThrowingRunnable;
import org.junit.internal.ExactComparisonCriteria;
import org.junit.internal.InexactComparisonCriteria;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class Assert {
    public static void assertArrayEquals(String str, Object[] objArr, Object[] objArr2) {
        internalArrayEquals(str, objArr, objArr2);
    }

    public static void assertEquals(String str, Object obj, Object obj2) {
        if (equalsRegardingNull(obj, obj2)) {
            return;
        }
        if (!(obj instanceof String) || !(obj2 instanceof String)) {
            failNotEquals(str, obj, obj2);
        } else {
            if (str == null) {
                str = "";
            }
            throw new ComparisonFailure(str, (String) obj, (String) obj2);
        }
    }

    public static void assertFalse(String str, boolean z) {
        assertTrue(str, !z);
    }

    public static void assertNotEquals(String str, Object obj, Object obj2) {
        if (equalsRegardingNull(obj, obj2)) {
            failEquals(str, obj2);
        }
    }

    public static void assertNotNull(String str, Object obj) {
        assertTrue(str, obj != null);
    }

    public static void assertNotSame(String str, Object obj, Object obj2) {
        if (obj == obj2) {
            failSame(str);
        }
    }

    public static void assertNull(String str, Object obj) {
        if (obj == null) {
            return;
        }
        failNotNull(str, obj);
    }

    public static void assertSame(String str, Object obj, Object obj2) {
        if (obj == obj2) {
            return;
        }
        failNotSame(str, obj, obj2);
    }

    @Deprecated
    public static <T> void assertThat(T t, Matcher<? super T> matcher) {
        assertThat("", t, matcher);
    }

    public static <T extends Throwable> T assertThrows(Class<T> cls, ThrowingRunnable throwingRunnable) {
        return (T) assertThrows(null, cls, throwingRunnable);
    }

    public static void assertTrue(String str, boolean z) {
        if (z) {
            return;
        }
        fail(str);
    }

    private static String buildPrefix(String str) {
        return (str == null || str.length() == 0) ? "" : str.concat(": ");
    }

    private static boolean doubleIsDifferent(double d, double d2, double d3) {
        return Double.compare(d, d2) != 0 && Math.abs(d - d2) > d3;
    }

    private static boolean equalsRegardingNull(Object obj, Object obj2) {
        return obj == null ? obj2 == null : isEquals(obj, obj2);
    }

    public static void fail(String str) {
        if (str != null) {
            throw new AssertionError(str);
        }
        throw new AssertionError();
    }

    private static void failEquals(String str, Object obj) {
        fail((str != null ? str.concat(". ") : "Values should be different. ") + "Actual: " + obj);
    }

    private static void failNotEquals(String str, Object obj, Object obj2) {
        fail(format(str, obj, obj2));
    }

    private static void failNotNull(String str, Object obj) {
        fail((str != null ? str.concat(" ") : "") + "expected null, but was:<" + obj + ">");
    }

    private static void failNotSame(String str, Object obj, Object obj2) {
        fail((str != null ? str.concat(" ") : "") + "expected same:<" + obj + "> was not:<" + obj2 + ">");
    }

    private static void failSame(String str) {
        fail((str != null ? str.concat(" ") : "") + "expected not same");
    }

    private static boolean floatIsDifferent(float f, float f4, float f5) {
        return Float.compare(f, f4) != 0 && Math.abs(f - f4) > f5;
    }

    public static String format(String str, Object obj, Object obj2) {
        String strConcat = "";
        if (str != null && !"".equals(str)) {
            strConcat = str.concat(" ");
        }
        String strValueOf = String.valueOf(obj);
        String strValueOf2 = String.valueOf(obj2);
        if (!equalsRegardingNull(strValueOf, strValueOf2)) {
            StringBuilder sbM2228s = AbstractC2821a.m2228s(strConcat, "expected:<", strValueOf, "> but was:<", strValueOf2);
            sbM2228s.append(">");
            return sbM2228s.toString();
        }
        StringBuilder sbM781w = AbstractC0541b.m781w(strConcat, "expected: ");
        sbM781w.append(formatClassAndValue(obj, strValueOf));
        sbM781w.append(" but was: ");
        sbM781w.append(formatClassAndValue(obj2, strValueOf2));
        return sbM781w.toString();
    }

    private static String formatClass(Class<?> cls) {
        String canonicalName = cls.getCanonicalName();
        return canonicalName == null ? cls.getName() : canonicalName;
    }

    private static String formatClassAndValue(Object obj, String str) {
        return AbstractC2821a.m2221l(obj == null ? "null" : obj.getClass().getName(), "<", str, ">");
    }

    private static void internalArrayEquals(String str, Object obj, Object obj2) {
        new ExactComparisonCriteria().arrayEquals(str, obj, obj2);
    }

    private static boolean isEquals(Object obj, Object obj2) {
        return obj.equals(obj2);
    }

    public static void assertArrayEquals(Object[] objArr, Object[] objArr2) {
        assertArrayEquals((String) null, objArr, objArr2);
    }

    public static void assertFalse(boolean z) {
        assertFalse(null, z);
    }

    public static void assertNotNull(Object obj) {
        assertNotNull(null, obj);
    }

    public static void assertNotSame(Object obj, Object obj2) {
        assertNotSame(null, obj, obj2);
    }

    public static void assertNull(Object obj) {
        assertNull(null, obj);
    }

    public static void assertSame(Object obj, Object obj2) {
        assertSame(null, obj, obj2);
    }

    @Deprecated
    public static <T> void assertThat(String str, T t, Matcher<? super T> matcher) {
        MatcherAssert.assertThat(str, t, matcher);
    }

    public static <T extends Throwable> T assertThrows(String str, Class<T> cls, ThrowingRunnable throwingRunnable) {
        try {
            throwingRunnable.run();
            StringBuilder sb = new StringBuilder();
            sb.append(buildPrefix(str));
            sb.append("expected " + formatClass(cls) + " to be thrown, but nothing was thrown");
            throw new AssertionError(sb.toString());
        } catch (Throwable th) {
            if (cls.isInstance(th)) {
                return th;
            }
            String string = formatClass(cls);
            Class<?> cls2 = th.getClass();
            String string2 = formatClass(cls2);
            if (string.equals(string2)) {
                StringBuilder sbM781w = AbstractC0541b.m781w(string, Log.TAG_SEPARATOR);
                sbM781w.append(Integer.toHexString(System.identityHashCode(cls)));
                string = sbM781w.toString();
                StringBuilder sbM781w2 = AbstractC0541b.m781w(string2, Log.TAG_SEPARATOR);
                sbM781w2.append(Integer.toHexString(System.identityHashCode(cls2)));
                string2 = sbM781w2.toString();
            }
            AssertionError assertionError = new AssertionError(buildPrefix(str) + format("unexpected exception type thrown;", string, string2));
            assertionError.initCause(th);
            throw assertionError;
        }
    }

    public static void assertTrue(boolean z) {
        assertTrue(null, z);
    }

    public static void assertArrayEquals(String str, boolean[] zArr, boolean[] zArr2) {
        internalArrayEquals(str, zArr, zArr2);
    }

    public static void assertNotEquals(Object obj, Object obj2) {
        assertNotEquals((String) null, obj, obj2);
    }

    public static void fail() {
        fail(null);
    }

    public static void assertArrayEquals(boolean[] zArr, boolean[] zArr2) {
        assertArrayEquals((String) null, zArr, zArr2);
    }

    public static void assertNotEquals(String str, long j, long j2) {
        if (j == j2) {
            failEquals(str, Long.valueOf(j2));
        }
    }

    public static void assertArrayEquals(String str, byte[] bArr, byte[] bArr2) {
        internalArrayEquals(str, bArr, bArr2);
    }

    public static void assertNotEquals(long j, long j2) {
        assertNotEquals((String) null, j, j2);
    }

    public static void assertArrayEquals(byte[] bArr, byte[] bArr2) {
        assertArrayEquals((String) null, bArr, bArr2);
    }

    public static void assertEquals(Object obj, Object obj2) {
        assertEquals((String) null, obj, obj2);
    }

    public static void assertNotEquals(String str, double d, double d2, double d3) {
        if (doubleIsDifferent(d, d2, d3)) {
            return;
        }
        failEquals(str, Double.valueOf(d2));
    }

    public static void assertArrayEquals(String str, char[] cArr, char[] cArr2) {
        internalArrayEquals(str, cArr, cArr2);
    }

    public static void assertEquals(String str, double d, double d2, double d3) {
        if (doubleIsDifferent(d, d2, d3)) {
            failNotEquals(str, Double.valueOf(d), Double.valueOf(d2));
        }
    }

    public static void assertArrayEquals(char[] cArr, char[] cArr2) {
        assertArrayEquals((String) null, cArr, cArr2);
    }

    public static void assertNotEquals(double d, double d2, double d3) {
        assertNotEquals((String) null, d, d2, d3);
    }

    public static void assertArrayEquals(String str, short[] sArr, short[] sArr2) {
        internalArrayEquals(str, sArr, sArr2);
    }

    public static void assertEquals(String str, float f, float f4, float f5) {
        if (floatIsDifferent(f, f4, f5)) {
            failNotEquals(str, Float.valueOf(f), Float.valueOf(f4));
        }
    }

    public static void assertNotEquals(float f, float f4, float f5) {
        assertNotEquals((String) null, f, f4, f5);
    }

    public static void assertArrayEquals(short[] sArr, short[] sArr2) {
        assertArrayEquals((String) null, sArr, sArr2);
    }

    public static void assertNotEquals(String str, float f, float f4, float f5) {
        if (floatIsDifferent(f, f4, f5)) {
            return;
        }
        failEquals(str, Float.valueOf(f4));
    }

    public static void assertArrayEquals(String str, int[] iArr, int[] iArr2) {
        internalArrayEquals(str, iArr, iArr2);
    }

    public static void assertEquals(long j, long j2) {
        assertEquals((String) null, j, j2);
    }

    public static void assertArrayEquals(int[] iArr, int[] iArr2) {
        assertArrayEquals((String) null, iArr, iArr2);
    }

    public static void assertEquals(String str, long j, long j2) {
        if (j != j2) {
            failNotEquals(str, Long.valueOf(j), Long.valueOf(j2));
        }
    }

    public static void assertArrayEquals(String str, long[] jArr, long[] jArr2) {
        internalArrayEquals(str, jArr, jArr2);
    }

    @Deprecated
    public static void assertEquals(double d, double d2) {
        assertEquals((String) null, d, d2);
    }

    public static void assertArrayEquals(long[] jArr, long[] jArr2) {
        assertArrayEquals((String) null, jArr, jArr2);
    }

    @Deprecated
    public static void assertEquals(String str, double d, double d2) {
        fail("Use assertEquals(expected, actual, delta) to compare floating-point numbers");
    }

    public static void assertArrayEquals(String str, double[] dArr, double[] dArr2, double d) {
        new InexactComparisonCriteria(d).arrayEquals(str, dArr, dArr2);
    }

    public static void assertEquals(double d, double d2, double d3) {
        assertEquals((String) null, d, d2, d3);
    }

    public static void assertArrayEquals(double[] dArr, double[] dArr2, double d) {
        assertArrayEquals((String) null, dArr, dArr2, d);
    }

    public static void assertEquals(float f, float f4, float f5) {
        assertEquals((String) null, f, f4, f5);
    }

    public static void assertArrayEquals(String str, float[] fArr, float[] fArr2, float f) {
        new InexactComparisonCriteria(f).arrayEquals(str, fArr, fArr2);
    }

    @Deprecated
    public static void assertEquals(String str, Object[] objArr, Object[] objArr2) {
        assertArrayEquals(str, objArr, objArr2);
    }

    public static void assertArrayEquals(float[] fArr, float[] fArr2, float f) {
        assertArrayEquals((String) null, fArr, fArr2, f);
    }

    @Deprecated
    public static void assertEquals(Object[] objArr, Object[] objArr2) {
        assertArrayEquals(objArr, objArr2);
    }
}
