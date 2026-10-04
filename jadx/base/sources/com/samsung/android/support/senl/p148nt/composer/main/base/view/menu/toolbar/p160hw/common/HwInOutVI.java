package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.common;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.TransitionValues;
import androidx.transition.Visibility;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class HwInOutVI extends Visibility {
    private static final long DEFAULT_ALPHA_DURATION = 150;
    private static final float DEFAULT_ALPHA_IN_VALUE = 1.0f;
    private static final float DEFAULT_ALPHA_OUT_VALUE = 0.0f;
    private static final long DEFAULT_SCALE_DURATION = 250;
    private static final float DEFAULT_SCALE_IN_VALUE = 1.0f;
    private static final float DEFAULT_SCALE_OUT_VALUE = 0.95f;

    /* JADX INFO: renamed from: IN */
    public static final int f7222IN = 1;
    public static final int OUT = 2;
    private static final String PROPNAME_ALPHA = "android:inout:transitionAlpha";
    private static final String PROPNAME_SCALE_X = "android:inout:transitionScaleX";
    private static final String PROPNAME_SCALE_Y = "android:inout:transitionScaleY";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Retention(RetentionPolicy.SOURCE)
    public @interface InOutMode {
    }

    public HwInOutVI() {
    }

    private Animator createAlphaAnimator(final View view, int i) {
        ValueAnimator valueAnimatorOfPropertyValuesHolder = ValueAnimator.ofPropertyValuesHolder(getAlpha(i));
        valueAnimatorOfPropertyValuesHolder.setDuration(150L);
        valueAnimatorOfPropertyValuesHolder.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.common.HwInOutVI.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                view.setAlpha(((Float) valueAnimator.getAnimatedValue(HwInOutVI.PROPNAME_ALPHA)).floatValue());
            }
        });
        return valueAnimatorOfPropertyValuesHolder;
    }

    private Animator createAnimator(final View view, int i) {
        Animator animatorCreateScaleAnimator = createScaleAnimator(view, i);
        Animator animatorCreateAlphaAnimator = createAlphaAnimator(view, i);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(animatorCreateScaleAnimator, animatorCreateAlphaAnimator);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.common.HwInOutVI.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                HwInOutVI.this.resetView(view);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                HwInOutVI.this.resetView(view);
            }
        });
        return animatorSet;
    }

    private Animator createScaleAnimator(final View view, int i) {
        ValueAnimator valueAnimatorOfPropertyValuesHolder = ValueAnimator.ofPropertyValuesHolder(getScaleX(i), getScaleY(i));
        valueAnimatorOfPropertyValuesHolder.setDuration(250L);
        valueAnimatorOfPropertyValuesHolder.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.hw.common.HwInOutVI.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                view.setScaleX(((Float) valueAnimator.getAnimatedValue(HwInOutVI.PROPNAME_SCALE_X)).floatValue());
                view.setScaleY(((Float) valueAnimator.getAnimatedValue(HwInOutVI.PROPNAME_SCALE_Y)).floatValue());
            }
        });
        return valueAnimatorOfPropertyValuesHolder;
    }

    private PropertyValuesHolder getAlpha(int i) {
        return PropertyValuesHolder.ofFloat(PROPNAME_ALPHA, getStartAlpha(i), getEndAlpha(i));
    }

    private float getEndAlpha(int i) {
        return i == 2 ? 0.0f : 1.0f;
    }

    private float getEndScale(int i) {
        return i == 2 ? 0.95f : 1.0f;
    }

    private PropertyValuesHolder getScaleX(int i) {
        return PropertyValuesHolder.ofFloat(PROPNAME_SCALE_X, getStartScale(i), getEndScale(i));
    }

    private PropertyValuesHolder getScaleY(int i) {
        return PropertyValuesHolder.ofFloat(PROPNAME_SCALE_Y, getStartScale(i), getEndScale(i));
    }

    private float getStartAlpha(int i) {
        return i == 1 ? 0.0f : 1.0f;
    }

    private float getStartScale(int i) {
        return i == 1 ? 0.95f : 1.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetView(View view) {
        view.setScaleX(1.0f);
        view.setScaleY(1.0f);
        view.setAlpha(1.0f);
    }

    public Animator getAnimator(View view) {
        return createAnimator(view, getMode());
    }

    @Override // androidx.transition.Visibility
    public Animator onAppear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return createAnimator(view, 1);
    }

    @Override // androidx.transition.Visibility
    public Animator onDisappear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return createAnimator(view, 2);
    }

    public HwInOutVI(int i) {
        setMode(i);
    }
}
