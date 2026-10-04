package com.google.android.material.tabs;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
abstract class SeslAbsIndicatorView extends View {
    public SeslAbsIndicatorView(Context context) {
        super(context);
    }

    public abstract void onHide();

    public abstract void onSetSelectedIndicatorColor(int i);

    public abstract void onShow();

    public void setHide() {
        onHide();
    }

    public void setPressed() {
        startPressEffect();
    }

    public void setReleased() {
        startReleaseEffect();
    }

    public void setSelectedIndicatorColor(int i) {
        onSetSelectedIndicatorColor(i);
    }

    public void setShow() {
        onShow();
    }

    public abstract void startPressEffect();

    public abstract void startReleaseEffect();

    public SeslAbsIndicatorView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SeslAbsIndicatorView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public SeslAbsIndicatorView(Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }
}
