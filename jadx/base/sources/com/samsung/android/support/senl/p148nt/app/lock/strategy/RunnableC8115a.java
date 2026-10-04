package com.samsung.android.support.senl.p148nt.app.lock.strategy;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.app.lock.strategy.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class RunnableC8115a implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f6120a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ UnlockStrategy f6121b;

    public /* synthetic */ RunnableC8115a(UnlockStrategy unlockStrategy, int i) {
        this.f6120a = i;
        this.f6121b = unlockStrategy;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f6120a) {
            case 0:
                UnlockStrategy.onActivityResult$lambda$1(this.f6121b);
                break;
            default:
                UnlockStrategy.unlockWithGUID$lambda$0(this.f6121b);
                break;
        }
    }
}
