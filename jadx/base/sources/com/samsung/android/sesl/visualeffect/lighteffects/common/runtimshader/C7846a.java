package com.samsung.android.sesl.visualeffect.lighteffects.common.runtimshader;

import android.graphics.RuntimeShader;
import com.samsung.android.sesl.visualeffect.lighteffects.radialgrad.RadialGradRenderEffect;
import java.util.function.Consumer;

/* JADX INFO: renamed from: com.samsung.android.sesl.visualeffect.lighteffects.common.runtimshader.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class C7846a implements Consumer {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f5265a = 0;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ int f5266b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ int f5267c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ VibeRenderEffectBase f5268d;

    public /* synthetic */ C7846a(VibeRenderEffectBase vibeRenderEffectBase, int i, int i2) {
        this.f5268d = vibeRenderEffectBase;
        this.f5266b = i;
        this.f5267c = i2;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        switch (this.f5265a) {
            case 0:
                VibeRenderEffectBase.setSize$lambda$10(this.f5268d, this.f5266b, this.f5267c, (RuntimeShader) obj);
                break;
            default:
                RadialGradRenderEffect.setSpotColor$lambda$10(this.f5266b, (RadialGradRenderEffect) this.f5268d, this.f5267c, (RuntimeShader) obj);
                break;
        }
    }

    public /* synthetic */ C7846a(RadialGradRenderEffect radialGradRenderEffect, int i, int i2) {
        this.f5266b = i;
        this.f5268d = radialGradRenderEffect;
        this.f5267c = i2;
    }
}
