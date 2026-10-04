package com.samsung.android.sesl.visualeffect.lighteffects.guidinglight;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.RuntimeShader;
import com.samsung.android.sesl.visualeffect.lighteffects.common.runtimshader.VibeRenderEffectBase;
import com.samsung.android.sesl.visualeffect.lighteffects.processinglight.ProcessingLightRenderEffect;
import com.samsung.android.sesl.visualeffect.lighteffects.radialgrad.RadialGradRenderEffect;
import com.samsung.android.sesl.visualeffect.lighteffects.transitionlight.TransitionLightConfig;
import com.samsung.android.sesl.visualeffect.lighteffects.transitionlight.TransitionLightRenderEffect;
import java.util.function.Consumer;

/* JADX INFO: renamed from: com.samsung.android.sesl.visualeffect.lighteffects.guidinglight.l */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class C7860l implements Consumer {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f5305a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ VibeRenderEffectBase f5306b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Object f5307c;

    public /* synthetic */ C7860l(VibeRenderEffectBase vibeRenderEffectBase, Object obj, int i) {
        this.f5305a = i;
        this.f5306b = vibeRenderEffectBase;
        this.f5307c = obj;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        switch (this.f5305a) {
            case 0:
                GuidingLightRenderEffect.setLightColor$lambda$21((GuidingLightRenderEffect) this.f5306b, (Color) this.f5307c, (RuntimeShader) obj);
                break;
            case 1:
                GuidingLightRenderEffect.setBorderWidth$lambda$11((GuidingLightRenderEffect) this.f5306b, (Point) this.f5307c, (RuntimeShader) obj);
                break;
            case 2:
                ProcessingLightRenderEffect.setLightPosition$lambda$11((ProcessingLightRenderEffect) this.f5306b, (PointF) this.f5307c, (RuntimeShader) obj);
                break;
            case 3:
                RadialGradRenderEffect.setLightMap$lambda$4((RadialGradRenderEffect) this.f5306b, (Bitmap) this.f5307c, (RuntimeShader) obj);
                break;
            case 4:
                TransitionLightRenderEffect.setScaleType$lambda$19((TransitionLightRenderEffect) this.f5306b, (TransitionLightConfig.ScaleType) this.f5307c, (RuntimeShader) obj);
                break;
            case 5:
                TransitionLightRenderEffect.setTransPosition$lambda$15((TransitionLightRenderEffect) this.f5306b, (PointF) this.f5307c, (RuntimeShader) obj);
                break;
            default:
                TransitionLightRenderEffect.setRevealMode$lambda$4((TransitionLightRenderEffect) this.f5306b, (TransitionLightConfig.RevealMode) this.f5307c, (RuntimeShader) obj);
                break;
        }
    }
}
