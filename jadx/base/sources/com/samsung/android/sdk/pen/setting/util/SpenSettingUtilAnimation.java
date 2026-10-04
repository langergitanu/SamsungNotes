package com.samsung.android.sdk.pen.setting.util;

import android.animation.Animator;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.PathInterpolator;
import android.view.animation.ScaleAnimation;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.FloatPropertyCompat;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.apache.xmlbeans.XmlErrorCodes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0007JB\u0010\u0018\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u001cH\u0007J,\u0010!\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u001d\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u001c2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0007J,\u0010$\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u001c2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0007J.\u0010%\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010&\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u001c2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010'H\u0007J,\u0010(\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010&\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u001c2\b\u0010\"\u001a\u0004\u0018\u00010'H\u0007J,\u0010)\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010&\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u001c2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0007J,\u0010*\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010&\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u001c2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0007J\u0010\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u0005H\u0007JH\u0010.\u001a\u00020/2\u0006\u0010\u0016\u001a\u00020\u00172\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u0017012\u0006\u00102\u001a\u00020\u001a2\u0006\u00103\u001a\u00020\u001a2\u0006\u00104\u001a\u00020\u001a2\u0006\u00105\u001a\u00020\u001a2\n\b\u0002\u00106\u001a\u0004\u0018\u000107R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u00068"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/util/SpenSettingUtilAnimation;", "", "<init>", "()V", "DEFAULT_INTERPOLATOR", "", "SINE_IN_OUT_33", "SINE_IN_OUT_60", "SINE_IN_OUT_70", "SINE_IN_OUT_80", "SINE_IN_OUT_90", "SINE_OUT_60", "SINE_OUT_70", "SIN_IN_90", "CUSTOM_INTERPOLATOR_BRUSH_SELECT", "CUSTOM_INTERPOLATOR_BRUSH_TRANSITION", "CUSTOM_INTERPOLATOR_LINEAR", "CUSTOM_INTERPOLATOR_PEN_PREVIEW", "CUSTOM_INTERPOLATOR_RECOIL_RELEASE", "CUSTOM_INTERPOLATOR_ONE_EASING", "colorSelectAnimation", "", "view", "Landroid/view/View;", "scaleUpDownAnimation", "upScale", "", "upDuration", "", "upInterpolator", "downDuration", "downInterpolator", XmlErrorCodes.DURATION, "scaleUpVisibleAnimator", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Landroid/animation/Animator$AnimatorListener;", "scaleDownGoneAnimator", "alphaVisibleAnimation", "interpolator", "Landroid/view/animation/Animation$AnimationListener;", "alphaGoneAnimation", "alphaVisibleAnimator", "alphaGoneAnimator", "getInterpolator", "Landroid/view/animation/PathInterpolator;", "type", "startSpringAnimation", "Landroidx/dynamicanimation/animation/SpringAnimation;", "property", "Landroidx/dynamicanimation/animation/FloatPropertyCompat;", "startValue", "dampingRatio", "stiffness", "finalPosition", "endListener", "Landroidx/dynamicanimation/animation/DynamicAnimation$OnAnimationEndListener;", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenSettingUtilAnimation {
    public static final int CUSTOM_INTERPOLATOR_BRUSH_SELECT = 11;
    public static final int CUSTOM_INTERPOLATOR_BRUSH_TRANSITION = 12;
    public static final int CUSTOM_INTERPOLATOR_LINEAR = 15;
    public static final int CUSTOM_INTERPOLATOR_ONE_EASING = 20;
    public static final int CUSTOM_INTERPOLATOR_PEN_PREVIEW = 18;
    public static final int CUSTOM_INTERPOLATOR_RECOIL_RELEASE = 19;
    public static final int DEFAULT_INTERPOLATOR = 0;

    @NotNull
    public static final SpenSettingUtilAnimation INSTANCE = new SpenSettingUtilAnimation();
    public static final int SINE_IN_OUT_33 = 1;
    public static final int SINE_IN_OUT_60 = 2;
    public static final int SINE_IN_OUT_70 = 3;
    public static final int SINE_IN_OUT_80 = 4;
    public static final int SINE_IN_OUT_90 = 5;
    public static final int SINE_OUT_60 = 6;
    public static final int SINE_OUT_70 = 7;
    public static final int SIN_IN_90 = 8;

    private SpenSettingUtilAnimation() {
    }

    @JvmStatic
    public static final void alphaGoneAnimation(@Nullable View view, int interpolator, long duration, @Nullable Animation.AnimationListener listener) {
        if (view == null) {
            return;
        }
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(duration);
        alphaAnimation.setInterpolator(getInterpolator(interpolator));
        alphaAnimation.setAnimationListener(listener);
        view.startAnimation(alphaAnimation);
    }

    @JvmStatic
    public static final void alphaGoneAnimator(@Nullable View view, int interpolator, long duration, @Nullable Animator.AnimatorListener listener) {
        if (view == null) {
            return;
        }
        view.setAlpha(1.0f);
        view.animate().alpha(0.0f).setListener(listener).setInterpolator(getInterpolator(interpolator)).setDuration(duration).start();
    }

    @JvmStatic
    @JvmOverloads
    public static final void alphaVisibleAnimation(@Nullable View view, int i, long j) {
        alphaVisibleAnimation$default(view, i, j, null, 8, null);
    }

    public static /* synthetic */ void alphaVisibleAnimation$default(View view, int i, long j, Animation.AnimationListener animationListener, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            animationListener = null;
        }
        alphaVisibleAnimation(view, i, j, animationListener);
    }

    @JvmStatic
    public static final void alphaVisibleAnimator(@Nullable View view, int interpolator, long duration, @Nullable Animator.AnimatorListener listener) {
        if (view == null) {
            return;
        }
        view.setAlpha(0.0f);
        view.animate().alpha(1.0f).setListener(listener).setInterpolator(getInterpolator(interpolator)).setDuration(duration).start();
    }

    @JvmStatic
    public static final void colorSelectAnimation(@Nullable View view) {
        if (view == null) {
            return;
        }
        view.measure(0, 0);
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.1f, 1.0f, 0.1f, 1.0f, view.getMeasuredWidth() / 2.0f, view.getMeasuredWidth() / 2.0f);
        scaleAnimation.setDuration(300L);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(200L);
        scaleAnimation.setInterpolator(new PathInterpolator(0.09f, 0.91f, 0.46f, 1.34f));
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(scaleAnimation);
        animationSet.addAnimation(alphaAnimation);
        view.startAnimation(animationSet);
    }

    @JvmStatic
    @NotNull
    public static final PathInterpolator getInterpolator(int type) {
        switch (type) {
            case 1:
                return new PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
            case 2:
                return new PathInterpolator(0.33f, 0.0f, 0.4f, 1.0f);
            case 3:
                return new PathInterpolator(0.33f, 0.0f, 0.3f, 1.0f);
            case 4:
                return new PathInterpolator(0.33f, 0.0f, 0.2f, 1.0f);
            case 5:
                return new PathInterpolator(0.33f, 0.0f, 0.1f, 1.0f);
            case 6:
                return new PathInterpolator(0.17f, 0.17f, 0.4f, 1.0f);
            case 7:
                return new PathInterpolator(0.17f, 0.17f, 0.3f, 1.0f);
            case 8:
                return new PathInterpolator(0.9f, 0.0f, 0.83f, 0.83f);
            case 9:
            case 10:
            case 13:
            case 14:
            case 16:
            case 17:
            default:
                return new PathInterpolator(0.33f, 0.0f, 0.67f, 1.0f);
            case 11:
                return new PathInterpolator(0.22f, 0.25f, 0.0f, 1.0f);
            case 12:
                return new PathInterpolator(0.4f, 0.6f, 0.0f, 1.0f);
            case 15:
                return new PathInterpolator(0.0f, 0.0f, 1.0f, 1.0f);
            case 18:
                return new PathInterpolator(0.33f, 0.0f, 0.4f, 1.0f);
            case 19:
                return new PathInterpolator(0.17f, 0.17f, 0.67f, 1.0f);
            case 20:
                return new PathInterpolator(0.22f, 0.25f, 0.0f, 1.0f);
        }
    }

    @JvmStatic
    public static final void scaleDownGoneAnimator(@Nullable View view, int downInterpolator, long duration, @Nullable Animator.AnimatorListener listener) {
        if (view == null) {
            return;
        }
        view.setScaleX(1.0f);
        view.setScaleY(1.0f);
        view.animate().scaleX(0.0f).scaleY(0.0f).setListener(listener).setInterpolator(getInterpolator(downInterpolator)).setDuration(duration).start();
    }

    @JvmStatic
    public static final void scaleUpDownAnimation(@Nullable View view, float upScale, long upDuration, int upInterpolator, long downDuration, int downInterpolator, long duration) {
        if (view == null) {
            return;
        }
        view.measure(0, 0);
        float f = 1.0f / upScale;
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, upScale, 1.0f, upScale, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(upDuration);
        scaleAnimation.setInterpolator(getInterpolator(upInterpolator));
        ScaleAnimation scaleAnimation2 = new ScaleAnimation(1.0f, f, 1.0f, f, 1, 0.5f, 1, 0.5f);
        scaleAnimation2.setDuration(downDuration);
        scaleAnimation2.setInterpolator(getInterpolator(downInterpolator));
        scaleAnimation2.setStartOffset(upDuration + duration);
        AnimationSet animationSet = new AnimationSet(false);
        animationSet.addAnimation(scaleAnimation);
        animationSet.addAnimation(scaleAnimation2);
        view.startAnimation(animationSet);
    }

    @JvmStatic
    public static final void scaleUpVisibleAnimator(@Nullable View view, int upInterpolator, long duration, @Nullable Animator.AnimatorListener listener) {
        if (view == null) {
            return;
        }
        view.setScaleX(0.0f);
        view.setScaleY(0.0f);
        view.animate().scaleX(1.0f).scaleY(1.0f).setListener(listener).setInterpolator(getInterpolator(upInterpolator)).setDuration(duration).start();
    }

    @NotNull
    public final SpringAnimation startSpringAnimation(@NotNull View view, @NotNull FloatPropertyCompat<View> property, float startValue, float dampingRatio, float stiffness, float finalPosition, @Nullable DynamicAnimation.OnAnimationEndListener endListener) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(property, "property");
        SpringAnimation springAnimation = new SpringAnimation(view, property);
        SpringForce springForce = new SpringForce();
        springAnimation.setStartValue(startValue);
        springForce.setDampingRatio(dampingRatio);
        springForce.setStiffness(stiffness);
        springForce.setFinalPosition(finalPosition);
        springAnimation.setSpring(springForce);
        springAnimation.addEndListener(endListener);
        springAnimation.start();
        return springAnimation;
    }

    @JvmStatic
    @JvmOverloads
    public static final void alphaVisibleAnimation(@Nullable View view, int interpolator, long duration, @Nullable Animation.AnimationListener listener) {
        if (view == null) {
            return;
        }
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(duration);
        alphaAnimation.setInterpolator(getInterpolator(interpolator));
        alphaAnimation.setAnimationListener(listener);
        view.startAnimation(alphaAnimation);
    }
}
