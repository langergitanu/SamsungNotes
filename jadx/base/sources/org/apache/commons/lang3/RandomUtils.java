package org.apache.commons.lang3;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;
import java.util.function.Supplier;
import org.apache.commons.lang3.exception.UncheckedException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class RandomUtils {
    private static RandomUtils INSECURE = new RandomUtils(new C13930x(3));
    private static RandomUtils SECURE = new RandomUtils(new C13930x(4));
    private static final ThreadLocal<SecureRandom> SECURE_RANDOM_STRONG;
    private static RandomUtils SECURE_STRONG;
    private static final Supplier<Random> SECURE_STRONG_SUPPLIER;
    private final Supplier<Random> random;

    static {
        C13930x c13930x = new C13930x(5);
        SECURE_STRONG_SUPPLIER = c13930x;
        SECURE_STRONG = new RandomUtils(c13930x);
        SECURE_RANDOM_STRONG = ThreadLocal.withInitial(new C13930x(6));
    }

    @Deprecated
    public RandomUtils() {
        this(SECURE_STRONG_SUPPLIER);
    }

    public static RandomUtils insecure() {
        return INSECURE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Random lambda$static$0() {
        return SECURE_RANDOM_STRONG.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ SecureRandom lambda$static$1() {
        try {
            return SecureRandom.getInstanceStrong();
        } catch (NoSuchAlgorithmException e) {
            throw new UncheckedException(e);
        }
    }

    @Deprecated
    public static boolean nextBoolean() {
        return secure().randomBoolean();
    }

    @Deprecated
    public static byte[] nextBytes(int i) {
        return secure().randomBytes(i);
    }

    @Deprecated
    public static double nextDouble() {
        return secure().randomDouble();
    }

    @Deprecated
    public static float nextFloat() {
        return secure().randomFloat();
    }

    @Deprecated
    public static int nextInt() {
        return secure().randomInt();
    }

    @Deprecated
    public static long nextLong() {
        return secure().randomLong();
    }

    public static RandomUtils secure() {
        return SECURE;
    }

    public static SecureRandom secureRandom() {
        return SECURE_RANDOM_STRONG.get();
    }

    public static RandomUtils secureStrong() {
        return SECURE_STRONG;
    }

    public Random random() {
        return this.random.get();
    }

    public boolean randomBoolean() {
        return random().nextBoolean();
    }

    public byte[] randomBytes(int i) {
        Validate.isTrue(i >= 0, "Count cannot be negative.", new Object[0]);
        byte[] bArr = new byte[i];
        random().nextBytes(bArr);
        return bArr;
    }

    public double randomDouble() {
        return randomDouble(0.0d, Double.MAX_VALUE);
    }

    public float randomFloat() {
        return randomFloat(0.0f, Float.MAX_VALUE);
    }

    public int randomInt() {
        return randomInt(0, Integer.MAX_VALUE);
    }

    public long randomLong() {
        return randomLong(Long.MAX_VALUE);
    }

    public String toString() {
        return "RandomUtils [random=" + random() + "]";
    }

    private RandomUtils(Supplier<Random> supplier) {
        this.random = supplier;
    }

    @Deprecated
    public static double nextDouble(double d, double d2) {
        return secure().randomDouble(d, d2);
    }

    @Deprecated
    public static float nextFloat(float f, float f4) {
        return secure().randomFloat(f, f4);
    }

    @Deprecated
    public static int nextInt(int i, int i2) {
        return secure().randomInt(i, i2);
    }

    @Deprecated
    public static long nextLong(long j, long j2) {
        return secure().randomLong(j, j2);
    }

    private long randomLong(long j) {
        long jNextLong;
        long j2;
        do {
            jNextLong = random().nextLong() >>> 1;
            j2 = jNextLong % j;
        } while (((jNextLong - j2) + j) - 1 < 0);
        return j2;
    }

    public double randomDouble(double d, double d2) {
        Validate.isTrue(d2 >= d, "Start value must be smaller or equal to end value.", new Object[0]);
        Validate.isTrue(d >= 0.0d, "Both range values must be non-negative.", new Object[0]);
        if (d == d2) {
            return d;
        }
        return (random().nextDouble() * (d2 - d)) + d;
    }

    public float randomFloat(float f, float f4) {
        Validate.isTrue(f4 >= f, "Start value must be smaller or equal to end value.", new Object[0]);
        Validate.isTrue(f >= 0.0f, "Both range values must be non-negative.", new Object[0]);
        if (f == f4) {
            return f;
        }
        return (random().nextFloat() * (f4 - f)) + f;
    }

    public int randomInt(int i, int i2) {
        Validate.isTrue(i2 >= i, "Start value must be smaller or equal to end value.", new Object[0]);
        Validate.isTrue(i >= 0, "Both range values must be non-negative.", new Object[0]);
        return i == i2 ? i : random().nextInt(i2 - i) + i;
    }

    public long randomLong(long j, long j2) {
        Validate.isTrue(j2 >= j, "Start value must be smaller or equal to end value.", new Object[0]);
        Validate.isTrue(j >= 0, "Both range values must be non-negative.", new Object[0]);
        return j == j2 ? j : j + randomLong(j2 - j);
    }
}
