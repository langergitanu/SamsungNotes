package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class RunnableC9222a implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f6780a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ SpenConvertToTextListenerImpl f6781b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ boolean f6782c;

    public /* synthetic */ RunnableC9222a(SpenConvertToTextListenerImpl spenConvertToTextListenerImpl, boolean z, int i) {
        this.f6780a = i;
        this.f6781b = spenConvertToTextListenerImpl;
        this.f6782c = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f6780a) {
            case 0:
                this.f6781b.lambda$onConvertToTextFailed$0(this.f6782c);
                break;
            default:
                this.f6781b.lambda$updateConvertToTextRunning$1(this.f6782c);
                break;
        }
    }
}
