package com.samsung.android.vexfwk.sdk.imageeffect;

import com.samsung.android.vexfwk.sdk.common.VexFwkSdkBase;
import com.samsung.android.vexfwk.sdk.imageeffect.VexFwkImageEffectProcessor;
import com.samsung.android.vexfwk.sdk.objeraser.VexFwkImageObjectRemover;
import com.samsung.android.vexfwk.sdk.objeraser.VexFwkVideoObjectRemover;
import java.util.function.Supplier;

/* JADX INFO: renamed from: com.samsung.android.vexfwk.sdk.imageeffect.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class C11579a implements Supplier {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f8095a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ boolean f8096b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Object f8097c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ Object f8098d;

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ Object f8099e;

    /* JADX INFO: renamed from: f */
    public final /* synthetic */ Object f8100f;

    public /* synthetic */ C11579a(Object obj, VexFwkImageEffectProcessor.SegMask segMask, VexFwkImageEffectProcessor vexFwkImageEffectProcessor, VexFwkImageEffectProcessor.ImageEffect imageEffect, boolean z) {
        this.f8095a = 0;
        this.f8097c = obj;
        this.f8098d = segMask;
        this.f8099e = vexFwkImageEffectProcessor;
        this.f8100f = imageEffect;
        this.f8096b = z;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.f8095a) {
            case 0:
                return VexFwkImageEffectProcessor.applyEffectImpl$lambda$6(this.f8097c, (VexFwkImageEffectProcessor.SegMask) this.f8098d, (VexFwkImageEffectProcessor) this.f8099e, (VexFwkImageEffectProcessor.ImageEffect) this.f8100f, this.f8096b);
            case 1:
                return VexFwkImageObjectRemover.removeObject$lambda$6(this.f8096b, (VexFwkImageObjectRemover.ObjectMask) this.f8097c, (String) this.f8098d, (String) this.f8099e, (VexFwkImageObjectRemover) this.f8100f);
            default:
                return VexFwkVideoObjectRemover.removeObject$lambda$6(this.f8096b, (VexFwkVideoObjectRemover.ObjectMask) this.f8097c, (String) this.f8098d, (String) this.f8099e, (VexFwkVideoObjectRemover) this.f8100f);
        }
    }

    public /* synthetic */ C11579a(boolean z, Object obj, String str, String str2, VexFwkSdkBase vexFwkSdkBase, int i) {
        this.f8095a = i;
        this.f8096b = z;
        this.f8097c = obj;
        this.f8098d = str;
        this.f8099e = str2;
        this.f8100f = vexFwkSdkBase;
    }
}
