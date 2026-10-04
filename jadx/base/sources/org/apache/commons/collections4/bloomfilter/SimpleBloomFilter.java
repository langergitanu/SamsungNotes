package org.apache.commons.collections4.bloomfilter;

import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.metadata.VMetaDataKey;
import java.util.Arrays;
import java.util.Objects;
import java.util.function.IntPredicate;
import java.util.function.LongPredicate;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class SimpleBloomFilter implements BloomFilter<SimpleBloomFilter> {
    private final long[] bitMap;
    private int cardinality;
    private final Shape shape;

    public SimpleBloomFilter(Shape shape) {
        Objects.requireNonNull(shape, VMetaDataKey.META_KEY_SHAPE);
        this.shape = shape;
        this.bitMap = BitMaps.newBitMap(shape);
        this.cardinality = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$contains$0(int i) {
        return BitMaps.contains(this.bitMap, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$isEmpty$1(long j) {
        return j == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$merge$2(int[] iArr, long j) {
        long[] jArr = this.bitMap;
        int i = iArr[0];
        iArr[0] = i + 1;
        jArr[i] = jArr[i] | j;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$merge$3(int i) {
        if (i < 0 || i >= this.shape.getNumberOfBits()) {
            throw new IllegalArgumentException(AbstractC0541b.m767i(this.shape.getNumberOfBits(), "IndexExtractor should only send values in the range[0,", ")"));
        }
        BitMaps.set(this.bitMap, i);
        return true;
    }

    @Override // org.apache.commons.collections4.bloomfilter.BitMapExtractor
    public long[] asBitMapArray() {
        long[] jArr = this.bitMap;
        return Arrays.copyOf(jArr, jArr.length);
    }

    @Override // org.apache.commons.collections4.bloomfilter.BloomFilter
    public int cardinality() {
        int i = this.cardinality;
        if (i >= 0) {
            return i;
        }
        int iCardinality = SetOperations.cardinality(this);
        this.cardinality = iCardinality;
        return iCardinality;
    }

    @Override // org.apache.commons.collections4.bloomfilter.BloomFilter
    public int characteristics() {
        return 0;
    }

    @Override // org.apache.commons.collections4.bloomfilter.BloomFilter
    public void clear() {
        Arrays.fill(this.bitMap, 0L);
        this.cardinality = 0;
    }

    @Override // org.apache.commons.collections4.bloomfilter.BloomFilter
    public boolean contains(IndexExtractor indexExtractor) {
        return indexExtractor.processIndices(new C13760s(this, 0));
    }

    @Override // org.apache.commons.collections4.bloomfilter.BloomFilter
    public Shape getShape() {
        return this.shape;
    }

    @Override // org.apache.commons.collections4.bloomfilter.BloomFilter
    public boolean isEmpty() {
        return this.cardinality == 0 || processBitMaps(new C13746e(1));
    }

    @Override // org.apache.commons.collections4.bloomfilter.BloomFilter
    public boolean merge(BitMapExtractor bitMapExtractor) {
        Objects.requireNonNull(bitMapExtractor, "bitMapExtractor");
        try {
            final int[] iArr = new int[1];
            bitMapExtractor.processBitMaps(new LongPredicate() { // from class: org.apache.commons.collections4.bloomfilter.t
                @Override // java.util.function.LongPredicate
                public final boolean test(long j) {
                    return this.f9746a.lambda$merge$2(iArr, j);
                }
            });
            iArr[0] = iArr[0] - 1;
            int longIndex = BitMaps.getLongIndex(this.shape.getNumberOfBits());
            if (longIndex == iArr[0] && (this.bitMap[longIndex] >> this.shape.getNumberOfBits()) != 0) {
                throw new IllegalArgumentException("BitMapExtractor set a bit higher than the limit for the shape: " + this.shape.getNumberOfBits());
            }
            this.cardinality = -1;
            return true;
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalArgumentException(AbstractC0541b.m767i(this.bitMap.length, "BitMapExtractor should send at most ", " maps"), e);
        }
    }

    @Override // org.apache.commons.collections4.bloomfilter.BitMapExtractor
    public boolean processBitMapPairs(BitMapExtractor bitMapExtractor, LongBiPredicate longBiPredicate) {
        CountingLongPredicate countingLongPredicate = new CountingLongPredicate(this.bitMap, longBiPredicate);
        return bitMapExtractor.processBitMaps(countingLongPredicate) && countingLongPredicate.processRemaining();
    }

    @Override // org.apache.commons.collections4.bloomfilter.BitMapExtractor
    public boolean processBitMaps(LongPredicate longPredicate) {
        Objects.requireNonNull(longPredicate, "consumer");
        for (long j : this.bitMap) {
            if (!longPredicate.test(j)) {
                return false;
            }
        }
        return true;
    }

    @Override // org.apache.commons.collections4.bloomfilter.IndexExtractor, org.apache.commons.collections4.bloomfilter.CellExtractor
    public boolean processIndices(IntPredicate intPredicate) {
        Objects.requireNonNull(intPredicate, "consumer");
        return IndexExtractor.fromBitMapExtractor(this).processIndices(intPredicate);
    }

    @Override // org.apache.commons.collections4.bloomfilter.BloomFilter
    public SimpleBloomFilter copy() {
        return new SimpleBloomFilter(this);
    }

    private SimpleBloomFilter(SimpleBloomFilter simpleBloomFilter) {
        this.shape = simpleBloomFilter.shape;
        this.bitMap = (long[]) simpleBloomFilter.bitMap.clone();
        this.cardinality = simpleBloomFilter.cardinality;
    }

    @Override // org.apache.commons.collections4.bloomfilter.BloomFilter
    public boolean merge(BloomFilter<?> bloomFilter) {
        Objects.requireNonNull(bloomFilter, "other");
        if ((bloomFilter.characteristics() & 1) != 0) {
            merge((IndexExtractor) bloomFilter);
        } else {
            merge((BitMapExtractor) bloomFilter);
        }
        return true;
    }

    @Override // org.apache.commons.collections4.bloomfilter.BloomFilter
    public boolean merge(Hasher hasher) {
        Objects.requireNonNull(hasher, "hasher");
        return merge(hasher.indices(this.shape));
    }

    @Override // org.apache.commons.collections4.bloomfilter.BloomFilter
    public boolean merge(IndexExtractor indexExtractor) {
        Objects.requireNonNull(indexExtractor, "indexExtractor");
        indexExtractor.processIndices(new C13760s(this, 1));
        this.cardinality = -1;
        return true;
    }
}
