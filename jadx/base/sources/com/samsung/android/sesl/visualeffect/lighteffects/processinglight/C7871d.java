package com.samsung.android.sesl.visualeffect.lighteffects.processinglight;

import android.graphics.Bitmap;
import android.graphics.RuntimeShader;
import java.util.function.Consumer;

/* JADX INFO: renamed from: com.samsung.android.sesl.visualeffect.lighteffects.processinglight.d */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class C7871d implements Consumer {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f5337a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ ProcessingLightRenderEffect f5338b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Bitmap f5339c;

    public /* synthetic */ C7871d(ProcessingLightRenderEffect processingLightRenderEffect, Bitmap bitmap, int i) {
        this.f5337a = i;
        this.f5338b = processingLightRenderEffect;
        this.f5339c = bitmap;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        switch (this.f5337a) {
            case 0:
                ProcessingLightRenderEffect.setLightMap$lambda$8(this.f5338b, this.f5339c, (RuntimeShader) obj);
                break;
            default:
                ProcessingLightRenderEffect.setTintTexture$lambda$4(this.f5338b, this.f5339c, (RuntimeShader) obj);
                break;
        }
    }
}
