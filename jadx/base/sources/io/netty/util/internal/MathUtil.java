package io.netty.util.internal;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final class MathUtil {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    private MathUtil() {
    }

    public static int compare(int i, int i2) {
        if (i < i2) {
            return -1;
        }
        return i > i2 ? 1 : 0;
    }

    public static int findNextPositivePowerOfTwo(int i) {
        return 1 << (32 - Integer.numberOfLeadingZeros(i - 1));
    }

    public static boolean isOutOfBounds(int i, int i2, int i4) {
        int i5 = i | i2 | i4;
        int i6 = i + i2;
        return ((i5 | i6) | (i4 - i6)) < 0;
    }

    public static int safeFindNextPositivePowerOfTwo(int i) {
        if (i <= 0) {
            return 1;
        }
        if (i >= 1073741824) {
            return 1073741824;
        }
        return findNextPositivePowerOfTwo(i);
    }

    public static int compare(long j, long j2) {
        if (j < j2) {
            return -1;
        }
        return j > j2 ? 1 : 0;
    }
}
