package com.samsung.android.sesl.visualeffect.lighteffects.radialgrad;

import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.util.Size;
import androidx.annotation.RequiresApi;
import com.samsung.android.sesl.visualeffect.lighteffects.common.control.IColorEffect;
import com.samsung.android.sesl.visualeffect.lighteffects.common.control.VibeEffectBase;
import com.samsung.android.sesl.visualeffect.lighteffects.common.runtimshader.VibeRenderEffect;
import com.samsung.android.support.senl.p148nt.data.common.constants.ExternalDataConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@RequiresApi(33)
@Metadata(m13885d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\u0013\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00150\u00142\u0006\u0010\u0005\u001a\u00020\u0002H\u0016J\u001e\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0003H\u0002R\u0014\u0010\b\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR$\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0019"}, m13886d2 = {"Lcom/samsung/android/sesl/visualeffect/lighteffects/radialgrad/RadialGradControl;", "Lcom/samsung/android/sesl/visualeffect/lighteffects/common/control/VibeEffectBase;", "Lcom/samsung/android/sesl/visualeffect/lighteffects/radialgrad/RadialGradConfig;", "Lcom/samsung/android/sesl/visualeffect/lighteffects/radialgrad/RadialGradRenderEffect;", "Lcom/samsung/android/sesl/visualeffect/lighteffects/common/control/IColorEffect;", ExternalDataConstants.EmbeddingConfig.KEY, "<init>", "(Lcom/samsung/android/sesl/visualeffect/lighteffects/radialgrad/RadialGradConfig;)V", "colorRenderEffect", "Lcom/samsung/android/sesl/visualeffect/lighteffects/common/runtimshader/VibeRenderEffect;", "getColorRenderEffect", "()Lcom/samsung/android/sesl/visualeffect/lighteffects/common/runtimshader/VibeRenderEffect;", "value", "Landroid/util/Size;", "drawingBufferSize", "getDrawingBufferSize", "()Landroid/util/Size;", "setDrawingBufferSize", "(Landroid/util/Size;)V", "build", "Lkotlin/Pair;", "", "Landroid/animation/ValueAnimator;", "buildAnimations", "effect", "sesl-visualeffect-INTERNAL-2.1.10_release"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nRadialGradControl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RadialGradControl.kt\ncom/samsung/android/sesl/visualeffect/lighteffects/radialgrad/RadialGradControl\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,88:1\n1#2:89\n1872#3,3:90\n1872#3,3:93\n1863#3,2:96\n*S KotlinDebug\n*F\n+ 1 RadialGradControl.kt\ncom/samsung/android/sesl/visualeffect/lighteffects/radialgrad/RadialGradControl\n*L\n37#1:90,3\n55#1:93,3\n76#1:96,2\n*E\n"})
public final class RadialGradControl extends VibeEffectBase<RadialGradConfig, RadialGradRenderEffect> implements IColorEffect {

    @NotNull
    private Size drawingBufferSize;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RadialGradControl(@NotNull RadialGradConfig config) {
        super(config);
        Intrinsics.checkNotNullParameter(config, "config");
        Size drawingBufferSize = config.getDrawingBufferSize();
        this.drawingBufferSize = drawingBufferSize == null ? new Size(0, 0) : drawingBufferSize;
    }

    private final List<ValueAnimator> buildAnimations(RadialGradConfig config, RadialGradRenderEffect effect) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        for (Object obj : config.getSpotConfigs()) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            RadialGradRenderEffect radialGradRenderEffect = effect;
            arrayList.addAll(buildAnimations$lambda$10$lambda$9$buildWiggle$default((SpotConfig) obj, radialGradRenderEffect, i, this, false, 16, null));
            effect = radialGradRenderEffect;
            i = i2;
        }
        return arrayList;
    }

    private static final List<ValueAnimator> buildAnimations$lambda$10$lambda$9$buildWiggle(final SpotConfig spotConfig, final RadialGradRenderEffect radialGradRenderEffect, final int i, final RadialGradControl radialGradControl, boolean z) {
        Function1<? super Integer, Unit> function1;
        WiggleAnimationConfig wiggle = spotConfig.getWiggle();
        if (wiggle != null) {
            PointF position = spotConfig.getPosition();
            float scale = spotConfig.getScale();
            int color = spotConfig.getColor();
            int spotColor = radialGradRenderEffect.getSpotColor(i);
            PointF spotPosition = radialGradRenderEffect.getSpotPosition(i);
            float spotScale = radialGradRenderEffect.getSpotScale(i);
            if (z) {
                function1 = null;
            } else {
                final int i2 = 0;
                function1 = new Function1() { // from class: com.samsung.android.sesl.visualeffect.lighteffects.radialgrad.b
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        switch (i2) {
                            case 0:
                                return RadialGradControl.buildAnimations$lambda$10$lambda$9$buildWiggle$lambda$4(radialGradRenderEffect, i, ((Integer) obj).intValue());
                            case 1:
                                return RadialGradControl.buildAnimations$lambda$10$lambda$9$buildWiggle$lambda$5(radialGradRenderEffect, i, (PointF) obj);
                            default:
                                return RadialGradControl.buildAnimations$lambda$10$lambda$9$buildWiggle$lambda$6(radialGradRenderEffect, i, ((Float) obj).floatValue());
                        }
                    }
                };
            }
            Function1<? super Integer, Unit> function12 = function1;
            final int i4 = 1;
            Function1<? super PointF, Unit> function13 = new Function1() { // from class: com.samsung.android.sesl.visualeffect.lighteffects.radialgrad.b
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    switch (i4) {
                        case 0:
                            return RadialGradControl.buildAnimations$lambda$10$lambda$9$buildWiggle$lambda$4(radialGradRenderEffect, i, ((Integer) obj).intValue());
                        case 1:
                            return RadialGradControl.buildAnimations$lambda$10$lambda$9$buildWiggle$lambda$5(radialGradRenderEffect, i, (PointF) obj);
                        default:
                            return RadialGradControl.buildAnimations$lambda$10$lambda$9$buildWiggle$lambda$6(radialGradRenderEffect, i, ((Float) obj).floatValue());
                    }
                }
            };
            final int i5 = 2;
            List<ValueAnimator> listBuild$sesl_visualeffect_INTERNAL_2_1_10_release = wiggle.build$sesl_visualeffect_INTERNAL_2_1_10_release(position, scale, color, spotPosition, spotScale, spotColor, function13, new Function1() { // from class: com.samsung.android.sesl.visualeffect.lighteffects.radialgrad.b
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    switch (i5) {
                        case 0:
                            return RadialGradControl.buildAnimations$lambda$10$lambda$9$buildWiggle$lambda$4(radialGradRenderEffect, i, ((Integer) obj).intValue());
                        case 1:
                            return RadialGradControl.buildAnimations$lambda$10$lambda$9$buildWiggle$lambda$5(radialGradRenderEffect, i, (PointF) obj);
                        default:
                            return RadialGradControl.buildAnimations$lambda$10$lambda$9$buildWiggle$lambda$6(radialGradRenderEffect, i, ((Float) obj).floatValue());
                    }
                }
            }, function12, new Function1() { // from class: com.samsung.android.sesl.visualeffect.lighteffects.radialgrad.c
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return RadialGradControl.buildAnimations$lambda$10$lambda$9$buildWiggle$lambda$8(this.f5350a, spotConfig, radialGradRenderEffect, i, (ValueAnimator) obj);
                }
            });
            if (listBuild$sesl_visualeffect_INTERNAL_2_1_10_release != null) {
                return listBuild$sesl_visualeffect_INTERNAL_2_1_10_release;
            }
        }
        return new ArrayList();
    }

    public static /* synthetic */ List buildAnimations$lambda$10$lambda$9$buildWiggle$default(SpotConfig spotConfig, RadialGradRenderEffect radialGradRenderEffect, int i, RadialGradControl radialGradControl, boolean z, int i2, Object obj) {
        if ((i2 & 16) != 0) {
            z = false;
        }
        return buildAnimations$lambda$10$lambda$9$buildWiggle(spotConfig, radialGradRenderEffect, i, radialGradControl, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit buildAnimations$lambda$10$lambda$9$buildWiggle$lambda$4(RadialGradRenderEffect radialGradRenderEffect, int i, int i2) {
        radialGradRenderEffect.setSpotColor(i, i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit buildAnimations$lambda$10$lambda$9$buildWiggle$lambda$5(RadialGradRenderEffect radialGradRenderEffect, int i, PointF p) {
        Intrinsics.checkNotNullParameter(p, "p");
        radialGradRenderEffect.setSpotPosition(i, p);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit buildAnimations$lambda$10$lambda$9$buildWiggle$lambda$6(RadialGradRenderEffect radialGradRenderEffect, int i, float f) {
        radialGradRenderEffect.setSpotScale(i, f);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit buildAnimations$lambda$10$lambda$9$buildWiggle$lambda$8(RadialGradControl radialGradControl, SpotConfig spotConfig, RadialGradRenderEffect radialGradRenderEffect, int i, ValueAnimator anim) {
        Intrinsics.checkNotNullParameter(anim, "anim");
        radialGradControl.getAnimators$sesl_visualeffect_INTERNAL_2_1_10_release().remove(anim);
        List<ValueAnimator> listBuildAnimations$lambda$10$lambda$9$buildWiggle = buildAnimations$lambda$10$lambda$9$buildWiggle(spotConfig, radialGradRenderEffect, i, radialGradControl, true);
        Iterator<T> it = listBuildAnimations$lambda$10$lambda$9$buildWiggle.iterator();
        while (it.hasNext()) {
            ((ValueAnimator) it.next()).start();
        }
        radialGradControl.getAnimators$sesl_visualeffect_INTERNAL_2_1_10_release().addAll(listBuildAnimations$lambda$10$lambda$9$buildWiggle);
        return Unit.INSTANCE;
    }

    @Override // com.samsung.android.sesl.visualeffect.lighteffects.common.control.IColorEffect
    @NotNull
    public VibeRenderEffect getColorRenderEffect() {
        RadialGradRenderEffect renderEffect = getRenderEffect();
        Intrinsics.checkNotNull(renderEffect);
        return renderEffect;
    }

    @Override // com.samsung.android.sesl.visualeffect.lighteffects.common.control.IColorEffect
    @NotNull
    public Size getDrawingBufferSize() {
        return this.drawingBufferSize;
    }

    public void setDrawingBufferSize(@NotNull Size value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.drawingBufferSize = value;
        RadialGradRenderEffect renderEffect = getRenderEffect();
        if (renderEffect != null) {
            renderEffect.setSize(this.drawingBufferSize.getWidth(), this.drawingBufferSize.getHeight());
        }
    }

    @Override // com.samsung.android.sesl.visualeffect.lighteffects.common.control.VibeEffectBase
    @NotNull
    public Pair<RadialGradRenderEffect, List<ValueAnimator>> build(@NotNull RadialGradConfig config) {
        Intrinsics.checkNotNullParameter(config, "config");
        RadialGradRenderEffect radialGradRenderEffect = new RadialGradRenderEffect();
        radialGradRenderEffect.setBlurRadius(config.getBlurRadius());
        Bitmap radialMap = config.getRadialMap();
        if (radialMap != null) {
            radialGradRenderEffect.setLightMap(radialMap);
        }
        Size drawingBufferSize = config.getDrawingBufferSize();
        if (drawingBufferSize != null) {
            radialGradRenderEffect.setSize(drawingBufferSize.getWidth(), drawingBufferSize.getHeight());
        }
        radialGradRenderEffect.setBackgroundColor(config.getBackgroundColor());
        radialGradRenderEffect.setSpotCount(config.getSpotConfigs().size());
        int i = 0;
        for (Object obj : config.getSpotConfigs()) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            SpotConfig spotConfig = (SpotConfig) obj;
            radialGradRenderEffect.setSpotEnabled(i, spotConfig.getEnabled());
            radialGradRenderEffect.setSpotColor(i, spotConfig.getColor());
            radialGradRenderEffect.setSpotScale(i, spotConfig.getScale());
            radialGradRenderEffect.setSpotPosition(i, spotConfig.getPosition());
            i = i2;
        }
        return new Pair<>(radialGradRenderEffect, buildAnimations(config, radialGradRenderEffect));
    }
}
