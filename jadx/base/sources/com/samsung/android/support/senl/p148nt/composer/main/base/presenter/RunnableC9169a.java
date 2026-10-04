package com.samsung.android.support.senl.p148nt.composer.main.base.presenter;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.presenter.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class RunnableC9169a implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f6775a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ BaseComposerPresenter f6776b;

    public /* synthetic */ RunnableC9169a(BaseComposerPresenter baseComposerPresenter, int i) {
        this.f6775a = i;
        this.f6776b = baseComposerPresenter;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f6775a) {
            case 0:
                this.f6776b.lambda$doActivityResultWithPending$3();
                break;
            case 1:
                this.f6776b.lambda$onPostInitFinished$2();
                break;
            case 2:
                this.f6776b.lambda$onActivityResult$4();
                break;
            default:
                this.f6776b.lambda$onActivityResult$5();
                break;
        }
    }
}
