package com.samsung.android.sesl.visualeffect.lighteffects.transitionlight;

import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.graphics.PointF;
import androidx.annotation.RequiresApi;
import com.samsung.android.sesl.visualeffect.lighteffects.common.control.VibeEffectBase;
import com.samsung.android.sesl.visualeffect.lighteffects.transitionlight.TransitionLightConfig;
import com.samsung.android.sesl.visualeffect.lighteffects.transitionlight.TransitionLightRenderEffect;
import com.samsung.android.support.senl.p148nt.data.common.constants.ExternalDataConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@RequiresApi(33)
@Metadata(m13885d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J$\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\f\u0012\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t0\b2\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0010\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*R$\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0012\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R$\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u000b\u001a\u00020\u0015@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR$\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u000b\u001a\u00020\u001b@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R$\u0010!\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u000f\"\u0004\b#\u0010\u0011R$\u0010$\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u000f\"\u0004\b&\u0010\u0011¨\u0006+"}, m13886d2 = {"Lcom/samsung/android/sesl/visualeffect/lighteffects/transitionlight/TransitionLightControl;", "Lcom/samsung/android/sesl/visualeffect/lighteffects/common/control/VibeEffectBase;", "Lcom/samsung/android/sesl/visualeffect/lighteffects/transitionlight/TransitionLightConfig;", "Lcom/samsung/android/sesl/visualeffect/lighteffects/transitionlight/TransitionLightRenderEffect;", ExternalDataConstants.EmbeddingConfig.KEY, "<init>", "(Lcom/samsung/android/sesl/visualeffect/lighteffects/transitionlight/TransitionLightConfig;)V", "build", "Lkotlin/Pair;", "", "Landroid/animation/ValueAnimator;", "value", "", "tintSaturation", "getTintSaturation", "()F", "setTintSaturation", "(F)V", "progress", "getProgress", "setProgress", "Lcom/samsung/android/sesl/visualeffect/lighteffects/transitionlight/TransitionLightConfig$RevealMode;", "revealMode", "getRevealMode", "()Lcom/samsung/android/sesl/visualeffect/lighteffects/transitionlight/TransitionLightConfig$RevealMode;", "setRevealMode", "(Lcom/samsung/android/sesl/visualeffect/lighteffects/transitionlight/TransitionLightConfig$RevealMode;)V", "Landroid/graphics/PointF;", "transPosition", "getTransPosition", "()Landroid/graphics/PointF;", "setTransPosition", "(Landroid/graphics/PointF;)V", "transAlpha", "getTransAlpha", "setTransAlpha", "transScale", "getTransScale", "setTransScale", "setColorBitmap", "", "colorBitmap", "Landroid/graphics/Bitmap;", "sesl-visualeffect-INTERNAL-2.1.10_release"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class TransitionLightControl extends VibeEffectBase<TransitionLightConfig, TransitionLightRenderEffect> {
    private float progress;

    @NotNull
    private TransitionLightConfig.RevealMode revealMode;
    private float tintSaturation;
    private float transAlpha;

    @NotNull
    private PointF transPosition;
    private float transScale;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TransitionLightControl(@NotNull TransitionLightConfig config) {
        super(config);
        Intrinsics.checkNotNullParameter(config, "config");
        this.tintSaturation = 1.2f;
        this.revealMode = TransitionLightRenderEffect.Companion.Default.INSTANCE.getRevealMode();
        this.transPosition = new PointF(0.5f, 0.5f);
        this.transAlpha = 1.0f;
        this.transScale = 1.0f;
    }

    public final float getProgress() {
        return this.progress;
    }

    @NotNull
    public final TransitionLightConfig.RevealMode getRevealMode() {
        return this.revealMode;
    }

    public final float getTintSaturation() {
        return this.tintSaturation;
    }

    public final float getTransAlpha() {
        return this.transAlpha;
    }

    @NotNull
    public final PointF getTransPosition() {
        return this.transPosition;
    }

    public final float getTransScale() {
        return this.transScale;
    }

    public final void setColorBitmap(@Nullable Bitmap colorBitmap) {
        TransitionLightRenderEffect renderEffect = getRenderEffect();
        if (renderEffect != null) {
            renderEffect.setTintTexture(colorBitmap);
        }
    }

    public final void setProgress(float f) {
        this.progress = f;
        TransitionLightRenderEffect renderEffect = getRenderEffect();
        if (renderEffect != null) {
            renderEffect.setProgress(this.progress);
        }
    }

    public final void setRevealMode(@NotNull TransitionLightConfig.RevealMode value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.revealMode = value;
        TransitionLightRenderEffect renderEffect = getRenderEffect();
        if (renderEffect != null) {
            renderEffect.setRevealMode(this.revealMode);
        }
    }

    public final void setTintSaturation(float f) {
        this.tintSaturation = f;
        TransitionLightRenderEffect renderEffect = getRenderEffect();
        if (renderEffect != null) {
            renderEffect.setTintSaturation(this.tintSaturation);
        }
    }

    public final void setTransAlpha(float f) {
        this.transAlpha = f;
        TransitionLightRenderEffect renderEffect = getRenderEffect();
        if (renderEffect != null) {
            renderEffect.setTransAlpha(this.transAlpha);
        }
    }

    public final void setTransPosition(@NotNull PointF value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.transPosition = value;
        TransitionLightRenderEffect renderEffect = getRenderEffect();
        if (renderEffect != null) {
            renderEffect.setTransPosition(this.transPosition);
        }
    }

    public final void setTransScale(float f) {
        this.transScale = f;
        TransitionLightRenderEffect renderEffect = getRenderEffect();
        if (renderEffect != null) {
            renderEffect.setTransScale(this.transScale);
        }
    }

    @Override // com.samsung.android.sesl.visualeffect.lighteffects.common.control.VibeEffectBase
    @NotNull
    public Pair<TransitionLightRenderEffect, List<ValueAnimator>> build(@NotNull TransitionLightConfig config) {
        Intrinsics.checkNotNullParameter(config, "config");
        TransitionLightRenderEffect transitionLightRenderEffect = new TransitionLightRenderEffect();
        transitionLightRenderEffect.setBitmap(config.getImageBitmap());
        transitionLightRenderEffect.setTransMap(config.getTransMap());
        transitionLightRenderEffect.setTransPosition(config.getTransPos());
        transitionLightRenderEffect.setTransScale(config.getTransScale());
        transitionLightRenderEffect.setTransAlpha(config.getTransAlpha());
        transitionLightRenderEffect.setTintIntensity(config.getTintIntensity());
        transitionLightRenderEffect.setTintSaturation(config.getTintSaturation());
        transitionLightRenderEffect.setRevealMode(config.getRevealMode());
        transitionLightRenderEffect.setScaleType(config.getScaleType());
        transitionLightRenderEffect.setFrameRate(config.getFrameRate());
        transitionLightRenderEffect.setStretch(config.getLightStretch());
        return new Pair<>(transitionLightRenderEffect, null);
    }
}
