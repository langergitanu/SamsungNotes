package com.samsung.android.sesl.visualeffect.lighteffects.guidinglight;

import android.graphics.RuntimeShader;
import java.util.function.Consumer;

/* JADX INFO: renamed from: com.samsung.android.sesl.visualeffect.lighteffects.guidinglight.k */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class C7859k implements Consumer {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f5302a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ GuidingLightRenderEffect f5303b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ float f5304c;

    public /* synthetic */ C7859k(GuidingLightRenderEffect guidingLightRenderEffect, float f, int i) {
        this.f5302a = i;
        this.f5303b = guidingLightRenderEffect;
        this.f5304c = f;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        switch (this.f5302a) {
            case 0:
                GuidingLightRenderEffect.setReflLightIntensity$lambda$26(this.f5303b, this.f5304c, (RuntimeShader) obj);
                break;
            case 1:
                GuidingLightRenderEffect.setDitherVariation$lambda$28(this.f5303b, this.f5304c, (RuntimeShader) obj);
                break;
            case 2:
                GuidingLightRenderEffect.setViewAlpha$lambda$4(this.f5303b, this.f5304c, (RuntimeShader) obj);
                break;
            case 3:
                GuidingLightRenderEffect.setGlowSharpness$lambda$24(this.f5303b, this.f5304c, (RuntimeShader) obj);
                break;
            case 4:
                GuidingLightRenderEffect.setCircleRadius$lambda$29(this.f5303b, this.f5304c, (RuntimeShader) obj);
                break;
            case 5:
                GuidingLightRenderEffect.setBoundarySmoothWidth$lambda$37(this.f5303b, this.f5304c, (RuntimeShader) obj);
                break;
            case 6:
                GuidingLightRenderEffect.setOuterSaturation$lambda$9(this.f5303b, this.f5304c, (RuntimeShader) obj);
                break;
            case 7:
                GuidingLightRenderEffect.setReflAlbedo$lambda$27(this.f5303b, this.f5304c, (RuntimeShader) obj);
                break;
            case 8:
                GuidingLightRenderEffect.setGlobalLuminance$lambda$8(this.f5303b, this.f5304c, (RuntimeShader) obj);
                break;
            case 9:
                GuidingLightRenderEffect.setStretch$lambda$5(this.f5303b, this.f5304c, (RuntimeShader) obj);
                break;
            case 10:
                GuidingLightRenderEffect.setProgress$lambda$3(this.f5303b, this.f5304c, (RuntimeShader) obj);
                break;
            case 11:
                GuidingLightRenderEffect.setViewCornerRadius$lambda$13(this.f5303b, this.f5304c, (RuntimeShader) obj);
                break;
            case 12:
                GuidingLightRenderEffect.setReflLightRadius$lambda$25(this.f5303b, this.f5304c, (RuntimeShader) obj);
                break;
            case 13:
                GuidingLightRenderEffect.setOutlineThickness$lambda$36(this.f5303b, this.f5304c, (RuntimeShader) obj);
                break;
            case 14:
                GuidingLightRenderEffect.setLightIntensity$lambda$20(this.f5303b, this.f5304c, (RuntimeShader) obj);
                break;
            case 15:
                GuidingLightRenderEffect.setGlowIntensity$lambda$22(this.f5303b, this.f5304c, (RuntimeShader) obj);
                break;
            case 16:
                GuidingLightRenderEffect.setGlowRadius$lambda$23(this.f5303b, this.f5304c, (RuntimeShader) obj);
                break;
            case 17:
                GuidingLightRenderEffect.setLightRadius$lambda$19(this.f5303b, this.f5304c, (RuntimeShader) obj);
                break;
            case 18:
                GuidingLightRenderEffect.setStretchDirLit$lambda$6(this.f5303b, this.f5304c, (RuntimeShader) obj);
                break;
            default:
                GuidingLightRenderEffect.setSaturation$lambda$7(this.f5303b, this.f5304c, (RuntimeShader) obj);
                break;
        }
    }
}
