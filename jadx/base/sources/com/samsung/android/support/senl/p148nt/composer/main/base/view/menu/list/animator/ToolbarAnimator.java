package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.list.animator;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.samsung.android.spr.drawable.animation.interpolator.SineInOut33;
import com.samsung.android.support.senl.p148nt.composer.C9086R;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ToolbarAnimator {
    private Animation mLastAnimation;
    private IListener mListener;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface IListener {
        void onShowingAnimationEnd(int i);
    }

    public ToolbarAnimator(IListener iListener) {
        this.mListener = iListener;
    }

    public void hide(final View view) {
        Animation animationLoadAnimation = AnimationUtils.loadAnimation(view.getContext(), C9086R.anim.comp_pagelist_toolbar_hide);
        this.mLastAnimation = animationLoadAnimation;
        animationLoadAnimation.setInterpolator(new SineInOut33());
        this.mLastAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.list.animator.ToolbarAnimator.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                view.setVisibility(8);
                ToolbarAnimator.this.mLastAnimation = null;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
        view.startAnimation(this.mLastAnimation);
    }

    public boolean isAnimating() {
        Animation animation = this.mLastAnimation;
        return (animation == null || !animation.hasStarted() || this.mLastAnimation.hasEnded()) ? false : true;
    }

    public void show(final View view, final int i) {
        Animation animationLoadAnimation = AnimationUtils.loadAnimation(view.getContext(), C9086R.anim.comp_pagelist_toolbar_show);
        this.mLastAnimation = animationLoadAnimation;
        animationLoadAnimation.setInterpolator(new SineInOut33());
        this.mLastAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.list.animator.ToolbarAnimator.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                ToolbarAnimator.this.mListener.onShowingAnimationEnd(i);
                ToolbarAnimator.this.mLastAnimation = null;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                view.setVisibility(0);
            }
        });
        view.startAnimation(this.mLastAnimation);
    }
}
