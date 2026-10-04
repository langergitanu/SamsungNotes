package com.samsung.android.sdk.pen.engine.drawLoop;

import android.view.View;

/* JADX INFO: renamed from: com.samsung.android.sdk.pen.engine.drawLoop.d */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class RunnableC7450d implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f4963a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ View f4964b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ SpenDrawLoopTexture f4965c;

    public /* synthetic */ RunnableC7450d(View view, SpenDrawLoopTexture spenDrawLoopTexture, int i) {
        this.f4963a = i;
        this.f4964b = view;
        this.f4965c = spenDrawLoopTexture;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4963a) {
            case 0:
                SpenDrawLoopTexture.setCaptureCurrentViewBmp$lambda$6$lambda$4(this.f4964b, this.f4965c);
                break;
            default:
                SpenDrawLoopTexture.setCurrentViewColor$lambda$3$lambda$1(this.f4964b, this.f4965c);
                break;
        }
    }
}
