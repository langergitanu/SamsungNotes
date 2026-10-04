package org.apache.commons.collections4.bloomfilter;

import java.util.Arrays;
import java.util.BitSet;
import java.util.Objects;
import java.util.function.IntPredicate;
import java.util.function.LongPredicate;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@FunctionalInterface
public interface IndexExtractor {

    /* JADX INFO: renamed from: org.apache.commons.collections4.bloomfilter.IndexExtractor$1Indices, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public final class C1Indices {
        private int[] data = new int[32];
        private int size;

        public C1Indices() {
        }

        public boolean add(int i) {
            int[] iArrEnsureCapacityForAdd = IndexUtils.ensureCapacityForAdd(this.data, this.size);
            this.data = iArrEnsureCapacityForAdd;
            int i2 = this.size;
            this.size = i2 + 1;
            iArrEnsureCapacityForAdd[i2] = i;
            return true;
        }

        public int[] toArray() {
            int i = this.size;
            int[] iArr = this.data;
            return i == iArr.length ? iArr : Arrays.copyOf(iArr, i);
        }
    }

    static IndexExtractor fromBitMapExtractor(BitMapExtractor bitMapExtractor) {
        Objects.requireNonNull(bitMapExtractor, "bitMapExtractor");
        return new C13749h(bitMapExtractor);
    }

    static IndexExtractor fromIndexArray(final int... iArr) {
        return new IndexExtractor() { // from class: org.apache.commons.collections4.bloomfilter.IndexExtractor.2
            @Override // org.apache.commons.collections4.bloomfilter.IndexExtractor
            public int[] asIndexArray() {
                return (int[]) iArr.clone();
            }

            @Override // org.apache.commons.collections4.bloomfilter.IndexExtractor, org.apache.commons.collections4.bloomfilter.CellExtractor
            public boolean processIndices(IntPredicate intPredicate) {
                for (int i : iArr) {
                    if (!intPredicate.test(i)) {
                        return false;
                    }
                }
                return true;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    static /* synthetic */ boolean lambda$fromBitMapExtractor$0(BitMapExtractor bitMapExtractor, final IntPredicate intPredicate) {
        return bitMapExtractor.processBitMaps(new C13745d(new LongPredicate() { // from class: org.apache.commons.collections4.bloomfilter.IndexExtractor.1
            int wordIdx;

            @Override // java.util.function.LongPredicate
            public boolean test(long j) {
                int i = this.wordIdx;
                while (j != 0) {
                    if ((j & 1) == 1 && !intPredicate.test(i)) {
                        return false;
                    }
                    j >>>= 1;
                    i++;
                }
                this.wordIdx += 64;
                return true;
            }
        }, 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    static /* synthetic */ boolean lambda$uniqueIndices$1(BitSet bitSet, int i) {
        bitSet.set(i);
        return true;
    }

    default int[] asIndexArray() {
        C1Indices c1Indices = new C1Indices();
        processIndices(new C13750i(c1Indices, 1));
        return c1Indices.toArray();
    }

    boolean processIndices(IntPredicate intPredicate);

    default IndexExtractor uniqueIndices() {
        final BitSet bitSet = new BitSet();
        processIndices(new C13750i(bitSet, 3));
        return new IndexExtractor(this) { // from class: org.apache.commons.collections4.bloomfilter.IndexExtractor.3
            final /* synthetic */ IndexExtractor this$0;

            {
                this.this$0 = this;
            }

            @Override // org.apache.commons.collections4.bloomfilter.IndexExtractor, org.apache.commons.collections4.bloomfilter.CellExtractor
            public boolean processIndices(IntPredicate intPredicate) {
                int iNextSetBit = bitSet.nextSetBit(0);
                while (iNextSetBit >= 0) {
                    if (!intPredicate.test(iNextSetBit)) {
                        return false;
                    }
                    iNextSetBit = bitSet.nextSetBit(iNextSetBit + 1);
                }
                return true;
            }

            @Override // org.apache.commons.collections4.bloomfilter.IndexExtractor
            public IndexExtractor uniqueIndices() {
                return this;
            }
        };
    }
}
