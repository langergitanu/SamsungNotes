package com.samsung.android.spr.drawable.animation.interpolator;

import android.animation.TimeInterpolator;
import java.util.TimeZone;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class SprTimeInterpolator implements TimeInterpolator {
    static final int DAY_MILLISECONDS = 86400000;
    public static final int DAY_TYPE = 1;
    static final int WEEK_MILLISECONDS = 604800000;
    public static final int WEEK_TYPE = 2;
    private int mDuration;
    private int mPeriodType;
    private int mQuotient;

    public SprTimeInterpolator() {
        this.mDuration = 0;
        this.mPeriodType = 0;
        this.mQuotient = 1;
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        long offset = jCurrentTimeMillis + ((long) TimeZone.getDefault().getOffset(jCurrentTimeMillis));
        long j = this.mPeriodType == 1 ? offset % 86400000 : (offset - 259200000) % 604800000;
        int i = this.mDuration;
        long j2 = j % ((long) i);
        int i2 = this.mQuotient;
        if (i2 > 1) {
            j2 = (j2 / ((long) i2)) * ((long) i2);
        }
        return j2 / i;
    }

    public void setDuration(int i) {
        this.mDuration = i;
    }

    public void setPeriodType(int i) {
        this.mPeriodType = i;
    }

    public void setQuotient(int i) {
        this.mQuotient = i;
    }

    public SprTimeInterpolator(int i, int i2, int i4) {
        this.mDuration = i;
        this.mPeriodType = i2;
        this.mQuotient = i4;
    }
}
