package com.samsung.android.sesl.visualeffect.surfaceeffects.turbulencenoise;

/* JADX INFO: renamed from: com.samsung.android.sesl.visualeffect.surfaceeffects.turbulencenoise.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class RunnableC7895b implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f5388a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ TurbulenceNoiseController f5389b;

    public /* synthetic */ RunnableC7895b(TurbulenceNoiseController turbulenceNoiseController, int i) {
        this.f5388a = i;
        this.f5389b = turbulenceNoiseController;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f5388a) {
            case 0:
                TurbulenceNoiseController.playEaseOutAnimation$lambda$0(this.f5389b);
                break;
            case 1:
                this.f5389b.playEaseOutAnimation();
                break;
            default:
                this.f5389b.playMainAnimation();
                break;
        }
    }
}
