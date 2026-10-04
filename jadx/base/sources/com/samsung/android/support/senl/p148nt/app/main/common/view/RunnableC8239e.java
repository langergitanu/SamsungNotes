package com.samsung.android.support.senl.p148nt.app.main.common.view;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.app.main.common.view.e */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class RunnableC8239e implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f6167a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ NotesPenRecyclerView f6168b;

    public /* synthetic */ RunnableC8239e(NotesPenRecyclerView notesPenRecyclerView, int i) {
        this.f6167a = i;
        this.f6168b = notesPenRecyclerView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f6167a) {
            case 0:
                this.f6168b.lambda$dispatchKeyEvent$0();
                break;
            default:
                this.f6168b.lambda$scrollToTop$1();
                break;
        }
    }
}
