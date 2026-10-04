package androidx.core.widget;

/* JADX INFO: renamed from: androidx.core.widget.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class RunnableC2501a implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f1362a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ ContentLoadingProgressBar f1363b;

    public /* synthetic */ RunnableC2501a(ContentLoadingProgressBar contentLoadingProgressBar, int i) {
        this.f1362a = i;
        this.f1363b = contentLoadingProgressBar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1362a) {
            case 0:
                this.f1363b.lambda$new$0();
                break;
            case 1:
                this.f1363b.lambda$new$1();
                break;
            case 2:
                this.f1363b.showOnUiThread();
                break;
            default:
                this.f1363b.hideOnUiThread();
                break;
        }
    }
}
