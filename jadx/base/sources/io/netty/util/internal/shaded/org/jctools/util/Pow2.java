package io.netty.util.internal.shaded.org.jctools.util;

import androidx.appcompat.widget.AbstractC0541b;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final class Pow2 {
    public static final int MAX_POW2 = 1073741824;

    public static long align(long j, int i) {
        if (!isPowerOfTwo(i)) {
            throw new IllegalArgumentException(AbstractC0000a.m11h(i, "alignment must be a power of 2:"));
        }
        int i2 = i - 1;
        return (j + ((long) i2)) & ((long) (~i2));
    }

    public static boolean isPowerOfTwo(int i) {
        return (i & (i + (-1))) == 0;
    }

    public static int roundToPowerOfTwo(int i) {
        if (i > 1073741824) {
            throw new IllegalArgumentException(AbstractC0541b.m767i(i, "There is no larger power of 2 int for value:", " since it exceeds 2^31."));
        }
        if (i >= 0) {
            return 1 << (32 - Integer.numberOfLeadingZeros(i - 1));
        }
        throw new IllegalArgumentException(AbstractC0541b.m767i(i, "Given value:", ". Expecting value >= 0."));
    }
}
