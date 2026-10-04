package com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class RunnableC8405a implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f6182a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ AdapterManager f6183b;

    public /* synthetic */ RunnableC8405a(AdapterManager adapterManager, int i) {
        this.f6182a = i;
        this.f6183b = adapterManager;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f6182a) {
            case 0:
                this.f6183b.lambda$updateDataChangeFromToggleFolderExpandState$0();
                break;
            case 1:
                this.f6183b.lambda$removeTipCard$5();
                break;
            case 2:
                this.f6183b.lambda$showTipCard$4();
                break;
            default:
                this.f6183b.lambda$runDeleteConvertedNotesTask$3();
                break;
        }
    }
}
