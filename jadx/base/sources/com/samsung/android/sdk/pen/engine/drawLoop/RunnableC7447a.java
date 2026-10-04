package com.samsung.android.sdk.pen.engine.drawLoop;

/* JADX INFO: renamed from: com.samsung.android.sdk.pen.engine.drawLoop.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class RunnableC7447a implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f4958a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ SpenDrawLoopAGLL f4959b;

    public /* synthetic */ RunnableC7447a(SpenDrawLoopAGLL spenDrawLoopAGLL, int i) {
        this.f4958a = i;
        this.f4959b = spenDrawLoopAGLL;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4958a) {
            case 0:
                SpenDrawLoopAGLL.doFrame$lambda$4(this.f4959b);
                break;
            case 1:
                SpenDrawLoopAGLL.postDestroyRendererAdapter$lambda$1(this.f4959b);
                break;
            default:
                SpenDrawLoopAGLL.surfaceChanged$lambda$3(this.f4959b);
                break;
        }
    }
}
