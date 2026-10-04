package com.vladsch.flexmark.util.misc;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class MinMaxAvgInt {
    private int min = Integer.MAX_VALUE;
    private int max = Integer.MIN_VALUE;
    private int total = 0;

    public void add(int i) {
        this.total += i;
        this.min = Math.min(this.min, i);
        this.max = Math.max(this.max, i);
    }

    public void diff(int i, int i2) {
        add(i2 - i);
    }

    public int getAvg(int i) {
        if (i == 0) {
            return 0;
        }
        return this.total / i;
    }

    public int getMax() {
        return this.max;
    }

    public int getMin() {
        return this.min;
    }

    public int getTotal() {
        return this.total;
    }

    public void add(MinMaxAvgInt minMaxAvgInt) {
        this.total += minMaxAvgInt.total;
        this.min = Math.min(this.min, minMaxAvgInt.min);
        this.max = Math.max(this.max, minMaxAvgInt.max);
    }
}
