package com.samsung.android.sesl.visualeffect.surfaceeffects.ripple;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.RequiresApi;
import androidx.appcompat.animation.C0421a;
import androidx.core.graphics.ColorUtils;
import com.samsung.android.sesl.visualeffect.surfaceeffects.ripple.RippleShader;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.apache.xmlbeans.XmlErrorCodes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001dH\u0007J\u0018\u0010!\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020\u001dH\u0007J\u0012\u0010$\u001a\u00020\u001b2\b\u0010%\u001a\u0004\u0018\u00010&H\u0015J\b\u0010'\u001a\u00020\u001bH\u0015J\b\u0010(\u001a\u00020\u001bH\u0007J0\u0010)\u001a\u00020\u001b2\b\b\u0002\u0010*\u001a\u00020\u001d2\b\b\u0002\u0010+\u001a\u00020\u001d2\b\b\u0002\u0010,\u001a\u00020\u001d2\b\b\u0002\u0010-\u001a\u00020\u001dH\u0007J0\u0010.\u001a\u00020\u001b2\b\b\u0002\u0010*\u001a\u00020\u001d2\b\b\u0002\u0010+\u001a\u00020\u001d2\b\b\u0002\u0010,\u001a\u00020\u001d2\b\b\u0002\u0010-\u001a\u00020\u001dH\u0007J0\u0010/\u001a\u00020\u001b2\b\b\u0002\u0010*\u001a\u00020\u001d2\b\b\u0002\u0010+\u001a\u00020\u001d2\b\b\u0002\u0010,\u001a\u00020\u001d2\b\b\u0002\u0010-\u001a\u00020\u001dH\u0007J0\u00100\u001a\u00020\u001b2\u0006\u00101\u001a\u0002022\u0006\u0010*\u001a\u00020\u001d2\u0006\u0010+\u001a\u00020\u001d2\u0006\u0010,\u001a\u00020\u001d2\u0006\u0010-\u001a\u00020\u001dH\u0002J\u0018\u00103\u001a\u00020\u001b2\u0006\u00104\u001a\u00020\u001d2\u0006\u00105\u001a\u00020\u001dH\u0007J!\u00106\u001a\u00020\u001b2\u0012\u00107\u001a\n\u0012\u0006\b\u0001\u0012\u00020908\"\u000209H\u0007¢\u0006\u0002\u0010:J\u0014\u0010;\u001a\u00020\u001b2\n\b\u0002\u0010<\u001a\u0004\u0018\u00010=H\u0007J\u001a\u0010>\u001a\u00020\u001b2\u0006\u0010?\u001a\u00020@2\b\b\u0002\u0010A\u001a\u00020@H\u0007J\u001a\u0010B\u001a\u00020\u001b2\u0006\u0010?\u001a\u00020@2\b\b\u0002\u0010A\u001a\u00020@H\u0007J\u0010\u0010C\u001a\u00020\u001b2\u0006\u0010D\u001a\u00020\u001dH\u0007J\u0006\u0010E\u001a\u00020FJ\u0010\u0010G\u001a\u00020\u001b2\u0006\u0010H\u001a\u00020IH\u0015R\u001a\u0010\b\u001a\u00020\tX\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u00020\u0011X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001f\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006J"}, m13886d2 = {"Lcom/samsung/android/sesl/visualeffect/surfaceeffects/ripple/RippleView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "rippleShader", "Lcom/samsung/android/sesl/visualeffect/surfaceeffects/ripple/RippleShader;", "getRippleShader", "()Lcom/samsung/android/sesl/visualeffect/surfaceeffects/ripple/RippleShader;", "setRippleShader", "(Lcom/samsung/android/sesl/visualeffect/surfaceeffects/ripple/RippleShader;)V", "ripplePaint", "Landroid/graphics/Paint;", "animator", "Landroid/animation/ValueAnimator;", "getAnimator", "()Landroid/animation/ValueAnimator;", XmlErrorCodes.DURATION, "", "getDuration", "()J", "setDuration", "(J)V", "setMaxSize", "", "maxWidth", "", "maxHeight", "centerX", "centerY", "setCenter", "x", "y", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onAttachedToWindow", "setupShader", "setBaseRingFadeParams", "fadeInStart", "fadeInEnd", "fadeOutStart", "fadeOutEnd", "setSparkleRingFadeParams", "setCenterFillFadeParams", "setFadeParams", "fadeParams", "Lcom/samsung/android/sesl/visualeffect/surfaceeffects/ripple/RippleShader$FadeParams;", "setBlur", "start", "end", "setSizeAtProgresses", "targetSizes", "", "Lcom/samsung/android/sesl/visualeffect/surfaceeffects/ripple/RippleShader$SizeAtProgress;", "([Lcom/samsung/android/sesl/visualeffect/surfaceeffects/ripple/RippleShader$SizeAtProgress;)V", "startRipple", "onAnimationEnd", "Ljava/lang/Runnable;", "setColor", "color", "", "alpha", "setSparkleColor", "setSparkleStrength", "strength", "rippleInProgress", "", "onDraw", "canvas", "Landroid/graphics/Canvas;", "sesl-visualeffect-INTERNAL-2.1.10_release"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public class RippleView extends View {

    @NotNull
    private final ValueAnimator animator;
    private float centerX;
    private float centerY;
    private long duration;

    @NotNull
    private final Paint ripplePaint;
    protected RippleShader rippleShader;

    public RippleView(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ripplePaint = new Paint();
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        Intrinsics.checkNotNullExpressionValue(valueAnimatorOfFloat, "ofFloat(...)");
        this.animator = valueAnimatorOfFloat;
        this.duration = 1750L;
    }

    public static /* synthetic */ void setBaseRingFadeParams$default(RippleView rippleView, float f, float f4, float f5, float f6, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setBaseRingFadeParams");
        }
        if ((i & 1) != 0) {
            f = rippleView.getRippleShader().getBaseRingFadeParams().getFadeInStart();
        }
        if ((i & 2) != 0) {
            f4 = rippleView.getRippleShader().getBaseRingFadeParams().getFadeInEnd();
        }
        if ((i & 4) != 0) {
            f5 = rippleView.getRippleShader().getBaseRingFadeParams().getFadeOutStart();
        }
        if ((i & 8) != 0) {
            f6 = rippleView.getRippleShader().getBaseRingFadeParams().getFadeOutEnd();
        }
        rippleView.setBaseRingFadeParams(f, f4, f5, f6);
    }

    public static /* synthetic */ void setCenterFillFadeParams$default(RippleView rippleView, float f, float f4, float f5, float f6, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setCenterFillFadeParams");
        }
        if ((i & 1) != 0) {
            f = rippleView.getRippleShader().getCenterFillFadeParams().getFadeInStart();
        }
        if ((i & 2) != 0) {
            f4 = rippleView.getRippleShader().getCenterFillFadeParams().getFadeInEnd();
        }
        if ((i & 4) != 0) {
            f5 = rippleView.getRippleShader().getCenterFillFadeParams().getFadeOutStart();
        }
        if ((i & 8) != 0) {
            f6 = rippleView.getRippleShader().getCenterFillFadeParams().getFadeOutEnd();
        }
        rippleView.setCenterFillFadeParams(f, f4, f5, f6);
    }

    public static /* synthetic */ void setColor$default(RippleView rippleView, int i, int i2, int i4, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setColor");
        }
        if ((i4 & 2) != 0) {
            i2 = 115;
        }
        rippleView.setColor(i, i2);
    }

    private final void setFadeParams(RippleShader.FadeParams fadeParams, float fadeInStart, float fadeInEnd, float fadeOutStart, float fadeOutEnd) {
        fadeParams.setFadeInStart(fadeInStart);
        fadeParams.setFadeInEnd(fadeInEnd);
        fadeParams.setFadeOutStart(fadeOutStart);
        fadeParams.setFadeOutEnd(fadeOutEnd);
    }

    public static /* synthetic */ void setSparkleColor$default(RippleView rippleView, int i, int i2, int i4, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setSparkleColor");
        }
        if ((i4 & 2) != 0) {
            i2 = 115;
        }
        rippleView.setSparkleColor(i, i2);
    }

    public static /* synthetic */ void setSparkleRingFadeParams$default(RippleView rippleView, float f, float f4, float f5, float f6, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setSparkleRingFadeParams");
        }
        if ((i & 1) != 0) {
            f = rippleView.getRippleShader().getSparkleRingFadeParams().getFadeInStart();
        }
        if ((i & 2) != 0) {
            f4 = rippleView.getRippleShader().getSparkleRingFadeParams().getFadeInEnd();
        }
        if ((i & 4) != 0) {
            f5 = rippleView.getRippleShader().getSparkleRingFadeParams().getFadeOutStart();
        }
        if ((i & 8) != 0) {
            f6 = rippleView.getRippleShader().getSparkleRingFadeParams().getFadeOutEnd();
        }
        rippleView.setSparkleRingFadeParams(f, f4, f5, f6);
    }

    public static /* synthetic */ void startRipple$default(RippleView rippleView, Runnable runnable, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: startRipple");
        }
        if ((i & 1) != 0) {
            runnable = null;
        }
        rippleView.startRipple(runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startRipple$lambda$1(RippleView rippleView, ValueAnimator updateListener) {
        Intrinsics.checkNotNullParameter(updateListener, "updateListener");
        long currentPlayTime = updateListener.getCurrentPlayTime();
        Object animatedValue = updateListener.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float fFloatValue = ((Float) animatedValue).floatValue();
        rippleView.getRippleShader().setRawProgress(fFloatValue);
        rippleView.getRippleShader().setDistortionStrength(1 - fFloatValue);
        rippleView.getRippleShader().setTime(currentPlayTime);
        rippleView.invalidate();
    }

    @NotNull
    public final ValueAnimator getAnimator() {
        return this.animator;
    }

    public final long getDuration() {
        return this.duration;
    }

    @NotNull
    public final RippleShader getRippleShader() {
        RippleShader rippleShader = this.rippleShader;
        if (rippleShader != null) {
            return rippleShader;
        }
        Intrinsics.throwUninitializedPropertyAccessException("rippleShader");
        return null;
    }

    @Override // android.view.View
    @RequiresApi(33)
    public void onAttachedToWindow() {
        getRippleShader().setPixelDensity(getResources().getDisplayMetrics().density);
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    @RequiresApi(33)
    public void onConfigurationChanged(@Nullable Configuration newConfig) {
        getRippleShader().setPixelDensity(getResources().getDisplayMetrics().density);
        super.onConfigurationChanged(newConfig);
    }

    @Override // android.view.View
    @RequiresApi(33)
    public void onDraw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (canvas.isHardwareAccelerated()) {
            canvas.drawCircle(this.centerX, this.centerY, getRippleShader().getRippleSize().getCurrentWidth(), this.ripplePaint);
        }
    }

    public final boolean rippleInProgress() {
        return this.animator.isRunning();
    }

    @JvmOverloads
    @RequiresApi(33)
    public final void setBaseRingFadeParams() {
        setBaseRingFadeParams$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
    }

    @RequiresApi(33)
    public final void setBlur(float start, float end) {
        getRippleShader().setBlurStart(start);
        getRippleShader().setBlurEnd(end);
    }

    @RequiresApi(33)
    public final void setCenter(float x, float y2) {
        this.centerX = x;
        this.centerY = y2;
        getRippleShader().setCenter(x, y2);
    }

    @JvmOverloads
    @RequiresApi(33)
    public final void setCenterFillFadeParams() {
        setCenterFillFadeParams$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
    }

    @RequiresApi(33)
    public final void setColor(int color, int alpha) {
        getRippleShader().setColor(ColorUtils.setAlphaComponent(color, alpha));
    }

    public final void setDuration(long j) {
        this.duration = j;
    }

    @RequiresApi(33)
    public final void setMaxSize(float maxWidth, float maxHeight) {
        getRippleShader().getRippleSize().setMaxSize(maxWidth, maxHeight);
    }

    public final void setRippleShader(@NotNull RippleShader rippleShader) {
        Intrinsics.checkNotNullParameter(rippleShader, "<set-?>");
        this.rippleShader = rippleShader;
    }

    @RequiresApi(33)
    public final void setSizeAtProgresses(@NotNull RippleShader.SizeAtProgress... targetSizes) {
        Intrinsics.checkNotNullParameter(targetSizes, "targetSizes");
        getRippleShader().getRippleSize().setSizeAtProgresses((RippleShader.SizeAtProgress[]) Arrays.copyOf(targetSizes, targetSizes.length));
    }

    @RequiresApi(33)
    public final void setSparkleColor(int color, int alpha) {
        getRippleShader().setSparkleColor(ColorUtils.setAlphaComponent(color, alpha));
    }

    @JvmOverloads
    @RequiresApi(33)
    public final void setSparkleRingFadeParams() {
        setSparkleRingFadeParams$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
    }

    @RequiresApi(33)
    public final void setSparkleStrength(float strength) {
        getRippleShader().setSparkleStrength(strength);
    }

    @RequiresApi(33)
    public final void setupShader() {
        setRippleShader(new RippleShader());
        getRippleShader().setColor(-1);
        getRippleShader().setSparkleColor(-1);
        getRippleShader().setRawProgress(0.0f);
        getRippleShader().setSparkleStrength(0.3f);
        getRippleShader().setPixelDensity(getResources().getDisplayMetrics().density);
        this.ripplePaint.setShader(getRippleShader());
    }

    @JvmOverloads
    @RequiresApi(33)
    public final void startRipple() {
        startRipple$default(this, null, 1, null);
    }

    @JvmOverloads
    @RequiresApi(33)
    public final void setBaseRingFadeParams(float f) {
        setBaseRingFadeParams$default(this, f, 0.0f, 0.0f, 0.0f, 14, null);
    }

    @JvmOverloads
    @RequiresApi(33)
    public final void setCenterFillFadeParams(float f) {
        setCenterFillFadeParams$default(this, f, 0.0f, 0.0f, 0.0f, 14, null);
    }

    @JvmOverloads
    @RequiresApi(33)
    public final void setSparkleRingFadeParams(float f) {
        setSparkleRingFadeParams$default(this, f, 0.0f, 0.0f, 0.0f, 14, null);
    }

    @JvmOverloads
    @RequiresApi(33)
    public final void startRipple(@Nullable final Runnable onAnimationEnd) {
        if (this.animator.isRunning()) {
            return;
        }
        this.animator.setDuration(this.duration);
        this.animator.addUpdateListener(new C0421a(this, 14));
        this.animator.addListener(new AnimatorListenerAdapter() { // from class: com.samsung.android.sesl.visualeffect.surfaceeffects.ripple.RippleView.startRipple.2
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

    @JvmOverloads
    @RequiresApi(33)
    public final void setBaseRingFadeParams(float f, float f4) {
        setBaseRingFadeParams$default(this, f, f4, 0.0f, 0.0f, 12, null);
    }

    @JvmOverloads
    @RequiresApi(33)
    public final void setCenterFillFadeParams(float f, float f4) {
        setCenterFillFadeParams$default(this, f, f4, 0.0f, 0.0f, 12, null);
    }

    @JvmOverloads
    @RequiresApi(33)
    public final void setSparkleRingFadeParams(float f, float f4) {
        setSparkleRingFadeParams$default(this, f, f4, 0.0f, 0.0f, 12, null);
    }

    @JvmOverloads
    @RequiresApi(33)
    public final void setBaseRingFadeParams(float f, float f4, float f5) {
        setBaseRingFadeParams$default(this, f, f4, f5, 0.0f, 8, null);
    }

    @JvmOverloads
    @RequiresApi(33)
    public final void setCenterFillFadeParams(float f, float f4, float f5) {
        setCenterFillFadeParams$default(this, f, f4, f5, 0.0f, 8, null);
    }

    @JvmOverloads
    @RequiresApi(33)
    public final void setSparkleRingFadeParams(float f, float f4, float f5) {
        setSparkleRingFadeParams$default(this, f, f4, f5, 0.0f, 8, null);
    }

    @JvmOverloads
    @RequiresApi(33)
    public final void setBaseRingFadeParams(float fadeInStart, float fadeInEnd, float fadeOutStart, float fadeOutEnd) {
        setFadeParams(getRippleShader().getBaseRingFadeParams(), fadeInStart, fadeInEnd, fadeOutStart, fadeOutEnd);
    }

    @JvmOverloads
    @RequiresApi(33)
    public final void setCenterFillFadeParams(float fadeInStart, float fadeInEnd, float fadeOutStart, float fadeOutEnd) {
        setFadeParams(getRippleShader().getCenterFillFadeParams(), fadeInStart, fadeInEnd, fadeOutStart, fadeOutEnd);
    }

    @JvmOverloads
    @RequiresApi(33)
    public final void setSparkleRingFadeParams(float fadeInStart, float fadeInEnd, float fadeOutStart, float fadeOutEnd) {
        setFadeParams(getRippleShader().getSparkleRingFadeParams(), fadeInStart, fadeInEnd, fadeOutStart, fadeOutEnd);
    }
}
