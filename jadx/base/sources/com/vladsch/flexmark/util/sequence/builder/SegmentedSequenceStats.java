package com.vladsch.flexmark.util.sequence.builder;

import androidx.compose.foundation.layout.AbstractC1038a;
import com.samsung.android.support.senl.p148nt.model.collector.common.C11419a;
import com.vladsch.flexmark.util.misc.MinMaxAvgLong;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import p005A3.C0016a;
import p074R1.C0233e;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class SegmentedSequenceStats {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final ArrayList<Integer> AGGR_STEPS;
    static final int MAX_BUCKETS;
    private ArrayList<StatsEntry> aggregatedStats;
    private final HashMap<StatsEntry, StatsEntry> stats = new HashMap<>();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class StatsEntry implements Comparable<StatsEntry> {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        int count;
        int segments;
        final MinMaxAvgLong segStats = new MinMaxAvgLong();
        final MinMaxAvgLong length = new MinMaxAvgLong();
        final MinMaxAvgLong overhead = new MinMaxAvgLong();

        public StatsEntry(int i) {
            this.segments = i;
        }

        public void add(int i, int i2, int i4) {
            this.count++;
            this.segStats.add(i);
            this.length.add(i2);
            this.overhead.add(i4);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.segments == ((StatsEntry) obj).segments;
        }

        public int hashCode() {
            return this.segments;
        }

        @Override // java.lang.Comparable
        public int compareTo(@NotNull StatsEntry statsEntry) {
            int iCompare = Integer.compare(this.segments, statsEntry.segments);
            return iCompare != 0 ? iCompare : Integer.compare(this.count, statsEntry.count);
        }

        public void add(@NotNull StatsEntry statsEntry) {
            this.count += statsEntry.count;
            this.segStats.add(statsEntry.segStats);
            this.length.add(statsEntry.length);
            this.overhead.add(statsEntry.overhead);
        }
    }

    static {
        ArrayList<Integer> arrayList = new ArrayList<>();
        AGGR_STEPS = arrayList;
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);
        arrayList.add(6);
        arrayList.add(7);
        arrayList.add(8);
        arrayList.add(15);
        arrayList.add(16);
        arrayList.add(256);
        for (int iM1200a = 65536; iM1200a < 1048576; iM1200a = AbstractC1038a.m1200a(iM1200a, iM1200a, 65536, AGGR_STEPS)) {
        }
        MAX_BUCKETS = AGGR_STEPS.size();
    }

    private SegmentedSequenceStats() {
    }

    @NotNull
    public static SegmentedSequenceStats getInstance() {
        return new SegmentedSequenceStats();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ StatsEntry lambda$addStats$0(StatsEntry statsEntry) {
        return statsEntry;
    }

    public void addStats(int i, int i2, int i4) {
        this.stats.computeIfAbsent(new StatsEntry(i), new C11419a(16)).add(i, i2, i4);
    }

    public void clear() {
        this.stats.clear();
    }

    @NotNull
    public List<StatsEntry> getAggregatedStats() {
        if (this.aggregatedStats == null) {
            List<StatsEntry> stats = getStats();
            int i = MAX_BUCKETS;
            this.aggregatedStats = new ArrayList<>(i);
            int i2 = i - 1;
            int iIntValue = AGGR_STEPS.get(i2).intValue();
            int size = stats.size();
            for (int i4 = 0; i4 < MAX_BUCKETS; i4++) {
                this.aggregatedStats.add(null);
            }
            while (true) {
                int i5 = size - 1;
                if (size <= 0) {
                    break;
                }
                StatsEntry statsEntry = stats.get(i5);
                if (statsEntry.segments < iIntValue) {
                    while (i2 > 0) {
                        i2--;
                        iIntValue = AGGR_STEPS.get(i2).intValue();
                        if (statsEntry.segments >= iIntValue) {
                            break;
                        }
                    }
                }
                StatsEntry statsEntry2 = this.aggregatedStats.get(i2);
                if (statsEntry2 == null) {
                    statsEntry2 = new StatsEntry(iIntValue);
                    this.aggregatedStats.set(i2, statsEntry2);
                }
                statsEntry2.add(statsEntry);
                size = i5;
            }
            this.aggregatedStats.removeIf(new C0233e(9));
        }
        return this.aggregatedStats;
    }

    @NotNull
    public String getAggregatedStatsText() {
        return getStatsText(getAggregatedStats());
    }

    public int getCount(int i) {
        StatsEntry statsEntry = new StatsEntry(i);
        if (this.stats.containsKey(statsEntry)) {
            return this.stats.get(statsEntry).count;
        }
        return 0;
    }

    @NotNull
    public List<StatsEntry> getStats() {
        ArrayList arrayList = new ArrayList(this.stats.keySet());
        arrayList.sort(new C0016a(17));
        return arrayList;
    }

    @NotNull
    public String getStatsText(List<StatsEntry> list) {
        Long l;
        Integer num;
        int i;
        double total;
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        sb.append(String.format("%10s,%10s,%10s,%10s,%10s,%10s,%10s,%10s,%10s,%10s,%10s,%10s,%10s,%8s", "count", "min-seg", "avg-seg", "max-seg", "min-len", "avg-len", "max-len", "min-ovr", "avg-ovr", "max-ovr", "tot-len", "tot-chr", "tot-ovr", "ovr %"));
        sb.append("\n");
        while (true) {
            int i2 = size - 1;
            if (size <= 0) {
                return sb.toString();
            }
            StatsEntry statsEntry = list.get(i2);
            Integer numValueOf = Integer.valueOf(statsEntry.count);
            Long lValueOf = Long.valueOf(statsEntry.count == 1 ? statsEntry.segments : statsEntry.segStats.getMin());
            int i4 = statsEntry.count;
            Long lValueOf2 = Long.valueOf(i4 == 1 ? statsEntry.segments : statsEntry.segStats.getAvg(i4));
            Long lValueOf3 = Long.valueOf(statsEntry.count == 1 ? statsEntry.segments : statsEntry.segStats.getMax());
            Long lValueOf4 = Long.valueOf(statsEntry.length.getMin());
            Long lValueOf5 = Long.valueOf(statsEntry.length.getAvg(statsEntry.count));
            Long lValueOf6 = Long.valueOf(statsEntry.length.getMax());
            Long lValueOf7 = Long.valueOf(statsEntry.overhead.getMin());
            Long lValueOf8 = Long.valueOf(statsEntry.overhead.getAvg(statsEntry.count));
            Long lValueOf9 = Long.valueOf(statsEntry.overhead.getMax());
            Long lValueOf10 = Long.valueOf(statsEntry.length.getTotal());
            Long lValueOf11 = Long.valueOf(statsEntry.length.getTotal() * 2);
            Long lValueOf12 = Long.valueOf(statsEntry.overhead.getTotal());
            if (statsEntry.length.getTotal() == 0) {
                i = i2;
                total = 0.0d;
                l = lValueOf;
                num = numValueOf;
            } else {
                l = lValueOf;
                num = numValueOf;
                i = i2;
                total = ((statsEntry.overhead.getTotal() * 100.0d) / statsEntry.length.getTotal()) / 2.0d;
            }
            sb.append(String.format("%10d,%10d,%10d,%10d,%10d,%10d,%10d,%10d,%10d,%10d,%10d,%10d,%10d,%8.3f", num, l, lValueOf2, lValueOf3, lValueOf4, lValueOf5, lValueOf6, lValueOf7, lValueOf8, lValueOf9, lValueOf10, lValueOf11, lValueOf12, Double.valueOf(total)));
            sb.append("\n");
            size = i;
        }
    }

    @NotNull
    public String getStatsText() {
        return getStatsText(getStats());
    }
}
