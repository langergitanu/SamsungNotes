package com.samsung.android.sesl.visualeffect.lighteffects.processinglight;

import android.graphics.RuntimeShader;
import java.util.function.Consumer;

/* JADX INFO: renamed from: com.samsung.android.sesl.visualeffect.lighteffects.processinglight.e */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class C7872e implements Consumer {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f5340a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ int f5341b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ ProcessingLightRenderEffect f5342c;

    public /* synthetic */ C7872e(int i, ProcessingLightRenderEffect processingLightRenderEffect, int i2) {
        this.f5340a = i2;
        this.f5341b = i;
        this.f5342c = processingLightRenderEffect;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        switch (this.f5340a) {
            case 0:
                ProcessingLightRenderEffect.setLightColor$lambda$9(this.f5341b, this.f5342c, (RuntimeShader) obj);
                break;
            default:
                ProcessingLightRenderEffect.setDomainColor$lambda$17(this.f5341b, this.f5342c, (RuntimeShader) obj);
                break;
        }
    }
}
