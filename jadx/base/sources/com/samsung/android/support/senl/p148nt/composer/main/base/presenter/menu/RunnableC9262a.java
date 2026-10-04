package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class RunnableC9262a implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f6795a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ MenuPresenterManager f6796b;

    public /* synthetic */ RunnableC9262a(MenuPresenterManager menuPresenterManager, int i) {
        this.f6795a = i;
        this.f6796b = menuPresenterManager;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f6795a) {
            case 0:
                this.f6796b.lambda$executeSyncConflictInvalidVersionType$1();
                break;
            case 1:
                this.f6796b.lambda$executeSyncConflictInvalidVersionType$2();
                break;
            default:
                this.f6796b.lambda$executeSyncConflictInvalidVersionType$3();
                break;
        }
    }
}
