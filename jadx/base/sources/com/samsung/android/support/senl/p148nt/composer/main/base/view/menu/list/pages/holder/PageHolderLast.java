package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.list.pages.holder;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.View;
import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.list.pages.PageListResourceUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.pages.PageListHolderPresenter;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class PageHolderLast extends PageHolder {
    private final View mPlusImageView;
    private ShowAnimation mShowAnimation;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ShowAnimation {
        private static final long DURATION = 200;
        private static final float END_ALPHA = 1.0f;
        private static final float START_ALPHA = 0.0f;
        private ValueAnimator mAnimator;

        public /* synthetic */ ShowAnimation(int i) {
            this();
        }

        public void cancel() {
            ValueAnimator valueAnimator = this.mAnimator;
            if (valueAnimator == null || !valueAnimator.isRunning()) {
                return;
            }
            this.mAnimator.cancel();
        }

        public void start(final View view) {
            cancel();
            view.setAlpha(0.0f);
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.mAnimator = valueAnimatorOfFloat;
            valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.list.pages.holder.PageHolderLast.ShowAnimation.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    view.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            });
            this.mAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.list.pages.holder.PageHolderLast.ShowAnimation.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    view.setAlpha(1.0f);
                    ShowAnimation.this.mAnimator = null;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    view.setAlpha(1.0f);
                    ShowAnimation.this.mAnimator = null;
                }
            });
            this.mAnimator.setDuration(200L).start();
        }

        private ShowAnimation() {
        }
    }

    public PageHolderLast(@NonNull View view, PageListHolderPresenter pageListHolderPresenter, PageHolderVariable pageHolderVariable) {
        super(view, pageListHolderPresenter, pageHolderVariable);
        View viewFindViewById = view.findViewById(C9086R.id.pages_item_plus);
        this.mPlusImageView = viewFindViewById;
        viewFindViewById.setVisibility(0);
    }

    private void setVisibility() {
        this.mPlusImageView.setVisibility(0);
        this.mMoreBtn.setVisibility(8);
        this.mBookmarkBtnContainer.setVisibility(8);
        this.mBookmarkBtnImage.setVisibility(8);
        this.mPageIndexView.setVisibility(8);
    }

    private void updateDescription() {
        this.mThumbnailContainer.setContentDescription(PageListResourceUtils.getAddPageDescription());
    }

    public ShowAnimation getShowAnimation() {
        if (this.mShowAnimation == null) {
            this.mShowAnimation = new ShowAnimation(0);
        }
        return this.mShowAnimation;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.list.pages.holder.PageHolder
    public int getType() {
        return 1;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.list.pages.holder.PageHolder
    public void onBind(String str, int i, int i2, boolean z, boolean z2, String str2, int i4) {
        super.onBind(str, i, i2, z, z2, str2, i4);
        PageHolderVariable pageHolderVariable = this.mPageHolderVariable;
        if (!pageHolderVariable.mIsEditable || pageHolderVariable.mIsDisabledAddPage) {
            this.itemView.setVisibility(8);
        } else {
            this.itemView.setVisibility(0);
        }
        updateDescription();
        setVisibility();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.list.pages.holder.PageHolder
    public void setNoInfoState() {
        resize(1.4142857f);
        setVisibility();
        this.mPlusImageView.setVisibility(8);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.list.pages.holder.PageHolder
    public void startModeChangeAnimation(int i, int i2) {
        if (i2 == 0 && i == 1) {
            getShowAnimation().start(this.itemView);
        }
    }
}
