package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.M */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class RunnableC9692M implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f6931a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ CreateImageResultViewManager f6932b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ String f6933c;

    public /* synthetic */ RunnableC9692M(CreateImageResultViewManager createImageResultViewManager, String str, int i) {
        this.f6931a = i;
        this.f6932b = createImageResultViewManager;
        this.f6933c = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f6931a) {
            case 0:
                this.f6932b.lambda$requestRelease$1(this.f6933c);
                break;
            default:
                this.f6932b.lambda$onFailed$3(this.f6933c);
                break;
        }
    }
}
