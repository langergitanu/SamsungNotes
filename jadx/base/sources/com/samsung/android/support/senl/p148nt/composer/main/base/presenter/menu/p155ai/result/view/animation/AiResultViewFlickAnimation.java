package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.animation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.animation.LinearInterpolator;
import androidx.appcompat.animation.C0421a;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.ColorUtils;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.support.senl.p148nt.base.common.util.ContextUtils;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\t\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000bJ\b\u0010\u0010\u001a\u00020\u000eH\u0002J\u0018\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u0010\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0013H\u0002J\u0006\u0010\u0017\u001a\u00020\u000eJ\u0006\u0010\u0018\u001a\u00020\u000eJ\u0006\u0010\u0019\u001a\u00020\u000eJ\u0006\u0010\u001a\u001a\u00020\u000eR\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/view/animation/AiResultViewFlickAnimation;", "", "targetView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "mTargetView", "mShowAnimator", "Landroid/animation/ValueAnimator;", "mHideAnimator", "mIsDimmed", "", "mIsEnabled", "setEnabledAnimation", "", "isEnabled", "makeAnimation", "createAnimator", "start", "", "end", "setBackgroundAlpha", "opacity", "startHideAnimation", "startShowAnimation", "cancelAllAnimations", "close", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class AiResultViewFlickAnimation {
    public static final long HIDE_DURATION_TYPE_DIM = 200;
    public static final long SHOW_DURATION_TYPE_DIM = 150;
    public static final float TARGET_OPACITY_DARK_MODE = 0.1f;
    public static final float TARGET_OPACITY_LIGHT_MODE = 0.05f;

    @Nullable
    private ValueAnimator mHideAnimator;
    private boolean mIsDimmed;
    private boolean mIsEnabled;

    @Nullable
    private ValueAnimator mShowAnimator;

    @NotNull
    private final View mTargetView;
    private static final String TAG = Logger.createTag("AiResultViewFlickAnimation");

    public AiResultViewFlickAnimation(@NotNull View targetView) {
        Intrinsics.checkNotNullParameter(targetView, "targetView");
        this.mTargetView = targetView;
        this.mIsEnabled = true;
        makeAnimation();
    }

    private final ValueAnimator createAnimator(final float start, final float end) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(start, end);
        valueAnimatorOfFloat.setInterpolator(new LinearInterpolator());
        final boolean z = start < end;
        valueAnimatorOfFloat.setDuration(z ? 150L : 200L);
        valueAnimatorOfFloat.addUpdateListener(new C0421a(this, 20));
        valueAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.animation.AiResultViewFlickAnimation.createAnimator.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                super.onAnimationEnd(animation);
                AiResultViewFlickAnimation.this.setBackgroundAlpha(end);
                AiResultViewFlickAnimation.this.mIsDimmed = z;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                super.onAnimationStart(animation);
                AiResultViewFlickAnimation.this.setBackgroundAlpha(start);
            }
        });
        Intrinsics.checkNotNull(valueAnimatorOfFloat);
        return valueAnimatorOfFloat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createAnimator$lambda$0(AiResultViewFlickAnimation aiResultViewFlickAnimation, ValueAnimator valueAnimator) {
        aiResultViewFlickAnimation.setBackgroundAlpha(((Float) AbstractC6670b.m4742c(valueAnimator, "animation", "null cannot be cast to non-null type kotlin.Float")).floatValue());
    }

    private final void makeAnimation() {
        float f = ContextUtils.isNightMode(this.mTargetView.getContext()) ? 0.1f : 0.05f;
        this.mHideAnimator = createAnimator(f, 0.0f);
        this.mShowAnimator = createAnimator(0.0f, f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setBackgroundAlpha(float opacity) {
        Drawable background = this.mTargetView.getBackground();
        Intrinsics.checkNotNull(background, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
        ((GradientDrawable) background).setColor(ColorUtils.setAlphaComponent(ContextCompat.getColor(this.mTargetView.getContext(), C9086R.color.ai_menu_scroll_view_pager_bg_color), (int) (opacity * 255)));
        this.mTargetView.invalidate();
    }

    public final void cancelAllAnimations() {
        ValueAnimator valueAnimator;
        ValueAnimator valueAnimator2;
        ValueAnimator valueAnimator3 = this.mHideAnimator;
        if (valueAnimator3 != null && valueAnimator3.isRunning() && (valueAnimator2 = this.mHideAnimator) != null) {
            valueAnimator2.cancel();
        }
        ValueAnimator valueAnimator4 = this.mShowAnimator;
        if (valueAnimator4 == null || !valueAnimator4.isRunning() || (valueAnimator = this.mShowAnimator) == null) {
            return;
        }
        valueAnimator.cancel();
    }

    public final void close() {
        cancelAllAnimations();
        this.mHideAnimator = null;
        this.mShowAnimator = null;
    }

    public final void setEnabledAnimation(boolean isEnabled) {
        this.mIsEnabled = isEnabled;
    }

    public final void startHideAnimation() {
        if (this.mIsDimmed) {
            ValueAnimator valueAnimator = this.mShowAnimator;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                ValueAnimator valueAnimator2 = this.mHideAnimator;
                if (valueAnimator2 != null) {
                    ValueAnimator valueAnimator3 = this.mShowAnimator;
                    valueAnimator2.setCurrentFraction(1.0f - (valueAnimator3 != null ? valueAnimator3.getAnimatedFraction() : 0.0f));
                }
                ValueAnimator valueAnimator4 = this.mShowAnimator;
                if (valueAnimator4 != null) {
                    valueAnimator4.cancel();
                }
            }
            ValueAnimator valueAnimator5 = this.mHideAnimator;
            if (valueAnimator5 != null) {
                valueAnimator5.start();
            }
        }
    }

    public final void startShowAnimation() {
        if (this.mIsEnabled) {
            ValueAnimator valueAnimator = this.mHideAnimator;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                ValueAnimator valueAnimator2 = this.mShowAnimator;
                if (valueAnimator2 != null) {
                    ValueAnimator valueAnimator3 = this.mHideAnimator;
                    valueAnimator2.setCurrentFraction(1.0f - (valueAnimator3 != null ? valueAnimator3.getAnimatedFraction() : 0.0f));
                }
                ValueAnimator valueAnimator4 = this.mHideAnimator;
                if (valueAnimator4 != null) {
                    valueAnimator4.cancel();
                }
            }
            ValueAnimator valueAnimator5 = this.mShowAnimator;
            if (valueAnimator5 != null) {
                valueAnimator5.start();
            }
        }
    }
}
