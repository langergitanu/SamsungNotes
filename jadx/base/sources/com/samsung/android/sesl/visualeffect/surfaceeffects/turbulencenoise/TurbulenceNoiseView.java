package com.samsung.android.sesl.visualeffect.surfaceeffects.turbulencenoise;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.core.graphics.ColorUtils;
import com.samsung.android.support.senl.p148nt.data.common.constants.ExternalDataConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\n\u0018\u0000 12\u00020\u0001:\u00011B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0015J\u0015\u0010\u001f\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020!H\u0001¢\u0006\u0002\b\"J\u0014\u0010#\u001a\u00020\u001c2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010%H\u0007J(\u0010&\u001a\u00020\u001c2\b\b\u0002\u0010'\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020(2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010%H\u0007J\u0014\u0010*\u001a\u00020\u001c2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010%H\u0007J\u0014\u0010+\u001a\u00020\u001c2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010%H\u0007J\u0010\u0010-\u001a\u00020\u001c2\u0006\u0010.\u001a\u00020\rH\u0007J\r\u0010/\u001a\u00020\u001cH\u0000¢\u0006\u0002\b0R\u0010\u0010\b\u001a\u00020\t8\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\u000b8\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R&\u0010\f\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R&\u0010\u0014\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0016\u0010\u000f\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u00062"}, m13886d2 = {"Lcom/samsung/android/sesl/visualeffect/surfaceeffects/turbulencenoise/TurbulenceNoiseView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "turbulenceNoiseShader", "Lcom/samsung/android/sesl/visualeffect/surfaceeffects/turbulencenoise/TurbulenceNoiseShader;", "paint", "Landroid/graphics/Paint;", "noiseConfig", "Lcom/samsung/android/sesl/visualeffect/surfaceeffects/turbulencenoise/TurbulenceNoiseAnimationConfig;", "getNoiseConfig$annotations", "()V", "getNoiseConfig", "()Lcom/samsung/android/sesl/visualeffect/surfaceeffects/turbulencenoise/TurbulenceNoiseAnimationConfig;", "setNoiseConfig", "(Lcom/samsung/android/sesl/visualeffect/surfaceeffects/turbulencenoise/TurbulenceNoiseAnimationConfig;)V", "currentAnimator", "Landroid/animation/ValueAnimator;", "getCurrentAnimator$annotations", "getCurrentAnimator", "()Landroid/animation/ValueAnimator;", "setCurrentAnimator", "(Landroid/animation/ValueAnimator;)V", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "updateColor", "color", "", "updateColor$sesl_visualeffect_INTERNAL_2_1_10_release", "play", "onAnimationEnd", "Ljava/lang/Runnable;", "playEaseIn", "offsetX", "", "offsetY", "playEaseOut", "finish", "nextAnimation", "applyConfig", ExternalDataConstants.EmbeddingConfig.KEY, "clearConfig", "clearConfig$sesl_visualeffect_INTERNAL_2_1_10_release", "Companion", "sesl-visualeffect-INTERNAL-2.1.10_release"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nTurbulenceNoiseView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TurbulenceNoiseView.kt\ncom/samsung/android/sesl/visualeffect/surfaceeffects/turbulencenoise/TurbulenceNoiseView\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,236:1\n1#2:237\n*E\n"})
public final class TurbulenceNoiseView extends View {
    private static final float MS_TO_SEC = 0.001f;

    @Nullable
    private ValueAnimator currentAnimator;

    @Nullable
    private TurbulenceNoiseAnimationConfig noiseConfig;

    @RequiresApi(33)
    @NotNull
    private final Paint paint;

    @RequiresApi(33)
    @NotNull
    private final TurbulenceNoiseShader turbulenceNoiseShader;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TurbulenceNoiseView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        TurbulenceNoiseShader turbulenceNoiseShader = new TurbulenceNoiseShader(false, 1, null);
        this.turbulenceNoiseShader = turbulenceNoiseShader;
        Paint paint = new Paint();
        paint.setShader(turbulenceNoiseShader);
        this.paint = paint;
    }

    public static /* synthetic */ void finish$default(TurbulenceNoiseView turbulenceNoiseView, Runnable runnable, int i, Object obj) {
        if ((i & 1) != 0) {
            runnable = null;
        }
        turbulenceNoiseView.finish(runnable);
    }

    @VisibleForTesting
    public static /* synthetic */ void getCurrentAnimator$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getNoiseConfig$annotations() {
    }

    public static /* synthetic */ void play$default(TurbulenceNoiseView turbulenceNoiseView, Runnable runnable, int i, Object obj) {
        if ((i & 1) != 0) {
            runnable = null;
        }
        turbulenceNoiseView.play(runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void play$lambda$2(TurbulenceNoiseView turbulenceNoiseView, float f, TurbulenceNoiseAnimationConfig turbulenceNoiseAnimationConfig, float f4, float f5, ValueAnimator updateListener) {
        Intrinsics.checkNotNullParameter(updateListener, "updateListener");
        float currentPlayTime = updateListener.getCurrentPlayTime() * 0.001f;
        turbulenceNoiseView.turbulenceNoiseShader.setNoiseMove((turbulenceNoiseAnimationConfig.getNoiseMoveSpeedX() * currentPlayTime) + f, (turbulenceNoiseAnimationConfig.getNoiseMoveSpeedY() * currentPlayTime) + f4, (turbulenceNoiseAnimationConfig.getNoiseMoveSpeedZ() * currentPlayTime) + f5);
        turbulenceNoiseView.turbulenceNoiseShader.setOpacity(turbulenceNoiseAnimationConfig.getLuminosityMultiplier());
        turbulenceNoiseView.invalidate();
    }

    public static /* synthetic */ void playEaseIn$default(TurbulenceNoiseView turbulenceNoiseView, float f, float f4, Runnable runnable, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 0.0f;
        }
        if ((i & 2) != 0) {
            f4 = 0.0f;
        }
        if ((i & 4) != 0) {
            runnable = null;
        }
        turbulenceNoiseView.playEaseIn(f, f4, runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void playEaseIn$lambda$3(TurbulenceNoiseView turbulenceNoiseView, float f, float f4, TurbulenceNoiseAnimationConfig turbulenceNoiseAnimationConfig, float f5, float f6, float f7, ValueAnimator updateListener) {
        Intrinsics.checkNotNullParameter(updateListener, "updateListener");
        float currentPlayTime = updateListener.getCurrentPlayTime() * 0.001f;
        Object animatedValue = updateListener.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float fFloatValue = ((Float) animatedValue).floatValue();
        turbulenceNoiseView.turbulenceNoiseShader.setNoiseMove((turbulenceNoiseAnimationConfig.getNoiseMoveSpeedX() * currentPlayTime) + f + f4, (turbulenceNoiseAnimationConfig.getNoiseMoveSpeedY() * currentPlayTime) + f5 + f6, (turbulenceNoiseAnimationConfig.getNoiseMoveSpeedZ() * currentPlayTime) + f7);
        turbulenceNoiseView.turbulenceNoiseShader.setOpacity(turbulenceNoiseAnimationConfig.getLuminosityMultiplier() * fFloatValue);
        turbulenceNoiseView.invalidate();
    }

    public static /* synthetic */ void playEaseOut$default(TurbulenceNoiseView turbulenceNoiseView, Runnable runnable, int i, Object obj) {
        if ((i & 1) != 0) {
            runnable = null;
        }
        turbulenceNoiseView.playEaseOut(runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void playEaseOut$lambda$4(TurbulenceNoiseView turbulenceNoiseView, float f, TurbulenceNoiseAnimationConfig turbulenceNoiseAnimationConfig, float f4, float f5, ValueAnimator updateListener) {
        Intrinsics.checkNotNullParameter(updateListener, "updateListener");
        float currentPlayTime = updateListener.getCurrentPlayTime() * 0.001f;
        Object animatedValue = updateListener.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float fFloatValue = ((Float) animatedValue).floatValue();
        turbulenceNoiseView.turbulenceNoiseShader.setNoiseMove((turbulenceNoiseAnimationConfig.getNoiseMoveSpeedX() * currentPlayTime) + f, (turbulenceNoiseAnimationConfig.getNoiseMoveSpeedY() * currentPlayTime) + f4, (turbulenceNoiseAnimationConfig.getNoiseMoveSpeedZ() * currentPlayTime) + f5);
        turbulenceNoiseView.turbulenceNoiseShader.setOpacity(turbulenceNoiseAnimationConfig.getLuminosityMultiplier() * (1.0f - fFloatValue));
        turbulenceNoiseView.invalidate();
    }

    @RequiresApi(33)
    @VisibleForTesting(otherwise = 3)
    public final void applyConfig(@NotNull TurbulenceNoiseAnimationConfig config) {
        Intrinsics.checkNotNullParameter(config, "config");
        this.noiseConfig = config;
        TurbulenceNoiseShader turbulenceNoiseShader = this.turbulenceNoiseShader;
        turbulenceNoiseShader.setGridCount(config.getGridCount());
        turbulenceNoiseShader.setColor(config.getColor());
        turbulenceNoiseShader.setBackgroundColor(config.getBackgroundColor());
        turbulenceNoiseShader.setSize(config.getWidth(), config.getHeight());
        turbulenceNoiseShader.setPixelDensity(config.getPixelDensity());
        turbulenceNoiseShader.setInverseNoiseLuminosity(false);
        turbulenceNoiseShader.setLumaMatteFactors(config.getLumaMatteBlendFactor(), config.getLumaMatteOverallBrightness());
        this.paint.setBlendMode(config.getBlendMode());
    }

    public final void clearConfig$sesl_visualeffect_INTERNAL_2_1_10_release() {
        this.noiseConfig = null;
    }

    @VisibleForTesting(otherwise = 3)
    public final void finish(@Nullable Runnable nextAnimation) {
        ValueAnimator valueAnimator = this.currentAnimator;
        if (valueAnimator != null) {
            valueAnimator.pause();
        }
        this.currentAnimator = null;
        if (nextAnimation != null) {
            nextAnimation.run();
        }
    }

    @Nullable
    public final ValueAnimator getCurrentAnimator() {
        return this.currentAnimator;
    }

    @Nullable
    public final TurbulenceNoiseAnimationConfig getNoiseConfig() {
        return this.noiseConfig;
    }

    @Override // android.view.View
    @RequiresApi(33)
    public void onDraw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (canvas.isHardwareAccelerated()) {
            canvas.drawPaint(this.paint);
        }
    }

    @RequiresApi(33)
    @VisibleForTesting(otherwise = 3)
    public final void play(@Nullable final Runnable onAnimationEnd) {
        TurbulenceNoiseAnimationConfig turbulenceNoiseAnimationConfig = this.noiseConfig;
        if (turbulenceNoiseAnimationConfig == null) {
            return;
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.setDuration((long) turbulenceNoiseAnimationConfig.getMaxDuration());
        valueAnimatorOfFloat.addUpdateListener(new C7896c(this, this.turbulenceNoiseShader.getNoiseOffsetX(), turbulenceNoiseAnimationConfig, this.turbulenceNoiseShader.getNoiseOffsetY(), this.turbulenceNoiseShader.getNoiseOffsetZ(), 0));
        valueAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: com.samsung.android.sesl.visualeffect.surfaceeffects.turbulencenoise.TurbulenceNoiseView.play.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                TurbulenceNoiseView.this.setCurrentAnimator(null);
                Runnable runnable = onAnimationEnd;
                if (runnable != null) {
                    runnable.run();
                }
            }
        });
        valueAnimatorOfFloat.start();
        this.currentAnimator = valueAnimatorOfFloat;
    }

    @RequiresApi(33)
    @VisibleForTesting(otherwise = 3)
    public final void playEaseIn(final float offsetX, final float offsetY, @Nullable final Runnable onAnimationEnd) {
        final TurbulenceNoiseAnimationConfig turbulenceNoiseAnimationConfig = this.noiseConfig;
        if (turbulenceNoiseAnimationConfig == null) {
            return;
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.setDuration((long) turbulenceNoiseAnimationConfig.getEaseInDuration());
        final float noiseOffsetX = this.turbulenceNoiseShader.getNoiseOffsetX();
        final float noiseOffsetY = this.turbulenceNoiseShader.getNoiseOffsetY();
        final float noiseOffsetZ = this.turbulenceNoiseShader.getNoiseOffsetZ();
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.samsung.android.sesl.visualeffect.surfaceeffects.turbulencenoise.d
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                TurbulenceNoiseView.playEaseIn$lambda$3(this.f5396a, offsetX, noiseOffsetX, turbulenceNoiseAnimationConfig, offsetY, noiseOffsetY, noiseOffsetZ, valueAnimator);
            }
        });
        valueAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: com.samsung.android.sesl.visualeffect.surfaceeffects.turbulencenoise.TurbulenceNoiseView.playEaseIn.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                TurbulenceNoiseView.this.setCurrentAnimator(null);
                Runnable runnable = onAnimationEnd;
                if (runnable != null) {
                    runnable.run();
                }
            }
        });
        valueAnimatorOfFloat.start();
        this.currentAnimator = valueAnimatorOfFloat;
    }

    @RequiresApi(33)
    @VisibleForTesting(otherwise = 3)
    public final void playEaseOut(@Nullable final Runnable onAnimationEnd) {
        TurbulenceNoiseAnimationConfig turbulenceNoiseAnimationConfig = this.noiseConfig;
        if (turbulenceNoiseAnimationConfig == null) {
            return;
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.setDuration((long) turbulenceNoiseAnimationConfig.getEaseOutDuration());
        valueAnimatorOfFloat.addUpdateListener(new C7896c(this, this.turbulenceNoiseShader.getNoiseOffsetX(), turbulenceNoiseAnimationConfig, this.turbulenceNoiseShader.getNoiseOffsetY(), this.turbulenceNoiseShader.getNoiseOffsetZ(), 1));
        valueAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: com.samsung.android.sesl.visualeffect.surfaceeffects.turbulencenoise.TurbulenceNoiseView.playEaseOut.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                TurbulenceNoiseView.this.setCurrentAnimator(null);
                Runnable runnable = onAnimationEnd;
                if (runnable != null) {
                    runnable.run();
                }
            }
        });
        valueAnimatorOfFloat.start();
        this.currentAnimator = valueAnimatorOfFloat;
    }

    public final void setCurrentAnimator(@Nullable ValueAnimator valueAnimator) {
        this.currentAnimator = valueAnimator;
    }

    public final void setNoiseConfig(@Nullable TurbulenceNoiseAnimationConfig turbulenceNoiseAnimationConfig) {
        this.noiseConfig = turbulenceNoiseAnimationConfig;
    }

    @RequiresApi(33)
    public final void updateColor$sesl_visualeffect_INTERNAL_2_1_10_release(int color) {
        TurbulenceNoiseAnimationConfig turbulenceNoiseAnimationConfig = this.noiseConfig;
        if (turbulenceNoiseAnimationConfig != null) {
            this.turbulenceNoiseShader.setColor(ColorUtils.setAlphaComponent(color, turbulenceNoiseAnimationConfig.getOpacity()));
        }
    }
}
