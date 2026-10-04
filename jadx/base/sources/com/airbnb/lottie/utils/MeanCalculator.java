package com.airbnb.lottie.utils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class MeanCalculator {

    /* JADX INFO: renamed from: n */
    private int f1967n;
    private float sum;

    public void add(float f) {
        float f4 = this.sum + f;
        this.sum = f4;
        int i = this.f1967n + 1;
        this.f1967n = i;
        if (i == Integer.MAX_VALUE) {
            this.sum = f4 / 2.0f;
            this.f1967n = i / 2;
        }
    }

    public float getMean() {
        int i = this.f1967n;
        if (i == 0) {
            return 0.0f;
        }
        return this.sum / i;
    }
}
