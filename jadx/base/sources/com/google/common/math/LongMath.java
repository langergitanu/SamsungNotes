package com.google.common.math;

import androidx.compose.animation.core.AnimationKt;
import androidx.compose.runtime.AbstractC1974b;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Longs;
import com.google.common.primitives.UnsignedLongs;
import cz.msebera.android.httpclient.HttpStatus;
import java.math.RoundingMode;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
@GwtCompatible(emulated = true)
public final class LongMath {

    @VisibleForTesting
    static final long FLOOR_SQRT_MAX_LONG = 3037000499L;

    @VisibleForTesting
    static final long MAX_POWER_OF_SQRT2_UNSIGNED = -5402926248376769404L;

    @VisibleForTesting
    static final long MAX_SIGNED_POWER_OF_TWO = 4611686018427387904L;
    private static final int SIEVE_30 = -545925251;

    @VisibleForTesting
    static final byte[] maxLog10ForLeadingZeros = {19, 18, 18, 18, 18, 17, 17, 17, 16, 16, 16, 15, 15, 15, 15, 14, 14, 14, 13, 13, 13, 12, 12, 12, 12, 11, 11, 11, 10, 10, 10, 9, 9, 9, 9, 8, 8, 8, 7, 7, 7, 6, 6, 6, 6, 5, 5, 5, 4, 4, 4, 3, 3, 3, 3, 2, 2, 2, 1, 1, 1, 0, 0, 0};

    @VisibleForTesting
    @J2ktIncompatible
    @GwtIncompatible
    static final long[] powersOf10 = {1, 10, 100, 1000, 10000, 100000, AnimationKt.MillisToNanos, 10000000, 100000000, 1000000000, 10000000000L, 100000000000L, 1000000000000L, 10000000000000L, 100000000000000L, 1000000000000000L, 10000000000000000L, 100000000000000000L, 1000000000000000000L};

    @VisibleForTesting
    @J2ktIncompatible
    @GwtIncompatible
    static final long[] halfPowersOf10 = {3, 31, 316, 3162, 31622, 316227, 3162277, 31622776, 316227766, 3162277660L, 31622776601L, 316227766016L, 3162277660168L, 31622776601683L, 316227766016837L, 3162277660168379L, 31622776601683793L, 316227766016837933L, 3162277660168379331L};
    static final long[] factorials = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800, 39916800, 479001600, 6227020800L, 87178291200L, 1307674368000L, 20922789888000L, 355687428096000L, 6402373705728000L, 121645100408832000L, 2432902008176640000L};
    static final int[] biggestBinomials = {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 3810779, 121977, 16175, 4337, 1733, 887, 534, 361, 265, 206, 169, 143, 125, 111, 101, 94, 88, 83, 79, 76, 74, 72, 70, 69, 68, 67, 67, 66, 66, 66, 66};

    @VisibleForTesting
    static final int[] biggestSimpleBinomials = {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 2642246, 86251, 11724, 3218, 1313, 684, HttpStatus.SC_INSUFFICIENT_SPACE_ON_RESOURCE, 287, 214, 169, 139, 119, 105, 95, 87, 81, 76, 73, 70, 68, 66, 64, 63, 62, 62, 61, 61, 61};
    private static final long[][] millerRabinBaseSets = {new long[]{291830, 126401071349994536L}, new long[]{885594168, 725270293939359937L, 3569819667048198375L}, new long[]{273919523040L, 15, 7363882082L, 992620450144556L}, new long[]{47636622961200L, 2, 2570940, 211991001, 3749873356L}, new long[]{7999252175582850L, 2, 4130806001517L, 149795463772692060L, 186635894390467037L, 3967304179347715805L}, new long[]{585226005592931976L, 2, 123635709730000L, 9233062284813009L, 43835965440333360L, 761179012939631437L, 1263739024124850375L}, new long[]{Long.MAX_VALUE, 2, 325, 9375, 28178, 450775, 9780504, 1795265022}};

    /* JADX INFO: renamed from: com.google.common.math.LongMath$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C58151 {
        static final /* synthetic */ int[] $SwitchMap$java$math$RoundingMode;

        static {
            int[] iArr = new int[RoundingMode.values().length];
            $SwitchMap$java$math$RoundingMode = iArr;
            try {
                iArr[RoundingMode.UNNECESSARY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.DOWN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.FLOOR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.UP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.CEILING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.HALF_DOWN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.HALF_UP.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.HALF_EVEN.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum MillerRabinTester {
        SMALL { // from class: com.google.common.math.LongMath.MillerRabinTester.1
            @Override // com.google.common.math.LongMath.MillerRabinTester
            public long mulMod(long j, long j2, long j3) {
                return (j * j2) % j3;
            }

            @Override // com.google.common.math.LongMath.MillerRabinTester
            public long squareMod(long j, long j2) {
                return (j * j) % j2;
            }
        },
        LARGE { // from class: com.google.common.math.LongMath.MillerRabinTester.2
            private long plusMod(long j, long j2, long j3) {
                long j5 = j + j2;
                return j >= j3 - j2 ? j5 - j3 : j5;
            }

            private long times2ToThe32Mod(long j, long j2) {
                int i = 32;
                do {
                    int iMin = Math.min(i, Long.numberOfLeadingZeros(j));
                    j = UnsignedLongs.remainder(j << iMin, j2);
                    i -= iMin;
                } while (i > 0);
                return j;
            }

            @Override // com.google.common.math.LongMath.MillerRabinTester
            public long mulMod(long j, long j2, long j3) {
                long j5 = j >>> 32;
                long j6 = j2 >>> 32;
                long j7 = j & 4294967295L;
                long j8 = j2 & 4294967295L;
                long jTimes2ToThe32Mod = (j5 * j8) + times2ToThe32Mod(j5 * j6, j3);
                if (jTimes2ToThe32Mod < 0) {
                    jTimes2ToThe32Mod = UnsignedLongs.remainder(jTimes2ToThe32Mod, j3);
                }
                return plusMod(times2ToThe32Mod((j6 * j7) + jTimes2ToThe32Mod, j3), UnsignedLongs.remainder(j7 * j8, j3), j3);
            }

            @Override // com.google.common.math.LongMath.MillerRabinTester
            public long squareMod(long j, long j2) {
                long j3 = j >>> 32;
                long j5 = j & 4294967295L;
                long jTimes2ToThe32Mod = times2ToThe32Mod(j3 * j3, j2);
                long jRemainder = j3 * j5 * 2;
                if (jRemainder < 0) {
                    jRemainder = UnsignedLongs.remainder(jRemainder, j2);
                }
                return plusMod(times2ToThe32Mod(jTimes2ToThe32Mod + jRemainder, j2), UnsignedLongs.remainder(j5 * j5, j2), j2);
            }
        };

        private long powMod(long j, long j2, long j3) {
            long jSquareMod = j;
            long jMulMod = 1;
            while (j2 != 0) {
                long j5 = j3;
                if ((j2 & 1) != 0) {
                    jMulMod = mulMod(jMulMod, jSquareMod, j5);
                }
                jSquareMod = squareMod(jSquareMod, j5);
                j2 >>= 1;
                j3 = j5;
            }
            return jMulMod;
        }

        public static boolean test(long j, long j2) {
            return (j2 <= LongMath.FLOOR_SQRT_MAX_LONG ? SMALL : LARGE).testWitness(j, j2);
        }

        private boolean testWitness(long j, long j2) {
            long j3 = j2 - 1;
            int iNumberOfTrailingZeros = Long.numberOfTrailingZeros(j3);
            long j5 = j3 >> iNumberOfTrailingZeros;
            long j6 = j % j2;
            if (j6 == 0) {
                return true;
            }
            long jPowMod = powMod(j6, j5, j2);
            if (jPowMod == 1) {
                return true;
            }
            int i = 0;
            while (jPowMod != j3) {
                i++;
                if (i == iNumberOfTrailingZeros) {
                    return false;
                }
                jPowMod = squareMod(jPowMod, j2);
            }
            return true;
        }

        public abstract long mulMod(long j, long j2, long j3);

        public abstract long squareMod(long j, long j2);

        /* synthetic */ MillerRabinTester(C58151 c58151) {
            this();
        }
    }

    private LongMath() {
    }

    public static long binomial(int i, int i2) {
        MathPreconditions.checkNonNegative("n", i);
        MathPreconditions.checkNonNegative("k", i2);
        Preconditions.checkArgument(i2 <= i, "k (%s) > n (%s)", i2, i);
        if (i2 > (i >> 1)) {
            i2 = i - i2;
        }
        long jMultiplyFraction = 1;
        if (i2 == 0) {
            return 1L;
        }
        if (i2 == 1) {
            return i;
        }
        long[] jArr = factorials;
        if (i < jArr.length) {
            return jArr[i] / (jArr[i2] * jArr[i - i2]);
        }
        int[] iArr = biggestBinomials;
        if (i2 >= iArr.length || i > iArr[i2]) {
            return Long.MAX_VALUE;
        }
        int[] iArr2 = biggestSimpleBinomials;
        if (i2 < iArr2.length && i <= iArr2[i2]) {
            int i4 = i - 1;
            long j = i;
            for (int i5 = 2; i5 <= i2; i5++) {
                j = (j * ((long) i4)) / ((long) i5);
                i4--;
            }
            return j;
        }
        long j2 = i;
        int iLog2 = log2(j2, RoundingMode.CEILING);
        int i6 = i - 1;
        int i7 = iLog2;
        int i8 = 2;
        long j3 = j2;
        long j5 = 1;
        while (i8 <= i2) {
            i7 += iLog2;
            if (i7 < 63) {
                j3 *= (long) i6;
                j5 *= (long) i8;
            } else {
                jMultiplyFraction = multiplyFraction(jMultiplyFraction, j3, j5);
                j3 = i6;
                j5 = i8;
                i7 = iLog2;
            }
            i8++;
            i6--;
        }
        return multiplyFraction(jMultiplyFraction, j3, j5);
    }

    public static long ceilingPowerOfTwo(long j) {
        MathPreconditions.checkPositive("x", j);
        if (j <= 4611686018427387904L) {
            return 1 << (-Long.numberOfLeadingZeros(j - 1));
        }
        throw new ArithmeticException(AbstractC1974b.m1317j(j, "ceilingPowerOfTwo(", ") is not representable as a long"));
    }

    public static long checkedAdd(long j, long j2) {
        long j3 = j + j2;
        MathPreconditions.checkNoOverflow(((j ^ j2) < 0) | ((j ^ j3) >= 0), "checkedAdd", j, j2);
        return j3;
    }

    public static long checkedMultiply(long j, long j2) {
        int iNumberOfLeadingZeros = Long.numberOfLeadingZeros(~j2) + Long.numberOfLeadingZeros(j2) + Long.numberOfLeadingZeros(~j) + Long.numberOfLeadingZeros(j);
        if (iNumberOfLeadingZeros > 65) {
            return j * j2;
        }
        MathPreconditions.checkNoOverflow(iNumberOfLeadingZeros >= 64, "checkedMultiply", j, j2);
        MathPreconditions.checkNoOverflow((j >= 0) | (j2 != Long.MIN_VALUE), "checkedMultiply", j, j2);
        long j3 = j * j2;
        MathPreconditions.checkNoOverflow(j == 0 || j3 / j == j2, "checkedMultiply", j, j2);
        return j3;
    }

    @J2ktIncompatible
    @GwtIncompatible
    public static long checkedPow(long j, int i) {
        int i2 = i;
        MathPreconditions.checkNonNegative("exponent", i2);
        long jCheckedMultiply = 1;
        if (!(j >= -2) || !(j <= 2)) {
            long j2 = j;
            while (i2 != 0) {
                if (i2 == 1) {
                    return checkedMultiply(jCheckedMultiply, j2);
                }
                if ((i2 & 1) != 0) {
                    jCheckedMultiply = checkedMultiply(jCheckedMultiply, j2);
                }
                i2 >>= 1;
                if (i2 > 0) {
                    MathPreconditions.checkNoOverflow(-3037000499L <= j2 && j2 <= FLOOR_SQRT_MAX_LONG, "checkedPow", j2, i2);
                    j2 *= j2;
                }
            }
            return jCheckedMultiply;
        }
        int i4 = (int) j;
        if (i4 == -2) {
            MathPreconditions.checkNoOverflow(i2 < 64, "checkedPow", j, i2);
            return (i2 & 1) == 0 ? 1 << i2 : (-1) << i2;
        }
        if (i4 == -1) {
            return (i2 & 1) == 0 ? 1L : -1L;
        }
        if (i4 == 0) {
            return i2 == 0 ? 1L : 0L;
        }
        if (i4 == 1) {
            return 1L;
        }
        if (i4 != 2) {
            throw new AssertionError();
        }
        MathPreconditions.checkNoOverflow(i2 < 63, "checkedPow", j, i2);
        return 1 << i2;
    }

    @J2ktIncompatible
    @GwtIncompatible
    public static long checkedSubtract(long j, long j2) {
        long j3 = j - j2;
        MathPreconditions.checkNoOverflow(((j ^ j2) >= 0) | ((j ^ j3) >= 0), "checkedSubtract", j, j2);
        return j3;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @J2ktIncompatible
    @GwtIncompatible
    public static long divide(long j, long j2, RoundingMode roundingMode) {
        Preconditions.checkNotNull(roundingMode);
        long j3 = j / j2;
        long j5 = j - (j2 * j3);
        if (j5 == 0) {
            return j3;
        }
        int i = ((int) ((j ^ j2) >> 63)) | 1;
        switch (C58151.$SwitchMap$java$math$RoundingMode[roundingMode.ordinal()]) {
            case 1:
                MathPreconditions.checkRoundingUnnecessary(j5 == 0);
                return j3;
            case 2:
                return j3;
            case 3:
                if (i >= 0) {
                    return j3;
                }
                return j3 + ((long) i);
            case 4:
                return j3 + ((long) i);
            case 5:
                if (i <= 0) {
                    return j3;
                }
                return j3 + ((long) i);
            case 6:
            case 7:
            case 8:
                long jAbs = Math.abs(j5);
                long jAbs2 = jAbs - (Math.abs(j2) - jAbs);
                if (jAbs2 == 0) {
                    if (roundingMode != RoundingMode.HALF_UP && (roundingMode != RoundingMode.HALF_EVEN || (1 & j3) == 0)) {
                        return j3;
                    }
                } else if (jAbs2 <= 0) {
                    return j3;
                }
                return j3 + ((long) i);
            default:
                throw new AssertionError();
        }
    }

    @J2ktIncompatible
    @GwtIncompatible
    public static long factorial(int i) {
        MathPreconditions.checkNonNegative("n", i);
        long[] jArr = factorials;
        if (i < jArr.length) {
            return jArr[i];
        }
        return Long.MAX_VALUE;
    }

    public static boolean fitsInInt(long j) {
        return ((long) ((int) j)) == j;
    }

    public static long floorPowerOfTwo(long j) {
        MathPreconditions.checkPositive("x", j);
        return 1 << (63 - Long.numberOfLeadingZeros(j));
    }

    public static long gcd(long j, long j2) {
        MathPreconditions.checkNonNegative("a", j);
        MathPreconditions.checkNonNegative("b", j2);
        if (j == 0) {
            return j2;
        }
        if (j2 == 0) {
            return j;
        }
        int iNumberOfTrailingZeros = Long.numberOfTrailingZeros(j);
        long jNumberOfTrailingZeros = j >> iNumberOfTrailingZeros;
        int iNumberOfTrailingZeros2 = Long.numberOfTrailingZeros(j2);
        long j3 = j2 >> iNumberOfTrailingZeros2;
        while (jNumberOfTrailingZeros != j3) {
            long j5 = jNumberOfTrailingZeros - j3;
            long j6 = (j5 >> 63) & j5;
            long j7 = (j5 - j6) - j6;
            j3 += j6;
            jNumberOfTrailingZeros = j7 >> Long.numberOfTrailingZeros(j7);
        }
        return jNumberOfTrailingZeros << Math.min(iNumberOfTrailingZeros, iNumberOfTrailingZeros2);
    }

    public static boolean isPowerOfTwo(long j) {
        return (j > 0) & ((j & (j - 1)) == 0);
    }

    @J2ktIncompatible
    @GwtIncompatible
    public static boolean isPrime(long j) {
        if (j < 2) {
            MathPreconditions.checkNonNegative("n", j);
            return false;
        }
        if (j < 66) {
            return ((722865708377213483 >> (((int) j) + (-2))) & 1) != 0;
        }
        if (((1 << ((int) (j % 30))) & SIEVE_30) != 0 || j % 7 == 0 || j % 11 == 0 || j % 13 == 0) {
            return false;
        }
        if (j < 289) {
            return true;
        }
        for (long[] jArr : millerRabinBaseSets) {
            if (j <= jArr[0]) {
                for (int i = 1; i < jArr.length; i++) {
                    if (!MillerRabinTester.test(jArr[i], j)) {
                        return false;
                    }
                }
                return true;
            }
        }
        throw new AssertionError();
    }

    @VisibleForTesting
    public static int lessThanBranchFree(long j, long j2) {
        return (int) ((~(~(j - j2))) >>> 63);
    }

    @J2ktIncompatible
    @GwtIncompatible
    public static int log10(long j, RoundingMode roundingMode) {
        int iLessThanBranchFree;
        MathPreconditions.checkPositive("x", j);
        int iLog10Floor = log10Floor(j);
        long j2 = powersOf10[iLog10Floor];
        switch (C58151.$SwitchMap$java$math$RoundingMode[roundingMode.ordinal()]) {
            case 1:
                MathPreconditions.checkRoundingUnnecessary(j == j2);
                return iLog10Floor;
            case 2:
            case 3:
                return iLog10Floor;
            case 4:
            case 5:
                iLessThanBranchFree = lessThanBranchFree(j2, j);
                break;
            case 6:
            case 7:
            case 8:
                iLessThanBranchFree = lessThanBranchFree(halfPowersOf10[iLog10Floor], j);
                break;
            default:
                throw new AssertionError();
        }
        return iLessThanBranchFree + iLog10Floor;
    }

    @J2ktIncompatible
    @GwtIncompatible
    public static int log10Floor(long j) {
        byte b = maxLog10ForLeadingZeros[Long.numberOfLeadingZeros(j)];
        return b - lessThanBranchFree(j, powersOf10[b]);
    }

    public static int log2(long j, RoundingMode roundingMode) {
        MathPreconditions.checkPositive("x", j);
        switch (C58151.$SwitchMap$java$math$RoundingMode[roundingMode.ordinal()]) {
            case 1:
                MathPreconditions.checkRoundingUnnecessary(isPowerOfTwo(j));
                break;
            case 2:
            case 3:
                break;
            case 4:
            case 5:
                return 64 - Long.numberOfLeadingZeros(j - 1);
            case 6:
            case 7:
            case 8:
                int iNumberOfLeadingZeros = Long.numberOfLeadingZeros(j);
                return lessThanBranchFree(MAX_POWER_OF_SQRT2_UNSIGNED >>> iNumberOfLeadingZeros, j) + (63 - iNumberOfLeadingZeros);
            default:
                throw new AssertionError("impossible");
        }
        return 63 - Long.numberOfLeadingZeros(j);
    }

    public static long mean(long j, long j2) {
        return (j & j2) + ((j ^ j2) >> 1);
    }

    @J2ktIncompatible
    @GwtIncompatible
    public static int mod(long j, int i) {
        return (int) mod(j, i);
    }

    public static long multiplyFraction(long j, long j2, long j3) {
        if (j == 1) {
            return j2 / j3;
        }
        long jGcd = gcd(j, j3);
        return (j2 / (j3 / jGcd)) * (j / jGcd);
    }

    @J2ktIncompatible
    @GwtIncompatible
    public static long pow(long j, int i) {
        MathPreconditions.checkNonNegative("exponent", i);
        if (-2 > j || j > 2) {
            long j2 = 1;
            while (i != 0) {
                if (i == 1) {
                    return j2 * j;
                }
                j2 *= (i & 1) == 0 ? 1L : j;
                j *= j;
                i >>= 1;
            }
            return j2;
        }
        int i2 = (int) j;
        if (i2 == -2) {
            if (i < 64) {
                return (i & 1) == 0 ? 1 << i : -(1 << i);
            }
            return 0L;
        }
        if (i2 == -1) {
            return (i & 1) == 0 ? 1L : -1L;
        }
        if (i2 == 0) {
            return i == 0 ? 1L : 0L;
        }
        if (i2 == 1) {
            return 1L;
        }
        if (i2 != 2) {
            throw new AssertionError();
        }
        if (i < 64) {
            return 1 << i;
        }
        return 0L;
    }

    @J2ktIncompatible
    @GwtIncompatible
    public static double roundToDouble(long j, RoundingMode roundingMode) {
        long j2;
        double dNextUp;
        long jCeil;
        double d = j;
        long j3 = (long) d;
        int iCompare = j3 == Long.MAX_VALUE ? -1 : Longs.compare(j, j3);
        int[] iArr = C58151.$SwitchMap$java$math$RoundingMode;
        switch (iArr[roundingMode.ordinal()]) {
            case 1:
                MathPreconditions.checkRoundingUnnecessary(iCompare == 0);
                return d;
            case 2:
                if (j >= 0) {
                    if (iCompare < 0) {
                        return DoubleUtils.nextDown(d);
                    }
                } else if (iCompare > 0) {
                    return Math.nextUp(d);
                }
                return d;
            case 3:
                if (iCompare < 0) {
                    return DoubleUtils.nextDown(d);
                }
                return d;
            case 4:
                if (j >= 0) {
                    if (iCompare > 0) {
                        return Math.nextUp(d);
                    }
                } else if (iCompare < 0) {
                    return DoubleUtils.nextDown(d);
                }
                return d;
            case 5:
                if (iCompare > 0) {
                    return Math.nextUp(d);
                }
                return d;
            case 6:
            case 7:
            case 8:
                if (iCompare >= 0) {
                    dNextUp = Math.nextUp(d);
                    j2 = Long.MAX_VALUE;
                    jCeil = (long) Math.ceil(dNextUp);
                } else {
                    j2 = Long.MAX_VALUE;
                    double dNextDown = DoubleUtils.nextDown(d);
                    long jFloor = (long) Math.floor(dNextDown);
                    dNextUp = d;
                    d = dNextDown;
                    jCeil = j3;
                    j3 = jFloor;
                }
                long j5 = j - j3;
                long j6 = jCeil - j;
                if (jCeil == j2) {
                    j6++;
                }
                int iCompare2 = Longs.compare(j5, j6);
                if (iCompare2 >= 0) {
                    if (iCompare2 <= 0) {
                        int i = iArr[roundingMode.ordinal()];
                        if (i != 6) {
                            if (i != 7) {
                                if (i != 8) {
                                    throw new AssertionError("impossible");
                                }
                                if ((DoubleUtils.getSignificand(d) & 1) == 0) {
                                }
                            } else if (j >= 0) {
                            }
                        } else if (j >= 0) {
                        }
                    }
                    return dNextUp;
                }
                return d;
            default:
                throw new AssertionError("impossible");
        }
    }

    public static long saturatedAdd(long j, long j2) {
        long j3 = j + j2;
        return (((j2 ^ j) > 0L ? 1 : ((j2 ^ j) == 0L ? 0 : -1)) < 0) | ((j ^ j3) >= 0) ? j3 : ((j3 >>> 63) ^ 1) + Long.MAX_VALUE;
    }

    public static long saturatedMultiply(long j, long j2) {
        int iNumberOfLeadingZeros = Long.numberOfLeadingZeros(~j2) + Long.numberOfLeadingZeros(j2) + Long.numberOfLeadingZeros(~j) + Long.numberOfLeadingZeros(j);
        if (iNumberOfLeadingZeros > 65) {
            return j * j2;
        }
        long j3 = ((j ^ j2) >>> 63) + Long.MAX_VALUE;
        if (!((iNumberOfLeadingZeros < 64) | ((j2 == Long.MIN_VALUE) & (j < 0)))) {
            long j5 = j * j2;
            if (j == 0 || j5 / j == j2) {
                return j5;
            }
        }
        return j3;
    }

    public static long saturatedPow(long j, int i) {
        MathPreconditions.checkNonNegative("exponent", i);
        long jSaturatedMultiply = 1;
        if (!(j >= -2) || !(j <= 2)) {
            long j2 = ((j >>> 63) & ((long) (i & 1))) + Long.MAX_VALUE;
            while (i != 0) {
                if (i == 1) {
                    return saturatedMultiply(jSaturatedMultiply, j);
                }
                if ((i & 1) != 0) {
                    jSaturatedMultiply = saturatedMultiply(jSaturatedMultiply, j);
                }
                i >>= 1;
                if (i > 0) {
                    if ((-3037000499L > j) || (j > FLOOR_SQRT_MAX_LONG)) {
                        return j2;
                    }
                    j *= j;
                }
            }
            return jSaturatedMultiply;
        }
        int i2 = (int) j;
        if (i2 == -2) {
            return i >= 64 ? ((long) (i & 1)) + Long.MAX_VALUE : (i & 1) == 0 ? 1 << i : (-1) << i;
        }
        if (i2 == -1) {
            return (i & 1) == 0 ? 1L : -1L;
        }
        if (i2 == 0) {
            return i == 0 ? 1L : 0L;
        }
        if (i2 == 1) {
            return 1L;
        }
        if (i2 != 2) {
            throw new AssertionError();
        }
        if (i >= 63) {
            return Long.MAX_VALUE;
        }
        return 1 << i;
    }

    public static long saturatedSubtract(long j, long j2) {
        long j3 = j - j2;
        return (((j2 ^ j) > 0L ? 1 : ((j2 ^ j) == 0L ? 0 : -1)) >= 0) | ((j ^ j3) >= 0) ? j3 : ((j3 >>> 63) ^ 1) + Long.MAX_VALUE;
    }

    @J2ktIncompatible
    @GwtIncompatible
    public static long sqrt(long j, RoundingMode roundingMode) {
        MathPreconditions.checkNonNegative("x", j);
        if (fitsInInt(j)) {
            return IntMath.sqrt((int) j, roundingMode);
        }
        long jSqrt = (long) Math.sqrt(j);
        long j2 = jSqrt * jSqrt;
        switch (C58151.$SwitchMap$java$math$RoundingMode[roundingMode.ordinal()]) {
            case 1:
                MathPreconditions.checkRoundingUnnecessary(j2 == j);
                return jSqrt;
            case 2:
            case 3:
                return j < j2 ? jSqrt - 1 : jSqrt;
            case 4:
            case 5:
                return j > j2 ? jSqrt + 1 : jSqrt;
            case 6:
            case 7:
            case 8:
                long j3 = jSqrt - ((long) (j < j2 ? 1 : 0));
                return j3 + ((long) lessThanBranchFree((j3 * j3) + j3, j));
            default:
                throw new AssertionError();
        }
    }

    @J2ktIncompatible
    @GwtIncompatible
    public static long mod(long j, long j2) {
        if (j2 <= 0) {
            throw new ArithmeticException("Modulus must be positive");
        }
        long j3 = j % j2;
        return j3 >= 0 ? j3 : j3 + j2;
    }
}
