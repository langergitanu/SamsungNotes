package com.samsung.android.sesl.visualeffect.lighteffects.guidinglight;

import android.graphics.RuntimeShader;
import com.samsung.android.sesl.visualeffect.lighteffects.common.runtimshader.VibeRenderEffectBase;
import com.samsung.android.sesl.visualeffect.lighteffects.processinglight.ProcessingLightRenderEffect;
import java.util.function.Consumer;

/* JADX INFO: renamed from: com.samsung.android.sesl.visualeffect.lighteffects.guidinglight.q */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class C7865q implements Consumer {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f5321a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ VibeRenderEffectBase f5322b;

    public /* synthetic */ C7865q(VibeRenderEffectBase vibeRenderEffectBase, int i) {
        this.f5321a = i;
        this.f5322b = vibeRenderEffectBase;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        switch (this.f5321a) {
            case 0:
                GuidingLightRenderEffect._init_$lambda$1((GuidingLightRenderEffect) this.f5322b, (RuntimeShader) obj);
                break;
            default:
                ProcessingLightRenderEffect.setLightMap$lambda$7((ProcessingLightRenderEffect) this.f5322b, (RuntimeShader) obj);
                break;
        }
    }
}
