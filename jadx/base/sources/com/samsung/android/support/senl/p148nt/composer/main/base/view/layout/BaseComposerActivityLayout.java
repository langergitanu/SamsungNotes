package com.samsung.android.support.senl.p148nt.composer.main.base.view.layout;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class BaseComposerActivityLayout extends FrameLayout {
    private static final boolean IS_AVAILABLE_OS;
    private final int[] mBaseLocation;
    private int mLastTouchEventToolType;
    private OnDispatchKeyEvent mOnDispatchKeyEvent;
    private OnDispatchKeyEventPreImeInterceptor mOnDispatchKeyEventPreImeInterceptor;
    private final int[] mTargetLocation;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface OnDispatchKeyEvent {
        boolean dispatchKeyEvent(KeyEvent keyEvent);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface OnDispatchKeyEventPreImeInterceptor {
        boolean dispatchKeyEventPreIme(KeyEvent keyEvent);
    }

    static {
        IS_AVAILABLE_OS = Build.VERSION.SDK_INT <= 27;
    }

    public BaseComposerActivityLayout(Context context) {
        super(context);
        this.mBaseLocation = new int[2];
        this.mTargetLocation = new int[2];
    }

    private boolean contains(View view, int i, int i2) {
        int i4;
        view.getLocationOnScreen(this.mTargetLocation);
        int i5 = this.mTargetLocation[0];
        return i5 <= i && i <= view.getWidth() + i5 && (i4 = this.mTargetLocation[1]) <= i2 && i2 <= view.getHeight() + i4;
    }

    private boolean isShown(View view) {
        return (view == null || view.getVisibility() != 0 || view.getAlpha() == 0.0f) ? false : true;
    }

    private View resolveTargetView(View view, int i, int i2) {
        if (!(view instanceof ViewGroup)) {
            if (isShown(view) && contains(view, i, i2)) {
                return view;
            }
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        if (!contains(view, i, i2)) {
            return null;
        }
        if (viewGroup.getVisibility() == 0) {
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View viewResolveTargetView = resolveTargetView(viewGroup.getChildAt(childCount), i, i2);
                if (viewResolveTargetView != null && viewResolveTargetView.getVisibility() == 0) {
                    return viewResolveTargetView;
                }
            }
        }
        Drawable background = viewGroup.getBackground();
        if (viewGroup.getVisibility() != 0 || viewGroup.getAlpha() == 0.0f || background == null || background.getAlpha() == 0) {
            return null;
        }
        return view;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        OnDispatchKeyEvent onDispatchKeyEvent = this.mOnDispatchKeyEvent;
        if (onDispatchKeyEvent == null || !onDispatchKeyEvent.dispatchKeyEvent(keyEvent)) {
            return super.dispatchKeyEvent(keyEvent);
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEventPreIme(KeyEvent keyEvent) {
        OnDispatchKeyEvent onDispatchKeyEvent = this.mOnDispatchKeyEvent;
        if (onDispatchKeyEvent != null && onDispatchKeyEvent.dispatchKeyEvent(keyEvent)) {
            return true;
        }
        OnDispatchKeyEventPreImeInterceptor onDispatchKeyEventPreImeInterceptor = this.mOnDispatchKeyEventPreImeInterceptor;
        if (onDispatchKeyEventPreImeInterceptor == null || !onDispatchKeyEventPreImeInterceptor.dispatchKeyEventPreIme(keyEvent)) {
            return super.dispatchKeyEventPreIme(keyEvent);
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        OnDispatchKeyEvent onDispatchKeyEvent = this.mOnDispatchKeyEvent;
        if (onDispatchKeyEvent == null || !onDispatchKeyEvent.dispatchKeyEvent(keyEvent)) {
            return super.dispatchKeyShortcutEvent(keyEvent);
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.mLastTouchEventToolType = motionEvent.getToolType(0);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public int getLastTouchEventToolType() {
        return this.mLastTouchEventToolType;
    }

    @Override // android.view.ViewGroup, android.view.View
    public PointerIcon onResolvePointerIcon(MotionEvent motionEvent, int i) {
        if (!IS_AVAILABLE_OS) {
            return super.onResolvePointerIcon(motionEvent, i);
        }
        PointerIcon pointerIconOnResolvePointerIcon = super.onResolvePointerIcon(motionEvent, i);
        if (pointerIconOnResolvePointerIcon == null) {
            getLocationOnScreen(this.mBaseLocation);
            View viewResolveTargetView = resolveTargetView(this, ((int) motionEvent.getX(i)) + this.mBaseLocation[0], ((int) motionEvent.getY(i)) + this.mBaseLocation[1]);
            if (viewResolveTargetView != null) {
                viewResolveTargetView.getLocationOnScreen(this.mTargetLocation);
                int i2 = this.mBaseLocation[0];
                int[] iArr = this.mTargetLocation;
                motionEvent.offsetLocation(i2 - iArr[0], r0[1] - iArr[1]);
                return viewResolveTargetView.onResolvePointerIcon(motionEvent, i);
            }
        }
        return pointerIconOnResolvePointerIcon;
    }

    public void setDispatchKeyEvent(OnDispatchKeyEvent onDispatchKeyEvent) {
        this.mOnDispatchKeyEvent = onDispatchKeyEvent;
    }

    public void setOnDispatchKeyEventPreImeInterceptor(OnDispatchKeyEventPreImeInterceptor onDispatchKeyEventPreImeInterceptor) {
        this.mOnDispatchKeyEventPreImeInterceptor = onDispatchKeyEventPreImeInterceptor;
    }

    public BaseComposerActivityLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mBaseLocation = new int[2];
        this.mTargetLocation = new int[2];
    }

    public BaseComposerActivityLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mBaseLocation = new int[2];
        this.mTargetLocation = new int[2];
    }
}
