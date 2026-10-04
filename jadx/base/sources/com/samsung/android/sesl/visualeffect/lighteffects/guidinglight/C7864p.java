package com.samsung.android.sesl.visualeffect.lighteffects.guidinglight;

import android.graphics.RuntimeShader;
import com.samsung.android.sesl.visualeffect.lighteffects.common.runtimshader.VibeRenderEffectBase;
import com.samsung.android.sesl.visualeffect.lighteffects.processinglight.ProcessingLightRenderEffect;
import java.util.function.Consumer;

/* JADX INFO: renamed from: com.samsung.android.sesl.visualeffect.lighteffects.guidinglight.p */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class C7864p implements Consumer {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f5318a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ boolean f5319b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ VibeRenderEffectBase f5320c;

    public /* synthetic */ C7864p(VibeRenderEffectBase vibeRenderEffectBase, boolean z, int i) {
        this.f5318a = i;
        this.f5320c = vibeRenderEffectBase;
        this.f5319b = z;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        switch (this.f5318a) {
            case 0:
                GuidingLightRenderEffect.setTintFlipX$lambda$35((GuidingLightRenderEffect) this.f5320c, this.f5319b, (RuntimeShader) obj);
                break;
            default:
                ProcessingLightRenderEffect.setLightPositionStretch$lambda$12((ProcessingLightRenderEffect) this.f5320c, this.f5319b, (RuntimeShader) obj);
                break;
        }
    }
}
