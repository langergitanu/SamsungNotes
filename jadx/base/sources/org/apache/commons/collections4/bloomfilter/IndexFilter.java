package org.apache.commons.collections4.bloomfilter;

import java.util.function.IntPredicate;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class IndexFilter {
    private final IntPredicate consumer;
    private final int size;
    private final IntPredicate tracker;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ArrayTracker implements IntPredicate {
        private int populated;
        private final int[] seen;

        public ArrayTracker(Shape shape) {
            this.seen = new int[shape.getNumberOfHashFunctions()];
        }

        @Override // java.util.function.IntPredicate
        public boolean test(int i) {
            if (i < 0) {
                throw new IndexOutOfBoundsException(AbstractC0000a.m11h(i, "number may not be less than zero. "));
            }
            int i2 = 0;
            while (true) {
                int i4 = this.populated;
                if (i2 >= i4) {
                    int[] iArr = this.seen;
                    this.populated = i4 + 1;
                    iArr[i4] = i;
                    return true;
                }
                if (this.seen[i2] == i) {
                    return false;
                }
                i2++;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class BitMapTracker implements IntPredicate {
        private final long[] bits;

        public BitMapTracker(Shape shape) {
            this.bits = BitMaps.newBitMap(shape);
        }

        @Override // java.util.function.IntPredicate
        public boolean test(int i) {
            boolean z = !BitMaps.contains(this.bits, i);
            BitMaps.set(this.bits, i);
            return z;
        }
    }

    private IndexFilter(Shape shape, IntPredicate intPredicate) {
        this.size = shape.getNumberOfBits();
        this.consumer = intPredicate;
        if (BitMaps.numberOfBitMaps(shape) * 8 < ((long) shape.getNumberOfHashFunctions()) * 4) {
            this.tracker = new BitMapTracker(shape);
        } else {
            this.tracker = new ArrayTracker(shape);
        }
    }

    public static IntPredicate create(Shape shape, IntPredicate intPredicate) {
        return new C13750i(new IndexFilter(shape, intPredicate), 4);
    }

    public boolean test(int i) {
        if (i >= this.size) {
            throw new IndexOutOfBoundsException(String.format("number too large %d >= %d", Integer.valueOf(i), Integer.valueOf(this.size)));
        }
        if (this.tracker.test(i)) {
            return this.consumer.test(i);
        }
        return true;
    }
}
