package org.apache.commons.collections4.bloomfilter;

import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.metadata.VMetaDataKey;
import java.util.Iterator;
import java.util.Objects;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.function.IntPredicate;
import java.util.function.LongPredicate;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class SparseBloomFilter implements BloomFilter<SparseBloomFilter> {
    private final TreeSet<Integer> indices;
    private final Shape shape;

    public SparseBloomFilter(Shape shape) {
        Objects.requireNonNull(shape, VMetaDataKey.META_KEY_SHAPE);
        this.shape = shape;
        this.indices = new TreeSet<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean add(int i) {
        this.indices.add(Integer.valueOf(i));
        return true;
    }

    @Override // org.apache.commons.collections4.bloomfilter.BitMapExtractor
    public long[] asBitMapArray() {
        long[] jArrNewBitMap = BitMaps.newBitMap(this.shape);
        Iterator<Integer> it = this.indices.iterator();
        while (it.hasNext()) {
            BitMaps.set(jArrNewBitMap, it.next().intValue());
        }
        return jArrNewBitMap;
    }

    @Override // org.apache.commons.collections4.bloomfilter.BloomFilter
    public int cardinality() {
        return this.indices.size();
    }

    @Override // org.apache.commons.collections4.bloomfilter.BloomFilter
    public int characteristics() {
        return 1;
    }

    @Override // org.apache.commons.collections4.bloomfilter.BloomFilter
    public void clear() {
        this.indices.clear();
    }

    @Override // org.apache.commons.collections4.bloomfilter.BloomFilter
    public boolean contains(BitMapExtractor bitMapExtractor) {
        return contains(IndexExtractor.fromBitMapExtractor(bitMapExtractor));
    }

    @Override // org.apache.commons.collections4.bloomfilter.BloomFilter
    public Shape getShape() {
        return this.shape;
    }

    @Override // org.apache.commons.collections4.bloomfilter.BloomFilter
    public boolean isEmpty() {
        return this.indices.isEmpty();
    }

    @Override // org.apache.commons.collections4.bloomfilter.BloomFilter
    public boolean merge(BitMapExtractor bitMapExtractor) {
        Objects.requireNonNull(bitMapExtractor, "bitMapExtractor");
        return merge(IndexExtractor.fromBitMapExtractor(bitMapExtractor));
    }

    @Override // org.apache.commons.collections4.bloomfilter.BitMapExtractor
    public boolean processBitMaps(LongPredicate longPredicate) {
        Objects.requireNonNull(longPredicate, "consumer");
        int iNumberOfBitMaps = BitMaps.numberOfBitMaps(this.shape);
        Iterator<Integer> it = this.indices.iterator();
        long longBit = 0;
        int i = 0;
        while (it.hasNext()) {
            int iIntValue = it.next().intValue();
            while (BitMaps.getLongIndex(iIntValue) != i) {
                if (!longPredicate.test(longBit)) {
                    return false;
                }
                i++;
                longBit = 0;
            }
            longBit |= BitMaps.getLongBit(iIntValue);
        }
        if (!longPredicate.test(longBit)) {
            return false;
        }
        for (int i2 = i + 1; i2 < iNumberOfBitMaps; i2++) {
            if (!longPredicate.test(0L)) {
                return false;
            }
        }
        return true;
    }

    @Override // org.apache.commons.collections4.bloomfilter.IndexExtractor, org.apache.commons.collections4.bloomfilter.CellExtractor
    public boolean processIndices(IntPredicate intPredicate) {
        Objects.requireNonNull(intPredicate, "consumer");
        return this.indices.stream().allMatch(new C13758q(intPredicate, 1));
    }

    @Override // org.apache.commons.collections4.bloomfilter.BloomFilter
    public boolean contains(IndexExtractor indexExtractor) {
        TreeSet<Integer> treeSet = this.indices;
        Objects.requireNonNull(treeSet);
        return indexExtractor.processIndices(new C13750i(treeSet, 6));
    }

    @Override // org.apache.commons.collections4.bloomfilter.BloomFilter
    public SparseBloomFilter copy() {
        return new SparseBloomFilter(this);
    }

    @Override // org.apache.commons.collections4.bloomfilter.BloomFilter
    public boolean merge(BloomFilter<?> bloomFilter) {
        Objects.requireNonNull(bloomFilter, "other");
        int iCharacteristics = bloomFilter.characteristics() & 1;
        IndexExtractor indexExtractorFromBitMapExtractor = bloomFilter;
        if (iCharacteristics == 0) {
            indexExtractorFromBitMapExtractor = IndexExtractor.fromBitMapExtractor(bloomFilter);
        }
        merge(indexExtractorFromBitMapExtractor);
        return true;
    }

    private SparseBloomFilter(SparseBloomFilter sparseBloomFilter) {
        this.shape = sparseBloomFilter.shape;
        this.indices = new TreeSet<>((SortedSet) sparseBloomFilter.indices);
    }

    @Override // org.apache.commons.collections4.bloomfilter.BloomFilter
    public boolean merge(Hasher hasher) {
        Objects.requireNonNull(hasher, "hasher");
        merge(hasher.indices(this.shape));
        return true;
    }

    @Override // org.apache.commons.collections4.bloomfilter.BloomFilter
    public boolean merge(IndexExtractor indexExtractor) {
        Objects.requireNonNull(indexExtractor, "indexExtractor");
        indexExtractor.processIndices(new C13750i(this, 5));
        if (!this.indices.isEmpty()) {
            if (this.indices.last().intValue() < this.shape.getNumberOfBits()) {
                if (this.indices.first().intValue() < 0) {
                    throw new IllegalArgumentException(String.format("Value in list %s is less than 0", this.indices.first()));
                }
            } else {
                throw new IllegalArgumentException(String.format("Value in list %s is greater than maximum value (%s)", this.indices.last(), Integer.valueOf(this.shape.getNumberOfBits() - 1)));
            }
        }
        return true;
    }
}
