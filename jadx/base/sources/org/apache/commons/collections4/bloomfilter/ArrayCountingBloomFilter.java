package org.apache.commons.collections4.bloomfilter;

import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.metadata.VMetaDataKey;
import java.util.Arrays;
import java.util.Objects;
import java.util.function.IntPredicate;
import java.util.function.LongPredicate;
import java.util.stream.IntStream;
import org.apache.commons.collections4.bloomfilter.CellExtractor;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class ArrayCountingBloomFilter implements CountingBloomFilter {
    private final int[] cells;
    private final Shape shape;
    private int state;

    private ArrayCountingBloomFilter(ArrayCountingBloomFilter arrayCountingBloomFilter) {
        this.shape = arrayCountingBloomFilter.shape;
        this.state = arrayCountingBloomFilter.state;
        this.cells = (int[]) arrayCountingBloomFilter.cells.clone();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$asIndexArray$0(int i) {
        return this.cells[i] > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$cardinality$1(int i) {
        return this.cells[i] > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$contains$2(int i) {
        return this.cells[i] != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$getMaxInsert$3(int[] iArr, int i, int i2) {
        int i4 = this.cells[i] / i2;
        if (i4 < iArr[0]) {
            iArr[0] = i4;
        }
        return iArr[0] > 0;
    }

    @Override // org.apache.commons.collections4.bloomfilter.CountingBloomFilter
    public boolean add(CellExtractor cellExtractor) {
        Objects.requireNonNull(cellExtractor, "other");
        cellExtractor.processCells(new C13744c(this, 0));
        return isValid();
    }

    @Override // org.apache.commons.collections4.bloomfilter.IndexExtractor
    public int[] asIndexArray() {
        return IntStream.range(0, this.cells.length).filter(new C13743b(this, 1)).toArray();
    }

    @Override // org.apache.commons.collections4.bloomfilter.BloomFilter
    public int cardinality() {
        return (int) IntStream.range(0, this.cells.length).filter(new C13743b(this, 2)).count();
    }

    @Override // org.apache.commons.collections4.bloomfilter.BloomFilter
    public int characteristics() {
        return 1;
    }

    @Override // org.apache.commons.collections4.bloomfilter.BloomFilter
    public void clear() {
        Arrays.fill(this.cells, 0);
    }

    @Override // org.apache.commons.collections4.bloomfilter.BloomFilter
    public boolean contains(BitMapExtractor bitMapExtractor) {
        return contains(IndexExtractor.fromBitMapExtractor(bitMapExtractor));
    }

    @Override // org.apache.commons.collections4.bloomfilter.CountingBloomFilter
    public int getMaxCell() {
        return Integer.MAX_VALUE;
    }

    @Override // org.apache.commons.collections4.bloomfilter.CountingBloomFilter
    public int getMaxInsert(CellExtractor cellExtractor) {
        int[] iArr = {Integer.MAX_VALUE};
        cellExtractor.processCells(new C13742a(this, iArr, 0));
        return iArr[0];
    }

    @Override // org.apache.commons.collections4.bloomfilter.BloomFilter
    public Shape getShape() {
        return this.shape;
    }

    @Override // org.apache.commons.collections4.bloomfilter.CountingBloomFilter
    public boolean isValid() {
        return this.state >= 0;
    }

    @Override // org.apache.commons.collections4.bloomfilter.BitMapExtractor
    public boolean processBitMaps(LongPredicate longPredicate) {
        Objects.requireNonNull(longPredicate, "consumer");
        int iNumberOfBitMaps = BitMaps.numberOfBitMaps(this.cells.length) - 1;
        int i = 0;
        int i2 = 0;
        int i4 = 0;
        while (true) {
            long longBit = 0;
            if (i2 < iNumberOfBitMaps) {
                int i5 = 0;
                while (i5 < 64) {
                    int i6 = i4 + 1;
                    if (this.cells[i4] != 0) {
                        longBit |= BitMaps.getLongBit(i5);
                    }
                    i5++;
                    i4 = i6;
                }
                if (!longPredicate.test(longBit)) {
                    return false;
                }
                i2++;
            } else {
                while (true) {
                    int[] iArr = this.cells;
                    if (i4 >= iArr.length) {
                        return longPredicate.test(longBit);
                    }
                    int i7 = i4 + 1;
                    if (iArr[i4] != 0) {
                        longBit |= BitMaps.getLongBit(i);
                    }
                    i++;
                    i4 = i7;
                }
            }
        }
    }

    @Override // org.apache.commons.collections4.bloomfilter.CellExtractor
    public boolean processCells(CellExtractor.CellPredicate cellPredicate) {
        Objects.requireNonNull(cellPredicate, "consumer");
        int i = 0;
        while (true) {
            int[] iArr = this.cells;
            if (i >= iArr.length) {
                return true;
            }
            int i2 = iArr[i];
            if (i2 != 0 && !cellPredicate.test(i, i2)) {
                return false;
            }
            i++;
        }
    }

    @Override // org.apache.commons.collections4.bloomfilter.IndexExtractor, org.apache.commons.collections4.bloomfilter.CellExtractor
    public boolean processIndices(IntPredicate intPredicate) {
        Objects.requireNonNull(intPredicate, "consumer");
        int i = 0;
        while (true) {
            int[] iArr = this.cells;
            if (i >= iArr.length) {
                return true;
            }
            if (iArr[i] != 0 && !intPredicate.test(i)) {
                return false;
            }
            i++;
        }
    }

    @Override // org.apache.commons.collections4.bloomfilter.CountingBloomFilter
    public boolean subtract(CellExtractor cellExtractor) {
        Objects.requireNonNull(cellExtractor, "other");
        cellExtractor.processCells(new C13744c(this, 1));
        return isValid();
    }

    @Override // org.apache.commons.collections4.bloomfilter.BloomFilter
    public boolean contains(IndexExtractor indexExtractor) {
        return indexExtractor.processIndices(new C13743b(this, 0));
    }

    @Override // org.apache.commons.collections4.bloomfilter.BloomFilter
    public ArrayCountingBloomFilter copy() {
        return new ArrayCountingBloomFilter(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean add(int i, int i2) {
        try {
            int[] iArr = this.cells;
            int i4 = iArr[i] + i2;
            this.state |= i4;
            iArr[i] = i4;
            return true;
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalArgumentException(String.format("Filter only accepts values in the [0,%d) range", Integer.valueOf(getShape().getNumberOfBits())), e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean subtract(int i, int i2) {
        try {
            int[] iArr = this.cells;
            int i4 = iArr[i] - i2;
            this.state |= i4;
            iArr[i] = i4;
            return true;
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalArgumentException(String.format("Filter only accepts values in the [0,%d) range", Integer.valueOf(getShape().getNumberOfBits())), e);
        }
    }

    public ArrayCountingBloomFilter(Shape shape) {
        Objects.requireNonNull(shape, VMetaDataKey.META_KEY_SHAPE);
        this.shape = shape;
        this.cells = new int[shape.getNumberOfBits()];
    }
}
