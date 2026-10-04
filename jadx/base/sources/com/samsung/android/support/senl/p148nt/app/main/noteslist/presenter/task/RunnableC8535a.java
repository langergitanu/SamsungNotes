package com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.task;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.task.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class RunnableC8535a implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f6241a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ ShareDialogTask f6242b;

    public /* synthetic */ RunnableC8535a(ShareDialogTask shareDialogTask, int i) {
        this.f6241a = i;
        this.f6242b = shareDialogTask;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f6241a) {
            case 0:
                ShareDialogTask.executeExportTask$lambda$2(this.f6242b);
                break;
            case 1:
                ShareDialogTask.showWordExportOptionPopup$lambda$0(this.f6242b);
                break;
            default:
                ShareDialogTask.showPdfExportOptionPopup$lambda$1(this.f6242b);
                break;
        }
    }
}
