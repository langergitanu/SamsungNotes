package com.samsung.android.sesl.visualeffect.surfaceeffects.ripple;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.core.graphics.ColorUtils;
import com.samsung.android.sesl.visualeffect.lighteffects.guidinglight.C7854f;
import com.samsung.android.sesl.visualeffect.surfaceeffects.ripple.RippleShader;
import com.samsung.android.sesl.visualeffect.utils.EffectFrameRateHelper;
import com.samsung.android.support.senl.p148nt.data.common.constants.ExternalDataConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p123b3.C4202b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@RequiresApi(33)
@Metadata(m13885d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 #2\u00020\u0001:\u0001#B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0012\u001a\u00020\u0013J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0007H\u0007J\b\u0010\u0016\u001a\u00020\u0013H\u0007J \u0010\u0017\u001a\u00020\u00132\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0007J\u0006\u0010\u001b\u001a\u00020\u001cJ\b\u0010\u001d\u001a\u00020\u0013H\u0003J\u001a\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010 H\u0002J\b\u0010\"\u001a\u00020\u0013H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, m13886d2 = {"Lcom/samsung/android/sesl/visualeffect/surfaceeffects/ripple/RippleAnimation;", "", ExternalDataConstants.EmbeddingConfig.KEY, "Lcom/samsung/android/sesl/visualeffect/surfaceeffects/ripple/RippleAnimationConfig;", "<init>", "(Lcom/samsung/android/sesl/visualeffect/surfaceeffects/ripple/RippleAnimationConfig;)V", "frameCount", "", "startFrameTime", "", "rippleShader", "Lcom/samsung/android/sesl/visualeffect/surfaceeffects/ripple/RippleShader;", "getRippleShader$annotations", "()V", "getRippleShader", "()Lcom/samsung/android/sesl/visualeffect/surfaceeffects/ripple/RippleShader;", "animator", "Landroid/animation/ValueAnimator;", "updateConfigs", "", "updateColor", "color", "updateSparkleColor", "play", "onAnimationEnd", "Ljava/lang/Runnable;", "onAnimationCancel", "isPlaying", "", "applyConfigToShader", "assignFadeParams", "destFadeParams", "Lcom/samsung/android/sesl/visualeffect/surfaceeffects/ripple/RippleShader$FadeParams;", "srcFadeParams", "logFrameRate", "Companion", "sesl-visualeffect-INTERNAL-2.1.10_release"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nRippleAnimation.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RippleAnimation.kt\ncom/samsung/android/sesl/visualeffect/surfaceeffects/ripple/RippleAnimation\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,175:1\n1#2:176\n*E\n"})
public final class RippleAnimation {
    private static final boolean FRAMERATE_DEBUG = false;
    private static final float MS_TO_SEC = 0.001f;

    @NotNull
    private static final String TAG = "RippleAnimation";

    @NotNull
    private ValueAnimator animator;

    @NotNull
    private final RippleAnimationConfig config;
    private int frameCount;

    @RequiresApi(33)
    @NotNull
    private final RippleShader rippleShader;
    private long startFrameTime;

    public RippleAnimation(@NotNull RippleAnimationConfig config) {
        Intrinsics.checkNotNullParameter(config, "config");
        this.config = config;
        this.rippleShader = new RippleShader();
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        Intrinsics.checkNotNullExpressionValue(valueAnimatorOfFloat, "ofFloat(...)");
        this.animator = valueAnimatorOfFloat;
        applyConfigToShader();
    }

    @RequiresApi(33)
    private final void applyConfigToShader() {
        RippleShader rippleShader = this.rippleShader;
        rippleShader.setCenter(this.config.getCenterX(), this.config.getCenterY());
        rippleShader.getRippleSize().setMaxSize(this.config.getScale() * this.config.getMaxWidth(), this.config.getScale() * this.config.getMaxHeight());
        rippleShader.setPixelDensity(this.config.getPixelDensity());
        rippleShader.setColor(ColorUtils.setAlphaComponent(this.config.getColor(), this.config.getOpacity()));
        rippleShader.setSparkleColor(this.config.getSparkleColor());
        rippleShader.setSparkleStrength(this.config.getSparkleStrength());
        assignFadeParams(rippleShader.getBaseRingFadeParams(), this.config.getBaseRingFadeParams());
        assignFadeParams(rippleShader.getSparkleRingFadeParams(), this.config.getSparkleRingFadeParams());
        assignFadeParams(rippleShader.getCenterFillFadeParams(), this.config.getCenterFillFadeParams());
    }

    private final void assignFadeParams(RippleShader.FadeParams destFadeParams, RippleShader.FadeParams srcFadeParams) {
        if (srcFadeParams != null) {
            destFadeParams.setFadeInStart(srcFadeParams.getFadeInStart());
            destFadeParams.setFadeInEnd(srcFadeParams.getFadeInEnd());
            destFadeParams.setFadeOutStart(srcFadeParams.getFadeOutStart());
            destFadeParams.setFadeOutEnd(srcFadeParams.getFadeOutEnd());
        }
    }

    @VisibleForTesting(otherwise = 3)
    public static /* synthetic */ void getRippleShader$annotations() {
    }

    private final void logFrameRate() {
    }

    public static /* synthetic */ void play$default(RippleAnimation rippleAnimation, Runnable runnable, Runnable runnable2, int i, Object obj) {
        if ((i & 1) != 0) {
            runnable = null;
        }
        if ((i & 2) != 0) {
            runnable2 = runnable;
        }
        rippleAnimation.play(runnable, runnable2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void play$lambda$2(RippleAnimation rippleAnimation, float f, float f4, ValueAnimator anim) {
        Intrinsics.checkNotNullParameter(anim, "anim");
        float currentPlayTime = anim.getCurrentPlayTime() * 0.001f;
        rippleAnimation.rippleShader.setMove((rippleAnimation.config.getMoveSpeedX() * currentPlayTime) + f, (rippleAnimation.config.getMoveSpeedY() * currentPlayTime) + f4);
        long currentPlayTime2 = anim.getCurrentPlayTime();
        Object animatedValue = anim.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float fFloatValue = ((Float) animatedValue).floatValue();
        rippleAnimation.rippleShader.setRawProgress(fFloatValue);
        rippleAnimation.rippleShader.setDistortionStrength(rippleAnimation.config.getShouldDistort() ? 1 - fFloatValue : 0.0f);
        rippleAnimation.rippleShader.setTime(currentPlayTime2);
        if (rippleAnimation.config.getHintSparkleOnly() && rippleAnimation.rippleShader.getSparkleDisappearedState()) {
            rippleAnimation.animator.cancel();
        }
        rippleAnimation.logFrameRate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit play$lambda$3(ValueAnimator.AnimatorUpdateListener animatorUpdateListener, ValueAnimator animator) {
        Intrinsics.checkNotNullParameter(animator, "animator");
        animatorUpdateListener.onAnimationUpdate(animator);
        return Unit.INSTANCE;
    }

    @NotNull
    public final RippleShader getRippleShader() {
        return this.rippleShader;
    }

    public final boolean isPlaying() {
        return this.animator.isRunning();
    }

    @JvmOverloads
    @RequiresApi(33)
    public final void play() {
        play$default(this, null, null, 3, null);
    }

    @RequiresApi(33)
    public final void updateColor(int color) {
        this.config.setColor(color);
        applyConfigToShader();
    }

    public final void updateConfigs() {
        applyConfigToShader();
    }

    @RequiresApi(33)
    public final void updateSparkleColor() {
        RippleAnimationConfig rippleAnimationConfig = this.config;
        rippleAnimationConfig.setSparkleColor(rippleAnimationConfig.getColor());
        applyConfigToShader();
    }

    @JvmOverloads
    @RequiresApi(33)
    public final void play(@Nullable Runnable runnable) {
        play$default(this, runnable, null, 2, null);
    }

    @JvmOverloads
    @RequiresApi(33)
    public final void play(@Nullable final Runnable onAnimationEnd, @Nullable final Runnable onAnimationCancel) {
        if (isPlaying()) {
            return;
        }
        if (this.config.isReverse()) {
            this.animator = ValueAnimator.ofFloat(1.0f, 0.0f);
        }
        this.animator.setInterpolator(this.config.getInterpolator());
        this.animator.setDuration(this.config.getDuration());
        ValueAnimator.AnimatorUpdateListener c7854f = new C7854f(this.config.getCenterX(), this.config.getCenterY(), 5, this);
        if (this.config.getRequestedFrameRate() != null && !EffectFrameRateHelper.INSTANCE.isViewFrameRateUpdateAvailable()) {
            c7854f = new EffectFrameRateHelper.FrameRateAnimatorUpdateListener(this.config.getRequestedFrameRate().floatValue(), new C4202b(c7854f, 4));
        }
        this.animator.addUpdateListener(c7854f);
        this.animator.addListener(new AnimatorListenerAdapter() { // from class: com.samsung.android.sesl.visualeffect.surfaceeffects.ripple.RippleAnimation.play.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                super.onAnimationCancel(animation);
                Runnable runnable = onAnimationCancel;
                if (runnable != null) {
                    runnable.run();
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                Runnable runnable = onAnimationEnd;
                if (runnable != null) {
                    runnable.run();
                }
            }
        });
        this.animator.start();
    }
}
