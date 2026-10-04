package com.vladsch.flexmark.util.misc;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class MinMaxAvgFloat {
    private float min = Float.MAX_VALUE;
    private float max = Float.MIN_VALUE;
    private float total = 0.0f;

    public void add(float f) {
        this.total += f;
        this.min = Math.min(this.min, f);
        this.max = Math.max(this.max, f);
    }

    public void diff(float f, float f4) {
        add(f4 - f);
    }

    public float getAvg(float f) {
        if (f == 0.0f) {
            return 0.0f;
        }
        return this.total / f;
    }

    public float getMax() {
        return this.max;
    }

    public float getMin() {
        return this.min;
    }

    public float getTotal() {
        return this.total;
    }

    public void add(MinMaxAvgFloat minMaxAvgFloat) {
        this.total += minMaxAvgFloat.total;
        this.min = Math.min(this.min, minMaxAvgFloat.min);
        this.max = Math.max(this.max, minMaxAvgFloat.max);
    }
}
