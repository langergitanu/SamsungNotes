package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.docking;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.quicktool.docking.e */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class RunnableC10783e implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f7253a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ SettingQTPenListDockingLayout f7254b;

    public /* synthetic */ RunnableC10783e(SettingQTPenListDockingLayout settingQTPenListDockingLayout, int i) {
        this.f7253a = i;
        this.f7254b = settingQTPenListDockingLayout;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f7253a) {
            case 0:
                this.f7254b.updatePenPosition();
                break;
            default:
                SettingQTPenListDockingLayout.access$updatePenPosition(this.f7254b);
                break;
        }
    }
}
