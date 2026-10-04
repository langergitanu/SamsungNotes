package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.list.pages.holder;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.view.animation.LinearInterpolator;
import android.widget.CheckBox;
import com.samsung.android.view.animation.SineInOut90;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
class CheckBoxShowHideAnimator {
    private static final String ALPHA_PROPERTY_NAME = "ALPHA";
    private static final int CHECKED_DIM_OPACITY_FROM = 0;
    public static final int CHECKED_DIM_OPACITY_TO = 100;
    private static final int CHECKED_DURATION = 100;
    private static final String SCALE_PROPERTY_NAME = "SCALE";
    private static final float SHOW_ALPHA_FROM = 0.0f;
    private static final float SHOW_ALPHA_TO = 1.0f;
    private static final int SHOW_HIDE_DURATION = 400;
    private static final float SHOW_SCALE_FROM = 0.5f;
    private static final float SHOW_SCALE_TO = 1.0f;
    private static final int UNCHECKED_DIM_OPACITY_FROM = 100;
    public static final int UNCHECKED_DIM_OPACITY_TO = 0;
    private ValueAnimator mDimAnimator;
    private ValueAnimator mHideAnimator;
    private LinearInterpolator mLinearInterpolator;
    private ValueAnimator mShowAnimator;
    private SineInOut90 mSineInOut90;

    private LinearInterpolator createLinearInterpolator() {
        if (this.mLinearInterpolator == null) {
            this.mLinearInterpolator = new LinearInterpolator();
        }
        return this.mLinearInterpolator;
    }

    private SineInOut90 createSineInOut90() {
        if (this.mSineInOut90 == null) {
            this.mSineInOut90 = new SineInOut90();
        }
        return this.mSineInOut90;
    }

    public void hideAnimation(final CheckBox checkBox) {
        ValueAnimator valueAnimator = this.mShowAnimator;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.mShowAnimator.cancel();
        }
        checkBox.setVisibility(0);
        ValueAnimator valueAnimator2 = new ValueAnimator();
        this.mHideAnimator = valueAnimator2;
        valueAnimator2.setDuration(400L).setInterpolator(createSineInOut90());
        this.mHideAnimator.setValues(PropertyValuesHolder.ofFloat(ALPHA_PROPERTY_NAME, 1.0f, 0.0f));
        this.mHideAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.list.pages.holder.CheckBoxShowHideAnimator.5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator3) {
                checkBox.setAlpha(((Float) valueAnimator3.getAnimatedValue(CheckBoxShowHideAnimator.ALPHA_PROPERTY_NAME)).floatValue());
            }
        });
        this.mHideAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.list.pages.holder.CheckBoxShowHideAnimator.6
            private void setLastState() {
                checkBox.setVisibility(8);
                checkBox.setAlpha(1.0f);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                setLastState();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                setLastState();
            }
        });
        this.mHideAnimator.start();
    }

    public void showAnimation(final CheckBox checkBox) {
        ValueAnimator valueAnimator = this.mHideAnimator;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.mHideAnimator.cancel();
        }
        checkBox.setAlpha(0.0f);
        checkBox.setScaleX(0.5f);
        checkBox.setScaleY(0.5f);
        ValueAnimator valueAnimator2 = new ValueAnimator();
        this.mShowAnimator = valueAnimator2;
        valueAnimator2.setDuration(400L).setInterpolator(createSineInOut90());
        this.mShowAnimator.setValues(PropertyValuesHolder.ofFloat(SCALE_PROPERTY_NAME, 0.5f, 1.0f), PropertyValuesHolder.ofFloat(ALPHA_PROPERTY_NAME, 0.0f, 1.0f));
        this.mShowAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.list.pages.holder.CheckBoxShowHideAnimator.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator3) {
                float fFloatValue = ((Float) valueAnimator3.getAnimatedValue(CheckBoxShowHideAnimator.SCALE_PROPERTY_NAME)).floatValue();
                float fFloatValue2 = ((Float) valueAnimator3.getAnimatedValue(CheckBoxShowHideAnimator.ALPHA_PROPERTY_NAME)).floatValue();
                checkBox.setScaleX(fFloatValue);
                checkBox.setScaleY(fFloatValue);
                checkBox.setAlpha(fFloatValue2);
            }
        });
        this.mShowAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.list.pages.holder.CheckBoxShowHideAnimator.4
            private void setLastState() {
                checkBox.setScaleX(1.0f);
                checkBox.setScaleY(1.0f);
                checkBox.setAlpha(1.0f);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                setLastState();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                setLastState();
            }
        });
        this.mShowAnimator.start();
    }

    public void updateCheckBoxDim(boolean z, final CheckableRelativeLayout checkableRelativeLayout, final CheckBox checkBox) {
        int i = 100;
        int i2 = 0;
        if (z) {
            i2 = 100;
            i = 0;
        }
        ValueAnimator valueAnimator = this.mDimAnimator;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.mDimAnimator.cancel();
        }
        checkableRelativeLayout.setChecked(true);
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(i, i2);
        this.mDimAnimator = valueAnimatorOfInt;
        valueAnimatorOfInt.setInterpolator(createLinearInterpolator());
        this.mDimAnimator.setDuration(100L);
        this.mDimAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.list.pages.holder.CheckBoxShowHideAnimator.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                checkableRelativeLayout.getForeground().setAlpha(((Integer) valueAnimator2.getAnimatedValue()).intValue());
            }
        });
        this.mDimAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.list.pages.holder.CheckBoxShowHideAnimator.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                checkableRelativeLayout.setChecked(checkBox.isChecked());
            }
        });
        this.mDimAnimator.start();
    }
}
