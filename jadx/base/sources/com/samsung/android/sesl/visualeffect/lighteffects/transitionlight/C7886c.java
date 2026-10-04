package com.samsung.android.sesl.visualeffect.lighteffects.transitionlight;

import android.graphics.Bitmap;
import android.graphics.RuntimeShader;
import java.util.function.Consumer;

/* JADX INFO: renamed from: com.samsung.android.sesl.visualeffect.lighteffects.transitionlight.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class C7886c implements Consumer {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f5381a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ TransitionLightRenderEffect f5382b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Bitmap f5383c;

    public /* synthetic */ C7886c(TransitionLightRenderEffect transitionLightRenderEffect, Bitmap bitmap, int i) {
        this.f5381a = i;
        this.f5382b = transitionLightRenderEffect;
        this.f5383c = bitmap;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        switch (this.f5381a) {
            case 0:
                TransitionLightRenderEffect.setBitmap$lambda$6(this.f5382b, this.f5383c, (RuntimeShader) obj);
                break;
            case 1:
                TransitionLightRenderEffect.setTintTexture$lambda$10(this.f5382b, this.f5383c, (RuntimeShader) obj);
                break;
            default:
                TransitionLightRenderEffect.setTransMap$lambda$14(this.f5382b, this.f5383c, (RuntimeShader) obj);
                break;
        }
    }
}
