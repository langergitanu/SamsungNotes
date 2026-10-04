package com.samsung.android.sdk.pen.setting.drawing;

import com.samsung.android.sdk.pen.setting.drawing.SpenBrushPenTypeLayout;

/* JADX INFO: renamed from: com.samsung.android.sdk.pen.setting.drawing.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class RunnableC7571a implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f5047a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ SpenBrushPenTypeLayout f5048b;

    public /* synthetic */ RunnableC7571a(SpenBrushPenTypeLayout spenBrushPenTypeLayout, int i) {
        this.f5047a = i;
        this.f5048b = spenBrushPenTypeLayout;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f5047a) {
            case 0:
                SpenBrushPenTypeLayout.setUnselectedPen$lambda$1(this.f5048b);
                break;
            default:
                SpenBrushPenTypeLayout.AnimationAnimationListenerC75681.onAnimationEnd$lambda$0(this.f5048b);
                break;
        }
    }
}
