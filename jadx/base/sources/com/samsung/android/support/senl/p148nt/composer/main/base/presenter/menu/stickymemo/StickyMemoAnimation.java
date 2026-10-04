package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.stickymemo;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.PathInterpolator;
import androidx.appcompat.animation.C0421a;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.app.sdk.deepsky.textextraction.capsule.data.p137ui.C7051a;
import com.samsung.android.sdk.pen.worddoc.SpenStickyNote;
import com.samsung.android.spr.drawable.animation.interpolator.SineIn33;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.StickyMemoView;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.common.util.SmLogger;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.view.animation.SineInOut60;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 62\u00020\u0001:\u00016B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0004\u001a\u00020\u0005J\u0018\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cJ*\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010 \u001a\u0004\u0018\u00010\u001cJ&\u0010!\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001cH\u0002J\u0010\u0010\"\u001a\u00020#2\u0006\u0010\u0019\u001a\u00020$H\u0002J\u0010\u0010%\u001a\u00020#2\u0006\u0010\u0019\u001a\u00020$H\u0002J\u0010\u0010&\u001a\u00020#2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0010\u0010'\u001a\u00020#2\u0006\u0010\u0019\u001a\u00020$H\u0002J\u0010\u0010(\u001a\u00020#2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0010\u0010)\u001a\u00020#2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u001e\u0010*\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001a2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00170+H\u0007J&\u0010,\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001f2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00170+H\u0007J\u0016\u0010-\u001a\u00020\u00172\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00170+H\u0002J\u0010\u0010.\u001a\u00020#2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0010\u0010/\u001a\u00020#2\u0006\u0010\u0019\u001a\u00020$H\u0002J\u0010\u00100\u001a\u00020#2\u0006\u0010\u0019\u001a\u00020$H\u0002J\u0010\u00101\u001a\u00020#2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0006\u00102\u001a\u00020\u0010J\u000e\u00103\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001aJ\u0010\u00104\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0006\u00105\u001a\u00020\u0017R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00067"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/stickymemo/StickyMemoAnimation;", "", "<init>", "()V", "composerViewPresenter", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/composer/ComposerViewPresenter;", "showAnimator", "Landroid/animation/AnimatorSet;", "getShowAnimator", "()Landroid/animation/AnimatorSet;", "setShowAnimator", "(Landroid/animation/AnimatorSet;)V", "hideAnimator", "getHideAnimator", "setHideAnimator", "isLoadedHideAnimation", "", "()Z", "setLoadedHideAnimation", "(Z)V", "oneEasingInterpolator", "Landroid/view/animation/Interpolator;", "setComposerViewPresenter", "", "showAnimation", "view", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/StickyMemoView;", "endFunc", "Ljava/lang/Runnable;", "maximizeAnimation", "obj", "Lcom/samsung/android/sdk/pen/worddoc/SpenStickyNote;", "releaseFunc", "startShowAnimator", "getShowAlphaAnimator", "Landroid/animation/ValueAnimator;", "Landroid/view/View;", "getShowScaleAnimator", "getShowDecorViewAnimator", "getMaximizeScaleAnimator", "getLottieShowAnimator", "getShowContentAlphaAnimator", "hidAnimation", "Lkotlin/Function0;", "minimizeAnimation", "startHideAnimator", "getHideAlphaAnimator", "getHideScaleAnimator", "getMinimizeScaleAnimator", "getLottieHideAnimator", "isHiding", "setShowAnimation", "preloadHideAnimation", "cancelShowAnimation", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class StickyMemoAnimation {

    @NotNull
    private static final String HIDE_ANIMATION = "hide_memo.json";

    @NotNull
    private static final String SHOW_ANIMATION = "show_memo.json";
    private ComposerViewPresenter composerViewPresenter;

    @Nullable
    private AnimatorSet hideAnimator;
    private boolean isLoadedHideAnimation;

    @NotNull
    private final Interpolator oneEasingInterpolator = new PathInterpolator(0.22f, 0.25f, 0.0f, 1.0f);

    @Nullable
    private AnimatorSet showAnimator;
    private static final String TAG = Logger.createTag("StickyMemoAnimation");

    private final ValueAnimator getHideAlphaAnimator(StickyMemoView view) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.0f);
        objectAnimatorOfFloat.setDuration(200L);
        objectAnimatorOfFloat.setInterpolator(new LinearInterpolator());
        Intrinsics.checkNotNull(objectAnimatorOfFloat);
        return objectAnimatorOfFloat;
    }

    private final ValueAnimator getHideScaleAnimator(View view) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(1.0f, 1.1f);
        valueAnimatorOfFloat.addUpdateListener(new C7051a(view, 1));
        valueAnimatorOfFloat.setDuration(300L);
        valueAnimatorOfFloat.setInterpolator(new SineIn33());
        Intrinsics.checkNotNull(valueAnimatorOfFloat);
        return valueAnimatorOfFloat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getHideScaleAnimator$lambda$3(View view, ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) AbstractC6670b.m4742c(valueAnimator, "animation", "null cannot be cast to non-null type kotlin.Float")).floatValue();
        view.setScaleX(fFloatValue);
        view.setScaleY(fFloatValue);
    }

    private final ValueAnimator getLottieHideAnimator(final StickyMemoView view) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.setDuration(350L);
        valueAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.stickymemo.StickyMemoAnimation.getLottieHideAnimator.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                view.getLottieAnimationView().playAnimation();
            }
        });
        view.getLottieAnimationView().setAnimation(HIDE_ANIMATION);
        Integer backgroundColor = view.getDocManager().getBackgroundColor();
        if (backgroundColor != null) {
            view.updateBackgroundColor(backgroundColor.intValue(), true);
        }
        Intrinsics.checkNotNull(valueAnimatorOfFloat);
        return valueAnimatorOfFloat;
    }

    private final ValueAnimator getLottieShowAnimator(final StickyMemoView view) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.stickymemo.StickyMemoAnimation.getLottieShowAnimator.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                view.getLottieAnimationView().playAnimation();
            }
        });
        Intrinsics.checkNotNull(valueAnimatorOfFloat);
        return valueAnimatorOfFloat;
    }

    private final ValueAnimator getMaximizeScaleAnimator(View view) {
        view.setPivotX(view.getLayoutParams().width / 2.0f);
        view.setPivotY(view.getContext().getResources().getDimensionPixelSize(C9086R.dimen.top_menu_top_margin));
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.5f, 1.0f);
        valueAnimatorOfFloat.addUpdateListener(new C7051a(view, 4));
        valueAnimatorOfFloat.setDuration(300L);
        valueAnimatorOfFloat.setInterpolator(new SineInOut60());
        Intrinsics.checkNotNull(valueAnimatorOfFloat);
        return valueAnimatorOfFloat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getMaximizeScaleAnimator$lambda$2(View view, ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) AbstractC6670b.m4742c(valueAnimator, "animation", "null cannot be cast to non-null type kotlin.Float")).floatValue();
        view.setScaleX(fFloatValue);
        view.setScaleY(fFloatValue);
    }

    private final ValueAnimator getMinimizeScaleAnimator(View view) {
        view.setPivotX(view.getWidth() / 2.0f);
        view.setPivotY(view.getContext().getResources().getDimensionPixelSize(C9086R.dimen.top_menu_top_margin));
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(1.0f, 0.5f);
        valueAnimatorOfFloat.addUpdateListener(new C7051a(view, 3));
        valueAnimatorOfFloat.setDuration(400L);
        valueAnimatorOfFloat.setInterpolator(new SineIn33());
        Intrinsics.checkNotNull(valueAnimatorOfFloat);
        return valueAnimatorOfFloat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getMinimizeScaleAnimator$lambda$4(View view, ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) AbstractC6670b.m4742c(valueAnimator, "animation", "null cannot be cast to non-null type kotlin.Float")).floatValue();
        view.setScaleX(fFloatValue);
        view.setScaleY(fFloatValue);
    }

    private final ValueAnimator getShowAlphaAnimator(View view) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "alpha", 0.0f, 1.0f);
        objectAnimatorOfFloat.setDuration(300L);
        objectAnimatorOfFloat.setInterpolator(new LinearInterpolator());
        view.setAlpha(0.0f);
        Intrinsics.checkNotNull(objectAnimatorOfFloat);
        return objectAnimatorOfFloat;
    }

    private final ValueAnimator getShowContentAlphaAnimator(StickyMemoView view) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view.getComposerView(), "alpha", 0.0f, 1.0f);
        objectAnimatorOfFloat.setDuration(300L);
        objectAnimatorOfFloat.setStartDelay(300L);
        objectAnimatorOfFloat.setInterpolator(new LinearInterpolator());
        view.getComposerView().setAlpha(0.0f);
        Intrinsics.checkNotNull(objectAnimatorOfFloat);
        return objectAnimatorOfFloat;
    }

    private final ValueAnimator getShowDecorViewAnimator(StickyMemoView view) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.addUpdateListener(new C0421a(view, 21));
        valueAnimatorOfFloat.setInterpolator(this.oneEasingInterpolator);
        valueAnimatorOfFloat.setDuration(400L);
        valueAnimatorOfFloat.setStartDelay(300L);
        view.getTopDecorView().setScaleX(0.0f);
        view.getTopDecorView().setScaleY(0.0f);
        Intrinsics.checkNotNull(valueAnimatorOfFloat);
        return valueAnimatorOfFloat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getShowDecorViewAnimator$lambda$1(StickyMemoView stickyMemoView, ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) AbstractC6670b.m4742c(valueAnimator, "animation", "null cannot be cast to non-null type kotlin.Float")).floatValue();
        stickyMemoView.getTopDecorView().setScaleX(fFloatValue);
        stickyMemoView.getTopDecorView().setScaleY(fFloatValue);
    }

    private final ValueAnimator getShowScaleAnimator(View view) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(1.1f, 1.0f);
        valueAnimatorOfFloat.addUpdateListener(new C7051a(view, 2));
        valueAnimatorOfFloat.setInterpolator(new SineInOut60());
        valueAnimatorOfFloat.setDuration(300L);
        Intrinsics.checkNotNull(valueAnimatorOfFloat);
        return valueAnimatorOfFloat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getShowScaleAnimator$lambda$0(View view, ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) AbstractC6670b.m4742c(valueAnimator, "animation", "null cannot be cast to non-null type kotlin.Float")).floatValue();
        view.setScaleX(fFloatValue);
        view.setScaleY(fFloatValue);
    }

    private final void preloadHideAnimation(StickyMemoView view) {
        if (this.isLoadedHideAnimation) {
            return;
        }
        view.getLottieAnimationView().setAnimation(HIDE_ANIMATION);
        this.isLoadedHideAnimation = true;
    }

    private final void startHideAnimator(final Function0<Unit> releaseFunc) {
        AnimatorSet animatorSet = this.hideAnimator;
        if (animatorSet != null) {
            animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.stickymemo.StickyMemoAnimation.startHideAnimator.1
                private final void release() {
                    if (StickyMemoAnimation.this.getHideAnimator() != null) {
                        releaseFunc.invoke();
                    }
                    StickyMemoAnimation.this.setHideAnimator(null);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                    Logger.m10999d(StickyMemoAnimation.TAG, "onHideAnimationCancel#");
                    release();
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                    Logger.m10999d(StickyMemoAnimation.TAG, "onHideAnimationEnd#");
                    release();
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                    Logger.m10999d(StickyMemoAnimation.TAG, "onHideAnimationStart#");
                }
            });
        }
        AnimatorSet animatorSet2 = this.hideAnimator;
        if (animatorSet2 != null) {
            animatorSet2.start();
        }
    }

    private final void startShowAnimator(final StickyMemoView view, final Runnable endFunc, final Runnable releaseFunc) {
        AnimatorSet animatorSet = this.showAnimator;
        if (animatorSet != null) {
            animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.stickymemo.StickyMemoAnimation.startShowAnimator.1
                private final void release() {
                    this.setShowAnimator(null);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                    Logger.m10999d(StickyMemoAnimation.TAG, "onShowAnimationCancel#");
                    Runnable runnable = releaseFunc;
                    if (runnable != null) {
                        runnable.run();
                    }
                    view.notifyAnimationState(false);
                    release();
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                    Logger.m10999d(StickyMemoAnimation.TAG, "onShowAnimationEnd#");
                    view.notifyAnimationState(false);
                    Runnable runnable = endFunc;
                    if (runnable != null) {
                        runnable.run();
                    }
                    release();
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                    Logger.m10999d(StickyMemoAnimation.TAG, "onShowAnimationStart#");
                    view.notifyAnimationState(true);
                }
            });
        }
        AnimatorSet animatorSet2 = this.showAnimator;
        if (animatorSet2 != null) {
            animatorSet2.start();
        }
    }

    public static /* synthetic */ void startShowAnimator$default(StickyMemoAnimation stickyMemoAnimation, StickyMemoView stickyMemoView, Runnable runnable, Runnable runnable2, int i, Object obj) {
        if ((i & 4) != 0) {
            runnable2 = null;
        }
        stickyMemoAnimation.startShowAnimator(stickyMemoView, runnable, runnable2);
    }

    public final void cancelShowAnimation() {
        AnimatorSet animatorSet = this.showAnimator;
        if (animatorSet != null) {
            String TAG2 = TAG;
            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
            SmLogger.m8661d(TAG2, "cancelShowAnimation#");
            animatorSet.cancel();
        }
    }

    @Nullable
    public final AnimatorSet getHideAnimator() {
        return this.hideAnimator;
    }

    @Nullable
    public final AnimatorSet getShowAnimator() {
        return this.showAnimator;
    }

    @SuppressLint({"Recycle"})
    public final void hidAnimation(@NotNull StickyMemoView view, @NotNull Function0<Unit> releaseFunc) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(releaseFunc, "releaseFunc");
        AnimatorSet animatorSet = new AnimatorSet();
        this.hideAnimator = animatorSet;
        animatorSet.playTogether(getHideAlphaAnimator(view));
        AnimatorSet animatorSet2 = this.hideAnimator;
        if (animatorSet2 != null) {
            animatorSet2.playTogether(getHideScaleAnimator(view));
        }
        AnimatorSet animatorSet3 = this.hideAnimator;
        if (animatorSet3 != null) {
            animatorSet3.playTogether(getLottieHideAnimator(view));
        }
        startHideAnimator(releaseFunc);
    }

    public final boolean isHiding() {
        return this.hideAnimator != null;
    }

    /* JADX INFO: renamed from: isLoadedHideAnimation, reason: from getter */
    public final boolean getIsLoadedHideAnimation() {
        return this.isLoadedHideAnimation;
    }

    public final void maximizeAnimation(@NotNull StickyMemoView view, @NotNull SpenStickyNote obj, @Nullable Runnable endFunc, @Nullable Runnable releaseFunc) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(obj, "obj");
        AnimatorSet animatorSet = new AnimatorSet();
        this.showAnimator = animatorSet;
        animatorSet.playTogether(getShowAlphaAnimator(view));
        AnimatorSet animatorSet2 = this.showAnimator;
        if (animatorSet2 != null) {
            animatorSet2.playTogether(getMaximizeScaleAnimator(view));
        }
        AnimatorSet animatorSet3 = this.showAnimator;
        if (animatorSet3 != null) {
            animatorSet3.playTogether(getLottieShowAnimator(view));
        }
        AnimatorSet animatorSet4 = this.showAnimator;
        if (animatorSet4 != null) {
            animatorSet4.playTogether(getShowContentAlphaAnimator(view));
        }
        AnimatorSet animatorSet5 = this.showAnimator;
        if (animatorSet5 != null) {
            animatorSet5.playTogether(getShowDecorViewAnimator(view));
        }
        AnimatorSet animatorSet6 = this.showAnimator;
        if (animatorSet6 != null) {
            animatorSet6.setStartDelay(100L);
        }
        ComposerViewPresenter composerViewPresenter = this.composerViewPresenter;
        if (composerViewPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("composerViewPresenter");
            composerViewPresenter = null;
        }
        composerViewPresenter.startStickyMemoIconAnimation(obj, false);
        startShowAnimator(view, endFunc, releaseFunc);
    }

    @SuppressLint({"Recycle"})
    public final void minimizeAnimation(@NotNull StickyMemoView view, @NotNull final SpenStickyNote obj, @NotNull Function0<Unit> releaseFunc) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(obj, "obj");
        Intrinsics.checkNotNullParameter(releaseFunc, "releaseFunc");
        AnimatorSet animatorSet = new AnimatorSet();
        this.hideAnimator = animatorSet;
        animatorSet.playTogether(getHideAlphaAnimator(view));
        AnimatorSet animatorSet2 = this.hideAnimator;
        if (animatorSet2 != null) {
            animatorSet2.playTogether(getMinimizeScaleAnimator(view));
        }
        AnimatorSet animatorSet3 = this.hideAnimator;
        if (animatorSet3 != null) {
            animatorSet3.playTogether(getLottieHideAnimator(view));
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.stickymemo.StickyMemoAnimation.minimizeAnimation.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                ComposerViewPresenter composerViewPresenter = StickyMemoAnimation.this.composerViewPresenter;
                if (composerViewPresenter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("composerViewPresenter");
                    composerViewPresenter = null;
                }
                composerViewPresenter.startStickyMemoIconAnimation(obj, true);
            }
        });
        valueAnimatorOfFloat.setDuration(10L);
        valueAnimatorOfFloat.setStartDelay(200L);
        AnimatorSet animatorSet4 = this.hideAnimator;
        if (animatorSet4 != null) {
            animatorSet4.playTogether(valueAnimatorOfFloat);
        }
        startHideAnimator(releaseFunc);
    }

    public final void setComposerViewPresenter(@NotNull ComposerViewPresenter composerViewPresenter) {
        Intrinsics.checkNotNullParameter(composerViewPresenter, "composerViewPresenter");
        this.composerViewPresenter = composerViewPresenter;
    }

    public final void setHideAnimator(@Nullable AnimatorSet animatorSet) {
        this.hideAnimator = animatorSet;
    }

    public final void setLoadedHideAnimation(boolean z) {
        this.isLoadedHideAnimation = z;
    }

    public final void setShowAnimation(@NotNull StickyMemoView view) {
        Intrinsics.checkNotNullParameter(view, "view");
        preloadHideAnimation(view);
        view.getLottieAnimationView().setAnimation(SHOW_ANIMATION);
    }

    public final void setShowAnimator(@Nullable AnimatorSet animatorSet) {
        this.showAnimator = animatorSet;
    }

    public final void showAnimation(@NotNull StickyMemoView view, @Nullable Runnable endFunc) {
        Intrinsics.checkNotNullParameter(view, "view");
        AnimatorSet animatorSet = new AnimatorSet();
        this.showAnimator = animatorSet;
        animatorSet.playTogether(getShowAlphaAnimator(view));
        AnimatorSet animatorSet2 = this.showAnimator;
        if (animatorSet2 != null) {
            animatorSet2.playTogether(getShowScaleAnimator(view));
        }
        AnimatorSet animatorSet3 = this.showAnimator;
        if (animatorSet3 != null) {
            animatorSet3.playTogether(getLottieShowAnimator(view));
        }
        AnimatorSet animatorSet4 = this.showAnimator;
        if (animatorSet4 != null) {
            animatorSet4.playTogether(getShowDecorViewAnimator(view));
        }
        startShowAnimator$default(this, view, endFunc, null, 4, null);
    }
}
