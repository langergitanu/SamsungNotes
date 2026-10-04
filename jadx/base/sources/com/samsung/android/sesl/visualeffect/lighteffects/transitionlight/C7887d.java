package com.samsung.android.sesl.visualeffect.lighteffects.transitionlight;

import android.graphics.RuntimeShader;
import java.util.function.Consumer;

/* JADX INFO: renamed from: com.samsung.android.sesl.visualeffect.lighteffects.transitionlight.d */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class C7887d implements Consumer {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f5384a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ TransitionLightRenderEffect f5385b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ float f5386c;

    public /* synthetic */ C7887d(TransitionLightRenderEffect transitionLightRenderEffect, float f, int i) {
        this.f5384a = i;
        this.f5385b = transitionLightRenderEffect;
        this.f5386c = f;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        switch (this.f5384a) {
            case 0:
                TransitionLightRenderEffect.setTransScale$lambda$16(this.f5385b, this.f5386c, (RuntimeShader) obj);
                break;
            case 1:
                TransitionLightRenderEffect.setTintIntensity$lambda$7(this.f5385b, this.f5386c, (RuntimeShader) obj);
                break;
            case 2:
                TransitionLightRenderEffect.setProgress$lambda$1(this.f5385b, this.f5386c, (RuntimeShader) obj);
                break;
            case 3:
                TransitionLightRenderEffect.setTintSaturation$lambda$8(this.f5385b, this.f5386c, (RuntimeShader) obj);
                break;
            case 4:
                TransitionLightRenderEffect.setTransAlpha$lambda$17(this.f5385b, this.f5386c, (RuntimeShader) obj);
                break;
            default:
                TransitionLightRenderEffect.setStretch$lambda$18(this.f5385b, this.f5386c, (RuntimeShader) obj);
                break;
        }
    }
}
