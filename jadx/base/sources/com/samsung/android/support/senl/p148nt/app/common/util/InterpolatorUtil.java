package com.samsung.android.support.senl.p148nt.app.common.util;

import android.view.animation.Interpolator;
import com.samsung.android.spr.drawable.animation.interpolator.SineInOut33;
import com.samsung.android.spr.drawable.animation.interpolator.SineInOut60;
import com.samsung.android.spr.drawable.animation.interpolator.SineInOut70;
import com.samsung.android.spr.drawable.animation.interpolator.SineInOut80;
import com.samsung.android.spr.drawable.animation.interpolator.SineInOut90;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class InterpolatorUtil {
    private static Interpolator mSineInOut33;
    private static Interpolator mSineInOut60;
    private static Interpolator mSineInOut70;
    private static Interpolator mSineInOut80;
    private static Interpolator mSineInOut90;

    public static Interpolator getSineInOut33() {
        if (mSineInOut33 == null) {
            mSineInOut33 = new SineInOut33();
        }
        return mSineInOut33;
    }

    public static Interpolator getSineInOut60() {
        if (mSineInOut60 == null) {
            mSineInOut60 = new SineInOut60();
        }
        return mSineInOut60;
    }

    public static Interpolator getSineInOut70() {
        if (mSineInOut70 == null) {
            mSineInOut70 = new SineInOut70();
        }
        return mSineInOut70;
    }

    public static Interpolator getSineInOut80() {
        if (mSineInOut80 == null) {
            mSineInOut80 = new SineInOut80();
        }
        return mSineInOut80;
    }

    public static Interpolator getSineInOut90() {
        if (mSineInOut90 == null) {
            mSineInOut90 = new SineInOut90();
        }
        return mSineInOut90;
    }
}
