package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.editor.animation;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.os.Build;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.animation.PathInterpolator;
import androidx.appcompat.widget.SeslSeekBar;
import androidx.glance.AbstractC2821a;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.CTLogger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import p258y.AbstractC14516b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class SeekBarProgressAnimation {
    private static final int SEEK_BAR_ANIMATION_LONG_DURATION = 400;
    private static final int SEEK_BAR_ANIMATION_SHORT_DURATION = 100;
    private static final int VALUE_THRESHOLD = 10;
    private int mAnimatingEndValue;
    private ObjectAnimator mAnimator;
    private boolean mIsDragging;
    private int mScaledTouchSlop;
    private SeslSeekBar mSeekBar;
    private int mStartProgress;
    private int mTouchDownX;
    private final String TAG = CTLogger.createTag("SeekBarProgressAnimation");
    private final Animator.AnimatorListener mInnerAnimationListener = new Animator.AnimatorListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.template.editor.animation.SeekBarProgressAnimation.1
        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (SeekBarProgressAnimation.this.mSeekBar != null) {
                SeekBarProgressAnimation seekBarProgressAnimation = SeekBarProgressAnimation.this;
                seekBarProgressAnimation.mStartProgress = seekBarProgressAnimation.mSeekBar.getProgress();
            }
            SeekBarProgressAnimation.this.mIsDragging = false;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    };

    public SeekBarProgressAnimation(SeslSeekBar seslSeekBar) {
        if (seslSeekBar == null) {
            return;
        }
        this.mSeekBar = seslSeekBar;
        this.mScaledTouchSlop = ViewConfiguration.get(seslSeekBar.getContext()).getScaledTouchSlop();
    }

    private void cancelAnimation() {
        Logger.m11003i(this.TAG, "cancelAnimation: ");
        ObjectAnimator objectAnimator = this.mAnimator;
        if (objectAnimator != null) {
            objectAnimator.cancel();
            this.mAnimator.removeListener(this.mInnerAnimationListener);
        }
    }

    public boolean isAnimationRunning() {
        ObjectAnimator objectAnimator = this.mAnimator;
        return objectAnimator != null && objectAnimator.isRunning();
    }

    public boolean isDragging() {
        return this.mIsDragging;
    }

    public void setOnTouchEvent(MotionEvent motionEvent) {
        if (this.mSeekBar == null) {
            return;
        }
        int x = (int) motionEvent.getX();
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 2 && Math.abs(x - this.mTouchDownX) > this.mScaledTouchSlop) {
                this.mIsDragging = true;
                return;
            }
            return;
        }
        int pointerCount = motionEvent.getPointerCount();
        if (pointerCount <= 0 || motionEvent.getToolType(pointerCount - 1) == 1) {
            this.mScaledTouchSlop = ViewConfiguration.get(this.mSeekBar.getContext()).getScaledTouchSlop();
        } else if (Build.VERSION.SDK_INT >= 28) {
            this.mScaledTouchSlop = ViewConfiguration.get(this.mSeekBar.getContext()).getScaledHoverSlop();
        } else {
            this.mScaledTouchSlop = ViewConfiguration.get(this.mSeekBar.getContext()).getScaledTouchSlop() / 2;
        }
        this.mStartProgress = this.mSeekBar.getProgress();
        this.mTouchDownX = x;
        this.mIsDragging = false;
    }

    public void setStartProgress(int i) {
        this.mStartProgress = i;
    }

    public void setTarget(boolean z, boolean z2, int i) {
        AbstractC8014b.m7222x(AbstractC2821a.m2230u("setTarget: fromUSer= ", " isTracking= ", " mIsDragging= ", z, z2), this.mIsDragging, this.TAG);
        if (z && z2 && !this.mIsDragging) {
            startAnimation(this.mStartProgress, i);
            return;
        }
        if (z && isAnimationRunning()) {
            if (this.mIsDragging) {
                cancelAnimation();
            } else {
                if (z2) {
                    return;
                }
                startAnimation(this.mStartProgress, i);
            }
        }
    }

    public boolean startAnimation(int i, int i2) {
        SeslSeekBar seslSeekBar = this.mSeekBar;
        if (seslSeekBar == null || i == i2) {
            return false;
        }
        if (!seslSeekBar.isShown()) {
            this.mSeekBar.setProgress(i2);
            return false;
        }
        if (isAnimationRunning()) {
            if (i2 == this.mAnimatingEndValue) {
                return false;
            }
            i = ((Integer) this.mAnimator.getAnimatedValue()).intValue();
            cancelAnimation();
        }
        this.mAnimatingEndValue = i2;
        AbstractC14516b.m15114b(i, i2, "startAnimation: ", " -> ", this.TAG);
        ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(this.mSeekBar, "Progress", i, i2);
        this.mAnimator = objectAnimatorOfInt;
        objectAnimatorOfInt.addListener(this.mInnerAnimationListener);
        this.mAnimator.setInterpolator(new PathInterpolator(0.22f, 0.25f, 0.0f, 1.0f));
        if (Math.abs(i - i2) <= 10) {
            this.mAnimator.setDuration(100L);
        } else {
            this.mAnimator.setDuration(400L);
        }
        this.mAnimator.start();
        return true;
    }
}
