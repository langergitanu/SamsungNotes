package androidx.appcompat.widget;

/* JADX INFO: renamed from: androidx.appcompat.widget.n */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class RunnableC0553n implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f960a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f961b;

    public /* synthetic */ RunnableC0553n(Object obj, int i) {
        this.f960a = i;
        this.f961b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f960a) {
            case 0:
                ((TooltipCompatHandler) this.f961b).lambda$new$0();
                break;
            case 1:
                ((TooltipCompatHandler) this.f961b).hide();
                break;
            default:
                ((SearchView) this.f961b).lambda$seslSetSviEnabled$1();
                break;
        }
    }
}
