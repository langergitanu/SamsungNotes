package org.apache.commons.collections4.bloomfilter;

import java.util.TreeMap;
import java.util.function.IntPredicate;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@FunctionalInterface
public interface CellExtractor extends IndexExtractor {

    /* JADX INFO: renamed from: org.apache.commons.collections4.bloomfilter.CellExtractor$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class C137351 implements CellExtractor {
        TreeMap<CounterCell, CounterCell> counterCells = new TreeMap<>();
        final /* synthetic */ IndexExtractor val$indexExtractor;

        /* JADX INFO: renamed from: org.apache.commons.collections4.bloomfilter.CellExtractor$1$CounterCell */
        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public final class CounterCell implements Comparable<CounterCell> {
            int count;
            final int idx;

            public CounterCell(int i, int i2) {
                this.idx = i;
                this.count = i2;
            }

            @Override // java.lang.Comparable
            public int compareTo(CounterCell counterCell) {
                return Integer.compare(this.idx, counterCell.idx);
            }
        }

        public C137351(IndexExtractor indexExtractor) {
            this.val$indexExtractor = indexExtractor;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ boolean lambda$populate$1(int i) {
            CounterCell counterCell = new CounterCell(i, 1);
            CounterCell counterCell2 = this.counterCells.get(counterCell);
            if (counterCell2 == null) {
                this.counterCells.put(counterCell, counterCell);
            } else {
                counterCell2.count++;
            }
            return true;
        }

        private void populate() {
            if (this.counterCells.isEmpty()) {
                this.val$indexExtractor.processIndices(new C13750i(this, 0));
            }
        }

        @Override // org.apache.commons.collections4.bloomfilter.IndexExtractor
        public int[] asIndexArray() {
            populate();
            return this.counterCells.keySet().stream().mapToInt(new C13751j()).toArray();
        }

        @Override // org.apache.commons.collections4.bloomfilter.CellExtractor
        public boolean processCells(CellPredicate cellPredicate) {
            populate();
            for (CounterCell counterCell : this.counterCells.values()) {
                if (!cellPredicate.test(counterCell.idx, counterCell.count)) {
                    return false;
                }
            }
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @FunctionalInterface
    public interface CellPredicate {
        boolean test(int i, int i2);
    }

    static CellExtractor from(IndexExtractor indexExtractor) {
        return new C137351(indexExtractor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    static /* synthetic */ boolean lambda$processIndices$0(IntPredicate intPredicate, int i, int i2) {
        return intPredicate.test(i);
    }

    boolean processCells(CellPredicate cellPredicate);

    default boolean processIndices(IntPredicate intPredicate) {
        return processCells(new C13749h(intPredicate));
    }

    @Override // org.apache.commons.collections4.bloomfilter.IndexExtractor
    default IndexExtractor uniqueIndices() {
        return this;
    }
}
