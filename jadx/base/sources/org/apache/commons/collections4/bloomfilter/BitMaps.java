package org.apache.commons.collections4.bloomfilter;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class BitMaps {
    private static final int DIVIDE_BY_64 = 6;

    private BitMaps() {
    }

    public static boolean contains(long[] jArr, int i) {
        return (getLongBit(i) & jArr[getLongIndex(i)]) != 0;
    }

    public static long getLongBit(int i) {
        return 1 << i;
    }

    public static int getLongIndex(int i) {
        return i >> 6;
    }

    public static int mod(long j, int i) {
        long j2 = i;
        long j3 = j - ((((j >>> 1) / j2) << 1) * j2);
        if (j3 >= j2) {
            j3 -= j2;
        }
        return (int) j3;
    }

    public static long[] newBitMap(int i) {
        return new long[numberOfBitMaps(i)];
    }

    public static int numberOfBitMaps(int i) {
        return ((i - 1) >> 6) + 1;
    }

    public static void set(long[] jArr, int i) {
        int longIndex = getLongIndex(i);
        jArr[longIndex] = jArr[longIndex] | getLongBit(i);
    }

    public static long[] newBitMap(Shape shape) {
        return newBitMap(shape.getNumberOfBits());
    }

    public static int numberOfBitMaps(Shape shape) {
        return numberOfBitMaps(shape.getNumberOfBits());
    }
}
