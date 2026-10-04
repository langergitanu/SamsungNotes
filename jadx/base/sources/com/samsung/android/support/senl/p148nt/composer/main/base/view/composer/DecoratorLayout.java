package com.samsung.android.support.senl.p148nt.composer.main.base.view.composer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.widget.RelativeLayout;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class DecoratorLayout extends RelativeLayout {
    private OnMousePointerListener mOnMousePointerListener;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface OnMousePointerListener {
        void onMousePointer(MotionEvent motionEvent);
    }

    public DecoratorLayout(Context context) {
        super(context);
    }

    private void notifyMousePointer(MotionEvent motionEvent) {
        OnMousePointerListener onMousePointerListener;
        if (motionEvent.getToolType(0) == 3 && (onMousePointerListener = this.mOnMousePointerListener) != null) {
            onMousePointerListener.onMousePointer(motionEvent);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public PointerIcon onResolvePointerIcon(MotionEvent motionEvent, int i) {
        notifyMousePointer(motionEvent);
        return super.onResolvePointerIcon(motionEvent, i);
    }

    public void setOnMousePointerListener(OnMousePointerListener onMousePointerListener) {
        this.mOnMousePointerListener = onMousePointerListener;
    }

    public DecoratorLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public DecoratorLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public DecoratorLayout(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }
}
