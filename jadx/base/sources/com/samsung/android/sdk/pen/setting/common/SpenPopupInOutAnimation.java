package com.samsung.android.sdk.pen.setting.common;

import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilAnimation;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.xmlbeans.XmlErrorCodes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000  2\u00020\u0001:\u0001 B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\u0010J\u0010\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u000bJ\u0010\u0010\u0015\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u000bJ\b\u0010\u0016\u001a\u00020\u0010H\u0002J \u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J \u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/common/SpenPopupInOutAnimation;", "", "targetView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "mTargetView", "mShowAnimationSet", "Landroid/view/animation/AnimationSet;", "mHideAnimationSet", "mHideAnimationListener", "Landroid/view/animation/Animation$AnimationListener;", "mShowAnimationListener", "mShowAnimation", "mHideAnimation", "close", "", "cancelAnimation", "showAnimation", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "hideAnimation", "initAnimation", "createAlphaAnimation", "Landroid/view/animation/AlphaAnimation;", "fromValue", "", "toValue", XmlErrorCodes.DURATION, "", "createScaleAnimation", "Landroid/view/animation/ScaleAnimation;", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenPopupInOutAnimation {

    @NotNull
    private static final String TAG = "SpenPopupInOutAnimation";

    @Nullable
    private Animation.AnimationListener mHideAnimationListener;
    private AnimationSet mHideAnimationSet;

    @Nullable
    private Animation.AnimationListener mShowAnimationListener;
    private AnimationSet mShowAnimationSet;

    @Nullable
    private View mTargetView;

    @NotNull
    private final Animation.AnimationListener mShowAnimation = new Animation.AnimationListener() { // from class: com.samsung.android.sdk.pen.setting.common.SpenPopupInOutAnimation$mShowAnimation$1
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            Log.i("SpenPopupInOutAnimation", "ShowAnimation - onAnimationEnd()");
            Animation.AnimationListener animationListener = this.this$0.mShowAnimationListener;
            if (animationListener != null) {
                animationListener.onAnimationEnd(animation);
            }
            this.this$0.mShowAnimationListener = null;
            this.this$0.cancelAnimation();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            Animation.AnimationListener animationListener = this.this$0.mShowAnimationListener;
            if (animationListener != null) {
                animationListener.onAnimationRepeat(animation);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            Log.i("SpenPopupInOutAnimation", "ShowAnimation - onAnimationStart()");
            Animation.AnimationListener animationListener = this.this$0.mShowAnimationListener;
            if (animationListener != null) {
                animationListener.onAnimationStart(animation);
            }
        }
    };

    @NotNull
    private final Animation.AnimationListener mHideAnimation = new Animation.AnimationListener() { // from class: com.samsung.android.sdk.pen.setting.common.SpenPopupInOutAnimation$mHideAnimation$1
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            Log.i("SpenPopupInOutAnimation", "HideAnimation - onAnimationEnd() called. ".concat(this.this$0.mHideAnimationListener == null ? "NULL" : "NOT NULL"));
            Animation.AnimationListener animationListener = this.this$0.mHideAnimationListener;
            if (animationListener != null) {
                animationListener.onAnimationEnd(animation);
            }
            this.this$0.mHideAnimationListener = null;
            this.this$0.cancelAnimation();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            Animation.AnimationListener animationListener = this.this$0.mHideAnimationListener;
            if (animationListener != null) {
                animationListener.onAnimationRepeat(animation);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            Log.i("SpenPopupInOutAnimation", "HideAnimation - onAnimationStart() called. ");
            Animation.AnimationListener animationListener = this.this$0.mHideAnimationListener;
            if (animationListener != null) {
                animationListener.onAnimationStart(animation);
            }
        }
    };

    public SpenPopupInOutAnimation(@Nullable View view) {
        this.mTargetView = view;
        initAnimation();
    }

    private final AlphaAnimation createAlphaAnimation(float fromValue, float toValue, long duration) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(fromValue, toValue);
        alphaAnimation.setDuration(duration);
        alphaAnimation.setInterpolator(SpenSettingUtilAnimation.getInterpolator(1));
        alphaAnimation.setFillAfter(true);
        return alphaAnimation;
    }

    private final ScaleAnimation createScaleAnimation(float fromValue, float toValue, long duration) {
        ScaleAnimation scaleAnimation = new ScaleAnimation(fromValue, toValue, fromValue, toValue, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(duration);
        scaleAnimation.setInterpolator(SpenSettingUtilAnimation.getInterpolator(3));
        scaleAnimation.setFillAfter(true);
        return scaleAnimation;
    }

    private final void initAnimation() {
        AnimationSet animationSet = new AnimationSet(false);
        this.mShowAnimationSet = animationSet;
        animationSet.setAnimationListener(this.mShowAnimation);
        AnimationSet animationSet2 = this.mShowAnimationSet;
        AnimationSet animationSet3 = null;
        if (animationSet2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mShowAnimationSet");
            animationSet2 = null;
        }
        animationSet2.addAnimation(createAlphaAnimation(0.0f, 1.0f, 150L));
        AnimationSet animationSet4 = this.mShowAnimationSet;
        if (animationSet4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mShowAnimationSet");
            animationSet4 = null;
        }
        animationSet4.addAnimation(createScaleAnimation(0.95f, 1.0f, 250L));
        AnimationSet animationSet5 = new AnimationSet(false);
        this.mHideAnimationSet = animationSet5;
        animationSet5.setAnimationListener(this.mHideAnimation);
        AnimationSet animationSet6 = this.mHideAnimationSet;
        if (animationSet6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHideAnimationSet");
            animationSet6 = null;
        }
        animationSet6.addAnimation(createAlphaAnimation(1.0f, 0.0f, 150L));
        AnimationSet animationSet7 = this.mHideAnimationSet;
        if (animationSet7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHideAnimationSet");
        } else {
            animationSet3 = animationSet7;
        }
        animationSet3.addAnimation(createScaleAnimation(1.0f, 0.95f, 250L));
    }

    public final void cancelAnimation() {
        View view = this.mTargetView;
        if (view == null || view.getAnimation() == null) {
            return;
        }
        Log.i(TAG, " cancelAnimation()");
        this.mShowAnimationListener = null;
        this.mHideAnimationListener = null;
        view.clearAnimation();
        view.setAlpha(1.0f);
        view.setScaleX(1.0f);
        view.setScaleY(1.0f);
    }

    public final void close() {
        Log.i(TAG, "close()");
        View view = this.mTargetView;
        if (view != null) {
            view.clearAnimation();
        }
        this.mTargetView = null;
        this.mShowAnimationListener = null;
        this.mHideAnimationListener = null;
    }

    public final boolean hideAnimation(@Nullable Animation.AnimationListener listener) {
        Log.i(TAG, "hideAnimation() listener is ".concat(listener == null ? "NULL" : "NOT NULL"));
        View view = this.mTargetView;
        if (view == null) {
            return false;
        }
        this.mHideAnimationListener = listener;
        AnimationSet animationSet = this.mHideAnimationSet;
        if (animationSet == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHideAnimationSet");
            animationSet = null;
        }
        view.startAnimation(animationSet);
        return true;
    }

    public final boolean showAnimation(@Nullable Animation.AnimationListener listener) {
        Log.i(TAG, "showAnimation()");
        View view = this.mTargetView;
        if (view == null) {
            return false;
        }
        this.mShowAnimationListener = listener;
        AnimationSet animationSet = this.mShowAnimationSet;
        if (animationSet == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mShowAnimationSet");
            animationSet = null;
        }
        view.startAnimation(animationSet);
        return true;
    }
}
