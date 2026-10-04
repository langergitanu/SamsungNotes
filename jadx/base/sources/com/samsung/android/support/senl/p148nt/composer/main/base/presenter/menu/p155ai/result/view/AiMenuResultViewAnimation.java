package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.view.animation.PathInterpolator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager2.widget.ViewPager2;
import com.samsung.android.support.senl.p145cm.base.common.util.LocaleUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class AiMenuResultViewAnimation {
    private final AiMenuResultCommonViews mCommonViews;
    private PageTransformerImpl mPageTransformer;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class PageTransformerImpl implements ViewPager2.PageTransformer {
        public static final String TAG_FIRST = "first";
        public static final String TAG_SECOND = "second";
        int mEventBaseIndex;
        int mEventStartIndex;

        private void movePageAnimation(@NonNull View view, float f) {
            if ("second".equals(view.getTag())) {
                if (f < 0.0f || f > 1.0f) {
                    return;
                }
                if (this.mEventStartIndex == this.mEventBaseIndex) {
                    updateSecondView(view, 1.0f - f, true);
                    return;
                } else {
                    updateSecondView(view, f, false);
                    return;
                }
            }
            if (!"first".equals(view.getTag()) || f < -1.0f || f > 0.0f) {
                return;
            }
            if (this.mEventStartIndex == this.mEventBaseIndex) {
                updateFirstView(view, Math.abs(f), false);
            } else {
                updateFirstView(view, f + 1.0f, true);
            }
        }

        private void setScaleView(View view, float f) {
            view.setScaleX(f);
            view.setScaleY(f);
        }

        private void updateFirstView(View view, float f, boolean z) {
            float f4 = 0.2f * f;
            if (z) {
                view.setTranslationX(view.getWidth() - (view.getWidth() * f));
                setScaleView(view, f4 + 0.8f);
                view.setAlpha(Math.min(1.0f, f * 2.0f));
            } else {
                float f5 = 1.0f - f4;
                view.setTranslationX(view.getWidth() * f);
                if (f == 1.0f) {
                    setScaleView(view, 0.0f);
                } else {
                    setScaleView(view, f5);
                }
                view.setAlpha(1.0f - Math.min(1.0f, f * 2.0f));
            }
        }

        private void updateSecondView(View view, float f, boolean z) {
            float fMin = Math.min(1.0f, f * 2.0f);
            if (z) {
                view.setAlpha(fMin);
            } else {
                view.setAlpha(1.0f - fMin);
            }
        }

        public void setEventBaseIndex(int i) {
            this.mEventBaseIndex = i;
        }

        public void setEventStartIndex(int i) {
            this.mEventStartIndex = i;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.PageTransformer
        public void transformPage(@NonNull View view, float f) {
            movePageAnimation(view, f);
        }
    }

    public AiMenuResultViewAnimation(AiMenuResultCommonViews aiMenuResultCommonViews) {
        this.mCommonViews = aiMenuResultCommonViews;
    }

    public PageTransformerImpl getPageTransformer() {
        return this.mPageTransformer;
    }

    public void initAnimation() {
        this.mPageTransformer = new PageTransformerImpl();
    }

    public void runMoveToResultPageAnimation(final ViewPager2 viewPager2, int i, @Nullable final Runnable runnable) {
        ValueAnimator valueAnimatorOfInt;
        ValueAnimator valueAnimatorOfFloat;
        int width = viewPager2.getWidth();
        if (!LocaleUtils.isRTLMode()) {
            valueAnimatorOfInt = ValueAnimator.ofInt(width * i, (i + 1) * width);
        } else {
            if (viewPager2.getAdapter() == null) {
                return;
            }
            int itemCount = viewPager2.getAdapter().getItemCount() - i;
            valueAnimatorOfInt = ValueAnimator.ofInt((itemCount - 1) * width, (itemCount - 2) * width);
        }
        valueAnimatorOfInt.setDuration(400L);
        valueAnimatorOfInt.setInterpolator(new PathInterpolator(0.22f, 0.25f, 0.0f, 1.0f));
        valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(width, viewPager2) { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultViewAnimation.1
            int previousX;
            final /* synthetic */ int val$pageWidth;
            final /* synthetic */ ViewPager2 val$viewPager;

            {
                this.val$pageWidth = width;
                this.val$viewPager = viewPager2;
                this.previousX = width;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
                int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                this.val$viewPager.fakeDragBy(-(iIntValue - this.previousX));
                this.previousX = iIntValue;
            }
        });
        valueAnimatorOfInt.addListener(new AnimatorListenerAdapter() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultViewAnimation.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                viewPager2.endFakeDrag();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                viewPager2.beginFakeDrag();
            }
        });
        if (this.mCommonViews.getContinuesProgress().isShowing()) {
            valueAnimatorOfFloat = null;
        } else {
            valueAnimatorOfFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
            valueAnimatorOfFloat.setDuration(100L);
            valueAnimatorOfFloat.setInterpolator(new LinearInterpolator());
            valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultViewAnimation.3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
                    AiMenuResultViewAnimation.this.mCommonViews.setAlphaBottomButtons((valueAnimator.getAnimatedFraction() * 0.6f) + 0.4f);
                }
            });
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(valueAnimatorOfInt);
        if (valueAnimatorOfFloat != null) {
            animatorSet.playTogether(valueAnimatorOfFloat);
        }
        animatorSet.start();
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AiMenuResultViewAnimation.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                Runnable runnable2 = runnable;
                if (runnable2 != null) {
                    runnable2.run();
                }
            }
        });
    }
}
