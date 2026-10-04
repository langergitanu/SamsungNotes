package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.title;

import androidx.appcompat.app.AlertDialog;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.view.menu.title.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class RunnableC10497b implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f7212a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ FolderViewManager f7213b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ AlertDialog f7214c;

    public /* synthetic */ RunnableC10497b(FolderViewManager folderViewManager, AlertDialog alertDialog, int i) {
        this.f7212a = i;
        this.f7213b = folderViewManager;
        this.f7214c = alertDialog;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f7212a) {
            case 0:
                this.f7213b.lambda$init$0(this.f7214c);
                break;
            default:
                this.f7213b.lambda$init$1(this.f7214c);
                break;
        }
    }
}
