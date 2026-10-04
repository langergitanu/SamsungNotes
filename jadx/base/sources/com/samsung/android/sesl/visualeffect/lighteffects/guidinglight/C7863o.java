package com.samsung.android.sesl.visualeffect.lighteffects.guidinglight;

import android.graphics.PointF;
import android.graphics.RuntimeShader;
import android.graphics.Shader;
import com.samsung.android.sesl.visualeffect.lighteffects.common.runtimshader.VibeRenderEffectBase;
import com.samsung.android.sesl.visualeffect.lighteffects.processinglight.ProcessingLightRenderEffect;
import com.samsung.android.sesl.visualeffect.lighteffects.transitionlight.TransitionLightRenderEffect;
import java.util.function.Consumer;

/* JADX INFO: renamed from: com.samsung.android.sesl.visualeffect.lighteffects.guidinglight.o */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class C7863o implements Consumer {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f5314a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Shader f5315b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ PointF f5316c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ VibeRenderEffectBase f5317d;

    public /* synthetic */ C7863o(VibeRenderEffectBase vibeRenderEffectBase, Shader shader, PointF pointF, int i) {
        this.f5314a = i;
        this.f5317d = vibeRenderEffectBase;
        this.f5315b = shader;
        this.f5316c = pointF;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        switch (this.f5314a) {
            case 0:
                GuidingLightRenderEffect.setTintShader$lambda$33((GuidingLightRenderEffect) this.f5317d, this.f5315b, this.f5316c, (RuntimeShader) obj);
                break;
            case 1:
                ProcessingLightRenderEffect.setTintShader$lambda$6((ProcessingLightRenderEffect) this.f5317d, this.f5315b, this.f5316c, (RuntimeShader) obj);
                break;
            default:
                TransitionLightRenderEffect.setTintShader$lambda$12((TransitionLightRenderEffect) this.f5317d, this.f5315b, this.f5316c, (RuntimeShader) obj);
                break;
        }
    }
}
