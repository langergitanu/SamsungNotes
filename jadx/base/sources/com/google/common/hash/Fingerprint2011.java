package com.google.common.hash;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
final class Fingerprint2011 extends AbstractNonStreamingHashFunction {
    static final HashFunction FINGERPRINT_2011 = new Fingerprint2011();

    /* JADX INFO: renamed from: K0 */
    private static final long f3370K0 = -6505348102511208375L;

    /* JADX INFO: renamed from: K1 */
    private static final long f3371K1 = -8261664234251669945L;

    /* JADX INFO: renamed from: K2 */
    private static final long f3372K2 = -4288712594273399085L;

    /* JADX INFO: renamed from: K3 */
    private static final long f3373K3 = -4132994306676758123L;

    @VisibleForTesting
    public static long fingerprint(byte[] bArr, int i, int i2) {
        long jMurmurHash64WithSeed = i2 <= 32 ? murmurHash64WithSeed(bArr, i, i2, -1397348546323613475L) : i2 <= 64 ? hashLength33To64(bArr, i, i2) : fullFingerprint(bArr, i, i2);
        long jLoad64 = f3370K0;
        long jLoad642 = i2 >= 8 ? LittleEndianByteArray.load64(bArr, i) : -6505348102511208375L;
        if (i2 >= 9) {
            jLoad64 = LittleEndianByteArray.load64(bArr, (i + i2) - 8);
        }
        long jHash128to64 = hash128to64(jMurmurHash64WithSeed + jLoad64, jLoad642);
        return (jHash128to64 == 0 || jHash128to64 == 1) ? jHash128to64 - 2 : jHash128to64;
    }

    private static long fullFingerprint(byte[] bArr, int i, int i2) {
        byte[] bArr2 = bArr;
        long jLoad64 = LittleEndianByteArray.load64(bArr, i);
        int i4 = i + i2;
        long jLoad642 = LittleEndianByteArray.load64(bArr2, i4 - 16) ^ f3371K1;
        long jLoad643 = f3370K0 ^ LittleEndianByteArray.load64(bArr2, i4 - 56);
        long[] jArr = new long[2];
        long[] jArr2 = new long[2];
        long j = i2;
        weakHashLength32WithSeeds(bArr2, i4 - 64, j, jLoad642, jArr);
        weakHashLength32WithSeeds(bArr2, i4 - 32, j * f3371K1, f3370K0, jArr2);
        long[] jArr3 = jArr2;
        long jShiftMix = (shiftMix(jArr[1]) * f3371K1) + jLoad643;
        long jRotateRight = Long.rotateRight(jLoad64 + jShiftMix, 39) * f3371K1;
        int i5 = (i2 - 1) & (-64);
        long jRotateRight2 = Long.rotateRight(jLoad642, 33) * f3371K1;
        long j2 = jRotateRight;
        long j3 = jShiftMix;
        int i6 = i;
        while (true) {
            long jRotateRight3 = Long.rotateRight(j2 + jRotateRight2 + jArr[0] + LittleEndianByteArray.load64(bArr2, i6 + 16), 37) * f3371K1;
            long jRotateRight4 = Long.rotateRight(jRotateRight2 + jArr[1] + LittleEndianByteArray.load64(bArr2, i6 + 48), 42) * f3371K1;
            long j5 = jArr3[1] ^ jRotateRight3;
            long j6 = jRotateRight4 ^ jArr[0];
            long jRotateRight5 = Long.rotateRight(j3 ^ jArr3[0], 33);
            weakHashLength32WithSeeds(bArr2, i6, jArr[1] * f3371K1, jArr3[0] + j5, jArr);
            int i7 = i6;
            long[] jArr4 = jArr3;
            weakHashLength32WithSeeds(bArr, i7 + 32, jRotateRight5 + jArr3[1], j6, jArr4);
            i6 = i7 + 64;
            i5 -= 64;
            if (i5 == 0) {
                return hash128to64((shiftMix(j6) * f3371K1) + hash128to64(jArr[0], jArr4[0]) + j5, hash128to64(jArr[1], jArr4[1]) + jRotateRight5);
            }
            bArr2 = bArr;
            jArr3 = jArr4;
            j3 = j5;
            jRotateRight2 = j6;
            j2 = jRotateRight5;
        }
    }

    @VisibleForTesting
    public static long hash128to64(long j, long j2) {
        long j3 = (j2 ^ j) * f3373K3;
        long j5 = (j ^ (j3 ^ (j3 >>> 47))) * f3373K3;
        return (j5 ^ (j5 >>> 47)) * f3373K3;
    }

    private static long hashLength33To64(byte[] bArr, int i, int i2) {
        long jLoad64 = LittleEndianByteArray.load64(bArr, i + 24);
        int i4 = i + i2;
        int i5 = i4 - 16;
        long jLoad642 = ((((long) i2) + LittleEndianByteArray.load64(bArr, i5)) * f3370K0) + LittleEndianByteArray.load64(bArr, i);
        long jRotateRight = Long.rotateRight(jLoad642 + jLoad64, 52);
        long jRotateRight2 = Long.rotateRight(jLoad642, 37);
        long jLoad643 = jLoad642 + LittleEndianByteArray.load64(bArr, i + 8);
        long jRotateRight3 = Long.rotateRight(jLoad643, 7) + jRotateRight2;
        int i6 = i + 16;
        long jLoad644 = jLoad643 + LittleEndianByteArray.load64(bArr, i6);
        long j = jLoad64 + jLoad644;
        long jRotateRight4 = Long.rotateRight(jLoad644, 31) + jRotateRight + jRotateRight3;
        long jLoad645 = LittleEndianByteArray.load64(bArr, i6) + LittleEndianByteArray.load64(bArr, i4 - 32);
        long jLoad646 = LittleEndianByteArray.load64(bArr, i4 - 8);
        long jRotateRight5 = Long.rotateRight(jLoad645 + jLoad646, 52);
        long jRotateRight6 = Long.rotateRight(jLoad645, 37);
        long jLoad647 = jLoad645 + LittleEndianByteArray.load64(bArr, i4 - 24);
        long jRotateRight7 = Long.rotateRight(jLoad647, 7) + jRotateRight6;
        long jLoad648 = jLoad647 + LittleEndianByteArray.load64(bArr, i5);
        return shiftMix((shiftMix(((jLoad648 + jLoad646 + jRotateRight4) * f3370K0) + ((Long.rotateRight(jLoad648, 31) + jRotateRight5 + jRotateRight7 + j) * f3372K2)) * f3370K0) + jRotateRight4) * f3372K2;
    }

    @VisibleForTesting
    public static long murmurHash64WithSeed(byte[] bArr, int i, int i2, long j) {
        int i4 = i2 & (-8);
        int i5 = i2 & 7;
        long jLoad64Safely = j ^ (((long) i2) * f3373K3);
        for (int i6 = 0; i6 < i4; i6 += 8) {
            jLoad64Safely = (jLoad64Safely ^ (shiftMix(LittleEndianByteArray.load64(bArr, i + i6) * f3373K3) * f3373K3)) * f3373K3;
        }
        if (i5 != 0) {
            jLoad64Safely = (LittleEndianByteArray.load64Safely(bArr, i + i4, i5) ^ jLoad64Safely) * f3373K3;
        }
        return shiftMix(shiftMix(jLoad64Safely) * f3373K3);
    }

    private static long shiftMix(long j) {
        return j ^ (j >>> 47);
    }

    private static void weakHashLength32WithSeeds(byte[] bArr, int i, long j, long j2, long[] jArr) {
        long jLoad64 = LittleEndianByteArray.load64(bArr, i);
        long jLoad642 = LittleEndianByteArray.load64(bArr, i + 8);
        long jLoad643 = LittleEndianByteArray.load64(bArr, i + 16);
        long jLoad644 = LittleEndianByteArray.load64(bArr, i + 24);
        long j3 = j + jLoad64;
        long j5 = jLoad642 + j3 + jLoad643;
        long jRotateRight = Long.rotateRight(j5, 23) + Long.rotateRight(j2 + j3 + jLoad644, 51);
        jArr[0] = j5 + jLoad644;
        jArr[1] = jRotateRight + j3;
    }

    @Override // com.google.common.hash.HashFunction
    public int bits() {
        return 64;
    }

    @Override // com.google.common.hash.AbstractNonStreamingHashFunction, com.google.common.hash.AbstractHashFunction, com.google.common.hash.HashFunction
    public HashCode hashBytes(byte[] bArr, int i, int i2) {
        Preconditions.checkPositionIndexes(i, i + i2, bArr.length);
        return HashCode.fromLong(fingerprint(bArr, i, i2));
    }

    public String toString() {
        return "Hashing.fingerprint2011()";
    }
}
