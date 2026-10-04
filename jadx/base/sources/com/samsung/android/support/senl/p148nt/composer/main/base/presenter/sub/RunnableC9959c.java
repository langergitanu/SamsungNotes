package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.sub;

import com.samsung.android.support.senl.p148nt.model.repository.data.NotesDocument;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.presenter.sub.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class RunnableC9959c implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f7073a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ ServiceContractImpl f7074b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ NotesDocument f7075c;

    public /* synthetic */ RunnableC9959c(ServiceContractImpl serviceContractImpl, NotesDocument notesDocument, int i) {
        this.f7073a = i;
        this.f7074b = serviceContractImpl;
        this.f7075c = notesDocument;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f7073a) {
            case 0:
                this.f7074b.lambda$onReloadedDocument$5(this.f7075c);
                break;
            default:
                this.f7074b.lambda$changeNote$2(this.f7075c);
                break;
        }
    }
}
