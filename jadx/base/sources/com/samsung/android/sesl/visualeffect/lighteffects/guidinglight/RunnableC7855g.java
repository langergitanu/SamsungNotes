package com.samsung.android.sesl.visualeffect.lighteffects.guidinglight;

/* JADX INFO: renamed from: com.samsung.android.sesl.visualeffect.lighteffects.guidinglight.g */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class RunnableC7855g implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f5292a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ AnimationManager f5293b;

    public /* synthetic */ RunnableC7855g(AnimationManager animationManager, int i) {
        this.f5292a = i;
        this.f5293b = animationManager;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f5292a) {
            case 0:
                AnimationManager.createNowBarAnimation$lambda$14(this.f5293b);
                break;
            default:
                AnimationManager.createSizeAnimation$lambda$3(this.f5293b);
                break;
        }
    }
}
