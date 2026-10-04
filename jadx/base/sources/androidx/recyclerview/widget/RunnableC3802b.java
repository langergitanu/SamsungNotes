package androidx.recyclerview.widget;

/* JADX INFO: renamed from: androidx.recyclerview.widget.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class RunnableC3802b implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f1657a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f1658b;

    public /* synthetic */ RunnableC3802b(Object obj, int i) {
        this.f1657a = i;
        this.f1658b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1657a) {
            case 0:
                ((SeslRecyclerViewFastScroller) this.f1658b).lambda$new$0();
                break;
            default:
                ((RecyclerView) this.f1658b).invalidate();
                break;
        }
    }
}
