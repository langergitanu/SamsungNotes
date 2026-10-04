package com.google.common.hash;

import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
final class FarmHashFingerprint64 extends AbstractNonStreamingHashFunction {
    static final HashFunction FARMHASH_FINGERPRINT_64 = new FarmHashFingerprint64();

    /* JADX INFO: renamed from: K0 */
    private static final long f3367K0 = -4348849565147123417L;

    /* JADX INFO: renamed from: K1 */
    private static final long f3368K1 = -5435081209227447693L;

    /* JADX INFO: renamed from: K2 */
    private static final long f3369K2 = -7286425919675154353L;

    @VisibleForTesting
    public static long fingerprint(byte[] bArr, int i, int i2) {
        return i2 <= 32 ? i2 <= 16 ? hashLength0to16(bArr, i, i2) : hashLength17to32(bArr, i, i2) : i2 <= 64 ? hashLength33To64(bArr, i, i2) : hashLength65Plus(bArr, i, i2);
    }

    private static long hashLength0to16(byte[] bArr, int i, int i2) {
        if (i2 >= 8) {
            long j = (((long) i2) * 2) + f3369K2;
            long jLoad64 = LittleEndianByteArray.load64(bArr, i) + f3369K2;
            long jLoad642 = LittleEndianByteArray.load64(bArr, (i + i2) - 8);
            return hashLength16((Long.rotateRight(jLoad642, 37) * j) + jLoad64, (Long.rotateRight(jLoad64, 25) + jLoad642) * j, j);
        }
        if (i2 >= 4) {
            return hashLength16(((long) i2) + ((((long) LittleEndianByteArray.load32(bArr, i)) & 4294967295L) << 3), ((long) LittleEndianByteArray.load32(bArr, (i + i2) - 4)) & 4294967295L, ((long) (i2 * 2)) + f3369K2);
        }
        if (i2 <= 0) {
            return f3369K2;
        }
        return shiftMix((((long) ((bArr[i] & 255) + ((bArr[(i2 >> 1) + i] & 255) << 8))) * f3369K2) ^ (((long) (i2 + ((bArr[(i2 - 1) + i] & 255) << 2))) * f3367K0)) * f3369K2;
    }

    private static long hashLength16(long j, long j2, long j3) {
        long j5 = (j ^ j2) * j3;
        long j6 = ((j5 ^ (j5 >>> 47)) ^ j2) * j3;
        return (j6 ^ (j6 >>> 47)) * j3;
    }

    private static long hashLength17to32(byte[] bArr, int i, int i2) {
        long j = (((long) i2) * 2) + f3369K2;
        long jLoad64 = LittleEndianByteArray.load64(bArr, i) * f3368K1;
        long jLoad642 = LittleEndianByteArray.load64(bArr, i + 8);
        int i4 = i + i2;
        long jLoad643 = LittleEndianByteArray.load64(bArr, i4 - 8) * j;
        return hashLength16(Long.rotateRight(jLoad643, 30) + Long.rotateRight(jLoad64 + jLoad642, 43) + (LittleEndianByteArray.load64(bArr, i4 - 16) * f3369K2), jLoad643 + Long.rotateRight(jLoad642 + f3369K2, 18) + jLoad64, j);
    }

    private static long hashLength33To64(byte[] bArr, int i, int i2) {
        long j = (((long) i2) * 2) + f3369K2;
        long jLoad64 = LittleEndianByteArray.load64(bArr, i) * f3369K2;
        long jLoad642 = LittleEndianByteArray.load64(bArr, i + 8);
        int i4 = i + i2;
        long jLoad643 = LittleEndianByteArray.load64(bArr, i4 - 8) * j;
        long jRotateRight = Long.rotateRight(jLoad643, 30) + Long.rotateRight(jLoad64 + jLoad642, 43) + (LittleEndianByteArray.load64(bArr, i4 - 16) * f3369K2);
        long jHashLength16 = hashLength16(jRotateRight, jLoad643 + Long.rotateRight(jLoad642 + f3369K2, 18) + jLoad64, j);
        long jLoad644 = LittleEndianByteArray.load64(bArr, i + 16) * j;
        long jLoad645 = LittleEndianByteArray.load64(bArr, i + 24);
        long jLoad646 = (jRotateRight + LittleEndianByteArray.load64(bArr, i4 - 32)) * j;
        return hashLength16(Long.rotateRight(jLoad646, 30) + Long.rotateRight(jLoad644 + jLoad645, 43) + ((jHashLength16 + LittleEndianByteArray.load64(bArr, i4 - 24)) * j), Long.rotateRight(jLoad645 + jLoad64, 18) + jLoad644 + jLoad646, j);
    }

    private static long hashLength65Plus(byte[] bArr, int i, int i2) {
        byte[] bArr2 = bArr;
        long j = 81;
        long j2 = f3368K1;
        long j3 = (j * f3368K1) + 113;
        long jShiftMix = shiftMix((j3 * f3369K2) + 113) * f3369K2;
        long[] jArr = new long[2];
        long[] jArr2 = new long[2];
        long jLoad64 = (j * f3369K2) + LittleEndianByteArray.load64(bArr, i);
        char c = 1;
        int i4 = i2 - 1;
        char c2 = '@';
        int iM1610D = AbstractC2322a.m1610D(i4, 64, 64, i);
        int i5 = i4 & 63;
        int i6 = iM1610D + i5;
        int i7 = i6 - 63;
        long j5 = jShiftMix;
        long jLoad642 = j3;
        long j6 = jLoad64;
        int i8 = i;
        while (true) {
            long jRotateRight = Long.rotateRight(j6 + jLoad642 + jArr[0] + LittleEndianByteArray.load64(bArr2, i8 + 8), 37) * j2;
            long jRotateRight2 = Long.rotateRight(jLoad642 + jArr[c] + LittleEndianByteArray.load64(bArr2, i8 + 48), 42) * j2;
            long j7 = jRotateRight ^ jArr2[c];
            jLoad642 = jRotateRight2 + jArr[0] + LittleEndianByteArray.load64(bArr2, i8 + 40);
            long jRotateRight3 = Long.rotateRight(j5 + jArr2[0], 33) * j2;
            long j8 = j2;
            char c4 = c2;
            int i9 = i5;
            char c5 = c;
            weakHashLength32WithSeeds(bArr2, i8, jArr[c] * j2, j7 + jArr2[0], jArr);
            int i10 = i8;
            long[] jArr3 = jArr;
            weakHashLength32WithSeeds(bArr2, i10 + 32, jRotateRight3 + jArr2[c5], LittleEndianByteArray.load64(bArr2, i10 + 16) + jLoad642, jArr2);
            i8 = i10 + 64;
            if (i8 == iM1610D) {
                long j9 = ((j7 & 255) << c5) + j8;
                long j10 = jArr2[0] + ((long) i9);
                jArr2[0] = j10;
                long j11 = jArr3[0] + j10;
                jArr3[0] = j11;
                jArr2[0] = jArr2[0] + j11;
                long jRotateRight4 = Long.rotateRight(jRotateRight3 + jLoad642 + jArr3[0] + LittleEndianByteArray.load64(bArr2, i6 - 55), 37) * j9;
                long jRotateRight5 = Long.rotateRight(jLoad642 + jArr3[c5] + LittleEndianByteArray.load64(bArr2, i6 - 15), 42) * j9;
                long j12 = jRotateRight4 ^ (jArr2[c5] * 9);
                long jLoad643 = (jArr3[0] * 9) + LittleEndianByteArray.load64(bArr2, i6 - 23) + jRotateRight5;
                long jRotateRight6 = Long.rotateRight(j7 + jArr2[0], 33) * j9;
                weakHashLength32WithSeeds(bArr2, i7, jArr3[c5] * j9, jArr2[0] + j12, jArr3);
                weakHashLength32WithSeeds(bArr2, i6 - 31, jArr2[c5] + jRotateRight6, LittleEndianByteArray.load64(bArr2, i6 - 47) + jLoad643, jArr2);
                return hashLength16((shiftMix(jLoad643) * f3367K0) + hashLength16(jArr3[0], jArr2[0], j9) + j12, hashLength16(jArr3[c5], jArr2[c5], j9) + jRotateRight6, j9);
            }
            bArr2 = bArr;
            c2 = c4;
            i5 = i9;
            j6 = jRotateRight3;
            j5 = j7;
            c = c5;
            jArr = jArr3;
            j2 = j8;
        }
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
        long jRotateRight = Long.rotateRight(j5, 44) + Long.rotateRight(j2 + j3 + jLoad644, 21);
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
        return "Hashing.farmHashFingerprint64()";
    }
}
