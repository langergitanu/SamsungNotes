package androidx.appcompat.widget;

/* JADX INFO: renamed from: androidx.appcompat.widget.h */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class RunnableC0547h implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f952a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Toolbar f953b;

    public /* synthetic */ RunnableC0547h(Toolbar toolbar, int i) {
        this.f952a = i;
        this.f953b = toolbar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f952a) {
            case 0:
                this.f953b.collapseActionView();
                break;
            default:
                this.f953b.invalidateMenu();
                break;
        }
    }
}
