package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.sub;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.presenter.sub.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class RunnableC9958b implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f7070a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ ServiceContractImpl f7071b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Runnable f7072c;

    public /* synthetic */ RunnableC9958b(ServiceContractImpl serviceContractImpl, Runnable runnable, int i) {
        this.f7070a = i;
        this.f7071b = serviceContractImpl;
        this.f7072c = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f7070a) {
            case 0:
                this.f7071b.lambda$readyReload$4(this.f7072c);
                break;
            default:
                this.f7071b.lambda$onReadyReload$3(this.f7072c);
                break;
        }
    }
}
