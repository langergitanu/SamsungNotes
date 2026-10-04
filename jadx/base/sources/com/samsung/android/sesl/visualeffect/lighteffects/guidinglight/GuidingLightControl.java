package com.samsung.android.sesl.visualeffect.lighteffects.guidinglight;

import android.animation.ValueAnimator;
import android.util.Log;
import androidx.annotation.RequiresApi;
import com.samsung.android.sesl.visualeffect.lighteffects.common.config.AnimatableAttribute;
import com.samsung.android.sesl.visualeffect.lighteffects.common.control.IColorEffect;
import com.samsung.android.sesl.visualeffect.lighteffects.common.control.IColorEffectKt;
import com.samsung.android.sesl.visualeffect.lighteffects.common.control.VibeEffectBase;
import com.samsung.android.sesl.visualeffect.lighteffects.common.runtimshader.VibeRenderEffect;
import com.samsung.android.sesl.visualeffect.lighteffects.common.runtimshader.VibeRenderEffectBase;
import com.samsung.android.sesl.visualeffect.lighteffects.guidinglight.GuidingLightConfig;
import com.samsung.android.support.senl.p148nt.data.common.constants.ExternalDataConstants;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@RequiresApi(33)
@Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J$\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\f\u0012\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t0\b2\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u0002¨\u0006\u0010"}, m13886d2 = {"Lcom/samsung/android/sesl/visualeffect/lighteffects/guidinglight/GuidingLightControl;", "Lcom/samsung/android/sesl/visualeffect/lighteffects/common/control/VibeEffectBase;", "Lcom/samsung/android/sesl/visualeffect/lighteffects/guidinglight/GuidingLightConfig;", "Lcom/samsung/android/sesl/visualeffect/lighteffects/guidinglight/GuidingLightRenderEffect;", ExternalDataConstants.EmbeddingConfig.KEY, "<init>", "(Lcom/samsung/android/sesl/visualeffect/lighteffects/guidinglight/GuidingLightConfig;)V", "build", "Lkotlin/Pair;", "", "Landroid/animation/ValueAnimator;", "setColorEffect", "", "colorEffect", "Lcom/samsung/android/sesl/visualeffect/lighteffects/common/control/IColorEffect;", "applyConfig", "sesl-visualeffect-INTERNAL-2.1.10_release"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nGuidingLightControl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GuidingLightControl.kt\ncom/samsung/android/sesl/visualeffect/lighteffects/guidinglight/GuidingLightControl\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,80:1\n1863#2,2:81\n*S KotlinDebug\n*F\n+ 1 GuidingLightControl.kt\ncom/samsung/android/sesl/visualeffect/lighteffects/guidinglight/GuidingLightControl\n*L\n29#1:81,2\n*E\n"})
public final class GuidingLightControl extends VibeEffectBase<GuidingLightConfig, GuidingLightRenderEffect> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuidingLightControl(@NotNull GuidingLightConfig config) {
        super(config);
        Intrinsics.checkNotNullParameter(config, "config");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setColorEffect$lambda$1(VibeRenderEffectBase vibeRenderEffectBase, GuidingLightControl guidingLightControl, IColorEffect iColorEffect, boolean z) {
        if (vibeRenderEffectBase.getShaderUpdated()) {
            GuidingLightRenderEffect renderEffect = guidingLightControl.getRenderEffect();
            if (renderEffect != null) {
                renderEffect.setTintShader(vibeRenderEffectBase.getShader(), IColorEffectKt.toPointF(iColorEffect.getDrawingBufferSize()));
            }
            vibeRenderEffectBase.setShaderUpdated$sesl_visualeffect_INTERNAL_2_1_10_release(false);
        }
        return Unit.INSTANCE;
    }

    public final void applyConfig(@NotNull GuidingLightConfig config) {
        Intrinsics.checkNotNullParameter(config, "config");
        GuidingLightRenderEffect renderEffect = getRenderEffect();
        if (renderEffect == null) {
            return;
        }
        renderEffect.setLightPos(config.getLightPos());
        renderEffect.setLightRadius(config.getLightRadius());
        renderEffect.setLightIntensity(config.getLightIntensity());
        renderEffect.setGlowRadius(config.getGlowRadius());
        renderEffect.setGlowIntensity(config.getGlowIntensity());
        renderEffect.setGlowSharpness(config.getGlowSharpness());
        renderEffect.setReflLightRadius(config.getReflLightRadius());
        renderEffect.setReflLightIntensity(config.getReflLightIntensity());
        renderEffect.setReflAlbedo(config.getReflAlbedo());
        renderEffect.setFrameRate(config.getFrameRate());
        renderEffect.setGlobalLuminance(config.getGlobalLuminance());
        renderEffect.setDitherVariation(config.getDitherVariation());
        renderEffect.setSaturation(config.getSaturation());
        renderEffect.setStretch(config.getStretch());
        renderEffect.setOuterSaturation(config.getOuterSaturation());
        renderEffect.setStretchDirLit(config.getStretchDirLit());
        renderEffect.setOutlineThickness(config.getOutlineThickness());
        renderEffect.setBoundarySmoothWidth(config.getBoundarySmoothWidth());
        GuidingLightConfig.Shape shape = config.getShape();
        GuidingLightConfig.ShaderPrecision shaderPrecision = config.getShaderPrecision();
        float lightRadius = config.getLightRadius();
        float lightIntensity = config.getLightIntensity();
        float frameRate = config.getFrameRate();
        float glowIntensity = config.getGlowIntensity();
        float glowRadius = config.getGlowRadius();
        float glowSharpness = config.getGlowSharpness();
        float reflLightIntensity = config.getReflLightIntensity();
        float reflLightRadius = config.getReflLightRadius();
        float reflAlbedo = config.getReflAlbedo();
        float globalLuminance = config.getGlobalLuminance();
        float saturation = config.getSaturation();
        float outerSaturation = config.getOuterSaturation();
        float stretch = config.getStretch();
        float stretchDirLit = config.getStretchDirLit();
        StringBuilder sb = new StringBuilder("GuidingLightConfig shape:");
        sb.append(shape);
        sb.append(" precision:");
        sb.append(shaderPrecision);
        sb.append(" radius:");
        AbstractC11014a.m12337v(sb, lightRadius, " intensity:", lightIntensity, " frameRate:");
        AbstractC11014a.m12337v(sb, frameRate, " glowIntensity:", glowIntensity, " glowRadius:");
        AbstractC11014a.m12337v(sb, glowRadius, " glowSharpness:", glowSharpness, " refIntensity:");
        AbstractC11014a.m12337v(sb, reflLightIntensity, " refRadius:", reflLightRadius, " refAlbedo: ");
        AbstractC11014a.m12337v(sb, reflAlbedo, "  gLuminance:", globalLuminance, " saturation:");
        AbstractC11014a.m12337v(sb, saturation, " outerSaturation:", outerSaturation, " stretch:");
        sb.append(stretch);
        sb.append(" stretchDirLit: ");
        sb.append(stretchDirLit);
        Log.i(GuidingLightConfig.TAG, sb.toString());
    }

    public final void setColorEffect(@NotNull IColorEffect colorEffect) {
        ArrayList<Function1<Boolean, Unit>> onUpdateListeners;
        Intrinsics.checkNotNullParameter(colorEffect, "colorEffect");
        VibeRenderEffect colorRenderEffect = colorEffect.getColorRenderEffect();
        Intrinsics.checkNotNull(colorRenderEffect, "null cannot be cast to non-null type com.samsung.android.sesl.visualeffect.lighteffects.common.runtimshader.VibeRenderEffectBase");
        VibeRenderEffectBase vibeRenderEffectBase = (VibeRenderEffectBase) colorRenderEffect;
        GuidingLightRenderEffect renderEffect = getRenderEffect();
        if (renderEffect != null) {
            renderEffect.setTintShader(vibeRenderEffectBase.getShader(), IColorEffectKt.toPointF(colorEffect.getDrawingBufferSize()));
        }
        GuidingLightRenderEffect renderEffect2 = getRenderEffect();
        if (renderEffect2 == null || (onUpdateListeners = renderEffect2.getOnUpdateListeners()) == null) {
            return;
        }
        onUpdateListeners.add(new C7857i(vibeRenderEffectBase, 0, this, colorEffect));
    }

    @Override // com.samsung.android.sesl.visualeffect.lighteffects.common.control.VibeEffectBase
    @NotNull
    public Pair<GuidingLightRenderEffect, List<ValueAnimator>> build(@NotNull GuidingLightConfig config) {
        Intrinsics.checkNotNullParameter(config, "config");
        GuidingLightRenderEffect guidingLightRenderEffect = new GuidingLightRenderEffect(config.getShape() == GuidingLightConfig.Shape.RoundRect, config.getShaderPrecision());
        getVibeRenderEffect().add(guidingLightRenderEffect);
        applyConfig(config);
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = config.getAnimatableAttribute$sesl_visualeffect_INTERNAL_2_1_10_release().iterator();
        while (it.hasNext()) {
            arrayList.add(((AnimatableAttribute) it.next()).build$sesl_visualeffect_INTERNAL_2_1_10_release(this));
        }
        return new Pair<>(guidingLightRenderEffect, arrayList);
    }
}
