package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.list.animator;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.samsung.android.spr.drawable.animation.interpolator.SineInOut33;
import com.samsung.android.spr.drawable.animation.interpolator.SineInOut90;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.list.animator.IListAnimator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ListPhoneAnimator implements IListAnimator {
    private final View mBackgroundView;
    private boolean mIsHiding = false;
    private final IListAnimator.IAnimatorListener mListener;
    private final View mView;

    public ListPhoneAnimator(View view, View view2, IListAnimator.IAnimatorListener iAnimatorListener) {
        this.mView = view;
        this.mBackgroundView = view2;
        this.mListener = iAnimatorListener;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.list.animator.IListAnimator
    public void hideAnimationView() {
        View view = this.mBackgroundView;
        if (view == null) {
            return;
        }
        this.mIsHiding = false;
        view.clearAnimation();
        this.mBackgroundView.setVisibility(8);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.list.animator.IListAnimator
    public void startHidingAnim() {
        if (this.mView.getAnimation() == null || !this.mIsHiding || !this.mView.getAnimation().hasStarted() || this.mView.getAnimation().hasEnded()) {
            this.mIsHiding = false;
            Animation animationLoadAnimation = AnimationUtils.loadAnimation(this.mView.getContext(), C9086R.anim.comp_list_slide_right_phone);
            animationLoadAnimation.setInterpolator(new SineInOut90());
            animationLoadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.list.animator.ListPhoneAnimator.3
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    ListPhoneAnimator.this.mIsHiding = false;
                    ListPhoneAnimator.this.mListener.onHidingAnimationEnd();
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    ListPhoneAnimator.this.mIsHiding = true;
                }
            });
            Animation animationLoadAnimation2 = AnimationUtils.loadAnimation(this.mView.getContext(), C9086R.anim.comp_list_dim_disable_phone);
            animationLoadAnimation2.setInterpolator(new SineInOut33());
            animationLoadAnimation2.setAnimationListener(new Animation.AnimationListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.list.animator.ListPhoneAnimator.4
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    ListPhoneAnimator.this.hideAnimationView();
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }
            });
            this.mView.startAnimation(animationLoadAnimation);
            View view = this.mBackgroundView;
            if (view != null) {
                view.startAnimation(animationLoadAnimation2);
            }
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.list.animator.IListAnimator
    public void startShowingAnim() {
        this.mIsHiding = false;
        Animation animationLoadAnimation = AnimationUtils.loadAnimation(this.mView.getContext(), C9086R.anim.comp_list_slide_left_phone);
        animationLoadAnimation.setInterpolator(new SineInOut90());
        animationLoadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.list.animator.ListPhoneAnimator.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                ListPhoneAnimator.this.mListener.onShowingAnimationEnd();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                ListPhoneAnimator.this.mListener.onShowingAnimationStart();
            }
        });
        Animation animationLoadAnimation2 = AnimationUtils.loadAnimation(this.mView.getContext(), C9086R.anim.comp_list_dim_enable_phone);
        animationLoadAnimation2.setInterpolator(new SineInOut33());
        animationLoadAnimation2.setAnimationListener(new Animation.AnimationListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.list.animator.ListPhoneAnimator.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                ListPhoneAnimator.this.mBackgroundView.setVisibility(0);
            }
        });
        View view = this.mBackgroundView;
        if (view != null) {
            view.startAnimation(animationLoadAnimation2);
        }
        this.mView.startAnimation(animationLoadAnimation);
    }
}
