package com.google.android.material.carousel;

import androidx.annotation.NonNull;
import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.core.math.MathUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class Arrangement {
    private static final float MEDIUM_ITEM_FLEX_PERCENTAGE = 0.1f;
    final float cost;
    final int largeCount;
    float largeSize;
    int mediumCount;
    float mediumSize;
    final int priority;
    int smallCount;
    float smallSize;

    public Arrangement(int i, float f, float f4, float f5, int i2, float f6, int i4, float f7, int i5, float f8) {
        this.priority = i;
        this.smallSize = MathUtils.clamp(f, f4, f5);
        this.smallCount = i2;
        this.mediumSize = f6;
        this.mediumCount = i4;
        this.largeSize = f7;
        this.largeCount = i5;
        fit(f8, f4, f5, f7);
        this.cost = cost(f7);
    }

    private float calculateLargeSize(float f, int i, float f4, int i2, int i4) {
        if (i <= 0) {
            f4 = 0.0f;
        }
        float f5 = i2 / 2.0f;
        return (f - ((i + f5) * f4)) / (i4 + f5);
    }

    private float cost(float f) {
        if (isValid()) {
            return Math.abs(f - this.largeSize) * this.priority;
        }
        return Float.MAX_VALUE;
    }

    public static Arrangement findLowestCostArrangement(float f, float f4, float f5, float f6, int[] iArr, float f7, int[] iArr2, float f8, int[] iArr3) {
        Arrangement arrangement = null;
        int i = 1;
        for (int i2 : iArr3) {
            int length = iArr2.length;
            int i4 = 0;
            while (i4 < length) {
                int i5 = iArr2[i4];
                int length2 = iArr.length;
                int i6 = 0;
                while (i6 < length2) {
                    int i7 = length;
                    int i8 = i4;
                    int i9 = i;
                    int i10 = length2;
                    int i11 = i6;
                    Arrangement arrangement2 = new Arrangement(i9, f4, f5, f6, iArr[i6], f7, i5, f8, i2, f);
                    if (arrangement == null || arrangement2.cost < arrangement.cost) {
                        if (arrangement2.cost == 0.0f) {
                            return arrangement2;
                        }
                        arrangement = arrangement2;
                    }
                    int i12 = i9 + 1;
                    i6 = i11 + 1;
                    i4 = i8;
                    i = i12;
                    length = i7;
                    length2 = i10;
                }
                i4++;
                i = i;
                length = length;
            }
        }
        return arrangement;
    }

    private void fit(float f, float f4, float f5, float f6) {
        float space = f - getSpace();
        int i = this.smallCount;
        if (i > 0 && space > 0.0f) {
            float f7 = this.smallSize;
            this.smallSize = Math.min(space / i, f5 - f7) + f7;
        } else if (i > 0 && space < 0.0f) {
            float f8 = this.smallSize;
            this.smallSize = Math.max(space / i, f4 - f8) + f8;
        }
        int i2 = this.smallCount;
        float f9 = i2 > 0 ? this.smallSize : 0.0f;
        this.smallSize = f9;
        float fCalculateLargeSize = calculateLargeSize(f, i2, f9, this.mediumCount, this.largeCount);
        this.largeSize = fCalculateLargeSize;
        float f10 = (this.smallSize + fCalculateLargeSize) / 2.0f;
        this.mediumSize = f10;
        int i4 = this.mediumCount;
        if (i4 <= 0 || fCalculateLargeSize == f6) {
            return;
        }
        float f11 = (f6 - fCalculateLargeSize) * this.largeCount;
        float fMin = Math.min(Math.abs(f11), f10 * 0.1f * i4);
        if (f11 > 0.0f) {
            this.mediumSize -= fMin / this.mediumCount;
            this.largeSize = (fMin / this.largeCount) + this.largeSize;
        } else {
            this.mediumSize = (fMin / this.mediumCount) + this.mediumSize;
            this.largeSize -= fMin / this.largeCount;
        }
    }

    private float getSpace() {
        return (this.smallSize * this.smallCount) + (this.mediumSize * this.mediumCount) + (this.largeSize * this.largeCount);
    }

    private boolean isValid() {
        int i = this.largeCount;
        if (i <= 0 || this.smallCount <= 0 || this.mediumCount <= 0) {
            return i <= 0 || this.smallCount <= 0 || this.largeSize > this.smallSize;
        }
        float f = this.largeSize;
        float f4 = this.mediumSize;
        return f > f4 && f4 > this.smallSize;
    }

    public int getItemCount() {
        return this.smallCount + this.mediumCount + this.largeCount;
    }

    @NonNull
    public String toString() {
        StringBuilder sb = new StringBuilder("Arrangement [priority=");
        sb.append(this.priority);
        sb.append(", smallCount=");
        sb.append(this.smallCount);
        sb.append(", smallSize=");
        sb.append(this.smallSize);
        sb.append(", mediumCount=");
        sb.append(this.mediumCount);
        sb.append(", mediumSize=");
        sb.append(this.mediumSize);
        sb.append(", largeCount=");
        sb.append(this.largeCount);
        sb.append(", largeSize=");
        sb.append(this.largeSize);
        sb.append(", cost=");
        return AbstractC1038a.m1217r(sb, "]", this.cost);
    }
}
