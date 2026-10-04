package com.samsung.android.sdk.pen.setting.colorpicker;

import android.view.ViewTreeObserver;
import com.samsung.android.sesl.visualeffect.lighteffects.common.runtimshader.VibeRenderEffectBase;

/* JADX INFO: renamed from: com.samsung.android.sdk.pen.setting.colorpicker.d */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class ViewTreeObserverOnGlobalLayoutListenerC7542d implements ViewTreeObserver.OnGlobalLayoutListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f5021a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f5022b;

    public /* synthetic */ ViewTreeObserverOnGlobalLayoutListenerC7542d(Object obj, int i) {
        this.f5021a = i;
        this.f5022b = obj;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        switch (this.f5021a) {
            case 0:
                SpenColorSwatchView.initSwatchViewOutline$lambda$4((SpenColorSwatchView) this.f5022b);
                break;
            case 1:
                SpenColorSwatchView.needUpdate$lambda$3((SpenColorSwatchView) this.f5022b);
                break;
            default:
                VibeRenderEffectBase.invalidationListener$lambda$0((VibeRenderEffectBase) this.f5022b);
                break;
        }
    }
}
