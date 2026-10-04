package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.sub;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.presenter.sub.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class RunnableC9957a implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f7067a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Initializer f7068b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ String f7069c;

    public /* synthetic */ RunnableC9957a(Initializer initializer, String str, int i) {
        this.f7067a = i;
        this.f7068b = initializer;
        this.f7069c = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f7067a) {
            case 0:
                this.f7068b.lambda$handleWidgetAction$1(this.f7069c);
                break;
            default:
                this.f7068b.lambda$blockSipToShow$2(this.f7069c);
                break;
        }
    }
}
