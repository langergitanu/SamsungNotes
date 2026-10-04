package com.samsung.android.sesl.visualeffect.lighteffects.transitionlight;

import android.graphics.RuntimeShader;
import java.util.function.Consumer;

/* JADX INFO: renamed from: com.samsung.android.sesl.visualeffect.lighteffects.transitionlight.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class C7885b implements Consumer {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f5379a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ TransitionLightRenderEffect f5380b;

    public /* synthetic */ C7885b(TransitionLightRenderEffect transitionLightRenderEffect, int i) {
        this.f5379a = i;
        this.f5380b = transitionLightRenderEffect;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        switch (this.f5379a) {
            case 0:
                TransitionLightRenderEffect.setBitmap$lambda$5(this.f5380b, (RuntimeShader) obj);
                break;
            default:
                TransitionLightRenderEffect.setTransMap$lambda$13(this.f5380b, (RuntimeShader) obj);
                break;
        }
    }
}
