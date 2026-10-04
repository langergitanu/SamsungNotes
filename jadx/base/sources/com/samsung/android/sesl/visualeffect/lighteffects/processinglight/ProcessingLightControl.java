package com.samsung.android.sesl.visualeffect.lighteffects.processinglight;

import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.Shader;
import android.util.Size;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.RequiresApi;
import com.samsung.android.sesl.visualeffect.lighteffects.common.config.AnimatableAttribute;
import com.samsung.android.sesl.visualeffect.lighteffects.common.control.IColorEffectKt;
import com.samsung.android.sesl.visualeffect.lighteffects.common.control.IEffectColorConsumer;
import com.samsung.android.sesl.visualeffect.lighteffects.common.control.IEffectColorProvider;
import com.samsung.android.sesl.visualeffect.lighteffects.common.control.VibeEffectBase;
import com.samsung.android.sesl.visualeffect.lighteffects.common.runtimshader.VibeRenderEffect;
import com.samsung.android.sesl.visualeffect.lighteffects.common.runtimshader.VibeRenderEffectBase;
import com.samsung.android.sesl.visualeffect.lighteffects.guidinglight.C7857i;
import com.samsung.android.sesl.visualeffect.lighteffects.processinglight.ProcessingLightRenderEffect;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.draw.common.VDrawConst;
import com.samsung.android.support.senl.p148nt.data.common.constants.ExternalDataConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p122b2.C4191n;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@RequiresApi(33)
@Metadata(m13885d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n0\t2\u0006\u0010\u0005\u001a\u00020\u0002H\u0016J\u0012\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\u0018\u0010.\u001a\u00020+2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u000202H\u0016J\u0010\u00103\u001a\u00020+2\u0006\u00104\u001a\u000205H\u0016J\u000e\u00106\u001a\u00020+2\u0006\u0010\u0005\u001a\u00020\u0002R$\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0014\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u0013@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R*\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\f\u001a\u0004\u0018\u00010\u0019@@X\u0080\u000e¢\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR$\u0010 \u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0010\"\u0004\b\"\u0010\u0012R,\u0010$\u001a\u0004\u0018\u00010#2\b\u0010\f\u001a\u0004\u0018\u00010#8\u0006@FX\u0087\u000e¢\u0006\u0010\n\u0002\u0010)\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(¨\u00067"}, m13886d2 = {"Lcom/samsung/android/sesl/visualeffect/lighteffects/processinglight/ProcessingLightControl;", "Lcom/samsung/android/sesl/visualeffect/lighteffects/common/control/VibeEffectBase;", "Lcom/samsung/android/sesl/visualeffect/lighteffects/processinglight/ProcessingLightConfig;", "Lcom/samsung/android/sesl/visualeffect/lighteffects/processinglight/ProcessingLightRenderEffect;", "Lcom/samsung/android/sesl/visualeffect/lighteffects/common/control/IEffectColorConsumer;", ExternalDataConstants.EmbeddingConfig.KEY, "<init>", "(Lcom/samsung/android/sesl/visualeffect/lighteffects/processinglight/ProcessingLightConfig;)V", "build", "Lkotlin/Pair;", "", "Landroid/animation/ValueAnimator;", "value", "", "lightScale", "getLightScale", "()F", "setLightScale", "(F)V", "Landroid/graphics/PointF;", "lightPosition", "getLightPosition", "()Landroid/graphics/PointF;", "setLightPosition", "(Landroid/graphics/PointF;)V", "", "lightPositionStretch", "getLightPositionStretch$sesl_visualeffect_INTERNAL_2_1_10_release", "()Ljava/lang/Boolean;", "setLightPositionStretch$sesl_visualeffect_INTERNAL_2_1_10_release", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "lightIntensity", "getLightIntensity", "setLightIntensity", "", "domainColor", "getDomainColor", "()Ljava/lang/Integer;", "setDomainColor", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "setColorBitmap", "", "colorBitmap", "Landroid/graphics/Bitmap;", "setColorShader", "shader", "Landroid/graphics/Shader;", "size", "Landroid/util/Size;", "setColorEffect", "colorEffect", "Lcom/samsung/android/sesl/visualeffect/lighteffects/common/control/IEffectColorProvider;", "buildAnimation", "sesl-visualeffect-INTERNAL-2.1.10_release"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nProcessingLightControl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ProcessingLightControl.kt\ncom/samsung/android/sesl/visualeffect/lighteffects/processinglight/ProcessingLightControl\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 Color.kt\nandroidx/core/graphics/ColorKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,120:1\n1#2:121\n470#3:122\n1755#4,3:123\n1863#4,2:126\n1863#4,2:128\n*S KotlinDebug\n*F\n+ 1 ProcessingLightControl.kt\ncom/samsung/android/sesl/visualeffect/lighteffects/processinglight/ProcessingLightControl\n*L\n76#1:122\n102#1:123,3\n103#1:126,2\n116#1:128,2\n*E\n"})
public final class ProcessingLightControl extends VibeEffectBase<ProcessingLightConfig, ProcessingLightRenderEffect> implements IEffectColorConsumer {

    @ColorInt
    @Nullable
    private Integer domainColor;
    private float lightIntensity;

    @NotNull
    private PointF lightPosition;

    @Nullable
    private Boolean lightPositionStretch;
    private float lightScale;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProcessingLightControl(@NotNull ProcessingLightConfig config) {
        super(config);
        Intrinsics.checkNotNullParameter(config, "config");
        this.lightScale = 2.05f;
        this.lightPosition = ProcessingLightRenderEffect.Companion.Default.INSTANCE.getLightPos();
        this.lightIntensity = 1.0f;
        this.domainColor = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void buildAnimation$lambda$6(ProcessingLightControl processingLightControl, View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        ProcessingLightRenderEffect renderEffect = processingLightControl.getRenderEffect();
        if (renderEffect != null) {
            renderEffect.remove(it);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void buildAnimation$lambda$7(ProcessingLightControl processingLightControl, boolean z, View it) {
        ProcessingLightRenderEffect renderEffect;
        Intrinsics.checkNotNullParameter(it, "it");
        ProcessingLightRenderEffect renderEffect2 = processingLightControl.getRenderEffect();
        if (renderEffect2 != null) {
            renderEffect2.add(it);
        }
        if (!z || (renderEffect = processingLightControl.getRenderEffect()) == null) {
            return;
        }
        renderEffect.tryStart();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setColorEffect$lambda$3(VibeRenderEffectBase vibeRenderEffectBase, ProcessingLightControl processingLightControl, IEffectColorProvider iEffectColorProvider, boolean z) {
        if (vibeRenderEffectBase.getShaderUpdated()) {
            ProcessingLightRenderEffect renderEffect = processingLightControl.getRenderEffect();
            if (renderEffect != null) {
                renderEffect.setTintShader(vibeRenderEffectBase.getShader(), IColorEffectKt.toPointF(iEffectColorProvider.getDrawingBufferSize()));
            }
            vibeRenderEffectBase.setShaderUpdated$sesl_visualeffect_INTERNAL_2_1_10_release(false);
        }
        return Unit.INSTANCE;
    }

    public final void buildAnimation(@NotNull ProcessingLightConfig config) {
        Intrinsics.checkNotNullParameter(config, "config");
        ArrayList<ValueAnimator> animators$sesl_visualeffect_INTERNAL_2_1_10_release = getAnimators$sesl_visualeffect_INTERNAL_2_1_10_release();
        final boolean z = false;
        if (animators$sesl_visualeffect_INTERNAL_2_1_10_release == null || !animators$sesl_visualeffect_INTERNAL_2_1_10_release.isEmpty()) {
            Iterator<T> it = animators$sesl_visualeffect_INTERNAL_2_1_10_release.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (((ValueAnimator) it.next()).isRunning()) {
                    z = true;
                    break;
                }
            }
        }
        Iterator<T> it2 = getAnimators$sesl_visualeffect_INTERNAL_2_1_10_release().iterator();
        while (it2.hasNext()) {
            ((ValueAnimator) it2.next()).cancel();
        }
        getAnimators$sesl_visualeffect_INTERNAL_2_1_10_release().clear();
        getViews().forEachAlive(new C4191n(this, 15));
        getViews().forEachAlive(new Consumer() { // from class: com.samsung.android.sesl.visualeffect.lighteffects.processinglight.b
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ProcessingLightControl.buildAnimation$lambda$7(this.f5332a, z, (View) obj);
            }
        });
        Iterator<T> it3 = config.getAnimatableAttribute$sesl_visualeffect_INTERNAL_2_1_10_release().iterator();
        while (it3.hasNext()) {
            getAnimators$sesl_visualeffect_INTERNAL_2_1_10_release().add(((AnimatableAttribute) it3.next()).build$sesl_visualeffect_INTERNAL_2_1_10_release(this));
        }
    }

    @Nullable
    public final Integer getDomainColor() {
        return this.domainColor;
    }

    public final float getLightIntensity() {
        return this.lightIntensity;
    }

    @NotNull
    public final PointF getLightPosition() {
        return this.lightPosition;
    }

    @Nullable
    /* JADX INFO: renamed from: getLightPositionStretch$sesl_visualeffect_INTERNAL_2_1_10_release, reason: from getter */
    public final Boolean getLightPositionStretch() {
        return this.lightPositionStretch;
    }

    public final float getLightScale() {
        return this.lightScale;
    }

    @Override // com.samsung.android.sesl.visualeffect.lighteffects.common.control.IEffectColorConsumer
    public void setColorBitmap(@Nullable Bitmap colorBitmap) {
        ProcessingLightRenderEffect renderEffect = getRenderEffect();
        if (renderEffect != null) {
            renderEffect.setTintTexture(colorBitmap);
        }
    }

    @Override // com.samsung.android.sesl.visualeffect.lighteffects.common.control.IEffectColorConsumer
    public void setColorEffect(@NotNull IEffectColorProvider colorEffect) {
        ArrayList<Function1<Boolean, Unit>> onUpdateListeners;
        Intrinsics.checkNotNullParameter(colorEffect, "colorEffect");
        VibeRenderEffect colorRenderEffect = colorEffect.getColorRenderEffect();
        Intrinsics.checkNotNull(colorRenderEffect, "null cannot be cast to non-null type com.samsung.android.sesl.visualeffect.lighteffects.common.runtimshader.VibeRenderEffectBase");
        VibeRenderEffectBase vibeRenderEffectBase = (VibeRenderEffectBase) colorRenderEffect;
        ProcessingLightRenderEffect renderEffect = getRenderEffect();
        if (renderEffect != null) {
            renderEffect.setTintShader(vibeRenderEffectBase.getShader(), IColorEffectKt.toPointF(colorEffect.getDrawingBufferSize()));
        }
        ProcessingLightRenderEffect renderEffect2 = getRenderEffect();
        if (renderEffect2 == null || (onUpdateListeners = renderEffect2.getOnUpdateListeners()) == null) {
            return;
        }
        onUpdateListeners.add(new C7857i(vibeRenderEffectBase, 1, this, colorEffect));
    }

    @Override // com.samsung.android.sesl.visualeffect.lighteffects.common.control.IEffectColorConsumer
    public void setColorShader(@NotNull Shader shader, @NotNull Size size) {
        Intrinsics.checkNotNullParameter(shader, "shader");
        Intrinsics.checkNotNullParameter(size, "size");
        ProcessingLightRenderEffect renderEffect = getRenderEffect();
        if (renderEffect != null) {
            renderEffect.setTintShader(shader, IColorEffectKt.toPointF(size));
        }
    }

    public final void setDomainColor(@Nullable Integer num) {
        this.domainColor = num;
        ProcessingLightRenderEffect renderEffect = getRenderEffect();
        if (renderEffect != null) {
            Integer num2 = this.domainColor;
            renderEffect.setDomainColor(num2 != null ? num2.intValue() : Color.parseColor(VDrawConst.DEFAULT_FILL_COLOR));
        }
    }

    public final void setLightIntensity(float f) {
        this.lightIntensity = f;
        ProcessingLightRenderEffect renderEffect = getRenderEffect();
        Intrinsics.checkNotNull(renderEffect);
        renderEffect.setLightIntensity(this.lightIntensity);
    }

    public final void setLightPosition(@NotNull PointF value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.lightPosition = value;
        ProcessingLightRenderEffect renderEffect = getRenderEffect();
        if (renderEffect != null) {
            renderEffect.setLightPosition(this.lightPosition);
        }
    }

    /* JADX INFO: renamed from: setLightPositionStretch$sesl_visualeffect_INTERNAL_2_1_10_release */
    public final void m6667x11ebdd0e(@Nullable Boolean bool) {
        this.lightPositionStretch = bool;
        if (bool != null) {
            boolean zBooleanValue = bool.booleanValue();
            ProcessingLightRenderEffect renderEffect = getRenderEffect();
            if (renderEffect != null) {
                renderEffect.setLightPositionStretch(zBooleanValue);
            }
        }
    }

    public final void setLightScale(float f) {
        this.lightScale = f;
        ProcessingLightRenderEffect renderEffect = getRenderEffect();
        if (renderEffect != null) {
            renderEffect.setLightScale(this.lightScale);
        }
    }

    @Override // com.samsung.android.sesl.visualeffect.lighteffects.common.control.VibeEffectBase
    @NotNull
    public Pair<ProcessingLightRenderEffect, List<ValueAnimator>> build(@NotNull ProcessingLightConfig config) {
        Intrinsics.checkNotNullParameter(config, "config");
        ProcessingLightRenderEffect processingLightRenderEffect = new ProcessingLightRenderEffect(config.getUseLightnessCalibration(), config.getBlendMode());
        processingLightRenderEffect.setLightColor(config.getLightColor());
        processingLightRenderEffect.setLightPosition(config.getLightPos());
        processingLightRenderEffect.setLightRotation(config.getLightAngle());
        processingLightRenderEffect.setLightScale(config.getLightScale());
        processingLightRenderEffect.setLightIntensity(config.getLightIntensity());
        Integer domainColor = config.getDomainColor();
        if (domainColor != null) {
            processingLightRenderEffect.setDomainColor(domainColor.intValue());
        }
        processingLightRenderEffect.setDomainStrength(config.getDomainStrength());
        processingLightRenderEffect.setDomainDeltaRatio(config.getDomainDeltaRatio());
        processingLightRenderEffect.setStretch(config.getLightStretch());
        processingLightRenderEffect.setFrameRate(config.getFrameRate());
        return new Pair<>(processingLightRenderEffect, null);
    }
}
