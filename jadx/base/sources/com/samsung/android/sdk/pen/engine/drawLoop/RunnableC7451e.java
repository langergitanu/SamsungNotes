package com.samsung.android.sdk.pen.engine.drawLoop;

/* JADX INFO: renamed from: com.samsung.android.sdk.pen.engine.drawLoop.e */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class RunnableC7451e implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f4966a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ SpenDrawLoopTexture f4967b;

    public /* synthetic */ RunnableC7451e(SpenDrawLoopTexture spenDrawLoopTexture, int i) {
        this.f4966a = i;
        this.f4967b = spenDrawLoopTexture;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4966a) {
            case 0:
                SpenDrawLoopTexture.setCaptureCurrentViewBmp$lambda$6$lambda$5(this.f4967b);
                break;
            case 1:
                SpenDrawLoopTexture.doFrame$lambda$9(this.f4967b);
                break;
            default:
                SpenDrawLoopTexture.setCurrentViewColor$lambda$3$lambda$2(this.f4967b);
                break;
        }
    }
}
