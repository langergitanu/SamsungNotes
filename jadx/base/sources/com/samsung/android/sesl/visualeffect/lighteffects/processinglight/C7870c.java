package com.samsung.android.sesl.visualeffect.lighteffects.processinglight;

import android.graphics.RuntimeShader;
import java.util.function.Consumer;

/* JADX INFO: renamed from: com.samsung.android.sesl.visualeffect.lighteffects.processinglight.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class C7870c implements Consumer {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f5334a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ ProcessingLightRenderEffect f5335b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ float f5336c;

    public /* synthetic */ C7870c(ProcessingLightRenderEffect processingLightRenderEffect, float f, int i) {
        this.f5334a = i;
        this.f5335b = processingLightRenderEffect;
        this.f5336c = f;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        switch (this.f5334a) {
            case 0:
                ProcessingLightRenderEffect.setLightRotation$lambda$10(this.f5335b, this.f5336c, (RuntimeShader) obj);
                break;
            case 1:
                ProcessingLightRenderEffect.setDomainStrength$lambda$19(this.f5335b, this.f5336c, (RuntimeShader) obj);
                break;
            case 2:
                ProcessingLightRenderEffect.setDitherVariation$lambda$20(this.f5335b, this.f5336c, (RuntimeShader) obj);
                break;
            case 3:
                ProcessingLightRenderEffect.setLightScale$lambda$13(this.f5335b, this.f5336c, (RuntimeShader) obj);
                break;
            case 4:
                ProcessingLightRenderEffect.setLightSaturation$lambda$16(this.f5335b, this.f5336c, (RuntimeShader) obj);
                break;
            case 5:
                ProcessingLightRenderEffect.setStretch$lambda$14(this.f5335b, this.f5336c, (RuntimeShader) obj);
                break;
            case 6:
                ProcessingLightRenderEffect.setDomainDeltaRatio$lambda$18(this.f5335b, this.f5336c, (RuntimeShader) obj);
                break;
            default:
                ProcessingLightRenderEffect.setLightIntensity$lambda$15(this.f5335b, this.f5336c, (RuntimeShader) obj);
                break;
        }
    }
}
