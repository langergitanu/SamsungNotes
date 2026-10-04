package com.samsung.android.sesl.visualeffect.lighteffects.radialgrad;

import android.graphics.RuntimeShader;
import java.util.function.Consumer;

/* JADX INFO: renamed from: com.samsung.android.sesl.visualeffect.lighteffects.radialgrad.e */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class C7877e implements Consumer {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f5354a = 0;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ RadialGradRenderEffect f5355b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ int f5356c;

    public /* synthetic */ C7877e(int i, RadialGradRenderEffect radialGradRenderEffect) {
        this.f5356c = i;
        this.f5355b = radialGradRenderEffect;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        switch (this.f5354a) {
            case 0:
                RadialGradRenderEffect.setBackgroundColor$lambda$6(this.f5356c, this.f5355b, (RuntimeShader) obj);
                break;
            default:
                RadialGradRenderEffect.setSpotCount$lambda$7(this.f5355b, this.f5356c, (RuntimeShader) obj);
                break;
        }
    }

    public /* synthetic */ C7877e(RadialGradRenderEffect radialGradRenderEffect, int i) {
        this.f5355b = radialGradRenderEffect;
        this.f5356c = i;
    }
}
