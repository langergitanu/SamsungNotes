package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog;

import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.SyncConflictConfirmDialogPresenter;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.presenter.dialog.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class RunnableC9258b implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f6789a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f6790b;

    public /* synthetic */ RunnableC9258b(Object obj, int i) {
        this.f6789a = i;
        this.f6790b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f6789a) {
            case 0:
                ((SyncConflictConfirmDialogPresenter.C92531) this.f6790b).lambda$onReceived$0();
                break;
            default:
                ((SyncConflictConfirmDialogPresenter.RunnableC92542) this.f6790b).lambda$run$1();
                break;
        }
    }
}
