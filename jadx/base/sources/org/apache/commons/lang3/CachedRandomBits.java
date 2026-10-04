package org.apache.commons.lang3;

import java.util.Objects;
import java.util.Random;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
final class CachedRandomBits {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int BITS_PER_BYTE = 8;
    private static final int BIT_INDEX_MASK = 7;
    private static final int MAX_BITS = 32;
    private static final int MAX_CACHE_SIZE = 268435455;
    private int bitIndex;
    private final byte[] cache;
    private final Random random;

    public CachedRandomBits(int i, Random random) {
        if (i <= 0) {
            throw new IllegalArgumentException("cacheSize must be positive");
        }
        byte[] bArr = i <= MAX_CACHE_SIZE ? new byte[i] : new byte[MAX_CACHE_SIZE];
        this.cache = bArr;
        Objects.requireNonNull(random, "random");
        this.random = random;
        random.nextBytes(bArr);
        this.bitIndex = 0;
    }

    public int nextBits(int i) {
        if (i > 32 || i <= 0) {
            throw new IllegalArgumentException("number of bits must be between 1 and 32");
        }
        int i2 = 0;
        int i4 = 0;
        while (i2 < i) {
            int i5 = this.bitIndex >> 3;
            byte[] bArr = this.cache;
            if (i5 >= bArr.length) {
                this.random.nextBytes(bArr);
                this.bitIndex = 0;
            }
            int iMin = Math.min(8 - (this.bitIndex & 7), i - i2);
            byte[] bArr2 = this.cache;
            int i6 = this.bitIndex;
            i4 = (i4 << iMin) | ((bArr2[i6 >> 3] >> (i6 & 7)) & ((1 << iMin) - 1));
            i2 += iMin;
            this.bitIndex = i6 + iMin;
        }
        return i4;
    }
}
