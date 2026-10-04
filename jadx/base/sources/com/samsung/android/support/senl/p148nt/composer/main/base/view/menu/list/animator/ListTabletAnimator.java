package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.list.animator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.list.animator.IListAnimator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ListTabletAnimator implements IListAnimator {
    private int mAnimationDuration;
    public IContract mContract;
    private final IListAnimator.IAnimatorListener mListener;
    private ValueAnimator mValueAnimator;
    private final View mView;
    private int mInitialMargin = 0;
    private final ValueAnimator.AnimatorUpdateListener mUpdateListener = new ValueAnimator.AnimatorUpdateListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.list.animator.ListTabletAnimator.3
        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ListTabletAnimator.this.mView.getLayoutParams();
            layoutParams.setMarginStart(iIntValue);
            ListTabletAnimator.this.mView.setLayoutParams(layoutParams);
        }
    };

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface IContract {
        int getListWidth();
    }

    public ListTabletAnimator(View view, IListAnimator.IAnimatorListener iAnimatorListener, IContract iContract) {
        this.mAnimationDuration = 450;
        this.mContract = iContract;
        this.mView = view;
        this.mListener = iAnimatorListener;
        this.mAnimationDuration = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setInitialStartMargin(int i) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mView.getLayoutParams();
        layoutParams.setMarginStart(i);
        this.mView.setLayoutParams(layoutParams);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.list.animator.IListAnimator
    public void hideAnimationView() {
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.list.animator.IListAnimator
    public void startHidingAnim() {
        this.mInitialMargin = ((ViewGroup.MarginLayoutParams) this.mView.getLayoutParams()).getMarginStart();
        final int listWidth = this.mContract.getListWidth() * (-1);
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(this.mInitialMargin, listWidth);
        this.mValueAnimator = valueAnimatorOfInt;
        valueAnimatorOfInt.addUpdateListener(this.mUpdateListener);
        this.mValueAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.list.animator.ListTabletAnimator.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                ListTabletAnimator.this.setInitialStartMargin(listWidth);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ListTabletAnimator.this.mListener.onHidingAnimationEnd();
            }
        });
        this.mValueAnimator.setDuration(this.mAnimationDuration).start();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.list.animator.IListAnimator
    public void startShowingAnim() {
        this.mInitialMargin = 0;
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(this.mContract.getListWidth() * (-1), this.mInitialMargin);
        this.mValueAnimator = valueAnimatorOfInt;
        valueAnimatorOfInt.addUpdateListener(this.mUpdateListener);
        this.mValueAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.list.animator.ListTabletAnimator.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                ListTabletAnimator listTabletAnimator = ListTabletAnimator.this;
                listTabletAnimator.setInitialStartMargin(listTabletAnimator.mInitialMargin);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ListTabletAnimator.this.mListener.onShowingAnimationEnd();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ListTabletAnimator.this.mListener.onShowingAnimationStart();
            }
        });
        this.mValueAnimator.setDuration(this.mAnimationDuration).start();
    }
}
