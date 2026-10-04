package com.samsung.android.sesl.visualeffect.lighteffects.common.runtimshader;

import android.view.View;
import java.util.function.Consumer;

/* JADX INFO: renamed from: com.samsung.android.sesl.visualeffect.lighteffects.common.runtimshader.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class C7847b implements Consumer {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f5269a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ VibeRenderEffectBase f5270b;

    public /* synthetic */ C7847b(VibeRenderEffectBase vibeRenderEffectBase, int i) {
        this.f5269a = i;
        this.f5270b = vibeRenderEffectBase;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        switch (this.f5269a) {
            case 0:
                VibeRenderEffectBase.destroy$lambda$6(this.f5270b, (View) obj);
                break;
            default:
                VibeRenderEffectBase.update$lambda$9(this.f5270b, (View) obj);
                break;
        }
    }
}
