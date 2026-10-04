package com.samsung.android.spr.drawable.animation.interpolator;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.Interpolator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class QuintEaseIn implements Interpolator {
    public QuintEaseIn() {
    }

    /* JADX INFO: renamed from: in */
    private float m7085in(float f) {
        return f * f * f * f * f;
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        return m7085in(f);
    }

    public QuintEaseIn(Context context, AttributeSet attributeSet) {
    }
}
