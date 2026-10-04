package com.samsung.android.sdk.pen.setting.common;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilAnimation;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilOpacity;
import com.samsung.android.spen.C7932R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\b\b\u0001\u0018\u0000 52\u00020\u0001:\u000256B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0016\u001a\u00020\u0017J\u0006\u0010\u0018\u001a\u00020\u0017J\u0016\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u0012J\u001e\u0010\u001f\u001a\u00020\u00172\u0006\u0010 \u001a\u00020\u00122\u0006\u0010!\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020\u0012J\u0006\u0010#\u001a\u00020\u0017J\u0006\u0010$\u001a\u00020\u0017J\u0010\u0010%\u001a\u00020\u00172\b\u0010&\u001a\u0004\u0018\u00010\u000eJ\u0010\u0010'\u001a\u00020\u00172\u0006\u0010(\u001a\u00020\u0012H\u0002J\u0010\u0010)\u001a\u00020\u00172\u0006\u0010*\u001a\u00020\u0012H\u0002J\u0010\u0010+\u001a\u00020\u00172\u0006\u0010*\u001a\u00020\u0012H\u0002J\u0010\u0010,\u001a\u00020\u00172\u0006\u0010-\u001a\u00020\u0012H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u00060\u0010R\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0019\u001a\u00020\u001a8F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001bR\u000e\u0010.\u001a\u00020/X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020/X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020/X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020/X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00067"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/common/SpenSliderTransitionAnimator;", "", "context", "Landroid/content/Context;", "mColorControl", "Lcom/samsung/android/sdk/pen/setting/common/SpenSeekBarColorControl;", "mSliderAnimation", "Lcom/samsung/android/sdk/pen/setting/common/SpenSliderAnimation;", "<init>", "(Landroid/content/Context;Lcom/samsung/android/sdk/pen/setting/common/SpenSeekBarColorControl;Lcom/samsung/android/sdk/pen/setting/common/SpenSliderAnimation;)V", "mShowAnimator", "Landroid/animation/Animator;", "mHideAnimator", "mHideListener", "Landroid/animation/Animator$AnimatorListener;", "mAnimatorUtils", "Lcom/samsung/android/sdk/pen/setting/common/SpenSliderTransitionAnimator$AnimatorUtils;", "mStartHeight", "", "mEndHeight", "mShowAniThumbColor", "mShowCurrentColor", "close", "", "cancel", "isRunningAnimation", "", "()Z", "setHeight", "startHeight", "endHeight", "startShow", "startThumbColor", "endThumbColor", "currentColor", "startHide", "endHide", "setHideAnimatorListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setSliderHeight", "height", "setThumbColor", "color", "setProgressColor", "setProgressBgAlpha", "alpha", "mHeightAdjustListener", "Landroid/animation/ValueAnimator$AnimatorUpdateListener;", "mProgressThumbAdjustListener", "mProgressColorAdjustListener", "mProgressBgAlphaAdjustListener", "mShowAnimatorListener", "mHideAnimatorListener", "Companion", "AnimatorUtils", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SuppressLint({"LongLogTag"})
public final class SpenSliderTransitionAnimator {
    private static final int MAX_ALPHA_VALUE = 255;
    private static final int MIN_ALPHA_VALUE = 0;
    private static final int PROGRESS_ALPHA_CHANGE_DURATION = 400;
    private static final int PROGRESS_SCALE_CHANGE_DURATION = 250;
    private static final int PROGRESS_THUMB_COLOR_CHANGE_DURATION = 400;

    @NotNull
    private static final String TAG = "SpenSliderTransitionAnimation";

    @NotNull
    private AnimatorUtils mAnimatorUtils;

    @Nullable
    private SpenSeekBarColorControl mColorControl;
    private int mEndHeight;

    @NotNull
    private final ValueAnimator.AnimatorUpdateListener mHeightAdjustListener;

    @Nullable
    private Animator mHideAnimator;

    @NotNull
    private final Animator.AnimatorListener mHideAnimatorListener;

    @Nullable
    private Animator.AnimatorListener mHideListener;

    @NotNull
    private final ValueAnimator.AnimatorUpdateListener mProgressBgAlphaAdjustListener;

    @NotNull
    private final ValueAnimator.AnimatorUpdateListener mProgressColorAdjustListener;

    @NotNull
    private final ValueAnimator.AnimatorUpdateListener mProgressThumbAdjustListener;
    private int mShowAniThumbColor;

    @Nullable
    private Animator mShowAnimator;

    @NotNull
    private final Animator.AnimatorListener mShowAnimatorListener;
    private int mShowCurrentColor;

    @Nullable
    private SpenSliderAnimation mSliderAnimation;
    private int mStartHeight;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J.\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007J\u0016\u0010\f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007J\u0016\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007J\u0016\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0007J\u0016\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0007J\u0016\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0007¨\u0006\u0015"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/common/SpenSliderTransitionAnimator$AnimatorUtils;", "", "<init>", "(Lcom/samsung/android/sdk/pen/setting/common/SpenSliderTransitionAnimator;)V", "getShowAnimator", "Landroid/animation/Animator;", "startHeight", "", "endHeight", "startThumbColor", "endThumbColor", "currentColor", "getHideAnimator", "getHeightAnimator", "getThumbColorAnimator", "startColor", "endColor", "getProgressColorAnimator", "getProgressBgAlphaAnimator", "startAlpha", "endAlpha", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public final class AnimatorUtils {
        public AnimatorUtils() {
        }

        @NotNull
        public final Animator getHeightAnimator(int startHeight, int endHeight) {
            ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(startHeight, endHeight);
            valueAnimatorOfInt.addUpdateListener(SpenSliderTransitionAnimator.this.mHeightAdjustListener);
            valueAnimatorOfInt.setDuration(250L);
            valueAnimatorOfInt.setInterpolator(SpenSettingUtilAnimation.getInterpolator(4));
            Intrinsics.checkNotNull(valueAnimatorOfInt);
            return valueAnimatorOfInt;
        }

        @NotNull
        public final Animator getHideAnimator(int startHeight, int endHeight) {
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(getHeightAnimator(startHeight, endHeight), getProgressBgAlphaAnimator(255, 0));
            return animatorSet;
        }

        @NotNull
        public final Animator getProgressBgAlphaAnimator(int startAlpha, int endAlpha) {
            ValueAnimator valueAnimatorOfObject = ValueAnimator.ofObject(new ArgbEvaluator(), Integer.valueOf(startAlpha), Integer.valueOf(endAlpha));
            valueAnimatorOfObject.setDuration(400L);
            valueAnimatorOfObject.setInterpolator(SpenSettingUtilAnimation.getInterpolator(5));
            valueAnimatorOfObject.addUpdateListener(SpenSliderTransitionAnimator.this.mProgressBgAlphaAdjustListener);
            Intrinsics.checkNotNull(valueAnimatorOfObject);
            return valueAnimatorOfObject;
        }

        @NotNull
        public final Animator getProgressColorAnimator(int startColor, int endColor) {
            ValueAnimator valueAnimatorOfObject = ValueAnimator.ofObject(new ArgbEvaluator(), Integer.valueOf(startColor), Integer.valueOf(endColor));
            valueAnimatorOfObject.setDuration(400L);
            valueAnimatorOfObject.setInterpolator(SpenSettingUtilAnimation.getInterpolator(5));
            valueAnimatorOfObject.addUpdateListener(SpenSliderTransitionAnimator.this.mProgressColorAdjustListener);
            Intrinsics.checkNotNull(valueAnimatorOfObject);
            return valueAnimatorOfObject;
        }

        @NotNull
        public final Animator getShowAnimator(int startHeight, int endHeight, int startThumbColor, int endThumbColor, int currentColor) {
            AnimatorSet animatorSet = new AnimatorSet();
            Animator heightAnimator = getHeightAnimator(startHeight, endHeight);
            Animator thumbColorAnimator = getThumbColorAnimator(startThumbColor, endThumbColor);
            SpenSeekBarColorControl spenSeekBarColorControl = SpenSliderTransitionAnimator.this.mColorControl;
            if (spenSeekBarColorControl == null || !spenSeekBarColorControl.isSupportProgressBg()) {
                animatorSet.playTogether(heightAnimator, thumbColorAnimator, getProgressColorAnimator(SpenSettingUtilOpacity.setCurrentAlpha(currentColor, 0), SpenSettingUtilOpacity.setCurrentAlpha(currentColor, 255)), getProgressBgAlphaAnimator(0, 255));
            } else {
                animatorSet.playTogether(heightAnimator, thumbColorAnimator);
            }
            SpenSliderTransitionAnimator.this.mShowAniThumbColor = startThumbColor;
            SpenSliderTransitionAnimator.this.mShowCurrentColor = currentColor;
            return animatorSet;
        }

        @NotNull
        public final Animator getThumbColorAnimator(int startColor, int endColor) {
            ValueAnimator valueAnimatorOfObject = ValueAnimator.ofObject(new ArgbEvaluator(), Integer.valueOf(startColor), Integer.valueOf(endColor));
            valueAnimatorOfObject.setDuration(400L);
            valueAnimatorOfObject.addUpdateListener(SpenSliderTransitionAnimator.this.mProgressThumbAdjustListener);
            Intrinsics.checkNotNull(valueAnimatorOfObject);
            return valueAnimatorOfObject;
        }
    }

    public SpenSliderTransitionAnimator(@NotNull Context context, @Nullable SpenSeekBarColorControl spenSeekBarColorControl, @Nullable SpenSliderAnimation spenSliderAnimation) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.mColorControl = spenSeekBarColorControl;
        this.mSliderAnimation = spenSliderAnimation;
        Resources resources = context.getResources();
        this.mStartHeight = resources.getDimensionPixelSize(C7932R.dimen.setting_slider_track_min_height);
        this.mEndHeight = resources.getDimensionPixelSize(C7932R.dimen.setting_slider_opacity_progress_height);
        this.mAnimatorUtils = new AnimatorUtils();
        final int i = 0;
        this.mHeightAdjustListener = new ValueAnimator.AnimatorUpdateListener(this) { // from class: com.samsung.android.sdk.pen.setting.common.g

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ SpenSliderTransitionAnimator f5041b;

            {
                this.f5041b = this;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                switch (i) {
                    case 0:
                        SpenSliderTransitionAnimator.mHeightAdjustListener$lambda$1(this.f5041b, valueAnimator);
                        break;
                    case 1:
                        SpenSliderTransitionAnimator.mProgressThumbAdjustListener$lambda$2(this.f5041b, valueAnimator);
                        break;
                    case 2:
                        SpenSliderTransitionAnimator.mProgressColorAdjustListener$lambda$3(this.f5041b, valueAnimator);
                        break;
                    default:
                        SpenSliderTransitionAnimator.mProgressBgAlphaAdjustListener$lambda$4(this.f5041b, valueAnimator);
                        break;
                }
            }
        };
        final int i2 = 1;
        this.mProgressThumbAdjustListener = new ValueAnimator.AnimatorUpdateListener(this) { // from class: com.samsung.android.sdk.pen.setting.common.g

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ SpenSliderTransitionAnimator f5041b;

            {
                this.f5041b = this;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                switch (i2) {
                    case 0:
                        SpenSliderTransitionAnimator.mHeightAdjustListener$lambda$1(this.f5041b, valueAnimator);
                        break;
                    case 1:
                        SpenSliderTransitionAnimator.mProgressThumbAdjustListener$lambda$2(this.f5041b, valueAnimator);
                        break;
                    case 2:
                        SpenSliderTransitionAnimator.mProgressColorAdjustListener$lambda$3(this.f5041b, valueAnimator);
                        break;
                    default:
                        SpenSliderTransitionAnimator.mProgressBgAlphaAdjustListener$lambda$4(this.f5041b, valueAnimator);
                        break;
                }
            }
        };
        final int i4 = 2;
        this.mProgressColorAdjustListener = new ValueAnimator.AnimatorUpdateListener(this) { // from class: com.samsung.android.sdk.pen.setting.common.g

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ SpenSliderTransitionAnimator f5041b;

            {
                this.f5041b = this;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                switch (i4) {
                    case 0:
                        SpenSliderTransitionAnimator.mHeightAdjustListener$lambda$1(this.f5041b, valueAnimator);
                        break;
                    case 1:
                        SpenSliderTransitionAnimator.mProgressThumbAdjustListener$lambda$2(this.f5041b, valueAnimator);
                        break;
                    case 2:
                        SpenSliderTransitionAnimator.mProgressColorAdjustListener$lambda$3(this.f5041b, valueAnimator);
                        break;
                    default:
                        SpenSliderTransitionAnimator.mProgressBgAlphaAdjustListener$lambda$4(this.f5041b, valueAnimator);
                        break;
                }
            }
        };
        final int i5 = 3;
        this.mProgressBgAlphaAdjustListener = new ValueAnimator.AnimatorUpdateListener(this) { // from class: com.samsung.android.sdk.pen.setting.common.g

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ SpenSliderTransitionAnimator f5041b;

            {
                this.f5041b = this;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                switch (i5) {
                    case 0:
                        SpenSliderTransitionAnimator.mHeightAdjustListener$lambda$1(this.f5041b, valueAnimator);
                        break;
                    case 1:
                        SpenSliderTransitionAnimator.mProgressThumbAdjustListener$lambda$2(this.f5041b, valueAnimator);
                        break;
                    case 2:
                        SpenSliderTransitionAnimator.mProgressColorAdjustListener$lambda$3(this.f5041b, valueAnimator);
                        break;
                    default:
                        SpenSliderTransitionAnimator.mProgressBgAlphaAdjustListener$lambda$4(this.f5041b, valueAnimator);
                        break;
                }
            }
        };
        this.mShowAnimatorListener = new Animator.AnimatorListener() { // from class: com.samsung.android.sdk.pen.setting.common.SpenSliderTransitionAnimator$mShowAnimatorListener$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
                SpenSeekBarColorControl spenSeekBarColorControl2;
                Intrinsics.checkNotNullParameter(animation, "animation");
                if (this.this$0.mSliderAnimation == null || (spenSeekBarColorControl2 = this.this$0.mColorControl) == null) {
                    return;
                }
                SpenSliderTransitionAnimator spenSliderTransitionAnimator = this.this$0;
                spenSliderTransitionAnimator.setSliderHeight(spenSliderTransitionAnimator.mEndHeight);
                spenSliderTransitionAnimator.setThumbColor(spenSliderTransitionAnimator.mShowAniThumbColor);
                if (spenSeekBarColorControl2.isSupportProgressBg()) {
                    return;
                }
                spenSliderTransitionAnimator.setProgressColor(SpenSettingUtilOpacity.setCurrentAlpha(spenSliderTransitionAnimator.mShowCurrentColor, 255));
                spenSliderTransitionAnimator.setProgressBgAlpha(255);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                Log.i("SpenSliderTransitionAnimation", "[SHOW] onAnimationEnd()");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                Log.i("SpenSliderTransitionAnimation", "[SHOW] onAnimationStart()");
            }
        };
        this.mHideAnimatorListener = new Animator.AnimatorListener() { // from class: com.samsung.android.sdk.pen.setting.common.SpenSliderTransitionAnimator$mHideAnimatorListener$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                this.this$0.endHide();
                Animator.AnimatorListener animatorListener = this.this$0.mHideListener;
                if (animatorListener != null) {
                    animatorListener.onAnimationCancel(animation);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                this.this$0.endHide();
                Animator.AnimatorListener animatorListener = this.this$0.mHideListener;
                if (animatorListener != null) {
                    animatorListener.onAnimationEnd(animation);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                Animator.AnimatorListener animatorListener = this.this$0.mHideListener;
                if (animatorListener != null) {
                    animatorListener.onAnimationRepeat(animation);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                Animator.AnimatorListener animatorListener = this.this$0.mHideListener;
                if (animatorListener != null) {
                    animatorListener.onAnimationStart(animation);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mHeightAdjustListener$lambda$1(SpenSliderTransitionAnimator spenSliderTransitionAnimator, ValueAnimator valueAnimator) {
        spenSliderTransitionAnimator.setSliderHeight(((Integer) AbstractC6670b.m4742c(valueAnimator, "animation", "null cannot be cast to non-null type kotlin.Int")).intValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mProgressBgAlphaAdjustListener$lambda$4(SpenSliderTransitionAnimator spenSliderTransitionAnimator, ValueAnimator valueAnimator) {
        spenSliderTransitionAnimator.setProgressBgAlpha(((Integer) AbstractC6670b.m4742c(valueAnimator, "animation", "null cannot be cast to non-null type kotlin.Int")).intValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mProgressColorAdjustListener$lambda$3(SpenSliderTransitionAnimator spenSliderTransitionAnimator, ValueAnimator valueAnimator) {
        spenSliderTransitionAnimator.setProgressColor(((Integer) AbstractC6670b.m4742c(valueAnimator, "animation", "null cannot be cast to non-null type kotlin.Int")).intValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mProgressThumbAdjustListener$lambda$2(SpenSliderTransitionAnimator spenSliderTransitionAnimator, ValueAnimator valueAnimator) {
        spenSliderTransitionAnimator.setThumbColor(((Integer) AbstractC6670b.m4742c(valueAnimator, "animation", "null cannot be cast to non-null type kotlin.Int")).intValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setProgressBgAlpha(int alpha) {
        SpenSeekBarColorControl spenSeekBarColorControl = this.mColorControl;
        if (spenSeekBarColorControl != null) {
            spenSeekBarColorControl.setProgressBgAlpha(alpha);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setProgressColor(int color) {
        SpenSeekBarColorControl spenSeekBarColorControl = this.mColorControl;
        if (spenSeekBarColorControl == null || spenSeekBarColorControl.isSupportProgressBg()) {
            return;
        }
        spenSeekBarColorControl.setProgressColor(color);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setSliderHeight(int height) {
        SpenSliderAnimation spenSliderAnimation = this.mSliderAnimation;
        if (spenSliderAnimation != null) {
            spenSliderAnimation.setProgress(height);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setThumbColor(int color) {
        SpenSeekBarColorControl spenSeekBarColorControl = this.mColorControl;
        if (spenSeekBarColorControl != null) {
            spenSeekBarColorControl.setThumbColor(color);
        }
    }

    public final void cancel() {
        Log.i(TAG, "cancelAnimation()");
        Animator animator = this.mShowAnimator;
        if (animator != null && animator.isRunning()) {
            Log.i(TAG, "showAnimator is canceled.");
            Animator animator2 = this.mShowAnimator;
            if (animator2 != null) {
                animator2.cancel();
            }
        }
        this.mShowAnimator = null;
        Animator animator3 = this.mHideAnimator;
        if (animator3 != null && animator3.isRunning()) {
            Log.i(TAG, "hideAnimator is canceled.");
            Animator animator4 = this.mHideAnimator;
            if (animator4 != null) {
                animator4.cancel();
            }
        }
        this.mHideAnimator = null;
    }

    public final void close() {
        this.mColorControl = null;
        this.mSliderAnimation = null;
        this.mHideListener = null;
        cancel();
    }

    public final void endHide() {
        SpenSliderAnimation spenSliderAnimation;
        Log.i(TAG, "endHide()");
        if (this.mColorControl == null || (spenSliderAnimation = this.mSliderAnimation) == null) {
            return;
        }
        if (spenSliderAnimation != null) {
            spenSliderAnimation.setProgress(this.mEndHeight);
        }
        SpenSeekBarColorControl spenSeekBarColorControl = this.mColorControl;
        if (spenSeekBarColorControl != null) {
            spenSeekBarColorControl.setThumbAlpha(255);
        }
        SpenSeekBarColorControl spenSeekBarColorControl2 = this.mColorControl;
        if (spenSeekBarColorControl2 != null) {
            spenSeekBarColorControl2.setProgressBgAlpha(255);
        }
    }

    public final boolean isRunningAnimation() {
        Animator animator;
        Animator animator2 = this.mShowAnimator;
        return (animator2 != null && animator2.isRunning()) || ((animator = this.mHideAnimator) != null && animator.isRunning());
    }

    public final void setHeight(int startHeight, int endHeight) {
        AbstractC6670b.m4744e(startHeight, endHeight, "setHeight() s=", " e=", TAG);
        this.mStartHeight = startHeight;
        this.mEndHeight = endHeight;
    }

    public final void setHideAnimatorListener(@Nullable Animator.AnimatorListener listener) {
        this.mHideListener = listener;
    }

    public final void startHide() {
        if (this.mColorControl == null || this.mSliderAnimation == null) {
            return;
        }
        cancel();
        SpenSeekBarColorControl spenSeekBarColorControl = this.mColorControl;
        if (spenSeekBarColorControl != null) {
            spenSeekBarColorControl.setThumbAlpha(0);
        }
        Animator hideAnimator = this.mAnimatorUtils.getHideAnimator(this.mEndHeight, this.mStartHeight);
        this.mHideAnimator = hideAnimator;
        if (hideAnimator != null) {
            hideAnimator.addListener(this.mHideAnimatorListener);
        }
        Animator animator = this.mHideAnimator;
        if (animator != null) {
            animator.start();
        }
    }

    public final void startShow(int startThumbColor, int endThumbColor, int currentColor) {
        if (this.mColorControl == null || this.mSliderAnimation == null) {
            return;
        }
        cancel();
        Animator showAnimator = this.mAnimatorUtils.getShowAnimator(this.mStartHeight, this.mEndHeight, startThumbColor, endThumbColor, currentColor);
        this.mShowAnimator = showAnimator;
        if (showAnimator != null) {
            showAnimator.addListener(this.mShowAnimatorListener);
        }
        Animator animator = this.mShowAnimator;
        if (animator != null) {
            animator.start();
        }
    }
}
