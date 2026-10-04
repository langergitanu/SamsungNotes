package com.samsung.android.sdk.pen.view.gesture.detector;

import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005J\u0016\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/view/gesture/detector/SpenGestureLowPassFilter;", "", "<init>", "()V", "mCorrectValue", "", "reset", "", "observedValue", "correct", "alpha", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenGestureLowPassFilter {
    private float mCorrectValue = 1.0f;

    public final float correct(float observedValue, float alpha) {
        float f = (alpha * observedValue) + ((1 - alpha) * this.mCorrectValue);
        this.mCorrectValue = f;
        return f;
    }

    public final void reset(float observedValue) {
        this.mCorrectValue = observedValue;
    }
}
