package com.samsung.android.support.senl.p148nt.app.common.widget;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.app.common.widget.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class RunnableC8043a implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f6095a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ FolderPathLayout f6096b;

    public /* synthetic */ RunnableC8043a(FolderPathLayout folderPathLayout, int i) {
        this.f6095a = i;
        this.f6096b = folderPathLayout;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f6095a) {
            case 0:
                this.f6096b.lambda$updateCurrentPath$0();
                break;
            default:
                this.f6096b.lambda$resetFolderPath$1();
                break;
        }
    }
}
