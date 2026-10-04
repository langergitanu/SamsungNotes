package org.apache.commons.collections4.bloomfilter;

import java.util.Arrays;
import java.util.Objects;
import java.util.function.LongPredicate;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@FunctionalInterface
public interface BitMapExtractor {

    /* JADX INFO: renamed from: org.apache.commons.collections4.bloomfilter.BitMapExtractor$1Bits, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public final class C1Bits {
        private long[] data = new long[16];
        private int size;

        public C1Bits() {
        }

        public boolean add(long j) {
            int i = this.size;
            long[] jArr = this.data;
            if (i == jArr.length) {
                this.data = Arrays.copyOf(jArr, i * 2);
            }
            long[] jArr2 = this.data;
            int i2 = this.size;
            this.size = i2 + 1;
            jArr2[i2] = j;
            return true;
        }

        public long[] toArray() {
            int i = this.size;
            long[] jArr = this.data;
            return i == jArr.length ? jArr : Arrays.copyOf(jArr, i);
        }
    }

    static BitMapExtractor fromBitMapArray(final long... jArr) {
        return new BitMapExtractor() { // from class: org.apache.commons.collections4.bloomfilter.BitMapExtractor.1
            @Override // org.apache.commons.collections4.bloomfilter.BitMapExtractor
            public long[] asBitMapArray() {
                long[] jArr2 = jArr;
                return Arrays.copyOf(jArr2, jArr2.length);
            }

            @Override // org.apache.commons.collections4.bloomfilter.BitMapExtractor
            public boolean processBitMapPairs(BitMapExtractor bitMapExtractor, LongBiPredicate longBiPredicate) {
                CountingLongPredicate countingLongPredicate = new CountingLongPredicate(jArr, longBiPredicate);
                return bitMapExtractor.processBitMaps(countingLongPredicate) && countingLongPredicate.processRemaining();
            }

            @Override // org.apache.commons.collections4.bloomfilter.BitMapExtractor
            public boolean processBitMaps(LongPredicate longPredicate) {
                for (long j : jArr) {
                    if (!longPredicate.test(j)) {
                        return false;
                    }
                }
                return true;
            }
        };
    }

    static BitMapExtractor fromIndexExtractor(IndexExtractor indexExtractor, int i) {
        Objects.requireNonNull(indexExtractor, "extractor");
        long[] jArrNewBitMap = BitMaps.newBitMap(i);
        indexExtractor.processIndices(new C13750i(jArrNewBitMap, 2));
        return fromBitMapArray(jArrNewBitMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    static /* synthetic */ boolean lambda$fromIndexExtractor$0(long[] jArr, int i) {
        BitMaps.set(jArr, i);
        return true;
    }

    default long[] asBitMapArray() {
        C1Bits c1Bits = new C1Bits();
        processBitMaps(new C13745d(c1Bits, 0));
        return c1Bits.toArray();
    }

    default boolean processBitMapPairs(BitMapExtractor bitMapExtractor, LongBiPredicate longBiPredicate) {
        CountingLongPredicate countingLongPredicate = new CountingLongPredicate(asBitMapArray(), longBiPredicate);
        return bitMapExtractor.processBitMaps(countingLongPredicate) && countingLongPredicate.processRemaining();
    }

    boolean processBitMaps(LongPredicate longPredicate);
}
