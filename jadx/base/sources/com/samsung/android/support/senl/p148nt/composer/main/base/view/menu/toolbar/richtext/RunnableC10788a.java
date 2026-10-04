package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.richtext.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class RunnableC10788a implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f7255a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ RtToolbarMenu f7256b;

    public /* synthetic */ RunnableC10788a(RtToolbarMenu rtToolbarMenu, int i) {
        this.f7255a = i;
        this.f7256b = rtToolbarMenu;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f7255a) {
            case 0:
                this.f7256b.hide();
                break;
            case 1:
                this.f7256b.show();
                break;
            default:
                this.f7256b.lambda$show$2();
                break;
        }
    }
}
