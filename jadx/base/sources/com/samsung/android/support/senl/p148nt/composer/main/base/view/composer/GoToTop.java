package com.samsung.android.support.senl.p148nt.composer.main.base.view.composer;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import com.samsung.android.support.senl.p148nt.composer.C9086R;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class GoToTop {
    private static final int DURATION = 333;
    private static final long SHOW_TIME = 2000;
    private View.OnClickListener mClickListener;
    private boolean mDisabled;
    private final View mGoToTopView;
    private Runnable mHideRunnable;
    private boolean mIsHiding;

    public GoToTop(View view) {
        this.mGoToTopView = view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void runHideAnimation() {
        this.mGoToTopView.animate().alpha(0.0f).setDuration(333L).setListener(new AnimatorListenerAdapter() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.composer.GoToTop.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                GoToTop.this.mGoToTopView.setVisibility(4);
                GoToTop.this.mIsHiding = false;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                GoToTop.this.mGoToTopView.setVisibility(4);
                GoToTop.this.mIsHiding = false;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                GoToTop.this.mIsHiding = true;
            }
        }).start();
    }

    private void runShowAnimation() {
        this.mGoToTopView.animate().alpha(1.0f).setDuration(333L).setListener(new AnimatorListenerAdapter() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.composer.GoToTop.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                GoToTop.this.mGoToTopView.postDelayed(GoToTop.this.mHideRunnable, 2000L);
            }
        }).start();
    }

    public void hide() {
        if (this.mDisabled || this.mGoToTopView.getVisibility() != 0 || this.mIsHiding) {
            return;
        }
        this.mGoToTopView.removeCallbacks(this.mHideRunnable);
        runHideAnimation();
    }

    public void hideImmediately() {
        if (!this.mDisabled && this.mGoToTopView.getVisibility() == 0) {
            this.mGoToTopView.setVisibility(4);
        }
    }

    public void init(View.OnClickListener onClickListener) {
        this.mClickListener = onClickListener;
        this.mGoToTopView.setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.composer.GoToTop.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                GoToTop.this.mClickListener.onClick(view);
            }
        });
        this.mHideRunnable = new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.composer.GoToTop.2
            @Override // java.lang.Runnable
            public void run() {
                GoToTop.this.runHideAnimation();
            }
        };
    }

    public void setEnable(boolean z) {
        this.mDisabled = !z;
    }

    public void show() {
        if (this.mDisabled) {
            return;
        }
        if (this.mGoToTopView.getVisibility() != 0) {
            this.mGoToTopView.setVisibility(0);
            runShowAnimation();
            return;
        }
        this.mGoToTopView.removeCallbacks(this.mHideRunnable);
        if (!this.mIsHiding) {
            this.mGoToTopView.postDelayed(this.mHideRunnable, 2000L);
            return;
        }
        this.mGoToTopView.animate().cancel();
        this.mGoToTopView.setVisibility(0);
        runShowAnimation();
    }

    public void updateBottomMargin(boolean z) {
        if (z) {
            int dimensionPixelSize = this.mGoToTopView.getContext().getResources().getDimensionPixelSize(C9086R.dimen.comp_go_to_top_bottom_margin_with_display_cutout);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mGoToTopView.getLayoutParams();
            marginLayoutParams.bottomMargin = dimensionPixelSize;
            this.mGoToTopView.setLayoutParams(marginLayoutParams);
            return;
        }
        int dimensionPixelSize2 = this.mGoToTopView.getContext().getResources().getDimensionPixelSize(C9086R.dimen.comp_go_to_top_bottom_margin);
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.mGoToTopView.getLayoutParams();
        marginLayoutParams2.bottomMargin = dimensionPixelSize2;
        this.mGoToTopView.setLayoutParams(marginLayoutParams2);
    }
}
