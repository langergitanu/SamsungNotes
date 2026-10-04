package com.samsung.android.sesl.visualeffect.lighteffects.guidinglight;

import android.graphics.Bitmap;
import android.graphics.RuntimeShader;
import java.util.function.Consumer;

/* JADX INFO: renamed from: com.samsung.android.sesl.visualeffect.lighteffects.guidinglight.n */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class C7862n implements Consumer {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f5311a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Bitmap f5312b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ GuidingLightRenderEffect f5313c;

    public /* synthetic */ C7862n(Bitmap bitmap, GuidingLightRenderEffect guidingLightRenderEffect, int i) {
        this.f5311a = i;
        this.f5312b = bitmap;
        this.f5313c = guidingLightRenderEffect;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        switch (this.f5311a) {
            case 0:
                GuidingLightRenderEffect.setTintTexture$lambda$31(this.f5313c, this.f5312b, (RuntimeShader) obj);
                break;
            case 1:
                GuidingLightRenderEffect.setLightmap$lambda$15(this.f5312b, this.f5313c, (RuntimeShader) obj);
                break;
            default:
                GuidingLightRenderEffect.setLightmapGlow$lambda$17(this.f5312b, this.f5313c, (RuntimeShader) obj);
                break;
        }
    }

    public /* synthetic */ C7862n(GuidingLightRenderEffect guidingLightRenderEffect, Bitmap bitmap) {
        this.f5311a = 0;
        this.f5313c = guidingLightRenderEffect;
        this.f5312b = bitmap;
    }
}
