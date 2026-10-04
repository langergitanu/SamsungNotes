package com.samsung.android.spr.drawable.animation.interpolator;

import android.animation.TimeInterpolator;
import java.util.Hashtable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class SprTimeInterpolatorFactory {
    private static Hashtable<Integer, SprTimeInterpolator> mTable;

    public static TimeInterpolator get(int i, int i2, int i4, int i5) {
        if (mTable == null) {
            mTable = new Hashtable<>();
        }
        int i6 = i2 - i5;
        SprTimeInterpolator sprTimeInterpolator = mTable.get(Integer.valueOf(i6));
        if (sprTimeInterpolator != null) {
            return sprTimeInterpolator;
        }
        SprTimeInterpolator sprTimeInterpolator2 = new SprTimeInterpolator(i2, i4, i5);
        mTable.put(Integer.valueOf(i6), sprTimeInterpolator2);
        return sprTimeInterpolator2;
    }
}
