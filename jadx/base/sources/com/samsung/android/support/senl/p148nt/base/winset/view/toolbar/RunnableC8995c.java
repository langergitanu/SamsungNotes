package com.samsung.android.support.senl.p148nt.base.winset.view.toolbar;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.base.winset.view.toolbar.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class RunnableC8995c implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f6519a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ CustomToolbar f6520b;

    public /* synthetic */ RunnableC8995c(CustomToolbar customToolbar, int i) {
        this.f6519a = i;
        this.f6520b = customToolbar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f6519a) {
            case 0:
                this.f6520b.updateToolbarLayout();
                break;
            case 1:
                CustomToolbar.mRunnableOverflowMenuClickListener$lambda$0(this.f6520b);
                break;
            case 2:
                this.f6520b.showAnimate(null);
                break;
            case 3:
                CustomToolbar.setPopupNoteVisibility$lambda$6(this.f6520b);
                break;
            default:
                this.f6520b.hideAnimate(null);
                break;
        }
    }
}
