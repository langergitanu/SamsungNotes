package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.quicktool.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class RunnableC10739b implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f7230a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ QuickToolContainer f7231b;

    public /* synthetic */ RunnableC10739b(QuickToolContainer quickToolContainer, int i) {
        this.f7230a = i;
        this.f7231b = quickToolContainer;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f7230a) {
            case 0:
                QuickToolContainer._init_$lambda$0(this.f7231b);
                break;
            case 1:
                QuickToolContainer.restoreDocking$lambda$4(this.f7231b);
                break;
            default:
                QuickToolContainer.restoreDocking$lambda$5(this.f7231b);
                break;
        }
    }
}
