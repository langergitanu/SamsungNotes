package com.vladsch.flexmark.util.misc;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class MinMaxAvgLong {
    private long min = Long.MAX_VALUE;
    private long max = Long.MIN_VALUE;
    private long total = 0;

    public void add(long j) {
        this.total += j;
        this.min = Math.min(this.min, j);
        this.max = Math.max(this.max, j);
    }

    public void diff(long j, long j2) {
        add(j2 - j);
    }

    public long getAvg(long j) {
        if (j == 0) {
            return 0L;
        }
        return this.total / j;
    }

    public long getMax() {
        return this.max;
    }

    public long getMin() {
        return this.min;
    }

    public long getTotal() {
        return this.total;
    }

    public void add(MinMaxAvgLong minMaxAvgLong) {
        this.total += minMaxAvgLong.total;
        this.min = Math.min(this.min, minMaxAvgLong.min);
        this.max = Math.max(this.max, minMaxAvgLong.max);
    }
}
