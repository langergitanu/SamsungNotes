package androidx.core.math;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public class MathUtils {
    private MathUtils() {
    }

    public static int addExact(int i, int i2) {
        int i4 = i + i2;
        if ((i >= 0) == (i2 >= 0)) {
            if ((i >= 0) != (i4 >= 0)) {
                throw new ArithmeticException("integer overflow");
            }
        }
        return i4;
    }

    public static double clamp(double d, double d2, double d3) {
        return d < d2 ? d2 : d > d3 ? d3 : d;
    }

    public static int decrementExact(int i) {
        if (i != Integer.MIN_VALUE) {
            return i - 1;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static int incrementExact(int i) {
        if (i != Integer.MAX_VALUE) {
            return i + 1;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static int multiplyExact(int i, int i2) {
        int i4 = i * i2;
        if (i == 0 || i2 == 0 || (i4 / i == i2 && i4 / i2 == i)) {
            return i4;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static int negateExact(int i) {
        if (i != Integer.MIN_VALUE) {
            return -i;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static int subtractExact(int i, int i2) {
        int i4 = i - i2;
        if ((i < 0) != (i2 < 0)) {
            if ((i < 0) != (i4 < 0)) {
                throw new ArithmeticException("integer overflow");
            }
        }
        return i4;
    }

    public static int toIntExact(long j) {
        if (j > 2147483647L || j < -2147483648L) {
            throw new ArithmeticException("integer overflow");
        }
        return (int) j;
    }

    public static long addExact(long j, long j2) {
        long j3 = j + j2;
        if ((j >= 0) == (j2 >= 0)) {
            if ((j >= 0) != (j3 >= 0)) {
                throw new ArithmeticException("integer overflow");
            }
        }
        return j3;
    }

    public static float clamp(float f, float f4, float f5) {
        return f < f4 ? f4 : f > f5 ? f5 : f;
    }

    public static long decrementExact(long j) {
        if (j != Long.MIN_VALUE) {
            return j - 1;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static long incrementExact(long j) {
        if (j != Long.MAX_VALUE) {
            return j + 1;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static long negateExact(long j) {
        if (j != Long.MIN_VALUE) {
            return -j;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static long subtractExact(long j, long j2) {
        long j3 = j - j2;
        if ((j < 0) != (j2 < 0)) {
            if ((j < 0) != (j3 < 0)) {
                throw new ArithmeticException("integer overflow");
            }
        }
        return j3;
    }

    public static int clamp(int i, int i2, int i4) {
        return i < i2 ? i2 : i > i4 ? i4 : i;
    }

    public static long multiplyExact(long j, long j2) {
        long j3 = j * j2;
        if (j == 0 || j2 == 0 || (j3 / j == j2 && j3 / j2 == j)) {
            return j3;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static long clamp(long j, long j2, long j3) {
        return j < j2 ? j2 : j > j3 ? j3 : j;
    }
}
