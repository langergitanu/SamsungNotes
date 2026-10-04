package com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class RunnableC8670b implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f6276a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ PickEditSearchMode f6277b;

    public /* synthetic */ RunnableC8670b(PickEditSearchMode pickEditSearchMode, int i) {
        this.f6276a = i;
        this.f6277b = pickEditSearchMode;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f6276a) {
            case 0:
                this.f6277b.lambda$exitSearchRecyclerView$1();
                break;
            default:
                this.f6277b.lambda$exitSearchRecyclerView$0();
                break;
        }
    }
}
