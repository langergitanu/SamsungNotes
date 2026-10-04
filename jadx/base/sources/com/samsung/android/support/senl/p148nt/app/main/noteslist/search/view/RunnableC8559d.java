package com.samsung.android.support.senl.p148nt.app.main.noteslist.search.view;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.app.main.noteslist.search.view.d */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class RunnableC8559d implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f6251a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ NotesSearchView f6252b;

    public /* synthetic */ RunnableC8559d(NotesSearchView notesSearchView, int i) {
        this.f6251a = i;
        this.f6252b = notesSearchView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f6251a) {
            case 0:
                this.f6252b.lambda$clearShader$4();
                break;
            default:
                this.f6252b.lambda$applyShader$3();
                break;
        }
    }
}
