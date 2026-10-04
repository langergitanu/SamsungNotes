package com.samsung.android.sesl.visualeffect.lighteffects.guidinglight;

import android.graphics.PointF;
import android.graphics.RuntimeShader;
import java.util.function.Consumer;

/* JADX INFO: renamed from: com.samsung.android.sesl.visualeffect.lighteffects.guidinglight.m */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class C7861m implements Consumer {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f5308a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ GuidingLightRenderEffect f5309b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ PointF f5310c;

    public /* synthetic */ C7861m(GuidingLightRenderEffect guidingLightRenderEffect, PointF pointF, int i) {
        this.f5308a = i;
        this.f5309b = guidingLightRenderEffect;
        this.f5310c = pointF;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        switch (this.f5308a) {
            case 0:
                GuidingLightRenderEffect.setRoundRectDirection$lambda$12(this.f5309b, this.f5310c, (RuntimeShader) obj);
                break;
            case 1:
                GuidingLightRenderEffect.setLightPos$lambda$18(this.f5309b, this.f5310c, (RuntimeShader) obj);
                break;
            default:
                GuidingLightRenderEffect.setViewCenter$lambda$10(this.f5309b, this.f5310c, (RuntimeShader) obj);
                break;
        }
    }
}
